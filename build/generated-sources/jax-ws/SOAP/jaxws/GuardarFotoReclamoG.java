
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GuardarFotoReclamoG", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuardarFotoReclamoG", namespace = "http://SOAP/", propOrder = {
    "imgeByte",
    "fileName",
    "tipo"
})
public class GuardarFotoReclamoG {

    @XmlElement(name = "imgeByte", namespace = "http://SOAP/", nillable = true)
    private byte[] imgeByte;
    @XmlElement(name = "fileName", namespace = "http://SOAP/")
    private String fileName;
    @XmlElement(name = "tipo", namespace = "http://SOAP/")
    private String tipo;

    /**
     * 
     * @return
     *     returns byte[]
     */
    public byte[] getImgeByte() {
        return this.imgeByte;
    }

    /**
     * 
     * @param imgeByte
     *     the value for the imgeByte property
     */
    public void setImgeByte(byte[] imgeByte) {
        this.imgeByte = imgeByte;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 
     * @param fileName
     *     the value for the fileName property
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
