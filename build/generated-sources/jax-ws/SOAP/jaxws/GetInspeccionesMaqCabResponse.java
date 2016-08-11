
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.InspeccionesMaqCab;

@XmlRootElement(name = "GetInspeccionesMaqCabResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInspeccionesMaqCabResponse", namespace = "http://SOAP/")
public class GetInspeccionesMaqCabResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<InspeccionesMaqCab> _return;

    /**
     * 
     * @return
     *     returns ArrayList<InspeccionesMaqCab>
     */
    public ArrayList<InspeccionesMaqCab> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<InspeccionesMaqCab> _return) {
        this._return = _return;
    }

}
