
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.entities.Complaint;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/updateCom2")
public class updateCom2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            String cid=request.getParameter("id");
            int id=Integer.parseInt(cid);
            String uid=request.getParameter("uid");
            int id1=Integer.parseInt(uid);
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String phone_no=request.getParameter("phone_no");
            String police_city=request.getParameter("pcity");
            String police_state=request.getParameter("pstate");
            String complaint_detail=request.getParameter("complaint_detail");
            String area=request.getParameter("area");
            String icity=request.getParameter("icity");
            String tcrime=request.getParameter("tcrime");
            
            LocalDate localDate = LocalDate.now();
            java.sql.Date date = java.sql.Date.valueOf(localDate);
            
            String accused_name=request.getParameter("aname");
            String accused_add=request.getParameter("aadd");
            String accused_phno=request.getParameter("aphno");
            String victim_name=request.getParameter("vname");
            String victim_add=request.getParameter("vadd");
            String victim_phno=request.getParameter("vphno");
            String evidence_detail=request.getParameter("evidence_detail");
            String filename = request.getParameter("filename");
            Part filePart = request.getPart("files");
if (filePart != null) {
    String fileName = filePart.getSubmittedFileName();
//            Part filePart = request.getPart("files");
//String fileName = filePart.getSubmittedFileName();
String filePath = getServletContext().getRealPath("") + "images" + File.separator + fileName;

String path = getServletContext().getRealPath("") + "images";
//String path1 = getServletContext().getRealPath("") + "videos";

            String status=request.getParameter("status");
            
            Complaint c = new Complaint();
            c.setId(id);
            c.setUserId(id1);
            c.setName(name);
            c.setEmail(email);
            c.setPhone_no(phone_no);
            c.setPolice_city(police_city);
            c.setPolice_state(police_state);
            c.setComplaint_detail(complaint_detail);
            c.setArea(area);
            c.setIcity(icity);
            c.setTcrime(tcrime);
            c.setDate(date);
            c.setAccused_name(accused_name);
            c.setAccused_add(accused_add);
            c.setAccused_phno(accused_phno);
            c.setVictim_name(victim_name);
            c.setVictim_add(victim_add);
            c.setVictim_phno(victim_phno);
            c.setEvidence_detail(evidence_detail);
            c.setFileName(fileName);
            c.setPart(filePart);
            c.setStatus(status);
            
            ComplaintDao dao=new ComplaintDao(DbConnect.getConn());
            int s = dao.updateComp(c);
            if(s>0)
            {
                File file = new File(path);
                filePart.write(path+File.separator+fileName);
               out.println("<html><head><script type='text/javascript'>");
                    out.println("alert('Updated successful!');");
                    out.println("window.location.href='displayadmin?id=" + c.getId() + "';");
                    out.println("</script></head></html>");
            }else{
                out.println("<html><head><script type='text/javascript'>");
                        out.println("alert('Something Went Wrong!');");
                    out.println("window.location.href='displayadmin?id=" + c.getId() + "';");
                    out.println("</script></head></html>");
            }
} else {
    System.out.println("null");
}
        }
catch (SQLException ex) {
            Logger.getLogger(updateCom2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

}
    


