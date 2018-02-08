
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.QuejaCliente;

@XmlRootElement(name = "ListQuejaClienteResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListQuejaClienteResponse", namespace = "http://SOAP/")
public class ListQuejaClienteResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<QuejaCliente> _return;

    /**
     * 
     * @return
     *     returns ArrayList<QuejaCliente>
     */
    public ArrayList<QuejaCliente> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<QuejaCliente> _return) {
        this._return = _return;
    }

}
