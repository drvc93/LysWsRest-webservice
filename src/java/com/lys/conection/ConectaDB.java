/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lys.conection;

import SOAP.SOAPLYS;
import com.lys.util.Propiedades;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class ConectaDB {

    
     private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
      private String url ="jdbc:sqlserver://ibserver_29;databaseName=pprodmant";
     // private String  usuario = "desarrollador";
      ///private String password = "@sist@8";
     
     public Connection getConexion() throws IOException {
        Connection cn = null;
       // Properties prop = new Properties();
        //prop.load(Propiedades.class.getResourceAsStream("configuracion.properties"));

        String TextObt = "" ,  sUsuario  = "" , sPass = "" , sStringConect = "" , sDB = "" , sServer="" ; 
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        
        try {
            entrada = new FileInputStream(pathF+ File.separator +"webapps"+File.separator+"LysWsRest"+ File.separator+"propiedades"+File.separator+"configuracion.properties");
            propiedades.load(entrada);
            sDB= propiedades.getProperty("database");
            sServer = propiedades.getProperty("server");
            sUsuario = propiedades.getProperty("usuario");
            sPass = propiedades.getProperty("password");
            
            url ="jdbc:sqlserver://"+sServer+";databaseName="+sDB; // cambiar
          //  url="jdbc:sqlserver://ibserver_29;databaseName=pprodmant";
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        } catch (IOException ex) {
            Logger.getLogger(SOAPLYS.class.getName()).log(Level.SEVERE, null, ex);
            TextObt = ex.getMessage();
        }
       

        try {
          Class.forName(driver).newInstance();
        //   cn = DriverManager.getConnection(url,sUsuario,sPass); // cambiar
           cn = DriverManager.getConnection(url,"desarrollador2","@desit39");
        //System.out.println("test");
        } catch (SQLException e) {
            System.out.println(e.toString());
            cn = null;
        } catch (Exception e) {
            System.out.println(e.toString());
            cn = null;
        }

        return cn;
    }
     
     public String CredencialesMail(String tipo) throws IOException {
         String result = "";
       
        String TextObt = "" ,  sUsuarioMail  = "" , sPassMail = "" , sStringConect = "" , sDB = "" , sServer="" ; 
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Path currentRelativePath = Paths.get("");
        String pathF = currentRelativePath.toAbsolutePath().toString();
        
        try {
            entrada = new FileInputStream(pathF+ File.separator +"webapps"+File.separator+"LysWsRest"+ File.separator+"propiedades"+File.separator+"configuracion.properties");
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
         }
         else if (tipo.equals("Pass")) {
             
             result = sPassMail;
         }
        return result;
    }
     
}
