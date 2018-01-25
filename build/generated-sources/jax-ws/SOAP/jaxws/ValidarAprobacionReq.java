
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ValidarAprobacionReq", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidarAprobacionReq", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nroreq",
    "usuarioaprobacion"
})
public class ValidarAprobacionReq {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nroreq", namespace = "http://SOAP/")
    private String nroreq;
    @XmlElement(name = "usuarioaprobacion", namespace = "http://SOAP/")
    private String usuarioaprobacion;

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
    public String getUsuarioaprobacion() {
        return this.usuarioaprobacion;
    }

    /**
     * 
     * @param usuarioaprobacion
     *     the value for the usuarioaprobacion property
     */
    public void setUsuarioaprobacion(String usuarioaprobacion) {
        this.usuarioaprobacion = usuarioaprobacion;
    }

}
