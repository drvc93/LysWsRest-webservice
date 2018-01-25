
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ListSolcitudServ", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSolcitudServ", namespace = "http://SOAP/", propOrder = {
    "compania",
    "flagfecha",
    "fechaini",
    "fechafin",
    "maquina",
    "prioridad",
    "estado",
    "personasolicit",
    "nsolicitud"
})
public class ListSolcitudServ {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "flagfecha", namespace = "http://SOAP/")
    private String flagfecha;
    @XmlElement(name = "fechaini", namespace = "http://SOAP/")
    private String fechaini;
    @XmlElement(name = "fechafin", namespace = "http://SOAP/")
    private String fechafin;
    @XmlElement(name = "maquina", namespace = "http://SOAP/")
    private String maquina;
    @XmlElement(name = "prioridad", namespace = "http://SOAP/")
    private String prioridad;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "personasolicit", namespace = "http://SOAP/")
    private String personasolicit;
    @XmlElement(name = "nsolicitud", namespace = "http://SOAP/")
    private String nsolicitud;

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
    public String getFlagfecha() {
        return this.flagfecha;
    }

    /**
     * 
     * @param flagfecha
     *     the value for the flagfecha property
     */
    public void setFlagfecha(String flagfecha) {
        this.flagfecha = flagfecha;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaini() {
        return this.fechaini;
    }

    /**
     * 
     * @param fechaini
     *     the value for the fechaini property
     */
    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
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
    public String getPrioridad() {
        return this.prioridad;
    }

    /**
     * 
     * @param prioridad
     *     the value for the prioridad property
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
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
    public String getPersonasolicit() {
        return this.personasolicit;
    }

    /**
     * 
     * @param personasolicit
     *     the value for the personasolicit property
     */
    public void setPersonasolicit(String personasolicit) {
        this.personasolicit = personasolicit;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNsolicitud() {
        return this.nsolicitud;
    }

    /**
     * 
     * @param nsolicitud
     *     the value for the nsolicitud property
     */
    public void setNsolicitud(String nsolicitud) {
        this.nsolicitud = nsolicitud;
    }

}
