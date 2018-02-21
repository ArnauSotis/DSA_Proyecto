import javax.swing.JFrame;
import java.awt.Canvas;

public class Juego extends JFrame implements Runnable{

    private Canvas canvas = new Canvas();
    public Juego()
    {

        //Al aturar el juego, para de compilar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Ventana de (0,0) a (1000,800)
        setBounds(0,0, 400, 300);

        //Coloca la pantalla en el centro
        setLocationRelativeTo(null);

        //Añade el lienzo
        add(canvas);

        //Lo hace visible
        setVisible(true);
    }

    public void run(){}
    public static void main2(String[] args)
    {
        Juego juego = new Juego();
        Thread juegoThread = new Thread(juego);
        juegoThread.start();

    }
}
