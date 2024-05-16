<%-- 
    Document   : addnews
    Created on : Dec 11, 2023, 9:20:47 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="allcomponet/allCss.jsp" %>
    </head>
    <body>
        
         <!--      admin navbar        -->
<%@include file="adminnavbar.jsp" %>

<div class="container-fluid">
    <div class="row p-2">
        <div class="col-md-8 offset-md-2">
            <div class="card" style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-7">
                            <h3 class="text-center">News Article</h3>
                            <form action="news" method="post">
                                <div class="form-group">
                                    <label for="exampleInputtitle1">Title</label>
                                    <input type="text" class="form-control" name="title" id="exampleInputtitle1">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputdate1">Date & Time</label>
                                    <input type="datetime-local" class="form-control" name="date_time" id="exampleInputdate1">
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">Content</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="6"></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                        <div class="col-md-5 d-flex justify-content-center align-items-center bg-white p-3">
                            <!-- Add your image tag here -->
                            <img src="img/news.png" alt="" class="img-fluid" style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    </body>
</html>
