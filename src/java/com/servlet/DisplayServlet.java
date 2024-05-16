package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.UserDAO;
import com.entities.Admin;
import com.entities.Complaint;
import com.entities.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        // Check if "userId" attribute exists in the session
        if (session.getAttribute("userId") == null) {
            // Redirect to login page 
            response.sendRedirect("index.jsp");
            return;
        }

        // Get user ID from session
        int userId = (int) session.getAttribute("userId");

        ComplaintDao complaintDao = new ComplaintDao(DbConnect.getConn());
        List<Complaint> userComplaints = null;
        
        try {
            userComplaints = complaintDao.getComplaintsByUserId(userId);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check if userComplaints is null
        if (userComplaints == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        request.setAttribute("userComplaints", userComplaints);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayComplaint.jsp");
        dispatcher.forward(request, response);
    }
}


