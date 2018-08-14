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
public class UsuarioPromotor {
    private String c_usuario ;
    private String c_nombusuario;

    public UsuarioPromotor() {
    }

    public UsuarioPromotor(String c_usuario, String c_nombusuario) {
        this.c_usuario = c_usuario;
        this.c_nombusuario = c_nombusuario;
    }

    public String getC_usuario() {
        return c_usuario;
    }

    public void setC_usuario(String c_usuario) {
        this.c_usuario = c_usuario;
    }

    public String getC_nombusuario() {
        return c_nombusuario;
    }

    public void setC_nombusuario(String c_nombusuario) {
        this.c_nombusuario = c_nombusuario;
    }
    
}
