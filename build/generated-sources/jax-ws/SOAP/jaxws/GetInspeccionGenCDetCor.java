
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetInspeccionGenCDetCor", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInspeccionGenCDetCor", namespace = "http://SOAP/")
public class GetInspeccionGenCDetCor {

    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;

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
