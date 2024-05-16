<link href="allcomponet/style1.css" rel="stylesheet" type="text/css"/>

<%@page import="com.entities.User"%>
<style>
    .icon-container {
    background-color: white;
    border-radius: 50%;
    width: 20px;
    height: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 5px;
    position: relative;
}

.icon-container i {
    color: #007bff; /* Primary color for the icon */
}

.view-link {
    margin-left: 20px;
}

/* Optional: Add some hover effect */
.icon-container:hover {
    background-color: #007bff;
}

.icon-container:hover i {
    color: white;
}

</style>
<nav class="navbar navbar-expand-lg navbar-dark nav" >
        <div id="logo" style="margin-right: 10px;"> <!-- Add some margin to the right for spacing -->
    <img src="img/logo.png" alt="Logo" style="height: 40px; width: auto; max-width: 100%;"/> <!-- Set maximum width to ensure responsiveness -->
</div>

    <a class="navbar-brand" href="index.jsp"><span class="fa fa-star"></span>Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp"><span class="fa fa-plus-square"></span>About us <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp"><span class="fa fa-user-circle fa-spin"></span>Login</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="register.jsp"><span class="fa fa-user-plus"></span>Sign up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="" target="_blank">
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
                    <h5 class="modal-title" id="exampleModalLabel">Crime Reporting System</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container text-center">
                        <% if (user != null) { %>
                            <h5 class="modal-title" id="exampleModalLabel"><%= user.getName() %></h5>
                            <!-- User table -->
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
                                </tbody>
                            </table>
                        <% } else { %>
                            <p>No user data available.</p>
                        <% } %>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">EDIT</button>
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
                    
                    
