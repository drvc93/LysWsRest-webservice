
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.Menu;

@XmlRootElement(name = "ListaMenuResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaMenuResponse", namespace = "http://SOAP/")
public class ListaMenuResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private Menu[] _return;

    /**
     * 
     * @return
     *     returns Menu[]
     */
    public Menu[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Menu[] _return) {
        this._return = _return;
    }

}
