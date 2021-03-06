
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetUsuarioCompComercial", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUsuarioCompComercial", namespace = "http://SOAP/")
public class GetUsuarioCompComercial {

    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;

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

}
