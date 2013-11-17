/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system.actions;

import database.util.UserDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zbs
 */
@WebServlet(name = "UpdateRole", urlPatterns = {"/UpdateRole"})
public class UpdateRole extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String name = request.getParameter("name");
        Boolean storage_read = false;
        Boolean storage_write = false;
        Boolean product_read = false;
        Boolean product_write = false;
        Boolean supplier_read = false;
        Boolean supplier_write = false;


        if (request.getParameter("storage_read") != null) {
            storage_read = true;
        }
        if (request.getParameter("storage_write") != null) {
            storage_write = true;
        }
        if (request.getParameter("product_read") != null) {
            product_read = true;
        }
        if (request.getParameter("product_write") != null) {
            product_write = true;
        }
        if (request.getParameter("supplier_read") != null) {
            supplier_read = true;
        }
        if (request.getParameter("supplier_write") != null) {
            supplier_write = true;
        }
        
        UserDatabase.updateRole(name, storage_read, storage_write, product_read, product_write, supplier_read, supplier_write);
        response.sendRedirect("admin.jsp");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRole.class.getName()).log(Level.SEVERE, null, ex);
        }
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
