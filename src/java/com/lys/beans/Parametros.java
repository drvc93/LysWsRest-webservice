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
public class Parametros   {
    
    private  String CodParametro;
     private String Descripcion;

    public String getCodParametro() {
        return CodParametro;
    }

    public void setCodParametro(String CodParametro) {
        this.CodParametro = CodParametro;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Parametros(String CodParametro, String Descripcion) {
        this.CodParametro = CodParametro;
        this.Descripcion = Descripcion;
    }
    
    public Parametros (){};
    
    
    
}
