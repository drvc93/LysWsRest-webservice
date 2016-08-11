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
public class InspeccionesGenDet {
    
    private String c_compania;
    private String n_correlativo;
    private String n_linea;
    private String c_comentario;
    private String c_rutafoto;
    private String c_ultimousuario;
    private String d_ultimafechamodificacion;
    private String c_tiporevisiong;
    private String c_flagadictipo;

    public InspeccionesGenDet() {
    }

    public InspeccionesGenDet(String c_compania, String n_correlativo, String n_linea, String c_comentario, String c_rutafoto, String c_ultimousuario, String d_ultimafechamodificacion, String c_tiporevisiong, String c_flagadictipo) {
        this.c_compania = c_compania;
        this.n_correlativo = n_correlativo;
        this.n_linea = n_linea;
        this.c_comentario = c_comentario;
        this.c_rutafoto = c_rutafoto;
        this.c_ultimousuario = c_ultimousuario;
        this.d_ultimafechamodificacion = d_ultimafechamodificacion;
        this.c_tiporevisiong = c_tiporevisiong;
        this.c_flagadictipo = c_flagadictipo;
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

    public String getN_linea() {
        return n_linea;
    }

    public void setN_linea(String n_linea) {
        this.n_linea = n_linea;
    }

    public String getC_comentario() {
        return c_comentario;
    }

    public void setC_comentario(String c_comentario) {
        this.c_comentario = c_comentario;
    }

    public String getC_rutafoto() {
        return c_rutafoto;
    }

    public void setC_rutafoto(String c_rutafoto) {
        this.c_rutafoto = c_rutafoto;
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

    public String getC_tiporevisiong() {
        return c_tiporevisiong;
    }

    public void setC_tiporevisiong(String c_tiporevisiong) {
        this.c_tiporevisiong = c_tiporevisiong;
    }

    public String getC_flagadictipo() {
        return c_flagadictipo;
    }

    public void setC_flagadictipo(String c_flagadictipo) {
        this.c_flagadictipo = c_flagadictipo;
    }
    
    
}
