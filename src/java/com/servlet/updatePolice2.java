/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.conn.DbConnect;
import com.dao.PoliceDao;
import com.entities.Police;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upPolice2")
public class updatePolice2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String cid = request.getParameter("id");

            if (cid != null && !cid.isEmpty()) {
                try {
                    int id = Integer.parseInt(cid);

                    String status = request.getParameter("status");

                    Police p = new Police();
                    p.setId(id);
                    p.setPstatus(status);

                    PoliceDao dao = new PoliceDao(DbConnect.getConn());
                    int s = dao.updatePolice(p);

                    if (s > 0) {
                        out.println("<html><head><script type='text/javascript'>");
                        out.println("alert('Update successful!');");
                        out.println("window.location.href='displayadmin?" + "';");
                        out.println("</script></head></html>");
                    } else {
                        response.sendRedirect("upPolice2");
                    }
                } catch(Exception e){
             e.printStackTrace();
         } 
            } else {
                // Handle the case when "id" is not present in the request parameters.
                out.println("Invalid or missing 'id' parameter");
            }
             
         } catch(Exception e){
             e.printStackTrace();
         }
    }
}
