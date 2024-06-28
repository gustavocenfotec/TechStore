package cr.ac.ucenfotec.views;

import cr.ac.ucenfotec.dao.Componentes.*;
import cr.ac.ucenfotec.entity.models.componentes.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class RegistrarComponenteMn extends JFrame {


    private DAOMegaComponente daoMegaComponente;
    private DAOComponente daoComponente;
    private DAORam daoRam;
    private DAOBateria daoBateria;

    private DAOTarjetaVideo daoTarjetaVideo;

    private DAOAlmacenamiento daoAlmacenamiento;
    private Componente componente;
    private Bateria bateria;
    private FuentePoder fuentePoder;

    private Procesador procesador;

    private Ram ram;
    private TarjetaMadre tarjetaMadre;

    private TarjetaVideo tarjetaVideo;

    private UnidadAlmacenamiento unidadAlmacenamiento;

    private JPanel registrarComponenteMN;
    private JComboBox comboBox1;
    private JButton registrarButton;
    private JButton volverAMenuButton;
    private JTextField obtenerPrecio;
    private JTextField obtenerNombre;
    private JTextField obtenerRating;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTable table1;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTextField obtenerID;

    /**
     * Constructor de Registro
     */
    public RegistrarComponenteMn() {
        setContentPane(registrarComponenteMN);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,900);
        setLocationRelativeTo(null);
        setVisible(true);
        this.daoMegaComponente=new DAOMegaComponente();
        this.daoComponente=new DAOComponente();
        this.daoRam=new DAORam();
        this.daoBateria=new DAOBateria();
        this.daoTarjetaVideo=new DAOTarjetaVideo();
        this.daoAlmacenamiento=new DAOAlmacenamiento();
        eliminarOpciones();

        crearTabla();


        registrarButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Evento de Registro, aqui se capturan todos los datos de
             *          los diferentes objetos y sus especializaciones.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion_componente,nombre,duracion,capacidadRam,tipoGPU,tipoAlmacenamiento;
//               Componente c= null;

                seleccion_componente= ((String) comboBox1.getSelectedItem());
                nombre=obtenerNombre.getText();
                int rating=Integer.parseInt(obtenerRating.getText());
                int id=0;
                double precio=Double.parseDouble(obtenerPrecio.getText());

                System.out.println("rating:"+rating);
                System.out.println("precio:"+precio);


                switch (seleccion_componente) {
                    case ("Bateria"):
                        duracion=((String) comboBox2.getSelectedItem());
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating+"Duracion:"+duracion);
                        bateria= new Bateria(nombre,precio, rating,seleccion_componente,duracion);
                        id= daoBateria.create(bateria);
                        System.out.println("El id en el sistema es"+id);
                        break;
                    case ("FuentePoder"):
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating);
                        componente= new FuentePoder(nombre,precio, rating,seleccion_componente);
                       id = daoComponente.create(componente);
                       System.out.println("El id en el sistema es"+id);
                        break;
                    case ("Procesador"):
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating);
                        componente= new Procesador(nombre,precio, rating,seleccion_componente);
                        id = daoComponente.create(componente);
                        System.out.println("El id en el sistema es"+id);
                        break;
                    case ("Ram"):
                        capacidadRam=((String) comboBox3.getSelectedItem());
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating+" Capacidad RAM:"+capacidadRam);
                        ram= new Ram(nombre,precio, rating,seleccion_componente, capacidadRam);
                        id = daoRam.create(ram);
                        System.out.println("El id en el sistema es"+id);
                        break;
                    case ("TarjetaMadre"):
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating);
                        componente= new TarjetaMadre(nombre,precio, rating,seleccion_componente);
                        id = daoComponente.create(componente);
                        System.out.println("El id en el sistema es"+id);
                        break;
                    case ("TarjetaVideo"):
                        tipoGPU=((String) comboBox4.getSelectedItem());
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating+" Tipo GPU:"+tipoGPU);
                        tarjetaVideo= new TarjetaVideo(nombre,precio, rating,seleccion_componente,tipoGPU);
                        id = daoTarjetaVideo.create(tarjetaVideo);
                        System.out.println("El id en el sistema es"+id);
                        break;
                    case ("Almacenamiento"):
                        tipoAlmacenamiento=((String) comboBox5.getSelectedItem());
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +seleccion_componente+ "precio:" + precio+ " Nombre: " + nombre + "Rating: " + rating+" Tipo Almacenamiento:"+tipoAlmacenamiento);
                        unidadAlmacenamiento= new UnidadAlmacenamiento(nombre,precio, rating,seleccion_componente,tipoAlmacenamiento);
                        id = daoAlmacenamiento.create(unidadAlmacenamiento);
                        System.out.println("El id en el sistema es"+id);
                        break;
                }
                crearTabla();

            }
        });
        volverAMenuButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, volver al menu por medio de evento de boton
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuAdministrador();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento seleccion de Combobox, el cual delimita que se quiere ver
             *          segun el parametro enviado, se trabaja por medio de switch case del combobox
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String contenedor=((String) comboBox1.getSelectedItem());


                JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Componente:" +contenedor);

                switch (contenedor) {
                    case ("Bateria"):
                        comboBox2.setVisible(true);
                        comboBox3.setVisible(true);
                        comboBox4.setVisible(true);
                        comboBox5.setVisible(true);
                        comboBox3.setVisible(false);
                        comboBox4.setVisible(false);
                        comboBox5.setVisible(false);
                        obtenerNombre.setVisible(true);
                        obtenerPrecio.setVisible(true);
                        obtenerRating.setVisible(true);
                        obtenerID.setVisible(true);
                        break;
                    case ("Ram"):
                        comboBox2.setVisible(true);
                        comboBox3.setVisible(true);
                        comboBox4.setVisible(true);
                        comboBox5.setVisible(true);
                        comboBox2.setVisible(false);
                        comboBox4.setVisible(false);
                        comboBox5.setVisible(false);
                        obtenerNombre.setVisible(true);
                        obtenerPrecio.setVisible(true);
                        obtenerRating.setVisible(true);
                        obtenerID.setVisible(true);
                        break;
                    case ("TarjetaVideo"):
                        comboBox2.setVisible(true);
                        comboBox3.setVisible(true);
                        comboBox4.setVisible(true);
                        comboBox5.setVisible(true);
                        comboBox2.setVisible(false);
                        comboBox3.setVisible(false);
                        comboBox5.setVisible(false);
                        obtenerNombre.setVisible(true);
                        obtenerPrecio.setVisible(true);
                        obtenerRating.setVisible(true);
                        obtenerID.setVisible(true);
                        break;
                    case ("Almacenamiento"):
                        comboBox2.setVisible(true);
                        comboBox3.setVisible(true);
                        comboBox4.setVisible(true);
                        comboBox5.setVisible(true);
                        comboBox2.setVisible(false);
                        comboBox3.setVisible(false);
                        comboBox4.setVisible(false);
                        obtenerNombre.setVisible(true);
                        obtenerPrecio.setVisible(true);
                        obtenerRating.setVisible(true);
                        obtenerID.setVisible(true);
                        break;
                    default:
                        comboBox2.setVisible(false);
                        comboBox3.setVisible(false);
                        comboBox4.setVisible(false);
                        comboBox5.setVisible(false);
                        obtenerNombre.setVisible(true);
                        obtenerPrecio.setVisible(true);
                        obtenerRating.setVisible(true);
                        obtenerID.setVisible(true);
                }

            }
        });
        modificarButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Accionante del evento de modificacion, busca el objeto
             *          por medio de codigo id unico de su respectiva tabla
             *          y por medio del
             * @see Bateria, para generar el objeto
             * @see DAOBateria para visualizarlo
             * estos son ejemplos pero es llamado todo por su propio nombre y atributos
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String seleccion_componente,nombre,duracion,capacidadRam,tipoGPU,tipoAlmacenamiento;

                seleccion_componente= ((String) comboBox1.getSelectedItem());
                nombre=obtenerNombre.getText();
                int rating=0;
                int id=Integer.parseInt(obtenerID.getText());
                double precio=0.0;
                String ratingLetras=obtenerRating.getText();
                String precioLetras=obtenerPrecio.getText();

                switch (seleccion_componente) {
                    case ("Bateria"):
                        duracion=((String) comboBox2.getSelectedItem());
                        bateria= daoBateria.read(id);
                        System.out.println(bateria);
                        captarInformacion(bateria,nombre,ratingLetras,rating,precioLetras,precio);
                        bateria.setDuracion(duracion);
                        bateria.setNombreComponente(seleccion_componente);

                        daoBateria.update(bateria);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);
                        break;
                    case ("FuentePoder"):
                        componente= daoComponente.read(id);

                        captarInformacion(componente,nombre,ratingLetras,rating,precioLetras,precio);

                        daoComponente.update(componente);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);
                        break;
                    case ("Procesador"):
                        componente= daoComponente.read(id);

                        captarInformacion(componente,nombre,ratingLetras,rating,precioLetras,precio);

                        daoComponente.update(componente);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);
                        break;
                    case ("Ram"):
                        capacidadRam=((String) comboBox3.getSelectedItem());
                        ram= daoRam.read(id);

                        captarInformacion(ram,nombre,ratingLetras,rating,precioLetras,precio);
                        ram.setCapacidadRam(capacidadRam);
                        ram.setNombreComponente(seleccion_componente);

                        daoRam.update(ram);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);
                        break;
                    case ("TarjetaMadre"):
                        componente= daoComponente.read(id);

                        captarInformacion(componente,nombre,ratingLetras,rating,precioLetras,precio);

                        daoComponente.update(componente);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);

                        break;
                    case ("TarjetaVideo"):
                        tipoGPU=((String) comboBox4.getSelectedItem());
                        tarjetaVideo= daoTarjetaVideo.read(id);

                        captarInformacion(tarjetaVideo,nombre,ratingLetras,rating,precioLetras,precio);
                        tarjetaVideo.setTipoGPU(tipoGPU);

                        tarjetaVideo.setNombreComponente(seleccion_componente);
                        daoTarjetaVideo.update(tarjetaVideo);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);

                        break;
                    case ("Almacenamiento"):
                        tipoAlmacenamiento=((String) comboBox5.getSelectedItem());
                        unidadAlmacenamiento= daoAlmacenamiento.read(id);

                        captarInformacion(unidadAlmacenamiento,nombre,ratingLetras,rating,precioLetras,precio);
                        unidadAlmacenamiento.setCapacidadAlmacenamiento(tipoAlmacenamiento);

                        daoAlmacenamiento.update(unidadAlmacenamiento);
                        JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Cambiado el componente:"+id);

                        break;
                }
                crearTabla();


            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Evento accionado por el boton de Eliminacion,
             *          busqueda del objeto por medio de id unico para su borrado en la base de datos
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                int id=Integer.parseInt(obtenerID.getText());
                System.out.println("Delete");
                Componente c = new Componente();
                c.setId(id);
                System.out.println("R/");
                System.out.println(daoComponente.delete(c));
                crearTabla();
            }
        });
    }

    /**
     * Void que pone la configuracion visual de forma expeditda al iniciar la pagina
     */
    public void eliminarOpciones(){
        comboBox2.setVisible(false);
        comboBox3.setVisible(false);
        comboBox4.setVisible(false);
        comboBox5.setVisible(false);
        obtenerNombre.setVisible(false);
        obtenerPrecio.setVisible(false);
        obtenerRating.setVisible(false);
        obtenerID.setVisible(false);


    }

    /**
     *
     * @param c, es tamano de la lista de la base de datos
     * @param lista3, lista con toda la informacion de la base de datos
     * @return data, devuelte toda la informacion de forma bidimensional de un array para llenar filas
     */
    public Object[][] crearFilasTabla(int c,List<MegaComponente> lista3){
        Object[][] data = new Object[c][9];

        int value = 1;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 9; j++) {
                if(j==0){
                    data[i][j] = lista3.get(i).getId();
                    value++;}
                else if (j==1) {
                    data[i][j] = lista3.get(i).getNombreComponente();
                    value++;}
                else if (j==2) {
                    data[i][j] = lista3.get(i).getNombre();
                    value++;}
                else if (j==3) {
                    data[i][j] = lista3.get(i).getPrecio();
                    value++;}
                else if (j==4) {
                    data[i][j] = lista3.get(i).getRating();
                    value++;}
                else if (j==5) {
                    data[i][j] = lista3.get(i).getDuracion();
                    value++;}
                else if (j==6) {
                    data[i][j] = lista3.get(i).getCapacidadRam();
                    value++;}
                else if (j==7) {
                    data[i][j] = lista3.get(i).getTipoGPU();
                    value++;}
                else if (j==8) {
                    data[i][j] = lista3.get(i).getCapacidadAlmacenamiento();
                    value++;}

            }
        }
        return data;
    }

    /**
     * Void de Creacion de tabla para ser visualizada en el esquema
     */
    public void crearTabla(){
        List<MegaComponente> lista3 = daoMegaComponente.listAll();


        int c = daoComponente.listAll().size();
        System.out.println(c);

        Object[][] row=crearFilasTabla(c,lista3);

        String[] column = {"ID", "Producto", "Nombre", "PRECIO", "RATING","Duracion","Capacidad Ram","Tipo GPU","Tipo Almacenamiento"};

        table1.setModel(new DefaultTableModel(row, column));
    }

    /**
     *
     * @param t generic de Componente y sus hijos
     * @param nombre nombre del componente
     * @param ratingLetras tamno de las letras y asegurar el no vacio
     * @param rating numero de rating deseado
     * @param precioLetras tamno de las letras y asegurar el no vacio
     * @param precio precio del componente
     */
    public void captarInformacion(Componente t,String nombre,String ratingLetras,int rating,String precioLetras,double precio){
        if(!nombre.equals("nombre")){
            if(nombre.isEmpty()==false){
                t.setNombre(nombre);
            }
        }

        if(ratingLetras.isEmpty()==false){
            rating=Integer.parseInt(obtenerRating.getText());
            if(rating!=0){
                t.setRating(rating);}
        } else if (ratingLetras.isEmpty()==true) {
            JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Espacio Vacio de Rating");
        }

        if(precioLetras.isEmpty()==false){
            precio=Double.parseDouble(obtenerPrecio.getText());
            if(precio!=0.0){
                t.setPrecio(precio);}
        } else if (precioLetras.isEmpty()==true) {
            JOptionPane.showMessageDialog(RegistrarComponenteMn.this,"Espacio Vacio de Precio");
        }


    }


}
