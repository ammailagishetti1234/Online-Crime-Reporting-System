
package com.servlet;

import com.conn.DbConnect;
import com.dao.FIRDao;
import com.entities.FIR;
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

@WebServlet("/displayfirregch")
public class displayfirregch extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        
        String id = request.getParameter("id");
       System.out.println(id);
       if (id != null && !id.isEmpty()) {
            try {
                int fid = Integer.parseInt(id);
                System.out.println("idParam: " + fid);
                session.setAttribute("fid", fid);
                
                FIRDao dao = new FIRDao(DbConnect.getConn());
                List<FIR> fircomp = dao.getAccptedFIR(fid);
                request.setAttribute("firList", fircomp);
                
//                RequestDispatcher dispatcher = request.getRequestDispatcher("chargesheet.jsp");
//                dispatcher.forward(request, response);
response.sendRedirect("chargesheet.jsp?fid=" + fid);
            } catch (SQLException ex) {
                Logger.getLogger(displayfirregch.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
}
