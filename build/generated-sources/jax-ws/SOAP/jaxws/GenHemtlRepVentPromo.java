
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GenHemtlRepVentPromo", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenHemtlRepVentPromo", namespace = "http://SOAP/", propOrder = {
    "compania",
    "ciasecundaria",
    "undnegoc",
    "vendedor",
    "periodo",
    "moneda",
    "usuario",
    "formato"
})
public class GenHemtlRepVentPromo {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "ciasecundaria", namespace = "http://SOAP/")
    private String ciasecundaria;
    @XmlElement(name = "undnegoc", namespace = "http://SOAP/")
    private String undnegoc;
    @XmlElement(name = "vendedor", namespace = "http://SOAP/")
    private String vendedor;
    @XmlElement(name = "periodo", namespace = "http://SOAP/")
    private String periodo;
    @XmlElement(name = "moneda", namespace = "http://SOAP/")
    private String moneda;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "formato", namespace = "http://SOAP/")
    private String formato;

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
    public String getCiasecundaria() {
        return this.ciasecundaria;
    }

    /**
     * 
     * @param ciasecundaria
     *     the value for the ciasecundaria property
     */
    public void setCiasecundaria(String ciasecundaria) {
        this.ciasecundaria = ciasecundaria;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUndnegoc() {
        return this.undnegoc;
    }

    /**
     * 
     * @param undnegoc
     *     the value for the undnegoc property
     */
    public void setUndnegoc(String undnegoc) {
        this.undnegoc = undnegoc;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getVendedor() {
        return this.vendedor;
    }

    /**
     * 
     * @param vendedor
     *     the value for the vendedor property
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
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
    public String getMoneda() {
        return this.moneda;
    }

    /**
     * 
     * @param moneda
     *     the value for the moneda property
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
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
    public String getFormato() {
        return this.formato;
    }

    /**
     * 
     * @param formato
     *     the value for the formato property
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

}
