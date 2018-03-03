import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Timer;
import java.util.TimerTask;


public class Juego extends JFrame implements Runnable{

    private Canvas canvas = new Canvas();
    private RenderHandler renderer;
    private BufferedImage tierra;
    private BufferedImage spriteArbusto1, spriteArbusto2, spritePlayer1, spritePlayer2, spritePlayer3, spritePlayer4,spritePlayer1ataque, spritePlayer2ataque, spritePlayer3ataque, spritePlayer4ataque;
    private MovimientoTeclado teclado = new MovimientoTeclado();
    private SpriteAnimado spriteAnimado = new SpriteAnimado();
    public BufferedImage spritePrincesa;
    private GestorEscenarios gestorEscenarios = new GestorEscenarios(1);

    public Juego() throws IOException {

        //Al aturar el juego, para de compilar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ventana de (0,0) a (1000,800)
        setBounds(0,0, 1000, 800);

        //Coloca la pantalla en el centro
        setLocationRelativeTo(null);

        //Añade el lienzo
        add(canvas);

        //Lo hace visible
        setVisible(true);


        //Meto un buffer en el canvas para quitar el efecto flicker
        canvas.createBufferStrategy(3);


            cargarFotos();

         spriteAnimado.setSpriteActual(spritePlayer2);


        renderer = new RenderHandler(getWidth(),getHeight());

        canvas.addKeyListener(getKeyListener());




    }

    private BufferedImage loadImage(String camino) throws IOException {
        BufferedImage loadImage = ImageIO.read(Juego.class.getResource(camino));
        BufferedImage  loadImage2 = new BufferedImage(loadImage.getWidth(), loadImage.getHeight(),BufferedImage.TYPE_INT_RGB);
        loadImage2.getGraphics().drawImage(loadImage,0,0,null);

        return loadImage2;

    }


    public void cargarFotos() throws IOException {

        tierra = loadImage("images/GrassTile.png");
        spritePlayer2 = loadImage("images/PlayerDerecha1.png");
        spritePlayer4 = loadImage("images/PlayerIzquierda1.png");
        spritePlayer1 = loadImage("images/PlayerArriba1.png");
        spritePlayer3 = loadImage("images/PlayerAbajo1.png");
        spritePlayer2ataque = loadImage("images/PlayerDerecha1ataque.png");
        spritePlayer4ataque = loadImage("images/PlayerIzquierda1ataque.png");
        spritePlayer1ataque = loadImage("images/PlayerArriba1ataque.png");
        spritePlayer3ataque = loadImage("images/PlayerAbajo1ataque.png");
        spriteAnimado.setSpriteActual(spritePlayer2);
        spritePrincesa = loadImage("images/princesa.png");
        spriteArbusto1 = loadImage("images/arbusto1.png");

    }
    public void run()
    {

        //Arreglo de los frames encontrado en stackoverflow

        long lastTime = System.nanoTime();
        double nanoSecondConversion= 1000000000.0/60;
        double changeInSeconds=0;

        while(true){

            Long now = System.nanoTime();

            changeInSeconds += (now - lastTime)/nanoSecondConversion;


            while (changeInSeconds >=60)
            {
                update();
                changeInSeconds=0;

            }

            try {
                render();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lastTime = now;

        }


    }
    public MovimientoTeclado getKeyListener()
    {
        return teclado;
    }


    public void render() throws IOException {


        if(gestorEscenarios.numeroEscenario==1)
        { terreno1(getWidth(),getHeight());}

    }

    public void update(){}

    public static void main(String[] args) throws IOException {
        Juego juego = new Juego();
        Thread juegoThread = new Thread(juego);
        juegoThread.start();

    }

    public void terreno1(int getWidth, int getHeight){

        BufferStrategy bufferStrategy = canvas.getBufferStrategy();


        Graphics graphics = bufferStrategy.getDrawGraphics();

        paint(graphics);
        // Algoritmo diseñado por mi para rellenar todo el mapa de la Tile
        if(teclado.espada==0) {
            if (teclado.key == 2) {
                renderer.renderEscenario1(getWidth, getHeight, tierra, spritePlayer2, 2, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer2);
            }
            if (teclado.key == 1) {
                renderer.renderEscenario1(getWidth, getHeight, tierra, spritePlayer1, 1, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer1);
            }
            if (teclado.key == 3) {
                renderer.renderEscenario1(getWidth, getHeight,tierra, spritePlayer3, 3, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer3);
            }
            if (teclado.key == 4) {
                renderer.renderEscenario1(getWidth, getHeight, tierra, spritePlayer4, 4, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer4);
            }
            if(teclado.key==0){
                renderer.renderEscenario1(getWidth, getHeight,tierra,spriteAnimado.getSpriteActual(),5, spritePrincesa, spriteArbusto1);}
        }
        else if(teclado.espada!=0){
            if(teclado.key==1){
                renderer.renderEscenario1(getWidth, getHeight,tierra,spritePlayer1ataque,1, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer1ataque);}
            if(teclado.key==2){
                renderer.renderEscenario1(getWidth, getHeight,tierra,spritePlayer2ataque,2, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer2ataque);
            }
            if(teclado.key==3){
                renderer.renderEscenario1(getWidth, getHeight,tierra,spritePlayer3ataque,3, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer3ataque);}
            if(teclado.key==4){
                renderer.renderEscenario1(getWidth, getHeight,tierra,spritePlayer4ataque,4, spritePrincesa, spriteArbusto1);
                spriteAnimado.setSpriteActual(spritePlayer4ataque);}
            if(teclado.key==0){
                renderer.renderEscenario1(getWidth, getHeight,tierra,spriteAnimado.getSpriteActual(),5, spritePrincesa, spriteArbusto1);}

        }
        renderer.render(graphics);

        graphics.dispose();

        // Las imágenes se meten en el buffer, al hacer .show() las imagenes del buffer aparecen, como una carátula de un CD,
        // dibujas en la parte de atrás
        //y con el .show() le das la vuelta y se le el pintado

        bufferStrategy.show();

    }
}