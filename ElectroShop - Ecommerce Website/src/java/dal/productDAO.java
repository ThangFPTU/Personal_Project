/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author Thang
 */
public class productDAO extends DBContext {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        String query = "select *from product";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product pd = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                list.add(pd);
            }
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public ArrayList<Product> getProductByCatId(int idd) {
        ArrayList<Product> list = new ArrayList<>();
        String query = "select *from product where categoryid = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pd = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                list.add(pd);
            }
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public Product getProductById(int id) {

        String query = "select *from product where id = ?;";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));

            }

        } catch (Exception e) {
        }
        return null;

    }
    public void deleteProduct(int id) {
        String query = "delete from product where id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void editProduct(Product product) {
        String query = "update product \n" +
" set name = ?,\n" +
"[image] = ?,\n" +
"price = ?,\n" +
"tittle = ?,\n" +
"[description] = ?,\n" +
"categoryid = ?,\n" +
"amount =?\n" +
"where id = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getImage());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getTittle());
            ps.setString(5, product.getDes());
            ps.setInt(6, product.getCateId());
            ps.setInt(7, product.getAmount());
            ps.setInt(8, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void AddNewProduct(String name,double price,String image,String title,String description,int cateId,int amount) {
        String query = "insert into product values(?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setDouble(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, cateId);
            ps.setInt(7, amount);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getProductByName(String txtSearch) {

        String query = "select *from product where name like ?;";
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));

                list.add(p);
            }
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public static void main(String[] args) {
        productDAO dao = new productDAO();
        Product product = dao.getProductById(30);
        System.out.println(product.getId());
    }

}
