/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.RegistrationDAO;

/**
 *
 * @author NgocHao
 */
@WebServlet(name = "MovePageServlet", urlPatterns = {"/MovePageServlet"})
public class MovePageServlet extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Menu.jsp";
    private static final int PAGE_SIZE = 3;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            RegistrationDAO dao = new RegistrationDAO();
            int count = dao.getCountSushi();
            if (count != 0) {
                url = SUCCESS;
                int currentPage = count / PAGE_SIZE;
                if (count % PAGE_SIZE != 0) {
                    currentPage++;
                }
                HttpSession session = request.getSession();
                session.setAttribute("COUNT_SUSHI", currentPage);

            }
        } catch (SQLException e) {
            System.out.println("Error at MovePageServlet by SQL " + e);
        } catch (NamingException ex) {
            System.out.println("Error at MovePageServlet by Naming " + ex);
        } finally {
            response.sendRedirect(url);

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
        processRequest(request, response);
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
