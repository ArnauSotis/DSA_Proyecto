import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovimientoTeclado implements KeyListener, FocusListener {

    public int key;
    public MovimientoTeclado(){}

    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_D)
                this.key=2;
            else if(e.getKeyCode()== KeyEvent.VK_A)
                this.key=4;
            else if(e.getKeyCode()== KeyEvent.VK_S)
                this.key=3;
            else if(e.getKeyCode()== KeyEvent.VK_W)
                this.key=1;

        }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}



