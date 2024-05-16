
package com.servlet;

import com.conn.DbConnect;
import com.dao.FIRDao;
import com.entities.FIR;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateFIR2")
public class updateFIR2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            PrintWriter out=response.getWriter();
            
//            int id = Integer.parseInt(request.getParameter("fid"));
              String fidParameter = request.getParameter("fid");
            if (fidParameter != null && !fidParameter.isEmpty()) {
                int id = Integer.parseInt(fidParameter);
            String status = request.getParameter("status");
            
            FIR f = new FIR();
            
            f.setFid(id);
            f.setStatus(status);
            
            FIRDao dao = new FIRDao(DbConnect.getConn());
            int s = dao.updateFIR(f);
            if (s > 0) {
                    out.println("<html><head><script type='text/javascript'>");
                    out.println("alert('Updated FIR successful!');");
                    out.println("window.location.href='displayFIR.jsp';");
                    out.println("</script></head></html>");
                } else {
                    out.println("<html><head><script type='text/javascript'>");
                    out.println("alert('Something went wrong!');");
                    out.println("window.location.href='displayFIR.jsp';");
                    out.println("</script></head></html>");
                }
          } else {
                out.println("Invalid FIR ID");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
