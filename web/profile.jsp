
<%@page import="java.util.List"%>
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
        .page-content1 {
    background: #fff;   /*Set the background color of the side body to white */
    width: calc(100% - 17rem);
    margin-left: 10rem;
    transition: all 0.4s;
}
    </style>
    </head>
    <body>
           <%@page import="com.entities.User"%>
           
           <div class="container-fluid">
    <div class="row">
        
        <div class="vertical-nav" id="sidebar">
                        <div class="py-4 px-3 mb-4">
                            <div class="media d-flex align-items-center"><img src="" alt="..." width="80" height="80" class="mr-3 rounded-circle img-thumbnail shadow-sm">
                                <div class="media-body">
                                    <h4 class="m-0">Hello User</h4>
                                    <p class="font-weight-normal text-muted mb-0">Developer</p>
                                </div>
                            </div>
                        </div>
                        
                        <p class="text-dark font-weight-bold text-uppercase px-3 small pb-4 mb-0">Dashboard</p>
                        
                        <ul class="nav flex-column mb-0">
                            <li class="nav-item">
                                <a href="index.jsp" class="nav-link text-dark">
                                    <i class="fa fa-th-large mr-3 text-dark fa-fw"></i>
                                    Home
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="index.jsp" class="nav-link text-dark">
                                    <i class="fa fa-address-card mr-3 text-dark fa-fw"></i>
                                    about
                                </a>
                            </li>

                        </ul>
                        
                        <p class="text-dark font-weight-bold text-uppercase px-3 small py-4 mb-0">Services</p>
                        
                        <ul class="nav flex-column mb-0">
                            <li class="nav-item">
                                <a href="regComplaint.jsp" class="nav-link text-dark">
                                    <i class="fa fa-address-card mr-3 text-dark fa-fw"></i>
                                    Add Complaint
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="displayfiruser" class="nav-link text-dark">
                                    <i class="fa fa-address-book mr-3 text-dark fa-fw"></i>
                                    FIR
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="displaychargeuser.jsp" class="nav-link text-dark">
                                    <i class="fa fa-building mr-3 text-dark fa-fw"></i>
                                    ChargeSheet
                                </a>
                            </li>
                        </ul>
                        
                        
                    </div>
        
        
        <div class="page-content">

           
 <!--      user navbar        -->
        <%@include file="navu.jsp" %>

<script>
    $(function(){
        $('#sidebarCollapse').on('click', function() {
            $('#sidebar, #content').toggleClass('active');
        })
    })
</script>


<div class="page-content1" id="content"><br><br>
                <!-- Welcome message and features -->
                <h2 class="display-5 text-dark">Welcome <%= user.getName() %>,</h2>
             
                <div class="separator"><hr></div>
                <div class="pt-7 pb-8">
                    <div class="container">
                        <div class="row">
                            
                <div class="section-head col-sm-12"></div>
                <div class="col-lg-4 col-sm-4">
                    <div class="item ml-3 ">
                        <span class="icon feature_box_col_one">
                            <i class="fa fa-address-card"></i>
                        </span>
                         <h4><a href="display">View Complaint</a></h4>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-4">
                    <div class="item ml-3">
                        <span class="icon feature_box_col_one">
                            <i class="fa fa-address-book"></i>
                        </span>
                        <h4><a href="displayfiruser">FIR</a></h4>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-4">
                    <div class="item ml-3">
                        <span class="icon feature_box_col_one">
                            <i class="fa fa-building"></i>
                        </span>
                        <h4><a href="displaychargeuser.jsp">chargesheet</a></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        </div>
    </div>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

<script>
    $(document).ready(function(){
        let editStatus=false;
        
        $('#edit-profile-button').click(function(){
           
           if(editStatus == false)
           {
              $("#profile-details").hide()
            
              $("#profile-edit").show();
              editStatus=true;
              $(this).text("Back")
             // swal("Good job!", "You clicked the button!", "success");
           } else {
               $("#profile-details").show()
            
              $("#profile-edit").hide();
              editStatus=false;
              $(this).text("Edit")
              //swal("Try Again!", "You clicked the button!", "error");
           }
            
        })
        
    });
</script>

<script>
    $(document).ready(function(e) {
        $("#edit-profile-button").on("submit",function(event){
            event.preventDefault();
            console.log("submit");
            let form = new FormData(this);
            
            $.ajax({
                url: "EditServlet",
                type: 'POST',
                data: form,
                success: function(data, textStatus, jqXHR) {
                    //success
                    swal("Good job!", "You clicked the button!", "success");
                },  // <-- add comma here
                error: function(jqXHR, textStatus, errorThrown){
                    //error
                    swal("Try Again!", "You clicked the button!", "error");
                },
                processData: false,
                contentType: false
            });
        });
    });
</script>

                  
    </body>
    
    
    
</html>
