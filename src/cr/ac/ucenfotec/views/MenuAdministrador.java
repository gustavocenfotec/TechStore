package cr.ac.ucenfotec.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdministrador extends JFrame {

    private JPanel MenuAdministrador;
    private JRadioButton menuComponentesRadioButton;
    private JRadioButton menuFamiliasRadioButton;
    private JRadioButton armadoCompu;
    private JButton menuElegidoButton;
    private JButton salirDeLaAplicacionButton;

    /**
     * Constructor administrador
     */

    public MenuAdministrador(){

        setContentPane(MenuAdministrador);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);

        menuElegidoButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Evento de botones de menu,
             *          aqui se captan los botones y son intregrados al menu para su eleccion
             *          por medio de radio buttons
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                menuElegidoButton.add(menuComponentesRadioButton);
                menuElegidoButton.add(menuFamiliasRadioButton);
                menuElegidoButton.add(armadoCompu);

                if (menuComponentesRadioButton.isSelected()) {
                    dispose();
                    new RegistrarComponenteMn();
                }
                else if (menuFamiliasRadioButton.isSelected()) {
                    dispose();
                    new RegistrarFamiliaMn();
                }

                else if (armadoCompu.isSelected()) {
                    dispose();
                    new ArmarComponenteaFamiliaMn();
                }

            }
        });
        salirDeLaAplicacionButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Menu de salida o boton accionador de salida
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();

            }
        });
    }
}
