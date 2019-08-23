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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author c3
 */
public class UserLogin extends javax.swing.JFrame {
 Connection con;
 Statement stmt;
    
  
    public UserLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException  {
      Driver driver =(Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nit777","root","");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        createAccount = new javax.swing.JButton();
        login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setText("jPasswordField1");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 250, 40));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 250, 40));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("USER LOGIN ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 400, 40));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("DEVELOPMENT BANK OF INDIA ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 520, 60));

        jLabel3.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("USERNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 220, 40));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 0));
        jLabel4.setText("PASSWORD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 200, 40));

        createAccount.setText("CREATE ACCOUNT ");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        getContentPane().add(createAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 550, 290, 50));

        login.setText("LOGIN ");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 170, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
      String user=username.getText();
      String pwd=password.getText();
      String u,p;
      boolean attempt=true;
     
      
          
            try {
                
                   
                    String query="select username ,password from accountholder where password = '"+pwd+"' and username = '"+user+"'";
                  
                     stmt = con.createStatement();

                    ResultSet set;
                     set = stmt.executeQuery(query);
                    
                    
                    if(set.next())
                    {   JOptionPane.showMessageDialog(this,"Login SucessFully");
                        DBI d=new DBI(this,stmt);
                        d.setVisible(true);
                        this.setVisible(false);
                       

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"incorrect username or password");
                        
                    }
                       



                } 
                    catch (SQLException ex) {
                        
                       
                    }
       
       
      
       
    }//GEN-LAST:event_loginActionPerformed

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
        AccountCreation ac=new AccountCreation(this,stmt);

        ac.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_createAccountActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {
      
        
        
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UserLogin().setVisible(true);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
