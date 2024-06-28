package cr.ac.ucenfotec.views;

import cr.ac.ucenfotec.dao.Usuario.DAOPersona;
import cr.ac.ucenfotec.entity.models.famCompu.Workstation;
import cr.ac.ucenfotec.entity.models.usuario.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Registro extends JFrame {

    private DAOPersona daoPersona;
    private Persona persona;
    private JPanel Registro;
    private JTextField nIdentificacion;
    private JTextField nombrePersona;
    private JTextField apellidoPersona;
    private JTextField correoElectronico;
    private JTextField telefono;
    private JTextField usuario;
    private JTextField contrasena;
    private JButton registrarButton;
    private JButton menuLoginButton;

    public Registro(){

        this.daoPersona=new DAOPersona();
        setContentPane(Registro);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
        registrarButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento de Registro de persona
             *          a este evento se le asiga toda la informacion creada
             * @see Persona, es creado para su envio posterior a
             * @see DAOPersona
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String seleccionIdentificacin,seleccionNombre,seleccionApellidos,seleccionCorrreoElectronico,
                        seleccionTelefono,seleccionUsuario,seleccionContrasena;

                seleccionIdentificacin= nIdentificacion.getText();
                seleccionNombre= nombrePersona.getText();
                seleccionApellidos=apellidoPersona.getText();
                seleccionCorrreoElectronico=correoElectronico.getText();
                seleccionTelefono=telefono.getText();
                seleccionUsuario=usuario.getText();
                seleccionContrasena=contrasena.getText();

                persona= new Persona(seleccionIdentificacin,seleccionNombre,seleccionApellidos,seleccionCorrreoElectronico,seleccionTelefono,seleccionUsuario,seleccionContrasena);
                int id = daoPersona.create(persona);
                System.out.println("El id en el sistema es"+id);
                JOptionPane.showMessageDialog(Registro.this,"numero de identificacion: " +seleccionIdentificacin+ " Nombre: "+seleccionNombre+" Apellidos: "+ seleccionApellidos+ " correo electronico: " + seleccionCorrreoElectronico+"telefono: "+seleccionTelefono+ " usuario: " + seleccionUsuario + " contrasena: " + seleccionContrasena);

                List<Persona> lista3 = daoPersona.listAll();
                System.out.println("Impresion de Registro");
                System.out.println(lista3);


            }
        });
        menuLoginButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Evento de Envio a Menu Login
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginPage();

            }
        });
    }
}
