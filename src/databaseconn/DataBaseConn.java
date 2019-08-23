/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author c3
 */
public class DataBaseConn {

    /**
     * @param args the command line arguments
     */
   public static Statement getStatement() throws ClassNotFoundException{

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nit777", "root", ""); Statement stmt = con.createStatement(); ) {
            return stmt;
            }
        
    catch (Exception e) {
        }
       return null;
    

}
}
