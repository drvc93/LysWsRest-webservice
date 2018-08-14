
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.OpcionConsulta;

@XmlRootElement(name = "GetOpcionesConsultaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOpcionesConsultaResponse", namespace = "http://SOAP/")
public class GetOpcionesConsultaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<OpcionConsulta> _return;

    /**
     * 
     * @return
     *     returns ArrayList<OpcionConsulta>
     */
    public ArrayList<OpcionConsulta> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<OpcionConsulta> _return) {
        this._return = _return;
    }

}
