
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.SugerenciaCliente;

@XmlRootElement(name = "ListSugerenciaClienteResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSugerenciaClienteResponse", namespace = "http://SOAP/")
public class ListSugerenciaClienteResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<SugerenciaCliente> _return;

    /**
     * 
     * @return
     *     returns ArrayList<SugerenciaCliente>
     */
    public ArrayList<SugerenciaCliente> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<SugerenciaCliente> _return) {
        this._return = _return;
    }

}
