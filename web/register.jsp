
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="allcomponet/allCss.jsp" %>
    </head>
    <body style="background-color: #f7faf8;">
        
                <!--      navbar        -->
<%@include file="normal_navbar.jsp" %>
      
<div class="container-fluid">
    <div class="row p-2">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h4 class="text-center text-success">Registration Page</h4>
                    
                    <% String successMsg =(String)session.getAttribute("successMsg");
                       String errorMsg = (String)session.getAttribute("errorMsg");
                    if(successMsg!=null){
                    %>
                    <p class="text-sucess text-center"><%=successMsg %></p>
                    <% session.removeAttribute("successMsg"); }

                     if(errorMsg!=null)
                    {
                    %>
                    <p class="text-danger text-center"><%=errorMsg %></p>
                    <% 
                        session.removeAttribute("errorMsg");
                    }
                    %>
                    
<form action="register" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input type="text" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp" required>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" required>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" required>
  </div>
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" required>
    <label class="form-check-label" name="check" for="exampleCheck1">accept terms & condition</label>
  </div>
    <div class="text-center mt-2">
        <button type="submit" class="btn btn-primary">Register</button>
    </div> 
</form>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="margin-top: 100px;"> 
<%@include file="allcomponet/footer.jsp"%>
</div>
    </body>
</html>
