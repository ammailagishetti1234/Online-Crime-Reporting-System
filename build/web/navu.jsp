<%-- 
    Document   : navu
    Created on : Apr 29, 2024, 6:32:40 AM
    Author     : lenovo
--%>

<%@page import="com.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<nav class="navbar navbar-expand-lg navbar-dark nav">
    <a class="navbar-brand"><span class="fa fa-plus-square"></span>Crime Reporting System</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
    <a class="navbar-brand" href="index.jsp"><span class="fa fa-star"></span>Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        

        <% User user = (User) session.getAttribute("user");
        if (user == null) { %>
            <form class="form-inline my-2 my-lg-0 ml-auto">
                <a href="index.jsp" class="btn btn-success">Login</a>
                <a href="register.jsp" class="btn btn-danger ml-2">Register</a>
            </form>
        <% } else { %>
            <form class="form-inline my-2 my-lg-0 ml-auto">
                <a data-toggle="modal" data-target="#exampleModal" class="btn btn-success ml-2 text-white"><%= user.getName() %></a>
                <a data-toggle="modal" data-target="#exampleModalCenter" class="btn btn-danger ml-2 text-white">LogOut</a>
            </form>
        <% } %>

    </div>

    <!-- User Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header bg-primary text-white text-center">
                    <h5 class="modal-title" id="exampleModalLabel">Crime Management System</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container text-center">
                        <% if (user != null) { %>
                            <h5 class="modal-title" id="exampleModalLabel"><%= user.getName() %></h5>
                            <!-- User table -->
                            <div id="profile-details">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <th scope="row">ID</th>
                                        <td><%= user.getId() %></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Name</th>
                                        <td><%= user.getName() %></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Email</th>
                                        <td><%= user.getEmail() %></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">Password</th>
                                        <td><%= user.getPassword() %></td>
                                    </tr>
                                </tbody>
                            </table>
                            
                        <% } else { %>
                            <p>No user data available.</p>
                        <% } %>
                        
                        </div>
                        
                    <!--profile-edit-->
                    <div id="profile-edit" style="display: none;">
                        <h2 class="mt-2">Please Edit Carefully</h2>
                        <form action="EditServlet" method="POST">
                            <table class="table">
                                <tr>
                                    <td>ID: </td>
                                    <td><%= user.getId() %></td>
                                </tr>
                                 <tr>
                                    <td>Name: </td>
                                    <td><input type="text" class="form-control" name="uname" value="<%= user.getName() %>"></td>
                                </tr>
                                 <tr>
                                    <td>Email: </td>
                                    <td><input type="email" class="form-control" name="uemail" value="<%= user.getEmail() %>"></td>
                                </tr>
                                 <tr>
                                    <td>Password: </td>
                                    <td><input type="password" class="form-control" name="upass" value="<%= user.getPassword() %>"></td>
                                </tr>
                            </table>
                                
                                <div class="container">
                                    <button type="submit" class="btn btn-outline-primary">save</button>
                                </div>
                        </form>
                        
                    </div>
                    
                    
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button id="edit-profile-button" type="button" class="btn btn-primary">EDIT</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->

    <!-- logout -->

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
    <!-- logout -->

</nav>
    </body>
</html>
