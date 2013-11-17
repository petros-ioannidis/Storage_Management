/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author sofia
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import database.util.*;
import java.util.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zbs
 */
@WebServlet(name = "ShowStorage", urlPatterns = {"/ShowStorage"})
public class ShowStorage extends HttpServlet {

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
        List<StorageUnit> units = UserDatabase.getAllStorages();
        StorageUnit unit = null;
        String html_output = null;
        String error_message = null;
        try {

            if (username.equals("admin")) {


                html_output = "<center><table border=\"1\">\n";
                
                for (int i = 0; i < units.size(); i++) { //!!!!!!

                    html_output += "<tr>\n"
                            + "<td>" + (i+1) + "</td>\n"
                            + "<td>" + units.get(i).getName() + "</td>\n"
                            + "<td><form method=\"GET\" action=\"EditStorage\"><button type=submit value=" + units.get(i).getName()
                            + " name=\"edit\">edit</button></form></td>"
                            + "</tr>";
                }
                
                request.setAttribute("html_output",html_output);
                request.getRequestDispatcher("AdminUser.jsp").forward(request, response);
            } else {
                error_message = "You are not authorized to do this."
                        + "<script>setTimeout(\"location.href = 'index.jsp';\",3000)</script>"; 
                request.setAttribute("html_output",error_message);
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
            System.out.println(ex.getMessage());
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
            System.out.println(ex.getMessage());
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
