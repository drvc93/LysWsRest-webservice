
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.UnidadNegocio;

@XmlRootElement(name = "GetUnidadNegUsuarioResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUnidadNegUsuarioResponse", namespace = "http://SOAP/")
public class GetUnidadNegUsuarioResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<UnidadNegocio> _return;

    /**
     * 
     * @return
     *     returns ArrayList<UnidadNegocio>
     */
    public ArrayList<UnidadNegocio> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<UnidadNegocio> _return) {
        this._return = _return;
    }

}
