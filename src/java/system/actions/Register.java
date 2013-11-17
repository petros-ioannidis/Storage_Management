/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.util.*;

/**
 *
 * @author zbs
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
        Statement statement;
        ResultSet resultSet;
        Connection con;
        con = UserDatabase.initiateConnection();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String con_pass = request.getParameter("Confirmed_Password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");

        statement = con.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement.executeQuery("SELECT * FROM users WHERE username=\"" + username + "\";");
        response.setContentType("text/html;charset=UTF-8");
        String error_message = null;
        try {
            /* TODO output your page here. You may use following sample code. */


            if (resultSet.next() == true) {
                error_message = "User already exists";
                request.setAttribute("html_output", error_message);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else if (!password.equals(con_pass)) {
                error_message = "Passwords do not match";
                request.setAttribute("html_output", error_message);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM users WHERE email=\"" + email + "\";");

                if (resultSet.next() == true) {
                    error_message = "email already exists";
                    request.setAttribute("html_output", error_message);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                } else {
                    String insertTableSQL = "insert users"
                            + "(password, name, surname, email, username) " + "values"
                            + "(\"" + password + "\",\"" + name + "\",\"" + surname + "\",\"" + email + "\",\"" + username + "\")";
                    statement.executeUpdate(insertTableSQL);
                    response.sendRedirect("ekremis.jsp");
                }
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
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
            Logger.getLogger(Register.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Register.class
                    .getName()).log(Level.SEVERE, null, ex);
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
