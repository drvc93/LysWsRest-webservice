
package SOAP.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.MenuDB;

@XmlRootElement(name = "GetDataMenuResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDataMenuResponse", namespace = "http://SOAP/")
public class GetDataMenuResponse {

    @XmlElement(name = "return", namespace = "")
    private List<MenuDB> _return;

    /**
     * 
     * @return
     *     returns List<MenuDB>
     */
    public List<MenuDB> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<MenuDB> _return) {
        this._return = _return;
    }

}
