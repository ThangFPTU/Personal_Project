/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thang
 */
public class Product {
    int id;
    String name,image;
    Double price;
    String des,tittle;
    int cateId;
    private int amount;

    public Product() {
    }

    public Product(int id, String name, String image, Double price, String des, String tittle, int cartID, int amount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.des = des;
        this.tittle = tittle;
        this.cateId = cartID;
        this.amount = amount;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTittle() {
        return tittle;
    }

    public void setStatus(String tittle) {
        this.tittle = tittle;
    }

    public void setCateId(int cartId) {
        this.cateId = cartId;
    }

    public int getCateId() {
        return cateId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
