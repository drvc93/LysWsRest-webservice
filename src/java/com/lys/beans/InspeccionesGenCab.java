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
public class InspeccionesGenCab {
    
    private String c_compania;
    private String n_correlativo;
    private String c_tipoinspeccion;
    private String c_maquina;
    private String c_centrocosto;
    private String c_comentario;
    private String c_usuarioinspeccion;
    private String d_fechainspeccion;
    private String c_estado;
    private String c_usuarioenvio;
    private String d_fechaenvio;
    private String c_ultimousuario;
    private String d_ultimafechamodificacion;

    public InspeccionesGenCab() {
    }

    public InspeccionesGenCab(String c_compania, String n_correlativo, String c_tipoinspeccion, String c_maquina, String c_centrocosto, String c_comentario, String c_usuarioinspeccion, String d_fechainspeccion, String c_estado, String c_usuarioenvio, String d_fechaenvio, String c_ultimousuario, String d_ultimafechamodificacion) {
        this.c_compania = c_compania;
        this.n_correlativo = n_correlativo;
        this.c_tipoinspeccion = c_tipoinspeccion;
        this.c_maquina = c_maquina;
        this.c_centrocosto = c_centrocosto;
        this.c_comentario = c_comentario;
        this.c_usuarioinspeccion = c_usuarioinspeccion;
        this.d_fechainspeccion = d_fechainspeccion;
        this.c_estado = c_estado;
        this.c_usuarioenvio = c_usuarioenvio;
        this.d_fechaenvio = d_fechaenvio;
        this.c_ultimousuario = c_ultimousuario;
        this.d_ultimafechamodificacion = d_ultimafechamodificacion;
    }

    public String getC_compania() {
        return c_compania;
    }

    public void setC_compania(String c_compania) {
        this.c_compania = c_compania;
    }

    public String getN_correlativo() {
        return n_correlativo;
    }

    public void setN_correlativo(String n_correlativo) {
        this.n_correlativo = n_correlativo;
    }

    public String getC_tipoinspeccion() {
        return c_tipoinspeccion;
    }

    public void setC_tipoinspeccion(String c_tipoinspeccion) {
        this.c_tipoinspeccion = c_tipoinspeccion;
    }

    public String getC_maquina() {
        return c_maquina;
    }

    public void setC_maquina(String c_maquina) {
        this.c_maquina = c_maquina;
    }

    public String getC_centrocosto() {
        return c_centrocosto;
    }

    public void setC_centrocosto(String c_centrocosto) {
        this.c_centrocosto = c_centrocosto;
    }

    public String getC_comentario() {
        return c_comentario;
    }

    public void setC_comentario(String c_comentario) {
        this.c_comentario = c_comentario;
    }

    public String getC_usuarioinspeccion() {
        return c_usuarioinspeccion;
    }

    public void setC_usuarioinspeccion(String c_usuarioinspeccion) {
        this.c_usuarioinspeccion = c_usuarioinspeccion;
    }

    public String getD_fechainspeccion() {
        return d_fechainspeccion;
    }

    public void setD_fechainspeccion(String d_fechainspeccion) {
        this.d_fechainspeccion = d_fechainspeccion;
    }

    public String getC_estado() {
        return c_estado;
    }

    public void setC_estado(String c_estado) {
        this.c_estado = c_estado;
    }

    public String getC_usuarioenvio() {
        return c_usuarioenvio;
    }

    public void setC_usuarioenvio(String c_usuarioenvio) {
        this.c_usuarioenvio = c_usuarioenvio;
    }

    public String getD_fechaenvio() {
        return d_fechaenvio;
    }

    public void setD_fechaenvio(String d_fechaenvio) {
        this.d_fechaenvio = d_fechaenvio;
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
