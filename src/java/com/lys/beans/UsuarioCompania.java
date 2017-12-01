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
public class UsuarioCompania {
   
    private String c_compania ;
    private String c_nombres ;

    public UsuarioCompania(String c_compania, String c_nombres) {
        this.c_compania = c_compania;
        this.c_nombres = c_nombres;
    }
    public UsuarioCompania() {
    }
    
    public String getC_compania() {
        return c_compania;
    }

    public void setC_compania(String c_compania) {
        this.c_compania = c_compania;
    }

    public String getC_nombres() {
        return c_nombres;
    }

    public void setC_nombres(String c_nombres) {
        this.c_nombres = c_nombres;
    }
    
    
    
   
    
}
