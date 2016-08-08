/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicecom.lys.restfull;

import com.google.gson.Gson;
import com.lys.conection.ConectaDB;
import com.lys.util.Propiedades;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.server.impl.container.servlet.ServletAdaptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author gian
 */
@Path("generic")
public class InspeccionFacadeREST {

    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) throws IOException {
        String output = "Method : " + msg;

        Properties prop = new Properties();
        prop.load(Propiedades.class.getResourceAsStream("configuracion.properties"));
        System.out.println("" + prop.getProperty("urlfoto"));
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/Transferir/{id}")
    public Response Transferir(@PathParam("id") int id) throws Exception {
        Connection cn = null;
        Gson gson = new Gson();

        boolean respuesta = false;
        String valor = "";
        Map<String, String> resultData = new HashMap<String, String>();
        try {

            cn = new ConectaDB().getConexion();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery("DECLARE @Error varchar(1000); BEGIN TRY EXEC [dbo].[SP_MT_TABLE_TRANSFERENCIA] @Tipo = N'I',@Numero =" + id + ",@Mensaje=@Error OUTPUT select @Error as Resultado END TRY BEGIN CATCH  SELECT ERROR_MESSAGE() AS Resultado; END CATCH");

            if (rs.next()) {

                valor = rs.getString("Resultado");

            }

            //st.executeUpdate(s);
            st.close();

            respuesta = true;

        } catch (Exception e) {

            //respuesta = 2;
            System.out.println(e.toString());

        }
        cn.close();

        if (valor.equalsIgnoreCase("OK")) {
            
            resultData.put("status", "1");
        } else {

            resultData.put("status", "0");
        }

        resultData.put("mensaje", valor);

        String respuestajson = gson.toJson(resultData);

        return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("getUsuarios")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response GetUsuarios() throws Exception {
        Connection cn = null;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        Object[] nombres;
        Gson gson = new Gson();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM  MTP_USUARIO ");

            ResultSet rs = pt.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];

            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);

                /*   respuesta.add( new MTP_USUARIO(
                rs.getString("c_codigousuario"),
                rs.getString("c_nombre"),
                rs.getString("c_clave"),
                rs.getString("n_persona"),
                rs.getString("c_estado")
                ));*/
            }
            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if ((lista.size()) == 0) {
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay Usuarios registrado");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {
            // String respuestajason = gson.toJson(lista);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }
    }

    @GET
    @Path("getMaquinas")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response GetMaquinas() throws Exception {
        Connection cn = null;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        Object[] nombres;
        Gson gson = new Gson();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * from MTP_MAQUINAS");
            ResultSet rs = pt.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];
            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);
                /*   respuesta.add( new MTP_MAQUINAS(
                rs.getString("c_compania"),
                rs.getString("c_maquina"),
                rs.getString("c_descripcion"),
                rs.getString("c_codigobarras"),
                rs.getString("c_familiainspeccion"),
                rs.getString("c_centrocosto"),
                rs.getString("c_estado"),
                rs.getString("c_ultimousuario"),
                rs.getString("d_ultimafechamodificacion")
                ));*/
            }

            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if ((lista.size()) == 0) {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay maquians registradas");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {
            //  String respuestajason = gson.toJson(respuesta);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }
    }

    @GET
    @Path("getFamilia")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getFamilia() throws Exception {
        Connection cn = null;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        Object[] nombres;
        Gson gson = new Gson();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM dbo.MTP_FAMILIAINSPECCION");

            ResultSet rs = pt.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];
            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);

            }

            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if ((lista.size()) == 0) {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay registros");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {
            //String respuestajason = gson.toJson(respuesta);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }
    }

    @GET
    @Path("getInspeccion")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response GetInspeccion() throws Exception {
        Connection cn = null;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        Object[] nombres;
        Gson gson = new Gson();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM MTP_INSPECCION");
            ResultSet rs = pt.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];
            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);

                /* respuesta.add( new MTP_INSPECCIONMAQUINA_CAB(
                rs.getString("c_compania"),
                rs.getString("n_correlativo"),
                rs.getString("c_maquina"),
                rs.getString("c_condicionmaquina"),
                rs.getString("c_comentario"),
                rs.getString("c_estado"),
                rs.getString("d_fechaInicioInspeccion"),
                rs.getString("d_fechaFinInspeccion"),
                rs.getString("c_usuarioInspeccion"),
                rs.getString("c_usuarioenvio"),
                rs.getString("d_fechaenvio"),
                rs.getString("c_ultimousuario"),
                rs.getString("d_ultimafechamodificacion")
                ));*/

            }
            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());
            throw err;

        }
        cn.close();

        if ((lista.size()) == 0) {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay registros");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {
            //String respuestajason = gson.toJson(respuesta);
            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }
    }

    @GET
    @Path("CentroCosto")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getCentroCosto() throws Exception {
        Connection cn = null;

        Gson gson = new Gson();
        Object[] nombres;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM MTP_CENTROCOSTO  ");

            ResultSet rs = pt.executeQuery();

            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];
            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);
                /* lista.add(new MTP_PERIODOINSPECCION(
                rs.getString("c_periodoinspeccion"),
                rs.getString("c_descripcion"),
                rs.getString("c_estado"),
                rs.getString("c_ultimousuario"),
                rs.getString("d_ultimafechamodificacion")
                )
                );*/
            }

            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());
            throw err;

        }
        cn.close();

        if (lista.size() > 0) {

            //String respuestajason = gson.toJson(lista);
            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay datos para codigo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

    }

    @GET
    @Path("ProgramaMantenimiento")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getProgramaMantenimiento() throws Exception {
        Connection cn = null;

        Gson gson = new Gson();
        Object[] nombres;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        
        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM MTP_PERIODOINSPECCION  ");

            ResultSet rs = pt.executeQuery();

            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];
            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);
                /* lista.add(new MTP_PERIODOINSPECCION(
                rs.getString("c_periodoinspeccion"),
                rs.getString("c_descripcion"),
                rs.getString("c_estado"),
                rs.getString("c_ultimousuario"),
                rs.getString("d_ultimafechamodificacion")
                )
                );*/
            }

            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());
            throw err;

        }
        cn.close();

        if (lista.size() > 0) {

            //String respuestajason = gson.toJson(lista);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay datos para codigo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

    }
    
    @GET
    @Path("TipoRevisionG")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getTipoRevisionG() throws Exception {
        Connection cn = null;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        Object[] nombres;
        Gson gson = new Gson();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM  MTP_TIPOREVISIONG");

            ResultSet rs = pt.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];

            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);
            }
            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if ((lista.size()) == 0) {
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay Tipo de Revisión registrado");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {
            // String respuestajason = gson.toJson(lista);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }
    }
    
    @GET
    @Path("TipoRevisionG_Parametro")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getTipoRevisionG_Parametro() throws Exception {
        Connection cn = null;
        
        //List<Object[]> lista = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        Object[] nombres;
        Gson gson = new Gson();

        try {
            cn = new ConectaDB().getConexion();
            PreparedStatement pt = cn.prepareStatement("SELECT * FROM  MTP_TIPOREVISIONG_PARAMETRO");

            ResultSet rs = pt.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            nombres = new Object[numberOfColumns];

            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);
                    nombres[i] = metadata.getColumnName(i + 1);

                }

                lista.add(arr);
            }
            rs.close();
            pt.close();
        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if ((lista.size()) == 0) {
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay Tipo de Revisión Parametro registrado");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {
            // String respuestajason = gson.toJson(lista);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("size", String.valueOf(lista.size()));
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("data" + i, gson.toJson(lista.get(i)));

            }

            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }
    }
    
    @POST
    // @Path("consultarHistorialInspeccion/{codigo}")
    @Path("consultarHistorialProgramaInspeccion")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getHistorialInspeccion(@FormParam("maquina") String maquina, @FormParam("inicio") String inicio, @FormParam("fin") String fin, @FormParam("centro") String centro, @FormParam("tipo") String tipo, @FormParam("retorno") String retorno) throws Exception {
        Connection cn = null;

        Gson gson = new Gson();
        //List<Object[]> lista = new ArrayList();
        //List<Object[]> lista2 = new ArrayList();
        //List<Object[]> lista3 = new ArrayList();
        List<Object[]> lista = new ArrayList<Object[]>();
        List<Object[]> lista2 = new ArrayList<Object[]>();
        List<Object[]> lista3 = new ArrayList<Object[]>();

        java.sql.Timestamp fechain = java.sql.Timestamp.valueOf(inicio);

        java.sql.Timestamp fechafin = java.sql.Timestamp.valueOf(fin);

        System.out.println("maquina" + String.valueOf(maquina));
        System.out.println("fechain" + String.valueOf(fechain));
        System.out.println("fechafin" + String.valueOf(fechafin));
        System.out.println("centro" + String.valueOf(centro));
        System.out.println("tipo" + String.valueOf(tipo));

        try {
            cn = new ConectaDB().getConexion();
            //  CallableStatement st= cn.prepareCall("{ SP_MT_CARGADATOS_PEINSPECCIONES(?,?,?,?,?,1)}");

            Statement st = cn.createStatement();
            Statement st2 = cn.createStatement();
            Statement st3 = cn.createStatement();
            String s = "EXECUTE   [pprodmant].[dbo].[SP_MT_CARGADATOS_PEINSPECCIONES] '" + maquina + "','" + fechain + "','" + fechafin + "','" + centro + "','" + tipo + "',1 ";
            String s1 = "EXECUTE   [pprodmant].[dbo].[SP_MT_CARGADATOS_PEINSPECCIONES] '" + maquina + "','" + fechain + "','" + fechafin + "','" + centro + "','" + tipo + "',2 ";
            String s2 = "EXECUTE   [pprodmant].[dbo].[SP_MT_CARGADATOS_PEINSPECCIONES] '" + maquina + "','" + fechain + "','" + fechafin + "','" + centro + "','" + tipo + "',3 ";

            System.out.println("" + s);
            st.executeUpdate(s);
            st2.executeUpdate(s1);

            st3.executeUpdate(s2);

            ResultSet rs = st.getGeneratedKeys();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberOfColumns = metadata.getColumnCount();

            ResultSet rs2 = st2.getGeneratedKeys();
            ResultSetMetaData metadata2 = rs2.getMetaData();
            int numberOfColumns2 = metadata2.getColumnCount();

            ResultSet rs3 = st3.getGeneratedKeys();
            ResultSetMetaData metadata3 = rs3.getMetaData();
            int numberOfColumns3 = metadata3.getColumnCount();

            while (rs.next()) {

                Object[] arr = new Object[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {

                    arr[i] = rs.getObject(i + 1);

                }

                lista.add(arr);

            }
            while (rs2.next()) {

                Object[] arr2 = new Object[numberOfColumns2];
                for (int i = 0; i < numberOfColumns2; i++) {

                    arr2[i] = rs2.getObject(i + 1);

                }

                lista2.add(arr2);

            }
            while (rs3.next()) {

                Object[] arr3 = new Object[numberOfColumns3];
                for (int i = 0; i < numberOfColumns3; i++) {

                    arr3[i] = rs3.getObject(i + 1);

                }

                lista3.add(arr3);

            }
            //listacab.add(nombres);
            
            rs.close();
            st.close();
            rs2.close();
            st2.close();
            rs3.close();
            st3.close();

        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if (lista.size() > 0) {

            String respuestajason = gson.toJson(lista);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("sizeprimero", String.valueOf(lista.size()));
            resultData.put("sizesegundo", String.valueOf(lista2.size()));
            resultData.put("sizetercero", String.valueOf(lista3.size()));
            //  resultData.put("data", respuestajason);
            for (int i = 0; i < lista.size(); i++) {

                resultData.put("dataprimero" + i, gson.toJson(lista.get(i)));

            }
            if (lista2.size() > 0) {

                for (int i = 0; i < lista2.size(); i++) {

                    resultData.put("datasegundo" + i, gson.toJson(lista2.get(i)));

                }
            }

            if (lista3.size() > 0) {
                for (int i = 0; i < lista3.size(); i++) {

                    resultData.put("datatercero" + i, gson.toJson(lista3.get(i)));

                }
            }

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay datos para codigo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  

    }

    @POST
    @Path("registrarInspeccion")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response ModificarInspeccion(@FormParam("c_compania") String c_compania, @FormParam("n_linea") String n_linea, @FormParam("c_inspeccion") String c_inspeccion, @FormParam("c_tipoinspeccion") String c_tipoinspeccion, @FormParam("n_porcentajeminimo") String n_porcentajeminimo, @FormParam("n_porcentajemaximo") String n_porcentajemaximo, @FormParam("n_porcentajeinspeccion") String n_porcentajeinspeccion, @FormParam("c_estado") String c_estado, @FormParam("c_comentario") String c_comentario, @FormParam("c_rutafoto") String c_rutafoto, @FormParam("c_ultimousuario") String c_ultimousuario, @FormParam("d_ultimafechamodificacion") String d_ultimafechamodificacion, @FormParam("c_maquina") String c_maquina, @FormParam("c_condicionmaquina") String c_condicionmaquina, @FormParam("c_comentarioc") String c_comentarioc, @FormParam("c_estadoc") String c_estadoc, @FormParam("d_fechaInicioInspeccionc") String d_fechaInicioInspeccionc, @FormParam("d_fechaFinInspeccionc") String d_fechaFinInspeccionc, @FormParam("c_usuarioInspeccionc") String c_usuarioInspeccionc, @FormParam("c_usuarioenvioc") String c_usuarioenvioc, @FormParam("d_fechaenvioc") String d_fechaenvioc, @FormParam("c_ultimousuarioc") String c_ultimousuarioc, @FormParam("d_ultimafechamodificacionc") String d_ultimafechamodificacionc, @FormParam("c_usuarioInspeccion") String c_usuarioInspeccion, @FormParam("c_periodoinspeccion") String c_periodoinspeccion) throws Exception {
        Connection cn = null;
        Boolean respuesta = false;
        Gson gson = new Gson();

        java.sql.Timestamp finspeccion = java.sql.Timestamp.valueOf(d_ultimafechamodificacion);//d_fechaInicioInspeccion

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp fecha = new java.sql.Timestamp(now.getTime());

        //select max tabla cab

        //select max tabla det


        //insert max+1 tabla cab

        //insert max+1 tabla det
        int id = 0;

        try {
            cn = new ConectaDB().getConexion();

            PreparedStatement pt = cn.prepareStatement("SELECT TOP 1 n_correlativo from MTP_INSPECCIONMAQUINA_CAB ORDER BY n_correlativo DESC");
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {

                String va = rs.getString("n_correlativo");
                id = Integer.parseInt(va) + 1;
            } else {
                id = 1;
            }
            //listacab.add(nombres);

            System.out.println(String.valueOf(id));
            rs.close();
            pt.close();

            java.sql.Timestamp fin = java.sql.Timestamp.valueOf(d_fechaInicioInspeccionc);//d_fechaInicioInspeccion
            java.sql.Timestamp ffin = java.sql.Timestamp.valueOf(d_fechaFinInspeccionc);//d_fechaInicioInspeccion
            java.sql.Timestamp fenv = java.sql.Timestamp.valueOf(d_fechaenvioc);//d_fechaInicioInspeccion
            java.sql.Timestamp fmod = java.sql.Timestamp.valueOf(d_ultimafechamodificacionc);//d_fechaInicioInspeccion

            PreparedStatement ptc = cn.prepareStatement("INSERT INTO  MTP_INSPECCIONMAQUINA_CAB (c_compania,n_correlativo,c_maquina,c_condicionmaquina,c_comentario,c_estado,d_fechaInicioInspeccion,d_fechaFinInspeccion,c_periodoinspeccion,c_usuarioInspeccion,c_usuarioenvio,d_fechaenvio,c_ultimousuario,d_ultimafechamodificacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

            ptc.setString(1, c_compania);
            ptc.setInt(2, id);

            ptc.setString(3, c_maquina);
            ptc.setString(4, c_condicionmaquina);
            ptc.setString(5, c_comentarioc);
            ptc.setString(6, c_estadoc);
            ptc.setTimestamp(7, fin);
            ptc.setTimestamp(8, ffin);
            ptc.setString(9, c_periodoinspeccion);
            ptc.setString(10, c_usuarioInspeccionc);
            ptc.setString(11, c_usuarioenvioc);
            ptc.setTimestamp(12, fenv);
            ptc.setString(13, c_ultimousuarioc);
            ptc.setTimestamp(14, fmod);

            ptc.execute();

            respuesta = true;
            // rs.close();

            ptc.close();
        } catch (Exception err) {

            respuesta = false;
            System.out.println(err.toString());

            //return Response.serverError().entity("UUID cannot be blank").build();

            throw err;

        }
        cn.close();

        if (respuesta) {
            
            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("mensaje", String.valueOf(id));

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No Actualizo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  

    }

    @POST
    @Path("registrarInspeccionDetalle")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response ModificarInspeccionDetalle(@FormParam("idcabecera") String id, @FormParam("c_compania") String c_compania, @FormParam("n_linea") String n_linea, @FormParam("c_inspeccion") String c_inspeccion, @FormParam("c_tipoinspeccion") String c_tipoinspeccion, @FormParam("n_porcentajeminimo") String n_porcentajeminimo, @FormParam("n_porcentajemaximo") String n_porcentajemaximo, @FormParam("n_porcentajeinspeccion") String n_porcentajeinspeccion, @FormParam("c_estado") String c_estado, @FormParam("c_comentario") String c_comentario, @FormParam("c_rutafoto") String c_rutafoto, @FormParam("c_ultimousuario") String c_ultimousuario, @FormParam("d_ultimafechamodificacion") String d_ultimafechamodificacion, @FormParam("c_maquina") String c_maquina, @FormParam("c_condicionmaquina") String c_condicionmaquina, @FormParam("c_comentarioc") String c_comentarioc, @FormParam("c_estadoc") String c_estadoc, @FormParam("d_fechaInicioInspeccionc") String d_fechaInicioInspeccionc, @FormParam("d_fechaFinInspeccionc") String d_fechaFinInspeccionc, @FormParam("c_usuarioInspeccionc") String c_usuarioInspeccionc, @FormParam("c_usuarioenvioc") String c_usuarioenvioc, @FormParam("d_fechaenvioc") String d_fechaenvioc, @FormParam("c_ultimousuarioc") String c_ultimousuarioc, @FormParam("d_ultimafechamodificacionc") String d_ultimafechamodificacionc, @FormParam("c_usuarioInspeccion") String c_usuarioInspeccion) throws Exception {
        Connection cn = null;
        Boolean respuesta = false;
        Gson gson = new Gson();

        java.sql.Timestamp finspeccion = java.sql.Timestamp.valueOf(d_ultimafechamodificacion);//d_fechaInicioInspeccion

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp fecha = new java.sql.Timestamp(now.getTime());
        PreparedStatement ptd;

        try {
            cn = new ConectaDB().getConexion();
            System.out.println("c  = " + n_porcentajeinspeccion);
            if (n_porcentajeinspeccion.length() == 0 || n_porcentajeinspeccion == null) {

                ptd = cn.prepareStatement("INSERT INTO  MTP_INSPECCIONMAQUINA_DET (c_compania,n_correlativo,n_linea,c_inspeccion,c_tipoinspeccion,n_porcentajeminimo,n_porcentajemaximo,c_estado,c_comentario, c_rutafoto,c_ultimousuario,d_ultimafechamodificacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ");

            } 
            else {

                ptd = cn.prepareStatement("INSERT INTO  MTP_INSPECCIONMAQUINA_DET (c_compania,n_correlativo,n_linea,c_inspeccion,c_tipoinspeccion,n_porcentajeminimo,n_porcentajemaximo,n_porcentajeinspeccion,c_estado,c_comentario, c_rutafoto,c_ultimousuario,d_ultimafechamodificacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ");

            }

            ptd.setString(1, c_compania);
            ptd.setInt(2, Integer.parseInt(id));
            ptd.setString(3, n_linea);
            //ptd.setInt(4, Integer.parseInt(c_inspeccion));
            ptd.setString(4, c_inspeccion);
            ptd.setString(5, c_tipoinspeccion);
            ptd.setDouble(6, Double.parseDouble(n_porcentajeminimo));
            ptd.setDouble(7, Double.parseDouble(n_porcentajemaximo));

            if (n_porcentajeinspeccion.length() == 0 || n_porcentajeinspeccion == null) {

                ptd.setString(8, c_estado);
                ptd.setString(9, c_comentario);
                ptd.setString(10, c_rutafoto);
                ptd.setString(11, c_ultimousuario);
                ptd.setTimestamp(12, finspeccion);

            } else {
                ptd.setDouble(8, Double.parseDouble(n_porcentajeinspeccion));
                ptd.setString(9, c_estado);
                ptd.setString(10, c_comentario);
                ptd.setString(11, c_rutafoto);
                ptd.setString(12, c_ultimousuario);
                ptd.setTimestamp(13, finspeccion);

            }
            //ptd.setDouble(6, Double.parseDouble(n_porcentajeminimo));
            //  ptd.setDouble(7, Double.parseDouble(n_porcentajemaximo));
            // ptd.setDouble(8, Double.parseDouble(n_porcentajeinspeccion));

            ptd.execute();

            respuesta = true;
            // rs.close();
            ptd.close();

        } catch (Exception err) {

            respuesta = false;
            System.out.println(err.toString());

            //return Response.serverError().entity("UUID cannot be blank").build();

            throw err;

        }

        cn.close();

        if (respuesta) {

            Map<String, String> resultData = new HashMap<String, String>();
            // Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("mensaje", String.valueOf(id));

            //return respuestajason;

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No Actualizo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  

    }
    //SELECT DetallePrograma.idDetallePrograma,DetallePrograma.Detalle, DetallePrograma.Systema, DetallePrograma.FechaHoraPrograma, DetallePrograma.Fecha, DetallePrograma.idPrograma, Programa.Periocidad, Programa.CodMaquina FROM DetallePrograma INNER JOIN Programa ON DetallePrograma.idPrograma = Programa.idPrograma where  Programa.CodMaquina='0099'

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("file") InputStream fileInputStream, @FormDataParam("file") FormDataContentDisposition contentDispositionHeader) throws Exception {
        {

            Calendar calendar = Calendar.getInstance();
            java.util.Date now = calendar.getTime();
            java.sql.Timestamp fecha = new java.sql.Timestamp(now.getTime());
            String fec = String.valueOf(fecha);
            fec = fec.replace(" ", "_");
            fec = fec.replace(":", "-");
            fec  = fec.substring(0,10);
            System.out.println("" + fec);

           /* Properties prop = new Properties();
            prop.load(Propiedades.class.getResourceAsStream("configuracion.properties"));
            System.out.println("" + prop.getProperty("urlfoto"));*/

            //String path = prop.getProperty("urlfoto") + contentDispositionHeader.getFileName() + ".jpg";
            String path = File.separator+File.separator+"IBSERVER_1"+File.separator+"Servidor de Archivos"+File.separator+"Fotos_Tablet"+File.separator + contentDispositionHeader.getFileName()+ ".jpg";
            GuardarFile(fileInputStream, path);
            String ruta = "Guardado en la siguiente ubicacion : " + path;

            //aca tiene que hacer el upload segun c_lina c_inspeccion y n_correlativo 

            return Response.status(200).entity(ruta).build();

        }
    }

    @POST
    @Path("modificarFoto")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response modificarFoto(@FormParam("correlativo") String correlativo, @FormParam("linea") String linea, @FormParam("foto") String foto) throws Exception {
        Connection cn = null;
        Boolean respuesta = false;
        Gson gson = new Gson();
        String path = "";

        System.out.println("linea" + linea);

        System.out.println("correlativo" + correlativo);

        try {
            cn = new ConectaDB().getConexion();

            //   System.out.println("" + prop.getProperty("urlfoto"));

            PreparedStatement ptc = cn.prepareStatement("UPDATE  MTP_INSPECCIONMAQUINA_DET SET c_rutafoto=? WHERE n_correlativo=? AND n_linea=?");
            path = foto ;
            ptc.setString(1, path);
            ptc.setString(2, correlativo);
            ptc.setString(3, linea);

            ptc.execute();

            respuesta = true;
            // rs.close();

            ptc.close();
        } catch (Exception err) {

            respuesta = false;
            System.out.println(err.toString());

            //return Response.serverError().entity("UUID cannot be blank").build();

            throw err;

        }
        cn.close();

        if (respuesta) {

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("mensaje", correlativo);
            resultData.put("path", path);

            System.out.println(path);

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No Actualizo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  

    }

    public void GuardarFile(InputStream uploadedInputStream,
            String serverLocation) {

        try {

            OutputStream outpuStream = new FileOutputStream(new File(serverLocation));

            int read = 0;
            byte[] bytes = new byte[1024];
            outpuStream = new FileOutputStream(new File(serverLocation));

            while ((read = uploadedInputStream.read(bytes)) != -1) {

                outpuStream.write(bytes, 0, read);

            }

            outpuStream.flush();
            outpuStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    @GET
    @Path("/verfoto/{foto}")
 
    public void VerFoto( @Context HttpServletResponse response,@PathParam("foto") String foto) throws Exception {
         {
             
         //HttpServletResponse response = context.getHttpServletResponse();

          //tring fileName = request.getParameter("image");   
        //try {
       
            
            response.setContentType("image/jpeg");  
        ServletOutputStream out;  
        out = response.getOutputStream();  
        
       /*Properties prop = new Properties();
        prop.load(Propiedades.class.getResourceAsStream("configuracion.properties"));
      */ 
        //System.out.println("" + prop.getProperty("urlfoto"));
            
            //AAA-0120120150420100057
        //FileInputStream fin = new FileInputStream(prop.getProperty("urlfoto")+foto+".jpg"); \\\\IBSERVER_1\\Servidor de Archivos\\Fotos_Tablet\\
        FileInputStream fin = new FileInputStream(File.separator+File.separator+"IBSERVER_1"+File.separator+"Servidor de Archivos"+File.separator+"Fotos_Tablet"+File.separator + foto + ".jpg");

        BufferedInputStream bin = new BufferedInputStream(fin);  
        BufferedOutputStream bout = new BufferedOutputStream(out);  
        int ch =0; ;  
        while((ch=bin.read())!=-1)  
        {  
        bout.write(ch);  
        }  
          bin.close();  
        fin.close();  
        bout.close();  
        out.close();  

      /*  }  catch(Exception e){
            
           e.printStackTrace();
            
        }*/
      
          
        } 

        
    }
    
    @POST
    @Path("registrarInspeccionG")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response ModificarInspeccionG(@FormParam("c_compania") String c_compania, @FormParam("c_tipoinspeccion") String c_tipoinspeccion, @FormParam("c_maquina") String c_maquina, @FormParam("c_centrocosto") String c_centrocosto, @FormParam("c_comentario") String c_comentario, @FormParam("c_usuarioinspeccion") String c_usuarioinspeccion, @FormParam("d_fechainspeccion") String d_fechainspeccion, @FormParam("c_estado") String c_estado, @FormParam("c_usuarioenvio") String c_usuarioenvio, @FormParam("d_fechaenvio") String d_fechaenvio, @FormParam("c_ultimousuario") String c_ultimousuario, @FormParam("d_ultimafechamodificacion") String d_ultimafechamodificacion) throws Exception {
        Connection cn = null;
        Boolean respuesta = false;
        Gson gson = new Gson();

        java.sql.Timestamp finspeccion = java.sql.Timestamp.valueOf(d_ultimafechamodificacion);//d_fechaInicioInspeccion

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp fecha = new java.sql.Timestamp(now.getTime());

        //select max tabla cab

        //select max tabla det


        //insert max+1 tabla cab

        //insert max+1 tabla det
        int id = 0;

        try {
            cn = new ConectaDB().getConexion();

            PreparedStatement pt = cn.prepareStatement("SELECT TOP 1 n_correlativo from MTP_INSPECCIONGENERAL_CAB ORDER BY n_correlativo DESC");
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {

                String va = rs.getString("n_correlativo");
                id = Integer.parseInt(va) + 1;
            } else {
                id = 1;
            }
            //listacab.add(nombres);

            System.out.println(String.valueOf(id));
            rs.close();
            pt.close();

            java.sql.Timestamp fin = java.sql.Timestamp.valueOf(d_fechainspeccion);//d_fechaInspeccion
            java.sql.Timestamp fenv = java.sql.Timestamp.valueOf(d_fechaenvio);//d_fechaEnvio
            java.sql.Timestamp fmod = java.sql.Timestamp.valueOf(d_ultimafechamodificacion);//d_fechaUltimaFechaModificacion

            PreparedStatement ptc = cn.prepareStatement("INSERT INTO MTP_INSPECCIONGENERAL_CAB (c_compania,n_correlativo,c_tipoinspeccion,c_maquina,c_centrocosto,c_comentario,c_usuarioinspeccion,d_fechainspeccion,c_estado,c_usuarioenvio,d_fechaenvio,c_ultimousuario,d_ultimafechamodificacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ");

            ptc.setString(1, c_compania);
            ptc.setInt(2, id);

            ptc.setString(3, c_tipoinspeccion);
            ptc.setString(4, c_maquina);
            ptc.setString(5, c_centrocosto);
            ptc.setString(6, c_comentario);
            ptc.setString(7, c_usuarioinspeccion);
            ptc.setTimestamp(8, fin);
            ptc.setString(9, c_estado);
            ptc.setString(10, c_usuarioenvio);
            ptc.setTimestamp(11, fenv);
            ptc.setString(12, c_ultimousuario);
            ptc.setTimestamp(13, fmod);

            ptc.execute();

            respuesta = true;
            // rs.close();

            ptc.close();
        } catch (Exception err) {

            respuesta = false;
            System.out.println(err.toString());

            //return Response.serverError().entity("UUID cannot be blank").build();

            throw err;

        }
        cn.close();
        
        //respuesta = true;
        
        if (respuesta) {

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("mensaje", String.valueOf(id));

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No Actualizo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  
    }
    
    @POST
    @Path("registrarInspeccionDetalleG")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response ModificarInspeccionDetalleG(@FormParam("idcabecera") String id, @FormParam("c_compania") String c_compania, @FormParam("n_linea") String n_linea, @FormParam("c_comentario") String c_comentario, @FormParam("c_rutafoto") String c_rutafoto, @FormParam("c_ultimousuario") String c_ultimousuario, @FormParam("d_ultimafechamodificacion") String d_ultimafechamodificacion,
           @FormParam("c_tiporevisiong") String c_tiporevisiong,@FormParam("c_flagadictipo") String c_flagadictipo) throws Exception {
        Connection cn = null;
        Boolean respuesta = false;
        Gson gson = new Gson();

        java.sql.Timestamp finspeccion = java.sql.Timestamp.valueOf(d_ultimafechamodificacion);//d_fechaInicioInspeccion

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp fecha = new java.sql.Timestamp(now.getTime());
        PreparedStatement ptd;

        try {
            cn = new ConectaDB().getConexion();
            
            ptd = cn.prepareStatement("INSERT INTO MTP_INSPECCIONGENERAL_DET (c_compania, n_correlativo, n_linea, c_comentario, c_rutafoto, c_ultimousuario, d_ultimafechamodificacion,c_tiporevisiong,c_flagadictipo) VALUES(?,?,?,?,?,?,?,?,?) ");

            ptd.setString(1, c_compania);
            ptd.setInt(2, Integer.parseInt(id));
            ptd.setInt(3, Integer.parseInt(n_linea));
            ptd.setString(4, c_comentario);
            ptd.setString(5, c_rutafoto);
            ptd.setString(6, c_ultimousuario);
            ptd.setTimestamp(7, finspeccion);
            ptd.setString(8, c_tiporevisiong);
            ptd.setString(9, c_flagadictipo);

            ptd.execute();

            respuesta = true;
            // rs.close();
            ptd.close();

        } catch (Exception err) {

            respuesta = false;
            System.out.println(err.toString());

            //return Response.serverError().entity("UUID cannot be blank").build();
            
            throw err;
            
        }

        cn.close();

        if (respuesta) {
            
            Map<String, String> resultData = new HashMap<String, String>();
            // Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("mensaje", String.valueOf(id));
            
            //return respuestajason;
            
            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();
            
        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No Actualizo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  

    }
    
    @GET
    @Path("/Transferir2/{id}")
    public Response Transferir2(@PathParam("id") int id) throws Exception {
        Connection cn = null;
        Gson gson = new Gson();

        boolean respuesta = false;
        String valor = "";
        Map<String, String> resultData = new HashMap<String, String>();
        try {

            cn = new ConectaDB().getConexion();
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery("DECLARE @Error varchar(1000); BEGIN TRY EXEC [dbo].[SP_MT_TABLE_TRANSFERENCIA] @Tipo = N'G',@Numero =" + id + ",@Mensaje=@Error OUTPUT select @Error as Resultado END TRY BEGIN CATCH  SELECT ERROR_MESSAGE() AS Resultado; END CATCH");

            if (rs.next()) {

                valor = rs.getString("Resultado");

            }

            //st.executeUpdate(s);
            st.close();

            respuesta = true;

        } catch (Exception e) {

            //respuesta = 2;
            System.out.println(e.toString());

        }
        cn.close();

        if (valor.equalsIgnoreCase("OK")) {
            
            resultData.put("status", "1");
        } else {

            resultData.put("status", "0");
        }

        resultData.put("mensaje", valor);

        String respuestajson = gson.toJson(resultData);

        return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();
    }
    
    @POST
    @Path("consultarHistorialInspeccionG")
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED})
    public Response getHistorialInspeccionG(@FormParam("tipo") String tipo, @FormParam("inicio") String inicio, @FormParam("fin") String fin, @FormParam("retorno") String retorno) throws Exception {
        Connection cn = null;

        Gson gson = new Gson();
        //List<Object[]> lista1 = new ArrayList();
        //List<Object[]> lista2 = new ArrayList();
        List<Object[]> lista1 = new ArrayList<Object[]>();
        List<Object[]> lista2 = new ArrayList<Object[]>();

        java.sql.Timestamp fechain = java.sql.Timestamp.valueOf(inicio);

        java.sql.Timestamp fechafin = java.sql.Timestamp.valueOf(fin);

        System.out.println("tipo" + String.valueOf(tipo));
        System.out.println("fechain" + String.valueOf(fechain));
        System.out.println("fechafin" + String.valueOf(fechafin));

        try {
            cn = new ConectaDB().getConexion();
            //  CallableStatement st= cn.prepareCall("{ SP_MT_CARGADATOS_PEINSPECCIONES(?,?,?,?,?,1)}");

            Statement st1 = cn.createStatement();
            Statement st2 = cn.createStatement();
            String s1 = "EXECUTE   [pprodmant].[dbo].[SP_MT_CARGADATOS_INSPGENERAL] '" + tipo + "','" + fechain + "','" + fechafin + "',1 ";
            String s2 = "EXECUTE   [pprodmant].[dbo].[SP_MT_CARGADATOS_INSPGENERAL] '" + tipo + "','" + fechain + "','" + fechafin + "',2 ";

            System.out.println("" + s1);
            st1.executeUpdate(s1);
            st2.executeUpdate(s2);

            ResultSet rs1 = st1.getGeneratedKeys();
            ResultSetMetaData metadata = rs1.getMetaData();
            int numberOfColumns1 = metadata.getColumnCount();

            ResultSet rs2 = st2.getGeneratedKeys();
            ResultSetMetaData metadata2 = rs2.getMetaData();
            int numberOfColumns2 = metadata2.getColumnCount();

            while (rs1.next()) {

                Object[] arr1 = new Object[numberOfColumns1];
                for (int i = 0; i < numberOfColumns1; i++) {

                    arr1[i] = rs1.getObject(i + 1);

                }

                lista1.add(arr1);

            }
            while (rs2.next()) {

                Object[] arr2 = new Object[numberOfColumns2];
                for (int i = 0; i < numberOfColumns2; i++) {

                    arr2[i] = rs2.getObject(i + 1);

                }

                lista2.add(arr2);

            }
            //listacab.add(nombres);
            
            rs1.close();
            st1.close();
            rs2.close();
            st2.close();

        } catch (Exception err) {

            System.out.println(err.toString());

            throw err;

        }
        cn.close();

        if (lista1.size() > 0) {

            String respuestajason = gson.toJson(lista1);

            //return respuestajason;
            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "1");
            resultData.put("sizeprimero", String.valueOf(lista1.size()));
            resultData.put("sizesegundo", String.valueOf(lista2.size()));
            //  resultData.put("data", respuestajason);
            for (int i = 0; i < lista1.size(); i++) {

                resultData.put("dataprimero" + i, gson.toJson(lista1.get(i)));

            }
            if (lista2.size() > 0) {

                for (int i = 0; i < lista2.size(); i++) {

                    resultData.put("datasegundo" + i, gson.toJson(lista2.get(i)));

                }
            }

            String respuestajson = gson.toJson(resultData);
            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        } else {

            Map<String, String> resultData = new HashMap<String, String>();
            resultData.put("status", "0");
            resultData.put("mensaje", "No hay datos para codigo");
            String respuestajson = gson.toJson(resultData);

            return Response.ok(respuestajson, MediaType.APPLICATION_JSON).build();

        }

        // return Response.serverError().entity("UUID cannot be blank").build();  

    }
    
}