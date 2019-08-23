/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconn;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author c3
 */
public class DataBaseConn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException {

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nit777", "root", ""); Statement stmt = con.createStatement(); ResultSet rset = stmt.executeQuery("select *from student")) {
            while (rset.next()) {
                System.out.print(rset.getInt(4) + "\t");
                System.out.print(rset.getString("NAME") + "\t");
                System.out.println(rset.getString("address"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
