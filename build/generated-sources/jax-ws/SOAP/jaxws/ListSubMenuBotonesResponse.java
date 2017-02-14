
package SOAP.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.SubMenuBotones;

@XmlRootElement(name = "ListSubMenuBotonesResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSubMenuBotonesResponse", namespace = "http://SOAP/")
public class ListSubMenuBotonesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<SubMenuBotones> _return;

    /**
     * 
     * @return
     *     returns List<SubMenuBotones>
     */
    public List<SubMenuBotones> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<SubMenuBotones> _return) {
        this._return = _return;
    }

}
