
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.InspeccionesGenCab;

@XmlRootElement(name = "GetInspeccionesGenCabResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInspeccionesGenCabResponse", namespace = "http://SOAP/")
public class GetInspeccionesGenCabResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<InspeccionesGenCab> _return;

    /**
     * 
     * @return
     *     returns ArrayList<InspeccionesGenCab>
     */
    public ArrayList<InspeccionesGenCab> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<InspeccionesGenCab> _return) {
        this._return = _return;
    }

}
