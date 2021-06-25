/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cart;
import dal.accountDAO;
import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import javax.servlet.http.HttpSession;
import model.Item;
import model.Product;

/**
 *
 * @author Thang
 */
public class addServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Object o = session.getAttribute("cart");
        Cart cart;
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String tid = request.getParameter("id");
        try {
            int pId = Integer.parseInt(tid); 
           Item item = null;
            boolean exist = false;
            for(Item i: cart.getItems()){
                if(i.getProduct().getId() == pId){
                    exist = true;
                    item = i;
                }
            }
            if(exist){
                item.setQuantity(item.getQuantity()+1);
                    item.setPrice(item.getPrice()*item.getQuantity());
            }else{
                productDAO dao = new productDAO();
                Product product = dao.getProductById(pId) ;
                item = new Item(product, 1, product.getPrice());
                cart.addItem(item);
            }
            

            
        } catch (Exception e) {
        }

        List<Item> list = cart.getItems();
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);

//        request.getRequestDispatcher("category?id="+ id).forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
