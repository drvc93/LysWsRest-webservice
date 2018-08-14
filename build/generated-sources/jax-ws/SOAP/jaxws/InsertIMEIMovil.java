
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertIMEIMovil", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertIMEIMovil", namespace = "http://SOAP/", propOrder = {
    "imei",
    "tipo",
    "numero",
    "usuarioreg",
    "estado",
    "ultusuario",
    "ultfecha",
    "seriechip"
})
public class InsertIMEIMovil {

    @XmlElement(name = "imei", namespace = "http://SOAP/")
    private String imei;
    @XmlElement(name = "tipo", namespace = "http://SOAP/")
    private String tipo;
    @XmlElement(name = "numero", namespace = "http://SOAP/")
    private String numero;
    @XmlElement(name = "usuarioreg", namespace = "http://SOAP/")
    private String usuarioreg;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "ultusuario", namespace = "http://SOAP/")
    private String ultusuario;
    @XmlElement(name = "ultfecha", namespace = "http://SOAP/")
    private String ultfecha;
    @XmlElement(name = "seriechip", namespace = "http://SOAP/")
    private String seriechip;

    /**
     * 
     * @return
     *     returns String
     */
    public String getImei() {
        return this.imei;
    }

    /**
     * 
     * @param imei
     *     the value for the imei property
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

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
    public String getNumero() {
        return this.numero;
    }

    /**
     * 
     * @param numero
     *     the value for the numero property
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsuarioreg() {
        return this.usuarioreg;
    }

    /**
     * 
     * @param usuarioreg
     *     the value for the usuarioreg property
     */
    public void setUsuarioreg(String usuarioreg) {
        this.usuarioreg = usuarioreg;
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

    /**
     * 
     * @return
     *     returns String
     */
    public String getUltfecha() {
        return this.ultfecha;
    }

    /**
     * 
     * @param ultfecha
     *     the value for the ultfecha property
     */
    public void setUltfecha(String ultfecha) {
        this.ultfecha = ultfecha;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getSeriechip() {
        return this.seriechip;
    }

    /**
     * 
     * @param seriechip
     *     the value for the seriechip property
     */
    public void setSeriechip(String seriechip) {
        this.seriechip = seriechip;
    }

}
