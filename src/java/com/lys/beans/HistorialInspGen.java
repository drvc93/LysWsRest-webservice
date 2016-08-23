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
public class HistorialInspGen {
    
    private  String numero ;
    private  String tipoInsp ;
    private  String codMaq ;
    private  String codCosto;
    private  String usarioInp;
    private  String fecha;
    private  String comentario ;
    private  String estado ;

    

    public HistorialInspGen() {
    }

    public HistorialInspGen(String numero, String tipoInsp, String codMaq, String codCosto, String usarioInp, String fecha, String comentario,String estado) {
        this.numero = numero;
        this.tipoInsp = tipoInsp;
        this.codMaq = codMaq;
        this.codCosto = codCosto;
        this.usarioInp = usarioInp;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoInsp() {
        return tipoInsp;
    }

    public void setTipoInsp(String tipoInsp) {
        this.tipoInsp = tipoInsp;
    }

    public String getCodMaq() {
        return codMaq;
    }

    public void setCodMaq(String codMaq) {
        this.codMaq = codMaq;
    }

    public String getCodCosto() {
        return codCosto;
    }

    public void setCodCosto(String codCosto) {
        this.codCosto = codCosto;
    }

    public String getUsarioInp() {
        return usarioInp;
    }

    public void setUsarioInp(String usarioInp) {
        this.usarioInp = usarioInp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
