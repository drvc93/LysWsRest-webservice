
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.SolicitudServicio;

@XmlRootElement(name = "ListSolcitudServResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSolcitudServResponse", namespace = "http://SOAP/")
public class ListSolcitudServResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<SolicitudServicio> _return;

    /**
     * 
     * @return
     *     returns ArrayList<SolicitudServicio>
     */
    public ArrayList<SolicitudServicio> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<SolicitudServicio> _return) {
        this._return = _return;
    }

}
