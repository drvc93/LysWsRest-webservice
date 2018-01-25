
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMATipoReclamo;

@XmlRootElement(name = "GetLisTipoReclamoResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLisTipoReclamoResponse", namespace = "http://SOAP/")
public class GetLisTipoReclamoResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMATipoReclamo> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMATipoReclamo>
     */
    public ArrayList<TMATipoReclamo> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMATipoReclamo> _return) {
        this._return = _return;
    }

}
