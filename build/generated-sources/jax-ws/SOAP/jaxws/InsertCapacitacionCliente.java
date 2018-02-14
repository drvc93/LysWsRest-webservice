
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertCapacitacionCliente", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertCapacitacionCliente", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "accion",
    "usuario",
    "fecha",
    "cliente",
    "personas",
    "fechaprob",
    "horaprob",
    "lugar",
    "direccioncli",
    "direccionreg",
    "temacapacitacion",
    "descripciontema",
    "estado",
    "observacion"
})
public class InsertCapacitacionCliente {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "fecha", namespace = "http://SOAP/")
    private String fecha;
    @XmlElement(name = "cliente", namespace = "http://SOAP/")
    private String cliente;
    @XmlElement(name = "personas", namespace = "http://SOAP/")
    private String personas;
    @XmlElement(name = "fechaprob", namespace = "http://SOAP/")
    private String fechaprob;
    @XmlElement(name = "horaprob", namespace = "http://SOAP/")
    private String horaprob;
    @XmlElement(name = "lugar", namespace = "http://SOAP/")
    private String lugar;
    @XmlElement(name = "direccioncli", namespace = "http://SOAP/")
    private String direccioncli;
    @XmlElement(name = "direccionreg", namespace = "http://SOAP/")
    private String direccionreg;
    @XmlElement(name = "temacapacitacion", namespace = "http://SOAP/")
    private String temacapacitacion;
    @XmlElement(name = "descripciontema", namespace = "http://SOAP/")
    private String descripciontema;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "observacion", namespace = "http://SOAP/")
    private String observacion;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCompania() {
        return this.compania;
    }

    /**
     * 
     * @param compania
     *     the value for the compania property
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCorrelativo() {
        return this.correlativo;
    }

    /**
     * 
     * @param correlativo
     *     the value for the correlativo property
     */
    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getAccion() {
        return this.accion;
    }

    /**
     * 
     * @param accion
     *     the value for the accion property
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * 
     * @param usuario
     *     the value for the usuario property
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * 
     * @param fecha
     *     the value for the fecha property
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCliente() {
        return this.cliente;
    }

    /**
     * 
     * @param cliente
     *     the value for the cliente property
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPersonas() {
        return this.personas;
    }

    /**
     * 
     * @param personas
     *     the value for the personas property
     */
    public void setPersonas(String personas) {
        this.personas = personas;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaprob() {
        return this.fechaprob;
    }

    /**
     * 
     * @param fechaprob
     *     the value for the fechaprob property
     */
    public void setFechaprob(String fechaprob) {
        this.fechaprob = fechaprob;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getHoraprob() {
        return this.horaprob;
    }

    /**
     * 
     * @param horaprob
     *     the value for the horaprob property
     */
    public void setHoraprob(String horaprob) {
        this.horaprob = horaprob;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLugar() {
        return this.lugar;
    }

    /**
     * 
     * @param lugar
     *     the value for the lugar property
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDireccioncli() {
        return this.direccioncli;
    }

    /**
     * 
     * @param direccioncli
     *     the value for the direccioncli property
     */
    public void setDireccioncli(String direccioncli) {
        this.direccioncli = direccioncli;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDireccionreg() {
        return this.direccionreg;
    }

    /**
     * 
     * @param direccionreg
     *     the value for the direccionreg property
     */
    public void setDireccionreg(String direccionreg) {
        this.direccionreg = direccionreg;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTemacapacitacion() {
        return this.temacapacitacion;
    }

    /**
     * 
     * @param temacapacitacion
     *     the value for the temacapacitacion property
     */
    public void setTemacapacitacion(String temacapacitacion) {
        this.temacapacitacion = temacapacitacion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescripciontema() {
        return this.descripciontema;
    }

    /**
     * 
     * @param descripciontema
     *     the value for the descripciontema property
     */
    public void setDescripciontema(String descripciontema) {
        this.descripciontema = descripciontema;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * 
     * @param estado
     *     the value for the estado property
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getObservacion() {
        return this.observacion;
    }

    /**
     * 
     * @param observacion
     *     the value for the observacion property
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
