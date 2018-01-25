
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.UsuarioSolicitante;

@XmlRootElement(name = "ListUsuarioSolcitResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListUsuarioSolcitResponse", namespace = "http://SOAP/")
public class ListUsuarioSolcitResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<UsuarioSolicitante> _return;

    /**
     * 
     * @return
     *     returns ArrayList<UsuarioSolicitante>
     */
    public ArrayList<UsuarioSolicitante> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<UsuarioSolicitante> _return) {
        this._return = _return;
    }

}
