
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertDatosAuditoria", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertDatosAuditoria", namespace = "http://SOAP/", propOrder = {
    "origen",
    "codIntApp",
    "tipo",
    "imei",
    "movil",
    "usuario",
    "hora",
    "seriechip"
})
public class InsertDatosAuditoria {

    @XmlElement(name = "origen", namespace = "http://SOAP/")
    private String origen;
    @XmlElement(name = "codIntApp", namespace = "http://SOAP/")
    private String codIntApp;
    @XmlElement(name = "tipo", namespace = "http://SOAP/")
    private String tipo;
    @XmlElement(name = "imei", namespace = "http://SOAP/")
    private String imei;
    @XmlElement(name = "movil", namespace = "http://SOAP/")
    private String movil;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "hora", namespace = "http://SOAP/")
    private String hora;
    @XmlElement(name = "seriechip", namespace = "http://SOAP/")
    private String seriechip;

    /**
     * 
     * @return
     *     returns String
     */
    public String getOrigen() {
        return this.origen;
    }

    /**
     * 
     * @param origen
     *     the value for the origen property
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodIntApp() {
        return this.codIntApp;
    }

    /**
     * 
     * @param codIntApp
     *     the value for the codIntApp property
     */
    public void setCodIntApp(String codIntApp) {
        this.codIntApp = codIntApp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * 
     * @param tipo
     *     the value for the tipo property
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getImei() {
        return this.imei;
    }

    /**
     * 
     * @param imei
     *     the value for the imei property
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMovil() {
        return this.movil;
    }

    /**
     * 
     * @param movil
     *     the value for the movil property
     */
    public void setMovil(String movil) {
        this.movil = movil;
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
    public String getHora() {
        return this.hora;
    }

    /**
     * 
     * @param hora
     *     the value for the hora property
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getSeriechip() {
        return this.seriechip;
    }

    /**
     * 
     * @param seriechip
     *     the value for the seriechip property
     */
    public void setSeriechip(String seriechip) {
        this.seriechip = seriechip;
    }

}
