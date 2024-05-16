
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.FIRDao;
import com.dao.chargesheetDao;
import com.entities.Complaint;
import com.entities.FIR;
import com.entities.chargesheet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/chargesheet")
@MultipartConfig
public class regchargesheet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        try {
    PrintWriter out = response.getWriter();
    String cidParam = request.getParameter("cid");
    String fidParam = request.getParameter("fid");

    System.out.println("fidParam: " + fidParam);
    System.out.println("cidParam: " + cidParam);

    if (cidParam != null && fidParam != null) {
        int fid = Integer.parseInt(fidParam);
        int cid = Integer.parseInt(cidParam);

        // Fetch FIR and Complaint entities from the database
        FIRDao firDao = new FIRDao(DbConnect.getConn());
        ComplaintDao complaintDao = new ComplaintDao(DbConnect.getConn());
        
        FIR f = firDao.getFIRById(fid);
        Complaint co = complaintDao.getComplaintById(cid);

        if (f != null && co != null) { 
            String section = request.getParameter("section");
            String brief = request.getParameter("brief");
            String filename = request.getParameter("files");
            String off = request.getParameter("off");
            String acc = request.getParameter("accu");
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            String status = request.getParameter("status");

            // Handling file upload
            Part filePart = request.getPart("files");
            String fileName = null;

            if (filePart != null && filePart.getSize() > 0) {
                fileName = filePart.getSubmittedFileName();
                String filePath = getServletContext().getRealPath("") + "images" + File.separator + fileName;
                String path = getServletContext().getRealPath("") + "images";

                File file = new File(path);
                filePart.write(path + File.separator + fileName);
            }

            // Create a new chargesheet object
            chargesheet c = new chargesheet(fid, section, brief, fileName, off, acc, date, status, cid);

            // Set the IDs for the chargesheet
            c.setId(f.getFid());  // Assuming fid is the correct ID for FIR
            c.setCid(co.getId()); // Set the Complaint ID for chargesheet

            // Save the chargesheet to the database
            chargesheetDao dao1 = new chargesheetDao(DbConnect.getConn());
            boolean ans = dao1.chargesheetreg(c);

            if (ans) {
                // Redirect to success page if registration is successful
                out.println("<html><head><script type='text/javascript'>");
                out.println("alert('Chargesheet registered successfully!');");
                out.println("window.location.href='displayAccptedFir.jsp'");
                out.println("</script></head></html>");
            } else {
                // Display error message if registration fails
                out.println("<html><head><script type='text/javascript'>");
                out.println("alert('Something went wrong!');");
                out.println("window.location.href='displayAccptedFir.jsp'");
                out.println("</script></head></html>");
            }
        } else {
            // FIR or Complaint does not exist
            out.println("<html><head><script type='text/javascript'>");
            out.println("alert('FIR or Complaint does not exist!');");
            out.println("window.location.href='displayAccptedFir.jsp'");
            out.println("</script></head></html>");
        }
    } else {
        // Parameters are missing
        out.println("<html><head><script type='text/javascript'>");
        out.println("alert('FIR or Complaint ID missing!');");
        out.println("window.location.href='displayAccptedFir.jsp'");
        out.println("</script></head></html>");
    }
} catch (Exception e) {
    e.printStackTrace();
}

    }
}
