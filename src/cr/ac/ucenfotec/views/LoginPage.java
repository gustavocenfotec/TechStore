package cr.ac.ucenfotec.views;

import cr.ac.ucenfotec.dao.Usuario.DAOPersona;
import cr.ac.ucenfotec.entity.models.usuario.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginPage extends JFrame{
    private JPanel LoginPage;
    private JTextField usuario;
    private JTextField contrasena;
    private JButton ingresarButton;
    private JButton registroButton;
    private DAOPersona daoPersona;


    public LoginPage(){

        this.daoPersona=new DAOPersona();

        setContentPane(LoginPage);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,400);
        setLocationRelativeTo(null);
        setVisible(true);
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Registro();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, una vez ingresado la informacion se envia la debida informacion
             *          que se desea a verificar, por medio del accionar del boton Ingresar
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String seleccionUsuario,seleccionContrasena;

                seleccionUsuario=usuario.getText();
                seleccionContrasena=contrasena.getText();
                /**
                 * Aqui se realiza la verficacion de la cuenta
                 */

                int verificacion=0;
                verificacion=verificarUsuario(seleccionUsuario,seleccionContrasena);
                System.out.println("Este es el resultado de la verficiacion =" + verificacion);
                if (verificacion == 1) {
                    System.out.println("Bienvenido a su cuenta de Usuario");
                    JOptionPane.showMessageDialog(LoginPage.this,"Bienvenido a su cuenta de Administrador");
                    dispose();
                    new MenuAdministrador();
                }
                else if (verificacion == 2){
                    System.out.println("Su cuenta no existe en el sistema");
                    JOptionPane.showMessageDialog(LoginPage.this,"No se encuentra su cuenta, revisar Contrasena o Registrarse");
                }
            }
        });
    }

    /**
     *
     * @param usuario, usuario ingresado
     * @param contrasena, contrasena ingresada
     * @return int, el cual significa el encuentro no de la cuenta
     */
    public int verificarUsuario(String usuario, String contrasena) {

        List<Persona> lista3 = daoPersona.listAll();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).getUsuario().equals(usuario) && lista3.get(i).getContrasena().equals(contrasena)) {
                return 1;
            }
        }
        return 2;
    }
}
