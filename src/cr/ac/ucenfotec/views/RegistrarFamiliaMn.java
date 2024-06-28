package cr.ac.ucenfotec.views;

import cr.ac.ucenfotec.dao.famCompu.*;
import cr.ac.ucenfotec.entity.models.famCompu.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegistrarFamiliaMn extends JFrame {

    private DAOMegaFamilia daoMegaFamilia;
    private MegaFamilia megaFamilia;

    private DAOEscolar daoEscolar;
    private DAOServidor daoServidor;

    private DAOOficina daoOficina;

    private DAOWorkstation daoWorkstation;

    private DAOGaming daoGaming;

    private DAOCasa daoCasa;

    private DAOTrabajo daoTrabajo;
    private Escolar escolar;
    private Servidor servidor;
    private Oficina oficina;
    private Workstation workstation;
    private Gaming gaming;
    private Casa casa;
    private Trabajo trabajo;


    private JPanel registrarFamiliaMn;
    private JComboBox FamiliasPrincipales;
    private JTextField nombreFamiliaTextField;
    private JButton registrarFamiliaButton;
    private JButton volverAMenuButton;
    private JComboBox SubFamilias;
    private JComboBox RAM;
    private JComboBox Almacenamiento;
    private JComboBox tipoGPU;
    private JComboBox numeroSticks;
    private JComboBox Monitor;
    private JTextField peso;
    private JComboBox fuentePoder;
    private JComboBox bateria;
    private JTable table1;
    private JButton modificarFamiliaButton;
    private JButton eliminarFamiliaButton;
    private JTextField obtenerID;

    public RegistrarFamiliaMn(){
        /**
         * Constructor del Registro Familia
         */
//        Inicializacion de Punteros

        this.daoEscolar=new DAOEscolar();
        this.daoServidor=new DAOServidor();
        this.daoOficina=new DAOOficina();
        this.daoWorkstation=new DAOWorkstation();
        this.daoGaming=new DAOGaming();
        this.daoCasa=new DAOCasa();
        this.daoTrabajo=new DAOTrabajo();
        this.daoMegaFamilia=new DAOMegaFamilia();

        setContentPane(registrarFamiliaMn);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,800);
        setLocationRelativeTo(null);
        setVisible(true);
        crearTabla();

//        String proteccionRAM[]={"4 GB","8 GB","16 GB","24 GB","32 GB","64 GB","128 GB","256 GB","512 GB","1024 GB"};
//        String proteccionAlmacenamiento[]={"1TB HDD","2TB HDD","128GB SSD","256GB SSD", "512GB SSD","1 TB SSD", "32 GB", "64 GB", "128 GB"};
//        String proteccionnumeroSticks[]={"1","2","3","4", "5","6","7","8","9","10","11","12","13","14","15","16"};
//        String proteccionTarjetaVideo[]={"GPU calculo científico"," GPU renderizado"," GPU homeworking"};
//        String proteccionBateria[]={"8 horas","10 horas","16 horas"};
//        String proteccionFuentesPoder[]={"1","2","3","4", "5","6","7","8"};
//        String proteccionSubFamilias[]={"Oficina", "Gaming","Workstation","Casa","Trabajo"};

        setGeneralVisualizacionFamilia();



        registrarFamiliaButton.addActionListener(new ActionListener() {

            /**
             *
             * @param e the event to be processed, evento de accion de Registrar Familia
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion_familia, seleccion_subfamilia,nombreFamilia, seleccionRam, seleccionAlmacenamiento, seleccionTipoGPU,seleccionNumeroSticks,seleccionMonitor,seleccionFuentePoder,seleccionBateria;

                int seleccionNumeroStickss,seleccionFuentePoders;
                double pesokg;

                seleccion_familia= ((String) FamiliasPrincipales.getSelectedItem());
                seleccion_subfamilia=((String) SubFamilias.getSelectedItem());
                nombreFamilia= nombreFamiliaTextField.getText();
                seleccionRam=((String) RAM.getSelectedItem());
                seleccionAlmacenamiento=((String) Almacenamiento.getSelectedItem());
                seleccionTipoGPU=((String) tipoGPU.getSelectedItem());
                seleccionNumeroSticks=((String) numeroSticks.getSelectedItem());
                seleccionNumeroStickss=Integer.parseInt(seleccionNumeroSticks);
                seleccionMonitor=((String) Monitor.getSelectedItem());
                pesokg=Double.parseDouble(peso.getText());
                seleccionFuentePoder=((String) fuentePoder.getSelectedItem());
                seleccionFuentePoders=Integer.parseInt(seleccionFuentePoder);
                seleccionBateria=((String) bateria.getSelectedItem());

/**
 * Sw case, que lleva la opcion del combobox de eleccion de familia
 */


                switch (seleccion_familia) {
                    /**
                     * Se envia el objeto segun la familia creada a su respectivo dao para su creacion
                     * ejemplos
                     * @see Escolar,
                     * @see Oficina,
                     * @see daoEscolar,
                     * @see daoOficina,
                     */
                    case ("Escolares"):
                        JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Familia Principal:" +seleccion_familia+ " Familia creada: "+nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento + " Y no admite tarjeta de Video ");
                        escolar= new Escolar(seleccion_familia,nombreFamilia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccion_familia,seleccion_familia);
                        int id = daoEscolar.create(escolar);
                        System.out.println("El id en el sistema es"+id);
                        break;
                    case ("Sobremesa"):
                        switch (seleccion_subfamilia) {
                            case ("Oficina"):
                                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Principal: " +seleccion_subfamilia+ " nombre de Familia:"+ nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento + " el cliente eligio llevar monitor : "+ seleccionMonitor +" Y no admite tarjeta de Video ");
                                oficina= new Oficina(seleccion_familia,nombreFamilia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccion_subfamilia,seleccion_subfamilia,seleccionMonitor,seleccion_subfamilia);
                                id = daoOficina.create(oficina);
                                System.out.println("El id en el sistema es"+id);
                                break;
                            case ("Gaming"):
                                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Principal: " +seleccion_subfamilia+ " nombre de Familia:"+ nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento + " el cliente eligio llevar monitor : "+ seleccionMonitor +" Y decidio llevar la siguiente tarjeta de Video " + seleccionTipoGPU);
                                gaming=new Gaming(seleccion_familia,nombreFamilia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccion_subfamilia,seleccion_subfamilia,seleccionMonitor,seleccion_subfamilia,seleccionTipoGPU);
                                id = daoGaming.create(gaming);
                                System.out.println("El id en el sistema es"+id);
                                break;
                            case ("Workstation"):
                                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Principal: " +seleccion_subfamilia+ " nombre de Familia:"+ nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento + " el cliente eligio llevar monitor : "+ seleccionMonitor +" Y decidio llevar la siguiente tarjeta de Video " + seleccionTipoGPU);
                                workstation=new Workstation(seleccion_familia,nombreFamilia,seleccionRam,seleccionNumeroStickss, seleccionAlmacenamiento,seleccion_subfamilia,seleccion_subfamilia,seleccionMonitor,seleccion_subfamilia, seleccionTipoGPU);
                                id = daoWorkstation.create(workstation);
                                System.out.println("El id en el sistema es"+id);
                                break;
                        }
                        break;
                    case ("Portables"):
                        switch (seleccion_subfamilia) {
                            case ("Casa"):
                                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Principal: " +seleccion_subfamilia+ " nombre de Familia:"+ nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento + " con una bateria de una duracion de : "+ seleccionBateria +" y goza de un peso de "+ pesokg+" Y no admite tarjeta de Video ");
                                casa= new Casa(seleccion_familia,nombreFamilia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccion_subfamilia,seleccion_subfamilia,pesokg,seleccionBateria,seleccion_subfamilia);
                                id = daoCasa.create(casa);
                                System.out.println("El id en el sistema es"+id);
                                break;
                            case ("Trabajo"):
                                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Principal: " +seleccion_subfamilia+ " nombre de Familia:"+ nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento +" tiene una tarjeta de Video de: "+ seleccionTipoGPU+ " con una bateria de una duracion de : "+ seleccionBateria +" y goza de un peso de "+ pesokg);
                                trabajo=new Trabajo(seleccion_familia,nombreFamilia,seleccionRam,
                                        seleccionNumeroStickss,seleccionAlmacenamiento,seleccion_subfamilia,seleccion_subfamilia,pesokg,seleccionBateria,seleccion_subfamilia,seleccionTipoGPU);
                                id = daoTrabajo.create(trabajo);
                                System.out.println("El id en el sistema es"+id);
                                break;
                        }
                        break;

                    case ("Servidores"):
                        JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Principal:" +seleccion_familia+ "nombre de Familia:"+ nombreFamilia+" Con una RAM de: "+ seleccionRam+ " con un numero de sticks de :" + seleccionNumeroSticks+ " Un almacenamiento de: " + seleccionAlmacenamiento + " con un numero de Fuentes de Poder de: "+ seleccionFuentePoder +" Y no admite tarjeta de Video ");
                        servidor=new Servidor(seleccion_familia,nombreFamilia,seleccionRam, seleccionNumeroStickss,seleccionAlmacenamiento,seleccion_familia,seleccion_familia,seleccionFuentePoders);
                        id = daoServidor.create(servidor);
                        System.out.println("El id en el sistema es"+id);
                        break;
                }
                crearTabla();

            }
        });
        volverAMenuButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, acccionador de vuelta al Menu
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuAdministrador();
            }
        });
        FamiliasPrincipales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Este es el accionador visual del contenido de los combobox segun la familia principal
                 */

                String contenedorFamilia=((String) FamiliasPrincipales.getSelectedItem());


                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Familia:" +contenedorFamilia);

                /**
                 * Se puede visualizar como los combobox se alimentan del Array previamente establecido
                 * para poder mostrar las necesidades exactas segun la clase
                 *
                 *  * Ademas selecciones de visualizacion para cada tipo de familia
                 *
                 */

                switch (contenedorFamilia) {
                    case ("Escolares"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                      //INICIO DE SELECCION DE APARTADOS
                        String RAMDeseadoES[]={"4 GB","8 GB","16 GB"};
                        String AlmacenamientoDeseadoES[]={"1TB HDD","128GB SSD"};
                        String SticksDeseadoES[]={"1","2"};

                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoES));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoES));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadoES));
                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        numeroSticks.setVisible(true);
                        break;
                    case ("Sobremesa"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String SubFamiliasDeseadasSM[]={"Oficina", "Gaming","Workstation"};
                        SubFamilias.setModel(new DefaultComboBoxModel(SubFamiliasDeseadasSM));
                        SubFamilias.setVisible(true);
                        break;
                    case ("Portables"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String proteccionSubFamiliasPO[]={"Casa","Trabajo"};
                        SubFamilias.setModel(new DefaultComboBoxModel(proteccionSubFamiliasPO));
                        SubFamilias.setVisible(true);
                        break;
                    case ("Servidores"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //QUE PUEDE OBSERVAR
                        String RAMDeseadoSE[]={"64 GB","128 GB","256 GB","512 GB","1024 GB"};
                        String SticksDeseadoSE[]={"1","2","3","4", "5","6","7","8","9","10","11","12","13","14","15","16"};
                        String AlmacenamientoDeseadoSE[]={"32 TB", "64 TB", "128 TB"};
                        String fuentePoderDeseadoSE[]={"1","2","3","4", "5","6","7","8"};
                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoSE));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoSE));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadoSE));
                        fuentePoder.setModel(new DefaultComboBoxModel(fuentePoderDeseadoSE));
                        RAM.setVisible(true);
                        numeroSticks.setVisible(true);
                        Almacenamiento.setVisible(true);
                        fuentePoder.setVisible(true);
                        break;
                }
            }
        });
        SubFamilias.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, envento de Seleccion de Combobox SubFamilia
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenedorSubFamilia=((String) SubFamilias.getSelectedItem());


                JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Familia:" +contenedorSubFamilia);

                /**
                 * Segun la subfamilia se genera el combobox segun las reglas de negocio previamente determinadas por el cliente
                 * volvemos a la implementacion de arrays dentro del combobox
                 * Ademas selecciones de visualizacion para cada tipo de familia
                 */

                switch (contenedorSubFamilia) {
                    case ("Oficina"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String RAMDeseadoOF[]={"8 GB","16 GB"};
                        String AlmacenamientoDeseadoOF[]={"256GB SSD"};
                        String SticksDeseadoOF[]={"1","2"};
                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoOF));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoOF));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadoOF));
                        RAM.setVisible(true);
                        numeroSticks.setVisible(true);
                        Almacenamiento.setVisible(true);
                        Monitor.setVisible(true);
                        break;

                    case ("Gaming"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String RAMDeseadoGA[]={"16 GB","24 GB","32 GB"};
                        String AlmacenamientoDeseadoGA[]={"1TB HDD","2TB HDD","256GB SSD", "512GB SSD","1 TB SSD"};
                        String SticksDeseadGA[]={"1","2","3","4"};
                        String TarjetaVideoDeseadoGA[]={"GPU calculo científico"," GPU renderizado"," GPU homeworking"};
                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoGA));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoGA));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadGA));
                        tipoGPU.setModel(new DefaultComboBoxModel(TarjetaVideoDeseadoGA));
                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        tipoGPU.setVisible(true);
                        numeroSticks.setVisible(true);
                        Monitor.setVisible(true);
                        break;

                    case ("Workstation"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String RAMDeseadoWS[]={"32 GB","64 GB"};
                        String AlmacenamientoDeseadoWS[]={"1TB HDD","2TB HDD","256GB SSD", "512GB SSD","1 TB SSD"};
                        String SticksDeseadWS[]={"1","2","3","4", "5","6","7","8"};
                        String TarjetaVideoDeseadoWS[]={"GPU calculo científico"," GPU renderizado"," GPU homeworking"};
                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoWS));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoWS));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadWS));
                        tipoGPU.setModel(new DefaultComboBoxModel(TarjetaVideoDeseadoWS));
                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        tipoGPU.setVisible(true);
                        numeroSticks.setVisible(true);
                        Monitor.setVisible(true);
                        break;

                    case ("Casa"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        // OBSERVAR EL CAMBIO
                        String RAMDeseadoCS[]={"8 GB","16 GB"};
                        String AlmacenamientoDeseadoCS[]={"256GB SSD", "512GB SSD"};
                        String SticksDeseadCS[]={"1","2"};
                        String BateriaDeseadaCS[]={"8 horas","10 horas"};
                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoCS));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoCS));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadCS));
                        bateria.setModel(new DefaultComboBoxModel(BateriaDeseadaCS));
                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        numeroSticks.setVisible(true);
                        peso.setVisible(true);
                        bateria.setVisible(true);
                        break;

                    case ("Trabajo"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //QUE PUEDE OBSERVAR
                        String RAMDeseadoTR[]={"8 GB","16 GB"};
                        String AlmacenamientoDeseadoTR[]={"256GB SSD", "512GB SSD"};
                        String SticksDeseadTR[]={"1","2"};
                        String TarjetaVideoDeseadaTR[]={"GPU calculo científico"," GPU renderizado"," GPU homeworking"};
                        String BateriaDeseadaTR[]={"8 horas","10 horas","16 horas"};
                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoTR));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoTR));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadTR));
                        bateria.setModel(new DefaultComboBoxModel(BateriaDeseadaTR));
                        tipoGPU.setModel(new DefaultComboBoxModel(TarjetaVideoDeseadaTR));
                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        tipoGPU.setVisible(true);
                        numeroSticks.setVisible(true);
                        peso.setVisible(true);
                        bateria.setVisible(true);
                        break;
                }



            }
        });

        eliminarFamiliaButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Borrado de objeto en la tabla
             *          se realiza por medio de busqueda por id
             *          segun se nota
             * @see MegaFamilia,
             * @see DAOMegaFamilia,
             * los cuales son utilizados para realizar el delete
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(obtenerID.getText());
                System.out.println("Delete");
                MegaFamilia c = new MegaFamilia();
                c.setId(id);
                System.out.println("R/");
                System.out.println(daoMegaFamilia.delete(c));
                crearTabla();
            }
        });
        modificarFamiliaButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Evento de accion de boton modificar
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion_familia, seleccion_subfamilia,nombreFamilia, seleccionRam, seleccionAlmacenamiento, seleccionTipoGPU,seleccionNumeroSticks,seleccionMonitor,seleccionFuentePoder,seleccionBateria,pesoLetras;

                int seleccionNumeroStickss,seleccionFuentePoders;
                double pesokg;

                seleccion_familia= ((String) FamiliasPrincipales.getSelectedItem());
                seleccion_subfamilia=((String) SubFamilias.getSelectedItem());
                nombreFamilia= nombreFamiliaTextField.getText();
                seleccionRam=((String) RAM.getSelectedItem());
                seleccionAlmacenamiento=((String) Almacenamiento.getSelectedItem());
                seleccionTipoGPU=((String) tipoGPU.getSelectedItem());
                seleccionNumeroSticks=((String) numeroSticks.getSelectedItem());
                seleccionNumeroStickss=Integer.parseInt(seleccionNumeroSticks);
                seleccionMonitor=((String) Monitor.getSelectedItem());
                pesokg=0.0;
                seleccionFuentePoder=((String) fuentePoder.getSelectedItem());
                seleccionFuentePoders=Integer.parseInt(seleccionFuentePoder);
                seleccionBateria=((String) bateria.getSelectedItem());
                pesoLetras=peso.getText();
                int id=Integer.parseInt(obtenerID.getText());


