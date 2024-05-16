
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
        <%@include file="navbar.jsp"%> <br>
        <div class="container-fluid">
    <div class="row p-2">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h4 class="text-center text-dark">Email</h4>
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
        <form action="send" method="POST">
            <div class="form-group">
                <label for="exampleInputEmail1"><b>Name:</b></label>
            <input type="text" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp" required>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1"><b>To:</b></label>
            <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" required>
           </div>
            <div class="form-group">
                <label for="exampleInputEmail1"><b>Subject:</b></label>
            <input type="text" class="form-control" name="subject" id="exampleInputEmail1" aria-describedby="emailHelp" required>
            </div>
             <div>
                <label><b>Message: </b></label>
                <textarea class="form-control" name="message" id="exampleFormControlTextarea1" rows="5"></textarea>
                </div>
            <div class="text-center mt-2">
            <button type="submit" class="btn btn-primary">Send</button>
         </div> 
        </form>
                </div>
            </div>
        </div>
    </div>
        </div> 
    </body>
</html>
