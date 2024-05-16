
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.entities.Complaint;
import com.entities.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteComplaint")
public class deleteComplaint extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        
         // Check if the session is null
//        if (session == null) {
//            // Handle the case when the session is null
//            // You might want to redirect the user to the login page or take appropriate action
//            response.sendRedirect("login.jsp"); // Change "login.jsp" to your login page
//            return;
//        }
//
//        // Check if the "userId" attribute is set
//        Object userIdObj = session.getAttribute("userId");
//
//        // Check if userIdObj is an instance of your UserIdClass
//        if (userIdObj == null || !(userIdObj instanceof User)) {
//            // Handle the case when userId is null or not of the expected class
//            // You might want to redirect the user to the login page or take appropriate action
//            response.sendRedirect("login.jsp"); // Change "login.jsp" to your login page
//            return;
//        }
        
      //  User userId = (User) userIdObj;

        int id = Integer.parseInt(request.getParameter("id"));
        Complaint c = new Complaint();
        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
        dao.delete(id);
        //HttpSession session = request.getSession();
        //int userId = (int) session.getAttribute("userId");
        System.out.println("deleted");
        response.sendRedirect("displayComplaint.jsp");
    }
    
}
