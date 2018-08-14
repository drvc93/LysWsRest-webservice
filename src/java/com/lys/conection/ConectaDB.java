package com.lys.conection;

import SOAP.SOAPLYS;
import com.lys.util.Propiedades;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectaDB {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url ="jdbc:sqlserver://ibserver_29;databaseName=pprodmant";
     
    public Connection getConexion() throws IOException {
        Connection cn = null;
        //Properties prop = new Properties();
        //prop.load(Propiedades.class.getResourceAsStream("configuracion.properties"));

        String TextObt = "", sUsuario = "", sPass = "", sDB = "", sServer="";
        String sNombreWeb = getNombreWebService();
        
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        
        try {
            entrada = new FileInputStream(pathF+ File.separator +"webapps"+File.separator+ sNombreWeb + File.separator+"propiedades"+File.separator+"configuracion.properties");
            propiedades.load(entrada);
            sDB= propiedades.getProperty("database");
            sServer = propiedades.getProperty("server");
            sUsuario = propiedades.getProperty("usuario");
            sPass = propiedades.getProperty("password");
            
            url ="jdbc:sqlserver://"+sServer+";databaseName="+sDB;
            //url="jdbc:sqlserver://ibserver_29;databaseName=pprodmant";             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        } catch (IOException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        }
       
        try {
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(url,sUsuario,sPass); //cambiar
            //cn = DriverManager.getConnection(url,"desarrollador2","@desit39");            
        } catch (Exception e) {
            System.out.println(e.toString());
            cn = null;
        }
        return cn;
    }
     
    public String CredencialesMail(String tipo) throws IOException {
        String TextObt = "", sUsuarioMail = "", sPassMail = "",result = "";
        String sNombreWeb = getNombreWebService();
        
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        
        try {
            entrada = new FileInputStream(pathF+ File.separator +"webapps"+File.separator+ sNombreWeb + File.separator+"propiedades"+File.separator+"configuracion.properties");
            propiedades.load(entrada);           
            sUsuarioMail = propiedades.getProperty("usuarioMail");
            sPassMail = propiedades.getProperty("claveMail");
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        } catch (IOException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        }
        
        if (tipo.equals("User")) {             
            result = sUsuarioMail;
        }else if (tipo.equals("Pass")){
            result = sPassMail;
        }
        return result;
    }
    
    public String getNombreWebService() throws UnsupportedEncodingException {
        String sNom = "";
        String path = this.getClass().getClassLoader().getResource("").getPath();
        try {
            path = URLDecoder.decode(path, "UTF-8");
            int nPosIni = path.indexOf("LysWsRest");
            int nPosTer = path.indexOf("/",nPosIni + 1);
            sNom = path.substring(nPosIni, nPosTer);

            //En caso de Falla
            nPosIni = sNom.indexOf("LysWsRest");
            if(nPosIni < 0){ sNom = "LysWsRest";}           
        }catch(Exception e){sNom = "";}
        return sNom;
    }
}
