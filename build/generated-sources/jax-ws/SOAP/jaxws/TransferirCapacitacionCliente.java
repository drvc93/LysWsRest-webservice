
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "TransferirCapacitacionCliente", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferirCapacitacionCliente", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "accion"
})
public class TransferirCapacitacionCliente {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCompania() {
        return this.compania;
    }

    /**
     * 
     * @param compania
     *     the value for the compania property
     */
    public void setCompania(String compania) {
        this.compania = compania;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCorrelativo() {
        return this.correlativo;
    }

    /**
     * 
     * @param correlativo
     *     the value for the correlativo property
     */
    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getAccion() {
        return this.accion;
    }

    /**
     * 
     * @param accion
     *     the value for the accion property
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

}
