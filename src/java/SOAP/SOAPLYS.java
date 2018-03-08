/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import com.lys.beans.AccesosDB;
import com.lys.beans.CapacitacionCliente;
import com.lys.beans.CentroCostoDB;
import com.lys.beans.CorreoApReqLog;
import com.lys.beans.CorreoUsuarioCCosto;
import com.lys.beans.DocsCapacitacion;
import com.lys.beans.DocsQuejaCliente;
import com.lys.beans.DocsReclamoGarantia;
import com.lys.beans.DocsSugerencia;
import com.lys.beans.EFacSerLot;
import com.lys.beans.EmpAsigSolicitud;
import com.lys.beans.EmpleadoMant;
import com.lys.beans.HistorialInspGen;
import com.lys.beans.HistorialInspMaq;
import com.lys.beans.IMEMovil;
import com.lys.beans.Inspecciones;
import com.lys.beans.InspeccionesGenCab;
import com.lys.beans.InspeccionesGenDet;
import com.lys.beans.InspeccionesMaqCab;
import com.lys.beans.InspeccionesMaqDet;
import com.lys.beans.Maquina;
import com.lys.beans.Menu;
import com.lys.beans.MenuDB;
import com.lys.beans.Parametros;
import com.lys.beans.ParametrosSist;
import com.lys.beans.PeriodoInspeccionDB;
import com.lys.beans.QuejaCliente;
import com.lys.beans.Rechazos;
import com.lys.beans.ReclamoGarantia;
import com.lys.beans.RequisicionLogCab;
import com.lys.beans.RequisicionLogDet;
import com.lys.beans.SolicitudServicio;
import com.lys.beans.SubMenu;
import com.lys.beans.SubMenuBotones;
import com.lys.beans.SugerenciaCliente;
import com.lys.beans.TMAAccionesTomar;
import com.lys.beans.TMACalificacionQueja;
import com.lys.beans.TMACliente;
import com.lys.beans.TMADireccionCli;
import com.lys.beans.TMAFalla;
import com.lys.beans.TMAMarca;
import com.lys.beans.TMAMedioRecepcion;
import com.lys.beans.TMAModelo;
import com.lys.beans.TMANotificacionQueja;
import com.lys.beans.TMAPruebaLab;
import com.lys.beans.TMATemaCapacitacion;
import com.lys.beans.TMATipoCalificacionQueja;
import com.lys.beans.TMATipoReclamo;
import com.lys.beans.TMATipoSugerencia;
import com.lys.beans.TMAVendedor;
import com.lys.beans.TipoRevisionGBD;
import com.lys.beans.UsuarioCompania;
import com.lys.beans.UsuarioDB;
import com.lys.beans.UsuarioSolicitante;
import com.lys.conection.ConectaDB;
import com.lys.conection.GetResultSet;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author dvillanueva
 */
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@WebService(serviceName = "SOAPLYS")
public class SOAPLYS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {

