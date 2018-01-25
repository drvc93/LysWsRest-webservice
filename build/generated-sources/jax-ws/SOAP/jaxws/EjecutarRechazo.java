
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EjecutarRechazo", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EjecutarRechazo", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nroreq",
    "razonrechazo",
    "descripcionrechazo"
})
public class EjecutarRechazo {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nroreq", namespace = "http://SOAP/")
    private String nroreq;
    @XmlElement(name = "razonrechazo", namespace = "http://SOAP/")
    private String razonrechazo;
    @XmlElement(name = "descripcionrechazo", namespace = "http://SOAP/")
    private String descripcionrechazo;

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
    public String getRazonrechazo() {
        return this.razonrechazo;
    }

    /**
     * 
     * @param razonrechazo
     *     the value for the razonrechazo property
     */
    public void setRazonrechazo(String razonrechazo) {
        this.razonrechazo = razonrechazo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescripcionrechazo() {
        return this.descripcionrechazo;
    }

    /**
     * 
     * @param descripcionrechazo
     *     the value for the descripcionrechazo property
     */
    public void setDescripcionrechazo(String descripcionrechazo) {
        this.descripcionrechazo = descripcionrechazo;
    }

}
