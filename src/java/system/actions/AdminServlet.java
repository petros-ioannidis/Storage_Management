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
import java.util.*;
import javax.servlet.http.HttpSession;
import storage.users.User;
import storage.users.UserRole;

/**
 *
 * @author zbs
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = null;
        String html_output = null;
        String edit = (String) request.getParameter("edit");
        String error_message = null;
        String dlist;
        try {

            if (username.equals("admin")) {

                List<User> users = UserDatabase.getAllUsers();
                List<UserRole> roles = UserDatabase.getAllRoles();

                html_output = "<center><table border=\"1\">\n";

                for (int i = 0; i < users.size(); i++) { //!!!!!!

                    html_output += "<tr>\n"
                            + "<td>" + i + "</td>\n"
                            + "<td>" + users.get(i).getUsername() + "</td>\n"
                            + "<td><form method=\"GET\" action=\"EditUser\"><button type=submit value=" + users.get(i).getUsername()
                            + " name=\"edit\">edit</button></form></td>"
                            + "</tr>";
                }

                html_output += "<br><br>"
                        + "<center><table border=\"1\">\n";

                for (int i = 0; i < roles.size(); i++) {

                    html_output += "<tr>\n"
                            + "<td>" + i + "</td>\n"
                            + "<td>" + roles.get(i).getName() + "</td>\n"
                            + "<td><form id=\"manageUserForm\" method=\"GET\" action=\"ManageRole\"><button type=submit value=" + roles.get(i).getName()
                            + " name=\"edit\">edit</button></form></td>"
                            + "<td><form method=\"GET\" action=\"DeleteRole\"><button type=submit value=" + roles.get(i).getName()
                            + " name=\"delete\">delete</button></form></td>"
                            + "</tr>";
                }
                html_output += "<center><form method=\"link\" action=\"roleform.jsp\"><input type=\"submit\" value=\"add role\"></form></center>";
                html_output += "<center><form method=\"get\" action=\"ShowProducts\"><button type=submit name=\"products\">products</button></form></center>";
                
                request.setAttribute("html_output", html_output);
                request.getRequestDispatcher("AdminUser.jsp").forward(request, response);
            
            } else {
                error_message = "You are not authorized to do this."
                        + "<script>setTimeout(\"location.href = 'index.jsp';\",3000)</script>";
                request.setAttribute("html_output", error_message);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (SQLException exep) {
            System.out.println(exep.getMessage());
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
