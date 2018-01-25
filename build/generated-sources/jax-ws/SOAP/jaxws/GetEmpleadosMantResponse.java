
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.EmpleadoMant;

@XmlRootElement(name = "GetEmpleadosMantResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEmpleadosMantResponse", namespace = "http://SOAP/")
public class GetEmpleadosMantResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<EmpleadoMant> _return;

    /**
     * 
     * @return
     *     returns ArrayList<EmpleadoMant>
     */
    public ArrayList<EmpleadoMant> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<EmpleadoMant> _return) {
        this._return = _return;
    }

}
