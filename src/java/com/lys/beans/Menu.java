/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lys.beans;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

/**
 *
 * @author dvillanueva
 */
public class Menu {

    private String codMenu;
    private String descripcionMenu;
    private String codAplicacion;

    

    public String getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(String codMenu) {
        this.codMenu = codMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public Menu(String codMenu, String descripcionMenu, String codAplicacion) {
        this.codMenu = codMenu;
        this.descripcionMenu = descripcionMenu;
        this.codAplicacion= codAplicacion;
    }
    
    public String getCodAplicacion() {
        return codAplicacion;
    }

    public void setCodAplicacion(String codAplicacion) {
        this.codAplicacion = codAplicacion;
    }

    public Menu() {
    }
;

}
