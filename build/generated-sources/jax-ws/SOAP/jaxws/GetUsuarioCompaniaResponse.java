
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.UsuarioCompania;

@XmlRootElement(name = "GetUsuarioCompaniaResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUsuarioCompaniaResponse", namespace = "http://SOAP/")
public class GetUsuarioCompaniaResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<UsuarioCompania> _return;

    /**
     * 
     * @return
     *     returns ArrayList<UsuarioCompania>
     */
    public ArrayList<UsuarioCompania> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<UsuarioCompania> _return) {
        this._return = _return;
    }

}
