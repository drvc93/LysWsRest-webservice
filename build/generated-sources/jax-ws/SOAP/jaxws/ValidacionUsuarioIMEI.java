
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ValidacionUsuarioIMEI", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidacionUsuarioIMEI", namespace = "http://SOAP/", propOrder = {
    "usuario",
    "clave",
    "imei",
    "numeromov",
    "seriechip"
})
public class ValidacionUsuarioIMEI {

    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "clave", namespace = "http://SOAP/")
    private String clave;
    @XmlElement(name = "imei", namespace = "http://SOAP/")
    private String imei;
    @XmlElement(name = "numeromov", namespace = "http://SOAP/")
    private String numeromov;
    @XmlElement(name = "seriechip", namespace = "http://SOAP/")
    private String seriechip;

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
    public String getClave() {
        return this.clave;
    }

    /**
     * 
     * @param clave
     *     the value for the clave property
     */
    public void setClave(String clave) {
        this.clave = clave;
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
    public String getNumeromov() {
        return this.numeromov;
    }

    /**
     * 
     * @param numeromov
     *     the value for the numeromov property
     */
    public void setNumeromov(String numeromov) {
        this.numeromov = numeromov;
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
