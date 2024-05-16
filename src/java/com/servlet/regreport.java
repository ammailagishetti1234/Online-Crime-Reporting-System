
package com.servlet;

import com.conn.DbConnect;
import com.dao.FIRDao;
import com.dao.chargesheetDao;
import com.dao.reportDao;
import com.entities.FIR;
import com.entities.chargesheet;
import com.entities.report;
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
import javax.servlet.http.Part;

@WebServlet("/report")
@MultipartConfig
public class regreport extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            PrintWriter out = response.getWriter();
            
            String fidParam = request.getParameter("fid");
            String chidParam = request.getParameter("chid");
            String cidParam = request.getParameter("cid");
            
            System.out.println("fidParam: " + fidParam);
            System.out.println("chidParam: " + chidParam);
            System.out.println("cidParam: " + cidParam);
            
            if (chidParam != null && fidParam != null) {
                int fid = Integer.parseInt(fidParam);
                int id = Integer.parseInt(chidParam);
                int cid = Integer.parseInt(cidParam);
                
                // Fetch FIR and charegsheet entities from the database
                FIRDao firDao = new FIRDao(DbConnect.getConn());
                chargesheetDao chargesheetDao = new chargesheetDao(DbConnect.getConn());
                
                chargesheet ch = chargesheetDao.getchargesheetById(id);
                FIR f = firDao.getFIRById(fid);
                
                if (f != null && ch != null) {
                  LocalDate localDate = LocalDate.now();
                  java.sql.Date date = java.sql.Date.valueOf(localDate); 
                  String pname = request.getParameter("name");
                  String section = request.getParameter("section");
                  String cdetail = request.getParameter("cdetail");
                  String padd = request.getParameter("address");
                  String note = request.getParameter("note");
                  
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
                  
                  // Create a new report object
                  report r = new report(date, pname, section, cdetail, padd, fileName, note);
                  
                  System.out.println("File name: " + fileName);
                  
                   // Set the IDs for the report
                   r.setChid(ch.getId());
                   r.setRId(f.getFid());
                   
                    // Save the report to the database
                    reportDao dao1 = new reportDao(DbConnect.getConn());
                    
                    System.out.println("File name: " + fileName);
                    boolean ans = dao1.regreport(r);
                    
                    System.out.println("File name: " + fileName);
                    
            if (ans) {
                out.println("<html><head><script type='text/javascript'>");
out.println("alert('Report Generated Successfully!!!');");
out.println("window.location.href='viewreport.jsp?reportId=" + r.getRId() + "'");
out.println("</script></head></html>");

            } else { 
                out.println("<html><head><script type='text/javascript'>");
                out.println("alert('Something went wrong!');");
                out.println("window.location.href='displayaccptedcharge.jsp'");
                out.println("</script></head></html>");
            }
            }
            else {
            out.println("<html><head><script type='text/javascript'>");
            out.println("alert('FIR or Complaint does not exist!');");  
            out.println("window.location.href='displayaccptedcharge.jsp'");
            out.println("</script></head></html>");
          }
            } else {
             out.println("<html><head><script type='text/javascript'>");
        out.println("alert('FIR or Complaint ID missing!');");
        out.println("window.location.href='displayaccptedcharge.jsp'");
        out.println("</script></head></html>");
    }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
}
