package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.entities.Admin;
import com.entities.Complaint;
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

@WebServlet("/displayadmin")
public class displaySerAdmin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    HttpSession session = request.getSession();
Admin loggedInAdmin = (Admin) session.getAttribute("admin");

ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
    List<Complaint> allComplaints = dao.getComplaintinfo(); 
    
    for (Complaint complaint : allComplaints) {
            if (complaint.getFileName() == null) {
                complaint.setFileName("default_image_path.jpg"); 
            } else {
               complaint.setFileName(complaint.getEvidenceImage());
            }
        }

    request.setAttribute("complaintList", allComplaints);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher("displayComAdmin.jsp");
        dispatcher.forward(request, response);
  
}
    
}

