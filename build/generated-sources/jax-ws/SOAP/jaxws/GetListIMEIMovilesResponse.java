
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.IMEMovil;

@XmlRootElement(name = "GetListIMEIMovilesResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListIMEIMovilesResponse", namespace = "http://SOAP/")
public class GetListIMEIMovilesResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<IMEMovil> _return;

    /**
     * 
     * @return
     *     returns ArrayList<IMEMovil>
     */
    public ArrayList<IMEMovil> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<IMEMovil> _return) {
        this._return = _return;
    }

}
