
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "AprobarSolcitudServ", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AprobarSolcitudServ", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nrosolicitud",
    "usuario"
})
public class AprobarSolcitudServ {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nrosolicitud", namespace = "http://SOAP/")
    private String nrosolicitud;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;

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
    public String getNrosolicitud() {
        return this.nrosolicitud;
    }

    /**
     * 
     * @param nrosolicitud
     *     the value for the nrosolicitud property
     */
    public void setNrosolicitud(String nrosolicitud) {
        this.nrosolicitud = nrosolicitud;
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

}
