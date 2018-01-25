
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.CentroCostoDB;

@XmlRootElement(name = "GetCentroCostoXCompaniaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCentroCostoXCompaniaResponse", namespace = "http://SOAP/")
public class GetCentroCostoXCompaniaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<CentroCostoDB> _return;

    /**
     * 
     * @return
     *     returns ArrayList<CentroCostoDB>
     */
    public ArrayList<CentroCostoDB> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<CentroCostoDB> _return) {
        this._return = _return;
    }

}
