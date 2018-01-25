
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.Rechazos;

@XmlRootElement(name = "ListaRechazosResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaRechazosResponse", namespace = "http://SOAP/")
public class ListaRechazosResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<Rechazos> _return;

    /**
     * 
     * @return
     *     returns ArrayList<Rechazos>
     */
    public ArrayList<Rechazos> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<Rechazos> _return) {
        this._return = _return;
    }

}
