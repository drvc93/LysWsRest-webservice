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
public class AccesosDB {

    
    private  int id;
    private  String usuario;
    private  String appCodigo;
    private  String nivelAcc;
    private  String acceso;
    private  String nuevo;
    private  String modificar;
    private  String eliminar;
    private  String otros;

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getAppCodigo() {
        return appCodigo;
    }

    public void setAppCodigo(String appCodigo) {
        this.appCodigo = appCodigo;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
    }

   

    public String getModificar() {
        return modificar;
    }

    public void setModificar(String modificar) {
        this.modificar = modificar;
    }

    public String getNivelAcc() {
        return nivelAcc;
    }

    public void setNivelAcc(String nivelAcc) {
        this.nivelAcc = nivelAcc;
    }

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public AccesosDB(String acceso, String appCodigo, String eliminar, String modificar, String nivelAcc, String nuevo, String otros, String usuario) {
        this.acceso = acceso;
        this.appCodigo = appCodigo;
        this.eliminar = eliminar;
        this.modificar = modificar;
        this.nivelAcc = nivelAcc;
        this.nuevo = nuevo;
        this.otros = otros;
        this.usuario = usuario;
    }

    public AccesosDB() {
    }
    
    
}
