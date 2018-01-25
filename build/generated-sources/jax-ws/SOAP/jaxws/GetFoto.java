
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetFoto", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFoto", namespace = "http://SOAP/")
public class GetFoto {

    @XmlElement(name = "filename", namespace = "http://SOAP/")
    private String filename;

    /**
     * 
     * @return
     *     returns String
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * 
     * @param filename
     *     the value for the filename property
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

}
