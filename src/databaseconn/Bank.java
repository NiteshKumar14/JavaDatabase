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

    public static void addAccount(String name) {
        Random random = new Random();
        int n = random.nextInt();
        acc.add(new BankAccount(n, 0, name));
        ncc++;

    }

    public Bank() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        
        Driver driver=(Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
        DriverManager.registerDriver(driver);
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nit777","root","");
        Statement stmt = con.createStatement();
        stmt.executeQuery("select *from account holder");
       
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public static double getTotalBalance() {
        double tb = 0;

        for (int i = 0; i < ncc; i++) {
            tb = acc.get(0).getBalance();

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
     

}
