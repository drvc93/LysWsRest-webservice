/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lys.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dvillanueva
 */
public class GetResultSet {

    public String ExecProcedure(String procedureName) throws java.lang.Exception {
        String resul ="";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://ibserver_29;user=desarrollador2;password=@desit39;database=pprodmant");
        //System.out.println("test");
        try {
        Statement sta = conn.createStatement();

        PreparedStatement ps = conn.prepareStatement(procedureName);
        ps.setEscapeProcessing(true);
        ps.setQueryTimeout(90);

        ResultSet rs = ps.executeQuery();
        resul = "ok";
        }
        catch(Exception e){
        resul=e.getMessage();
        
        }
        
        return resul;
    }

    public ResultSet CreateConection(String query) throws java.lang.Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://ibserver_29;user=desarrollador2;password=@desit39;database=pprodmant");
        //System.out.println("test");
        Statement sta = conn.createStatement();

        ResultSet rs = sta.executeQuery(query);
        return rs;
    }

    public ResultSet CreateConectionBDLys(String query) throws java.lang.Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://ibserver_29;user=desarrollador2;password=@desit39;database=lys");
        //System.out.println("test");
        Statement sta = conn.createStatement();

        ResultSet rs = sta.executeQuery(query);
        return rs;
    }

    public PreparedStatement StamenteForSP(String query) throws java.lang.Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://ibserver_29;user=desarrollador2;password=@desit39;database=pprodmant");
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setEscapeProcessing(true);
        ps.setQueryTimeout(90);//System.out.println("test");

        return ps;

    }

    public GetResultSet() {
    }
;
}
