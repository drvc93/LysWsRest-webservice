
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "LoginUser", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoginUser", namespace = "http://SOAP/", propOrder = {
    "usuario",
    "clave"
})
public class LoginUser {

    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "clave", namespace = "http://SOAP/")
    private String clave;

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

}
