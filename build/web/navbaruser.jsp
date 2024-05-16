<%-- 
    Document   : navbar
    Created on : Feb 6, 2024, 1:29:20 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="allcomponet/allCss.jsp" %>
    <link href="allcomponet/style1.css" rel="stylesheet" type="text/css"/>
    
        <style>
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
    <a class="navbar-brand"><span class="fa fa-plus-square"></span>Crime Management System</a>
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
    </body>
</html>
