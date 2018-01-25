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
public class TMAFalla {
    private String c_codigo ;
    private String c_descripcion ;

    
    public TMAFalla() {
    }

    public TMAFalla(String c_codigo, String c_descripcion) {
        this.c_codigo = c_codigo;
        this.c_descripcion = c_descripcion;
    }

    public String getC_codigo() {
        return c_codigo;
    }

    public void setC_codigo(String c_codigo) {
        this.c_codigo = c_codigo;
    }

    public String getC_descripcion() {
        return c_descripcion;
    }

    public void setC_descripcion(String c_descripcion) {
        this.c_descripcion = c_descripcion;
    }
    
    
    
    
    
}
