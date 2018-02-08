
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.CapacitacionCliente;

@XmlRootElement(name = "ListCapacitacionClienteResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListCapacitacionClienteResponse", namespace = "http://SOAP/")
public class ListCapacitacionClienteResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<CapacitacionCliente> _return;

    /**
     * 
     * @return
     *     returns ArrayList<CapacitacionCliente>
     */
    public ArrayList<CapacitacionCliente> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<CapacitacionCliente> _return) {
        this._return = _return;
    }

}
