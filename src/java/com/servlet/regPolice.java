
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.PoliceDao;
import com.entities.Complaint;
import com.entities.Police;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/police")
public class regPolice extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("pname");
        String station = request.getParameter("station");
        //String city = request.getParameter("pcity");
        String designation = request.getParameter("designation");
        
        Part filePart = request.getPart("files");
        String fileName = filePart.getSubmittedFileName();
        String filePath = getServletContext().getRealPath("") + "image1" + File.separator + fileName;
        String path = getServletContext().getRealPath("") + "image1";
        
        String gender = request.getParameter("gender");
        String cont_no = request.getParameter("cont_no");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        
        
        HttpSession session = request.getSession();
        
        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
        Complaint c = dao.getComplaintById(id);
        
        if(c!=null){
            Police p = new Police(id, name, station, designation, fileName, gender, cont_no, email, status);
            p.setId(c.getId());
            
            PoliceDao dao1 = new PoliceDao(DbConnect.getConn());
             boolean ans = dao1.policeRegister(p);
             
             if(ans) {
                    out.println("<html><head><script type='text/javascript'>");
                     out.println("alert('Assigned Police successful!');");
                    out.println("window.location.href='displayadmin?id=" + c.getId() + "';");
                    out.println("</script></head></html>");
                      //System.out.println("Register");
                } else {
                    out.println("<html><head><script type='text/javascript'>");
                    out.println("alert('Something Went Wrong!');");
                    out.println("window.location.href='displayadmin?id=" + c.getId() + "';");
                    out.println("</script></head></html>");
                     // System.out.println("Not Register");
                }
            
        }else{
            
        }
    }
}
