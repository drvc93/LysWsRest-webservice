
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertQuejaCliente", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertQuejaCliente", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "accion",
    "usuario",
    "nroformato",
    "cliente",
    "fecha",
    "documentoref",
    "mediorecepcion",
    "centrocosto",
    "calificacion",
    "usuarioderiv",
    "tipocalificacion",
    "item",
    "lote",
    "cantidad",
    "descqueja",
    "observaciones",
    "estado"
})
public class InsertQuejaCliente {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "nroformato", namespace = "http://SOAP/")
    private String nroformato;
    @XmlElement(name = "cliente", namespace = "http://SOAP/")
    private String cliente;
    @XmlElement(name = "fecha", namespace = "http://SOAP/")
    private String fecha;
    @XmlElement(name = "documentoref", namespace = "http://SOAP/")
    private String documentoref;
    @XmlElement(name = "mediorecepcion", namespace = "http://SOAP/")
    private String mediorecepcion;
    @XmlElement(name = "centrocosto", namespace = "http://SOAP/")
    private String centrocosto;
    @XmlElement(name = "calificacion", namespace = "http://SOAP/")
    private String calificacion;
    @XmlElement(name = "usuarioderiv", namespace = "http://SOAP/")
    private String usuarioderiv;
    @XmlElement(name = "tipocalificacion", namespace = "http://SOAP/")
    private String tipocalificacion;
    @XmlElement(name = "item", namespace = "http://SOAP/")
    private String item;
    @XmlElement(name = "lote", namespace = "http://SOAP/")
    private String lote;
    @XmlElement(name = "cantidad", namespace = "http://SOAP/")
    private String cantidad;
    @XmlElement(name = "descqueja", namespace = "http://SOAP/")
    private String descqueja;
    @XmlElement(name = "observaciones", namespace = "http://SOAP/")
    private String observaciones;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;

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
    public String getNroformato() {
        return this.nroformato;
    }

    /**
     * 
     * @param nroformato
     *     the value for the nroformato property
     */
    public void setNroformato(String nroformato) {
        this.nroformato = nroformato;
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
    public String getDocumentoref() {
        return this.documentoref;
    }

    /**
     * 
     * @param documentoref
     *     the value for the documentoref property
     */
    public void setDocumentoref(String documentoref) {
        this.documentoref = documentoref;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMediorecepcion() {
        return this.mediorecepcion;
    }

    /**
     * 
     * @param mediorecepcion
     *     the value for the mediorecepcion property
     */
    public void setMediorecepcion(String mediorecepcion) {
        this.mediorecepcion = mediorecepcion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCentrocosto() {
        return this.centrocosto;
    }

    /**
     * 
     * @param centrocosto
     *     the value for the centrocosto property
     */
    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCalificacion() {
        return this.calificacion;
    }

    /**
     * 
     * @param calificacion
     *     the value for the calificacion property
     */
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsuarioderiv() {
        return this.usuarioderiv;
    }

    /**
     * 
     * @param usuarioderiv
     *     the value for the usuarioderiv property
     */
    public void setUsuarioderiv(String usuarioderiv) {
        this.usuarioderiv = usuarioderiv;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipocalificacion() {
        return this.tipocalificacion;
    }

    /**
     * 
     * @param tipocalificacion
     *     the value for the tipocalificacion property
     */
    public void setTipocalificacion(String tipocalificacion) {
        this.tipocalificacion = tipocalificacion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getItem() {
        return this.item;
    }

    /**
     * 
     * @param item
     *     the value for the item property
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLote() {
        return this.lote;
    }

    /**
     * 
     * @param lote
     *     the value for the lote property
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCantidad() {
        return this.cantidad;
    }

    /**
     * 
     * @param cantidad
     *     the value for the cantidad property
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescqueja() {
        return this.descqueja;
    }

    /**
     * 
     * @param descqueja
     *     the value for the descqueja property
     */
    public void setDescqueja(String descqueja) {
        this.descqueja = descqueja;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getObservaciones() {
        return this.observaciones;
    }

    /**
     * 
     * @param observaciones
     *     the value for the observaciones property
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

}
