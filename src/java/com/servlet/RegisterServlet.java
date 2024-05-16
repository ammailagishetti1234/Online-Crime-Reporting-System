
package com.servlet;

import com.conn.DbConnect;
import com.dao.UserDAO;
import com.entities.User;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String check = request.getParameter("check");
      
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        User u = new User(name, email, password);
        
        UserDAO dao=new UserDAO(DbConnect.getConn()); 
        boolean f=dao.userRegister(u);
        
        HttpSession session=request.getSession();
        
        if(f){
            session.setAttribute("successMsg", "User Register Succesfully");
            response.sendRedirect("register.jsp");
            
        }else{
            session.setAttribute("errorMsg", "Something went wrong");
            response.sendRedirect("register.jsp");
        }
        
    
    }
}
