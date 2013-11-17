/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system.actions;

import database.util.UserDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import storage.users.User;
import storage.users.UserRole;

/**
 *
 * @author zbs
 */
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {

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
            throws ServletException, IOException {

        User user;
        String edit = (String) request.getParameter("edit");
        String dlist;
        String html_output;
        List<UserRole> roles;
        try {
            roles = UserDatabase.getAllRoles();

            user = UserDatabase.getUser("username", edit);
            String error_message = null;

            dlist = "<select name=\"role\">";

            for (int i = 0; i < roles.size(); i++) {
                dlist += "<option " + (roles.get(i).getName().equals(user.getRole().getName()) ? "selected" : "") + " value=\"" + roles.get(i).getName() + "\">" + roles.get(i).getName() + "</option>\n";
            }

            dlist += "</select>";
            html_output = "<div class=\"bigBox\" style=\"margin:0 auto;\">\n"
                    + "          <form method=\"GET\" action=\"UpdateUser\">"
                    + "            <table border=\"1\">\n"
                    + "                <tr>\n"
                    + "                    <td>Username</td>\n"
                    + "                    <td>" + user.getUsername() + "</td>" + "<input type=\"hidden\" name=\"username\" value=\"" + user.getUsername() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Role</td>\n"
                    + "                    <td>" + user.getRole().getName() + "</td>" + "<td>" + dlist + "</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Name</td>\n"
                    + "                    <td>" + user.getName() + "</td>" + "<td><input type=\"text\" name=\"name\" value=\"" + user.getName() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Surname</td>\n"
                    + "                    <td>" + user.getSurname() + "</td>\n" + "<td><input type=\"text\" name=\"surname\" value=\"" + user.getSurname() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Email</td>\n"
                    + "                    <td>" + user.getEmail() + "</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>Full User</td>\n"
                    + "                    <td>" + user.getFull_user() + "</td>\n" + "<td><input type=\"checkbox\" name=\"full_user\"" + ((user.getFull_user() == true) ? "checked" : "") + "/>full user</td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "           <input type=\"submit\" value=\"save\" name=\"\" />"
                    + "          </form>"
                    + "        </div>";


            request.setAttribute("html_output", html_output);
            request.getRequestDispatcher("AdminUser.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
        processRequest(request, response);
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
