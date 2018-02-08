
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "InsertReclamoGarantia", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertReclamoGarantia", namespace = "http://SOAP/", propOrder = {
    "compania",
    "correlativo",
    "accion",
    "usuario",
    "tiporeclamo",
    "fecha",
    "formato",
    "fechaformato",
    "cliente",
    "filtro",
    "lotefiltro",
    "procedencia",
    "facturaref",
    "lote1",
    "lote2",
    "lote3",
    "cantlote1",
    "cantlote2",
    "cantlote3",
    "tiempouso",
    "marca",
    "modelo",
    "year",
    "placavech",
    "obervclie",
    "pruebalab1",
    "pruebalab2",
    "pruebalab3",
    "ensayo1",
    "ensayo2",
    "ensayo3",
    "ensayo4",
    "ensayo5",
    "prediagvend",
    "prediagobse",
    "reembolsocli",
    "reembolsomto",
    "reembolsomon",
    "necesitavisita"
})
public class InsertReclamoGarantia {

    @XmlElement(name = "compania", namespace = "http://SOAP/")
    private String compania;
    @XmlElement(name = "correlativo", namespace = "http://SOAP/")
    private String correlativo;
    @XmlElement(name = "accion", namespace = "http://SOAP/")
    private String accion;
    @XmlElement(name = "usuario", namespace = "http://SOAP/")
    private String usuario;
    @XmlElement(name = "tiporeclamo", namespace = "http://SOAP/")
    private String tiporeclamo;
    @XmlElement(name = "fecha", namespace = "http://SOAP/")
    private String fecha;
    @XmlElement(name = "formato", namespace = "http://SOAP/")
    private String formato;
    @XmlElement(name = "fechaformato", namespace = "http://SOAP/")
    private String fechaformato;
    @XmlElement(name = "cliente", namespace = "http://SOAP/")
    private String cliente;
    @XmlElement(name = "filtro", namespace = "http://SOAP/")
    private String filtro;
    @XmlElement(name = "lotefiltro", namespace = "http://SOAP/")
    private String lotefiltro;
    @XmlElement(name = "procedencia", namespace = "http://SOAP/")
    private String procedencia;
    @XmlElement(name = "facturaref", namespace = "http://SOAP/")
    private String facturaref;
    @XmlElement(name = "lote1", namespace = "http://SOAP/")
    private String lote1;
    @XmlElement(name = "lote2", namespace = "http://SOAP/")
    private String lote2;
    @XmlElement(name = "lote3", namespace = "http://SOAP/")
    private String lote3;
    @XmlElement(name = "cantlote1", namespace = "http://SOAP/")
    private String cantlote1;
    @XmlElement(name = "cantlote2", namespace = "http://SOAP/")
    private String cantlote2;
    @XmlElement(name = "cantlote3", namespace = "http://SOAP/")
    private String cantlote3;
    @XmlElement(name = "tiempouso", namespace = "http://SOAP/")
    private String tiempouso;
    @XmlElement(name = "marca", namespace = "http://SOAP/")
    private String marca;
    @XmlElement(name = "modelo", namespace = "http://SOAP/")
    private String modelo;
    @XmlElement(name = "year", namespace = "http://SOAP/")
    private String year;
    @XmlElement(name = "placavech", namespace = "http://SOAP/")
    private String placavech;
    @XmlElement(name = "obervclie", namespace = "http://SOAP/")
    private String obervclie;
    @XmlElement(name = "pruebalab1", namespace = "http://SOAP/")
    private String pruebalab1;
    @XmlElement(name = "pruebalab2", namespace = "http://SOAP/")
    private String pruebalab2;
    @XmlElement(name = "pruebalab3", namespace = "http://SOAP/")
    private String pruebalab3;
    @XmlElement(name = "ensayo1", namespace = "http://SOAP/")
    private String ensayo1;
    @XmlElement(name = "ensayo2", namespace = "http://SOAP/")
    private String ensayo2;
    @XmlElement(name = "ensayo3", namespace = "http://SOAP/")
    private String ensayo3;
    @XmlElement(name = "ensayo4", namespace = "http://SOAP/")
    private String ensayo4;
    @XmlElement(name = "ensayo5", namespace = "http://SOAP/")
    private String ensayo5;
    @XmlElement(name = "prediagvend", namespace = "http://SOAP/")
    private String prediagvend;
    @XmlElement(name = "prediagobse", namespace = "http://SOAP/")
    private String prediagobse;
    @XmlElement(name = "reembolsocli", namespace = "http://SOAP/")
    private String reembolsocli;
    @XmlElement(name = "reembolsomto", namespace = "http://SOAP/")
    private String reembolsomto;
    @XmlElement(name = "reembolsomon", namespace = "http://SOAP/")
    private String reembolsomon;
    @XmlElement(name = "necesitavisita", namespace = "http://SOAP/")
    private String necesitavisita;

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
    public String getAccion() {
        return this.accion;
    }

