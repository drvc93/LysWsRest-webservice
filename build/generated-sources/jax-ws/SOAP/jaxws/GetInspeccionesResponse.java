
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.Inspecciones;

@XmlRootElement(name = "GetInspeccionesResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInspeccionesResponse", namespace = "http://SOAP/")
public class GetInspeccionesResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<Inspecciones> _return;

    /**
     * 
     * @return
     *     returns ArrayList<Inspecciones>
     */
    public ArrayList<Inspecciones> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<Inspecciones> _return) {
        this._return = _return;
    }

}
