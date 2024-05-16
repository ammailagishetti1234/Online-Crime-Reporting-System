
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.entities.Admin;
import com.entities.Complaint;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/displaycomregfir")
public class displaycomregfir extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

       String idParam = request.getParameter("id");
       System.out.println("idParam: " + idParam);

    if (idParam != null && !idParam.isEmpty()) {
        int id = Integer.parseInt(idParam);
        System.out.println("idParam: " + id);
        session.setAttribute("complaintId", id);

        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
        List<Complaint> fircomp = dao.getComplaintFIR(id);
        request.setAttribute("complaintList", fircomp);

        RequestDispatcher dispatcher = request.getRequestDispatcher("regFir.jsp");
        dispatcher.forward(request, response);
    } else {
        System.out.println("id or fid is null or empty");
    }
    }
}