    /**
     * 
     * @param accion
     *     the value for the accion property
     */
    public void setAccion(String accion) {
        this.accion = accion;
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
    public String getTiporeclamo() {
        return this.tiporeclamo;
    }

    /**
     * 
     * @param tiporeclamo
     *     the value for the tiporeclamo property
     */
    public void setTiporeclamo(String tiporeclamo) {
        this.tiporeclamo = tiporeclamo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * 
     * @param fecha
     *     the value for the fecha property
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    /**
     * 
     * @return
     *     returns String
     */
    public String getFechaformato() {
        return this.fechaformato;
    }

    /**
     * 
     * @param fechaformato
     *     the value for the fechaformato property
     */
    public void setFechaformato(String fechaformato) {
        this.fechaformato = fechaformato;
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
    public String getFiltro() {
        return this.filtro;
    }

    /**
     * 
     * @param filtro
     *     the value for the filtro property
     */
    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLotefiltro() {
        return this.lotefiltro;
    }

    /**
     * 
     * @param lotefiltro
     *     the value for the lotefiltro property
     */
    public void setLotefiltro(String lotefiltro) {
        this.lotefiltro = lotefiltro;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getProcedencia() {
        return this.procedencia;
    }

    /**
     * 
     * @param procedencia
     *     the value for the procedencia property
     */
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getFacturaref() {
        return this.facturaref;
    }

    /**
     * 
     * @param facturaref
     *     the value for the facturaref property
     */
    public void setFacturaref(String facturaref) {
        this.facturaref = facturaref;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLote1() {
        return this.lote1;
    }

    /**
     * 
     * @param lote1
     *     the value for the lote1 property
     */
    public void setLote1(String lote1) {
        this.lote1 = lote1;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLote2() {
        return this.lote2;
    }

    /**
     * 
     * @param lote2
     *     the value for the lote2 property
     */
    public void setLote2(String lote2) {
        this.lote2 = lote2;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLote3() {
        return this.lote3;
    }

    /**
     * 
     * @param lote3
     *     the value for the lote3 property
     */
    public void setLote3(String lote3) {
        this.lote3 = lote3;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCantlote1() {
        return this.cantlote1;
    }

    /**
     * 
     * @param cantlote1
     *     the value for the cantlote1 property
     */
    public void setCantlote1(String cantlote1) {
        this.cantlote1 = cantlote1;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCantlote2() {
        return this.cantlote2;
    }

    /**
     * 
     * @param cantlote2
     *     the value for the cantlote2 property
     */
    public void setCantlote2(String cantlote2) {
        this.cantlote2 = cantlote2;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCantlote3() {
        return this.cantlote3;
    }

    /**
     * 
     * @param cantlote3
     *     the value for the cantlote3 property
     */
    public void setCantlote3(String cantlote3) {
        this.cantlote3 = cantlote3;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getTiempouso() {
        return this.tiempouso;
    }

    /**
     * 
     * @param tiempouso
     *     the value for the tiempouso property
     */
    public void setTiempouso(String tiempouso) {
        this.tiempouso = tiempouso;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * 
     * @param marca
     *     the value for the marca property
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getModelo() {
        return this.modelo;
    }

    /**
     * 
     * @param modelo
     *     the value for the modelo property
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getYear() {
        return this.year;
    }

    /**
     * 
     * @param year
     *     the value for the year property
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPlacavech() {
        return this.placavech;
    }

    /**
     * 
     * @param placavech
     *     the value for the placavech property
     */
    public void setPlacavech(String placavech) {
        this.placavech = placavech;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getObervclie() {
        return this.obervclie;
    }

    /**
     * 
     * @param obervclie
     *     the value for the obervclie property
     */
    public void setObervclie(String obervclie) {
        this.obervclie = obervclie;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPruebalab1() {
        return this.pruebalab1;
    }

    /**
     * 
     * @param pruebalab1
     *     the value for the pruebalab1 property
     */
    public void setPruebalab1(String pruebalab1) {
        this.pruebalab1 = pruebalab1;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPruebalab2() {
        return this.pruebalab2;
    }

    /**
     * 
     * @param pruebalab2
     *     the value for the pruebalab2 property
     */
    public void setPruebalab2(String pruebalab2) {
        this.pruebalab2 = pruebalab2;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPruebalab3() {
        return this.pruebalab3;
    }

    /**
     * 
     * @param pruebalab3
     *     the value for the pruebalab3 property
     */
    public void setPruebalab3(String pruebalab3) {
        this.pruebalab3 = pruebalab3;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEnsayo1() {
        return this.ensayo1;
    }

    /**
     * 
     * @param ensayo1
     *     the value for the ensayo1 property
     */
    public void setEnsayo1(String ensayo1) {
        this.ensayo1 = ensayo1;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEnsayo2() {
        return this.ensayo2;
    }

    /**
     * 
     * @param ensayo2
     *     the value for the ensayo2 property
     */
    public void setEnsayo2(String ensayo2) {
        this.ensayo2 = ensayo2;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEnsayo3() {
        return this.ensayo3;
    }

    /**
     * 
     * @param ensayo3
     *     the value for the ensayo3 property
     */
    public void setEnsayo3(String ensayo3) {
        this.ensayo3 = ensayo3;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEnsayo4() {
        return this.ensayo4;
    }

    /**
     * 
     * @param ensayo4
     *     the value for the ensayo4 property
     */
    public void setEnsayo4(String ensayo4) {
        this.ensayo4 = ensayo4;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getEnsayo5() {
        return this.ensayo5;
    }

    /**
     * 
     * @param ensayo5
     *     the value for the ensayo5 property
     */
    public void setEnsayo5(String ensayo5) {
        this.ensayo5 = ensayo5;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPrediagvend() {
        return this.prediagvend;
    }

    /**
     * 
     * @param prediagvend
     *     the value for the prediagvend property
     */
    public void setPrediagvend(String prediagvend) {
        this.prediagvend = prediagvend;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getPrediagobse() {
        return this.prediagobse;
    }

    /**
     * 
     * @param prediagobse
     *     the value for the prediagobse property
     */
    public void setPrediagobse(String prediagobse) {
        this.prediagobse = prediagobse;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getReembolsocli() {
        return this.reembolsocli;
    }

    /**
     * 
     * @param reembolsocli
     *     the value for the reembolsocli property
     */
    public void setReembolsocli(String reembolsocli) {
        this.reembolsocli = reembolsocli;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getReembolsomto() {
        return this.reembolsomto;
    }

    /**
     * 
     * @param reembolsomto
     *     the value for the reembolsomto property
     */
    public void setReembolsomto(String reembolsomto) {
        this.reembolsomto = reembolsomto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getReembolsomon() {
        return this.reembolsomon;
    }

    /**
     * 
     * @param reembolsomon
     *     the value for the reembolsomon property
     */
    public void setReembolsomon(String reembolsomon) {
        this.reembolsomon = reembolsomon;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNecesitavisita() {
        return this.necesitavisita;
    }

    /**
     * 
     * @param necesitavisita
     *     the value for the necesitavisita property
     */
    public void setNecesitavisita(String necesitavisita) {
        this.necesitavisita = necesitavisita;
    }

}
