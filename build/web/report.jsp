
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_report", "root", "111");

    Statement st = con.createStatement();
%>

<center>
    <!-- Area-wise Crime Count -->
    <h2>Area-wise Crime Count</h2>
    <table border="1">
        <tr>
            <th>Crime Area</th>
            <th>Crime City</th>
            <th>Crime Type</th>
            <th>crime_count</th>
            <th>area_count</th>
            <th>type_count</th>
        </tr>

        <%
            ResultSet rs = st.executeQuery("SELECT icity, area, tcrime, COUNT(*) AS crime_count, COUNT(DISTINCT area) AS area_count, COUNT(DISTINCT tcrime) AS type_count FROM Complaint1 WHERE icity=? AND date_record BETWEEN ? AND ? GROUP BY icity, area, tcrime");
            while (rs.next()) {
        %>
                <tr>
                    <td><%= rs.getString("area") %></td>
                    <td><%= rs.getString("icity") %></td>
                    <td><%= rs.getString("tcrime") %></td>
                    <td><%= rs.getInt("crime_count") %></td>
                    <td><%= rs.getInt("area_count") %></td>
                    <td><%= rs.getInt("type_count") %></td>
                </tr>
        <%
            }
}   catch(Exception e){

}
        %>
    </table> 
    </body>
</html>
