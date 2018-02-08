
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMATemaCapacitacion;

@XmlRootElement(name = "GetListTemaCapacitacionResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListTemaCapacitacionResponse", namespace = "http://SOAP/")
public class GetListTemaCapacitacionResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMATemaCapacitacion> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMATemaCapacitacion>
     */
    public ArrayList<TMATemaCapacitacion> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMATemaCapacitacion> _return) {
        this._return = _return;
    }

}
