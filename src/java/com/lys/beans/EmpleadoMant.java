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
public class EmpleadoMant {
  private String c_compania ;
  private int n_empleado ;
  private  String  c_nombreempleado;
  private String  c_documento ;
  private String c_numeromovil ;

    public EmpleadoMant(String c_compania, int n_empleado, String c_nombreempleado, String c_documento ,String c_numeromovil) {
        this.c_compania = c_compania;
        this.n_empleado = n_empleado;
        this.c_nombreempleado = c_nombreempleado;
        this.c_documento = c_documento;
        this.c_numeromovil = c_numeromovil ;
    }

    
  
  
    public EmpleadoMant() {
    }

    public String getC_numeromovil() {
        return c_numeromovil;
    }

    public void setC_numeromovil(String c_numeromovil) {
        this.c_numeromovil = c_numeromovil;
    }
    
    
    public String getC_compania() {
        return c_compania;
    }

    public void setC_compania(String c_compania) {
        this.c_compania = c_compania;
    }

    public int getN_empleado() {
        return n_empleado;
    }

    public void setN_empleado(int n_empleado) {
        this.n_empleado = n_empleado;
    }

    public String getC_nombreempleado() {
        return c_nombreempleado;
    }

    public void setC_nombreempleado(String c_nombreempleado) {
        this.c_nombreempleado = c_nombreempleado;
    }

    public String getC_documento() {
        return c_documento;
    }

    public void setC_documento(String c_documento) {
        this.c_documento = c_documento;
    }
  
  
  
}
