package data;

import domain.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oliver
 */
public class CustomerMapper {
    
    public static boolean customerExsist = false;
    
    public boolean getCustomerExist() {
        return customerExsist;
    }
    
    public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                int userid = rs.getInt("userid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String cname = rs.getString("cname");
                String email = rs.getString("email");
                double balance = rs.getDouble("balance");
                customer = new Customer(userid, username, password, cname, email, balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
    
    public void setCustomer(String username, String password, String cname, String email, double balance) throws SQLException {

        //Customer customer = new Customer();
        Connection conn = new DB().getConnection();
        try {
            String sql = "INSERT INTO customer(userid, username, password, cname, email, balance) VALUES (null, ?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, cname);
            pstmt.setString(4, email);
            pstmt.setDouble(5, 100.00);
            
            if(checkUserExists(email)) {
                
                return;
            } else {
                System.out.println("User dosen't exsist");
            pstmt.execute();
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
//            try {
//                conn.rollback();
//            } catch (SQLException ex1) {
//                ex1.printStackTrace();
//            }
            
        }
    }
    
    
    public static boolean checkUserExists(String email) {
        
        boolean userExists = false;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet r1 = pstmt.executeQuery();
            String emailCounter;
            if(r1.next()) {
                emailCounter = r1.getString("email");
                if(emailCounter.equals(email)) {
                    System.out.println("User already exists");
                    userExists = true;
                    customerExsist = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return userExists;
    }
    
    public static void main(String[] args) {
        Customer c = new CustomerMapper().getCustomer(1);
        System.out.println(c);
    }
}
