
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ListQuejaCliente", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListQuejaCliente", namespace = "http://SOAP/", propOrder = {
    "compania",
    "cliente",
    "estado",
    "fecharegini",
    "fecharegfin"
})
public class ListQuejaCliente {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "cliente", namespace = "http://SOAP/")
    private String cliente;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "fecharegini", namespace = "http://SOAP/")
    private String fecharegini;
    @XmlElement(name = "fecharegfin", namespace = "http://SOAP/")
    private String fecharegfin;

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
    public String getCliente() {
        return this.cliente;
    }

    /**
     * 
     * @param cliente
     *     the value for the cliente property
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
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
    public String getFecharegini() {
        return this.fecharegini;
    }

    /**
     * 
     * @param fecharegini
     *     the value for the fecharegini property
     */
    public void setFecharegini(String fecharegini) {
        this.fecharegini = fecharegini;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFecharegfin() {
        return this.fecharegfin;
    }

    /**
     * 
     * @param fecharegfin
     *     the value for the fecharegfin property
     */
    public void setFecharegfin(String fecharegfin) {
        this.fecharegfin = fecharegfin;
    }

}
