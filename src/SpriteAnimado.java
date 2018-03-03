import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteAnimado {
    private BufferedImage spriteActual;

    private int direccion; //1 up, 2 derecha, 3 abajo, 4 izquierda
    private int numeroSprite;

    public SpriteAnimado()
    {


    }

    public BufferedImage getSpriteActual() {
        return this.spriteActual;
    }

    public void setSpriteActual(BufferedImage spriteActual)
    {
        this.spriteActual = spriteActual;
    }

}
