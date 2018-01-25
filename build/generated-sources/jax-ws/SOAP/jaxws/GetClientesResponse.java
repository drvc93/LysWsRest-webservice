
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMACliente;

@XmlRootElement(name = "GetClientesResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetClientesResponse", namespace = "http://SOAP/")
public class GetClientesResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMACliente> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMACliente>
     */
    public ArrayList<TMACliente> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMACliente> _return) {
        this._return = _return;
    }

}
