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
public class CorreoApReqLog {
   
    private String c_mensajeHtml ;
    private String c_correoaprobacion  ;
    private String c_correocreacion ;

    public CorreoApReqLog() {
    }

    public CorreoApReqLog(String c_mensajeHtml, String c_correoaprobacion, String c_correocreacion) {
        this.c_mensajeHtml = c_mensajeHtml;
        this.c_correoaprobacion = c_correoaprobacion;
        this.c_correocreacion = c_correocreacion;
    }
    
    
    public String getC_mensajeHtml() {
        return c_mensajeHtml;
    }

    public void setC_mensajeHtml(String c_mensajeHtml) {
        this.c_mensajeHtml = c_mensajeHtml;
    }

    public String getC_correoaprobacion() {
        return c_correoaprobacion;
    }

    public void setC_correoaprobacion(String c_correoaprobacion) {
        this.c_correoaprobacion = c_correoaprobacion;
    }

    public String getC_correocreacion() {
        return c_correocreacion;
    }

    public void setC_correocreacion(String c_correocreacion) {
        this.c_correocreacion = c_correocreacion;
    }
    
    
}
