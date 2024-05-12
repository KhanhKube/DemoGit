/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Customer;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "customerSeverlet", urlPatterns = {"/customer"})
public class customerSeverlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customerSeverlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerSeverlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    List<Customer> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        insert(id, request, response);
        String idDelete = request.getParameter("idDelete");
        delete(idDelete);
        String idEdit = request.getParameter("idEdit");
        Edit(idEdit, request, response);
        request.setAttribute("list", list);
        if(idEdit == null){
           request.getRequestDispatcher("customer.jsp").forward(request, response);
        }else{
           request.getRequestDispatcher("insert.jsp").forward(request, response);
        }
        
    }

    private void insert(String id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (id != null) {
            id = request.getParameter("id");
            if (checkId(id) == null) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                Customer customer = new Customer(id, name, email, address);
                list.add(customer);
                request.setAttribute("list", list);
                request.getRequestDispatcher("customer.jsp").forward(request, response);
            }
        }
    }
    private void delete(String idDelete){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(idDelete)){
                list.remove(i);
            }
        }
    }
    private void Edit(String idEdit, HttpServletRequest request, HttpServletResponse response){
        if(idEdit != null){
            for (int i = 0; i < list.size(); i++) {
                request.setAttribute("idEdit", list.get(i).getId());
                request.setAttribute("nameEdit", list.get(i).getName());
                request.setAttribute("emailEdit", list.get(i).getEmail());
                request.setAttribute("addressEdit", list.get(i).getAddress());
                
            }
        }
    }
    private Customer checkId(String id) {
        for (Customer customer : list) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        
        Customer customer = checkId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.getAddress();
        request.setAttribute("list", list);
        request.getRequestDispatcher("customer.jsp").forward(request, response);
        
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
