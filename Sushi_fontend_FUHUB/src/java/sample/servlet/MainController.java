/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NgocHao
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGIN_SERVLET = "LoginServlet";
    private static final String SEARCH_USERS = "Search User";
    private static final String SEARCH_USERS_SERVLET = "SearchUsersServlet";
    private static final String MOVE_PAGE = "MovePage";
    private static final String MOVE_PAGE_SERVLET = "MenuSushiServlet";
    private static final String DELETE_USER = "Delete";
    private static final String DELETE_USER_SERVLET = "DeleteUserServlet";
    private static final String UPDATE_USER = "Update";
    private static final String UPDATE_USER_SERVLET = "UpdateUserServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btAction");
            if (LOGIN.equals(action)) {
                url = LOGIN_SERVLET;
            } else if (SEARCH_USERS.equals(action)) {
                url = SEARCH_USERS_SERVLET;
            } else if (MOVE_PAGE.equals(action)) {
                url = MOVE_PAGE_SERVLET;
            } else if (DELETE_USER.equals(action)) {
                url = DELETE_USER_SERVLET;
            }else if (UPDATE_USER.equals(action)) {
                url = UPDATE_USER_SERVLET;
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
