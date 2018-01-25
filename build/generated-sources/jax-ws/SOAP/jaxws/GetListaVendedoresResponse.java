
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMAVendedor;

@XmlRootElement(name = "GetListaVendedoresResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListaVendedoresResponse", namespace = "http://SOAP/")
public class GetListaVendedoresResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMAVendedor> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMAVendedor>
     */
    public ArrayList<TMAVendedor> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMAVendedor> _return) {
        this._return = _return;
    }

}
