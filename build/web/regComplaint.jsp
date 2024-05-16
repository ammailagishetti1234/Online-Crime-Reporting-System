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
      #inputState,
      label[for="inputState"] {
      display: none;
      }
  
  .custom-left-margin {
    margin-left: 70px; 
}
</style>
    </head>
    
    
<body style="background-color: #FAFAFA;">

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
                                    <i class="fa fa-area-chart mr-3 text-dark fa-fw"></i>
                                    Add Complaint
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="displayfiruser" class="nav-link text-dark">
                                    <i class="fa fa-bar-chart mr-3 text-dark fa-fw"></i>
                                    FIR
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="displaychargeuser.jsp" class="nav-link text-dark">
                                    <i class="fa fa-bar-chart mr-3 text-dark fa-fw"></i>
                                    ChargeSheet
                                </a>
                            </li>
                        </ul>
                        
                      
                    </div>    
        
     
        
       <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
 <script>
    $(document).ready(function() {
        // Function to validate phone numbers
        function validatePhoneNumber(inputId) {
            var phoneNumber = $("#" + inputId).val();
            if (phoneNumber.length !== 10) {
                alert("Phone number must be 10 digits long.");
                return false;
            }
            return true;
        }

        // Event listener for form submission
        $("form").on("submit", function(event) {
            // Validate phone numbers before submitting the form
            if (!validatePhoneNumber("n3") || !validatePhoneNumber("n13") || !validatePhoneNumber("n16")) {
                event.preventDefault(); // Prevent form submission
            }
        });
    });
</script>

<script>
    function validatePhoneNumber(phoneNo, inputId) {
        if (phoneNo.length !== 10) {
            alert("Phone number must be 10 digits long.");
            document.getElementById(inputId).focus();
            return false;
        }
        return true;
    }

    function validateForm() {
        var phoneNo = document.getElementById("n3").value; // Replace "n3" with the actual input id for phone_no
        var accusedPhoneNo = document.getElementById("n13").value; // Replace "n13" with the actual input id for accused_phone_no
        var victimPhoneNo = document.getElementById("n16").value; // Replace "n16" with the actual input id for victim_phone_no

        if (!validatePhoneNumber(phoneNo, "n3") || !validatePhoneNumber(accusedPhoneNo, "n13") || !validatePhoneNumber(victimPhoneNo, "n16")) {
            return false;
        }

        // Additional form validation logic can be added here

        return true;
    }
</script>


<main class="p-15" style="padding-bottom: 50px;">
    
    <div class="container">
        
        <!--      admin navbar        -->
        
        <div class="row justify-content-end">
            
            <div class="col-md-11 mt-4 ml-auto"> 
                <div class="card mx-auto">
                    <div class="card-header text-center text-black">
                        <h3>
                        Register Complaint here
                        </h3>
       
                    </div>
                    <div class="card-body">
                       <form action="complaint" method="POST" onsubmit="return validateForm();" enctype="multipart/form-data" required>
                          <div class="form-row">
                           <input type="hidden" name="id">
                           <!--<input type="hidden" name="uid">-->
                            <div class="form-group col-md-4">
                                <input type="text" name="name" class="form-control" id="n1" placeholder="Your Name" required>
                            </div>
                            <div class="form-group col-md-4">
                                <input type="email" name="email" class="form-control" id="n2" placeholder="Your Email" required>
                            </div>
                            <div class="form-group col-md-4">
                                <input type="text" name="phone_no" class="form-control" id="n3" placeholder="Your Phone No" required>
                            </div>
                         </div>
                            
                            <div class="form-row">
                            <div class="form-group col-md-6">
                                <input type="text" name="pcity" class="form-control" id="n4" placeholder="Police_Station city" required>
                                <input type="text" name="pstate" class="form-control" id="n5" placeholder="Police_Station state" required>
                               <!--<textarea class="form-control" name="police_station" id="exampleFormControlTextarea1" rows="3" placeholder="Police_Station State <% out.println(); %>Police_Station City"></textarea>-->
                            </div>
                            <div class="form-group col-md-6">
                               <textarea class="form-control" name="complaint_detail" id="n6" rows="3" placeholder="Complaint Title <% out.println(); %>Complaint Detail" required></textarea>
                            </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                <select id="n7" name="area" class="form-control" placeholder="Area" required>
                                  <option selected>Incident Area</option>
                                  <option>Bandra</option>
                                  <option>Dadar</option>
                                  <option>Powai</option>
                                  <option>Andheri</option>
                                  <option>Malad</option>
                                  <option>Vasant Kunj</option>
                                  <option>Dwarka</option>
                                  <option>Chanakyapuri</option>
                                  <option>Saket</option>
                                  <option>Pitampura</option>
                                </select>
                                </div>
                                
                                <div class="form-group col-md-3">
                                <select id="n8" name="icity" class="form-control" placeholder="City" required>
                                  <option selected>Incident City</option>
                                  <option>Mumbai</option>
                                  <option>Delhi</option>
                                </select>
                                </div>
                                
                                <div class="form-group col-md-3">
                                <select class="form-control" id="n9" name="tcrime" required>
                                  <option>Type Of Crime</option>
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
                                  <input type="date" class="form-control" name="date" id="n10" step="1" required>
                                </div>
                            </div>
                            
                            <div class="form-row">
                            <div class="form-group col-md-6">
                                <input type="text" name="aname" class="form-control" id="n11" placeholder="Accused Name" required>
                                <input type="text" name="aadd" class="form-control" id="n12" placeholder="Accused Address" required>
                                <input type="text" name="aphone" class="form-control" id="n13" placeholder="Accused Phone_no" required>
                               <!--<textarea class="form-control" name="accused_detail" id="exampleFormControlTextarea1" rows="3" placeholder="Accused Name <% out.println(); %>Victim Address <% out.println(); %>Accused Ph_no"></textarea>-->
                            </div>
                            <div class="form-group col-md-6">
                                <input type="text" name="vname" class="form-control" id="n14" placeholder="Victim Name" required>
                                <input type="text" name="vadd" class="form-control" id="n15" placeholder="Victim Address" required>
                                <input type="text" name="vphone" class="form-control" id="n16" placeholder="Victim Phone_no" required>
                               
                               <!--<textarea class="form-control" name="victim_detail" id="exampleFormControlTextarea1" rows="3" placeholder="Victim Name <% out.println(); %>Victim Address <% out.println(); %>Victim Ph_no"></textarea>-->
                            </div>
                            </div>
                            
                            <div class="form-row">
                            <div class="form-group col-md-12">
                               <textarea class="form-control" name="evidence_detail" id="n17" rows="2" placeholder="Any Evidence" required></textarea>
                            </div>
                            </div>
                            
                            <div class="form-row">
                            <div class="form-group col-md-6">
                                <input type="file" name="files" id="n18"><br>
                               <small>Choose image as well as video file.</small>
                            </div>
                            </div>
                            <div>
                            <select id="inputState" class="form-control" name="status">
                              <option>---</option>
                              <option>Accepted</option>
                              <option>Rejected</option>
                            </select>
                            </div>
                            
                            <button type="submit" class="btn btn-primary col-md-3 mx-auto d-block">Register</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
    </body>
</html>
