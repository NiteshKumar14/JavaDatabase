/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconn;

import com.mysql.jdbc.Driver;
import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author c3
 */
public class Bank {

    public static ArrayList<BankAccount> acc = new ArrayList();
    public static int ncc;
   

    public static int addAccount(String name,String username,String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Random random = new Random();
        int n = random.nextInt();
        if(n<0)
            n=n*(-1);
        PreparedStatement stmt = getDbC().prepareStatement("INSERT INTO `bankaccount` (`username`, `password`, `name`, `balance`, `accountNumber`) VALUES (?,?,?,?,?)");
        stmt.setString(1,username);
        stmt.setString(2,password);
        stmt.setString(3,name);
        stmt.setDouble(4,0.0);
        stmt.setInt(5, n);
        stmt.executeUpdate();
   
       fetchDetails();
        return n;
       

    }

    public Bank() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
         getDbC();
         fetchDetails();
    }

    public static double getTotalBalance() {
        double tb = 0;

        for (int i = 0; i < ncc; i++) {
            tb += acc.get(i).getBalance();

        }
        return tb;
    }

    public static int maxBalanceAccount() {
        double min = MIN_VALUE;
        int val = ncc;
        int accno = 0;
        for (int i = 0; i < val; i++) {
            if (acc.get(i).getBalance() > min) {
                min = acc.get(i).getBalance();
                accno = acc.get(i).getAccountNumber();
            }

        }
        return accno;

    }

    public static int minBalanceAccount() {
        double max = MAX_VALUE;
        int val = ncc;
        int accno = 0;
        for (int i = 0; i < val; i++) {
            if (acc.get(i).getBalance() < max) {
                max = acc.get(i).getBalance();
                accno = acc.get(i).getAccountNumber();
            }

        }
        return accno;

    }

    public static BankAccount getAccount(int account) {
        for (int i = 0; i < ncc; i++) {
            if (acc.get(i).accountNumber == account) {
                return acc.get(i);
            }
        }
        return null;

    }

    public static int coutSBalance(int sbalance) {
        int count = 0;
        for (int i = 0; i < ncc; i++) {
            if (acc.get(i).getBalance() <= sbalance) {
                count++;
            }
        }
        return count;
    }
     public static BankAccount getAccountByName(String n) {
        for (int i = 0; i < ncc; i++) {
            if ((acc.get(i).name).equals(n)) {
                return acc.get(i);
            }
        }
        return null;

    }
    public static void fetchDetails() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
       Connection con=getDbC();
       Statement stmt=con.createStatement();
        ResultSet set=stmt.executeQuery("select *from bankaccount");
        
        while(set.next())
        {
            BankAccount temp= new BankAccount(set.getInt("accountnumber"),set.getDouble("balance"),set.getString("name"), set.getString("username"), set.getString("password"));
            acc.add(temp);
        } 
       
        
    }
    public static Connection getDbC() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException
    {
            Driver driver=(Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
        DriverManager.registerDriver(driver);
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nit777","root","");
      
        return con;
    }
    public static void  listDisplay()
    {   
        int size=acc.size();
        while(size!=0)
        {
            System.out.println("elements in arraylist : "+acc.toString());
            
        }
    }
     

}
