
<%@page import="com.entities.Complaint"%>
<%@page import="com.dao.ComplaintDao"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <% 
        String icity = request.getParameter("icity");
        LocalDate localDate = LocalDate.now();
        java.sql.Date start_date = java.sql.Date.valueOf(localDate);
        java.sql.Date end_date = java.sql.Date.valueOf(localDate);
        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
        List<Complaint> list = dao.getCrimeReports(icity, start_date, end_date);
        %>
        
    </head>
    <body>
    <div class="center-table">
 <table border='1'>
        <tr>
            <th>Area</th> 
            <th>Crime Type</th>
            <th>Area Crime Count</th> 
            <th>Crime Type Count</th> 
        </tr>
        <%
            
if (list == null) {
    System.out.println("The list is null.");
} else { %>
    <% 
            for(Complaint c: list) {
        %>
        <tr>
            <td><%= c.getArea() %></td>
            <td><%= c.getTcrime() %></td>
            <td><%= c.getAreacrimecount()  %></td>
            <td><%= c.getTypecrimecount() %></td>
        </tr>
         <% } %>
        <%
}
%>
        
    </table>
    </div>
    </body>
</html>
   