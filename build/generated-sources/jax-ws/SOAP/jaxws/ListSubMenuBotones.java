
package SOAP.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ListSubMenuBotones", namespace = "http://SOAP/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSubMenuBotones", namespace = "http://SOAP/", propOrder = {
    "codPadre",
    "codSubMenu",
    "codUsuario"
})
public class ListSubMenuBotones {

    @XmlElement(name = "CodPadre", namespace = "http://SOAP/")
    private String codPadre;
    @XmlElement(name = "CodSubMenu", namespace = "http://SOAP/")
    private String codSubMenu;
    @XmlElement(name = "CodUsuario", namespace = "http://SOAP/")
    private String codUsuario;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodPadre() {
        return this.codPadre;
    }

    /**
     * 
     * @param codPadre
     *     the value for the codPadre property
     */
    public void setCodPadre(String codPadre) {
        this.codPadre = codPadre;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodSubMenu() {
        return this.codSubMenu;
    }

    /**
     * 
     * @param codSubMenu
     *     the value for the codSubMenu property
     */
    public void setCodSubMenu(String codSubMenu) {
        this.codSubMenu = codSubMenu;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCodUsuario() {
        return this.codUsuario;
    }

    /**
     * 
     * @param codUsuario
     *     the value for the codUsuario property
     */
    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

}
