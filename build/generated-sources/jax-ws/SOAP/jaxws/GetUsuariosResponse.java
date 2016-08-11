
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.UsuarioDB;

@XmlRootElement(name = "GetUsuariosResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetUsuariosResponse", namespace = "http://SOAP/")
public class GetUsuariosResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<UsuarioDB> _return;

    /**
     * 
     * @return
     *     returns ArrayList<UsuarioDB>
     */
    public ArrayList<UsuarioDB> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<UsuarioDB> _return) {
        this._return = _return;
    }

}
