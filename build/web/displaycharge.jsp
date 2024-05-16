<%-- 
    Document   : displaycharge1
    Created on : Feb 15, 2024, 6:58:16 AM
    Author     : lenovo
--%>

<%@page import="com.entities.chargesheet"%>
<%@page import="com.dao.chargesheetDao"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ComplaintDao"%>
<%@page import="com.dao.FIRDao"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="com.entities.Complaint"%>
<%@page import="com.entities.FIR"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="allcomponet/allCss.jsp" %>
          <style>
             body {
         text-align: center;
        }

    table {
        width: 100%; 
        max-width: 100%; 
        border-collapse: collapse;
        text-align: left;
    }
     th, td {
        border: 1px solid #ddd;
        padding: 8px;
    }
    .styled-table td:nth-child(6)
             {
                max-width: 150px;
                overflow: hidden;
                text-overflow: ellipsis;
            }
            .styled-table td:nth-child(7)
             {
                max-width: 150px;
                overflow: hidden;
                text-overflow: ellipsis;
            }
    .back-img {
    /*background: url("img/c4.png");*/
/*    width: 100%;
    height: 30%;  
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center;   
    display: flex;
    justify-content: center;
    align-items: center;*/
}
.back-img1 {
    background: url("img/c4.png");
    width: 100%;
    height: 30%;  
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center;   
    display: flex;
    justify-content: center;
    align-items: center;
}
.container{
    text-align: left;
    margin: 0 auto; 
    width: 80%; 
    border: 1px solid #ddd; 
    padding: 20px;
}
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp"%> <br>
        
        <div class="back-img1">
        <div class="container-fluid p-0 m-0">
            <center><h1 class="card-title" style="font-family: Algerian; font-size: 60px;">DETAILS</h1></center>
        </div>
    </div><br><br>
    
        <div class="center-table">
            <table border='1' class="styled-table">
                <tr>
                    <th>Id</th>
                    <th>Complaint Detail</th>
                    <th>Complainer_Detail</th>
                    <th>Police_Station</th>
                    <th>Complaint type</th>
                    <th>Accused_detail</th>
                    <th>Victim_detail</th>
                </tr>
                <%
                    Integer id = null;
                    String idParam = request.getParameter("id");
                    System.out.println("idParam: " + idParam);
                    if (idParam != null && !idParam.isEmpty()) {
                        id = Integer.parseInt(idParam);
                        System.out.println("idParam: " + idParam);
                        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
                        List<Complaint> list = dao.getComplaintFIR(id);
                    
                        for (Complaint c : list) {
                %>

                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getComplaint_detail() %></td>
                    <td><%= c.getName() %><br> <%= c.getEmail() %> <br> <%= c.getPhone_no() %></td>
                    <td><%= c.getPolice_city() %><br><%= c.getPolice_state() %></td>
                    <td><%= c.getTcrime() %></td>
                    <td><%= c.getAccused_name() %><br><%= c.getAccused_add() %><br><%= c.getAccused_phno() %></td>
                    <td><%= c.getVictim_name() %><br><%= c.getVictim_add() %><br><%= c.getVictim_phno() %></td>
                </tr>
 
            </table>
                
<% 
     }
        } else 
          {
             System.out.println("id is null");
           }
%>
 </div>
          
 <div>
     <table border='1' class="styled-table">
                    <tr>
                        <th>FIR No</th>
                        <th>Complaint No</th>
                        <th>Section</th>
                        <th>Complaint Type</th>
                        <th>FIR Detail</th> 
                        <th>Date</th>
                        <th>FIR Status</th>
                    </tr>
        <%
            Integer fid = null;
            String idParam1 = request.getParameter("id");
            if(idParam1 != null && !idParam1.isEmpty()){
                fid = Integer.parseInt(idParam1); 
                FIRDao dao = new FIRDao(DbConnect.getConn()); 
                List<FIR> list = dao.getAccptedFIR(fid);
              
                for (FIR f : list) {
                
        %>
        <td><%= f.getFid() %></td>
            <td><%= f.getId() %></td>
            <td><%= f.getSection() %></td>
            <td><%= f.getComplaint_type() %></td>
            <td><%= f.getFir_detail() %></td>
            <td><b>Reg Date:</b><%= f.getReg_date() %> <br> <b>Start Date:</b><%= f.getFir_start_date() %> <br> <b>End Date:</b><%= f.getFir_end_date() %></td>
            <td><%= f.getStatus() %></td>
           
        </table>
            
            <% }
}  else 
          {
             System.out.println("id is null");
           }
        %>
 </div>
 
 
 <div>
     <table border='1' class="styled-table">
         <%
            chargesheetDao dao2 = new chargesheetDao(DbConnect.getConn());
            int fid1 = Integer.parseInt(request.getParameter("id")); 
            chargesheet ch = dao2.getAllDetails(fid1);
        %>
        <h2>CHARGESHEET DETAIL</h2>
       
        <tr> <td>Section</td> <td><%= ch.getSection() %></td> </tr>
        <tr><td>Brief Desciption</td> <td><%= ch.getBriefdesc() %></td> </tr>
        <tr><td>Chargesheet Report</td> <td><%= ch.getBriefdesc() %></td> </tr>
        <tr><td>Offense Detail</td> <td><%= ch.getOffense() %></td> </tr>
        <tr><td>Accused Detail</td> <td><%= ch.getAccused() %></td> </tr>
        <tr><td>Chargesheet Date:</td> <td><%= ch.getDate() %></td> </tr>
        <tr><td>Chargesheet Status</td> <td><%= ch.getStatus() %></td> </tr>
     </table>
 </div>
    
    </body>
</html>
