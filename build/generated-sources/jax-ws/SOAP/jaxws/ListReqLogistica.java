
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ListReqLogistica", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListReqLogistica", namespace = "http://SOAP/", propOrder = {
    "compania",
    "ccosto",
    "estado",
    "fechainicio",
    "fechafin",
    "nroreq"
})
public class ListReqLogistica {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "ccosto", namespace = "http://SOAP/")
    private String ccosto;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "fechainicio", namespace = "http://SOAP/")
    private String fechainicio;
    @XmlElement(name = "fechafin", namespace = "http://SOAP/")
    private String fechafin;
    @XmlElement(name = "nroreq", namespace = "http://SOAP/")
    private String nroreq;

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
    public String getCcosto() {
        return this.ccosto;
    }

    /**
     * 
     * @param ccosto
     *     the value for the ccosto property
     */
    public void setCcosto(String ccosto) {
        this.ccosto = ccosto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEstado() {
        return this.estado;
    }

    /**
     * 
     * @param estado
     *     the value for the estado property
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechainicio() {
        return this.fechainicio;
    }

    /**
     * 
     * @param fechainicio
     *     the value for the fechainicio property
     */
    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechafin() {
        return this.fechafin;
    }

    /**
     * 
     * @param fechafin
     *     the value for the fechafin property
     */
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNroreq() {
        return this.nroreq;
    }

    /**
     * 
     * @param nroreq
     *     the value for the nroreq property
     */
    public void setNroreq(String nroreq) {
        this.nroreq = nroreq;
    }

}
