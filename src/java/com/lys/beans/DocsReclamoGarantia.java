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
public class DocsReclamoGarantia {
    private String  c_compania ;
    private int n_numero;
    private int n_linea ;
    private String c_descripcion ;
    private String c_nombre_archivo;
    private  String c_ruta_archivo;
    private  String c_ultimousuario;
    private  String d_ultimafechamodificacion ;

    public DocsReclamoGarantia() {
    }

    public DocsReclamoGarantia(String c_compania, int n_numero, int n_linea, String c_descripcion, String c_nombre_archivo, String c_ruta_archivo, String c_ultimousuario, String d_ultimafechamodificacion) {
        this.c_compania = c_compania;
        this.n_numero = n_numero;
        this.n_linea = n_linea;
        this.c_descripcion = c_descripcion;
        this.c_nombre_archivo = c_nombre_archivo;
        this.c_ruta_archivo = c_ruta_archivo;
        this.c_ultimousuario = c_ultimousuario;
        this.d_ultimafechamodificacion = d_ultimafechamodificacion;
    }

    
    public String getC_compania() {
        return c_compania;
    }

    public void setC_compania(String c_compania) {
        this.c_compania = c_compania;
    }

    public int getN_numero() {
        return n_numero;
    }

    public void setN_numero(int n_numero) {
        this.n_numero = n_numero;
    }

    public int getN_linea() {
        return n_linea;
    }

    public void setN_linea(int n_linea) {
        this.n_linea = n_linea;
    }

    public String getC_descripcion() {
        return c_descripcion;
    }

    public void setC_descripcion(String c_descripcion) {
        this.c_descripcion = c_descripcion;
    }

    public String getC_nombre_archivo() {
        return c_nombre_archivo;
    }

    public void setC_nombre_archivo(String c_nombre_archivo) {
        this.c_nombre_archivo = c_nombre_archivo;
    }

    public String getC_ruta_archivo() {
        return c_ruta_archivo;
    }

    public void setC_ruta_archivo(String c_ruta_archivo) {
        this.c_ruta_archivo = c_ruta_archivo;
    }

    public String getC_ultimousuario() {
        return c_ultimousuario;
    }

    public void setC_ultimousuario(String c_ultimousuario) {
        this.c_ultimousuario = c_ultimousuario;
    }

    public String getD_ultimafechamodificacion() {
        return d_ultimafechamodificacion;
    }

    public void setD_ultimafechamodificacion(String d_ultimafechamodificacion) {
        this.d_ultimafechamodificacion = d_ultimafechamodificacion;
    }
    
    
}
