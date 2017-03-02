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
public class Topping {
    
    private int topid;
    private String name;
    private double price;
    
    public Topping() {
        
    }

    public Topping(int topid, String name, double price) {
        this.topid = topid;
        this.name = name;
        this.price = price;
    }

    public int getTopid() {
        return topid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Topping{" + "topid=" + topid + ", name=" + name + ", price=" + price + '}';
    }
    
    
    
}
