/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lys.conection;

import com.lys.util.Propiedades;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Laptop
 */
public class ConectaDB {

    /*
     * private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
     * private String url =
     * "jdbc:sqlserver://ibserver_29;databaseName=pprodmant"; private String
     * usuario = "desarrollador"; private String password = "@sist@8";
     */
    public Connection getConexion() throws IOException {
        Connection cn = null;
       // Properties prop = new Properties();
        //prop.load(Propiedades.class.getResourceAsStream("configuracion.properties"));


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
       cn = DriverManager.getConnection("jdbc:sqlserver://ibserver_29;user=desarrollador2;password=@desit39;database=pprodmant");
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
}
