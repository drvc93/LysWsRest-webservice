
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetFotoRG", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFotoRG", namespace = "http://SOAP/", propOrder = {
    "filename",
    "tipo"
})
public class GetFotoRG {

    @XmlElement(name = "filename", namespace = "http://SOAP/")
    private String filename;
    @XmlElement(name = "tipo", namespace = "http://SOAP/")
    private String tipo;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * 
     * @param tipo
     *     the value for the tipo property
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
