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
public class InspeccionesMaqDet {
    private String c_compania;
    private String n_correlativo;
    private String n_linea;
    private String c_inpeccion;
    private String c_tipoinspeccion ;
    private String n_porcentajeminimo;
    private String n_porcentajemaximo;
    private String n_pocentajeinspeccion;
    private String c_estado;
    private String c_comentario;
    private String c_rutafoto;
    private String c_ultimousuario;
    private String d_ultimafechamodificacion;

    public InspeccionesMaqDet() {
    }

    public InspeccionesMaqDet(String c_compania, String n_correlativo, String n_linea, String c_inpeccion, String c_tipoinspeccion, String n_porcentajeminimo, String n_porcentajemaximo, String n_pocentajeinspeccion, String c_estado, String c_comentario, String c_rutafoto, String c_ultimousuario, String d_ultimafechamodificacion) {
        this.c_compania = c_compania;
        this.n_correlativo = n_correlativo;
        this.n_linea = n_linea;
        this.c_inpeccion = c_inpeccion;
        this.c_tipoinspeccion = c_tipoinspeccion;
        this.n_porcentajeminimo = n_porcentajeminimo;
        this.n_porcentajemaximo = n_porcentajemaximo;
        this.n_pocentajeinspeccion = n_pocentajeinspeccion;
        this.c_estado = c_estado;
        this.c_comentario = c_comentario;
        this.c_rutafoto = c_rutafoto;
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

    public String getN_linea() {
        return n_linea;
    }

    public void setN_linea(String n_linea) {
        this.n_linea = n_linea;
    }

    public String getC_inpeccion() {
        return c_inpeccion;
    }

    public void setC_inpeccion(String c_inpeccion) {
        this.c_inpeccion = c_inpeccion;
    }

    public String getC_tipoinspeccion() {
        return c_tipoinspeccion;
    }

    public void setC_tipoinspeccion(String c_tipoinspeccion) {
        this.c_tipoinspeccion = c_tipoinspeccion;
    }

    public String getN_porcentajeminimo() {
        return n_porcentajeminimo;
    }

    public void setN_porcentajeminimo(String n_porcentajeminimo) {
        this.n_porcentajeminimo = n_porcentajeminimo;
    }

    public String getN_porcentajemaximo() {
        return n_porcentajemaximo;
    }

    public void setN_porcentajemaximo(String n_porcentajemaximo) {
        this.n_porcentajemaximo = n_porcentajemaximo;
    }

    public String getN_pocentajeinspeccion() {
        return n_pocentajeinspeccion;
    }

    public void setN_pocentajeinspeccion(String n_pocentajeinspeccion) {
        this.n_pocentajeinspeccion = n_pocentajeinspeccion;
    }

    public String getC_estado() {
        return c_estado;
    }

    public void setC_estado(String c_estado) {
        this.c_estado = c_estado;
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
    
    
}
