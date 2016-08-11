
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.InspeccionesGenDet;

@XmlRootElement(name = "GetInspeccionesGenDetResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInspeccionesGenDetResponse", namespace = "http://SOAP/")
public class GetInspeccionesGenDetResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<InspeccionesGenDet> _return;

    /**
     * 
     * @return
     *     returns ArrayList<InspeccionesGenDet>
     */
    public ArrayList<InspeccionesGenDet> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<InspeccionesGenDet> _return) {
        this._return = _return;
    }

}
