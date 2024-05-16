/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.conn.DbConnect;
import com.dao.AdminDao;
import com.entities.Admin;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminreg")
public class adminregservlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String email = request.getParameter("email");
String password = request.getParameter("password");
String code = request.getParameter("code");

AdminDao dao = new AdminDao(DbConnect.getConn());

// Check if there are any entries in the database table
if (dao.isAdminTableEmpty()) {
    // If the table is empty, proceed with registration
    Admin a = new Admin(email, password, code);
    boolean f = dao.adminReg(a);

    HttpSession session = request.getSession();

    if ("10AT11".equals(code)) {
        if (f) {
            session.setAttribute("successMsg", "Admin Registered Successfully");
            response.sendRedirect("adminreg.jsp");
        }
    } else {
        session.setAttribute("errorMsg", "Invalid code");
        response.sendRedirect("adminreg.jsp");
    }
} else {
    // If the table is not empty, display a message indicating that the admin is already registered
    HttpSession session = request.getSession();
    session.setAttribute("errorMsg", "Admin is already registered");
    response.sendRedirect("register.jsp");
}

    }
}
