import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Juego extends JFrame implements Runnable{

    private Canvas canvas = new Canvas();
    private RenderHandler renderer;
    private BufferedImage tierra;
    private BufferedImage spritePlayer1, spritePlayer2, spritePlayer3, spritePlayer4;
    private MovimientoTeclado teclado = new MovimientoTeclado();

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

        renderer = new RenderHandler(getWidth(),getHeight());

        tierra = loadImage("images/GrassTile.png");
        spritePlayer2 = loadImage("images/PlayerDerecha1.png");
        spritePlayer4 = loadImage("images/PlayerIzquierda1.png");
        spritePlayer1 = loadImage("images/PlayerArriba1.png");
        spritePlayer3 = loadImage("images/PlayerAbajo1.png");



    }

    private BufferedImage loadImage(String camino) throws IOException {
        BufferedImage loadImage = ImageIO.read(Juego.class.getResource(camino));
        BufferedImage  loadImage2 = new BufferedImage(loadImage.getWidth(), loadImage.getHeight(),BufferedImage.TYPE_INT_RGB);
        loadImage2.getGraphics().drawImage(loadImage,0,0,null);

        return loadImage2;

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

    public void render() throws IOException {
        //Mete el array de píxeles en la pantalla


        BufferStrategy bufferStrategy = canvas.getBufferStrategy();

        canvas.addKeyListener(teclado);
        canvas.addFocusListener(teclado);

        Graphics graphics = bufferStrategy.getDrawGraphics();

        paint(graphics);


        // Algoritmo diseñado por mi para rellenar todo el mapa de la Tile
        if(teclado.key==2){
            renderer.renderTerreno(getWidth(),getHeight(),tierra,spritePlayer2);}
        if(teclado.key==1){
            renderer.renderTerreno(getWidth(),getHeight(),tierra,spritePlayer1);}
        if(teclado.key==3){
            renderer.renderTerreno(getWidth(),getHeight(),tierra,spritePlayer3);}
        if(teclado.key==4){
            renderer.renderTerreno(getWidth(),getHeight(),tierra,spritePlayer4);}


         renderer.render(graphics);


          graphics.dispose();

        // Las imágenes se meten en el buffer, al hacer .show() las imagenes del buffer aparecen, como una carátula de un CD,
        // dibujas en la parte de atrás
        //y con el .show() le das la vuelta y se le el pintado
        bufferStrategy.show();

    }

    public void update(){}

    public static void main(String[] args) throws IOException {
        Juego juego = new Juego();
        Thread juegoThread = new Thread(juego);
        juegoThread.start();

    }
}