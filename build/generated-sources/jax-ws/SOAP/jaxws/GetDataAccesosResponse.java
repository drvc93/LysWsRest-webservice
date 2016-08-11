
package SOAP.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.AccesosDB;

@XmlRootElement(name = "GetDataAccesosResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDataAccesosResponse", namespace = "http://SOAP/")
public class GetDataAccesosResponse {

    @XmlElement(name = "return", namespace = "")
    private List<AccesosDB> _return;

    /**
     * 
     * @return
     *     returns List<AccesosDB>
     */
    public List<AccesosDB> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<AccesosDB> _return) {
        this._return = _return;
    }

}
