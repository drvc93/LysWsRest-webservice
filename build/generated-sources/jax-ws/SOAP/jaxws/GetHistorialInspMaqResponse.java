
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.HistorialInspMaq;

@XmlRootElement(name = "GetHistorialInspMaqResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHistorialInspMaqResponse", namespace = "http://SOAP/")
public class GetHistorialInspMaqResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<HistorialInspMaq> _return;

    /**
     * 
     * @return
     *     returns ArrayList<HistorialInspMaq>
     */
    public ArrayList<HistorialInspMaq> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<HistorialInspMaq> _return) {
        this._return = _return;
    }

}
