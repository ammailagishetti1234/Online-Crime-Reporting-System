

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
        body {
         text-align: center;
        }
         .center-container {
            text-align: left;
            display: inline-block;
        }
         .center-container {
            text-align: left;
            display: inline-block;
            margin: 0 auto; 
            width: 80%; 
            border: 1px solid #ddd; 
            padding: 20px; 
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-column {
            width: 60%;
            display: inline-block;
            vertical-align: top;
        }
        .image-column {
            width: 35%;
            display: inline-block;
            vertical-align: top;
            padding-left: 5%; /* Add some spacing between the columns */
        }

        </style>
    </head>
    <body>
         <!--      admin navbar        -->
<%@include file="navbar.jsp"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
   ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
    Complaint c = dao.getComplaintById(id); 
%>
<div class="center-container">
       <div class="form-column">
           <center><h3>Assign police</h3></center>
    <form action="police" method="POST" enctype="multipart/form-data">
  <div class="form-group row">
      <input type="hidden" name="id" value="<%= c.getId() %>">
       <input type="hidden" name="pid">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Name:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="pname" id="inputEmail3">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Station:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="station" id="inputPassword3">
    </div>
  </div>
<div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Gender</label>
      <select id="inputState" class="col-sm-10" name="gender">
          <option>--</option>
        <option>Male</option>
        <option>Female</option>
        </select>
    </div>
   <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Designation:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="designation" id="inputPassword3">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Image:</label>
    <div class="col-sm-10">
      <input type="file" name="files">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Contact No:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="cont_no" id="inputPassword3">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Email Id:</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" name="email" id="inputPassword3">
    </div>
  </div>
    
  <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Status:</label>
      <select id="inputState" class="col-sm-10" name="status">
        <option>Inactive</option>
        <option>Active</option>
        </select>
    </div>
  <div class="form-group row">
    <div class="col-sm-10 text-center">
      <button type="submit" class="btn btn-primary"> Add </button>
    </div>
  </div>
</form>
       </div>
        <div class="image-column justify-content-center align-items-center">
            <img src="img/police.png" alt="" class="img-fluid" style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
        </div>
</div>
    </body>
</html>
