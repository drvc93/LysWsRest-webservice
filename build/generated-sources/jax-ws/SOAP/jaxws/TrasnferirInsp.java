
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "TrasnferirInsp", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrasnferirInsp", namespace = "http://SOAP/", propOrder = {
    "tipoIns",
    "correlativo"
})
public class TrasnferirInsp {

    @XmlElement(name = "tipoIns", namespace = "http://SOAP/")
    private String tipoIns;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipoIns() {
        return this.tipoIns;
    }

    /**
     * 
     * @param tipoIns
     *     the value for the tipoIns property
     */
    public void setTipoIns(String tipoIns) {
        this.tipoIns = tipoIns;
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
