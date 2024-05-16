
package com.servlet;

import com.conn.DbConnect;
import com.dao.AdminDao;
import com.dao.UserDAO;
import com.entities.Admin;
import com.entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
        
        String email = req.getParameter("email");
        String pass = req.getParameter("ps1");
        String userType = req.getParameter("userType");
        
        if ("admin".equals(userType)) {
            AdminDao dao1 = new AdminDao(DbConnect.getConn());
            Admin a = dao1.loginadmin(email, pass);
            
            HttpSession session = req.getSession();
            
            if(a != null){
                session.setAttribute("admin", a);
                resp.sendRedirect("admin.jsp");
            }else{
                session.setAttribute("InvalidMsg", "Invalid Email or Password");
                resp.sendRedirect("index.jsp");
            }
            
        } else {
            UserDAO dao = new UserDAO(DbConnect.getConn());
            User u = dao.loginuser(email, pass);
            
            HttpSession session = req.getSession();
            if (u != null) {
                session.setAttribute("userId", u.getId()); 
                session.setAttribute("user",u);
                resp.sendRedirect("profile.jsp");
            } else {
                session.setAttribute("InvalidMsg", "Invalid Email or Password");
                resp.sendRedirect("index.jsp");
            }
        }
    }
}
