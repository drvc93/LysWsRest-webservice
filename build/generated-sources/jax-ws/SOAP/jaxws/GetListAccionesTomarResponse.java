
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMAAccionesTomar;

@XmlRootElement(name = "GetListAccionesTomarResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListAccionesTomarResponse", namespace = "http://SOAP/")
public class GetListAccionesTomarResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMAAccionesTomar> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMAAccionesTomar>
     */
    public ArrayList<TMAAccionesTomar> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMAAccionesTomar> _return) {
        this._return = _return;
    }

}
