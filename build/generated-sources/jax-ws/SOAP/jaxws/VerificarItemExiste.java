
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "VerificarItemExiste", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerificarItemExiste", namespace = "http://SOAP/")
public class VerificarItemExiste {

    @XmlElement(name = "item", namespace = "http://SOAP/")
    private String item;

    /**
     * 
     * @return
     *     returns String
     */
    public String getItem() {
        return this.item;
    }

    /**
     * 
     * @param item
     *     the value for the item property
     */
    public void setItem(String item) {
        this.item = item;
    }

}
