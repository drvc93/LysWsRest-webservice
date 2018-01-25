
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMAModelo;

@XmlRootElement(name = "GetListaModelosResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListaModelosResponse", namespace = "http://SOAP/")
public class GetListaModelosResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMAModelo> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMAModelo>
     */
    public ArrayList<TMAModelo> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMAModelo> _return) {
        this._return = _return;
    }

}
