package cr.ac.ucenfotec.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Presentacion extends JFrame {

    private JLabel Titulo1;
    private JButton Administrador;
    private JPanel MainPanel;

    /**
     * Constructor con especificaciones necesarias
     */
    public Presentacion() {
        setContentPane(MainPanel);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,400);
        setLocationRelativeTo(null);
        setVisible(true);
        Administrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();
            }
        });
    }


}