/**
 * Volvemos a visualizar las opciones de cambio que se vuelven true segun la familia
 * e implementacion de datos necesarios para la actualizacion de objeto dentro del mismo.
 */
                switch (seleccion_familia) {
                    case ("Escolares"):
                        escolar= daoEscolar.read(id);
                        System.out.println("El id es este: " +id);
                        captarInfoGeneral(escolar,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                        daoEscolar.update(escolar);
                        break;
                    case ("Sobremesa"):
                        switch (seleccion_subfamilia) {
                            case ("Oficina"):

                                oficina= daoOficina.read(id);
                                captarInfoGeneral(oficina,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                                captarInfoSobremesa(oficina,seleccionMonitor,seleccion_subfamilia);
                                daoOficina.update(oficina);
                                break;
                            case ("Gaming"):
                                gaming= daoGaming.read(id);
                                captarInfoGeneral(gaming,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                                captarInfoSobremesa(gaming,seleccionMonitor,seleccion_subfamilia);
                                gaming.setTarjetaVideo(seleccionTipoGPU);
                                daoGaming.update(gaming);
                                break;
                            case ("Workstation"):
                                workstation= daoWorkstation.read(id);
                                captarInfoGeneral(workstation,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                                captarInfoSobremesa(workstation,seleccionMonitor,seleccion_subfamilia);
                                workstation.setTarjetaVideo(seleccionTipoGPU);
                                daoWorkstation.update(workstation);
                                break;
                        }
                        break;
                    case ("Portables"):
                        switch (seleccion_subfamilia) {
                            case ("Casa"):
                                casa= daoCasa.read(id);
                                captarInfoGeneral(casa,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                                captarInfoPortables(casa,pesoLetras,pesokg,seleccionBateria,seleccion_subfamilia);
                                daoCasa.update(casa);
                                break;
                            case ("Trabajo"):
                                trabajo= daoTrabajo.read(id);
                                captarInfoGeneral(trabajo,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                                captarInfoPortables(trabajo,pesoLetras,pesokg,seleccionBateria,seleccion_subfamilia);
                                trabajo.setTarjetaVideo(seleccionTipoGPU);
                                daoTrabajo.update(trabajo);
                                break;
                        }
                        break;

                    case ("Servidores"):
                        servidor= daoServidor.read(id);
                        System.out.println("El id es este: " +id);
                        captarInfoGeneral(servidor,nombreFamilia, seleccion_familia, seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento);
                        servidor.setFuentesDePoder(seleccionFuentePoders);
                        daoServidor.update(servidor);
                        break;
                }
                crearTabla();
            }
        });
    }

    /**
     * Esta Seccion lo que despliega son las opciones en los listeners de cada una de las opciones
     * y que se deben desplegar
     *setGeneralVisualizacionFamilia  y setGeneralVisualizacionSubFamilia
     * realizan la desaparicion del Menu
     */
    public void setGeneralVisualizacionFamilia(){
        SubFamilias.setVisible(false);
        RAM.setVisible(false);
        Almacenamiento.setVisible(false);
        tipoGPU.setVisible(false);
        numeroSticks.setVisible(false);
        Monitor.setVisible(false);
        peso.setVisible(false);
        fuentePoder.setVisible(false);
        bateria.setVisible(false);
    }

    /**
     * Funcion void para visualizar lo deseado al momento de eligir subfamilia
     */

    public void setGeneralVisualizacionSubFamilia(){
        RAM.setVisible(false);
        Almacenamiento.setVisible(false);
        tipoGPU.setVisible(false);
        numeroSticks.setVisible(false);
        Monitor.setVisible(false);
        peso.setVisible(false);
        fuentePoder.setVisible(false);
        bateria.setVisible(false);
    }

    /**
     *
     * @param c es tamano de la lista que se desea representar
     * @param lista3, lista que desea llenar las filas
     * @return data que es un arrya bidimesionla para llenar las filas de la tabla
     */

    public Object[][] crearFilasTabla(int c, List<MegaFamilia> lista3){
        Object[][] data = new Object[c][14];

        int value = 1;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 14; j++) {
                if(j==0){
                    data[i][j] = lista3.get(i).getId();
                    value++;}
                else if (j==1) {
                    data[i][j] = lista3.get(i).getTipoPrincipalFamilia();
                    value++;}
                else if (j==2) {
                    data[i][j] = lista3.get(i).getTipoSubFamilia();
                    value++;}
                else if (j==3) {
                    data[i][j] = lista3.get(i).getNombreFamilia();
                    value++;}
                else if (j==4) {
                    data[i][j] = lista3.get(i).getCapacidadRAM();
                    value++;}
                else if (j==5) {
                    data[i][j] = lista3.get(i).getNumeroSticksRAM();
                    value++;}
                else if (j==6) {
                    data[i][j] = lista3.get(i).getTipoAlmacenamiento();
                    value++;}
                else if (j==7) {
                    data[i][j] = lista3.get(i).getTarjetaVideo();
                    value++;}
                else if (j==8) {
                    data[i][j] = lista3.get(i).getMonitor();
                    value++;}
                else if (j==9) {
                    data[i][j] = lista3.get(i).getPeso();
                    value++;}
                else if (j==10) {
                    data[i][j] = lista3.get(i).getBateria();
                    value++;}
                else if (j==11) {
                    data[i][j] = lista3.get(i).getFuentesDePoder();
                    value++;}
                else if (j==12) {
                    data[i][j] = lista3.get(i).getTarjetaMadre();
                    value++;}
                else if (j==13) {
                    data[i][j] = lista3.get(i).getProcesador();
                    value++;}

            }
        }
        return data;
    }

    /**
     * Funcion void de ingreso de datos para creacion de tabla
     */
    public void crearTabla(){
        List<MegaFamilia> lista3 = daoMegaFamilia.listAll();

        int c = daoMegaFamilia.listAll().size();

        Object[][] row=crearFilasTabla(c,lista3);

        String[] column = {"ID", "Nombre Familia Principal", "Nombre Subfamilia", "NombreFAM", "RAM","# Sticks","Tipo Almacenamiento","Tipo GPU","Monitor","Peso","Bateria","# Fuente Poder","Tarjeta Madre","Procesador"};


        table1.setModel(new DefaultTableModel(row, column));
    }

    /**
     *
     * @param t Generic Categoria Computadoras y todos sus familiares
     * @param nombre, nombre de la familia que se desea revelar
     */

    public void captarNombre(CategoriaComputadora t,String nombre) {
        if (!nombre.equals("nombre")) {
            if (nombre.isEmpty() == false) {
                t.setNombreFamilia(nombre);
            }
        }
    }

    /**
     *
     * @param t, Generic de componte, se envia cualquier hijo de componente
     * @param nombreFamilia, nombre de la familia en esencial
     * @param seleccion_familia, seleccion de la familia principal
     * @param seleccionRam, seleccion de ram de la familia a crear
     * @param seleccionNumeroStickss, numeros de sticks o rams para la tarjeta madre
     * @param seleccionAlmacenamiento, tipo de almacenamiento
     * Esta funcion es un tipo void que sirve para captar los datos de cada una de las familias
     */
    public void captarInfoGeneral(CategoriaComputadora t,String nombreFamilia, String seleccion_familia, String seleccionRam,int seleccionNumeroStickss,String seleccionAlmacenamiento) {

        t.setTipoPrincipalFamilia(seleccion_familia);
        captarNombre(t,nombreFamilia);
        t.setCapacidadRAM(seleccionRam);
        t.setNumeroSticksRAM(seleccionNumeroStickss);
        t.setTipoAlmacenamiento(seleccionAlmacenamiento);
        t.setTarjetaMadre(seleccion_familia);
        t.setProcesador(seleccion_familia);
    }

    /**
     *
     * @param t Generic Recibe cualquier tipo de Portable y sus hijos
     * @param pesoLetras, medicion del campo vacio en peso
     * @param pesokg, seleccion del cliente del peso a poner
     *
     *                Se analiza estos tres puntos para poder devolver o mantener el dato previo a actualizacion
     */
    public void captarPeso(Portable t,String pesoLetras,double pesokg) {
        if(pesoLetras.isEmpty()==false){
            pesokg=Double.parseDouble(peso.getText());
            if(pesokg!=0.0){
                t.setPeso(pesokg);}
        } else if (pesoLetras.isEmpty()==true) {
            JOptionPane.showMessageDialog(RegistrarFamiliaMn.this,"Espacio Vacio de Peso");
        }
    }

    /**
     *
     * @param t Generic del Tipo Portable e hijos
     * @param pesoLetras, revision del campo de peso si esta con letras o no
     * @param pesokg, peso que se desea
     * @param seleccionBateria, seleccion de la duracion bateria
     * @param seleccion_subfamilia, seleccion de la subfamilia
     */
    public void captarInfoPortables(Portable t,String pesoLetras,double pesokg,String seleccionBateria,String seleccion_subfamilia) {
        captarPeso(t,pesoLetras,pesokg);
        t.setBateria(seleccionBateria);
        t.setTipoSubFamilia(seleccion_subfamilia);
        t.setTarjetaMadre(seleccion_subfamilia);
        t.setProcesador(seleccion_subfamilia);
    }

    /**
     *
     * @param t Generic para Sobremesa y sus hijos
     * @param seleccionMonitor, seleccion de si desea monitor o no
     * @param seleccion_subfamilia, nombre de la subfamilia que pertenece
     *
     *                              funcion que sirve para poder captar el dato y devolverlo actulizado
     */
    public void captarInfoSobremesa(Sobremesa t,String seleccionMonitor,String seleccion_subfamilia) {
        t.setMonitor(seleccionMonitor);
        t.setTipoSubFamilia(seleccion_subfamilia);
        t.setTarjetaMadre(seleccion_subfamilia);
        t.setProcesador(seleccion_subfamilia);
    }


}
