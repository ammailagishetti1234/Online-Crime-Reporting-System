

<%@page import="com.entities.Police"%>
<%@page import="com.dao.FIRDao"%>
<%@page import="com.entities.FIR"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ComplaintDao"%>
<%@page import="com.entities.Complaint"%>
<%@page import="com.conn.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="allcomponet/allCss.jsp" %>
        <style>
        table {
        width: 60%; 
        max-width: 100%; 
        margin: auto;
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
     .btn-purple {
            background-color: purple;
            color: white;
            padding: 8px 16px;
            text-decoration: none;
            display: inline-block;
            border-radius: 4px;
        }
        </style>
        <%  
    ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
    List<Complaint> list = dao.getAccptedComplent(); 
%>
    </head>
    <body>
           <!--      admin navbar        -->
<%@include file="navbar.jsp"%>
  
<!--navbar-->
    <center><h1><b>FIR Details</b></h1></center>
        <table border='1'>
        <tr>
            <th>Id</th>
            <th>Police_Station</th>
            <th>Complainer Detail</th>
            <th>Complaint_details</th> 
            <th>Status</th>
            <th>PStatus</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <% 
            for(Complaint c: list) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getPolice_city() %><br><%= c.getPolice_state() %></td>
            <td><%= c.getName() %><br> <%=c.getEmail() %><br><%=c.getPhone_no() %> </td>
            
            <td><%= c.getComplaint_detail()  %></td>
            <td><%= c.getStatus()%></td>
            <td><%= c.getPstatus()%></td>
            
            <td>
            <% 
                int id = c.getId();
                FIRDao dao1 = new FIRDao(DbConnect.getConn());
                List<FIR> firList = dao1.isFIRregistered(id);
                if (firList != null && !firList.isEmpty()) {
            %>
                    <a href='' class='btn-purple'>View FIR</a>
            <%
                } else {
            %>
                    <a href='displaycomregfir?id=<%= c.getId() %>' class='btn-purple'>File FIR</a>
            <%
        }
           %>
            </td>
            
         
    <% } %>
        </table>
    </body>
</html>
