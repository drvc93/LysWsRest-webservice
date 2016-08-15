
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertInspMaqDet", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertInspMaqDet", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "linea",
    "codInspeccion",
    "tipoInsp",
    "porcentMin",
    "porcentMax",
    "porcentInsp",
    "estado",
    "comentario",
    "rutafoto",
    "ultimoUser"
})
public class InsertInspMaqDet {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "linea", namespace = "http://SOAP/")
    private String linea;
    @XmlElement(name = "codInspeccion", namespace = "http://SOAP/")
    private String codInspeccion;
    @XmlElement(name = "tipoInsp", namespace = "http://SOAP/")
    private String tipoInsp;
    @XmlElement(name = "porcentMin", namespace = "http://SOAP/")
    private String porcentMin;
    @XmlElement(name = "porcentMax", namespace = "http://SOAP/")
    private String porcentMax;
    @XmlElement(name = "porcentInsp", namespace = "http://SOAP/")
    private String porcentInsp;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "comentario", namespace = "http://SOAP/")
    private String comentario;
    @XmlElement(name = "rutafoto", namespace = "http://SOAP/")
    private String rutafoto;
    @XmlElement(name = "ultimoUser", namespace = "http://SOAP/")
    private String ultimoUser;

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
    public String getLinea() {
        return this.linea;
    }

    /**
     * 
     * @param linea
     *     the value for the linea property
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodInspeccion() {
        return this.codInspeccion;
    }

    /**
     * 
     * @param codInspeccion
     *     the value for the codInspeccion property
     */
    public void setCodInspeccion(String codInspeccion) {
        this.codInspeccion = codInspeccion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipoInsp() {
        return this.tipoInsp;
    }

    /**
     * 
     * @param tipoInsp
     *     the value for the tipoInsp property
     */
    public void setTipoInsp(String tipoInsp) {
        this.tipoInsp = tipoInsp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPorcentMin() {
        return this.porcentMin;
    }

    /**
     * 
     * @param porcentMin
     *     the value for the porcentMin property
     */
    public void setPorcentMin(String porcentMin) {
        this.porcentMin = porcentMin;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPorcentMax() {
        return this.porcentMax;
    }

    /**
     * 
     * @param porcentMax
     *     the value for the porcentMax property
     */
    public void setPorcentMax(String porcentMax) {
        this.porcentMax = porcentMax;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPorcentInsp() {
        return this.porcentInsp;
    }

    /**
     * 
     * @param porcentInsp
     *     the value for the porcentInsp property
     */
    public void setPorcentInsp(String porcentInsp) {
        this.porcentInsp = porcentInsp;
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
    public String getComentario() {
        return this.comentario;
    }

    /**
     * 
     * @param comentario
     *     the value for the comentario property
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getRutafoto() {
        return this.rutafoto;
    }

    /**
     * 
     * @param rutafoto
     *     the value for the rutafoto property
     */
    public void setRutafoto(String rutafoto) {
        this.rutafoto = rutafoto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUltimoUser() {
        return this.ultimoUser;
    }

    /**
     * 
     * @param ultimoUser
     *     the value for the ultimoUser property
     */
    public void setUltimoUser(String ultimoUser) {
        this.ultimoUser = ultimoUser;
    }

}
