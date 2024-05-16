
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

@WebServlet("/displayfiruser")
public class displayfiruser extends HttpServlet {
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        
        int userId = (int) session.getAttribute("userId");
        
        FIRDao dao = new FIRDao(DbConnect.getConn());
        List<FIR> userFir = null;
        
        try {
        userFir = dao.getFIRByUserId(userId);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        request.setAttribute("userFir", userFir);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayfiruser.jsp");
        dispatcher.forward(request, response);
        
     }
    
}
