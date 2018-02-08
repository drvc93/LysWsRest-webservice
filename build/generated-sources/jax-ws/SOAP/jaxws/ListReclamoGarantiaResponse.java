
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.ReclamoGarantia;

@XmlRootElement(name = "ListReclamoGarantiaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListReclamoGarantiaResponse", namespace = "http://SOAP/")
public class ListReclamoGarantiaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<ReclamoGarantia> _return;

    /**
     * 
     * @return
     *     returns ArrayList<ReclamoGarantia>
     */
    public ArrayList<ReclamoGarantia> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<ReclamoGarantia> _return) {
        this._return = _return;
    }

}
