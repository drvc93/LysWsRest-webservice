
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.InspeccionesMaqDet;

@XmlRootElement(name = "GetInspeccionesMaqDetResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInspeccionesMaqDetResponse", namespace = "http://SOAP/")
public class GetInspeccionesMaqDetResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<InspeccionesMaqDet> _return;

    /**
     * 
     * @return
     *     returns ArrayList<InspeccionesMaqDet>
     */
    public ArrayList<InspeccionesMaqDet> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<InspeccionesMaqDet> _return) {
        this._return = _return;
    }

}
