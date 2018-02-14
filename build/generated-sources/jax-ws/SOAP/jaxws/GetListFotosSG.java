
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetListFotosSG", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListFotosSG", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo"
})
public class GetListFotosSG {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;

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
    public String getCorrelativo() {
        return this.correlativo;
    }

    /**
     * 
     * @param correlativo
     *     the value for the correlativo property
     */
    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

}
