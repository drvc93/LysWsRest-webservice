
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.Parametros;

@XmlRootElement(name = "ListUsersResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListUsersResponse", namespace = "http://SOAP/")
public class ListUsersResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private Parametros[] _return;

    /**
     * 
     * @return
     *     returns Parametros[]
     */
    public Parametros[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Parametros[] _return) {
        this._return = _return;
    }

}
