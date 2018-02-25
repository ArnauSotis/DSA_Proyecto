import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menuprincipal extends JFrame{
    private JPanel panel1;
    private JButton jugarButton;
    private JButton salirButton;
    Juego juego;


    public Menuprincipal() {

        JFrame frame = new JFrame("Menu principal");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.setBounds(0,0, 400, 300);
        frame.setVisible(true);

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    juego.main(null);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();


            }

        }

        );
    }

    public static void main(String[] args)
    {
        Menuprincipal mp = new Menuprincipal();

    }

}
