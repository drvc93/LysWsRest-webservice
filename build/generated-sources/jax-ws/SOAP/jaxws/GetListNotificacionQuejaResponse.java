
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMANotificacionQueja;

@XmlRootElement(name = "GetListNotificacionQuejaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListNotificacionQuejaResponse", namespace = "http://SOAP/")
public class GetListNotificacionQuejaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMANotificacionQueja> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMANotificacionQueja>
     */
    public ArrayList<TMANotificacionQueja> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMANotificacionQueja> _return) {
        this._return = _return;
    }

}
