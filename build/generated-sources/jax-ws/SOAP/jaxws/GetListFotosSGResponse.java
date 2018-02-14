
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.DocsSugerencia;

@XmlRootElement(name = "GetListFotosSGResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListFotosSGResponse", namespace = "http://SOAP/")
public class GetListFotosSGResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<DocsSugerencia> _return;

    /**
     * 
     * @return
     *     returns ArrayList<DocsSugerencia>
     */
    public ArrayList<DocsSugerencia> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<DocsSugerencia> _return) {
        this._return = _return;
    }

}
