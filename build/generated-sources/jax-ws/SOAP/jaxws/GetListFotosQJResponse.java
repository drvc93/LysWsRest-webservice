
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.DocsQuejaCliente;

@XmlRootElement(name = "GetListFotosQJResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListFotosQJResponse", namespace = "http://SOAP/")
public class GetListFotosQJResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<DocsQuejaCliente> _return;

    /**
     * 
     * @return
     *     returns ArrayList<DocsQuejaCliente>
     */
    public ArrayList<DocsQuejaCliente> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<DocsQuejaCliente> _return) {
        this._return = _return;
    }

}
