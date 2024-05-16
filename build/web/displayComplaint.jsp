<%@page import="java.util.regex.Pattern"%>
<%@page import="com.entities.User"%>
<%@ page import="java.util.List" %>
<%@ page import="com.entities.Complaint" %>
<%@ page import="com.conn.DbConnect" %>
<%@ page import="com.dao.ComplaintDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Complaint</title>
    
    <%@include file="allcomponet/allCss.jsp" %>
    <link href="allcomponet/style1.css" rel="stylesheet" type="text/css"/>
    
    <%
    
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("index.jsp");
    }
%>
    
    <style>
    body {
        text-align: center;
    }

    h2 {
        color: #333; /* Text color */
        background-color: #f2f2f2; /* Background color */
        padding: 10px; /* Padding for spacing */
        border-radius: 5px; /* Optional: Rounded corners */
    }

    table {
        margin: 0 auto;
        width: 80%; /* Adjust the width as needed */
        border-collapse: collapse;
        text-align: left;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 10px;
    }

    th {
        background-color: #4CAF50; /* Green color */
        color: white;
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
 .icon-container {
    background-color: white;
    border-radius: 50%;
    width: 20px;
    height: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 5px;
    position: relative;
}

.icon-container i {
    color: #007bff; /* Primary color for the icon */
}

.view-link {
    margin-left: 20px;
}

/* Optional: Add some hover effect */
.icon-container:hover {
    background-color: #007bff;
}

.icon-container:hover i {
    color: white;
}
</style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark nav" >
    <a class="navbar-brand"><span class="fa fa-plus-square"></span>Crime Reporting System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp"><span class="fa fa-institution"></span>Home</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="profile.jsp"><span class="fa fa-id-card"></span>DashBoard</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="display"><span class="fa fa-institution"></span>View Complaint</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="displayfiruser.jsp"><span class="fa fa-id-card"></span>View FIR</a>
      </li>
     <li class="nav-item active">
        <a class="nav-link" href="displaychargeuser.jsp"><span class="fa fa-institution"></span>View Chargesheet</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    
            <li class="nav-item">
                <a class="nav-link" href="#" target="_blank">
                    <div class="icon-container"><i class="fab fa-facebook-f"></i></div></a>
            </li>
             <li class="nav-item">
                <a class="nav-link" href="#" target="_blank">
                    <div class="icon-container"><i class="fab fa-twitter"></i></div></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" target="_blank">
                    <div class="icon-container"><i class="fab fa-instagram"></i></div></a>
            </li>
        </ul>
        <a href="LogOut" class="btn btn-danger">LogOut</a>
       
    </div>
    </nav>
   
        <br>
    <div class="back-img">
    <div class="container-fluid p-0 m-0" >
        <center><h1 class="card-title" style="font-family: Algerian; font-size: 60px;">COMPLAINT TABLE</1></center>
        </div>
    </div>
        <br>
        
    <table border='1'>
        <tr>
            <th>Id</th>
            <th>Police_Station</th>
            <th>Complainer Detail</th>
            <th>Complaint_details</th> 
            <th>Accused_detail</th>
            <th>Victim_detail</th>
            <th>Evidence_detail</th>
            <th>Status</th>
        </tr>

        <% 
    int userId = (int) session.getAttribute("userId");
    ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
    List<Complaint> list = dao.getComplaintDetails1(userId);

            for(Complaint c: list) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getPolice_city() %><br><%= c.getPolice_state() %></td>
            <td><%= c.getName() %><br> <%=c.getEmail() %><br><%=c.getPhone_no() %> </td>
            
            <td><%= c.getComplaint_detail()  %></td>
            <td><%= c.getAccused_name() %><br><%= c.getAccused_add() %><br><%= c.getAccused_phno() %></td>
            <td><%= c.getVictim_name() %><br><%= c.getVictim_add() %><br><%= c.getVictim_phno() %></td>
    <td>
    <%= c.getEvidence_detail() %><br>
   <% 
    String fileName = c.getFileName();
    
    if (fileName != null && !fileName.isEmpty()) {
        boolean isVideo = Pattern.compile("\\.mp4$", Pattern.CASE_INSENSITIVE).matcher(fileName).find();

        if (isVideo) { %>
            <video width="200" height="100" controls>
                <source src="videos/<%= fileName %>" type="video/mp4">
                Your browser does not support the video tag.
            </video>
        <% } else { %>
            <img alt="" src="images/<%= fileName %>" width="200px" height="100px"><br>
        <% }
    } else { %>
        <!-- Display default image when evidence file is empty -->
        <img alt="" src="images/default.png" width="200px" height="100px"><br>
    <% } %>
    
</td>

            <td><%= c.getStatus()%></td>
           
            
        </tr>
        <% } %>
    </table>
</body>
</html>
