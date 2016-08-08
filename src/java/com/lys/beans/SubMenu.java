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
public class SubMenu implements KvmSerializable {

    private  String codSubMenu;
    private String descripcionSubmenu;
     private String codPadre;
     private String estado;

   

    public SubMenu(String codSubMenu, String descripcionSubmenu, String codPadre, String estado) {
        this.codSubMenu = codSubMenu;
        this.descripcionSubmenu = descripcionSubmenu;
        this.codPadre = codPadre;
        this.estado = estado;
    }
   

  
    

   
    public  SubMenu(){};

    public String getCodSubMenu() {
        return codSubMenu;
    }

    public void setCodSubMenu(String codSubMenu) {
        this.codSubMenu = codSubMenu;
    }

    public String getDescripcionSubmenu() {
        return descripcionSubmenu;
    }

    public void setDescripcionSubmenu(String descripcionSubmenu) {
        this.descripcionSubmenu = descripcionSubmenu;
    }


  public String getCodPadre() {
        return codPadre;
    }

    public void setCodPadre(String codPadre) {
        this.codPadre = codPadre;
    }

 public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public Object getProperty(int i) {
        switch (i){

            case 0:
                return codSubMenu;
            case 1:
                return  descripcionSubmenu;


        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void setProperty(int i, Object o) {

            switch (i){


                case 0 :
                    codSubMenu = o.toString();
                    break;

                case 1:
                    descripcionSubmenu = o.toString();
                    break;
                default:break;



            }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {

            switch (i){

                case 0:
                    propertyInfo.type= PropertyInfo.STRING_CLASS;
                    propertyInfo.name ="codSubMenu";
                    break;
                case  1 :
                    propertyInfo.type = PropertyInfo.STRING_CLASS;
                    propertyInfo.name="descripcionSubmenu";
                    break;
                default:break;



            }



    }
}
