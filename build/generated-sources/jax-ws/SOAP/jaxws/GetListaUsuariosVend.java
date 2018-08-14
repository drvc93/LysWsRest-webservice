
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetListaUsuariosVend", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetListaUsuariosVend", namespace = "http://SOAP/", propOrder = {
    "compania",
    "periodo",
    "usuario",
    "undnego"
})
public class GetListaUsuariosVend {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "periodo", namespace = "http://SOAP/")
    private String periodo;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "undnego", namespace = "http://SOAP/")
    private String undnego;

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
    public String getPeriodo() {
        return this.periodo;
    }

    /**
     * 
     * @param periodo
     *     the value for the periodo property
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
    public String getUndnego() {
        return this.undnego;
    }

    /**
     * 
     * @param undnego
     *     the value for the undnego property
     */
    public void setUndnego(String undnego) {
        this.undnego = undnego;
    }

}
