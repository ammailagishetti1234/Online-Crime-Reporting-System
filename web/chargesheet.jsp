<%-- 
    Document   : chargesheet
    Created on : Feb 3, 2024, 1:51:00 AM
    Author     : lenovo
--%>

<%@page import="java.util.List"%>
<%@page import="com.dao.chargesheetDao"%>
<%@page import="com.entities.chargesheet"%>
<%@page import="com.entities.FIR"%>
<%@page import="com.dao.FIRDao"%>
<%@page import="com.conn.DbConnect"%>
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
         .center-container {
            text-align: left;
            display: inline-block;
        }
         .center-container {
            text-align: left;
            display: inline-block;
            margin: 0 auto; 
            width: 80%; 
            border: 1px solid #ddd; 
            padding: 20px; 
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
 .btn-p1 {
    background-color: purple;
    color: white;
 }
        </style>
    </head>
    <body>
        <div class="center-container">
            <div class="center-table">
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
            String idParam = request.getParameter("fid");
            if(idParam != null && !idParam.isEmpty()){
                fid = Integer.parseInt(idParam); 
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
            <hr>
        <center><h3>ChargeSheet Registration</h3></center>
        
        <form action="chargesheet" method="post" enctype="multipart/form-data">
            <div class="form-group row">
                <input type="hidden" name="id">
                 <input type="hidden" name="fid" value="<%= f.getFid() %>">
                <input type="hidden" name="cid" value="<%= f.getId() %>">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Section:</label>
                <div class="col-sm-10">
                   <input type="text" class="form-control" name="section" id="inputEmail3">
                </div>
            </div>
            <div class="form-group row">
             <label for="inputPassword3" class="col-sm-2 col-form-label">Brief Description</label>
             <div class="col-sm-10">
              <textarea class="form-control" name="brief" id="exampleFormControlTextarea1" rows="3"></textarea>
             </div>
            </div>
            <div class="form-group row">
              <label for="inputPassword3" class="col-sm-2 col-form-label">ChargeSheet Report</label>
              <div class="col-sm-10">
                <input type="file" class="form-control" name="files" id="inputPassword3">
              </div>
            </div>
            <div class="form-group row">
              <label for="inputPassword3" class="col-sm-2 col-form-label">Offense</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" name="off" id="inputPassword3">
            </div>
            </div>
    
            <div class="form-group row">
              <label for="inputPassword3" class="col-sm-2 col-form-label">Accused</label>
              <div class="col-sm-10">
               <input type="text" class="form-control" name="accu" id="inputPassword3">
              </div>
            </div>
    
            <div class="form-group row">
             <label for="inputEmail3" class="col-sm-2 col-form-label">ChargeSheet Date:</label>
             <div class="col-sm-10">
               <input type="date" class="form-control" name="charge_date" id="inputEmail3">
             </div>
            </div>
    
            <div class="form-group row">
              <label for="inputEmail3" class="col-sm-2 col-form-label">Status:</label>
               <select id="inputState" class="col-sm-10" name="status">
        
                <option>Active</option>
               </select>
            </div>
            
           <div class="form-group row">
            <div class="col-sm-10">
             <button type="submit" class="btn btn-p1"> ChargeSheet </button>
            </div>
          </div>
  
        </form>
                
        <% }
        
}  else 
          {
             System.out.println("id is null");
           }
        %>
           
               
    </body>
</html>
