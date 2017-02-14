
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetHistorialInspGen", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHistorialInspGen", namespace = "http://SOAP/", propOrder = {
    "accion",
    "tipoInsp",
    "fInicio",
    "fFin"
})
public class GetHistorialInspGen {

    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;
    @XmlElement(name = "tipoInsp", namespace = "http://SOAP/")
    private String tipoInsp;
    @XmlElement(name = "FInicio", namespace = "http://SOAP/")
    private String fInicio;
    @XmlElement(name = "FFin", namespace = "http://SOAP/")
    private String fFin;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipoInsp() {
        return this.tipoInsp;
    }

    /**
     * 
     * @param tipoInsp
     *     the value for the tipoInsp property
     */
    public void setTipoInsp(String tipoInsp) {
        this.tipoInsp = tipoInsp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFInicio() {
        return this.fInicio;
    }

    /**
     * 
     * @param fInicio
     *     the value for the fInicio property
     */
    public void setFInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFFin() {
        return this.fFin;
    }

    /**
     * 
     * @param fFin
     *     the value for the fFin property
     */
    public void setFFin(String fFin) {
        this.fFin = fFin;
    }

}
