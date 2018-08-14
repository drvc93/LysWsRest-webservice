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
public class UnidadNegocio {
    private String c_compania ;
    private String c_unidadnegocio ;
    private String c_descripcion ;
    private String c_estado;

    public UnidadNegocio() {
    }

    public UnidadNegocio(String c_compania, String c_unidadnegocio, String c_descripcion, String c_estado) {
        this.c_compania = c_compania;
        this.c_unidadnegocio = c_unidadnegocio;
        this.c_descripcion = c_descripcion;
        this.c_estado = c_estado;
    }

    public String getC_compania() {
        return c_compania;
    }

    public void setC_compania(String c_compania) {
        this.c_compania = c_compania;
    }

    public String getC_unidadnegocio() {
        return c_unidadnegocio;
    }

    public void setC_unidadnegocio(String c_unidadnegocio) {
        this.c_unidadnegocio = c_unidadnegocio;
    }

    public String getC_descripcion() {
        return c_descripcion;
    }

    public void setC_descripcion(String c_descripcion) {
        this.c_descripcion = c_descripcion;
    }

    public String getC_estado() {
        return c_estado;
    }

    public void setC_estado(String c_estado) {
        this.c_estado = c_estado;
    }
    
    
    
}
