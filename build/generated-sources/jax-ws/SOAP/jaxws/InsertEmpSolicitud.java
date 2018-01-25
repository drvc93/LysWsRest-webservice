
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertEmpSolicitud", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertEmpSolicitud", namespace = "http://SOAP/", propOrder = {
    "compania",
    "nrosolicitud",
    "nsecuencia",
    "compempleado",
    "nempleado",
    "ultusuario"
})
public class InsertEmpSolicitud {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "nrosolicitud", namespace = "http://SOAP/")
    private String nrosolicitud;
    @XmlElement(name = "nsecuencia", namespace = "http://SOAP/")
    private String nsecuencia;
    @XmlElement(name = "compempleado", namespace = "http://SOAP/")
    private String compempleado;
    @XmlElement(name = "nempleado", namespace = "http://SOAP/")
    private String nempleado;
    @XmlElement(name = "ultusuario", namespace = "http://SOAP/")
    private String ultusuario;

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
    public String getNrosolicitud() {
        return this.nrosolicitud;
    }

    /**
     * 
     * @param nrosolicitud
     *     the value for the nrosolicitud property
     */
    public void setNrosolicitud(String nrosolicitud) {
        this.nrosolicitud = nrosolicitud;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNsecuencia() {
        return this.nsecuencia;
    }

    /**
     * 
     * @param nsecuencia
     *     the value for the nsecuencia property
     */
    public void setNsecuencia(String nsecuencia) {
        this.nsecuencia = nsecuencia;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCompempleado() {
        return this.compempleado;
    }

    /**
     * 
     * @param compempleado
     *     the value for the compempleado property
     */
    public void setCompempleado(String compempleado) {
        this.compempleado = compempleado;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNempleado() {
        return this.nempleado;
    }

    /**
     * 
     * @param nempleado
     *     the value for the nempleado property
     */
    public void setNempleado(String nempleado) {
        this.nempleado = nempleado;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUltusuario() {
        return this.ultusuario;
    }

    /**
     * 
     * @param ultusuario
     *     the value for the ultusuario property
     */
    public void setUltusuario(String ultusuario) {
        this.ultusuario = ultusuario;
    }

}
