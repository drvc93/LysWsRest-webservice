
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMAFalla;

@XmlRootElement(name = "GetListFallasResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListFallasResponse", namespace = "http://SOAP/")
public class GetListFallasResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMAFalla> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMAFalla>
     */
    public ArrayList<TMAFalla> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMAFalla> _return) {
        this._return = _return;
    }

}
