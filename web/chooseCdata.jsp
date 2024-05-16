
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!--        css-->
           <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
                 integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
           
      <a href="css/myStyle.jsp"></a>
      
    </head>
    <body>
        <%@include file="navbar.jsp"%> <br>
        <main class="primary-background p-10 " style="padding-bottom: 50px;">
    <div class="container">
<div class="col-md-7 mx-auto mt-4">
    
    <div class="card">
    <div class="card-header text-center primary-background text-black">
        <span class="fa fa-3x fa fa-user-circle"></span>
    <br>
    Register Complaint here
    </div>
    <div class="card-body">
      <form id="crimeReport" action="crimeServlet" method="POST">
                             
                    
          <div class="form-group col-md-6">
      <select id="inputcity" name="city" class="form-control" placeholder="City">
        <option selected>Incident City</option>
        <option>Mumbai</option>
        <option>Delhi</option>
      </select>
    </div>
        <div class="form-group col-md-6">
        <label for="start_date">Start Date:</label>
        <input type="date" id="start_date" name="start_date" class="form-control">
    </div>

    <div class="form-group col-md-6">
        <label for="end_date">End Date:</label>
        <input type="date" id="end_date" name="end_date" class="form-control">
    </div>
          <button type="submit" onclick="submitForm()" class="btn btn-primary">OK</button>
      </form>
           
    </div>
    </div>
</div>
    </div>
        </main>
        
        <script>
    function submitForm() {
        // Capture the selected values
        var icity = document.getElementById("icity").value;
        var startDate = document.getElementById("start_date").value;
        var endDate = document.getElementById("end_date").value;

        // Set the values to the form
        document.getElementById("visual.jsp").action = "visual.jsp?city=" + icity + "&start_date=" + startDate + "&end_date=" + endDate;

        // Submit the form
        document.getElementById("visual.jsp").submit();
    }
</script>

    </body>
</html>
