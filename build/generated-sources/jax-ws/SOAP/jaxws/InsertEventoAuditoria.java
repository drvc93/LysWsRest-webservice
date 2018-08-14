
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertEventoAuditoria", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertEventoAuditoria", namespace = "http://SOAP/", propOrder = {
    "origen",
    "imei",
    "numero",
    "seriechip",
    "hora",
    "accion",
    "usuario",
    "codintapp"
})
public class InsertEventoAuditoria {

    @XmlElement(name = "origen", namespace = "http://SOAP/")
    private String origen;
    @XmlElement(name = "imei", namespace = "http://SOAP/")
    private String imei;
    @XmlElement(name = "numero", namespace = "http://SOAP/")
    private String numero;
    @XmlElement(name = "seriechip", namespace = "http://SOAP/")
    private String seriechip;
    @XmlElement(name = "hora", namespace = "http://SOAP/")
    private String hora;
    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "codintapp", namespace = "http://SOAP/")
    private String codintapp;

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
    public String getNumero() {
        return this.numero;
    }

    /**
     * 
     * @param numero
     *     the value for the numero property
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
    public String getCodintapp() {
        return this.codintapp;
    }

    /**
     * 
     * @param codintapp
     *     the value for the codintapp property
     */
    public void setCodintapp(String codintapp) {
        this.codintapp = codintapp;
    }

}
