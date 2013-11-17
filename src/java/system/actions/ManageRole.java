/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system.actions;

import database.util.UserDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import storage.users.UserRole;

/**
 *
 * @author zbs
 */
@WebServlet(name = "ManageRole", urlPatterns = {"/ManageRole"})
public class ManageRole extends HttpServlet {

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

        try {
            String name = request.getParameter("edit");
            UserRole role = UserDatabase.getRole(name);
            String html_output;

            html_output = "<div class=\"bigBox\" style=\"margin:0 auto;\">\n"
                    + "          <form method=\"GET\" action=\"UpdateRole\">"
                    + "            <table border=\"1\">\n"
                    + "                <tr>\n"
                    + "                    <td>Role Name</td>\n"
                    + "                    <td>" + role.getName() + "</td>" + "<input type=\"hidden\" name=\"name\" value=\"" + role.getName() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>storage read access</td>\n"
                    + "                    <td>" + role.getStorage_read() + "</td>\n" + "<td><input type=\"checkbox\" name=\"storage_read\"" + ((role.getStorage_read() == true) ? "checked" : "") + "/>Storage read</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>storage write access</td>\n"
                    + "                    <td>" + role.getStorage_write() + "</td>\n" + "<td><input type=\"checkbox\" name=\"storage_write\"" + ((role.getStorage_write() == true) ? "checked" : "") + "/>Storage write</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>product read access</td>\n"
                    + "                    <td>" + role.getProduct_read() + "</td>\n" + "<td><input type=\"checkbox\" name=\"product_read\"" + ((role.getProduct_read() == true) ? "checked" : "") + "/>Product read</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>product write access</td>\n"
                    + "                    <td>" + role.getProduct_write() + "</td>\n" + "<td><input type=\"checkbox\" name=\"product_write\"" + ((role.getProduct_write() == true) ? "checked" : "") + "/>Product write</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>supplier read access</td>\n"
                    + "                    <td>" + role.getSupplier_read() + "</td>\n" + "<td><input type=\"checkbox\" name=\"supplier_read\"" + ((role.getSupplier_read() == true) ? "checked" : "") + "/>Supplier read</td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>supplier write access</td>\n"
                    + "                    <td>" + role.getSupplier_write() + "</td>\n" + "<td><input type=\"checkbox\" name=\"supplier_write\"" + ((role.getSupplier_write() == true) ? "checked" : "") + "/>Supplier write</td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "           <input type=\"submit\" value=\"save\" name=\"\" />"
                    + "          </form>"
                    + "        </div>";

            request.setAttribute("html_output", html_output);
            request.getRequestDispatcher("AdminUser.jsp").forward(request, response);
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
            Logger.getLogger(ManageRole.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManageRole.class.getName()).log(Level.SEVERE, null, ex);
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
