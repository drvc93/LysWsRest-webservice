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
public class CorreoUsuarioCCosto {
    
    private String c_usuario ;
    private String c_correo ;

    public CorreoUsuarioCCosto() {
    }

    public CorreoUsuarioCCosto(String c_usuario, String c_correo) {
        this.c_usuario = c_usuario;
        this.c_correo = c_correo;
    }

    
    
    public String getC_usuario() {
        return c_usuario;
    }

    public void setC_usuario(String c_usuario) {
        this.c_usuario = c_usuario;
    }

    public String getC_correo() {
        return c_correo;
    }

    public void setC_correo(String c_correo) {
        this.c_correo = c_correo;
    }
    
    
}


