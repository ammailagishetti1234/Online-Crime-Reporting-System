/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogOut")
public class LogoutServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        
        session.removeAttribute("user");
        
        HttpSession session2=req.getSession();
        session2.setAttribute("logMsg", "LogOut Succesfully..");
        
        session.removeAttribute("admin");
        session.invalidate();
        HttpSession session3=req.getSession();
        session3.setAttribute("logMsg1", "LogOut Succesfully..");
        resp.sendRedirect("index.jsp");
    }
    
}
