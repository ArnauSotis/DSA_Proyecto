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

        pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();

    }

    //Renderiza nuestro array de píxeles en la pantalla
    public void render(Graphics graphics)
    {

        graphics.drawImage(view,0,0,view.getWidth(),view.getHeight(),null);

    }

    // Renderiza la imagen a nuestros píxeles
    // El zoom hace que el píxel sea el doble hacia la izquierda (x) o hacia abajo (y)
    public void renderImagen(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom)
    {
        int[] imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        renderArray(imagePixels, image.getWidth(), image.getHeight(), xPosition, yPosition, xZoom, yZoom);
    }
    public void renderArray(int[] renderPixels, int renderWidth, int renderHeight, int xPosition, int yPosition, int xZoom, int yZoom)
    {
        for(int y = 0; y < renderHeight; y++)
            for(int x = 0; x < renderWidth; x++)
                for(int yZoomPosition = 0; yZoomPosition < yZoom; yZoomPosition++)
                    for(int xZoomPosition = 0; xZoomPosition < xZoom; xZoomPosition++)
                        setPixel(renderPixels[x + y * renderWidth], (x * xZoom) + xPosition + xZoomPosition, ((y * yZoom) + yPosition + yZoomPosition));
    }

    public void renderTerreno(int width, int height, BufferedImage imagen, BufferedImage imagenSprite)
    {
        for(int y=0;y<height;y=y+32)
        {
            for(int x=0;x<width;x=x+32)
            {
                renderImagen(imagen, x, y, 2, 2);

            }
        }
        renderImagen(imagenSprite,200,200,1,1);

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