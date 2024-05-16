
<%@page import="com.dao.NewsDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.News"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.entities.User"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    <%@include file="allcomponet/allCss.jsp" %>
    
    <style type="text/css">
        body{
            style: "background-color: #f7faf8;"
        }
        html, body {
        height: 100%;
        margin: 0;
    }

    .back-img {
        background: url("img/t2.jpg");
        width: 100%;
        height: 50%;
        background-repeat: no-repeat;
        background-size: cover; 
        display: flex;
        justify-content: center;
        align-items: center; 
    }
   .news-section {
    max-width: 650px; /* Adjust the width according to your preference */
    margin-right: 0px; /* No margin on the right */
    margin-bottom: 1px; /* Add 1px margin to create a gap */
    margin-left: 0px; /* No margin on the left */
}

.login-card {
    max-width: 450px;
    margin: 0 auto;
    margin-left: 0px;
    margin-bottom: 0; /* Remove the bottom margin */
}

 .container {
        max-width: 2500px; /* Set the maximum width as needed */
        margin-left: auto;
        margin-right: auto;
    }
    .about-us {
    margin-left: 0px;
    margin-right: 0px;
    margin-top: 0; /* Remove the top margin */
}
.card-single {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    background: #fff;
    
    border-radius: 10px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* Increased shadow */
    transition: box-shadow 0.3s;
    
}
@keyframes slideIn {
    0% { transform: translateY(-100%); }
    100% { transform: translateY(0); }
}

.welcome-slide, .slogan-slide {
    animation: slideIn 1.2s ease-out forwards;
}

.slogan-slide {
    animation-delay: 0.2s;
}
    </style>
    </head>
    <body>
      
                <!--      navbar        -->
<%@include file="normal_navbar.jsp" %>


<!--banner-->

<div class="container-fluid p-0 m-0 back-img">
    
    <div >
        <div class="container" style="color: white;"><br><br>
            <div class="welcome-slide">
            <h3 class="display-4" style="font-family: Arial Rounded MT Bold;">Welcome to, </h3>
            <h3 class="display-4" style="font-family: Arial Rounded MT Bold;">Online Crime Management System</h3><br>
            </div>
            <div class="slogan-slide">
        <h3 style="color: white; font-family: Algerian;">WE REPORT || EVERY CRIME || EVERY TIME</h3>
            </div>
        
        <a href="index.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span>Login</a>
         <a href="register.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-plus"></span>Sign Up</a>
         <a href="adminreg.jsp" class="btn btn-outline-light btn-lg"><span class="fa fa-user-circle fa-spin"></span>Admin Sign Up</a>
        </div>
    </div>
</div>
<!-- cards -->
<br>

<div class="">
 <div class="container">
<div class="row">
   
  <div class="col-md-8 news-section card-single" >
    <div class="card">
      <div class="card-body">
          <i><h3 class="card-title" style="font-family: Algerian;">Our Early News</h3></i>
        <%
    try {
        NewsDAO newsDAO = new NewsDAO(DbConnect.getConn());
        List<News> newsList = newsDAO.getAllNews();

        for (News news : newsList) {
%>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= news.getTitle() %></h5>
                    <p class="card-text"><strong>Date:</strong> <%= news.getDate_time() %></p>
                    <p class="card-text"><%= news.getContent() %></p>
                </div>
            </div>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

      </div>
    </div>
  </div>
   

  <div class="col-md-4 login-card card-single" >
    <div class="card">
      <div class="card-body">
        <h4 class="text-center text-dark" style="font-family: Algerian;">Login Page</h4>
        <hr>
         <% 
           String InvalidMsg = (String)session.getAttribute("InvalidMsg");
           if(InvalidMsg!=null)
           {
               %>
               <p class="text-danger text-center"> <%=InvalidMsg %> </p>
               <%
                   session.removeAttribute("InvalidMsg");
           }
        %>
        
        <% 
           String logMsg = (String)session.getAttribute("logMsg");
           if(logMsg !=null)
           {
               %>
               <p class="text-success text-center"> <%=logMsg %> </p>
               <%
                   session.removeAttribute("logMsg");
           }
        %>
        
        <% 
           String logMsg1 = (String)session.getAttribute("logMsg1");
           if(logMsg1 !=null)
           {
               %>
               <p class="text-success text-center"> <%=logMsg1 %> </p>
               <%
                   session.removeAttribute("logMsg1");
           }
        %>
     
        <form id="reg-form" action="Login" method="POST">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" name="ps1" id="exampleInputPassword1" required>
            </div>
            <div class="form-group">
            <label for="userType">Register as:</label>
    <select id="userType" name="userType">
        <option value="admin">Admin</option>
        <option value="user">User</option>
    </select>
            </div>
            <br>
            <div class="container text-center">
            <button  type="submit" class="btn btn-primary primary-background">Submit</button>
            </div>
        </form>
    </div>
  </div>
</div>
        
        <div class=" col-md-3 about-us card-single">
            <div class="card">
            <div class="card-body">
                <h4 class="text-center text-dark" style="font-family: Algerian;">About Us</h4><hr>
            <p>
                Welcome to our Crime Management System, where our mission is to create a safer and more secure community for all.
                At Crime Management System, we are dedicated to providing a comprehensive and efficient platform for reporting, 
                managing, and addressing criminal activities. Our team is committed to leveraging technology to empower law enforcement 
                agencies and citizens alike, fostering a collaborative approach to crime prevention and resolution. 
                fear.
            </p>
            </div>
            </div>
        </div>
     </div>
</div>
</div>

    </body>
</html>
