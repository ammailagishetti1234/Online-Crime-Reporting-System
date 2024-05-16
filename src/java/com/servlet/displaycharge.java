
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.FIRDao;
import com.dao.UserDAO;
import com.dao.chargesheetDao;
import com.entities.Complaint;
import com.entities.FIR;
import com.entities.chargesheet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaycharge")
public class displaycharge extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        
        //UserDAO dao1 = new UserDAO();
        ComplaintDao dao2 = new ComplaintDao(DbConnect.getConn());
        FIRDao dao3 = new FIRDao(DbConnect.getConn());
        chargesheetDao dao4 = new chargesheetDao(DbConnect.getConn());
        
        List<Complaint> complaint = dao2.getComplaintinfo();
        List<FIR> fir = dao3.getFIRinfo();
        List<chargesheet> charge = dao4.getChargeinfo();
        
        request.setAttribute("complaintList", complaint);
        request.setAttribute("firList", fir);
        request.setAttribute("chargeList", charge);
        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/displaycharge.jsp");
//        dispatcher.forward(request, response);
    }
    
}
