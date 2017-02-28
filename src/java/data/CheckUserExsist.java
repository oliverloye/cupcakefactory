/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oliver
 */
public class CheckUserExsist {
    
    public static boolean CheckUsernameExists(String email) {
        boolean userExists = false;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT email FROM customer";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet r1 = pstmt.executeQuery();
            String emailCounter;
            if(r1.next()) {
                emailCounter = r1.getString("email");
                if(emailCounter.equals(email)) {//this part does not happen even if it should
                    System.out.println("It already exists");
                    userExists = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userExists;
    }
    
}
