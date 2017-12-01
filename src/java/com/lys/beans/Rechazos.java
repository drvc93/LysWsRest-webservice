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
public class Rechazos {
    
    private String c_razonrechazo ;
    private String c_descripcion ;

    public Rechazos() {
    }

    public Rechazos(String c_razonrechazo, String c_descripcion) {
        this.c_razonrechazo = c_razonrechazo;
        this.c_descripcion = c_descripcion;
    }
    
    
    
    public String getC_razonrechazo() {
        return c_razonrechazo;
    }

    public void setC_razonrechazo(String c_razonrechazo) {
        this.c_razonrechazo = c_razonrechazo;
    }

    public String getC_descripcion() {
        return c_descripcion;
    }

    public void setC_descripcion(String c_descripcion) {
        this.c_descripcion = c_descripcion;
    }
     
    
}
