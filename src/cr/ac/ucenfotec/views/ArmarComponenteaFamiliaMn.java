package cr.ac.ucenfotec.views;

import cr.ac.ucenfotec.dao.Componentes.DAOMegaComponente;
import cr.ac.ucenfotec.dao.Componentes.DAORam;
import cr.ac.ucenfotec.dao.CompuArmada.DAOCompuArmada;
import cr.ac.ucenfotec.entity.models.ArmadoComputadora.ArmadoComputadora;
import cr.ac.ucenfotec.entity.models.componentes.Componente;
import cr.ac.ucenfotec.entity.models.componentes.MegaComponente;
import cr.ac.ucenfotec.entity.models.famCompu.MegaFamilia;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ArmarComponenteaFamiliaMn extends JFrame {


    private DAOCompuArmada daoCompuArmada;
    private DAORam daoRam;
    private MegaComponente megaComponente;

    private DAOMegaComponente daoMegaComponente;

    private ArmadoComputadora armadoComputadora;

    private JPanel ArComFAMn;
    private JComboBox FamiliasPrincipales;
    private JComboBox SubFamilias;
    private JComboBox RAM;
    private JComboBox numeroSticks;
    private JComboBox Almacenamiento;
    private JComboBox tipoGPU;
    private JComboBox tarjetaMadre;
    private JComboBox procesador;
    private JComboBox Monitor;
    private JComboBox bateria;
    private JComboBox fuentePoder;
    private JButton registrarButton;
    private JButton volverAMenuButton;
    private JTable table1;
    private JButton modificarComputadoraButton;
    private JButton eliminarComputadoraButton;
    private JTextField obtenerID;

    public ArmarComponenteaFamiliaMn() {

        this.armadoComputadora= new ArmadoComputadora();
        this.daoMegaComponente = new DAOMegaComponente();
        this.megaComponente = new MegaComponente();

        this.daoCompuArmada = new DAOCompuArmada();
        setContentPane(ArComFAMn);
        setTitle("Round Rock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);


        List<MegaComponente> listaMegaComponentes = daoMegaComponente.listAll();
        opcionesInicio();
        crearTabla();



        registrarButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento de registro, el cual se encarga de captura de datos de los objetos
             *          y envio a base de datos
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String seleccion_familia, seleccion_subfamilia, seleccionRam, seleccionAlmacenamiento, seleccionTipoGPU, seleccionNumeroSticks, seleccionMonitor, seleccionFuentePoder, seleccionBateria, seleccionTarjetaMadre, seleccionProcesador;
                int seleccionNumeroStickss, seleccionFuentePoders;

                seleccion_familia = ((String) FamiliasPrincipales.getSelectedItem());
                seleccion_subfamilia = ((String) SubFamilias.getSelectedItem());
                seleccionRam = ((String) RAM.getSelectedItem());
                seleccionAlmacenamiento = ((String) Almacenamiento.getSelectedItem());
                seleccionTipoGPU = ((String) tipoGPU.getSelectedItem());
                seleccionNumeroSticks = ((String) numeroSticks.getSelectedItem());
                seleccionNumeroStickss = Integer.parseInt(seleccionNumeroSticks);
                seleccionMonitor = ((String) Monitor.getSelectedItem());
                seleccionFuentePoder = ((String) fuentePoder.getSelectedItem());
                seleccionFuentePoders = Integer.parseInt(seleccionFuentePoder);
                seleccionBateria = ((String) bateria.getSelectedItem());
                seleccionTarjetaMadre = ((String) tarjetaMadre.getSelectedItem());
                seleccionProcesador = ((String) procesador.getSelectedItem());

                switch (seleccion_familia) {
                    case ("Escolares"):
                        JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Familia Principal:" + seleccion_familia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador + " Y no admite tarjeta de Video ");

                        ArmadoComputadora es = new ArmadoComputadora();
                        es.setTipoPrincipalFamilia(seleccion_familia);
                        es.setCapacidadRAM(seleccionRam);
                        es.setNumeroSticksRAM(seleccionNumeroStickss);
                        es.setTipoAlmacenamiento(seleccionAlmacenamiento);
                        es.setTarjetaMadre(seleccionTarjetaMadre);
                        es.setProcesador(seleccionProcesador);
                        int id = daoCompuArmada.create(es);
                        System.out.println("El id en el sistema es" + id);
                        break;
                    case ("Sobremesa"):
                        switch (seleccion_subfamilia) {
                            case ("Oficina"):
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Principal: " + seleccion_subfamilia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " el cliente eligio llevar monitor : " + seleccionMonitor + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador + " Y no admite tarjeta de Video ");
                                ArmadoComputadora of = new ArmadoComputadora();
                                of.setTipoPrincipalFamilia(seleccion_familia);
                                of.setTipoSubFamilia(seleccion_subfamilia);
                                of.setCapacidadRAM(seleccionRam);
                                of.setNumeroSticksRAM(seleccionNumeroStickss);
                                of.setTipoAlmacenamiento(seleccionAlmacenamiento);
                                of.setMonitor(seleccionMonitor);
                                of.setTarjetaMadre(seleccionTarjetaMadre);
                                of.setProcesador(seleccionProcesador);
                                id = daoCompuArmada.create(of);
                                System.out.println("El id en el sistema es" + id);

                                break;
                            case ("Gaming"):
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Principal: " + seleccion_subfamilia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " el cliente eligio llevar monitor : " + seleccionMonitor + " Y decidio llevar la siguiente tarjeta de Video " + seleccionTipoGPU + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador);
                                ArmadoComputadora ga = new ArmadoComputadora();
                                ga.setTipoPrincipalFamilia(seleccion_familia);
                                ga.setTipoSubFamilia(seleccion_subfamilia);
                                ga.setCapacidadRAM(seleccionRam);
                                ga.setNumeroSticksRAM(seleccionNumeroStickss);
                                ga.setTipoAlmacenamiento(seleccionAlmacenamiento);
                                ga.setMonitor(seleccionMonitor);
                                ga.setTarjetaVideo(seleccionTipoGPU);
                                ga.setTarjetaMadre(seleccionTarjetaMadre);
                                ga.setProcesador(seleccionProcesador);
                                id = daoCompuArmada.create(ga);
                                System.out.println("El id en el sistema es" + id);

                                break;
                            case ("Workstation"):
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Principal: " + seleccion_subfamilia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " el cliente eligio llevar monitor : " + seleccionMonitor + " Y decidio llevar la siguiente tarjeta de Video " + seleccionTipoGPU + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador);
                                ArmadoComputadora wo = new ArmadoComputadora();
                                wo.setTipoPrincipalFamilia(seleccion_familia);
                                wo.setTipoSubFamilia(seleccion_subfamilia);
                                wo.setCapacidadRAM(seleccionRam);
                                wo.setNumeroSticksRAM(seleccionNumeroStickss);
                                wo.setTipoAlmacenamiento(seleccionAlmacenamiento);
                                wo.setMonitor(seleccionMonitor);
                                wo.setTarjetaVideo(seleccionTipoGPU);
                                wo.setTarjetaMadre(seleccionTarjetaMadre);
                                wo.setProcesador(seleccionProcesador);
                                id = daoCompuArmada.create(wo);
                                System.out.println("El id en el sistema es" + id);

                                break;
                        }
                        break;
                    case ("Portables"):
                        switch (seleccion_subfamilia) {
                            case ("Casa"):
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Principal: " + seleccion_subfamilia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " con una bateria de una duracion de : " + seleccionBateria + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador + " Y no admite tarjeta de Video ");
                                ArmadoComputadora ca = new ArmadoComputadora();
                                ca.setTipoPrincipalFamilia(seleccion_familia);
                                ca.setTipoSubFamilia(seleccion_subfamilia);
                                ca.setCapacidadRAM(seleccionRam);
                                ca.setNumeroSticksRAM(seleccionNumeroStickss);
                                ca.setTipoAlmacenamiento(seleccionAlmacenamiento);
                                ca.setBateria(seleccionBateria);
                                ca.setTarjetaMadre(seleccionTarjetaMadre);
                                ca.setProcesador(seleccionProcesador);
                                id = daoCompuArmada.create(ca);
                                System.out.println("El id en el sistema es" + id);
                                break;
                            case ("Trabajo"):
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Principal: " + seleccion_subfamilia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " tiene una tarjeta de Video de: " + seleccionTipoGPU + " con una bateria de una duracion de : " + seleccionBateria + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador);
                                ArmadoComputadora wo = new ArmadoComputadora();
                                wo.setTipoPrincipalFamilia(seleccion_familia);
                                wo.setTipoSubFamilia(seleccion_subfamilia);
                                wo.setCapacidadRAM(seleccionRam);
                                wo.setNumeroSticksRAM(seleccionNumeroStickss);
                                wo.setTipoAlmacenamiento(seleccionAlmacenamiento);
                                wo.setTarjetaVideo(seleccionTipoGPU);
                                wo.setBateria(seleccionBateria);
                                wo.setTarjetaMadre(seleccionTarjetaMadre);
                                wo.setProcesador(seleccionProcesador);
                                id = daoCompuArmada.create(wo);
                                System.out.println("El id en el sistema es" + id);
                                break;
                        }
                        break;

                    case ("Servidores"):
                        JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Principal:" + seleccion_familia + " Con una RAM de: " + seleccionRam + " con un numero de sticks de :" + seleccionNumeroSticks + " Un almacenamiento de: " + seleccionAlmacenamiento + " con un numero de Fuentes de Poder de: " + seleccionFuentePoder + " Tiene una Tarjeta Madre: " + seleccionTarjetaMadre + " Tiene un procesador: " + seleccionProcesador + " Y no admite tarjeta de Video ");
                        ArmadoComputadora ser = new ArmadoComputadora();
                        ser.setTipoPrincipalFamilia(seleccion_familia);
                        ser.setCapacidadRAM(seleccionRam);
                        ser.setNumeroSticksRAM(seleccionNumeroStickss);
                        ser.setTipoAlmacenamiento(seleccionAlmacenamiento);
                        ser.setFuentesDePoder(seleccionFuentePoders);
                        ser.setTarjetaMadre(seleccionTarjetaMadre);
                        ser.setProcesador(seleccionProcesador);
                        id = daoCompuArmada.create(ser);
                        System.out.println("El id en el sistema es" + id);
                        break;
                }
                crearTabla();
            }
        });
        volverAMenuButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento de boton de volver a menu
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuAdministrador();
            }
        });
        FamiliasPrincipales.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento del combobox de Familia principal y representacion de datos
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenedorFamilia = ((String) FamiliasPrincipales.getSelectedItem());


                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Familia:" + contenedorFamilia);
                switch (contenedorFamilia) {
                    case ("Escolares"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //INICIO DE SELECCION DE APARTADOS

                        String[] RAMDeseadoES=ram4GB8GB16GB (listaMegaComponentes);
//                        String[] RAMDeseadoES ={"4 GB","8 GB","16 GB"};
//                        String AlmacenamientoDeseadoES[] = {"1TB HDD", "128GB SSD"};
                        String AlmacenamientoDeseadoES[] =almacenamiento1TBHDD128GBSSD(listaMegaComponentes);
                        String SticksDeseadoES[] = {"1", "2"};

                        String procesadorES[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreES[]=mostrarTarjetaMadre(listaMegaComponentes);


                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoES));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoES));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadoES));

                        procesador.setModel(new DefaultComboBoxModel(procesadorES));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreES));

                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        numeroSticks.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;
                    case ("Sobremesa"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String SubFamiliasDeseadasSM[] = {"Oficina", "Gaming", "Workstation"};
                        SubFamilias.setModel(new DefaultComboBoxModel(SubFamiliasDeseadasSM));
                        SubFamilias.setVisible(true);
                        break;
                    case ("Portables"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //INICIO DE SELECCION DE APARTADOS
                        String proteccionSubFamiliasPO[] = {"Casa", "Trabajo"};
                        SubFamilias.setModel(new DefaultComboBoxModel(proteccionSubFamiliasPO));
                        SubFamilias.setVisible(true);
                        break;
                    case ("Servidores"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionFamilia();
                        //QUE PUEDE OBSERVAR
                        String RAMDeseadoSE[] = ram64GB128GB256GB512GB1024GB (listaMegaComponentes);
//                        String RAMDeseadoSE[] = {"64 GB", "128 GB", "256 GB", "512 GB", "1024 GB"};
                        String SticksDeseadoSE[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
//                        String AlmacenamientoDeseadoSE[] = {"32 TB", "64 TB", "128 TB"};
                        String AlmacenamientoDeseadoSE[] =almacenamiento32TB64TB128TB(listaMegaComponentes);
                        String fuentePoderDeseadoSE[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
                        String procesadorSE[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreSE[]=mostrarTarjetaMadre(listaMegaComponentes);


                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoSE));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoSE));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadoSE));
                        fuentePoder.setModel(new DefaultComboBoxModel(fuentePoderDeseadoSE));
                        procesador.setModel(new DefaultComboBoxModel(procesadorSE));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreSE));


                        RAM.setVisible(true);
                        numeroSticks.setVisible(true);
                        Almacenamiento.setVisible(true);
                        fuentePoder.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;
                }
            }
        });
        SubFamilias.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, Evento de Muestra de Elecciones y generaccion de partes componentes
             *          segun las reglas de negocio por medio de las funciones de creacion por medio de condiciones
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenedorSubFamilia = ((String) SubFamilias.getSelectedItem());


                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, "Familia:" + contenedorSubFamilia);

                switch (contenedorSubFamilia) {
                    case ("Oficina"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //INICIO DE SELECCION DE APARTADOS
//                        String RAMDeseadoOF[] = {"8 GB", "16 GB"};
                        String RAMDeseadoOF[] =ram8GB16GB (listaMegaComponentes);
//                      String AlmacenamientoDeseadoOF[] = {"256GB SSD"};
                        String AlmacenamientoDeseadoOF[] = almacenamiento256TB(listaMegaComponentes);
                        String SticksDeseadoOF[] = {"1", "2"};
                        String procesadorOF[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreOF[]=mostrarTarjetaMadre(listaMegaComponentes);

                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoOF));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoOF));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadoOF));
                        procesador.setModel(new DefaultComboBoxModel(procesadorOF));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreOF));


                        RAM.setVisible(true);
                        numeroSticks.setVisible(true);
                        Almacenamiento.setVisible(true);
                        Monitor.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;

                    case ("Gaming"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //INICIO DE SELECCION DE APARTADOS

//                        String RAMDeseadoGA[] = {"16 GB", "24 GB", "32 GB"};
                        String RAMDeseadoGA[]=ram16GB24GB32GB(listaMegaComponentes);

//                        String AlmacenamientoDeseadoGA[] = {"1TB HDD", "2TB HDD", "256GB SSD", "512GB SSD", "1 TB SSD"};
                        String AlmacenamientoDeseadoGA[] =almacenamiento1TBHDD2TBHDD256GBSSD512GBSSD1TBSSD(listaMegaComponentes);

                        String SticksDeseadGA[] = {"1", "2", "3", "4"};

//                        String TarjetaVideoDeseadoGA[] = {"GPU calculo científico", " GPU renderizado", " GPU homeworking"};
                        String TarjetaVideoDeseadoGA[]=mostrarGPU(listaMegaComponentes);

                        String procesadorGA[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreGA[]=mostrarTarjetaMadre(listaMegaComponentes);

                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoGA));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoGA));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadGA));
                        tipoGPU.setModel(new DefaultComboBoxModel(TarjetaVideoDeseadoGA));
                        procesador.setModel(new DefaultComboBoxModel(procesadorGA));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreGA));





                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        tipoGPU.setVisible(true);
                        numeroSticks.setVisible(true);
                        Monitor.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;

                    case ("Workstation"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //INICIO DE SELECCION DE APARTADOS
//                        String RAMDeseadoWS[] = {"32 GB", "64 GB"};
                        String RAMDeseadoWS[]=ram32GB64GB(listaMegaComponentes);
//                        String AlmacenamientoDeseadoWS[] = {"1TB HDD", "2TB HDD", "256GB SSD", "512GB SSD", "1 TB SSD"};
                        String AlmacenamientoDeseadoWS[]=almacenamiento1TBHDD2TBHDD256GBSSD512GBSSD1TBSSD(listaMegaComponentes);

                        String SticksDeseadWS[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

//                        String TarjetaVideoDeseadoWS[] = {"GPU calculo científico", " GPU renderizado", " GPU homeworking"};
                        String TarjetaVideoDeseadoWS[]=mostrarGPU(listaMegaComponentes);

                        String procesadorWS[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreWS[]=mostrarTarjetaMadre(listaMegaComponentes);



                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoWS));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoWS));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadWS));
                        tipoGPU.setModel(new DefaultComboBoxModel(TarjetaVideoDeseadoWS));
                        procesador.setModel(new DefaultComboBoxModel(procesadorWS));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreWS));




                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        tipoGPU.setVisible(true);
                        numeroSticks.setVisible(true);
                        Monitor.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;

                    case ("Casa"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        // OBSERVAR EL CAMBIO
//                        String RAMDeseadoCS[] = {"8 GB", "16 GB"};
                        String RAMDeseadoCS[]=ram8GB16GB (listaMegaComponentes);
//                        String AlmacenamientoDeseadoCS[] = {"256GB SSD", "512GB SSD"};
                        String AlmacenamientoDeseadoCS[] =almacenamiento256GBSSD512GBSSD(listaMegaComponentes);
                        String SticksDeseadCS[] = {"1", "2"};

                        String procesadorCS[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreCS[]=mostrarTarjetaMadre(listaMegaComponentes);


//                        String BateriaDeseadaCS[] = {"8 horas", "10 horas"};
                        String BateriaDeseadaCS[] =duracion8hrs10hrs(listaMegaComponentes);

                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoCS));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoCS));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadCS));
                        bateria.setModel(new DefaultComboBoxModel(BateriaDeseadaCS));

                        procesador.setModel(new DefaultComboBoxModel(procesadorCS));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreCS));


                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        numeroSticks.setVisible(true);
                        bateria.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;

                    case ("Trabajo"):
                        //Funcion de visualizacion de Opciones
                        setGeneralVisualizacionSubFamilia();
                        //QUE PUEDE OBSERVAR
