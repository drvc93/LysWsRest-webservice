
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.EFacSerLot;

@XmlRootElement(name = "BuscarFiltroGarantiaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuscarFiltroGarantiaResponse", namespace = "http://SOAP/")
public class BuscarFiltroGarantiaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<EFacSerLot> _return;

    /**
     * 
     * @return
     *     returns ArrayList<EFacSerLot>
     */
    public ArrayList<EFacSerLot> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<EFacSerLot> _return) {
        this._return = _return;
    }

}
