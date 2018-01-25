
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnvioCorreoAprobReqLog", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvioCorreoAprobReqLog", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nroreq",
    "usuario",
    "estado",
    "ccosto"
})
public class EnvioCorreoAprobReqLog {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nroreq", namespace = "http://SOAP/")
    private String nroreq;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "ccosto", namespace = "http://SOAP/")
    private String ccosto;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsuario() {
        return this.usuario;
    }

    /**
     * 
     * @param usuario
     *     the value for the usuario property
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

}
