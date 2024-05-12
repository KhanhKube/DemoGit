/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author admin
 */
public class addStudent extends HttpServlet {

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
            out.println("<title>Servlet addStudent</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addStudent at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNo_raw = request.getParameter("rollNo");
        String name_raw = request.getParameter("name");
        String mark_raw = request.getParameter("mark");
        StudentDAO sdb = new StudentDAO();
        if (rollNo_raw != null) {
            String rollNo = rollNo_raw.trim();
            String name = name_raw.trim();
            String mark_string = mark_raw.trim();
            if (rollNo.isBlank() || name.isBlank() || mark_string.isBlank()) {
                request.setAttribute("err", "Don't input only space !");
                request.getRequestDispatcher("add.jsp").forward(request, response);
            } else {
                try {
                    float mark = Float.parseFloat(mark_string);
                    Student student = sdb.getStudent(rollNo_raw);
                    if (student == null) {
                        Student studentNew = new Student(rollNo_raw, name, mark);
                        sdb.insert(studentNew);
                        response.sendRedirect("list");
                    } else {
                        request.setAttribute("err", rollNo_raw + " is exitsed!!!");
                        request.getRequestDispatcher("add.jsp").forward(request, response);
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("err", "Mark must is the number");
                    request.getRequestDispatcher("add.jsp").forward(request, response);
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
        processRequest(request, response);
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
