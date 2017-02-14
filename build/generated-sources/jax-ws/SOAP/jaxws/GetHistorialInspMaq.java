
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetHistorialInspMaq", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHistorialInspMaq", namespace = "http://SOAP/", propOrder = {
    "accion",
    "maquina",
    "centrocosto",
    "fechaIni",
    "fechaFin"
})
public class GetHistorialInspMaq {

    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;
    @XmlElement(name = "maquina", namespace = "http://SOAP/")
    private String maquina;
    @XmlElement(name = "centrocosto", namespace = "http://SOAP/")
    private String centrocosto;
    @XmlElement(name = "fechaIni", namespace = "http://SOAP/")
    private String fechaIni;
    @XmlElement(name = "fechaFin", namespace = "http://SOAP/")
    private String fechaFin;

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
    public String getMaquina() {
        return this.maquina;
    }

    /**
     * 
     * @param maquina
     *     the value for the maquina property
     */
    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCentrocosto() {
        return this.centrocosto;
    }

    /**
     * 
     * @param centrocosto
     *     the value for the centrocosto property
     */
    public void setCentrocosto(String centrocosto) {
        this.centrocosto = centrocosto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaIni() {
        return this.fechaIni;
    }

    /**
     * 
     * @param fechaIni
     *     the value for the fechaIni property
     */
    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaFin() {
        return this.fechaFin;
    }

    /**
     * 
     * @param fechaFin
     *     the value for the fechaFin property
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

}
