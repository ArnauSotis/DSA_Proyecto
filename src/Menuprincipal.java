import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menuprincipal {
    private JPanel panel1;
    private JButton aceptarButton;
    private JButton salirButton;
    Juego juego;

    public Menuprincipal() {
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        juego.main2(null);
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Menu principal");
        frame.setContentPane(new Menuprincipal().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0, 400, 300);
        frame.setVisible(true);

    }
}
