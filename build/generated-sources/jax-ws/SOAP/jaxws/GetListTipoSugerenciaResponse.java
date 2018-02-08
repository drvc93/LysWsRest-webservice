
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TMATipoSugerencia;

@XmlRootElement(name = "GetListTipoSugerenciaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListTipoSugerenciaResponse", namespace = "http://SOAP/")
public class GetListTipoSugerenciaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TMATipoSugerencia> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TMATipoSugerencia>
     */
    public ArrayList<TMATipoSugerencia> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TMATipoSugerencia> _return) {
        this._return = _return;
    }

}
