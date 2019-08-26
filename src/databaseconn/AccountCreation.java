/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconn;

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
public class AccountCreation extends javax.swing.JFrame {
javax.swing.JFrame previous;
Statement stmt;
    /**
     * Creates new form AccountCreation
     * @param temp
     * @param stmt
     */
    public AccountCreation(javax.swing.JFrame temp,Statement stmt) {
        initComponents();
        previous=temp;
        this.stmt=stmt;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        LABE2 = new javax.swing.JLabel();
        LABE3 = new javax.swing.JLabel();
        createAccount = new javax.swing.JButton();
        close = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        LABE4 = new javax.swing.JLabel();
        LABE5 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        phno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userNameLabel.setFont(userNameLabel.getFont().deriveFont((userNameLabel.getFont().getStyle() | java.awt.Font.ITALIC), 18));
        userNameLabel.setText("USERNAME");
        getContentPane().add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 160, 30));

        LABE2.setFont(LABE2.getFont().deriveFont((LABE2.getFont().getStyle() | java.awt.Font.ITALIC), 18));
        LABE2.setText("NAME");
        getContentPane().add(LABE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 80, 30));

        LABE3.setFont(LABE3.getFont().deriveFont((LABE3.getFont().getStyle() | java.awt.Font.ITALIC), 18));
        LABE3.setText("ADDRESS");
        getContentPane().add(LABE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 80, 30));

        createAccount.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        createAccount.setText("CREATE ACCOUNT");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });
        getContentPane().add(createAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 210, 30));

        close.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        close.setText("CLOSE");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 210, 30));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 290, 40));
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 290, 40));
        getContentPane().add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 290, 40));

        LABE4.setFont(LABE4.getFont().deriveFont((LABE4.getFont().getStyle() | java.awt.Font.ITALIC), 18));
        LABE4.setText("PASSWORD");
        getContentPane().add(LABE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 160, 30));

        LABE5.setFont(LABE5.getFont().deriveFont((LABE5.getFont().getStyle() | java.awt.Font.ITALIC), 18));
        LABE5.setText("PHONE NUMBER ");
        getContentPane().add(LABE5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 160, 30));
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 290, 40));
        getContentPane().add(phno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 290, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed

    try {                                              
        
        String uname = "";
        String pass = "";
        String n ="";
       
        boolean attempt =true; 
        while(attempt)
        {   
            n = name.getText();

            uname = userName.getText();

            pass = this.pwd.getText();
            ResultSet set;
            if(n.equals("")||uname.equals("")||pass.equals(""))
            {
                JOptionPane.showMessageDialog(this, "all fiedls  are mandatory");
                name.setText("");
                userName.setText("");
                pwd.setText("");
                return;
            }
            boolean found=false;
                int iterator=0;
                while(true)
                {
                    if( Bank.acc.get(iterator++).getUsername().equals(userName.getText()))
                    {
                        found=true;
                        break;
                    }
                    if(iterator==Bank.acc.size()-1)
                        break;

                }
                if(found)
                {
                    JOptionPane.showMessageDialog(this, "username already exist try another one ");
                    userName.setText("");
                    return;
                }


            if(pass.length()<8)
            {
                JOptionPane.showMessageDialog(this, "pass must have 8 characters");

                pwd.setText("");
                return;

            }
             if(address.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "address must in fiiled");

                    address.setText("");
                    return;
            }

           if(phno.getText().length()<10)
            {

                try {
                    Integer.parseInt(phno.getText());
                    return;
                } catch (NumberFormatException numberFormatException) 
                {
                    JOptionPane.showMessageDialog(this, "invalid phone number ");

                    phno.setText("");
                    return;
                }
            }
        
                 else
               break;
            }
        
       
            int acc=Bank.addAccount(n,uname,pass);
            JOptionPane.showMessageDialog(this, "Account Created Successfully account number is :"+acc);
            Bank.fetchDetails();
      
            UserLogin object = new UserLogin();
            object.setVisible(true);
            setVisible(false);
        
        
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
        Logger.getLogger(AccountCreation.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }//GEN-LAST:event_createAccountActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
previous.setVisible(true);     
    }//GEN-LAST:event_formWindowClosing

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABE2;
    private javax.swing.JLabel LABE3;
    private javax.swing.JLabel LABE4;
    private javax.swing.JLabel LABE5;
    private javax.swing.JTextField address;
    private javax.swing.JButton close;
    private javax.swing.JButton createAccount;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phno;
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
