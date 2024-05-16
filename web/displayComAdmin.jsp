<%@page import="com.entities.Police"%>
<%@page import="com.dao.PoliceDao"%>
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
        margin: 40px;
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
    .btn-purple {
    background-color: purple;
    /* You can customize other styles as needed */
}
.back-img {
        background: url("img/fir.jpg");
        width: 100%;
        height: 10%;
        background-repeat: no-repeat;
        background-size: cover; 
        display: flex;
        justify-content: center;
        align-items: center; 
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
<%  
    ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
    List<Complaint> list = dao.getComplaintinfo(); 
    User user = (User) session.getAttribute("user");
        
%>
</head>
<body>
    
      <!--      navbar        -->
<%--<%@include file="navbar.jsp" %>--%>
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

<div class="center-table">
    <table border='1'>
        <tr>
            <th>Id</th>
            <th>User_Id</th>
            <th>Police_Station</th>
            <th>Complainer Detail</th>
            <th>Complaint_details</th> 
            <th>Accused_detail</th>
            <th>Victim_detail</th>
            <th>Evidence_detail</th>
            <th>Status</th>
            <th>PStatus</th>
            <th>Edit</th>
        </tr>

        <% 
            for(Complaint c: list) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getUserId() %></td>
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
        <img alt="" src="img/default.png" width="200px" height="100px"><br>
    <% } %>
</td>
            </td>
            <td><%= c.getStatus()%></td>
            <td><%= c.getPstatus()%></td>

<!-- Modal -->
<div class="modal fade" id="exampleModal<%= c.getId() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
    <div class="modal-content" style="width: 600px;">
      <div class="modal-header bg-primary">
          <center><h5 class="modal-title text-light" id="exampleModalLabel">Complaint Detail</h5></center>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <center><b><%= c.getPolice_city() %><br><%= c.getPolice_state() %><br></b></center><br><hr>
          <div class="form-row">
              <div class="form-group col-md-6">
              <b>Accused Detail:</b><br>
              <%= c.getAccused_name() %><br><%= c.getAccused_add() %><br><%= c.getAccused_phno() %>
              </div>
              <div class="form-group col-md-6">
              <b>Victim Detail:</b><br>
              <%= c.getVictim_name() %><br><%= c.getVictim_add() %><br><%= c.getVictim_phno() %>
              </div>
          </div><hr>
          <div class="form-row">
              <div class="form-group col-md-6">
              <b>Complainer Detail:</b><br>
              <%= c.getName() %><br><%= c.getEmail() %><br><%= c.getPhone_no() %>
              </div>
              <div class="form-group col-md-6">
                  <b>Police Station Response:</b><br>
                  Complaint Type:<%= c.getTcrime() %><br>
                  Note From Police Station:<br>
                  Complaint Status:<%= c.getStatus()%>
              </div>
          </div><hr>
          <div class="form-row">
              <div class="form-group col-md-12" style="text-align: left;">
                  <b>Complaint: </b> <%= c.getComplaint_detail()  %>
              </div>
          </div>
    <div class="form-row">
    <div class="form-group col-md-12" style="text-align: left;">
        <b>Evidence Detail:</b><br>
    </div>
</div>
<div class="form-row">
                    <br>
                    <div class="form-group col-md-6">
                        <!-- Display image -->
                        <img alt="" src="images/<%= fileName %>" class="img-fluid rounded" width="100%" height="auto">
                    </div>
                    <div class="form-group col-md-6">
                        <!-- Display video -->
                        <div class="embed-responsive embed-responsive-16by9">
                            <video class="embed-responsive-item" controls>
                                <source src="videos/<%= fileName %>" type="video/mp4">
                            </video>
                        </div>
                    </div>
 </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
<!--        <a href='displaycomregfir?id=<%= c.getId() %>' class='btn btn-primary'>File FIR</a>-->
      </div>
    </div>
  </div>
</div>
        
        <td>
          <% 
                if (c.getPstatus() != null) {
            %>
                    <a href='upPolice?id=<%= c.getId() %>' class="btn btn-success text-white">Police</a>
            <%
                } else {
            %>
                    <a href='assignPolice.jsp?id=<%= c.getId() %>' class="btn btn-success text-white">Add</a>
            <%
        }
%><br><br>
          <a data-toggle="modal" data-target="#exampleModal<%= c.getId() %>" class="btn btn-primary text-white">View</a>
        </td>
        <script>
    function submitForm(id) {
        // Create a form
        var form = $('<form action="updateCom1" method="post"></form>');

        form.append('<input type="hidden" name="id" value="' + id + '">');

        $('body').append(form);
        form.submit();
    }
</script>


           <td>
               <a href="#" class="btn btn-danger" onclick="submitForm('<%= c.getId() %>')">Edit</a><br><br>
               
           </td>
        </tr>
        <% } %>
        
    </table>
</div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" 
integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
crossorigin="anonymous"></script>

</body>
</html>
