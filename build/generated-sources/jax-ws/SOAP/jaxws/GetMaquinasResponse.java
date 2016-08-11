
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.Maquina;

@XmlRootElement(name = "GetMaquinasResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMaquinasResponse", namespace = "http://SOAP/")
public class GetMaquinasResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<Maquina> _return;

    /**
     * 
     * @return
     *     returns ArrayList<Maquina>
     */
    public ArrayList<Maquina> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<Maquina> _return) {
        this._return = _return;
    }

}
