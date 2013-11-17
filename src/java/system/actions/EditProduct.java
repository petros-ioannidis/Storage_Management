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
import storage.products.ProductType;

/**
 *
 * @author zbs
 */
@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
public class EditProduct extends HttpServlet {

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
           
            ProductType product = UserDatabase.getProduct("name", name);
            String SerialNum = product.getSerialNum();
            html_output = "<div class=\"bigBox\" style=\"margin:0 auto;\">\n"
                    + "          <form method=\"GET\" action=\"UpdateProduct\">"
                    + "            <table border=\"1\">\n"
                    + "                <tr>\n"
                    + "                    <td>name</td>\n"
                    + "                    <td>" + product.getName() + "</td>" + "<input type=\"hidden\" name=\"name\" value=\"" + product.getName() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>name</td>\n"
                    + "                    <td>" + product.getSerialNum() + "</td>" + "<input type=\"hidden\" name=\"serialNum\" value=\"" + product.getSerialNum() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>description</td>\n"
                    + "                    <td>" + product.getDescription() + "</td> + <td><input type=\"text\" name=\"description\" value=\"" + product.getDescription() + "\"/>\n"
                    + "                </tr>\n"  
                    + "                <tr>\n"
                    + "                    <td>productType</td>\n"
                    + "                    <td>" + product.getProductType() + "</td> + <td><input type=\"text\" name=\"description\" value=\"" + product.getProductType() + "\"/>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>size</td>\n"
                    + "                    <td>" + product.getSize() + "</td>\n" + "<td><input type=\"text\" name=\"size\" value=\"" + product.getSize() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>price</td>\n"
                    + "                    <td>" + product.getPrice() + "</td>\n" + "<td><input type=\"number\" name=\"price\" value=\"" + product.getPrice() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td>quantity</td>\n"
                    + "                    <td>" + product.getQuantity() + "</td>\n" + "<td><input type=\"number\" name=\"quantity\" value=\"" + product.getQuantity() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                    <td>weight</td>\n"
                    + "                    <td>" + product.getWeight() + "</td>\n" + "<td><input type=\"number\" name=\"weight\" value=\"" + product.getWeight() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                    <td>availability</td>\n"
                    + "                    <td>" + product.getAvailability() + "</td>\n" + "<td><input type=\"checkbox\" name=\"availability\" " + (product.getAvailability() == true ? "checked" : "") + " \" /></td>\n"
                    + "                </tr>\n"
                    + "                    <td>nameOfUnit</td>\n"
                    + "                    <td>" + product.getNameOfUnit() + "</td>\n" + "<td><input type=\"text\" name=\"nameOfUnit\" value=\"" + product.getNameOfUnit() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                    <td>supplierName</td>\n"
                    + "                    <td>" + product.getSupplierName() + "</td>\n" + "<td><input type=\"text\" name=\"supplierName\" value=\"" + product.getSupplierName() + "\" /></td>\n"
                    + "                </tr>\n"
                    + "                    <td>supplierSurname</td>\n"
                    + "                    <td>" + product.getSupplierSurname() + "</td>\n" + "<td><input type=\"text\" name=\"supplierName\" value=\"" + product.getSupplierSurname() + "\" /></td>\n"
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
