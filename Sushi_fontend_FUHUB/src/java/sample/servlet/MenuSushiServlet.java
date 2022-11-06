/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.dao.RegistrationDAO;
import sample.dao.SushiMenuDTO;

/**
 *
 * @author NgocHao
 */
@WebServlet(name = "MenuSushiServlet", urlPatterns = {"/MenuSushiServlet"})
public class MenuSushiServlet extends HttpServlet {
    
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "Menu.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String click = request.getParameter("clickPage");
            if (click == null) {
                click = "1";
            }
            int pageClick = Integer.parseInt(click);
            RegistrationDAO dao = new RegistrationDAO();
            List<SushiMenuDTO> menuSuShi = dao.getMenuSushi(pageClick);
            if (menuSuShi != null) {
                HttpSession session = request.getSession();
                session.setAttribute("MENU_SUSHI", menuSuShi);               
                url = SUCCESS;
            }
        } catch (SQLException e) {
            System.out.println("ERROR at Menu sushi Servlet by SQL " + e);
        } catch (NamingException ex) {
            System.out.println("ERROR at Menu sushi Servlet by Naming " + ex);
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
