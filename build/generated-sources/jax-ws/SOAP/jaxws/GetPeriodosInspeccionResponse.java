
package SOAP.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.lys.beans.PeriodoInspeccionDB;

@XmlRootElement(name = "GetPeriodosInspeccionResponse", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPeriodosInspeccionResponse", namespace = "http://SOAP/")
public class GetPeriodosInspeccionResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<PeriodoInspeccionDB> _return;

    /**
     * 
     * @return
     *     returns ArrayList<PeriodoInspeccionDB>
     */
    public ArrayList<PeriodoInspeccionDB> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<PeriodoInspeccionDB> _return) {
        this._return = _return;
    }

}
