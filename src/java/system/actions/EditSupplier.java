/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system.actions;

import database.util.UserDatabase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import storage.*;
import storage.products.ProductType;

/**
 *
 * @author zbs
 */
@WebServlet(name = "EditSupplier", urlPatterns = {"/EditSupplier"})
public class EditSupplier extends HttpServlet {

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
        String html_output;
        try {
            
            String name = (String) request.getParameter("edit");
            String surname = (String) request.getParameter("suredit");
            List<ProductType> products = UserDatabase.getAllProducts(name,surname);
            Supplier supplier = UserDatabase.getSupplier(name,surname);
            html_output = "<div class=\"bigBox\" style=\"margin:0 auto;\">\n"
                    + "          <form method=\"GET\" action=\"UpdateSupplier\">"
                    + "            <table border=\"1\">\n"
                    + "                <tr>\n"
                    + "                    <td>name</td>\n"
                    + "                    <td>" + supplier.getName()+"</td> + <td><input type=\"hidden\" name=\"name\" value=\"" + supplier.getName() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"+ "                <tr>\n"
                    + "                    <td>surname</td>\n"
                    + "                    <td>" + supplier.getSurname() + "</td> + <td><input type=\"hidden\" name=\"surname\" value=\"" + supplier.getSurname() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"+ "                <tr>\n"
                    + "                    <td>description</td>\n"
                    + "                    <td>" + supplier.getAddress() + "</td> + <td><input type=\"text\" name=\"address\" value=\"" + supplier.getAddress() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>size</td>\n"
                    + "                    <td>" + supplier.getSSN() + "</td>\n" + "<td><input type=\"text\" name=\"SSN\" value=\"" + supplier.getSSN() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "              </table>\n"
                    + "           <input type=\"submit\" value=\"save\" name=\"\" />"
                    + "          </form>"
                    + "        </div>";
            
             for (int i = 0; i < products.size(); i++) { //!!!!!!

                    html_output += "<table border=\"1\">\n"
                            +"<tr>\n"
                            + "<td>" + (i+1) + "</td>\n"
                            + "<td>" + products.get(i).getName() + "</td>\n"
                            + "</tr>"
                            + "</table>";
                }
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
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
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
