
package SOAP.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.SubMenu;

@XmlRootElement(name = "ListSubMenuResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSubMenuResponse", namespace = "http://SOAP/")
public class ListSubMenuResponse {

    @XmlElement(name = "return", namespace = "")
    private List<SubMenu> _return;

    /**
     * 
     * @return
     *     returns List<SubMenu>
     */
    public List<SubMenu> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<SubMenu> _return) {
        this._return = _return;
    }

}
