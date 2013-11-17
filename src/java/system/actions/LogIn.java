/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system.actions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.util.*;
import javax.servlet.http.HttpSession;
import storage.users.*;

/**
 *
 * @author zbs
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        statement = con.createStatement();
        // Result set get the result of the SQL queryUser user;
        User user = null;
        user = UserDatabase.getUser("username", username);
        response.setContentType("text/html;charset=UTF-8");
        String error_message = null;
        try {
            /* TODO output your page here. You may use following sample code. */


            if (user == null) {
                error_message = " <p>Register first!</p>\n"
                        + "        <script type=\"text/JavaScript\">\n"
                        + "            <!--\n"
                        + "            setTimeout(\"location.href = 'index.jsp';\",3000);\n"
                        + "            -->\n"
                        + "        </script>";
                request.setAttribute("html_output", error_message);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else if (!password.equals(user.getPassword())) {
                error_message = " <p>Wrong password!</p>\n"
                        + "        <script type=\"text/JavaScript\">\n"
                        + "            <!--\n"
                        + "            setTimeout(\"location.href = 'index.jsp';\",3000);\n"
                        + "            -->\n"
                        + "        </script>";
                request.setAttribute("html_output", error_message);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession(true);
                session.putValue("username", username);
                session.putValue("role", user.getRole().getName());
                session.putValue("storage_read", user.getRole().getStorage_read());
                session.putValue("storage_write", user.getRole().getStorage_write());
                session.putValue("product_read", user.getRole().getProduct_read());
                session.putValue("product_write", user.getRole().getProduct_write());
                session.putValue("supplier_read", user.getRole().getSupplier_read());
                session.putValue("supplier_write", user.getRole().getSupplier_write());
                session.putValue("name", user.getName());
                session.putValue("surname", user.getSurname());
                session.putValue("email", user.getEmail());
                session.putValue("full_user", user.getFull_user());
                response.sendRedirect("index.jsp");
            }

        } finally {
            }
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
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
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