        String TextObt = "";
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        try {
            entrada = new FileInputStream(pathF + File.separator + "webapps" + File.separator + "LysWsRest" + File.separator + "propiedades" + File.separator + "configuracion.properties");
            try {
                propiedades.load(entrada);
            } catch (Exception ex) {
                Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            }
            TextObt = propiedades.getProperty("password");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        }
        TextObt = TextObt + " - " + pathF;
        return TextObt;
    }

    @WebMethod(operationName = "ListUsers")
    public Parametros[] ListUsers() throws java.lang.Exception {
        List<Parametros> listPar = new ArrayList<Parametros>();
        GetResultSet cresult = new GetResultSet();
        String Sql = "SELECT c_codigousuario,c_nombre FROM  dbo.MTP_USUARIO";
        ResultSet rs = cresult.CreateConection(Sql);//this.CreateConection(Sql);

        while (rs.next()) {

            Parametros par = new Parametros(rs.getString(1), rs.getString(2));
            listPar.add(par);

        }
        Parametros[] l2 = new Parametros[listPar.size()];

        for (int i = 0; i < listPar.size(); i++) {

            l2[i] = listPar.get(i);

        }
//ExceptionBean
        return l2;
    }

    @WebMethod(operationName = "ListaMenu")
    public Menu[] ListaMenu(@WebParam(name = "CodUsuario", targetNamespace = "http://SOAP/") String CodUsuario) throws java.lang.Exception {
        //TODO write your implementation code here:
        String msj = ActualizarMenuAcceso();
        Menu[] ListMenu;

        //-------------------------
        List<Menu> list = new ArrayList<Menu>();

        String query = "EXEC dbo.SP_LISTAR_MENU '" + CodUsuario + "'";

        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            Menu men = new Menu(rs.getString(1), rs.getString(2), rs.getString(3));
            list.add(men);

        }

        ListMenu = new Menu[list.size()];
        for (int i = 0; i < list.size(); i++) {

            ListMenu[i] = list.get(i);

        }

        return ListMenu;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListSubMenu")
    public List<SubMenu> ListSubMenu(@WebParam(name = "CodUsuario", targetNamespace = "http://SOAP/") String CodUsuario) throws Exception {
        //TODO write your implementation code here:
        List<SubMenu> listSub = new ArrayList<SubMenu>();

        String query = "EXEC dbo.SP_LISTAR_SUBMENU '" + CodUsuario + "'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            SubMenu smenu = new SubMenu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            listSub.add(smenu);

        }

        return listSub;
    }

    /**
     * Web service operation
     */
    private String ActualizarMenuAcceso() throws Exception {

        String msj = "OK";
        String sqlAccesos = "EXEC SP_SINCRONIZAR_ACCESOS";
        String sqlMenu = "EXEC SP_SINCRONIZAR_MENU";

        GetResultSet Acceso = new GetResultSet();
        msj = Acceso.ExecProcedure(sqlAccesos);
        GetResultSet Menus = new GetResultSet();
        msj = Menus.ExecProcedure(sqlMenu);

        return msj;

    }

    @WebMethod(operationName = "ListSubMenuBotones")
    public List<SubMenuBotones> ListSubMenuBotones(@WebParam(name = "CodPadre", targetNamespace = "http://SOAP/") String CodPadre, @WebParam(name = "CodSubMenu", targetNamespace = "http://SOAP/") String CodSubMenu, @WebParam(name = "CodUsuario", targetNamespace = "http://SOAP/") String CodUsuario) throws Exception {

        List<SubMenuBotones> listSBotones = new ArrayList<SubMenuBotones>();

        String query = "EXEC dbo.SP_LISTAR_SUBMENU_ITEMS '" + CodPadre + "' , '" + CodSubMenu + "' , '" + CodUsuario + "'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            SubMenuBotones smenu = new SubMenuBotones(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            listSBotones.add(smenu);

        }
        return listSBotones;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetDataMenu")
    public List<MenuDB> GetDataMenu() throws Exception {
        String msj = ActualizarMenuAcceso();
        //TODO write your implementation code here:
        List<MenuDB> dataMenu = new ArrayList<MenuDB>();
        List<MenuDB> vartest = new ArrayList<MenuDB>();
        String query = "SELECT * FROM  dbo.MTP_MENUS";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            MenuDB mn = new MenuDB();
            mn.setAppCodigo(rs.getString(1));
            mn.setNivel1(rs.getString(2));
            mn.setNivel2(rs.getString(3));
            mn.setNivel3(rs.getString(4));
            mn.setNivel4(rs.getString(5));
            mn.setNivel5(rs.getString(6));
            mn.setNombreMenu(rs.getString(7));
            mn.setDescripcion(rs.getString(8));
            dataMenu.add(mn);

        }

        return dataMenu;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetDataAccesos")
    public List<AccesosDB> GetDataAccesos(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario) throws Exception {
        //TODO write your implementation code here:
        List<AccesosDB> dataAcceso = new ArrayList<AccesosDB>();
        String query = "SELECT * FROM  MTP_ACCESO  where c_usuario = '"+usuario+"'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            AccesosDB ac = new AccesosDB();

            ac.setUsuario(rs.getString(1));
            ac.setAppCodigo(rs.getString(2));
            ac.setNivelAcc(rs.getString(3));
            ac.setAcceso(rs.getString(4));
            ac.setNuevo(rs.getString(5));
            ac.setModificar(rs.getString(6));
            ac.setEliminar(rs.getString(7));
            ac.setOtros(rs.getString(8));

            dataAcceso.add(ac);

        }

        return dataAcceso;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "saveImage")
    public String saveImage(@WebParam(name = "imgeByte", targetNamespace = "http://SOAP/") byte[] imgeByte, @WebParam(name = "fileName", targetNamespace = "http://SOAP/") String fileName) throws Exception {

        String msg = "";
        String filePathServer = "";
        String extension = fileName.substring(fileName.length() - 3);
        if (extension.toUpperCase().equals("JPG")) {

            filePathServer = File.separator + File.separator + "IBSERVER_1" + File.separator + "Servidor de Archivos" + File.separator + "Fotos_Tablet" + File.separator + fileName;
        } else {
            filePathServer = File.separator + File.separator + "IBSERVER_1" + File.separator + "Servidor de Archivos" + File.separator + "Fotos_Tablet" + File.separator + fileName + ".jpg";

        }

        try {
            FileOutputStream fos = new FileOutputStream(filePathServer);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(imgeByte);
            outputStream.close();

            msg = "Received file: " + filePathServer;
            System.out.println("Received file: " + filePathServer);

        } catch (Exception ex) {
            System.err.println(ex);
            msg = ex.getMessage();
            //    throw new WebServiceException(ex);
        }
        return msg;
    }
    
    @WebMethod(operationName = "GuardarFotoReclamoG")
    public String GuardarFotoReclamoG(@WebParam(name = "imgeByte", targetNamespace = "http://SOAP/") byte[] imgeByte, @WebParam(name = "fileName", targetNamespace = "http://SOAP/") String fileName, @WebParam(name = "tipo", targetNamespace = "http://SOAP/") String tipo) throws Exception {
        String rutaserver = "";
                if(tipo.equals("RG")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RECGARRUTA").substring(2);
                }
                else   if(tipo.equals("QJ")){
                   rutaserver =  GetParametroTexto("00100000", "CO","DOCQUJRUTA").substring(2);
                }
                else   if(tipo.equals("SU")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSSUGRUTA").substring(2);
                }
                 else   if(tipo.equals("SE")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSSCERUTA").substring(2);
                }
                 else   if(tipo.equals("MP")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSMPURUTA").substring(2);
                }
                 else   if(tipo.equals("CT")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSCTERUTA").substring(2);
                }
                 else   if(tipo.equals("CP")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSOLCPRUTA").substring(2);
                }
                
        String msg = "";
        String filePathServer = "";
        String extension = fileName.substring(fileName.length() - 3);
        if (extension.toUpperCase().equals("JPG")) {

             filePathServer = File.separator + File.separator + "IBSERVER_1" +"\\Servidor de Archivos\\"+ rutaserver  + fileName;
        } else {
           filePathServer = File.separator + File.separator + "IBSERVER_1" +"\\Servidor de Archivos\\"+ rutaserver  + fileName+".jpg";

        }
        try {
            FileOutputStream fos = new FileOutputStream(filePathServer);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(imgeByte);
            outputStream.close();
            msg = "Received file: " + filePathServer;
            System.out.println("Received file: " + filePathServer);

        } catch (Exception ex) {
            System.err.println(ex);
            msg = ex.getMessage();
        }
        return msg;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspeccionesMaqCab")
    public ArrayList<InspeccionesMaqCab> GetInspeccionesMaqCab(@WebParam(name = "Usuario", targetNamespace = "http://SOAP/") String Usuario) throws Exception {
        //TODO write your implementation code here:
        ArrayList<InspeccionesMaqCab> result = new ArrayList<InspeccionesMaqCab>();
        String query = "SELECT * FROM dbo.MTp_INSPECCIONMAQUINA_CAB WHERE c_usuarioInspeccion ='" + Usuario + "'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            InspeccionesMaqCab insp = new InspeccionesMaqCab();
            insp.setC_compania(rs.getString(1));
            insp.setN_correlativo(rs.getString(2));
            insp.setC_maquina(rs.getString(3));
            insp.setC_condicionmaquina(rs.getString(4));
            insp.setC_comentario(rs.getString(5));
            insp.setC_estado(rs.getString(6));
            insp.setD_fechaInicioInspeccion(rs.getString(7));
            insp.setD_fechaFinInspeccion(rs.getString(8));
            insp.setC_periodoinspeccion(rs.getString(9));
            insp.setC_usuarioInspeccion(rs.getString(10));
            insp.setC_usuarioenvio(rs.getString(11));
            insp.setD_fechaEnvio(rs.getString(12));
            insp.setC_ultimousuario(rs.getString(13));
            insp.setD_ultimafechamodificacion(rs.getString(14));
            result.add(insp);

        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspeccionesMaqDet")
    public ArrayList<InspeccionesMaqDet> GetInspeccionesMaqDet(@WebParam(name = "Usuario", targetNamespace = "http://SOAP/") String Usuario) throws Exception {
        //TODO write your implementation code here:
        String concat_correlativos = "";
        String selecCorrelativos = "SELECT n_correlativo FROM dbo.MTp_INSPECCIONMAQUINA_CAB WHERE c_usuarioInspeccion ='" + Usuario + "'";
        GetResultSet cresultCorrelativos = new GetResultSet();
        ResultSet rscr = cresultCorrelativos.CreateConection(selecCorrelativos);
        while (rscr.next()) {
            concat_correlativos = concat_correlativos + rscr.getString(1) + ",";
        }
        concat_correlativos = concat_correlativos.substring(0, concat_correlativos.length() - 1);
        ArrayList<InspeccionesMaqDet> result = new ArrayList<InspeccionesMaqDet>();
        String query = "SELECT * FROM  dbo.MTP_INSPECCIONMAQUINA_DET where  n_correlativo in (" + concat_correlativos + ")";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {
            InspeccionesMaqDet inpd = new InspeccionesMaqDet();

            inpd.setC_compania(rs.getString(1));
            inpd.setN_correlativo(rs.getString(2));
            inpd.setN_linea(rs.getString(3));
            inpd.setC_inpeccion(rs.getString(4));
            inpd.setC_tipoinspeccion(rs.getString(5));
            inpd.setN_porcentajeminimo(rs.getString(6));
            inpd.setN_porcentajemaximo(rs.getString(7));
            inpd.setN_pocentajeinspeccion(rs.getString(8));
            inpd.setC_estado(rs.getString(9));
            inpd.setC_comentario(rs.getString(10));
            inpd.setC_rutafoto(rs.getString(11));
            inpd.setC_ultimousuario(rs.getString(12));
            inpd.setD_ultimafechamodificacion(rs.getString(13));

            result.add(inpd);
        }

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspeccionesGenCab")
    public ArrayList<InspeccionesGenCab> GetInspeccionesGenCab(@WebParam(name = "Usuario", targetNamespace = "http://SOAP/") String Usuario) throws Exception {
        //TODO write your implementation code here:
        ArrayList<InspeccionesGenCab> result = new ArrayList<InspeccionesGenCab>();
        String query = "SELECT * FROM  dbo.MTP_INSPECCIONGENERAL_CAB WHERE c_usuarioinspeccion = '" + Usuario + "'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            InspeccionesGenCab insp = new InspeccionesGenCab();
            insp.setC_compania(rs.getString(1));
            insp.setN_correlativo(rs.getString(2));
            insp.setC_tipoinspeccion(rs.getString(3));
            insp.setC_maquina(rs.getString(4));
            insp.setC_centrocosto(rs.getString(5));
            insp.setC_comentario(rs.getString(6));
            insp.setC_usuarioinspeccion(rs.getString(7));
            insp.setD_fechainspeccion(rs.getString(8));
            insp.setC_estado(rs.getString(9));
            insp.setC_usuarioenvio(rs.getString(10));
            insp.setD_fechaenvio(rs.getString(11));
            insp.setC_ultimousuario(rs.getString(12));
            insp.setD_ultimafechamodificacion(rs.getString(13));
            result.add(insp);

        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspeccionesGenDet")
    public ArrayList<InspeccionesGenDet> GetInspeccionesGenDet(@WebParam(name = "Usuario", targetNamespace = "http://SOAP/") String Usuario) throws Exception {
        //TODO write your implementation code here:
        String concat_correlativos = "";
        String selecCorrelativos = "SELECT  n_correlativo FROM  dbo.MTP_INSPECCIONGENERAL_CAB WHERE c_usuarioinspeccion = '" + Usuario + "'";
        GetResultSet cresultCorrelativos = new GetResultSet();
        ResultSet rscr = cresultCorrelativos.CreateConection(selecCorrelativos);
        while (rscr.next()) {
            concat_correlativos = concat_correlativos + rscr.getString(1) + ",";
        }
        concat_correlativos = concat_correlativos.substring(0, concat_correlativos.length() - 1);
        ArrayList<InspeccionesGenDet> result = new ArrayList<InspeccionesGenDet>();
        String query = "SELECT * FROM  dbo.MTP_INSPECCIONGENERAL_DET where  n_correlativo in (" + concat_correlativos + ")";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {
            InspeccionesGenDet inpd = new InspeccionesGenDet();

            inpd.setC_compania(rs.getString(1));
            inpd.setN_correlativo(rs.getString(2));
            inpd.setN_linea(rs.getString(3));
            inpd.setC_comentario(rs.getString(4));
            inpd.setC_rutafoto(rs.getString(5));
            inpd.setC_ultimousuario(rs.getString(6));
            inpd.setD_ultimafechamodificacion(rs.getString(7));
            inpd.setC_tiporevisiong(rs.getString(8));
            inpd.setC_flagadictipo(rs.getString(9));

            result.add(inpd);
        }

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetUsuarios")
    public ArrayList<UsuarioDB> GetUsuarios() throws Exception {
        ArrayList<UsuarioDB> listUsers = new ArrayList<UsuarioDB>();
        String query =  "select c_codigousuario, c_nombre, "+
                        " lys.dbo.uf_gn_GenDataPwd( c_clave, 'D') clvae, "+
                        "n_persona, c_estado, c_flagmantto "+
                        " from dbo.MTP_USUARIO";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            UsuarioDB us = new UsuarioDB();
            us.setCodigoUsuario(rs.getString(1));
            us.setNombre(rs.getString(2));
            us.setClave(rs.getString(3));
            us.setNroPersona(rs.getString(4));
            us.setEstado(rs.getString(5));
            us.setFlagmantto(rs.getString(6));
            listUsers.add(us);

        }

        return listUsers;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetMaquinas")
    public ArrayList<Maquina> GetMaquinas() throws Exception {
        ArrayList<Maquina> listMaquinas = new ArrayList<Maquina>();
        String select1 = "SELECT  c_compania , c_maquina , c_descripcion ,";
        String CaseSql = "CASE WHEN c_codigobarras IS NULL THEN '-'   ELSE c_codigobarras END c_codigobarras ,   CASE LEN(c_familiainspeccion) WHEN 0 THEN '-' ELSE c_familiainspeccion     END c_familiainspeccion ,";
        String select2 = " c_centrocosto , c_estado ,c_ultimousuario ,d_ultimafechamodificacion ";
        String fromTable = " FROM    dbo.MTP_MAQUINAS";
        String query = select1 + CaseSql + select2 + fromTable;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            Maquina mq = new Maquina();
            mq.setC_ompania(rs.getString(1));
            mq.setC_maquina(rs.getString(2));
            mq.setC_descripcion(rs.getString(3));
            mq.setC_codigobarras(rs.getString(4));
            mq.setC_familiainspeccion(rs.getString(5));
            mq.setC_centrocosto(rs.getString(6));
            mq.setC_estado(rs.getString(7));
            mq.setC_ultimousuario(rs.getString(8));
            mq.setD_ultimafechamodificacion(rs.getString(9));
            listMaquinas.add(mq);

        }

        return listMaquinas;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetPeriodosInspeccion")
    public ArrayList<PeriodoInspeccionDB> GetPeriodosInspeccion() throws Exception {

        ArrayList<PeriodoInspeccionDB> listPeriodos = new ArrayList<PeriodoInspeccionDB>();
        String query = "SELECT * FROM dbo.MTP_PERIODOINSPECCION";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            PeriodoInspeccionDB p = new PeriodoInspeccionDB();
            p.setC_periodoinspeccion(rs.getString(1));
            p.setC_descripcion(rs.getString(2));
            p.setC_estado(rs.getString(3));
            p.setC_ultimousuario(rs.getString(4));
            p.setD_ultimafechamodificacion(rs.getString(5));
            listPeriodos.add(p);

        }

        return listPeriodos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspecciones")
    public ArrayList<Inspecciones> GetInspecciones() throws Exception {

        ArrayList<Inspecciones> listInsp = new ArrayList<Inspecciones>();
        String query = "SELECT * FROM  dbo.MTP_INSPECCION;";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            Inspecciones inp = new Inspecciones();
            inp.setC_inspeccion(rs.getString(1));
            inp.setC_descripcion(rs.getString(2));
            inp.setC_tipoinspeccion(rs.getString(3));
            inp.setN_porcentajeminimo(rs.getString(4));
            inp.setN_porcentajemaximo(rs.getString(5));
            inp.setC_familiainspeccion(rs.getString(6));
            inp.setC_periodoinspeccion(rs.getString(7));
            inp.setC_estado(rs.getString(8));
            inp.setC_ultimousuario(rs.getString(9));
            inp.setD_ultimafechamodificacion(rs.getString(10));
            listInsp.add(inp);

        }

        return listInsp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertInspGenCab")
    public String InsertInspGenCab(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "tipoInsp", targetNamespace = "http://SOAP/") String tipoInsp, @WebParam(name = "codMaq", targetNamespace = "http://SOAP/") String codMaq, @WebParam(name = "codCentroC", targetNamespace = "http://SOAP/") String codCentroC, @WebParam(name = "comentario", targetNamespace = "http://SOAP/") String comentario, @WebParam(name = "usuarioInsp", targetNamespace = "http://SOAP/") String usuarioInsp, @WebParam(name = "fechaInsp", targetNamespace = "http://SOAP/") String fechaInsp, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "usuarioEnv", targetNamespace = "http://SOAP/") String usuarioEnv, @WebParam(name = "UltUsuario", targetNamespace = "http://SOAP/") String UltUsuario) throws Exception {
        //TODO write your implementation code here:
        String result = "0";
        long var_correlativo = Long.valueOf(correlativo);
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SPI_INSPECCION_GEN_CABECERA ?,?,?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setLong(2, var_correlativo);
        statement.setString(3, tipoInsp);
        statement.setString(4, codMaq);
        statement.setString(5, codCentroC);
        statement.setString(6, comentario);
        statement.setString(7, usuarioInsp);
        statement.setString(8, fechaInsp);
        statement.setString(9, estado);
        statement.setString(10, usuarioEnv);
        statement.setString(11, UltUsuario);

        int rowAfect = statement.executeUpdate();

        if (rowAfect > 0) {

            result = String.valueOf(rowAfect);
        }

        return result;
    }

    @WebMethod(operationName = "InsertInspMaqCab")
    public String InsertInspMaqCab(@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "maquina", targetNamespace = "http://SOAP/") String maquina, @WebParam(name = "condicionMaquina", targetNamespace = "http://SOAP/") String condicionMaquina, @WebParam(name = "comentario", targetNamespace = "http://SOAP/") String comentario, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "fechaIniInsp", targetNamespace = "http://SOAP/") String fechaIniInsp, @WebParam(name = "fechaFinInsp", targetNamespace = "http://SOAP/") String fechaFinInsp, @WebParam(name = "periodoInsp", targetNamespace = "http://SOAP/") String periodoInsp, @WebParam(name = "usuarioInsp", targetNamespace = "http://SOAP/") String usuarioInsp, @WebParam(name = "usuaruioEnv", targetNamespace = "http://SOAP/") String usuaruioEnv, @WebParam(name = "ultimoUsuario", targetNamespace = "http://SOAP/") String ultimoUsuario) throws Exception {

        String result = "0";
        long var_correlativo = Long.valueOf(correlativo);
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SPI_INSPECCION_MAQ_CABECERA ?,?,?,?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setLong(2, var_correlativo);
        statement.setString(3, maquina);
        statement.setString(4, condicionMaquina);
        statement.setString(5, comentario);
        statement.setString(6, estado);
        statement.setString(7, fechaIniInsp);
        statement.setString(8, fechaFinInsp);
        statement.setString(9, periodoInsp);
        statement.setString(10, usuarioInsp);
        statement.setString(11, usuaruioEnv);
        statement.setString(12, ultimoUsuario);

        int rowAfect = statement.executeUpdate();

        if (rowAfect > 0) {

            result = String.valueOf(rowAfect);
        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCorrelativo")
    public String GetCorrelativo() throws Exception {
        String result = "0";
        String query = "SELECT n_ultimocorrelativo FROM  dbo.ma_Correlativos  where c_compania = '00100000' and c_tipodocumento = 'SY' "+
                        "and c_seriedocumento = 'COIM' and c_aplicacion = 'MT'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }
    
    @WebMethod(operationName = "VerificarItemExiste")
    public String VerificarItemExiste(@WebParam(name = "item", targetNamespace = "http://SOAP/") String item) throws Exception {
        String result = "0";
        String query = "SELECT  count(*) n_count FROM  "+
                        " lys..ma_ItemsMast where c_item ='"+item+"' ";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertInspGenDet")
    public String InsertInspGenDet(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "linea", targetNamespace = "http://SOAP/") String linea, @WebParam(name = "comentario", targetNamespace = "http://SOAP/") String comentario, @WebParam(name = "rutaFoto", targetNamespace = "http://SOAP/") String rutaFoto, @WebParam(name = "ultUsuario", targetNamespace = "http://SOAP/") String ultUsuario, @WebParam(name = "tipoRev", targetNamespace = "http://SOAP/") String tipoRev, @WebParam(name = "flagAdic", targetNamespace = "http://SOAP/") String flagAdic) throws Exception {
        //TODO write your implementation code here:
        String result = "0";
        long var_correlativo = Long.valueOf(correlativo);
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SPI_INSPECCION_GEN_DETALLE ?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setLong(2, var_correlativo);
        statement.setInt(3, Integer.valueOf(linea));
        statement.setString(4, comentario);
        statement.setString(5, rutaFoto);
        statement.setString(6, ultUsuario);
        statement.setString(7, tipoRev);
        statement.setString(8, flagAdic);
        int rowAfect = statement.executeUpdate();

        if (rowAfect > 0) {

            result = "OK";
        }
        return result;
    }

    @WebMethod(operationName = "InsertInspMaqDet")
    public String InsertInspMaqDet(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "linea", targetNamespace = "http://SOAP/") String linea, @WebParam(name = "codInspeccion", targetNamespace = "http://SOAP/") String codInspeccion, @WebParam(name = "tipoInsp", targetNamespace = "http://SOAP/") String tipoInsp, @WebParam(name = "porcentMin", targetNamespace = "http://SOAP/") String porcentMin, @WebParam(name = "porcentMax", targetNamespace = "http://SOAP/") String porcentMax, @WebParam(name = "porcentInsp", targetNamespace = "http://SOAP/") String porcentInsp, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "comentario", targetNamespace = "http://SOAP/") String comentario, @WebParam(name = "rutafoto", targetNamespace = "http://SOAP/") String rutafoto, @WebParam(name = "ultimoUser", targetNamespace = "http://SOAP/") String ultimoUser) throws Exception {
        String result = "0";
        long var_correlativo = Long.valueOf(correlativo);
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SPI_INSPECCION_MAQ_DETALLE ?,?,?,?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setLong(2, var_correlativo);
        statement.setInt(3, Integer.valueOf(linea));
        statement.setString(4, codInspeccion);
        statement.setString(5, tipoInsp);
        statement.setString(6, porcentMin);
        statement.setString(7, porcentMax);
        statement.setString(8, porcentInsp);
        statement.setString(9, estado);
        statement.setString(10, comentario);
        statement.setString(11, rutafoto);
        statement.setString(12, ultimoUser);

        int rowAfect = statement.executeUpdate();

        if (rowAfect > 0) {

            result = "OK";
        }
        //  String query = "EXEC dbo.SPI_INSPECCION_MAQ_CABECERA @compania = '"+compania+"' ,  @maquina = '"+maquina+"',  @condicionMaquina = '"+condicionMaquina+"',  @comentario = '"+comentario+"',  @estado = '"+estado+"', @fechaInicioInp = '"+fechaIniInsp+"',   @fechaFinInsp = '"+fechaFinInsp+"',  @periodoInsp = '"+periodoInsp+"', @usuarioInsp = '"+usuarioInsp+"',  @usuarioEnvio = '"+usuaruioEnv+"',  @ultUsuario = '"+ultimoUsuario+"' ";
        // GetResultSet cresult = new GetResultSet();
        // ResultSet rs = cresult.CreateConection(query);

        return result;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCentroCosto")
    public ArrayList<CentroCostoDB> GetCentroCosto() throws Exception {
        ArrayList<CentroCostoDB> result = new ArrayList<CentroCostoDB>();
        GetResultSet cresult = new GetResultSet();
        String Sql = "SELECT * FROM dbo.MTP_CENTROCOSTO";
        ResultSet rs = cresult.CreateConection(Sql);
        while (rs.next()) {

            CentroCostoDB c = new CentroCostoDB();
            c.setC_compania(rs.getString(1));
            c.setC_centrocosto(rs.getString(2));
            c.setC_descripcion(rs.getString(3));
            c.setC_estado(rs.getString(4));
            result.add(c);

        }
        return result;
    }

    /**
     * Web service operation
     *
     */
    @WebMethod(operationName = "GetHistorialInspGen")
    public ArrayList<HistorialInspGen> GetHistorialInspGen(@WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "tipoInsp", targetNamespace = "http://SOAP/") String tipoInsp, @WebParam(name = "FInicio", targetNamespace = "http://SOAP/") String FInicio, @WebParam(name = "FFin", targetNamespace = "http://SOAP/") String FFin,  @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado ) throws Exception {
        ArrayList<HistorialInspGen> result = new ArrayList<HistorialInspGen>();
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CONSULTAS_LINEA_INSP_GEN ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, accion);
        statement.setString(2, tipoInsp);
        statement.setString(3, FInicio);
        statement.setString(4, FFin);
        statement.setString(5, estado);
        ResultSet res = statement.executeQuery();
        while (res.next()) {

            HistorialInspGen h = new HistorialInspGen();
            h.setNumero(res.getString(1));
            h.setTipoInsp(res.getString(2));
            h.setCodMaq(res.getString(3));
            h.setCodCosto(res.getString(4));
            h.setUsarioInp(res.getString(5));
            h.setFecha(res.getString(6));
            h.setComentario(res.getString(7));
            h.setEstado(res.getString(8));
            result.add(h);

        }

        return result;
    }

    @WebMethod(operationName = "GetHistorialInspMaq")
    public ArrayList<HistorialInspMaq> GetHistorialInspMaq(@WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "maquina", targetNamespace = "http://SOAP/") String maquina, @WebParam(name = "centrocosto", targetNamespace = "http://SOAP/") String centrocosto, @WebParam(name = "fechaIni", targetNamespace = "http://SOAP/") String fechaIni, @WebParam(name = "fechaFin", targetNamespace = "http://SOAP/") String fechaFin) throws Exception {
        ArrayList<HistorialInspMaq> result = new ArrayList<HistorialInspMaq>();
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CONSULTAS_LINEA_INSP_MAQ ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, accion);
        statement.setString(2, maquina);
        statement.setString(3, centrocosto);
        statement.setString(4, fechaIni);
        statement.setString(5, fechaFin);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            HistorialInspMaq h = new HistorialInspMaq();
            h.setNumero(res.getString(1));
            h.setFecha(res.getString(2));
            h.setCod_maquina(res.getString(3));
            h.setCentro_costo(res.getString(4));
            h.setFrecuencia(res.getString(5));
            h.setUsuario(res.getString(6));
            h.setComentario(res.getString(7));
            h.setEstado(res.getString(8));
            result.add(h);
        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TrasnferirInsp")
    public String TrasnferirInsp(@WebParam(name = "tipoIns", targetNamespace = "http://SOAP/") String tipoIns, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo) throws Exception {
        String result = "NO";
        int var_correlativo = Integer.valueOf(correlativo);
        int cont = 0;

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_TRANSFERIR_INSPECCION  @tipoInspeccion  = '" + tipoIns + "', @correlativo = " + correlativo + " , @correlativoInsert = 0 ";
            Statement statement = connection.createStatement();
            // CreateStatement statement = connection.prepareStatement(SQL_INSERT);
            //  statement.setEscapeProcessing(true);
            // statement.setQueryTimeout(90);
            // statement.setString(1, tipoIns);
            // statement.setLong(2, var_correlativo);
            //statement.setLong(3, 0);
            ResultSet res = statement.executeQuery(SQL_INSERT);
            //  int rowAfect = statement.executeUpdate();
            // ResultSet rs = statement.getResultSet();
            //  statement.set
            //result = String.valueOf(rowAfect);

            while (res.next()) {
                result = res.getString(1);
            }

        } catch (Exception e) {

            result = e.getMessage();
        }
        //result  = result + String.valueOf(rowAfect);
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetTipoRevisionG")
    public ArrayList<TipoRevisionGBD> GetTipoRevisionG() throws Exception {
        //TODO write your implementation code here:
        ArrayList<TipoRevisionGBD> listresult = new ArrayList<TipoRevisionGBD>();
        GetResultSet cresult = new GetResultSet();
        String Sql = "SELECT * FROM dbo.MTP_TIPOREVISIONG";
        ResultSet rs = cresult.CreateConection(Sql);

        while (rs.next()) {

            TipoRevisionGBD t = new TipoRevisionGBD();
            t.setCod_tiporevision(rs.getString(1));
            t.setDescripcion(rs.getString(2));
            t.setEstado(rs.getString(3));
            t.setUltimoUsuario(rs.getString(4));
            t.setUltFechaMod(rs.getString(5));
            listresult.add(t);

        }
        return listresult;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspeccionMaqDetCor")
    public ArrayList<InspeccionesMaqDet> GetInspeccionMaqDetCor(@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo) throws Exception {

        ArrayList<InspeccionesMaqDet> result = new ArrayList<InspeccionesMaqDet>();
        int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT * FROM lys.dbo.MT_INSPECCIONMAQUINA_DET WHERE n_correlativo = " + val_correlativo + " ;";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            InspeccionesMaqDet det = new InspeccionesMaqDet();
            det.setC_compania(rs.getString(1));
            det.setN_correlativo(rs.getString(2));
            det.setN_linea(rs.getString(3));
            det.setC_inpeccion(rs.getString(4));
            det.setC_tipoinspeccion(rs.getString(5));
            det.setN_porcentajeminimo(rs.getString(6));
            det.setN_porcentajemaximo(rs.getString(7));
            det.setN_pocentajeinspeccion(rs.getString(8));
            det.setC_estado(rs.getString(9));
            det.setC_comentario(rs.getString(10));
            det.setC_rutafoto(rs.getString(11));
            det.setC_ultimousuario(rs.getString(13));
            det.setD_ultimafechamodificacion(rs.getString(14));
            result.add(det);
        }
        return result;
    }

    @WebMethod(operationName = "GetInspeccionMaqCabCor")
    public ArrayList<InspeccionesMaqCab> GetInspeccionMaqCabCor(@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo) throws Exception {
        //TODO write your implementation code here:
        ArrayList<InspeccionesMaqCab> result = new ArrayList<InspeccionesMaqCab>();
        int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT * FROM lys.dbo.MT_INSPECCIONMAQUINA_CAB WHERE n_correlativo = " + val_correlativo + " ;";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            InspeccionesMaqCab inp = new InspeccionesMaqCab();
            inp.setC_compania(rs.getString(1));
            inp.setN_correlativo(rs.getString(2));
            inp.setC_maquina(rs.getString(3));
            inp.setC_condicionmaquina(rs.getString(4));
            inp.setC_comentario(rs.getString(5));
            inp.setC_estado(rs.getString(6));
            inp.setD_fechaInicioInspeccion(rs.getString(7));
            inp.setD_fechaFinInspeccion(rs.getString(8));
            inp.setC_periodoinspeccion(rs.getString(9));
            inp.setC_usuarioInspeccion(rs.getString(10));
            inp.setC_ultimousuario(rs.getString(11));
            inp.setD_ultimafechamodificacion(rs.getString(12));
            result.add(inp);

        }
        return result;
    }

    @WebMethod(operationName = "GetInspeccionGenCabCor")
    public ArrayList<InspeccionesGenCab> GetInspeccionGenCabCor(@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo) throws Exception {
        //TODO write your implementation code here:
        ArrayList<InspeccionesGenCab> result = new ArrayList<InspeccionesGenCab>();
        int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT * FROM lys.dbo.MT_INSPECCIONGENERAL_CAB WHERE n_correlativo = " + val_correlativo + ";";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            InspeccionesGenCab insp = new InspeccionesGenCab();
            insp.setC_compania(rs.getString(1));
            insp.setN_correlativo(rs.getString(2));
            insp.setC_tipoinspeccion(rs.getString(3));
            insp.setC_maquina(rs.getString(4));
            insp.setC_centrocosto(rs.getString(5));
            insp.setC_comentario(rs.getString(6));
            insp.setC_usuarioinspeccion(rs.getString(7));
            insp.setD_fechainspeccion(rs.getString(8));
            insp.setC_estado(rs.getString(9));
            insp.setC_ultimousuario(rs.getString(10));
            insp.setD_ultimafechamodificacion(rs.getString(11));

            result.add(insp);

        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetInspeccionGenCDetCor")
    public ArrayList<InspeccionesGenDet> GetInspeccionGenCDetCor(@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo) throws Exception {
        //TODO write your implementation code here:
        ArrayList<InspeccionesGenDet> result = new ArrayList<InspeccionesGenDet>();
        int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT * FROM lys.dbo.MT_INSPECCIONGENERAL_DET WHERE n_correlativo = " + val_correlativo + " ;";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            InspeccionesGenDet insp = new InspeccionesGenDet();
            insp.setC_compania(rs.getString(1));
            insp.setN_correlativo(rs.getString(2));
            insp.setN_linea(rs.getString(3));
            insp.setC_comentario(rs.getString(4));
            insp.setC_rutafoto(rs.getString(5));
            insp.setC_ultimousuario(rs.getString(7));
            insp.setD_ultimafechamodificacion(rs.getString(8));
            insp.setC_tiporevisiong(rs.getString(9));
            insp.setC_flagadictipo(rs.getString(10));

            result.add(insp);

        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetFoto")
    public byte[] GetFoto(@WebParam(name = "filename", targetNamespace = "http://SOAP/") String filename) throws Exception {
        //TODO write your implementation code here:
        String filePathServer = File.separator + File.separator + "IBSERVER_1" + File.separator + "Servidor de Archivos" + File.separator + "Fotos_Tablet" + File.separator + filename;
        Path path = Paths.get(filePathServer);
        byte[] result = Files.readAllBytes(path);

        return result;
    }
    
    @WebMethod(operationName = "GetFotoRG")
    public byte[] GetFotoRG(@WebParam(name = "filename", targetNamespace = "http://SOAP/") String filename,@WebParam(name = "tipo", targetNamespace = "http://SOAP/") String tipo) throws Exception {
        //TODO write your implementation code here:
        String rutaserver = "";
                if(tipo.equals("RG")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RECGARRUTA").substring(2);
                }
                else if (tipo.equals("QJ")){
                    rutaserver =  GetParametroTexto("00100000", "CO","DOCQUJRUTA").substring(2);
                }
                else   if(tipo.equals("SU")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSSUGRUTA").substring(2);
                }
                 else   if(tipo.equals("SE")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSSCERUTA").substring(2);
                }
                 else   if(tipo.equals("MP")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSMPURUTA").substring(2);
                }
                 else   if(tipo.equals("CT")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSCTERUTA").substring(2);
                }
                 else   if(tipo.equals("CP")){
                   rutaserver =  GetParametroTexto("00100000", "CO","RSOLCPRUTA").substring(2);
                }
        String filePathServer = File.separator + File.separator + "IBSERVER_1" + File.separator + "Servidor de Archivos" + File.separator + rutaserver + File.separator + filename;
        Path path = Paths.get(filePathServer);
        byte[] result = Files.readAllBytes(path);

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetTipoIp")
    public String GetTipoIp(@WebParam(name = "sTipo", targetNamespace = "http://SOAP/") String sTipo) throws Exception {
         //TODO write your implementation code here:
        String sIpLocal = "", sIpExt = "";
        String sResult = "";
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        try {
            entrada = new FileInputStream(pathF + File.separator + "webapps" + File.separator + "LysWsRest" + File.separator + "propiedades" + File.separator + "configuracion.properties");
            propiedades.load(entrada);
            sIpLocal = propiedades.getProperty("iplocal");
            sIpExt = propiedades.getProperty("ipexterna");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            sResult = ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            sResult = ex.getMessage();
        }

        if (sTipo.equals("EX")) {

            sResult = sIpExt;
        } else if (sTipo.equals("LO")) {

            sResult = sIpLocal;
        }

        return sResult;
    }

    @WebMethod(operationName = "ListSolcitudServ")
    public ArrayList<SolicitudServicio> ListSolcitudServ(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania,
            @WebParam(name = "flagfecha", targetNamespace = "http://SOAP/") String flagfecha, @WebParam(name = "fechaini", targetNamespace = "http://SOAP/") String fechaini,
            @WebParam(name = "fechafin", targetNamespace = "http://SOAP/") String fechafin, @WebParam(name = "maquina", targetNamespace = "http://SOAP/") String maquina,
            @WebParam(name = "prioridad", targetNamespace = "http://SOAP/") String prioridad, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado,
            @WebParam(name = "personasolicit", targetNamespace = "http://SOAP/") String personasolicit,@WebParam(name = "nsolicitud", targetNamespace = "http://SOAP/") String nsolicitud) throws Exception {
        ArrayList<SolicitudServicio> result = new ArrayList<SolicitudServicio>();
        /*ConectaDB cndb = new ConectaDB();
        Connection connection =  connection = cndb.getConexion();*/

        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_MT_LISTA_SOLIC_SERVIC_MOVIL ?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setString(2, flagfecha);
        statement.setString(3, fechaini);
        statement.setString(4, fechafin);
        statement.setString(5, maquina);
        statement.setString(6, prioridad);
        statement.setString(7, estado);
        statement.setInt(8, Integer.valueOf(personasolicit));
        statement.setInt(9, Integer.valueOf(nsolicitud));
        ResultSet res = statement.executeQuery();

        while (res.next()) {

            SolicitudServicio s = new SolicitudServicio();

            s.setC_compania(res.getString(1));
            s.setN_solicitud(res.getInt(2));
            s.setC_maquina(res.getString(3));
            s.setC_maquinanomb(res.getString(4));
            s.setC_ccosto(res.getString(5));
            s.setC_ccostonomb(res.getString(6));
            s.setC_personasolicitud(res.getString(7));
            s.setC_usuariosolicit(res.getString(8));
            s.setC_prioridad(res.getString(9));
            s.setC_descriproblema(res.getString(10));
            s.setC_descfalla(res.getString(11));
            s.setC_estado(res.getString(12));
            s.setC_fechareg(res.getString(13));
            s.setC_tiposolcitud(res.getString(14));
            s.setC_empleadosAsignados(res.getString(15));
            result.add(s);
        }

        return result;
    }

    @WebMethod(operationName = "ListUsuarioSolcit")
    public ArrayList<UsuarioSolicitante> ListUsuarioSolcit(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania) throws Exception {

        ArrayList<UsuarioSolicitante> result = new ArrayList<UsuarioSolicitante>();
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_MT_LIST_USUARIO_SOLICIT ?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            UsuarioSolicitante u = new UsuarioSolicitante();
            u.setN_persona(res.getInt(1));
            u.setC_nombreCompleto(res.getString(2));
            u.setC_numerodocumento(res.getString(3));
            result.add(u);

        }
        return result;
    }

    @WebMethod(operationName = "GetUsuarioCompania")
    public ArrayList<UsuarioCompania> GetUsuarioCompania(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario) throws Exception {
        //TODO write your implementation code here:
        ArrayList<UsuarioCompania> result = new ArrayList<UsuarioCompania>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT  c.c_Compania , c.c_Nombres "
                + " from lys..ma_Compania c inner join  "
                + " lys..MT_USUARIOCOMPANIA u "
                + " on  u.c_compania = c.c_Compania "
                + " and  c_codigousuario ='" + usuario + "'";

        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            UsuarioCompania uc = new UsuarioCompania();
            uc.setC_compania(rs.getString(1));
            uc.setC_nombres(rs.getString(2));
            result.add(uc);
        }
        return result;
    }
    
    @WebMethod(operationName = "GetUsuarioCompLogistica")
    public ArrayList<UsuarioCompania> GetUsuarioCompLogistica(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario) throws Exception {
        //TODO write your implementation code here:
        ArrayList<UsuarioCompania> result = new ArrayList<UsuarioCompania>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "Select a.c_Compania,a.c_Nombres "+
                        "from lys..ma_compania a,lys..lo_usuariocompania b "+
                        "where a.c_compania = b.c_compania "+
                        " and b.c_codigousuario ='"+usuario+"'";

        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            UsuarioCompania uc = new UsuarioCompania();
            uc.setC_compania(rs.getString(1));
            uc.setC_nombres(rs.getString(2));
            result.add(uc);
        }
        return result;
    }
    
     @WebMethod(operationName = "GetUsuarioCompComercial")
    public ArrayList<UsuarioCompania> GetUsuarioCompComercial(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario) throws Exception {
        //TODO write your implementation code here:
        ArrayList<UsuarioCompania> result = new ArrayList<UsuarioCompania>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "Select a.c_compania , b.c_Nombres "+
                        "from lys..co_usuariocompania a inner join lys..ma_Compania b  "+
                         "on b.c_Compania = a.c_compania "+
                          "and a.c_codigousuario = '" +usuario+"';";

        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            UsuarioCompania uc = new UsuarioCompania();
            uc.setC_compania(rs.getString(1));
            uc.setC_nombres(rs.getString(2));
            result.add(uc);
        }
        return result;
    }
    

    @WebMethod(operationName = "GetEmpleadosMant")
    public ArrayList<EmpleadoMant> GetEmpleadosMant(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania) throws Exception {
        ArrayList<EmpleadoMant> result = new ArrayList<EmpleadoMant>();
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_MT_EMPLEADOS_MANT ?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            EmpleadoMant e = new EmpleadoMant();
            e.setC_compania(res.getString(1));
            e.setN_empleado(res.getInt(2));
            e.setC_nombreempleado(res.getString(3));
            e.setC_documento(res.getString(5));
            e.setC_numeromovil(res.getString(6));
            result.add(e);

        }
        return result;
    }

    @WebMethod(operationName = "GetEmpleadosAsig")
    public ArrayList<EmpAsigSolicitud> GetEmpleadosAsig(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nrosolicitud", targetNamespace = "http://SOAP/") String nrosolicitud) throws Exception {
        //TODO write your implementation code here:
        ArrayList<EmpAsigSolicitud> result = new ArrayList<EmpAsigSolicitud>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "select a.c_compania, a.n_solicitud, a.n_secuencia, a.c_compempleado, a.n_empleado, "
                + " b.c_NombreCompleto, a.c_ultimousuario ,a.d_ultimafechamodificacion	 "
                + " from lys..mt_mantsolicitudemp_asig a "
                + " left join lys..RH_EMPLEADOS b on a.c_compempleado = b.c_Compania"
                + "  and b.n_empleado = a.n_empleado where a.n_solicitud = " + nrosolicitud + " and a.c_compania = '" + compania + "'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            EmpAsigSolicitud emp = new EmpAsigSolicitud();
            emp.setC_compania(rs.getString(1));
            emp.setN_solicitud(Integer.valueOf(rs.getString(2)));
            emp.setN_secuencia(Integer.valueOf(rs.getString(3)));
            emp.setC_compEmpleado(rs.getString(4));
            emp.setN_empleado(Integer.valueOf(rs.getString(5)));
            emp.setC__nombreempleado(rs.getString(6));
            emp.setC_ultimousuario(rs.getString(7));
            result.add(emp);
        }
        return result;
    }

    @WebMethod(operationName = "InsertEmpSolicitud")
    public String InsertEmpSolicitud(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nrosolicitud", targetNamespace = "http://SOAP/") String nrosolicitud,
            @WebParam(name = "nsecuencia", targetNamespace = "http://SOAP/") String nsecuencia, @WebParam(name = "compempleado", targetNamespace = "http://SOAP/") String compempleado,
            @WebParam(name = "nempleado", targetNamespace = "http://SOAP/") String nempleado, @WebParam(name = "ultusuario", targetNamespace = "http://SOAP/") String ultusuario) throws Exception {
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SPI_MT_SOLICITUDEMPLEADO '" + compania + "'," + nrosolicitud + "," + nsecuencia + ",'"
                    + compempleado + "'," + nempleado + ",'" + ultusuario + "'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;
    }

    @WebMethod(operationName = "BorrandoDetalleEmpSolc")
    public String BorrandoDetalleEmpSolc(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nrosolicitud", targetNamespace = "http://SOAP/") String nrosolicitud) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SPD_MT_LIMPIANDODETALLE_SOLICITUD '" + compania + "'," + nrosolicitud;
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }

    @WebMethod(operationName = "ValidarEmpleadoMant")
    public String ValidarEmpleadoMant(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario) throws Exception {
        //TODO write your implementation code here:
        String result = "N";
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "select  isnull(c_flag_emp_mtto, 'N')  c_flag_emp_mtto "
                + "from lys..ma_usuario "
                + "where c_codigousuario = '" + usuario + "' and c_estado = 'A'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            result = rs.getString(1);

        }
        return result;
    }

    @WebMethod(operationName = "CountEmpleadosSolict")
    public String CountEmpleadosSolict(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nsolicitud", targetNamespace = "http://SOAP/") String nsolicitud) throws Exception {
        //TODO write your implementation code here:
        String result = "0";
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT isnull(count(*),0) n_count "
                + "FROM  lys..mt_mantsolicitudemp_asig  "
                + " where  c_compania = '" + compania + "' and  n_solicitud =" + nsolicitud;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }

    @WebMethod(operationName = "AprobarSolcitudServ")
    public String AprobarSolcitudServ(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nrosolicitud", targetNamespace = "http://SOAP/") String nrosolicitud, @WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SPU_MT_APROBACION_SOLCITUD '" + compania + "'," + nrosolicitud + ",'" + usuario + "'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }

    @WebMethod(operationName = "ListReqLogistica")
    public ArrayList<RequisicionLogCab> ListReqLogistica(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania,
            @WebParam(name = "ccosto", targetNamespace = "http://SOAP/") String ccosto, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado,
            @WebParam(name = "fechainicio", targetNamespace = "http://SOAP/") String fechainicio, @WebParam(name = "fechafin", targetNamespace = "http://SOAP/") String fechafin,
            @WebParam(name = "nroreq", targetNamespace = "http://SOAP/") String nroreq) throws Exception {
        ArrayList<RequisicionLogCab> result = new ArrayList<RequisicionLogCab>();

        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_MT_LISTA_REQUISICIONES ?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setString(2, ccosto);
        statement.setString(3, estado);
        statement.setString(4, fechainicio);
        statement.setString(5, fechafin);
        statement.setString(6, nroreq);

        ResultSet res = statement.executeQuery();

        while (res.next()) {

            RequisicionLogCab r = new RequisicionLogCab();

            r.setC_compania(res.getString(1));
            r.setC_numeroreq(res.getString(2));
            r.setC_fechacreacion(res.getString(3));
            r.setC_usuariocreacion(res.getString(4));
            r.setC_prioridad(res.getString(5));
            r.setC_prioridadnomb(res.getString(6));
            r.setC_usuarioaprobacion(res.getString(7));
            r.setC_fechaaprobacion(res.getString(8));
            r.setC_ccosto(res.getString(9));
            r.setC_ccostonomb(res.getString(10));
            r.setC_cometario(res.getString(11));
            r.setC_clasificacion(res.getString(12));
            r.setC_estado(res.getString(13));
            r.setC_estadonomb(res.getString(14));
            r.setC_almacennomb(res.getString(15));
            r.setC_reposicionstock(res.getString(16));

            result.add(r);
        }

        return result;
    }
    
    @WebMethod(operationName = "BuscarFiltroGarantia")
    public ArrayList<EFacSerLot> BuscarFiltroGarantia(@WebParam(name = "tipo", targetNamespace = "http://SOAP/") String tipo,
            @WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente,
            @WebParam(name = "factura", targetNamespace = "http://SOAP/") String factura, @WebParam(name = "item", targetNamespace = "http://SOAP/") String item) throws Exception {
        ArrayList<EFacSerLot> result = new ArrayList<EFacSerLot>();

        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CO_BUSCAR_FILTROGARANTIA ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, tipo);
        statement.setString(2, compania);
        statement.setInt(3, Integer.valueOf(cliente));
        statement.setString(4, factura);
        statement.setString(5, item);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            EFacSerLot r = new EFacSerLot();
            r.setC_factRef(res.getString(1));
            r.setC_lote(res.getString(2));
            r.setC_procedencia(res.getString(3));
            result.add(r);
        }

        return result;
    }
    

    @WebMethod(operationName = "GetDetalleReqLog")
    public ArrayList<RequisicionLogDet> GetDetalleReqLog(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "numeroreq", targetNamespace = "http://SOAP/") String numeroreq) throws Exception {
        //TODO write your implementation code here:
        ArrayList<RequisicionLogDet> result = new ArrayList<RequisicionLogDet>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT     c_Compania , isnull(c_item,'-') c_item , c_descripcion , n_cantidadpedida , n_stockdisponible,n_stockminimo  ,isnull(c_Commoditycodigo,'-') c_Commoditycodigo  ,c_Centrocosto  "
                + " from  lys..lo_requisicionesdetalle  "
                + " where  c_Compania = '" + compania + "' and c_numerorequisicion = '" + numeroreq + "'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            RequisicionLogDet det = new RequisicionLogDet();
            det.setC_compania(rs.getString(1));
            det.setC_item(rs.getString(2));
            det.setC_descripcion(rs.getString(3));
            det.setC_cantidadpedida(rs.getString(4));
            det.setC_stockdisponible(rs.getString(5));
            det.setC_stockminimo(rs.getString(6));
            det.setC_comoditycodigo(rs.getString(7));
            det.setC_centrocosto(rs.getString(8));

            result.add(det);
        }
        return result;

    }

    @WebMethod(operationName = "ValidarAprobacionReq")
    public String ValidarAprobacionReq(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nroreq", targetNamespace = "http://SOAP/") String nroreq, @WebParam(name = "usuarioaprobacion", targetNamespace = "http://SOAP/") String usuarioaprobacion) throws Exception {
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_MT_VALIDACION_APROBACIONREQ '" + compania + "','" + nroreq + "','" + usuarioaprobacion + "'";

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }
    
    
    private String GetParametroTexto (String  comp ,String aplicacion , String parametrocod) throws Exception{
        String result = "NO";
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_QUERY = "Select c_texto from lys..ma_parametros "+
                 "where c_compania = '"+comp+"' " +
                 " and c_aplicacion =  '"+aplicacion+"' "+
                 " and c_parametrocodigo = '"+parametrocod+"'";
                
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(SQL_QUERY);
        while (res.next()) {
            result = res.getString(1);
        }
        return result;
    }
    
    
    private String GetHoraServidor() throws Exception {

        String result = "NO";
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_QUERY = "select getdate()";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(SQL_QUERY);
        while (res.next()) {
            result = res.getString(1);
        }
        return result;

    }
    
    
    
    
    @WebMethod(operationName = "EjecutarAprobReqLog")
    public String EjecutarAprobReqLog(@WebParam(name = "compania",targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nroreq",targetNamespace = "http://SOAP/") String nroreq,
                                    @WebParam(name = "usuarioaprobacion",targetNamespace = "http://SOAP/") String usuarioaprobacion) throws Exception
    {
        String result ="NO";
        String mensaje = "";
        
        
        try {
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_QUERY = "EXEC lys..SP_LO_APRUEBAREQUISICION '"+compania+ "','"+nroreq + "','"+usuarioaprobacion+"','" +
                            this.GetHoraServidor()+"','"+mensaje+"'";
                            
                
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(SQL_QUERY);
        
         while (res.next())
         {
         result =  res.getString(1);
         }
         }
        catch(Exception e) {
            result = e.getMessage();
        }
       
        return result;
    }
    
     @WebMethod(operationName = "ListaRechazos")
    public ArrayList<Rechazos> ListaRechazos() throws Exception {
        //TODO write your implementation code here:
        ArrayList<Rechazos> result = new ArrayList<Rechazos>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "Select c_razonrechazo,c_descripcion  from lys..ma_rechazos "
                        +"where c_tipo = 'RERQ'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            Rechazos re = new Rechazos();
            re.setC_razonrechazo(rs.getString(1));
            re.setC_descripcion(rs.getString(2));
            result.add(re);
        }
        return result;

    }
    
    @WebMethod(operationName = "ValidaRechazoReqLog")
    public String ValidaRechazoReqLog(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nroreq", targetNamespace = "http://SOAP/") String nroreq, @WebParam(name = "usuariorechazo", targetNamespace = "http://SOAP/") String usuariorechazo) throws Exception {
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_MT_VALIDACION_RECHAZO_REQLOG '" + compania + "','" + nroreq + "','" + usuariorechazo + "'";

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }
    
    @WebMethod(operationName = "EjecutarRechazo")
    public String EjecutarRechazo(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nroreq", targetNamespace = "http://SOAP/") String nroreq, @WebParam(name = "razonrechazo", targetNamespace = "http://SOAP/") String razonrechazo,
                                    @WebParam(name = "descripcionrechazo", targetNamespace = "http://SOAP/") String descripcionrechazo) throws Exception {
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_QUERY  ="exec SPU_MT_RECHAZO_REQ_LOG '"+compania+"','"+nroreq+"','"+razonrechazo+"','"+descripcionrechazo+"'";

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_QUERY);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }
    
    @WebMethod(operationName = "EnvioCorreoAprobReqLog")
    public String EnvioCorreoAprobReqLog(@WebParam(name = "compania",targetNamespace = "http://SOAP/") String compania, @WebParam(name = "nroreq",targetNamespace = "http://SOAP/") String nroreq,
                                    @WebParam(name = "usuario",targetNamespace = "http://SOAP/") String usuario , @WebParam(name = "estado",targetNamespace = "http://SOAP/") String estado,
                                                @WebParam(name = "ccosto",targetNamespace = "http://SOAP/") String ccosto) throws Exception 
    {   
        
        ArrayList<CorreoApReqLog>   ListCorreoMsj = new ArrayList<CorreoApReqLog>() ;
        ArrayList<CorreoUsuarioCCosto> ListCorreoUsCCosto = new ArrayList<CorreoUsuarioCCosto>();
        String msjSubject  = "";
        if(estado.equals("AP")){
        ListCorreoUsCCosto = this.GetUsuariosCorreoCCosto(compania, ccosto) ;
        ListCorreoMsj = this.GetMensajeCorreoAprobacion(compania, nroreq, usuario,"AP");
         msjSubject = "Notificación de Aprobación de Requisición." ;
        
        }
        else if(estado.equals("RE")){
            ListCorreoMsj = this.GetMensajeCorreoAprobacion(compania, nroreq, usuario,"RE");
          
             msjSubject = "Se rechazó la requisicón # " + nroreq  ;
        }
        
      String result ="ERROR";
      String from = "sistemas@filtroslys.com.pe";
      String host = "smtp.office365.com";
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      properties.setProperty("mail.smtp.port", "587");
      properties.setProperty("mail.smtp.auth", "true");
      properties.setProperty("mail.smtp.starttls.enable", "true");
      final String sUsuarioMail =  this.CredencialesMail("User");
      final String  sClaveMail  = this.CredencialesMail("Pass") ;      
      Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( sUsuarioMail , sClaveMail);
			}
		  });
        try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         if (estado.equals("AP")) {
            if(ListCorreoMsj.size()>0){
                CorreoApReqLog c =  ListCorreoMsj.get(0);
                  message.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getC_correoaprobacion()));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getC_correocreacion()));
            }

            if(ListCorreoUsCCosto.size()>0){
                for (int i = 0; i < ListCorreoUsCCosto.size(); i++) {
                    CorreoUsuarioCCosto c  = ListCorreoUsCCosto.get(i);
                     message.addRecipient(Message.RecipientType.CC, new InternetAddress(c.getC_correo()));
                }

            }
         }
         else if (estado.equals("RE")){
             if(ListCorreoMsj.size()>0){
                CorreoApReqLog c =  ListCorreoMsj.get(0);
                  
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getC_correocreacion()));
            }
         }
         message.setSubject(msjSubject);
          if (ListCorreoMsj.size()>0) {
               message.setContent(ListCorreoMsj.get(0).getC_mensajeHtml(), "text/html");
          }
         Transport.send(message);
         result = "OK";
      } catch (Exception mex) {
          result = mex.getMessage();
      }
        return result;
    }
    
    private ArrayList<CorreoApReqLog> GetMensajeCorreoAprobacion (String sCompania ,String sNroReq , String sUsuario , String sEstado){
        ArrayList<CorreoApReqLog> result = new ArrayList<CorreoApReqLog>();
        
         try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_QUERY  ="exec SP_MT_CORREO_REQ_LOG '"+sCompania+"','"+sNroReq+"','"+sEstado+"','"+sUsuario+ "'";

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_QUERY);

            while (res.next()) {
                CorreoApReqLog  c = new CorreoApReqLog();
                c.setC_mensajeHtml(res.getString(1));
                c.setC_correoaprobacion(res.getString(2));
                c.setC_correocreacion(res.getString(3));
                //result = res.getString(1);
                result.add(c);
            }
        } catch (Exception e) {
            //result = e.getMessage();
        }

        
        return result ;
    }
    
     private ArrayList<CorreoUsuarioCCosto> GetUsuariosCorreoCCosto (String sCompania ,String CCosto){
        ArrayList<CorreoUsuarioCCosto> result = new ArrayList<CorreoUsuarioCCosto>();
        
         try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_QUERY  ="exec SP_MT_CORREO_USUARIO_CCOSTO '"+sCompania+"','"+CCosto+"'";

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_QUERY);

            while (res.next()) {
                CorreoUsuarioCCosto  c = new CorreoUsuarioCCosto();
                c.setC_usuario(res.getString(1));
                c.setC_correo(res.getString(2));
                result.add(c);
            }
        } catch (Exception e) {
            //result = e.getMessage();
        }

        
        return result ;
    }
     
     private String CredencialesMail (String tipo){
         String TextObt = "",UserMail ="" ,ClaveMail= "";
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        try {
            entrada = new FileInputStream(pathF + File.separator + "webapps" + File.separator + "LysWsRest" + File.separator + "propiedades" + File.separator + "configuracion.properties");
            propiedades.load(entrada);
            UserMail = propiedades.getProperty("usuarioMail");
             ClaveMail = propiedades.getProperty("claveMail");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        }
        
         if (tipo.equals("User")) {
            TextObt   = UserMail ;
         }
         else if (tipo.equals("Pass")) {
            TextObt   = ClaveMail;
         }
        
        return TextObt;
     }
     
     @WebMethod(operationName = "LoginUser")
    public String LoginUser(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario, @WebParam(name = "clave", targetNamespace = "http://SOAP/") String clave) throws Exception {
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_MT_LOGIN '" + usuario + "','" + clave + "'" ;

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }
    
    @WebMethod(operationName = "GetCentroCostoXCompania")
    public ArrayList<CentroCostoDB> GetCentroCostoXCompania(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania) throws Exception {
        //TODO write your implementation code here:
        ArrayList<CentroCostoDB> result = new ArrayList<CentroCostoDB>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT  c_Compania,c_Centrocosto ,upper(c_Nombres ) c_ccostonomb , c_Estado "+
                        "from   lys..ma_centrocostos  "+
                        " where c_Compania = '"+compania+"'"+
                        " order  by c_ccostonomb asc";

        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            CentroCostoDB cc = new CentroCostoDB();
            cc.setC_compania(rs.getString(1));
            cc.setC_centrocosto(rs.getString(2));
            cc.setC_descripcion(rs.getString(3));
            cc.setC_estado(rs.getString(4));
            result.add(cc);
        }
        return result;
    }
    
    @WebMethod(operationName = "GetMaquinaXCompania")
    public ArrayList<Maquina> GetMaquinaXCompania(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania) throws Exception {
        //TODO write your implementation code here:
        ArrayList<Maquina> result = new ArrayList<Maquina>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query =  "SELECT c_compania , c_maquina , c_descripcion ,  isnull(c_codigobarra,'-')c_codigobarra , "+
                        " isnull(c_familiainspeccion,'-') c_familiainspeccion,c_centrocosto ,c_estado , c_ultimousuario , "+
                        " convert(varchar(10) ,d_ultimafechamodificacion,103) d_ultimafechamodificacion "+
                         " FROM  lys..MT_MAQUINA"+
                        " where c_compania  = '"+compania+"' order by  c_descripcion asc" ;

        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);

        while (rs.next()) {

            Maquina mq = new Maquina();
            mq.setC_ompania(rs.getString(1));
            mq.setC_maquina(rs.getString(2));
            mq.setC_descripcion(rs.getString(3));
            mq.setC_codigobarras(rs.getString(4));
            mq.setC_familiainspeccion(rs.getString(5));
            mq.setC_centrocosto(rs.getString(6));
            mq.setC_estado(rs.getString(7));
            mq.setC_ultimousuario(rs.getString(8));
            mq.setD_ultimafechamodificacion(rs.getString(9));
            result.add(mq);
        }
        return result;
    }
    
    @WebMethod(operationName = "GetDefaultCompania")
    public String GetDefaultCompania() throws Exception {
         //TODO write your implementation code here:
        String sIpLocal = "", sIpExt = "";
        String CompGeneral = "" ;
        String sResult = "";
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        try {
            entrada = new FileInputStream(pathF + File.separator + "webapps" + File.separator + "LysWsRest" + File.separator + "propiedades" + File.separator + "configuracion.properties");
            propiedades.load(entrada);
            CompGeneral = propiedades.getProperty("Compania");
           // sIpExt = propiedades.getProperty("ipexterna");

        } catch (Exception ex) {
           // Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            sResult = ex.getMessage();
        } 
         sResult = CompGeneral;
        return sResult;
    }
    
    @WebMethod(operationName = "ActulizarMaestros")
    public String ActulizarMaestros() throws Exception {
        String result = "OK";
        
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC sp_mt_cargadata " ;

            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;

    }
    
     @WebMethod(operationName = "GetClientes")
    public ArrayList<TMACliente> GetClientes() throws Exception {

        ArrayList<TMACliente> listC = new ArrayList<TMACliente>();
        String query = "SELECT c_compania, n_cliente, c_razonsocial from TMA_CLIENTES;";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            TMACliente c = new TMACliente();
            c.setC_compania(rs.getString(1));
            c.setN_cliente( rs.getInt(2));
            c.setC_razonsocial(rs.getString(3));
            listC.add(c);

        }

        return listC;
    }
    
    @WebMethod(operationName = "GetListFallas")
    public ArrayList<TMAFalla> GetListFallas() throws Exception {

        ArrayList<TMAFalla> listF = new ArrayList<TMAFalla>();
        String query = "SELECT c_codigo, c_descripcion FROM  TMA_FALLA";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAFalla f = new TMAFalla();
            f.setC_codigo(rs.getString(1));
            f.setC_descripcion(rs.getString(2));
            listF.add(f);

        }

        return listF;
    }
    
      @WebMethod(operationName = "GetListMarcas")
      public ArrayList<TMAMarca> GetListMarcas() throws Exception {
        ArrayList<TMAMarca> listM = new ArrayList<TMAMarca>();
        String query = "SELECT c_marca, c_descripcion, c_estado FROM TMA_MARCA";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAMarca m = new TMAMarca();
            m.setC_marca(rs.getString(1));
            m.setC_descripcion(rs.getString(2));
            m.setC_estado(rs.getString(3));
            listM.add(m);
        }
        return listM;
    }
      
      
      @WebMethod(operationName = "GetListaModelos")
      public ArrayList<TMAModelo> GetListaModelos() throws Exception {
        ArrayList<TMAModelo> listM = new ArrayList<TMAModelo>();
        String query = "select  c_marca, c_modelo, c_descripcion, c_estado FROM  TMA_MODELO";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAModelo m = new TMAModelo();
            m.setC_marca(rs.getString(1));
            m.setC_modelo(rs.getString(2));
            m.setC_descripcion(rs.getString(3));
            m.setC_estado(rs.getString(4));
            listM.add(m);
        }
        return listM;
    }
      
     @WebMethod(operationName = "GetListaPruebasLab")
      public ArrayList<TMAPruebaLab> GetListaPruebasLab() throws Exception {
        ArrayList<TMAPruebaLab> listP = new ArrayList<TMAPruebaLab>();
        String query = "SELECT c_codigo, c_descripcion, isnull( c_tipo , '-') c_tipo, "+
                        " isnull(c_unidadcodigo,'-') c_unidadcodigo  from  TMA_PRUEBALAB";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAPruebaLab p = new TMAPruebaLab();
            p.setC_codigo(rs.getString(1));
            p.setC_descripcion(rs.getString(2));
            p.setC_tipo(rs.getString(3));
            p.setC_unidadcodigo(rs.getString(4));
            listP.add(p);
        }
        return listP;
    }
      
    @WebMethod(operationName = "GetLisTipoReclamo")
      public ArrayList<TMATipoReclamo> GetLisTipoReclamo() throws Exception {
        ArrayList<TMATipoReclamo> listR = new ArrayList<TMATipoReclamo>();
        String query = "SELECT c_tiporeclamo, c_descripcion, c_estado, c_tipo FROM  dbo.TMA_TIPORECLAMO";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMATipoReclamo r = new TMATipoReclamo();
            r.setC_tiporeclamo(rs.getString(1));
            r.setC_descripcion(rs.getString(2));
            r.setC_estado(rs.getString(3));
            r.setC_tipo(rs.getString(4));
            listR.add(r);
        }
        return listR;
    }
      
       @WebMethod(operationName = "GetListaVendedores")
      public ArrayList<TMAVendedor> GetListaVendedores() throws Exception {
        ArrayList<TMAVendedor> listV = new ArrayList<TMAVendedor>();
        String query = "select c_compania, c_vendedor, c_ciasecundaria, c_nombres, c_estado from dbo.TMA_VENDEDOR";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAVendedor v = new TMAVendedor();
            v.setC_compania(rs.getString(1));
            v.setC_vendedor(rs.getString(2));
            v.setC_ciasecundaria(rs.getString(3));
            v.setC_nombres(rs.getString(4));
            v.setC_estado(rs.getString(5));
            listV.add(v);
        }
        return listV;
    }
      

