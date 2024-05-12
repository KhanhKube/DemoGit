/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Product;
import java.util.List;

/**
 *
 * @author admin
 */
public class productSeverlet extends HttpServlet {

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
            out.println("<title>Servlet productSeverlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet productSeverlet at " + request.getContextPath() + "</h1>");
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
    List<Product> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        insert(id, request, response);
        String idEdit = request.getParameter("idEdit");
        Edit(idEdit, request, response);
        String idDelete = request.getParameter("idDelete");
        delete(idDelete);
        request.setAttribute("list", list);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    private void delete(String idDelete) {
        if (idDelete != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(idDelete)) {
                    list.remove(i);
                }
            }
        }
    }

    private void insert(String id, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (id != null) {
            if (checkProduct(id) == null) {
                String name = request.getParameter("name");
                String provider = request.getParameter("provider");
                String price_raw = request.getParameter("price");
                try {
                    double price = Double.parseDouble(price_raw);
                    Product product = new Product(id, name, provider, price);
                    list.add(product);
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("product.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    System.err.println(e);
                }
            }
        }
    }

    private void Edit(String idEdit, HttpServletRequest request, HttpServletResponse response) {
        if (idEdit != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(idEdit)) {
                    request.setAttribute("idEdit", list.get(i).getId());
                    request.setAttribute("nameEdit", list.get(i).getName());
                    request.setAttribute("priceEdit", list.get(i).getPrice());
                    request.setAttribute("providerEdit", list.get(i).getProvider());
                }
            }
        }
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
        String price_raw = request.getParameter("price");
        String provider = request.getParameter("provider");
        try {
            double price = Double.parseDouble(price_raw);
            Product product = checkProduct(id);
            product.setPrice(price);
            product.setName(name);
            product.setProvider(provider);
            request.setAttribute("list", list);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            String error = "Unit's Price is number";
            request.setAttribute("list", list);
            request.setAttribute("error", error);
            request.getRequestDispatcher("product.jsp").forward(request, response);
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    private Product checkProduct(String id) {
        for (Product p : list) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
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
