
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMADireccionCli;

@XmlRootElement(name = "GetListDireccionCliResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListDireccionCliResponse", namespace = "http://SOAP/")
public class GetListDireccionCliResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMADireccionCli> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMADireccionCli>
     */
    public ArrayList<TMADireccionCli> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMADireccionCli> _return) {
        this._return = _return;
    }

}
