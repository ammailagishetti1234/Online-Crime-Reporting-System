/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.conn.DbConnect;
import com.dao.UserDAO;
import com.entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
//            fetch all data
             String uname = request.getParameter("uname");
             String uemail = request.getParameter("uemail");
             String upass = request.getParameter("upass");
             
             //get the user from session
             HttpSession s=request.getSession();
             User u = (User)s.getAttribute("user");
             u.setName(uname);
             u.setEmail (uemail);
             u.setPassword (upass);
             
             //update db
             UserDAO dao = new UserDAO(DbConnect.getConn());
             boolean ans=dao.updateUser(u);
             
             if(ans)
             {
                 response.sendRedirect("profile.jsp");
             }else{
                 response.sendRedirect("profile.jsp");
             }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
