/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP;

import com.lys.beans.AccesosDB;
import com.lys.beans.CentroCostoDB;
import com.lys.beans.CorreoApReqLog;
import com.lys.beans.CorreoUsuarioCCosto;
import com.lys.beans.EmpAsigSolicitud;
import com.lys.beans.EmpleadoMant;
import com.lys.beans.HistorialInspGen;
import com.lys.beans.HistorialInspMaq;
import com.lys.beans.Inspecciones;
import com.lys.beans.InspeccionesGenCab;
import com.lys.beans.InspeccionesGenDet;
import com.lys.beans.InspeccionesMaqCab;
import com.lys.beans.InspeccionesMaqDet;
import com.lys.beans.Maquina;
import com.lys.beans.Menu;
import com.lys.beans.MenuDB;
import com.lys.beans.Parametros;
import com.lys.beans.PeriodoInspeccionDB;
import com.lys.beans.Rechazos;
import com.lys.beans.RequisicionLogCab;
import com.lys.beans.RequisicionLogDet;
import com.lys.beans.SolicitudServicio;
import com.lys.beans.SubMenu;
import com.lys.beans.SubMenuBotones;
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
    public List<AccesosDB> GetDataAccesos() throws Exception {
        //TODO write your implementation code here:
        List<AccesosDB> dataAcceso = new ArrayList<AccesosDB>();
        String query = "SELECT * FROM  dbo.MTP_ACCESO";
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
        //  String query = "EXEC dbo.SPI_INSPECCION_MAQ_CABECERA @compania = '"+compania+"' ,  @maquina = '"+maquina+"',  @condicionMaquina = '"+condicionMaquina+"',  @comentario = '"+comentario+"',  @estado = '"+estado+"', @fechaInicioInp = '"+fechaIniInsp+"',   @fechaFinInsp = '"+fechaFinInsp+"',  @periodoInsp = '"+periodoInsp+"', @usuarioInsp = '"+usuarioInsp+"',  @usuarioEnvio = '"+usuaruioEnv+"',  @ultUsuario = '"+ultimoUsuario+"' ";
        // GetResultSet cresult = new GetResultSet();
        // ResultSet rs = cresult.CreateConection(query);

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCorrelativo")
    public String GetCorrelativo() throws Exception {
        String result = "0";
        String query = "SELECT n_ultimocorrelativo FROM  dbo.ma_Correlativos ";
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
    public ArrayList<HistorialInspGen> GetHistorialInspGen(@WebParam(name = "accion", targetNamespace = "http://SOAP/") String accion, @WebParam(name = "tipoInsp", targetNamespace = "http://SOAP/") String tipoInsp, @WebParam(name = "FInicio", targetNamespace = "http://SOAP/") String FInicio, @WebParam(name = "FFin", targetNamespace = "http://SOAP/") String FFin) throws Exception {
        ArrayList<HistorialInspGen> result = new ArrayList<HistorialInspGen>();
        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_CONSULTAS_LINEA_INSP_GEN ?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, accion);
        statement.setString(2, tipoInsp);
        statement.setString(3, FInicio);
        statement.setString(4, FFin);
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
            @WebParam(name = "personasolicit", targetNamespace = "http://SOAP/") String personasolicit) throws Exception {
        ArrayList<SolicitudServicio> result = new ArrayList<SolicitudServicio>();
        /*ConectaDB cndb = new ConectaDB();
        Connection connection =  connection = cndb.getConexion();*/

        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_MT_LISTA_SOLIC_SERVIC_MOVIL ?,?,?,?,?,?,?,?";
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
            @WebParam(name = "fechainicio", targetNamespace = "http://SOAP/") String fechainicio, @WebParam(name = "fechafin", targetNamespace = "http://SOAP/") String fechafin) throws Exception {
        ArrayList<RequisicionLogCab> result = new ArrayList<RequisicionLogCab>();

        ConectaDB cndb = new ConectaDB();
        Connection connection = cndb.getConexion();
        String SQL_INSERT = "EXEC SP_MT_LISTA_REQUISICIONES ?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);

        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, compania);
        statement.setString(2, ccosto);
        statement.setString(3, estado);
        statement.setString(4, fechainicio);
        statement.setString(5, fechafin);

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
            r.setC_estado(res.getString(13));
            r.setC_estadonomb(res.getString(14));

            result.add(r);
        }

        return result;
    }

    @WebMethod(operationName = "GetDetalleReqLog")
    public ArrayList<RequisicionLogDet> GetDetalleReqLog(@WebParam(name = "compania", targetNamespace = "http://SOAP/") String compania, @WebParam(name = "numeroreq", targetNamespace = "http://SOAP/") String numeroreq) throws Exception {
        //TODO write your implementation code here:
        ArrayList<RequisicionLogDet> result = new ArrayList<RequisicionLogDet>();
        //int val_correlativo = Integer.valueOf(correlativo);
        String query = "SELECT     c_Compania , c_item , c_descripcion , n_cantidadpedida , n_stockdisponible,n_stockminimo   "
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
         // Recipient's email ID needs to be mentioned.
     // String to = "abcd@gmail.com";
      // Sender's email ID needs to be mentioned
      String from = "sistemas@filtroslys.com.pe";
      // Assuming you are sending email from localhost
      String host = "smtp.office365.com";
      // Get system properties
      Properties properties = System.getProperties();
      // Setup mail server
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
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
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
         // Set Subject: header field
         message.setSubject(msjSubject);

         // Send the actual HTML message, as big as you like
        
          if (ListCorreoMsj.size()>0) {
               message.setContent(ListCorreoMsj.get(0).getC_mensajeHtml(), "text/html");
          }
        
         
         // Send message
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

}
