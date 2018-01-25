
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetTipoIp", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTipoIp", namespace = "http://SOAP/")
public class GetTipoIp {

    @XmlElement(name = "sTipo", namespace = "http://SOAP/")
    private String sTipo;

    /**
     * 
     * @return
     *     returns String
     */
    public String getSTipo() {
        return this.sTipo;
    }

    /**
     * 
     * @param sTipo
     *     the value for the sTipo property
     */
    public void setSTipo(String sTipo) {
        this.sTipo = sTipo;
    }

}
