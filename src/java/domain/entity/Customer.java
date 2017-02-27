/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author Oliver
 */
public class Customer {
    
    private int userid;
    private String username;
    private String password;
    private String cname;
    private String email;
    private double balance;

    public Customer(int userid, String username, String password, String cname, String email, double balance) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.cname = cname;
        this.email = email;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserid() {
        return userid;
    }

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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "userid=" + userid + ", username=" + username + ", password=" + password + ", cname=" + cname + ", email=" + email + ", balance=" + balance + '}';
    }

   
    
}
