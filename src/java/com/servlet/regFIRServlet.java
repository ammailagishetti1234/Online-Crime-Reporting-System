
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.FIRDao;
import com.entities.Complaint;
import com.entities.FIR;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/regfir")
public class regFIRServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            //int id1 = Integer.parseInt(request.getParameter("id"));
            String section = request.getParameter("section");
            String complaint_type = request.getParameter("comp_type");
            LocalDate localDate = LocalDate.now();
            Date regdate = Date.valueOf(localDate);
            String fir_detail = request.getParameter("fir");
            String start_date = request.getParameter("start_date");
            String end_date = request.getParameter("end_date");
            String status = request.getParameter("status");
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            HttpSession session = request.getSession();
            
            ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
            Complaint c = dao.getComplaintById(id);
            
            if(c!=null){
                FIR f  = new FIR(id, section, complaint_type, regdate, fir_detail, start_date, end_date, status);
                f.setId(c.getId());
                
                FIRDao dao1 = new FIRDao(DbConnect.getConn());
                boolean ans = dao1.firRegister(f);
                
                if(ans) {
                    session.setAttribute("successMsg", "FIR Registered Successfully");
                    response.sendRedirect("regFir.jsp?id=" + c.getId());
                } else {
                    session.setAttribute("errorMsg", "Something went wrong");
                    response.sendRedirect("regFir.jsp?id=" + c.getId());
                }
            }else{
                session.setAttribute("errorMsg", "User does not exist. Please register first.");
                response.sendRedirect("regFir.jsp?id=" + c.getId());
            }
    }
}
