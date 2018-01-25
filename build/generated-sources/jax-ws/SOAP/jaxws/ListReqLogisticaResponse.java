
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.RequisicionLogCab;

@XmlRootElement(name = "ListReqLogisticaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListReqLogisticaResponse", namespace = "http://SOAP/")
public class ListReqLogisticaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<RequisicionLogCab> _return;

    /**
     * 
     * @return
     *     returns ArrayList<RequisicionLogCab>
     */
    public ArrayList<RequisicionLogCab> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<RequisicionLogCab> _return) {
        this._return = _return;
    }

}
