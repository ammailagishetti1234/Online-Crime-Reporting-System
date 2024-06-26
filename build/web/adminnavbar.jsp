
<%@page import="com.entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
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
          <a class="nav-link" href="addnews.jsp"><span class="fa fa-id-card"></span>Update News</a>
      </li>
     
     
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
    </ul>
      
      <% Admin admin = (Admin)session.getAttribute("admin");
      if(admin==null)
      { %>
<form class="form-inline my-2 my-lg-0 ml-auto">
    <a href="login.jsp" class="btn btn-success">Login</a>
    <a href="register.jsp" class="btn btn-danger ml-2">Register</a>
</form>
      <%} else { %>
<form class="form-inline my-2 my-lg-0 ml-auto">
       <button class="btn btn-success">admin@gmail.com</button>
       <a data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-danger ml-2 text-white">LogOut</a>
</form>
 <% 
}    
%>  

 </div>
   <!-- Modal -->
   <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">LogOut</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body text-center">
                    <h6>Do You want LogOut..</h6>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <a href="LogOut" class="btn btn-primary">LogOut</a>
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>
<!-- logout-->

</nav>
    </body>
</html>
