package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.UserDAO;
import com.entities.Complaint;
import com.entities.User;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/complaint")
public class regComplaintServlet extends HttpServlet {
     private boolean validatePhoneNumber(String phone_no) {
        return phone_no.length() == 10;
    }

    private boolean checkPhoneNumberExists(String phone_no) throws SQLException {
        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());

        // Assuming you have a method in ComplaintDao to check if the phone number exists
        return dao.isPhoneNumberExists(phone_no);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            PrintWriter out = response.getWriter();
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone_no = request.getParameter("phone_no");
            String police_city = request.getParameter("pcity");
            String police_state = request.getParameter("pstate");
            String complaint_detail = request.getParameter("complaint_detail");
            String area = request.getParameter("area");
            String incident_city = request.getParameter("icity");
            String type_of_crime = request.getParameter("tcrime");
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            String accused_name = request.getParameter("aname");
            String accused_address = request.getParameter("aadd");
            String accused_phone_no = request.getParameter("aphone");
            String victim_name = request.getParameter("vname");
            String victim_address = request.getParameter("vadd");
            String victim_phone_no = request.getParameter("vphone");
            String evidence_detail = request.getParameter("evidence_detail");
            
            String status = request.getParameter("status");
            
            // Client-side phone number validation
            if (!validatePhoneNumber(phone_no) || !validatePhoneNumber(accused_phone_no) || !validatePhoneNumber(victim_phone_no)) {
                out.println("<html><head><script type='text/javascript'>");
                out.println("alert('Phone number must be 10 digits long.');");
                out.println("window.location.href='regComplaint.jsp'");
                out.println("</script></head></html>");
                return;
            }
            
            // Client-side phone number existence check
            if (checkPhoneNumberExists(phone_no) || checkPhoneNumberExists(accused_phone_no) || checkPhoneNumberExists(victim_phone_no)) {
                out.println("<html><head><script type='text/javascript'>");
                out.println("alert('Phone number already exists in the database.');");
                out.println("window.location.href='regComplaint.jsp'");
                out.println("</script></head></html>");
                return;
            }
            
            Part filePart = request.getPart("files");
            
            String fileName = null;
            
            if (filePart != null && filePart.getSize() > 0) {
                // File submitted, process it
                fileName = filePart.getSubmittedFileName();
                String filePath = getServletContext().getRealPath("") + "images" + File.separator + fileName;
                String path = getServletContext().getRealPath("") + "images";
                String path1 = getServletContext().getRealPath("") + "videos";
                
                File file = new File(path);
                filePart.write(path + File.separator + fileName);
                
                //filePart.write(filePath);
 
                Complaint complaint = new Complaint();
                complaint.setEvidenceImage(filePath); 
            }
            
            
            HttpSession session = request.getSession();
            
            UserDAO userDao = new UserDAO(DbConnect.getConn());
            User user = userDao.getUserByEmail(email);
            
            if (user != null) {
                System.out.println("User found: " + user.getName() + " (" + user.getEmail() + ")");
                
                Complaint c = new Complaint(name, email, phone_no, police_city, police_state, complaint_detail, area, incident_city, type_of_crime, date, accused_name, accused_address, accused_phone_no, victim_name, victim_address, victim_phone_no, evidence_detail, fileName, status);
                c.setUserId(user.getId());
                
                ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
                boolean f = dao.complaintRegister(c);
                
            if (f) {
               out.println("<html><head><script type='text/javascript'>");
               out.println("alert('Complaint register successful!');");
               out.println("window.location.href='displayComplaint.jsp'");
               out.println("</script></head></html>");
            } else {
               out.println("<html><head><script type='text/javascript'>");
               out.println("alert('Something went wrong!');");
               out.println("window.location.href='displayComplaint.jsp'");
               out.println("</script></head></html>");
}
            } else {
                out.println("<html><head><script type='text/javascript'>");
                out.println("alert('User does not exist!');");
                out.println("window.location.href='regComplaint.jsp'");
                out.println("</script></head></html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(regComplaintServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}

   
    
}
