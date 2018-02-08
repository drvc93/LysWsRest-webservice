
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.DocsReclamoGarantia;

@XmlRootElement(name = "GetListFotosRGResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListFotosRGResponse", namespace = "http://SOAP/")
public class GetListFotosRGResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<DocsReclamoGarantia> _return;

    /**
     * 
     * @return
     *     returns ArrayList<DocsReclamoGarantia>
     */
    public ArrayList<DocsReclamoGarantia> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<DocsReclamoGarantia> _return) {
        this._return = _return;
    }

}
