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
public class Bottom {
    
    private int botid;
    private String name;
    private double price;
    
    public Bottom() {
        
    }

    public Bottom(int botid, String name, double price) {
        this.botid = botid;
        this.name = name;
        this.price = price;
    }

    public int getBotid() {
        return botid;
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
        return "Bottom{" + "botid=" + botid + ", name=" + name + ", price=" + price + '}';
    }
    
}
