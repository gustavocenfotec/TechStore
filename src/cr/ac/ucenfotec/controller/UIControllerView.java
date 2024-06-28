package cr.ac.ucenfotec.controller;

import cr.ac.ucenfotec.views.*;

public class UIControllerView {
    private Presentacion presentacion;

    private RegistrarComponenteMn registrarComponenteMn;


    private RegistrarFamiliaMn registrarFamiliaMn;



    private ArmarComponenteaFamiliaMn armarComponenteaFamiliaMn;

    private LoginPage loginPage;

    private Registro registro;

    /**
     * Constructor del view
     */
    public UIControllerView() {
        this.presentacion=new Presentacion();

    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }


    public RegistrarComponenteMn getRegistrarComponenteMn() {
        return registrarComponenteMn;
    }

    public void setRegistrarComponenteMn(RegistrarComponenteMn registrarComponenteMn) {
        this.registrarComponenteMn = registrarComponenteMn;
    }



    public RegistrarFamiliaMn getRegistrarFamiliaMn() {
        return registrarFamiliaMn;
    }

    public void setRegistrarFamiliaMn(RegistrarFamiliaMn registrarFamiliaMn) {
        this.registrarFamiliaMn = registrarFamiliaMn;
    }

    public ArmarComponenteaFamiliaMn getArmarComponenteaFamiliaMn() {
        return armarComponenteaFamiliaMn;
    }

    public void setArmarComponenteaFamiliaMn(ArmarComponenteaFamiliaMn armarComponenteaFamiliaMn) {
        this.armarComponenteaFamiliaMn = armarComponenteaFamiliaMn;
    }


    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}