//                        String RAMDeseadoTR[] = {"8 GB", "16 GB"};
                        String RAMDeseadoTR[]=ram8GB16GB (listaMegaComponentes);

//                        String AlmacenamientoDeseadoTR[] = {"256GB SSD", "512GB SSD"};
                        String AlmacenamientoDeseadoTR[] =almacenamiento256GBSSD512GBSSD(listaMegaComponentes);

                        String SticksDeseadTR[] = {"1", "2"};

//                        String TarjetaVideoDeseadaTR[] = {"GPU calculo científico", " GPU renderizado", " GPU homeworking"};
                        String TarjetaVideoDeseadaTR[]=mostrarGPU(listaMegaComponentes);

//                        String BateriaDeseadaTR[] = {"8 horas", "10 horas", "16 horas"};
                        String BateriaDeseadaTR[] =duracion8hrs10hrs16hrs(listaMegaComponentes);


                        String procesadorTR[]=mostrarProcesador(listaMegaComponentes);
                        String tarjetaMadreTR[]=mostrarTarjetaMadre(listaMegaComponentes);


                        RAM.setModel(new DefaultComboBoxModel(RAMDeseadoTR));
                        Almacenamiento.setModel(new DefaultComboBoxModel(AlmacenamientoDeseadoTR));
                        numeroSticks.setModel(new DefaultComboBoxModel(SticksDeseadTR));
                        bateria.setModel(new DefaultComboBoxModel(BateriaDeseadaTR));
                        tipoGPU.setModel(new DefaultComboBoxModel(TarjetaVideoDeseadaTR));
                        procesador.setModel(new DefaultComboBoxModel(procesadorTR));
                        tarjetaMadre.setModel(new DefaultComboBoxModel(tarjetaMadreTR));

                        RAM.setVisible(true);
                        Almacenamiento.setVisible(true);
                        tipoGPU.setVisible(true);
                        numeroSticks.setVisible(true);
                        bateria.setVisible(true);
                        tarjetaMadre.setVisible(true);
                        procesador.setVisible(true);
                        break;
                }
            }
        });
        modificarComputadoraButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento de Captura de Modificar por medio de id del objeto previamente
             *          elegido
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String seleccion_familia, seleccion_subfamilia, seleccionRam, seleccionAlmacenamiento, seleccionTipoGPU, seleccionNumeroSticks, seleccionMonitor, seleccionFuentePoder, seleccionBateria, seleccionTarjetaMadre, seleccionProcesador;
                int seleccionNumeroStickss, seleccionFuentePoders,idArmado;

                seleccion_familia = ((String) FamiliasPrincipales.getSelectedItem());
                seleccion_subfamilia = ((String) SubFamilias.getSelectedItem());
                seleccionRam = ((String) RAM.getSelectedItem());
                seleccionAlmacenamiento = ((String) Almacenamiento.getSelectedItem());
                seleccionTipoGPU = ((String) tipoGPU.getSelectedItem());
                seleccionNumeroSticks = ((String) numeroSticks.getSelectedItem());
                seleccionNumeroStickss = Integer.parseInt(seleccionNumeroSticks);
                seleccionMonitor = ((String) Monitor.getSelectedItem());
                seleccionFuentePoder = ((String) fuentePoder.getSelectedItem());
                seleccionFuentePoders = Integer.parseInt(seleccionFuentePoder);
                seleccionBateria = ((String) bateria.getSelectedItem());
                seleccionTarjetaMadre = ((String) tarjetaMadre.getSelectedItem());
                seleccionProcesador = ((String) procesador.getSelectedItem());
                idArmado=Integer.parseInt(obtenerID.getText());

                switch (seleccion_familia) {
                    case ("Escolares"):
                        armadoComputadora= daoCompuArmada.read(idArmado);
                        captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                        daoCompuArmada.update(armadoComputadora);
                        JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, " Se actualizo la computadora deseada con el id: " +idArmado);
                        break;
                    case ("Sobremesa"):
                        switch (seleccion_subfamilia) {
                            case ("Oficina"):

                                armadoComputadora= daoCompuArmada.read(idArmado);
                                captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                                armadoComputadora.setTipoSubFamilia(seleccion_subfamilia);
                                armadoComputadora.setMonitor(seleccionMonitor);
                                daoCompuArmada.update(armadoComputadora);
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, " Se actualizo la computadora deseada con el id: " +idArmado);

                                break;
                            case ("Gaming"):

                                armadoComputadora= daoCompuArmada.read(idArmado);
                                captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                                armadoComputadora.setTipoSubFamilia(seleccion_subfamilia);
                                armadoComputadora.setMonitor(seleccionMonitor);
                                armadoComputadora.setTarjetaVideo(seleccionTipoGPU);
                                daoCompuArmada.update(armadoComputadora);


                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, " Se actualizo la computadora deseada con el id: " +idArmado);


                                break;
                            case ("Workstation"):
                                armadoComputadora= daoCompuArmada.read(idArmado);
                                captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                                armadoComputadora.setTipoSubFamilia(seleccion_subfamilia);
                                armadoComputadora.setMonitor(seleccionMonitor);
                                armadoComputadora.setTarjetaVideo(seleccionTipoGPU);
                                daoCompuArmada.update(armadoComputadora);
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, " Se actualizo la computadora deseada con el id: " +idArmado);

                                break;
                        }
                        break;
                    case ("Portables"):
                        switch (seleccion_subfamilia) {
                            case ("Casa"):
                                armadoComputadora= daoCompuArmada.read(idArmado);
                                captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                                armadoComputadora.setTipoSubFamilia(seleccion_subfamilia);
                                armadoComputadora.setBateria(seleccionBateria);
                                daoCompuArmada.update(armadoComputadora);
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, " Se actualizo la computadora deseada con el id: " +idArmado);


                                break;
                            case ("Trabajo"):
                                armadoComputadora= daoCompuArmada.read(idArmado);
                                captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                                armadoComputadora.setTipoSubFamilia(seleccion_subfamilia);
                                armadoComputadora.setTarjetaVideo(seleccionTipoGPU);
                                armadoComputadora.setBateria(seleccionBateria);
                                daoCompuArmada.update(armadoComputadora);
                                JOptionPane.showMessageDialog(ArmarComponenteaFamiliaMn.this, " Se actualizo la computadora deseada con el id: " +idArmado);

                                break;
                        }
                        break;

                    case ("Servidores"):
                        armadoComputadora= daoCompuArmada.read(idArmado);
                        captarInformacion(armadoComputadora, seleccion_familia,seleccionRam,seleccionNumeroStickss,seleccionAlmacenamiento,seleccionTarjetaMadre,seleccionProcesador);
                        armadoComputadora.setFuentesDePoder(seleccionFuentePoders);
                        daoCompuArmada.update(armadoComputadora);
                        break;
                }
                crearTabla();


            }
        });
        eliminarComputadoraButton.addActionListener(new ActionListener() {
            /**
             *
             * @param e the event to be processed, evento de Realizar la accion de eliminar
             *          Se busca por id para poder eliminar
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(obtenerID.getText());
                System.out.println("Delete");
                ArmadoComputadora c = new ArmadoComputadora();
                c.setId(id);
                System.out.println("R/");
                System.out.println(daoCompuArmada.delete(c));
                crearTabla();
            }
        });
    }

    /**
     * Void que se realiza al momento de elegir la familia principal
     */
    public void setGeneralVisualizacionFamilia() {
        SubFamilias.setVisible(false);
        RAM.setVisible(false);
        Almacenamiento.setVisible(false);
        tipoGPU.setVisible(false);
        numeroSticks.setVisible(false);
        Monitor.setVisible(false);
        fuentePoder.setVisible(false);
        bateria.setVisible(false);
        tarjetaMadre.setVisible(false);
        procesador.setVisible(false);

    }

    /**
     * Void que interpone la visualizacion desead al momento de elegir el combobox de Subfamilia
     */

    public void setGeneralVisualizacionSubFamilia() {
        RAM.setVisible(false);
        Almacenamiento.setVisible(false);
        tipoGPU.setVisible(false);
        numeroSticks.setVisible(false);
        Monitor.setVisible(false);
        tarjetaMadre.setVisible(false);
        procesador.setVisible(false);
    }

    /**
     *
     * @param c Tamano de la lista
     * @param lista3 lista con todo el contenido de base de datos
     * @return  Object[][] que es el array bidimensional de la lista y para creacion de filas
     */
    public Object[][] crearFilasTabla(int c, List<ArmadoComputadora> lista3) {
        Object[][] data = new Object[c][12];

        int value = 1;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 12; j++) {
                if (j == 0) {
                    data[i][j] = lista3.get(i).getId();
                    value++;
                } else if (j == 1) {
                    data[i][j] = lista3.get(i).getTipoPrincipalFamilia();
                    value++;
                } else if (j == 2) {
                    data[i][j] = lista3.get(i).getTipoSubFamilia();
                    value++;
                } else if (j == 3) {
                    data[i][j] = lista3.get(i).getCapacidadRAM();
                    value++;
                } else if (j == 4) {
                    data[i][j] = lista3.get(i).getNumeroSticksRAM();
                    value++;
                } else if (j == 5) {
                    data[i][j] = lista3.get(i).getTipoAlmacenamiento();
                    value++;
                } else if (j == 6) {
                    data[i][j] = lista3.get(i).getTarjetaVideo();
                    value++;
                } else if (j == 7) {
                    data[i][j] = lista3.get(i).getMonitor();
                    value++;
                } else if (j == 8) {
                    data[i][j] = lista3.get(i).getBateria();
                    value++;
                } else if (j == 9) {
                    data[i][j] = lista3.get(i).getTarjetaMadre();
                    value++;
                } else if (j == 10) {
                    data[i][j] = lista3.get(i).getProcesador();
                    value++;
                } else if (j == 11) {
                    data[i][j] = lista3.get(i).getFuentesDePoder();
                    value++;
                }

            }
        }
        return data;
    }
    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente RAM 4 GB 8 GB 16 GB
     *                             512 GB 1024 GB
     *
     * @return retorna el array con los rams
     */

    public String[] ram4GB8GB16GB (List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadRam().equals("4 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("8 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("16 GB")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadRam()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] RAMDeseadoES = arr.toArray(new String[arr.size()]);

        return RAMDeseadoES;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente RAM 64 GB 128 GB 256 GB
     *                             512 GB 1024 GB
     *
     * @return retorna el array con los rams
     */


    public String[] ram64GB128GB256GB512GB1024GB (List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadRam().equals("64 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("128 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("256 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("512 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("1024 GB")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadRam()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] RAMDeseado = arr.toArray(new String[arr.size()]);

        return RAMDeseado;
    }
    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente RAM 8 GB 16 GB
     *
     * @return retorna el array con los rams
     */

    public String[] ram8GB16GB (List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadRam().equals("8 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("16 GB")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadRam()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] RAMDeseado = arr.toArray(new String[arr.size()]);

        return RAMDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente RAM 16 GB 32 GB 64 GB
     *
     * @return retorna el array con los rams
     */

    public String[] ram16GB24GB32GB(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadRam().equals("16 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("24 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("32 GB")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadRam()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] RAMDeseado = arr.toArray(new String[arr.size()]);

        return RAMDeseado;
    }
    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente RAM 32 GB 64 GB
     *
     * @return retorna el array con los rams
     */

    public String[] ram32GB64GB(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadRam().equals("32 GB")||
                    listaMegaComponentes.get(i).getCapacidadRam().equals("64 GB")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadRam()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] RAMDeseado = arr.toArray(new String[arr.size()]);

        return RAMDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente almacenamiento 1TB HDD 128GB SSD
     *
     * @return retorna el array con los Almacenamientos
     */


    public String[] almacenamiento1TBHDD128GBSSD(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("1TB HDD")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("128GB SSD")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadAlmacenamiento()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente almacenamiento 32 TB 64 TB 128 TB
     *
     * @return retorna el array con los Almacenamientos
     */


    public String[] almacenamiento32TB64TB128TB(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("32 TB")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("64 TB")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("128 TB")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadAlmacenamiento()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente almacenamiento 256GB SSD
     *
     * @return retorna el array con los Almacenamientos
     */

    public String[] almacenamiento256TB(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("256GB SSD")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadAlmacenamiento()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);
            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente almacenamiento 1TB HDD 2TB HDD
     *                             256GB SSD 512GB SSD 1TB SSD
     *
     * @return retorna el array con los Almacenamientos
     */
//    String AlmacenamientoDeseadoGA[]={"1TB HDD","2TB HDD","256GB SSD", "512GB SSD","1 TB SSD"};
    public String[] almacenamiento1TBHDD2TBHDD256GBSSD512GBSSD1TBSSD(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("1TB HDD")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("2TB HDD")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("256GB SSD")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("512GB SSD")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("1 TB SSD")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadAlmacenamiento()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);

            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }
    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente almacenamiento 256GB SSD 512GB SSD
     *
     * @return retorna el array con los Almacenamientos
     */

    public String[] almacenamiento256GBSSD512GBSSD(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("256GB SSD")||
                    listaMegaComponentes.get(i).getCapacidadAlmacenamiento().equals("512GB SSD")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getCapacidadAlmacenamiento()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);
            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             los cuales tiene en su nombre componente Tarjeta de video
     *
     * @return retorna el array con los Tarjeta de Video
     */

    public String[] mostrarGPU(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getNombreComponente().equals("TarjetaVideo")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getTipoGPU()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);
            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }
    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             se realiza una condicion para poder enviar todas las duraciones de
     *                             8,10 horas de bateria
     *
     * @return retorna el array con los bateria
     */

    public String[] duracion8hrs10hrs(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getDuracion().equals("8 horas")||
                    listaMegaComponentes.get(i).getDuracion().equals("10 horas")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getDuracion()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);
            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }
    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             se realiza una condicion para poder enviar todas las duraciones de
     *                             8,10,16 horas de bateria
     *
     * @return retorna el array con los bateria
     */
    public String[] duracion8hrs10hrs16hrs(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getDuracion().equals("8 horas")||
                    listaMegaComponentes.get(i).getDuracion().equals("10 horas")||
            listaMegaComponentes.get(i).getDuracion().equals("16 horas")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getDuracion()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);
            }
        }

        String[] almacenamientoDeseado = arr.toArray(new String[arr.size()]);

        return almacenamientoDeseado;
    }

    /**
     *
     * @param listaMegaComponentes lista de todos los componentes
     *                             se realiza una condicion para poder enviar todos los procesadores
     *
     * @return retorna el array con los procesadores
     */
    public String[] mostrarProcesador(List<MegaComponente>listaMegaComponentes){

    List<String> arr = new ArrayList<String>();

    for (int i = 0; i < listaMegaComponentes.size(); i++) {
        if (listaMegaComponentes.get(i).getNombreComponente().equals("Procesador")) {
            String palabra_ingresar="";
            palabra_ingresar=(listaMegaComponentes.get(i).getTipoGPU()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
            arr.add(palabra_ingresar);
        }
    }

    String[] procesadores = arr.toArray(new String[arr.size()]);

    return procesadores;
}

    /**
     *
     * @param listaMegaComponentes, Este envia toda la lista de componentes para poder mostrarlos
     *                              los cuales deberan ser de Tarjeta Madre
     * @return
     */

    public String[] mostrarTarjetaMadre(List<MegaComponente>listaMegaComponentes){

        List<String> arr = new ArrayList<String>();

        for (int i = 0; i < listaMegaComponentes.size(); i++) {
            if (listaMegaComponentes.get(i).getNombreComponente().equals("TarjetaMadre")) {
                String palabra_ingresar="";
                palabra_ingresar=(listaMegaComponentes.get(i).getTipoGPU()+" "+listaMegaComponentes.get(i).getNombre()+" "+listaMegaComponentes.get(i).getPrecio());
                arr.add(palabra_ingresar);
            }
        }

        String[] tarjetaMadres = arr.toArray(new String[arr.size()]);

        return tarjetaMadres;
    }

    /**
     * Creacion de Tabla por medio de un void, el cual recibe la listado de computadoras previamente armadas para
     * visualizar
     */
    public void crearTabla(){
        List<ArmadoComputadora> lista3 = daoCompuArmada.listAll();

        int c = daoCompuArmada.listAll().size();

        Object[][] row = crearFilasTabla(c, lista3);

        String[] column = {"CODIGO", "FamiliaPrincipal", "SubFAmilia", "RAM", "Numeros de Sticks", "ALMACENAMIENTO", "GPU", "MONITOR", "BATERIA", "TMADRE", "PROCESADOR", "FUENTE PODER"};


        table1.setModel(new DefaultTableModel(row, column));
    }

    /**
     * Void de generacion de primera vista del menu deseado
     */
    public void opcionesInicio(){
        RAM.setVisible(false);
        numeroSticks.setVisible(false);
        Almacenamiento.setVisible(false);
        fuentePoder.setVisible(false);
        tarjetaMadre.setVisible(false);
        procesador.setVisible(false);
        SubFamilias.setVisible(false);
        Monitor.setVisible(false);
        tipoGPU.setVisible(false);
        bateria.setVisible(false);


    }

    /**
     *
     * @param t Objeto Armado computadora
     * @param seleccion_familia seleccion de la familia
     * @param seleccionRam ram deseado
     * @param seleccionNumeroStickss numeros de sticks de ram
     * @param seleccionAlmacenamiento almacenamiento de la computadora deseada
     * @param seleccionTarjetaMadre seleccion de tarjeta madre
     * @param seleccionProcesador seleccion procesador
     *
     *                            este apartado captura toda dicha inforamacion generalizada
     */
    public void captarInformacion(ArmadoComputadora t, String seleccion_familia, String seleccionRam, int seleccionNumeroStickss, String seleccionAlmacenamiento, String seleccionTarjetaMadre,String seleccionProcesador){
        t.setTipoPrincipalFamilia(seleccion_familia);
        t.setCapacidadRAM(seleccionRam);
        t.setNumeroSticksRAM(seleccionNumeroStickss);
        t.setTipoAlmacenamiento(seleccionAlmacenamiento);
        t.setTarjetaMadre(seleccionTarjetaMadre);
        t.setProcesador(seleccionProcesador);
    }




}


