/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconn;

/**
 *
 * @author c3
 */
public class BankAccount {

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    int accountNumber;

    public BankAccount(int accountNumber, double balance, String name, String username, String password) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
        this.username = username;
        this.password = password;
    }
    double balance;
    String name;
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankAccount(int accountNumber, double balance, String n) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        name = n;
    }

    public String getName() {
        return name;
    }

    double deposit(double x) {
        this.balance += x;
        return this.balance;
    }

   double withdraw(double x) {
        if (balance < x) {
            System.out.println("not enough balance");
            return 0;
        }
        balance -= x;
        return balance;

    }

    int getAccountNumber() {
        return accountNumber;
    }

    void taxDeduction() {
        balance = (balance - (0.3) * balance);

    }

    double getBalance() {
        return balance;

    }

}
