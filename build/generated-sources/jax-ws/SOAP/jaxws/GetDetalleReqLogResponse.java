
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.RequisicionLogDet;

@XmlRootElement(name = "GetDetalleReqLogResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDetalleReqLogResponse", namespace = "http://SOAP/")
public class GetDetalleReqLogResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<RequisicionLogDet> _return;

    /**
     * 
     * @return
     *     returns ArrayList<RequisicionLogDet>
     */
    public ArrayList<RequisicionLogDet> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<RequisicionLogDet> _return) {
        this._return = _return;
    }

}
