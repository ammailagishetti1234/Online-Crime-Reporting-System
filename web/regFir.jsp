
<%@page import="com.entities.Admin"%>
<%--<%@page import="com.entities.FIR"%>--%>
<%@page import="com.entities.User"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.Complaint"%>
<%@page import="com.dao.ComplaintDao"%>
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

        </style>
       
    </head>
    <body>
         <!--      admin navbar        -->


         <%@include file="navbar.jsp"%>
  
<!--navbar-->
    <center>
<div class="center-container">
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
        </div>
        <center><h3>FIR Registration</h3></center>
        
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
   <form action="regfir" method="POST">
  <div class="form-group row">
      
       <input type="hidden" name="id" value="<%= c.getId() %>">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Section:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="section" id="inputEmail3">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Complaint Type</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="comp_type" id="inputPassword3">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Reg Date:</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" name="reg_date" id="inputEmail3">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">FIR Detail</label>
    <div class="col-sm-10">
      <textarea class="form-control" name="fir" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
  </div>
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Fir Start Date:</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" name="start_date" id="inputEmail3">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Fir End Date:</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" name="end_date" id="inputEmail3">
    </div>
  </div>
  <div class="form-group row">
      <label for="inputEmail3" class="col-sm-2 col-form-label">Status:</label>
      <select id="inputState" class="col-sm-10" name="status">
        
        <option>Pending</option>
        <option>Active</option>
        <option>Under Progress</option>
        </select>
    </div>
            
 
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary"> FIR Register </button>
    </div>
  </div>
</form>
</div>
   
<% 
     }
        } else 
          {
             System.out.println("id is null");
           }
%>
    </center>
</html>
