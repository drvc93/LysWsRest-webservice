
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetEmpleadosAsig", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEmpleadosAsig", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nrosolicitud"
})
public class GetEmpleadosAsig {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nrosolicitud", namespace = "http://SOAP/")
    private String nrosolicitud;

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

}
