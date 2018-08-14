
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetListIMEIMoviles", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListIMEIMoviles", namespace = "http://SOAP/")
public class GetListIMEIMoviles {

    @XmlElement(name = "imei", namespace = "http://SOAP/")
    private String imei;

    /**
     * 
     * @return
     *     returns String
     */
    public String getImei() {
        return this.imei;
    }

    /**
     * 
     * @param imei
     *     the value for the imei property
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

}
