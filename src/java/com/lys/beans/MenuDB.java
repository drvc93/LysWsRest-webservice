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
public class MenuDB {
    
    private  int id;
    private  String AppCodigo;
    private  String nivel1;
    private  String nivel2;
    private  String nivel3;
    private  String nivel4;
    private  String nivel5;
    private  String NombreMenu;
    private  String Descripcion;

    public MenuDB(String appCodigo , String nivel1, String nivel2, String nivel3, String nivel4, String nivel5, String nombreMenu,String descripcion) {
        this.AppCodigo = appCodigo;   
        this.nivel1 = nivel1;
        this.nivel2 = nivel2;
        this.nivel3 = nivel3;
        this.nivel4 = nivel4;
        this.nivel5 = nivel5;
        this.NombreMenu = nombreMenu;
         this.Descripcion = descripcion;
    }

    public MenuDB() {
    }

    public String getAppCodigo() {
        return AppCodigo;
    }

    public void setAppCodigo(String appCodigo) {
        AppCodigo = appCodigo;
    }

    public String getNivel1() {
        return nivel1;
    }

    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    public String getNivel2() {
        return nivel2;
    }

    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getNivel3() {
        return nivel3;
    }

    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    public String getNivel4() {
        return nivel4;
    }

    public void setNivel4(String nivel4) {
        this.nivel4 = nivel4;
    }

    public String getNivel5() {
        return nivel5;
    }

    public void setNivel5(String nivel5) {
        this.nivel5 = nivel5;
    }

    public String getNombreMenu() {
        return NombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        NombreMenu = nombreMenu;
    }
       public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

         public String getDescripcion() {
        return Descripcion;
    }
   

    
}
