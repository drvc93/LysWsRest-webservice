
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertInspGenDet", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertInspGenDet", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "linea",
    "comentario",
    "rutaFoto",
    "ultUsuario",
    "tipoRev",
    "flagAdic"
})
public class InsertInspGenDet {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "linea", namespace = "http://SOAP/")
    private String linea;
    @XmlElement(name = "comentario", namespace = "http://SOAP/")
    private String comentario;
    @XmlElement(name = "rutaFoto", namespace = "http://SOAP/")
    private String rutaFoto;
    @XmlElement(name = "ultUsuario", namespace = "http://SOAP/")
    private String ultUsuario;
    @XmlElement(name = "tipoRev", namespace = "http://SOAP/")
    private String tipoRev;
    @XmlElement(name = "flagAdic", namespace = "http://SOAP/")
    private String flagAdic;

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
    public String getLinea() {
        return this.linea;
    }

    /**
     * 
     * @param linea
     *     the value for the linea property
     */
    public void setLinea(String linea) {
        this.linea = linea;
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
    public String getRutaFoto() {
        return this.rutaFoto;
    }

    /**
     * 
     * @param rutaFoto
     *     the value for the rutaFoto property
     */
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
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

    /**
     * 
     * @return
     *     returns String
     */
    public String getTipoRev() {
        return this.tipoRev;
    }

    /**
     * 
     * @param tipoRev
     *     the value for the tipoRev property
     */
    public void setTipoRev(String tipoRev) {
        this.tipoRev = tipoRev;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFlagAdic() {
        return this.flagAdic;
    }

    /**
     * 
     * @param flagAdic
     *     the value for the flagAdic property
     */
    public void setFlagAdic(String flagAdic) {
        this.flagAdic = flagAdic;
    }

}
