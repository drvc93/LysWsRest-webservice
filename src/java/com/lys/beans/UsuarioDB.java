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
public class UsuarioDB {
    private String codigoUsuario;
    private String nombre;
    private String clave;
    private String nroPersona;
    private String estado;
    private String flagmantto;

    public UsuarioDB() {
    }

    public UsuarioDB(String codigoUsuario, String nombre, String clave, String nroPersona, String estado, String flagmantto) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.nroPersona = nroPersona;
        this.estado = estado;
        this.flagmantto = flagmantto;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNroPersona() {
        return nroPersona;
    }

    public void setNroPersona(String nroPersona) {
        this.nroPersona = nroPersona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFlagmantto() {
        return flagmantto;
    }

    public void setFlagmantto(String flagmantto) {
        this.flagmantto = flagmantto;
    }
    
}
