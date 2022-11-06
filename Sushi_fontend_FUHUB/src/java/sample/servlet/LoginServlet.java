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
import sample.dao.UsersDTO;

/**
 *
 * @author NgocHao
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String ERROR = "Login.jsp";
    private static final String USER = "HomePage.jsp";
    private static final String ADMIN = "admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userID = request.getParameter("txtUser");
            String password = request.getParameter("txtPassword");
            RegistrationDAO dao = new RegistrationDAO();
            UsersDTO users = dao.getUser(userID, password);
            if (users != null) {
                HttpSession session = request.getSession();
                session.setAttribute("LIST_USER", users);
                if ("AD".equals(users.getRoleId())) {
                    url = ADMIN;
                } else if ("US".equals(users.getRoleId())) {
                    url = USER;
                }
            } else {
                request.setAttribute("ERROR_LOGIN", "Incorrect userID or password !");
            }
        } catch (SQLException e) {
            System.out.println("Error at Login Servlet by SQL " + e);
        } catch (NamingException ex) {
            System.out.println("Error at Login Servlet by Naming " + ex);
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
