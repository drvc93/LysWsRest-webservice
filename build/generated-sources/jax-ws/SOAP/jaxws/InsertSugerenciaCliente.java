
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertSugerenciaCliente", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertSugerenciaCliente", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "accion",
    "usuario",
    "fecha",
    "cliente",
    "tiposugerencia",
    "descripcion",
    "estado",
    "tipoinfo",
    "observacion"
})
public class InsertSugerenciaCliente {

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
    @XmlElement(name = "tiposugerencia", namespace = "http://SOAP/")
    private String tiposugerencia;
    @XmlElement(name = "descripcion", namespace = "http://SOAP/")
    private String descripcion;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "tipoinfo", namespace = "http://SOAP/")
    private String tipoinfo;
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
    public String getTiposugerencia() {
        return this.tiposugerencia;
    }

    /**
     * 
     * @param tiposugerencia
     *     the value for the tiposugerencia property
     */
    public void setTiposugerencia(String tiposugerencia) {
        this.tiposugerencia = tiposugerencia;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * 
     * @param descripcion
     *     the value for the descripcion property
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public String getTipoinfo() {
        return this.tipoinfo;
    }

    /**
     * 
     * @param tipoinfo
     *     the value for the tipoinfo property
     */
    public void setTipoinfo(String tipoinfo) {
        this.tipoinfo = tipoinfo;
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
