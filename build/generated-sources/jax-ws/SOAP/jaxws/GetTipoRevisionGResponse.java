
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.TipoRevisionGBD;

@XmlRootElement(name = "GetTipoRevisionGResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTipoRevisionGResponse", namespace = "http://SOAP/")
public class GetTipoRevisionGResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<TipoRevisionGBD> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TipoRevisionGBD>
     */
    public ArrayList<TipoRevisionGBD> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<TipoRevisionGBD> _return) {
        this._return = _return;
    }

}
