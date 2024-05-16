/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.entities.Complaint;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crimeServlet")
public class crimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//           String icity=req.getParameter("icity");
//            LocalDate localDate = LocalDate.now();
//            java.sql.Date start_date = java.sql.Date.valueOf(localDate);
//            java.sql.Date end_date = java.sql.Date.valueOf(localDate);
           ComplaintDao c = new ComplaintDao();
        List<Complaint> list = null;
        try {
            list = c.getAllCrimeData();
        } catch (SQLException ex) {
            Logger.getLogger(crimeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("visual.jsp");
        dispatcher.forward(req, resp);
   }
}
