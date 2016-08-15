
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertInspMaqCab", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertInspMaqCab", namespace = "http://SOAP/", propOrder = {
    "correlativo",
    "compania",
    "maquina",
    "condicionMaquina",
    "comentario",
    "estado",
    "fechaIniInsp",
    "fechaFinInsp",
    "periodoInsp",
    "usuarioInsp",
    "usuaruioEnv",
    "ultimoUsuario"
})
public class InsertInspMaqCab {

    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "maquina", namespace = "http://SOAP/")
    private String maquina;
    @XmlElement(name = "condicionMaquina", namespace = "http://SOAP/")
    private String condicionMaquina;
    @XmlElement(name = "comentario", namespace = "http://SOAP/")
    private String comentario;
    @XmlElement(name = "estado", namespace = "http://SOAP/")
    private String estado;
    @XmlElement(name = "fechaIniInsp", namespace = "http://SOAP/")
    private String fechaIniInsp;
    @XmlElement(name = "fechaFinInsp", namespace = "http://SOAP/")
    private String fechaFinInsp;
    @XmlElement(name = "periodoInsp", namespace = "http://SOAP/")
    private String periodoInsp;
    @XmlElement(name = "usuarioInsp", namespace = "http://SOAP/")
    private String usuarioInsp;
    @XmlElement(name = "usuaruioEnv", namespace = "http://SOAP/")
    private String usuaruioEnv;
    @XmlElement(name = "ultimoUsuario", namespace = "http://SOAP/")
    private String ultimoUsuario;

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
    public String getCondicionMaquina() {
        return this.condicionMaquina;
    }

    /**
     * 
     * @param condicionMaquina
     *     the value for the condicionMaquina property
     */
    public void setCondicionMaquina(String condicionMaquina) {
        this.condicionMaquina = condicionMaquina;
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
    public String getFechaIniInsp() {
        return this.fechaIniInsp;
    }

    /**
     * 
     * @param fechaIniInsp
     *     the value for the fechaIniInsp property
     */
    public void setFechaIniInsp(String fechaIniInsp) {
        this.fechaIniInsp = fechaIniInsp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaFinInsp() {
        return this.fechaFinInsp;
    }

    /**
     * 
     * @param fechaFinInsp
     *     the value for the fechaFinInsp property
     */
    public void setFechaFinInsp(String fechaFinInsp) {
        this.fechaFinInsp = fechaFinInsp;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPeriodoInsp() {
        return this.periodoInsp;
    }

    /**
     * 
     * @param periodoInsp
     *     the value for the periodoInsp property
     */
    public void setPeriodoInsp(String periodoInsp) {
        this.periodoInsp = periodoInsp;
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
    public String getUsuaruioEnv() {
        return this.usuaruioEnv;
    }

    /**
     * 
     * @param usuaruioEnv
     *     the value for the usuaruioEnv property
     */
    public void setUsuaruioEnv(String usuaruioEnv) {
        this.usuaruioEnv = usuaruioEnv;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getUltimoUsuario() {
        return this.ultimoUsuario;
    }

    /**
     * 
     * @param ultimoUsuario
     *     the value for the ultimoUsuario property
     */
    public void setUltimoUsuario(String ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }

}
