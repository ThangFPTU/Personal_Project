/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;
/**
 *
 * @author Thang
 */
public class accountDAO extends DBContext{
    public Account checkAcountExist(String uName){
        String sql= "select*from account where uName = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void signUp(String name,String pass,String email){
        String sql= "insert into account values(\n" +
"?,?,?,0)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Account login(String name,String pass){
        String sql= "select*from account where uName = ? and uPass = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
        accountDAO dao = new accountDAO();
        Account acount = dao.login("admin", "123456");
        System.out.println(acount.getAdmin());
    }
}
