/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lys.beans;

/**
 *
 * @author dvillanueva
 */
public class SolicitudServicio {
    private String c_compania ;
    private int n_solicitud ;
    private String c_maquina ;
    private String  c_maquinanomb;
    private String c_ccosto ; 
    private String c_ccostonomb ;
    private String c_personasolicitud ;
    private String c_usuariosolicit ;
    private String c_prioridad  ;
    private String c_descriproblema ;
    private String c_descfalla ;
    private String c_estado ;
    private String c_fechareg ;
    private String c_tiposolcitud ;
    private String c_empleadosAsignados ;

    public SolicitudServicio() {
    }

    public SolicitudServicio(String c_compania, int n_solicitud, String c_maquina, String c_maquinanomb, String c_ccosto, String c_ccostonomb, String c_personasolicitud, String c_usuariosolicit, String c_prioridad, String c_descriproblema, String c_descfalla, String c_estado, String c_fechareg, String c_tiposolcitud, String c_empleadosAsignados) {
        this.c_compania = c_compania;
        this.n_solicitud = n_solicitud;
        this.c_maquina = c_maquina;
        this.c_maquinanomb = c_maquinanomb;
        this.c_ccosto = c_ccosto;
        this.c_ccostonomb = c_ccostonomb;
        this.c_personasolicitud = c_personasolicitud;
        this.c_usuariosolicit = c_usuariosolicit;
        this.c_prioridad = c_prioridad;
        this.c_descriproblema = c_descriproblema;
        this.c_descfalla = c_descfalla;
        this.c_estado = c_estado;
        this.c_fechareg = c_fechareg;
        this.c_tiposolcitud = c_tiposolcitud;
        this.c_empleadosAsignados = c_empleadosAsignados;
    }

    
    
    
    public String getC_empleadosAsignados() {
        return c_empleadosAsignados;
    }

    public void setC_empleadosAsignados(String c_empleadosAsignados) {
        this.c_empleadosAsignados = c_empleadosAsignados;
    }

    
    
    /**
     * @return the c_compania
     */
    public String getC_compania() {
        return c_compania;
    }

    /**
     * @param c_compania the c_compania to set
     */
    public void setC_compania(String c_compania) {
        this.c_compania = c_compania;
    }

    /**
     * @return the n_solicitud
     */
    public int getN_solicitud() {
        return n_solicitud;
    }

    /**
     * @param n_solicitud the n_solicitud to set
     */
    public void setN_solicitud(int n_solicitud) {
        this.n_solicitud = n_solicitud;
    }

    /**
     * @return the c_maquina
     */
    public String getC_maquina() {
        return c_maquina;
    }

    /**
     * @param c_maquina the c_maquina to set
     */
    public void setC_maquina(String c_maquina) {
        this.c_maquina = c_maquina;
    }

    /**
     * @return the c_maquinanomb
     */
    public String getC_maquinanomb() {
        return c_maquinanomb;
    }

    /**
     * @param c_maquinanomb the c_maquinanomb to set
     */
    public void setC_maquinanomb(String c_maquinanomb) {
        this.c_maquinanomb = c_maquinanomb;
    }

    /**
     * @return the c_ccosto
     */
    public String getC_ccosto() {
        return c_ccosto;
    }

    /**
     * @param c_ccosto the c_ccosto to set
     */
    public void setC_ccosto(String c_ccosto) {
        this.c_ccosto = c_ccosto;
    }

    /**
     * @return the c_ccostonomb
     */
    public String getC_ccostonomb() {
        return c_ccostonomb;
    }

    /**
     * @param c_ccostonomb the c_ccostonomb to set
     */
    public void setC_ccostonomb(String c_ccostonomb) {
        this.c_ccostonomb = c_ccostonomb;
    }

    /**
     * @return the c_personasolicitud
     */
    public String getC_personasolicitud() {
        return c_personasolicitud;
    }

    /**
     * @param c_personasolicitud the c_personasolicitud to set
     */
    public void setC_personasolicitud(String c_personasolicitud) {
        this.c_personasolicitud = c_personasolicitud;
    }

    /**
     * @return the c_usuariosolicit
     */
    public String getC_usuariosolicit() {
        return c_usuariosolicit;
    }

    /**
     * @param c_usuariosolicit the c_usuariosolicit to set
     */
    public void setC_usuariosolicit(String c_usuariosolicit) {
        this.c_usuariosolicit = c_usuariosolicit;
    }

    /**
     * @return the c_prioridad
     */
    public String getC_prioridad() {
        return c_prioridad;
    }

    /**
     * @param c_prioridad the c_prioridad to set
     */
    public void setC_prioridad(String c_prioridad) {
        this.c_prioridad = c_prioridad;
    }

    /**
     * @return the c_descriproblema
     */
    public String getC_descriproblema() {
        return c_descriproblema;
    }

    /**
     * @param c_descriproblema the c_descriproblema to set
     */
    public void setC_descriproblema(String c_descriproblema) {
        this.c_descriproblema = c_descriproblema;
    }

    /**
     * @return the c_descfalla
     */
    public String getC_descfalla() {
        return c_descfalla;
    }

    /**
     * @param c_descfalla the c_descfalla to set
     */
    public void setC_descfalla(String c_descfalla) {
        this.c_descfalla = c_descfalla;
    }

    /**
     * @return the c_estado
     */
    public String getC_estado() {
        return c_estado;
    }

    /**
     * @param c_estado the c_estado to set
     */
    public void setC_estado(String c_estado) {
        this.c_estado = c_estado;
    }

    /**
     * @return the c_fechareg
     */
    public String getC_fechareg() {
        return c_fechareg;
    }

    /**
     * @param c_fechareg the c_fechareg to set
     */
    public void setC_fechareg(String c_fechareg) {
        this.c_fechareg = c_fechareg;
    }
    public String getC_tiposolcitud() {
        return c_tiposolcitud;
    }

    public void setC_tiposolcitud(String c_tiposolcitud) {
        this.c_tiposolcitud = c_tiposolcitud;
    }
}
