
<%@page import="com.dao.chargesheetDao"%>
<%@page import="com.entities.chargesheet"%>
<%@page import="com.entities.FIR"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.FIRDao"%>
<%@page import="com.conn.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <style>
  body {
        text-align: center;
    }

    h2 {
        color: #333; 
        background-color: #f2f2f2; 
        padding: 10px; 
        border-radius: 5px; 
    }

    .center-table {
        margin: 60px;
        width: 80%;
        text-align: center;
        /*overflow-x: auto;*/ 
    }

    table {
        width: 100%; 
        max-width: 100%; 
        border-collapse: collapse;
        text-align: center;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
    }

    th {
        background-color: #4CAF50; 
        color: white;
    }
   .btn-p1 {
    background-color: purple;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
    text-decoration: none; /* Remove default underline for links */
    display: inline-block; /* Ensures proper inline display */
}

.back-img {
         background: url("img/c4.png");
    width: 100%;
    height: 30%; /* Set the height to 30% of the viewport */
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center; /* Position the background image in the center */
    display: flex;
    justify-content: center;
    align-items: center;
    }
    .btn-primary1 {
    background-color: purple;
    /* You can customize other styles as needed */
}
</style>
    </head>
    <body>
         <%@include file="navbar.jsp"%> <br>
         
    <div class="back-img">
    <div class="container-fluid p-0 m-0" >
        <center><h1 class="card-title" style="font-family: Algerian; font-size: 60px;">CHARGESHEET DETAIL</1></center>
    </div>
    </div>
        <%
            FIRDao dao = new FIRDao(DbConnect.getConn());
            List<FIR> list = dao.getAccptedFir1();
        %>
        <div class="center-table">
    <table border='1'>
        <tr>
            <th>FIR No</th>
            <th>Complaint No</th>
            <th>Section</th>
            <th>Complaint Type</th>
            <th>FIR Detail</th>
            <th>Date</th>
            <th>FIR Status</th>
            <th>Police Name</th>
            <th>Police Station</th>
            <th>Action</th>
        </tr>
        
        <% 
            for(FIR f: list) {
        %>
        <tr>
            <td><%= f.getFid() %></td>
            <td><%= f.getId() %></td>
            <td><%= f.getSection() %></td>
            <td><%= f.getComplaint_type() %></td>
            <td><%= f.getFir_detail() %></td>
            <td><b>Reg Date:</b><%= f.getReg_date() %> <br> <b>Start Date:</b><%= f.getFir_start_date() %> <br> <b>End Date:</b><%= f.getFir_end_date() %></td>
            <td><%= f.getStatus() %></td>
             <td><%= f.getName() %></td>
            <td><%= f.getStation() %></td>
            
            <td>
            <% 
                int fid = f.getFid();
                chargesheetDao dao1 = new chargesheetDao(DbConnect.getConn());  
                List<chargesheet> cList = dao1.ischregistered(fid);
                if (cList != null && !cList.isEmpty()) {
            %>
            <a href='displaycharge.jsp?id=<%= f.getFid() %>' class="btn btn-primary1 text-white">View<br> chargesheet</a>
            <%
                } else {
            %>
                    <a href='displayfirregch?id=<%= f.getFid() %>' class="btn btn-primary1 text-white">File <br> chargesheet</a>
            <%
        }
           %>
            </td>
        </tr>
        
        <% } %>
    </table>
    
        </div>
    </body>
</html>
