
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMACalificacionQueja;

@XmlRootElement(name = "GetListaCalificacionQuejaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListaCalificacionQuejaResponse", namespace = "http://SOAP/")
public class GetListaCalificacionQuejaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMACalificacionQueja> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMACalificacionQueja>
     */
    public ArrayList<TMACalificacionQueja> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMACalificacionQueja> _return) {
        this._return = _return;
    }

}
