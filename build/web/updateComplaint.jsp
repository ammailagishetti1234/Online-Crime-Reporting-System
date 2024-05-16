<%@page import="com.entities.Admin"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.entities.Complaint"%>
<%@page import="com.dao.ComplaintDao"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="com.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <%@include file="allcomponet/allCss.jsp" %>
    <link href="allcomponet/style1.css" rel="stylesheet" type="text/css"/>
    <style>
       
        .custom-left-margin {
            margin-left: 70px; 
        }
    </style>
</head>
<body style="background-color: #FAFAFA;">
    <!-- admin navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark nav">
        <div class="collapse navbar-collapse" id="navbarNav">
            <% 
            User user = (User) session.getAttribute("user");
            Admin admin = (Admin) session.getAttribute("admin");

            if (user == null && admin == null) { %>
                <form class="form-inline my-2 my-lg-0 ml-auto">
                    <a href="index.jsp" class="btn btn-success">Login</a>
                    <a href="register.jsp" class="btn btn-danger ml-2">Register</a>
                </form>
            <% } else if (user != null) { %>
                <form class="form-inline my-2 my-lg-0 ml-auto">
                    <a data-toggle="modal" data-target="#exampleModal" class="btn btn-success ml-2 text-white"><%= user.getName() %></a>
                    <a data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-danger ml-2 text-white">LogOut</a>
                </form>
            <% } else if (admin != null) { %>
                <form class="form-inline my-2 my-lg-0 ml-auto">
                    <a data-toggle="modal" data-target="#exampleModal" class="btn btn-success ml-2 text-white"><%= admin.getEmail() %></a>
                    <a data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-danger ml-2 text-white">LogOut</a>
                </form>
            <% } %>
        </div>
    </nav>

      
        
       <script>
    function validatePhone() {
        var phoneInput = document.getElementById("inputphone1").value;
        var isValidPhone = /^\d{10}$/; // Assuming a 10-digit phone number

        if (!isValidPhone.test(phoneInput)) {
            alert("Please enter a valid 10-digit phone number.");
            return false;
        }

        return true;
    }
</script>

    <!-- For admin -->
    <% 
//       String email = (String) session.getAttribute("email");
//   String password = (String) session.getAttribute("password");
//
       String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
        Complaint c=dao.getComplaintById(id);
            %>
            <main class="p-15" style="padding-bottom: 50px;">
                <div class="container">
                    <div class="row justify-content-end">
                        <div class="col-md-11 mt-4 ml-auto"> 
                            <div class="card mx-auto">
                                <div class="card-header text-center text-black">
                                    <h3>
                                        Register Complaint here
                                    </h3>
                                </div>
                                <div class="card-body">
                                    <form action="updatecom" method="POST" onsubmit="return validatePhone()">
                                        <input type="hidden" name="id">
                                        <input type="hidden" name="uid">
                             <div class="form-row">
                            <div class="form-group col-md-4">
                                <input type="text" name="name" class="form-control" id="inputname1" placeholder="Your Name" value="<%= c.getName() %>" >
                            </div>
                            <div class="form-group col-md-4">
                                <input type="email" name="email" class="form-control" id="inputemail1" placeholder="Your Email" value="<%= c.getEmail() %>">
                            </div>
                            <div class="form-group col-md-4">
                                <input type="text" name="phone_no" class="form-control" id="phone_no" placeholder="Your Phone No" value="<%= c.getPhone_no() %>">
                            </div>
                         </div>
                                    
                            
                            <div class="form-row">
                            <div class="form-group col-md-6">
                               <textarea class="form-control" name="police_station" id="exampleFormControlTextarea1" rows="3" placeholder="Police_Station State <% out.println(); %>Police_Station City"><%= c.getPolice_city() %></textarea>
                            </div>
                            <div class="form-group col-md-6">
                               <textarea class="form-control" name="complaint_detail" id="exampleFormControlTextarea1" rows="3" placeholder="Complaint Title <% out.println(); %>Complaint Detail"><%= c.getComplaint_detail() %></textarea>
                            </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                <select id="inputarea" name="area" class="form-control" placeholder="Area" value="<%= c.getArea() %>">
                                  <option>Bandra</option>
                                  <option>Dadar</option>
                                  <option>Lajpat Nagar</option>
                                  <option>Chanakyapuri</option>
                                  <option>Jayanagar</option>
                                  <option>Indiranagar</option>
                                  <option>Mylapore</option>
                                  <option>Adyar</option>
                                  <option>Howrah</option>
                                  <option>Park Street</option>
                                </select>
                                </div>
                                
                                <div class="form-group col-md-3">
                                <select id="inputcity" name="icity" class="form-control" placeholder="City" value="<%= c.getIcity() %>">
                                  <option>Mumbai</option>
                                  <option>Delhi</option>
                                  <option>Bangalore</option>
                                  <option>Chennai</option>
                                  <option>Kolkata</option>
                                </select>
                                </div>
                                
                                <div class="form-group col-md-3">
                                <select class="form-control" name="tcrime" value="<%= c.getTcrime() %>">
                                  <option>Theft</option>
                                  <option>Burglary</option>
                                  <option>Assault</option> 
                                  <option>Robbery</option>
                                  <option>Fraud</option>
                                  <option>Cyber crime</option>
                                  <option>Homicide</option>
                                  <option>Drug Offense</option>
                                </select>
                                </div>
                                
                                <div class="form-group col-md-3">
                                  <input type="date" class="form-control" name="date" id="exampleInputdate1" step="1" value="<%= c.getDate() != null ? c.getDate().toLocalDate().toString() : "" %>">

                                </div>
                            </div>
                            
                            <div class="form-row">
                            <div class="form-group col-md-6">
                               <textarea class="form-control" name="accused_detail" id="exampleFormControlTextarea1" rows="3" placeholder="Accused Name <% out.println(); %>Victim Address <% out.println(); %>Accused Ph_no"><%= c.getAccused_detail() %></textarea>
                            </div>
                            <div class="form-group col-md-6">
                               <textarea class="form-control" name="victim_detail" id="exampleFormControlTextarea1" rows="3" placeholder="Victim Name <% out.println(); %>Victim Address <% out.println(); %>Victim Ph_no"><%= c.getVictim_detail() %></textarea>
                            </div>
                            </div>
                            
                            <div class="form-row">
                            <div class="form-group col-md-12">
                               <textarea class="form-control" name="evidence_detail" id="exampleFormControlTextarea1" rows="3" placeholder="Any Evidence"><%= c.getEvidence_detail() %></textarea>
                            </div>
                            </div>
                            <div>
                                        
                                                <select id="inputState" class="form-control" name="status">
                                                    <option>Pending</option>
                                                    <option>Active</option>
                                                    <option>In Progress</option>
                                                </select>
                                         
                                             </div>
                            <br>
                            <button class="btn btn-success">Edit </button>
                           
                                    </form>
                            
                               </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        <% %>

</body>
</html>
