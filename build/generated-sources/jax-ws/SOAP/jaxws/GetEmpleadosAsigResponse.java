
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.EmpAsigSolicitud;

@XmlRootElement(name = "GetEmpleadosAsigResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEmpleadosAsigResponse", namespace = "http://SOAP/")
public class GetEmpleadosAsigResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<EmpAsigSolicitud> _return;

    /**
     * 
     * @return
     *     returns ArrayList<EmpAsigSolicitud>
     */
    public ArrayList<EmpAsigSolicitud> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<EmpAsigSolicitud> _return) {
        this._return = _return;
    }

}
