
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertInspGenCab", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertInspGenCab", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "tipoInsp",
    "codMaq",
    "codCentroC",
    "comentario",
    "usuarioInsp",
    "fechaInsp",
    "estado",
    "usuarioEnv",
    "ultUsuario"
})
public class InsertInspGenCab {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "tipoInsp", namespace = "http://SOAP/")
    private String tipoInsp;
    @XmlElement(name = "codMaq", namespace = "http://SOAP/")
    private String codMaq;
    @XmlElement(name = "codCentroC", namespace = "http://SOAP/")
    private String codCentroC;
    @XmlElement(name = "comentario", namespace = "http://SOAP/")
    private String comentario;
    @XmlElement(name = "usuarioInsp", namespace = "http://SOAP/")
    private String usuarioInsp;
    @XmlElement(name = "fechaInsp", namespace = "http://SOAP/")
    private String fechaInsp;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "usuarioEnv", namespace = "http://SOAP/")
    private String usuarioEnv;
    @XmlElement(name = "UltUsuario", namespace = "http://SOAP/")
    private String ultUsuario;

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
    public String getCorrelativo() {
        return this.correlativo;
    }

    /**
     * 
     * @param correlativo
     *     the value for the correlativo property
     */
    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipoInsp() {
        return this.tipoInsp;
    }

    /**
     * 
     * @param tipoInsp
     *     the value for the tipoInsp property
     */
    public void setTipoInsp(String tipoInsp) {
        this.tipoInsp = tipoInsp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodMaq() {
        return this.codMaq;
    }

    /**
     * 
     * @param codMaq
     *     the value for the codMaq property
     */
    public void setCodMaq(String codMaq) {
        this.codMaq = codMaq;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodCentroC() {
        return this.codCentroC;
    }

    /**
     * 
     * @param codCentroC
     *     the value for the codCentroC property
     */
    public void setCodCentroC(String codCentroC) {
        this.codCentroC = codCentroC;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getComentario() {
        return this.comentario;
    }

    /**
     * 
     * @param comentario
     *     the value for the comentario property
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUsuarioInsp() {
        return this.usuarioInsp;
    }

    /**
     * 
     * @param usuarioInsp
     *     the value for the usuarioInsp property
     */
    public void setUsuarioInsp(String usuarioInsp) {
        this.usuarioInsp = usuarioInsp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaInsp() {
        return this.fechaInsp;
    }

    /**
     * 
     * @param fechaInsp
     *     the value for the fechaInsp property
     */
    public void setFechaInsp(String fechaInsp) {
        this.fechaInsp = fechaInsp;
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
    public String getUsuarioEnv() {
        return this.usuarioEnv;
    }

    /**
     * 
     * @param usuarioEnv
     *     the value for the usuarioEnv property
     */
    public void setUsuarioEnv(String usuarioEnv) {
        this.usuarioEnv = usuarioEnv;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUltUsuario() {
        return this.ultUsuario;
    }

    /**
     * 
     * @param ultUsuario
     *     the value for the ultUsuario property
     */
    public void setUltUsuario(String ultUsuario) {
        this.ultUsuario = ultUsuario;
    }

}
