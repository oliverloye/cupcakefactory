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
            PreparedStatement customerStmt = conn.prepareStatement(sql);

            
            customerStmt.setString(1, username);
            customerStmt.setString(2, password);
            customerStmt.setString(3, cname);
            customerStmt.setString(4, email);
            customerStmt.setDouble(5, 100.00);
            
            customerStmt.execute();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        Customer c = new CustomerMapper().getCustomer(1);
        System.out.println(c);
    }
}
