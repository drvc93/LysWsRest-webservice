
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CountEmpleadosSolict", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CountEmpleadosSolict", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nsolicitud"
})
public class CountEmpleadosSolict {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nsolicitud", namespace = "http://SOAP/")
    private String nsolicitud;

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
    public String getNsolicitud() {
        return this.nsolicitud;
    }

    /**
     * 
     * @param nsolicitud
     *     the value for the nsolicitud property
     */
    public void setNsolicitud(String nsolicitud) {
        this.nsolicitud = nsolicitud;
    }

}
