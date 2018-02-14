
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertDocsSugerencia", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertDocsSugerencia", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "linea",
    "descripcion",
    "nombrearchivo",
    "rutaarchivo",
    "ultusuario"
})
public class InsertDocsSugerencia {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "linea", namespace = "http://SOAP/")
    private String linea;
    @XmlElement(name = "descripcion", namespace = "http://SOAP/")
    private String descripcion;
    @XmlElement(name = "nombrearchivo", namespace = "http://SOAP/")
    private String nombrearchivo;
    @XmlElement(name = "rutaarchivo", namespace = "http://SOAP/")
    private String rutaarchivo;
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
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * 
     * @param descripcion
     *     the value for the descripcion property
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNombrearchivo() {
        return this.nombrearchivo;
    }

    /**
     * 
     * @param nombrearchivo
     *     the value for the nombrearchivo property
     */
    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getRutaarchivo() {
        return this.rutaarchivo;
    }

    /**
     * 
     * @param rutaarchivo
     *     the value for the rutaarchivo property
     */
    public void setRutaarchivo(String rutaarchivo) {
        this.rutaarchivo = rutaarchivo;
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
