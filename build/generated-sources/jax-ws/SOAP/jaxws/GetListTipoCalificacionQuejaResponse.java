
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMATipoCalificacionQueja;

@XmlRootElement(name = "GetListTipoCalificacionQuejaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListTipoCalificacionQuejaResponse", namespace = "http://SOAP/")
public class GetListTipoCalificacionQuejaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMATipoCalificacionQueja> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMATipoCalificacionQueja>
     */
    public ArrayList<TMATipoCalificacionQueja> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMATipoCalificacionQueja> _return) {
        this._return = _return;
    }

}
