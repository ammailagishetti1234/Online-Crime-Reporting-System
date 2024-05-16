<%-- 
    Document   : displaychargeuser
    Created on : Apr 2, 2024, 4:26:42 AM
    Author     : lenovo
--%>

<%@page import="com.entities.chargesheet"%>
<%@page import="java.util.List"%>
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
        margin: 50px;
        width: 90%;
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
    .btn-primary {
    background-color: purple;
    /* You can customize other styles as needed */
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
        <%@include file="navbaruser.jsp" %>
        
        <br>
    <div class="back-img">
    <div class="container-fluid p-0 m-0" >
        <center><h1 class="card-title" style="font-family: Algerian; font-size: 60px;">CHARGESHEET DETAILS</1></center>
        </div>
    </div>
        
        <div class="center-table">
    <table border='1'>
        <tr>
            <th>Chargesheet No</th>
            <th>FIR No</th>
            <th>Date of chargesheet</th>
            <th>Section</th>
            <th>Brief Description</th>
            <th>Status</th>
        </tr>
        
        <% 
           int userId = (int) session.getAttribute("userId");
           chargesheetDao dao = new chargesheetDao(DbConnect.getConn());
           List<chargesheet> list = dao.getChargesheetByUser(userId);
           
           for(chargesheet ch: list) {
        %>
        <tr>
            <td><%= ch.getId() %></td>
            <td><%= ch.getFid() %></td>
            <td><%= ch.getDate() %></td>
            <td><%= ch.getSection() %></td>
            <td><%= ch.getBriefdesc() %></td>
            <td><%= ch.getStatus() %></td>
        </tr>
        <% } %>
    </table>
        </div>
        
        
    </body>
</html>
