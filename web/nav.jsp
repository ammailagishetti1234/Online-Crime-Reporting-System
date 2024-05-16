<%-- 
    Document   : nav
    Created on : Apr 4, 2024, 9:44:17 PM
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
        <a class="nav-link" href="#"><span class="fa fa-institution"></span>Home</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="admin.jsp"><span class="fa fa-id-card"></span>DashBoard</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="addnews.jsp"><span class="fa fa-id-card"></span>News Update</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="displayadmin"><span class="fa fa-institution"></span>View Complaint</a>
      </li>
      <li class="nav-item active">
          <a class="nav-link" href="displayFIR.jsp"><span class="fa fa-id-card"></span>View FIR</a>
      </li>
     <li class="nav-item active">
        <a class="nav-link" href="displayAccptedFir.jsp"><span class="fa fa-institution"></span>View Chargesheet</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    
            <li class="nav-item">
                <a class="nav-link" href="https://www.facebook.com/onlinecrimemanagement/posts/study-existing-system-the-existing-system-is-manual-the-data-is-maintained-in-re/682194725188391/" target="_blank">
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
