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
public class SubMenuBotones  implements KvmSerializable  {

    private String codMenuBoton;
    private String codPadre;
    private String codSubmenu;
    private String Descripcion;

    public  SubMenuBotones(){};

    public SubMenuBotones(String codMenuBoton, String codPadre, String codSubmenu, String descripcion) {
        this.codMenuBoton = codMenuBoton;
        this.codPadre = codPadre;
        this.codSubmenu = codSubmenu;
        Descripcion = descripcion;
    }

    public String getCodMenuBoton() {
        return codMenuBoton;
    }

    public void setCodMenuBoton(String codMenuBoton) {
        this.codMenuBoton = codMenuBoton;
    }

    public String getCodPadre() {
        return codPadre;
    }

    public void setCodPadre(String codPadre) {
        this.codPadre = codPadre;
    }

    public String getCodSubmenu() {
        return codSubmenu;
    }

    public void setCodSubmenu(String codSubmenu) {
        this.codSubmenu = codSubmenu;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }



    @Override
    public Object getProperty(int i) {

        switch (i){

            case 0:
                return  codMenuBoton;
            case 1 :
                return  codPadre;
            case 2:
                return  codSubmenu;
            case  3 :
                return Descripcion;


        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void setProperty(int i, Object o) {

        switch (i){

            case 0:
                codMenuBoton = o.toString();
                break;
            case 1:
                codPadre = o.toString();
                break;
            case 2:
                codSubmenu = o.toString();
                break;
            case 3:
                Descripcion = o.toString();
                break;

            default:break;


        }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {


        switch (i){

            case 0:
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name= "codMenuBoton";
                break;
            case 1:
                propertyInfo.type= PropertyInfo.STRING_CLASS;
                propertyInfo.name = "codPadre";
                break;
            case 2:
                propertyInfo.type =PropertyInfo.STRING_CLASS;
                propertyInfo.name="codSubMenu";
                break;
            case 3 :
                propertyInfo.type = PropertyInfo.STRING_CLASS;
                propertyInfo.name="Descripcion";


        }

    }
    
}
