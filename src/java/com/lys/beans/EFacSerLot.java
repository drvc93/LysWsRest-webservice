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
public class EFacSerLot {
    private  String c_factRef ;
    private  String c_lote;
    private  String  c_procedencia ;

    public EFacSerLot() {
    }

    
    public EFacSerLot(String c_factRef, String c_lote, String c_procedencia) {
        this.c_factRef = c_factRef;
        this.c_lote = c_lote;
        this.c_procedencia = c_procedencia;
    }
    
    public String getC_factRef() {
        return c_factRef;
    }

    public void setC_factRef(String c_factRef) {
        this.c_factRef = c_factRef;
    }

    public String getC_lote() {
        return c_lote;
    }

    public void setC_lote(String c_lote) {
        this.c_lote = c_lote;
    }

    public String getC_procedencia() {
        return c_procedencia;
    }

    public void setC_procedencia(String c_procedencia) {
        this.c_procedencia = c_procedencia;
    }
    
    
}
