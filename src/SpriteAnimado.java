import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteAnimado {
    private BufferedImage spritePlayer;
    private RenderHandler renderHandler;
    private Juego juego;

    private int direccion; //1 up, 2 derecha, 3 abajo, 4 izquierda
    private int numeroSprite;

    public SpriteAnimado()
    {


    }

    public void spriteAnimado() throws IOException {



    }

    public BufferedImage loadImage(String camino) throws IOException {
        BufferedImage loadImage = ImageIO.read(Juego.class.getResource(camino));
        BufferedImage  loadImage2 = new BufferedImage(loadImage.getWidth(), loadImage.getHeight(),BufferedImage.TYPE_INT_RGB);
        loadImage2.getGraphics().drawImage(loadImage,0,0,null);

        return loadImage2;

    }

}
