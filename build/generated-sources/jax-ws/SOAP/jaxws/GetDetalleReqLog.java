
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetDetalleReqLog", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDetalleReqLog", namespace = "http://SOAP/", propOrder = {
    "compania",
    "numeroreq"
})
public class GetDetalleReqLog {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "numeroreq", namespace = "http://SOAP/")
    private String numeroreq;

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
    public String getNumeroreq() {
        return this.numeroreq;
    }

    /**
     * 
     * @param numeroreq
     *     the value for the numeroreq property
     */
    public void setNumeroreq(String numeroreq) {
        this.numeroreq = numeroreq;
    }

}
