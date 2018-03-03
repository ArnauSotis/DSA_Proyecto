import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimientoTeclado implements KeyListener, FocusListener {

    public int key;
    public int espada;
    private Juego juego;

    public MovimientoTeclado(Juego juego){
        this.juego = juego;
    }

    public void keyReleased(KeyEvent e) {
        this.key=0;
    }

    @Override
    public void keyTyped(KeyEvent e) {


        if(e.getKeyCode()== KeyEvent.VK_X){
            this.espada=5;
        }
        else if(e.getKeyCode()== KeyEvent.VK_Z){
            this.espada=0;}
        if(this.espada==0){
            if(e.getKeyCode()== KeyEvent.VK_D){
                this.key=2;}
            else if(e.getKeyCode()== KeyEvent.VK_A){
                this.key=4;}
            else if(e.getKeyCode()== KeyEvent.VK_S){
                this.key=3;}
            else if(e.getKeyCode()== KeyEvent.VK_W){
                this.key=1;}}

        if(this.espada!=0){
            if(e.getKeyCode()== KeyEvent.VK_D){
                this.key=2;
                this.espada=2;}
            else if(e.getKeyCode()== KeyEvent.VK_A){
                this.key=4;
                this.espada=4;}
            else if(e.getKeyCode()== KeyEvent.VK_S){
                this.key=3;
                this.espada=3;}
            else if(e.getKeyCode()== KeyEvent.VK_W){
                this.key=1;
                this.espada=1;}
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()== KeyEvent.VK_X){
            this.espada=5;}
        else if(e.getKeyCode()== KeyEvent.VK_Z){
            this.espada=0;}
            if(this.espada==0){
                if(e.getKeyCode()== KeyEvent.VK_D){
                    this.key=2;}
                else if(e.getKeyCode()== KeyEvent.VK_A){
                    this.key=4;}
                else if(e.getKeyCode()== KeyEvent.VK_S){
                    this.key=3;}
                else if(e.getKeyCode()== KeyEvent.VK_W){
                    this.key=1;}}

             if(this.espada!=0){
                 if(e.getKeyCode()== KeyEvent.VK_D){
                     this.key=2;
                     this.espada=2;}
                 else if(e.getKeyCode()== KeyEvent.VK_A){
                     this.key=4;
                     this.espada=4;}
                 else if(e.getKeyCode()== KeyEvent.VK_S){
                     this.key=3;
                     this.espada=3;}
                 else if(e.getKeyCode()== KeyEvent.VK_W){
                     this.key=1;
                     this.espada=1;}
             }
        }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}



