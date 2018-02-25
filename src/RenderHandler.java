import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

public class RenderHandler {

    private BufferedImage view;
    private int[] pixels;
    private Rectangulo camara;

    public RenderHandler(int width, int height)
    {



        // Crea un buffer
        view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        camara = new Rectangulo(0,0,width,height);

        camara.x = -100;
        camara.y= -30;

        pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();

    }

    //Renderiza nuestro array de píxeles en la pantalla
    public void render(Graphics graphics)
    {

        graphics.drawImage(view,0,0,view.getWidth(),view.getHeight(),null);

    }

    // Renderiza la imagen a nuestros píxeles
    // El zoom hace que el píxel sea el doble hacia la izquierda (x) o hacia abajo (y)
    public void renderImagen(BufferedImage image, int xPosicion, int yPosicion, int xZoom, int yZoom)
    {
        int[] imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        for (int y=0; y<image.getHeight();y++)
        { for(int x=0;x<image.getWidth();x++)
            { for(int yZoomPosicion=0; yZoomPosicion<yZoom;yZoomPosicion++)
                {for (int xZoomPosicion = 0; xZoomPosicion < xZoom; xZoomPosicion++)
                    {

                        setPixel(imagePixels[x + y * image.getWidth()], (x*xZoom) + xPosicion+xZoomPosicion,  ((yZoom*y) + yPosicion + yZoomPosicion));
                        //Muy difícil de entender!!! algoritmo sacado de un ingeniero de stackoverflow, el xZoom multiplicando hace que pase varias veces
                        //el color por el mismo píxel!!
                    }
                }
            }
        }
    }

    private void setPixel(int pixel, int x, int y)
    {

        if (x >= camara.x && y >= camara.y && x <= camara.x + camara.w && y <= camara.y + camara.h)
        {
            int pixelIndex = (x - camara.x) + (y - camara.y)* view.getWidth();
            if (pixels.length > pixelIndex) {
                pixels[pixelIndex] = pixel;
            }
        }

    }
}
