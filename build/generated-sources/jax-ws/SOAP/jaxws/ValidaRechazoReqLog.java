
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ValidaRechazoReqLog", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidaRechazoReqLog", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nroreq",
    "usuariorechazo"
})
public class ValidaRechazoReqLog {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nroreq", namespace = "http://SOAP/")
    private String nroreq;
    @XmlElement(name = "usuariorechazo", namespace = "http://SOAP/")
    private String usuariorechazo;

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
    public String getNroreq() {
        return this.nroreq;
    }

    /**
     * 
     * @param nroreq
     *     the value for the nroreq property
     */
    public void setNroreq(String nroreq) {
        this.nroreq = nroreq;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsuariorechazo() {
        return this.usuariorechazo;
    }

    /**
     * 
     * @param usuariorechazo
     *     the value for the usuariorechazo property
     */
    public void setUsuariorechazo(String usuariorechazo) {
        this.usuariorechazo = usuariorechazo;
    }

}
