/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Bottom;
import domain.entity.Topping;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oliver
 */
public class CakeMapper {
    
    
    public ArrayList<Topping> getToppings() {
        
        ArrayList<Topping> toppings = new ArrayList<>();
        
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM toppings";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int topid = rs.getInt("topid");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                toppings.add(new Topping(topid, name, price));
            }
            
            return toppings;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<Bottom> getBottoms() {
        
        ArrayList<Bottom> bottoms = new ArrayList<>();
        
        
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM bottoms";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int botid = rs.getInt("botid");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                bottoms.add(new Bottom(botid, name, price));
            }
            
            return bottoms;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
        
    }
    
}