@WebMethod(operationName = "GetListaCalificacionQueja")
    public ArrayList<TMACalificacionQueja> GetListaCalificacionQueja() throws Exception{
        ArrayList<TMACalificacionQueja> LstData = new ArrayList<TMACalificacionQueja>();
        String query = "Select c_calificacion,c_descripcion,c_usuarioderivacion,c_correo,c_estado from dbo.TMA_CALIFICACIONQUEJA";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMACalificacionQueja oEnt = new TMACalificacionQueja();
            oEnt.setC_calificacion(rs.getString(1));
            oEnt.setC_descripcion(rs.getString(2));
            oEnt.setC_usuarioderivacion(rs.getString(3));
            oEnt.setC_correo(rs.getString(4));
            oEnt.setC_estado(rs.getString(5));
            LstData.add(oEnt);
        }
        return LstData;
    }

    @WebMethod(operationName = "GetListMedioRecepcion")
    public ArrayList<TMAMedioRecepcion> GetListMedioRecepcion() throws Exception{
        ArrayList<TMAMedioRecepcion> LstData = new ArrayList<TMAMedioRecepcion>();
        String query = "Select c_mediorecepcion,c_descripcion,c_estado from dbo.TMA_MEDIORECEPCION";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAMedioRecepcion oEnt = new TMAMedioRecepcion();
            oEnt.setC_mediorecepcion(rs.getString(1));
            oEnt.setC_descripcion(rs.getString(2));
            oEnt.setC_estado(rs.getString(3));
            LstData.add(oEnt);
        }
        return LstData;
    }

    @WebMethod(operationName = "GetListTipoCalificacionQueja")
    public ArrayList<TMATipoCalificacionQueja> GetListTipoCalificacionQueja() throws Exception{
        ArrayList<TMATipoCalificacionQueja> LstData = new ArrayList<TMATipoCalificacionQueja>();
        String query = "Select c_tipocalificacion,c_calificacion,c_descripcion,c_estado from dbo.TMA_TIPOCALIFICACIONQUEJA";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMATipoCalificacionQueja oEnt = new TMATipoCalificacionQueja();
            oEnt.setC_tipocalificacion(rs.getString(1));
            oEnt.setC_calificacion(rs.getString(2));
            oEnt.setC_descripcion(rs.getString(3));
            oEnt.setC_estado(rs.getString(4));
            LstData.add(oEnt);
        }
        return LstData;
    }

    @WebMethod(operationName = "GetListAccionesTomar")
    public ArrayList<TMAAccionesTomar> GetListAccionesTomar() throws Exception{
        ArrayList<TMAAccionesTomar> LstData = new ArrayList<TMAAccionesTomar>();
        String query = "Select c_codaccion,c_descripcion,c_estado from dbo.TMA_ACCIONESTOMAR";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMAAccionesTomar oEnt = new TMAAccionesTomar();
            oEnt.setC_codaccion(rs.getString(1));
            oEnt.setC_descripcion(rs.getString(2));
            oEnt.setC_estado(rs.getString(3));
            LstData.add(oEnt);
        }
        return LstData;
    }

    @WebMethod(operationName = "GetListNotificacionQueja")
    public ArrayList<TMANotificacionQueja> GetListNotificacionQueja() throws Exception{
        ArrayList<TMANotificacionQueja> LstData = new ArrayList<TMANotificacionQueja>();
        String query = "Select c_notificacion,c_descripcion,c_envianot,c_usuarionot,c_estado from dbo.TMA_NOTIFICACIONQUEJA";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMANotificacionQueja oEnt = new TMANotificacionQueja();
            oEnt.setC_notificacion(rs.getString(1));
            oEnt.setC_descripcion(rs.getString(2));
            oEnt.setC_envianot(rs.getString(3));
            oEnt.setC_usuarionot(rs.getString(4));
            oEnt.setC_estado(rs.getString(5));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    /*****************************************/
    /*******MODULO RECLAMO GARANTIA***********/
    /*****************************************/    
    @WebMethod(operationName = "GetCorrelativorRecGar")
    public String GetCorrelativorRecGar() throws Exception {
        String result = "0";
        String query = "select  n_ultimocorrelativo from   dbo.MA_CORRELATIVOS "+
                       "where c_TipoDocumento = 'SY'  and c_seriedocumento = 'RGAR' "+
                       "and  c_aplicacion = 'CO'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }
    
    @WebMethod(operationName = "GetCorrelativorQueja")
    public String GetCorrelativorQueja() throws Exception {
        String result = "0";
        String query = "select  n_ultimocorrelativo from   dbo.MA_CORRELATIVOS "+
                       "where c_TipoDocumento = 'SY'  and c_seriedocumento = 'QUEJ' "+
                       "and  c_aplicacion = 'CO'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }
    
    @WebMethod(operationName = "InsertReclamoGarantia")
    public String InsertReclamoGarantia(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario, @WebParam(name = "tiporeclamo", targetNamespace = "http://SOAP/") String tiporeclamo, @WebParam(name = "fecha", targetNamespace = "http://SOAP/") String fecha, @WebParam(name = "formato", targetNamespace = "http://SOAP/") String formato, @WebParam(name = "fechaformato", targetNamespace = "http://SOAP/") String fechaformato, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "filtro", targetNamespace = "http://SOAP/") String filtro, @WebParam(name = "lotefiltro", targetNamespace = "http://SOAP/") String lotefiltro, @WebParam(name = "procedencia", targetNamespace = "http://SOAP/") String procedencia, @WebParam(name = "facturaref", targetNamespace = "http://SOAP/") String facturaref, @WebParam(name = "lote1", targetNamespace = "http://SOAP/") String lote1, @WebParam(name = "lote2", targetNamespace = "http://SOAP/") String lote2, @WebParam(name = "lote3", targetNamespace = "http://SOAP/") String lote3, @WebParam(name = "cantlote1", targetNamespace = "http://SOAP/") String cantlote1, @WebParam(name = "cantlote2", targetNamespace = "http://SOAP/") String cantlote2, @WebParam(name = "cantlote3", targetNamespace = "http://SOAP/") String cantlote3, @WebParam(name = "tiempouso", targetNamespace = "http://SOAP/") String tiempouso, @WebParam(name = "marca", targetNamespace = "http://SOAP/") String marca, @WebParam(name = "modelo", targetNamespace = "http://SOAP/") String modelo, @WebParam(name = "year", targetNamespace = "http://SOAP/") String year, @WebParam(name = "placavech", targetNamespace = "http://SOAP/") String placavech, @WebParam(name = "obervclie", targetNamespace = "http://SOAP/") String obervclie, @WebParam(name = "pruebalab1", targetNamespace = "http://SOAP/") String pruebalab1, @WebParam(name = "pruebalab2", targetNamespace = "http://SOAP/") String pruebalab2, @WebParam(name = "pruebalab3", targetNamespace = "http://SOAP/") String pruebalab3, @WebParam(name = "ensayo1", targetNamespace = "http://SOAP/") String ensayo1, @WebParam(name = "ensayo2", targetNamespace = "http://SOAP/") String ensayo2, @WebParam(name = "ensayo3", targetNamespace = "http://SOAP/") String ensayo3, @WebParam(name = "ensayo4", targetNamespace = "http://SOAP/") String ensayo4, @WebParam(name = "ensayo5", targetNamespace = "http://SOAP/") String ensayo5, @WebParam(name = "prediagvend", targetNamespace = "http://SOAP/") String prediagvend, @WebParam(name = "prediagobse", targetNamespace = "http://SOAP/") String prediagobse, @WebParam(name = "reembolsocli", targetNamespace = "http://SOAP/") String reembolsocli, @WebParam(name = "reembolsomto", targetNamespace = "http://SOAP/") String reembolsomto, @WebParam(name = "reembolsomon", targetNamespace = "http://SOAP/") String reembolsomon, @WebParam(name = "necesitavisita", targetNamespace = "http://SOAP/") String necesitavisita) throws Exception{
        //TODO write your implementation code here:
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERTARECLAMO '" +compania + "',"+correlativo+",'"+accion+"','"+usuario+"','"+tiporeclamo+"','"+fecha+"',"+formato+",'"+fechaformato+"',"+
                                cliente+",'"+filtro+"','"+lotefiltro+"','"+procedencia+"','"+facturaref+"','"+lote1+"','"+lote2+"','"+lote3+"',"+
                                cantlote1+","+cantlote2+","+cantlote3+",'"+ tiempouso+"','" +marca+"','"+modelo+"',"+year+",'"+placavech+"','"+obervclie+"','"+pruebalab1+"','"+
                                pruebalab2+"','"+pruebalab3+"','"+ensayo1+ "','"+ensayo2+"','"+ensayo3+"','"+ensayo4+"','"+ensayo5+"','"+
                                prediagvend+"','"+prediagobse+"','"+reembolsocli+"',"+reembolsomto+",'"+reembolsomon+"','"+necesitavisita+"';";
                               
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }

        return result;
    }

    @WebMethod(operationName = "TransferirReclamoGarantia")
    public String TransferirReclamoGarantia(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_TRANSFERIRRECLAMO @Compania  = '" + compania + "', @Correlativo = " + correlativo + " , @Accion = '" + accion + "'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    
    @WebMethod(operationName = "ListReclamoGarantia")
    public ArrayList<ReclamoGarantia> ListReclamoGarantia(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente,
           @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "fecharegini", targetNamespace = "http://SOAP/") String fecharegini, @WebParam(name = "fecharegfin", targetNamespace = "http://SOAP/") String fecharegfin) throws Exception{
        ArrayList<ReclamoGarantia> result = new ArrayList<ReclamoGarantia>();
        
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CO_LISTARECLAMO_ONLINE ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setInt(2, Integer.valueOf(cliente));
        statement.setString(3, estado);
        statement.setString(4, fecharegini);
        statement.setString(5, fecharegfin);
        ResultSet res = statement.executeQuery();

        while (res.next()) {
            ReclamoGarantia oEnt = new ReclamoGarantia();
            oEnt.setC_compania(res.getString(1));
            oEnt.setN_correlativo(res.getLong(2));
            oEnt.setD_fecha(res.getString(3));
            oEnt.setN_cliente(res.getInt(4));
            oEnt.setC_codproducto(res.getString(5));
            oEnt.setC_lote(res.getString(6));
            oEnt.setC_procedencia(res.getString(7));
            oEnt.setN_qtyingreso(res.getDouble(8));
            oEnt.setC_vendedor(res.getString(9));
            oEnt.setC_estado(res.getString(10));
            oEnt.setC_lote1(res.getString(11));
            oEnt.setC_lote2(res.getString(12));
            oEnt.setC_lote3(res.getString(13));
            oEnt.setN_cantlote1(res.getDouble(14));
            oEnt.setN_cantlote2(res.getDouble(15));
            oEnt.setN_cantlote3(res.getDouble(16));
            oEnt.setC_codmarca(res.getString(17));
            oEnt.setC_codmodelo(res.getString(18));
            oEnt.setN_pyear(res.getInt(19));
            oEnt.setC_tiempouso(res.getString(20));
            oEnt.setC_facturaRef(res.getString(21));
            oEnt.setC_prediagnostico(res.getString(23));
            oEnt.setN_formato(res.getInt(24));
            oEnt.setD_fechaformato(res.getString(25));
            oEnt.setC_obscliente(res.getString(26));
            oEnt.setC_flagvisita(res.getString(27));
            oEnt.setC_tiporeclamo(res.getString(28));
            oEnt.setC_reembcliente(res.getString(29));
            oEnt.setC_placavehic(res.getString(30));
            oEnt.setN_montoreembcli(res.getDouble(31));
            oEnt.setC_monedareembcli(res.getString(32));
            oEnt.setC_pruebalab1(res.getString(33));
            oEnt.setC_pruebalab2(res.getString(34));
            oEnt.setC_pruebalab3(res.getString(35));
            oEnt.setC_ensayo01(res.getString(36));
            oEnt.setC_ensayo02(res.getString(37));
            oEnt.setC_ensayo03(res.getString(38));
            oEnt.setC_ensayo04(res.getString(39));
            oEnt.setC_ensayo05(res.getString(40));
            oEnt.setC_usuario(res.getString(41));
            result.add(oEnt);
        }
        return result;
    }

    /*****************************************/
    /**********MODULO QUEJA CLIENTE***********/
    /*****************************************/
    @WebMethod(operationName = "InsertQuejaCliente")
    public String InsertQuejaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario, @WebParam(name = "nroformato", targetNamespace = "http://SOAP/") String nroformato, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "fecha", targetNamespace = "http://SOAP/") String fecha, @WebParam(name = "documentoref", targetNamespace = "http://SOAP/") String documentoref, @WebParam(name = "mediorecepcion", targetNamespace = "http://SOAP/") String mediorecepcion, @WebParam(name = "centrocosto", targetNamespace = "http://SOAP/") String centrocosto, @WebParam(name = "calificacion", targetNamespace = "http://SOAP/") String calificacion, @WebParam(name = "usuarioderiv", targetNamespace = "http://SOAP/") String usuarioderiv, @WebParam(name = "tipocalificacion", targetNamespace = "http://SOAP/") String tipocalificacion, @WebParam(name = "item", targetNamespace = "http://SOAP/") String item, @WebParam(name = "lote", targetNamespace = "http://SOAP/") String lote, @WebParam(name = "cantidad", targetNamespace = "http://SOAP/") String cantidad, @WebParam(name = "descqueja", targetNamespace = "http://SOAP/") String descqueja, @WebParam(name = "observaciones", targetNamespace = "http://SOAP/") String observaciones, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado) throws Exception {
        //TODO write your implementation code here:
        String result = "NO";

        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERTAQUEJA '"+compania+"',"+correlativo+",'"+accion+"','"+usuario+"','"+nroformato+"',"+cliente+",'"+
                                fecha+"','"+documentoref+"','"+mediorecepcion+"','"+centrocosto+"','"+calificacion+"','"+usuarioderiv+ "','"+
                                tipocalificacion+"','"+item+"','"+lote+"',"+cantidad+",'"+descqueja+"','"+observaciones+"','"+estado+"'";
                               
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }     
        return result;
    }

    @WebMethod(operationName = "TransferirQuejaCliente")
    public String TransferirQuejaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_TRANSFERIRQUEJA @Compania  = '" + compania + "', @Correlativo = " + correlativo + " , @Accion = '" + accion + "'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }

    @WebMethod(operationName = "ListQuejaCliente")
    public ArrayList<QuejaCliente> ListQuejaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "fecharegini", targetNamespace = "http://SOAP/") String fecharegini, @WebParam(name = "fecharegfin", targetNamespace = "http://SOAP/") String fecharegfin) throws Exception {
        ArrayList<QuejaCliente> result = new ArrayList<QuejaCliente>();
        
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CO_LISTAQUEJA_ONLINE ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setInt(2, Integer.valueOf(cliente));
        statement.setString(3, estado);
        statement.setString(4, fecharegini);
        statement.setString(5, fecharegfin);
        ResultSet res = statement.executeQuery();

        while (res.next()) {
            QuejaCliente oEnt = new QuejaCliente();
            oEnt.setC_compania(res.getString(1));
            oEnt.setN_correlativo(res.getLong(2));
            oEnt.setC_queja(res.getString(3));
            oEnt.setN_cliente(res.getInt(4));
            oEnt.setC_razonsocial(res.getString(5));
            oEnt.setC_documentoref(res.getString(6));
            oEnt.setC_mediorecepcion(res.getString(7));
            oEnt.setC_desqueja(res.getString(8));
            oEnt.setC_calificacion(res.getString(9));
            oEnt.setC_tipocalificacion(res.getString(10));
            oEnt.setC_observaciones(res.getString(11));
            oEnt.setC_centrocosto(res.getString(12));
            oEnt.setD_fechareg(res.getString(13));
            oEnt.setC_item(res.getString(14));
            oEnt.setC_lote(res.getString(15));
            oEnt.setN_cantidad(res.getDouble(16));
            oEnt.setC_usuarioinvestigacion(res.getString(17));
            oEnt.setD_fechaderivacion(res.getString(18));
            oEnt.setC_estado(res.getString(19));
            oEnt.setC_unidadneg(res.getString(20));
            oEnt.setC_descripcioninvestigacion(res.getString(21));
            oEnt.setC_procede(res.getString(22));
            oEnt.setD_fecharespuesta(res.getString(23));
            oEnt.setC_usuarioinvestigadopor(res.getString(24));
            oEnt.setD_fechainvestigadopor(res.getString(25));
            oEnt.setC_flaginvestigando(res.getString(26));
            oEnt.setC_tipocalificacioncierre(res.getString(27));
            oEnt.setC_descripcioncierre(res.getString(28));
            oEnt.setC_usuariocerrado(res.getString(29));
            oEnt.setD_fechacerrado(res.getString(30));
            oEnt.setC_codaccion1(res.getString(31));
            oEnt.setC_codaccion2(res.getString(32));
            oEnt.setC_codaccion3(res.getString(33));
            oEnt.setC_codaccion4(res.getString(34));
            oEnt.setC_cerrado(res.getString(35));
            oEnt.setC_notificacion(res.getString(36));
            oEnt.setC_observacionescierre(res.getString(37));
             oEnt.setC_estadofin(res.getString(38));
            result.add(oEnt);
        }
        return result;
    }
    
    /*****************************************/
    /**********MODULO SUGERENCIAS*************/
    /*****************************************/
    @WebMethod(operationName = "GetListTipoSugerencia")
    public ArrayList<TMATipoSugerencia> GetListTipoSugerencia() throws Exception{
        ArrayList<TMATipoSugerencia> LstData = new ArrayList<TMATipoSugerencia>();
        String query = "Select c_tiposugerencia,c_descripcion,c_estado from dbo.TMA_TIPOSUGERENCIA";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMATipoSugerencia oEnt = new TMATipoSugerencia();
            oEnt.setC_tiposugerencia(rs.getString(1));
            oEnt.setC_descripcion(rs.getString(2));
            oEnt.setC_estado(rs.getString(3));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    @WebMethod(operationName = "GetCorrelativoSugerencia")
    public String GetCorrelativoSugerencia() throws Exception {
        String result = "0";
        String query = "select n_ultimocorrelativo from dbo.MA_CORRELATIVOS "+
                       "where c_TipoDocumento = 'SY' and c_seriedocumento = 'RSUG' "+
                       "and c_aplicacion = 'CO'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }

    @WebMethod(operationName = "InsertSugerenciaCliente")
    public String InsertSugerenciaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo,  @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario, @WebParam(name = "fecha", targetNamespace = "http://SOAP/") String fecha, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "tiposugerencia", targetNamespace = "http://SOAP/") String tiposugerencia, @WebParam(name = "descripcion", targetNamespace = "http://SOAP/") String descripcion, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado,@WebParam(name = "tipoinfo", targetNamespace = "http://SOAP/") String tipoinfo,@WebParam(name = "observacion", targetNamespace = "http://SOAP/") String observacion) {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERTASUGERENCIA '"+compania+"',"+correlativo+",'"+accion+"','"+usuario+ "','" + tipoinfo + "','" +fecha+"',"+cliente+",'"+tiposugerencia+"','"+
                                descripcion+"','" + observacion + "','"+estado+"'";                               
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);

            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "TransferirSugerenciaCliente")
    public String TransferirSugerenciaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_TRANSFERIRSUGERENCIA @Compania  = '" + compania + "', @Correlativo = " + correlativo + " , @Accion = '" + accion + "'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "ListSugerenciaCliente")
    public ArrayList<SugerenciaCliente> ListSugerenciaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "fecharegini", targetNamespace = "http://SOAP/") String fecharegini, @WebParam(name = "fecharegfin", targetNamespace = "http://SOAP/") String fecharegfin, @WebParam(name = "tipoinfo", targetNamespace = "http://SOAP/") String tipoinfo) throws Exception {
        ArrayList<SugerenciaCliente> result = new ArrayList<SugerenciaCliente>();
        
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CO_LISTASUGERENCIA_ONLINE ?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setInt(2, Integer.valueOf(cliente));
        statement.setString(3, estado);
        statement.setString(4, fecharegini);
        statement.setString(5, fecharegfin);
        statement.setString(6, tipoinfo);
        ResultSet res = statement.executeQuery();

        while (res.next()) {
            SugerenciaCliente oEnt = new SugerenciaCliente();
            oEnt.setC_compania(res.getString(1));
            oEnt.setN_correlativo(res.getLong(2));            
            oEnt.setN_cliente(res.getInt(3));
            oEnt.setD_fecha(res.getString(4));
            oEnt.setC_tiposug(res.getString(5));
            oEnt.setC_descripcion(res.getString(6));
            oEnt.setC_usuarioreg(res.getString(7));
            oEnt.setD_fechareg(res.getString(8));
            oEnt.setC_estado(res.getString(9));
            oEnt.setC_usuariorev(res.getString(10));
            oEnt.setD_fecharev(res.getString(11));
            oEnt.setC_observacionrev(res.getString(12));
            oEnt.setC_accionrev(res.getString(13));
            oEnt.setC_flagfinrev(res.getString(14));
            oEnt.setC_usuarioAN(res.getString(15));
            oEnt.setD_fechaAN(res.getString(16));
            oEnt.setC_observacionAN(res.getString(17));
            oEnt.setC_usuarioCE(res.getString(18));
            oEnt.setD_fechaCE(res.getString(19));
            oEnt.setC_observacionCE(res.getString(20)); 
            oEnt.setC_tipoinfo(res.getString(21));
            oEnt.setN_identinfo(res.getLong(22));
            oEnt.setC_observacion(res.getString(23));
            result.add(oEnt);
        }
        return result;
    }

    /*****************************************/
    /**********MODULO CAPACITACION************/
    /*****************************************/
    @WebMethod(operationName = "GetListTemaCapacitacion")
    public ArrayList<TMATemaCapacitacion> GetListTemaCapacitacion() throws Exception{
        ArrayList<TMATemaCapacitacion> LstData = new ArrayList<TMATemaCapacitacion>();
        String query = "Select c_temacapacitacion,c_descripcion,c_estado from dbo.TMA_TEMACAPACITACION";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMATemaCapacitacion oEnt = new TMATemaCapacitacion();
            oEnt.setC_temacapacitacion(rs.getString(1));
            oEnt.setC_descripcion(rs.getString(2));
            oEnt.setC_estado(rs.getString(3));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    @WebMethod(operationName = "GetListDireccionCli")
    public ArrayList<TMADireccionCli> GetListDireccionCli() throws Exception{
        ArrayList<TMADireccionCli> LstData = new ArrayList<TMADireccionCli>();
        String query = "Select c_compania,n_cliente,n_secuencia,c_descripcion,c_estado from dbo.TMA_DIRECCIONCLI";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            TMADireccionCli oEnt = new TMADireccionCli();
            oEnt.setC_compania(rs.getString(1));
            oEnt.setN_cliente(rs.getInt(2));
            oEnt.setN_secuencia(rs.getInt(3));
            oEnt.setC_descripcion(rs.getString(4));
            oEnt.setC_estado(rs.getString(5));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    @WebMethod(operationName = "GetCorrelativoCapacitacion")
    public String GetCorrelativoCapacitacion() throws Exception {
        String result = "0";
        String query = "select n_ultimocorrelativo from dbo.MA_CORRELATIVOS "+
                       "where c_TipoDocumento = 'SY' and c_seriedocumento = 'RSCA' "+
                       "and c_aplicacion = 'CO'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }

    @WebMethod(operationName = "InsertCapacitacionCliente")
    public String InsertCapacitacionCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario, @WebParam(name = "fecha", targetNamespace = "http://SOAP/") String fecha, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "personas", targetNamespace = "http://SOAP/") String personas, @WebParam(name = "fechaprob", targetNamespace = "http://SOAP/") String fechaprob, @WebParam(name = "horaprob", targetNamespace = "http://SOAP/") String horaprob, @WebParam(name = "lugar", targetNamespace = "http://SOAP/") String lugar, @WebParam(name = "direccioncli", targetNamespace = "http://SOAP/") String direccioncli, @WebParam(name = "direccionreg", targetNamespace = "http://SOAP/") String direccionreg, @WebParam(name = "temacapacitacion", targetNamespace = "http://SOAP/") String temacapacitacion, @WebParam(name = "descripciontema", targetNamespace = "http://SOAP/") String descripciontema, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado,@WebParam(name = "observacion", targetNamespace = "http://SOAP/") String observacion) {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERTASOLCAPACITACION '"+compania+"',"+correlativo+",'"+accion+
                                "','" + usuario + "','"+fecha+
                                "',"+cliente+",'"+personas+"','"+fechaprob+"','"+horaprob+"','"+lugar+"',"+direccioncli+
                                ",'" + direccionreg +"','"+temacapacitacion+"','"+descripciontema+"','" + observacion + "','"+estado+"';";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "TransferirCapacitacionCliente")
    public String TransferirCapacitacionCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_TRANSFERIRSOLCAPACITACION @Compania  = '" + compania + "', @Correlativo = " + correlativo + " , @Accion = '" + accion + "'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "ListCapacitacionCliente")
    public ArrayList<CapacitacionCliente> ListCapacitacionCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "cliente", targetNamespace = "http://SOAP/") String cliente, @WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado, @WebParam(name = "fecharegini", targetNamespace = "http://SOAP/") String fecharegini, @WebParam(name = "fecharegfin", targetNamespace = "http://SOAP/") String fecharegfin) throws Exception {
        ArrayList<CapacitacionCliente> result = new ArrayList<CapacitacionCliente>();
        
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CO_LISTASOLCAPACITACION_ONLINE ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setInt(2, Integer.valueOf(cliente));
        statement.setString(3, estado);
        statement.setString(4, fecharegini);
        statement.setString(5, fecharegfin);
        ResultSet res = statement.executeQuery();

        while (res.next()) {
            CapacitacionCliente oEnt = new CapacitacionCliente();
            oEnt.setC_compania(res.getString(1));
            oEnt.setN_correlativo(res.getLong(2));
            oEnt.setN_cliente(res.getInt(3));
            oEnt.setD_fecha(res.getString(4));
            oEnt.setN_personas(res.getInt(5));
            oEnt.setD_fechaprob(res.getString(6));
            oEnt.setD_horaprob(res.getString(7));
            oEnt.setC_lugar(res.getString(8));
            oEnt.setN_direccioncli(res.getInt(9));
            oEnt.setC_direccionreg(res.getString(10));
            oEnt.setC_temacapacitacion(res.getString(11));
            oEnt.setC_descripciontema(res.getString(12));
            oEnt.setC_usuarioreg(res.getString(13));
            oEnt.setD_fechareg(res.getString(14));
            oEnt.setC_estado(res.getString(15));
            oEnt.setC_usuariorev(res.getString(16));
            oEnt.setD_fecharev(res.getString(17));
            oEnt.setC_observacionrev(res.getString(18));
            oEnt.setC_accionrev(res.getString(19));
            oEnt.setC_flagfinrev(res.getString(20));
            oEnt.setC_usuarioAN(res.getString(21));
            oEnt.setD_fechaAN(res.getString(22));
            oEnt.setC_observacionAN(res.getString(23));
            oEnt.setC_usuarioCE(res.getString(24));
            oEnt.setD_fechaCE(res.getString(25));
            oEnt.setC_observacionCE(res.getString(26));  
            oEnt.setC_observacion(res.getString(27));
            result.add(oEnt);
        }
        return result;
    }
    
    @WebMethod(operationName = "InsertDocsReclamoGar")
    public String InsertDocsReclamoGar(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "linea", targetNamespace = "http://SOAP/") String linea ,@WebParam(name = "descripcion", targetNamespace = "http://SOAP/") String descripcion ,@WebParam(name = "nombrearchivo", targetNamespace = "http://SOAP/") String nombrearchivo,@WebParam(name = "rutaarchivo", targetNamespace = "http://SOAP/") String rutaarchivo ,@WebParam(name = "ultusuario", targetNamespace = "http://SOAP/") String ultusuario) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERT_DOCS_RG '"+compania+"',"+correlativo+","+linea+",'"+descripcion+"','"+nombrearchivo+"','"+rutaarchivo+"','"+ultusuario+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "InsertDocsQuejaCliente")
    public String InsertDocsQuejaCliente(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "linea", targetNamespace = "http://SOAP/") String linea ,@WebParam(name = "descripcion", targetNamespace = "http://SOAP/") String descripcion ,@WebParam(name = "nombrearchivo", targetNamespace = "http://SOAP/") String nombrearchivo,@WebParam(name = "rutaarchivo", targetNamespace = "http://SOAP/") String rutaarchivo ,@WebParam(name = "ultusuario", targetNamespace = "http://SOAP/") String ultusuario) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERT_DOCS_QJ '"+compania+"',"+correlativo+","+linea+",'"+descripcion+"','"+nombrearchivo+"','"+rutaarchivo+"','"+ultusuario+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
     @WebMethod(operationName = "InsertDocsSugerencia")
    public String InsertDocsSugerencia(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "linea", targetNamespace = "http://SOAP/") String linea ,@WebParam(name = "descripcion", targetNamespace = "http://SOAP/") String descripcion ,@WebParam(name = "nombrearchivo", targetNamespace = "http://SOAP/") String nombrearchivo,@WebParam(name = "rutaarchivo", targetNamespace = "http://SOAP/") String rutaarchivo ,@WebParam(name = "ultusuario", targetNamespace = "http://SOAP/") String ultusuario) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERT_DOCS_SG '"+compania+"',"+correlativo+","+linea+",'"+descripcion+"','"+nombrearchivo+"','"+rutaarchivo+"','"+ultusuario+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "GetListFotosRG")
    public ArrayList<DocsReclamoGarantia> GetListFotosRG( @WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania ,@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo ) throws Exception{
        ArrayList<DocsReclamoGarantia> LstData = new ArrayList<DocsReclamoGarantia>();
        String query = "select c_compania, n_numero, n_linea, isnull(c_descripcion,'') c_descripcion, c_nombre_archivo, c_ruta_archivo, c_ultimousuario , d_ultimafechamodificacion "+
                        "from  lys..CO_RECLAMOSGARANTIA_DOC where c_compania = '"+compania+"' and n_numero ="+correlativo;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            DocsReclamoGarantia oEnt = new DocsReclamoGarantia();
            oEnt.setC_compania(rs.getString(1));
            oEnt.setN_numero(rs.getInt(2));
            oEnt.setN_linea(rs.getInt(3));
            oEnt.setC_descripcion(rs.getString(4));
            oEnt.setC_nombre_archivo(rs.getString(5));
            oEnt.setC_ruta_archivo(rs.getString(6));
            oEnt.setC_ultimousuario(rs.getString(7));
            oEnt.setD_ultimafechamodificacion(rs.getString(8));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    @WebMethod(operationName = "GetListFotosQJ")
    public ArrayList<DocsQuejaCliente> GetListFotosQJ( @WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania ,@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo ) throws Exception{
        ArrayList<DocsQuejaCliente> LstData = new ArrayList<DocsQuejaCliente>();
        String query = "select c_compania, n_queja, n_linea, isnull(c_descripcion,'') c_descripcion, c_nombre_archivo, c_ruta_archivo, c_ultimousuario ,d_ultimafechamodificacion "+
                        "from  lys..CO_QUEJACLIENTE_DOC where c_compania = '"+compania+"' and n_queja ="+correlativo;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            DocsQuejaCliente oEnt = new DocsQuejaCliente();
            oEnt.setC_compania(rs.getString(1));
            oEnt.setN_queja(rs.getInt(2));
            oEnt.setN_linea(rs.getInt(3));
            oEnt.setC_descripcion(rs.getString(4));
            oEnt.setC_nombre_archivo(rs.getString(5));
            oEnt.setC_ruta_archivo(rs.getString(6));
            oEnt.setC_ultimousuario(rs.getString(7));
            oEnt.setD_ultimafechamodificacion(rs.getString(8));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    
    
    
    @WebMethod(operationName = "GetListFotosSG")
    public ArrayList<DocsSugerencia> GetListFotosSG( @WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania ,@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo ) throws Exception{
        ArrayList<DocsSugerencia> LstData = new ArrayList<DocsSugerencia>();
        String query = "select c_compania, n_sugerencia, n_linea, isnull(c_descripcion,'') c_descripcion, c_nombre_archivo, c_ruta_archivo, c_ultimousuario ,d_ultimafechamodificacion "+
                        "from  lys..co_sugerenciacliente_doc where c_compania = '"+compania+"' and n_sugerencia ="+correlativo;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            DocsSugerencia oEnt = new DocsSugerencia();
            oEnt.setC_compania(rs.getString(1));
            oEnt.setN_sugerencia(rs.getInt(2));
            oEnt.setN_linea(rs.getInt(3));
            oEnt.setC_descripcion(rs.getString(4));
            oEnt.setC_nombre_archivo(rs.getString(5));
            oEnt.setC_ruta_archivo(rs.getString(6));
            oEnt.setC_ultimousuario(rs.getString(7));
            oEnt.setD_ultimafechamodificacion(rs.getString(8));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    @WebMethod(operationName = "InsertDocsCapacitacion")
    public String InsertDocsCapacitacion(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo, @WebParam(name = "linea", targetNamespace = "http://SOAP/") String linea ,@WebParam(name = "descripcion", targetNamespace = "http://SOAP/") String descripcion ,@WebParam(name = "nombrearchivo", targetNamespace = "http://SOAP/") String nombrearchivo,@WebParam(name = "rutaarchivo", targetNamespace = "http://SOAP/") String rutaarchivo ,@WebParam(name = "ultusuario", targetNamespace = "http://SOAP/") String ultusuario) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_CO_INSERT_DOCS_CP '"+compania+"',"+correlativo+","+linea+",'"+descripcion+"','"+nombrearchivo+"','"+rutaarchivo+"','"+ultusuario+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "GetListFotosCP")
    public ArrayList<DocsCapacitacion> GetListFotosCP( @WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania ,@WebParam(name = "correlativo", targetNamespace = "http://SOAP/") String correlativo ) throws Exception{
        ArrayList<DocsCapacitacion> LstData = new ArrayList<DocsCapacitacion>();
        String query = "select c_compania, n_solicitud, n_linea, isnull(c_descripcion,'') c_descripcion, c_nombre_archivo, c_ruta_archivo, c_ultimousuario ,d_ultimafechamodificacion "+
                        "from  lys..co_solcapacitacioncli_doc where c_compania = '"+compania+"' and n_solicitud ="+correlativo;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            DocsCapacitacion oEnt = new DocsCapacitacion();
            oEnt.setC_compania(rs.getString(1));
            oEnt.setN_solicitud(rs.getInt(2));
            oEnt.setN_linea(rs.getInt(3));
            oEnt.setC_descripcion(rs.getString(4));
            oEnt.setC_nombre_archivo(rs.getString(5));
            oEnt.setC_ruta_archivo(rs.getString(6));
            oEnt.setC_ultimousuario(rs.getString(7));
            oEnt.setD_ultimafechamodificacion(rs.getString(8));
            LstData.add(oEnt);
        }
        return LstData;
    }
    
    
    @WebMethod(operationName = "InsertDatosAuditoria")
    public String InsertDatosAuditoria(@WebParam(name = "origen", targetNamespace = "http://SOAP/") String origen, @WebParam(name = "codIntApp", targetNamespace = "http://SOAP/") String codIntApp, @WebParam(name = "tipo", targetNamespace = "http://SOAP/") String tipo ,@WebParam(name = "imei", targetNamespace = "http://SOAP/") String imei ,@WebParam(name = "movil", targetNamespace = "http://SOAP/") String movil,@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario ,@WebParam(name = "hora", targetNamespace = "http://SOAP/") String hora,@WebParam(name = "seriechip", targetNamespace = "http://SOAP/") String seriechip ) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_INSERTAR_DATOSAUDITORIA '"+origen+"','"+codIntApp+"','"+tipo+"','"+imei+"','"+movil+"','"+usuario+"','"+hora+"','"+seriechip+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "ValidacionUsuarioIMEI")
    public String ValidacionUsuarioIMEI(@WebParam(name = "usuario", targetNamespace = "http://SOAP/") String usuario, @WebParam(name = "clave", targetNamespace = "http://SOAP/") String clave, @WebParam(name = "imei", targetNamespace = "http://SOAP/") String imei ,@WebParam(name = "numeromov", targetNamespace = "http://SOAP/") String numeromov ,@WebParam(name = "seriechip", targetNamespace = "http://SOAP/") String seriechip) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_LOGIN_ONLINE '"+usuario+"','"+clave+"','"+imei+"','"+numeromov+"','"+seriechip+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "GetListIMEIMoviles")
    public ArrayList<IMEMovil> GetListIMEIMoviles(@WebParam(name = "imei", targetNamespace = "http://SOAP/") String imei ) throws Exception {
        //TODO write your implementation code here:
        ArrayList<IMEMovil> dataIMEI = new ArrayList<IMEMovil>();
        String query = "SELECT c_imei, c_tipo, c_numero, c_usuarioreg, d_fechareg, c_estado, " +
                        " c_ultimousuario, d_ultimafechamodificacion , " +
                        " c_seriechip FROM  lys..ma_imeicelular where c_imei = '"+imei+"'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            IMEMovil m = new IMEMovil();

            m.setC_imei(rs.getString(1));
            m.setC_tipo(rs.getString(2));
            m.setC_numero(rs.getString(3));
            m.setC_usuarioreg(rs.getString(4));
            m.setD_fechareg(rs.getString(5));
            m.setC_estado(rs.getString(6));
            m.setC_ultimousuario(rs.getString(7));
            m.setD_ultimafechamodificacion(rs.getString(8));
            m.setC_seriechip(rs.getString(9));

            dataIMEI.add(m);

        }

        return dataIMEI;
    }
    
    @WebMethod(operationName = "VerificarIMEIRegistrada")
    public String VerificarIMEIRegistrada(@WebParam(name = "imei", targetNamespace = "http://SOAP/") String imei) throws Exception {
        String result = "0";
        String query = "select count(*) n_contador  from  lys..ma_imeicelular where c_imei ='"+imei+"'";
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {
            result = rs.getString(1);
        }
        return result;
    }
    
    
    @WebMethod(operationName = "InsertIMEIMovil")
    public String InsertIMEIMovil(@WebParam(name = "imei", targetNamespace = "http://SOAP/") String imei, @WebParam(name = "tipo", targetNamespace = "http://SOAP/") String tipo, @WebParam(name = "numero", targetNamespace = "http://SOAP/") String numero ,@WebParam(name = "usuarioreg", targetNamespace = "http://SOAP/") String usuarioreg ,@WebParam(name = "estado", targetNamespace = "http://SOAP/") String estado,@WebParam(name = "ultusuario", targetNamespace = "http://SOAP/") String ultusuario ,@WebParam(name = "ultfecha", targetNamespace = "http://SOAP/") String ultfecha,@WebParam(name = "seriechip", targetNamespace = "http://SOAP/") String seriechip ) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_INSERT_IMEICELULAR '"+imei+"','"+tipo+"','"+numero+"','"+usuarioreg+"','"+estado+"','"+ultusuario+"','"+ultfecha+"','"+seriechip+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
    @WebMethod(operationName = "GetListaParametrosMov")
    public ArrayList<ParametrosSist> GetListaParametrosMov( ) throws Exception {
        //TODO write your implementation code here:
        ArrayList<ParametrosSist> datalist = new ArrayList<ParametrosSist>();
        String query = "select c_compania ,c_aplicacion,c_parametrocodigo,c_descripcion,c_texto, " +
                        " c_Ultimousuario,d_Ultimafechamodificacion , n_numero ,d_fecha " +
                        " from lys..ma_parametros " +
                        "where c_aplicacion ='CO' and c_parametrocodigo in ('FMAXIMETMP','TMPSINCRON')" ;
        GetResultSet cresult = new GetResultSet();
        ResultSet rs = cresult.CreateConection(query);
        while (rs.next()) {

            ParametrosSist p = new ParametrosSist();

            p.setC_compania(rs.getString(1));
            p.setC_aplicacion(rs.getString(2));
            p.setC_parametrocodigo(rs.getString(3));
            p.setC_descripcion(rs.getString(4));
            p.setC_texto(rs.getString(5));
            p.setC_ultusuario(rs.getString(6));
            p.setC_ultfechamodificacion(rs.getString(7));
            p.setN_numero(rs.getDouble(8));
            p.setD_fecha(rs.getString(9));

            datalist.add(p);

        }

        return datalist;
    }
    
    
    @WebMethod(operationName = "InsertEventoAuditoria")
    public String InsertEventoAuditoria(@WebParam(name = "origen", targetNamespace = "http://SOAP/") String origen ,@WebParam(name = "imei", targetNamespace = "http://SOAP/") String imei  ,@WebParam(name = "numero", targetNamespace = "http://SOAP/") String numero, @WebParam(name = "seriechip", targetNamespace = "http://SOAP/") String seriechip,@WebParam(name = "hora", targetNamespace = "http://SOAP/") String hora,@WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion ) throws Exception {
        String result = "NO";
        try {
            ConectaDB cndb = new ConectaDB();
            Connection connection = cndb.getConexion();
            String SQL_INSERT = "EXEC SP_INSERTAR_EVENTO_AUDITORIA '"+origen+"','"+imei+"','"+numero+"','"+seriechip+"','"+hora+"','"+accion+"'";
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(SQL_INSERT);
            while (res.next()) {
                result = res.getString(1);
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    

}


