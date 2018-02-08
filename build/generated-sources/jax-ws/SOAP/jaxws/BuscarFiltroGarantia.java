
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "BuscarFiltroGarantia", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuscarFiltroGarantia", namespace = "http://SOAP/", propOrder = {
    "tipo",
    "compania",
    "cliente",
    "factura",
    "item"
})
public class BuscarFiltroGarantia {

    @XmlElement(name = "tipo", namespace = "http://SOAP/")
    private String tipo;
    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "cliente", namespace = "http://SOAP/")
    private String cliente;
    @XmlElement(name = "factura", namespace = "http://SOAP/")
    private String factura;
    @XmlElement(name = "item", namespace = "http://SOAP/")
    private String item;

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * 
     * @param tipo
     *     the value for the tipo property
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

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
    public String getFactura() {
        return this.factura;
    }

    /**
     * 
     * @param factura
     *     the value for the factura property
     */
    public void setFactura(String factura) {
        this.factura = factura;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getItem() {
        return this.item;
    }

    /**
     * 
     * @param item
     *     the value for the item property
     */
    public void setItem(String item) {
        this.item = item;
    }

}
