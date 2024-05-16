<%-- 
    Document   : displayaccpted charge
    Created on : Feb 12, 2024, 3:00:14 AM
    Author     : lenovo
--%>

<%@page import="com.entities.report"%>
<%@page import="com.dao.reportDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.chargesheet"%>
<%@page import="com.dao.chargesheetDao"%>
<%@page import="com.conn.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
  body {
        text-align: center;
    }

    h2 {
        color: #333; 
        background-color: #f2f2f2; 
        padding: 10px; 
        border-radius: 5px; 
    }

    .center-table {
        margin: 60px;
        width: 80%;
        text-align: center;
        /*overflow-x: auto;*/ 
    }

    table {
        width: 100%; 
        max-width: 100%; 
        border-collapse: collapse;
        text-align: center;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
    }

    th {
        background-color: #4CAF50; 
        color: white;
    }
   .btn-p1 {
    background-color: purple;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
    text-decoration: none; /* Remove default underline for links */
    display: inline-block; /* Ensures proper inline display */
}

.back-img {
    background: url("img/c4.png");
    width: 100%;
    height: 30%; /* Set the height to 30% of the viewport */
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center; /* Position the background image in the center */
    display: flex;
    justify-content: center;
    align-items: center;
    }
</style>
    </head>
    <body>
        <%@include file="navbar.jsp"%> <br>
        <br>
    <div class="back-img">
    <div class="container-fluid p-0 m-0" >
        <center><h1 class="card-title" style="font-family: Algerian; font-size: 60px;">REPORT</1></center>
    </div>
    </div>
        <br>
        <div class="center-table">
    <table border='1'>
        <%
            chargesheetDao dao2 = new chargesheetDao(DbConnect.getConn());
            List<chargesheet> list = dao2.getAccptedcharge();
        %>
        
        <tr>
            <th>FIR Id</th>
            <th>chargesheet Id</th>
            <th>Section</th>
            <th>Brief Description</th>
            <th>Chargesheet Report</th>
            <th>Chargesheet Date</th>
            <th>Chargesheet Status</th>
        </tr>
       <% 
            for(chargesheet ch: list) {
        %>
        
        <tr>
         <td><%= ch.getId() %></td> 
         <td><%= ch.getFid() %></td> 
         <td><%= ch.getSection() %></td> 
         <td><%= ch.getBriefdesc() %></td> 
         <td><%= ch.getBriefdesc() %></td> 
         <td><%= ch.getDate() %></td> 
         <td><%= ch.getStatus() %></td>
         
         
          <%
    int id = ch.getId();
    reportDao dao1 = new reportDao(DbConnect.getConn());
    List<report> reList = dao1.isReportReg(id);
    if (reList != null && !reList.isEmpty()) {
        for (report r : reList) {
%>
            
                <td>
                    <a href='viewreport.jsp?reportId=<%= r.getRId() %>' class='btn-purple'>View Report</a>
                </td>
            
<%
        }
    } else {
%>
            
                <td>
                    <a href='report1.jsp?id=<%= ch.getId() %>' class='btn-purple'>File report</a>
                </td>
            </tr>
<%
    }
%>

<% } %>
    
    </table>
        </div>
    </body>
</html>
