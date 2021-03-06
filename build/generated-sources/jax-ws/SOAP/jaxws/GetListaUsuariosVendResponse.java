
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.UsuarioPromotor;

@XmlRootElement(name = "GetListaUsuariosVendResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListaUsuariosVendResponse", namespace = "http://SOAP/")
public class GetListaUsuariosVendResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<UsuarioPromotor> _return;

    /**
     * 
     * @return
     *     returns ArrayList<UsuarioPromotor>
     */
    public ArrayList<UsuarioPromotor> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<UsuarioPromotor> _return) {
        this._return = _return;
    }

}
