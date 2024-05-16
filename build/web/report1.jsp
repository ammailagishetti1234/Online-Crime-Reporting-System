
<%@page import="com.dao.FIRDao"%>
<%@page import="com.entities.FIR"%>
<%@page import="com.entities.chargesheet"%>
<%@page import="com.dao.chargesheetDao"%>
<%@page import="java.util.List"%>
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
            text-align: center;
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
        <%@include file="navbar.jsp"%>
    <%  
    int id1 = Integer.parseInt(request.getParameter("id"));
    chargesheetDao dao = new chargesheetDao(DbConnect.getConn());
    List<chargesheet> list = dao.getAccptedcharge1(id1);
    %>
    <center>
        <div class="center-container">
        <div class="center-table">
            <table border='1' class="styled-table">
            <tr>
                <th>Chargesheet No</th>
                <th>FIR reg No</th>
                <th>Section</th>
                <th>Description</th>
            </tr>
            <% 
            for(chargesheet c: list) {
           %>
           <tr>
               <td><%= c.getId() %></td>
               <td><%= c.getFid() %></td>
               <td><%= c.getSection() %></td>
               <td><%= c.getBriefdesc() %></td>

           </tr>
           
        </table>
        </div>
        <br>
        
        <% FIR f = new FIR();
           
        %>
        <form action="report" method="POST" enctype="multipart/form-data">
            <div class="form-group row">
                <input type="hidden" name="rid">
                <input type="hidden" name="chid"value="<%= c.getId() %>">
                <input type="hidden" name="fid" value="<%= c.getFid() %>">
                <input type="hidden" name="cid" value="<%= f.getId() %>">
                 
            <label for="inputEmail3" class="col-sm-2 col-form-label">Crime Report Date</label>
            <div class="col-sm-10">
              <input type="date" class="form-control" name="date" id="inputEmail3">
            </div>
            </div><hr>
        <h2>Prisonors Details:</h2>
        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Prisonors Name</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name="name" id="inputEmail3">
          </div>
        </div>
        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Section</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name="section" id="inputEmail3">
          </div>
        </div>
        <div class="form-group row">
          <label for="inputPassword3" class="col-sm-2 col-form-label">Crime Detail</label>
          <div class="col-sm-10">
            <textarea class="form-control" name="cdetail" id="exampleFormControlTextarea1" rows="3"></textarea>
          </div>
        </div>
        <div class="form-group row">
          <label for="inputPassword3" class="col-sm-2 col-form-label">Prisonors Address</label>
          <div class="col-sm-10">
            <textarea class="form-control" name="address" id="exampleFormControlTextarea1" rows="3"></textarea>
          </div>
        </div>
        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Prisonors Image</label>
          <div class="col-sm-10">
            <input type="file" class="form-control" name="files" id="inputEmail3">
          </div>
        </div>
        
        <div class="form-group row">
          <label for="inputEmail3" class="col-sm-2 col-form-label">Any Note</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name="note" id="inputEmail3">
          </div>
        </div>
        
        <div class="form-group row">
          <div class="col-sm-10">
           <button type="submit" class="btn btn-primary"> Submit </button>
          </div>
        </div>
        </form>
                
        </div>
                          <%
                    }
                %>
    </center>
    </body>
</html>
