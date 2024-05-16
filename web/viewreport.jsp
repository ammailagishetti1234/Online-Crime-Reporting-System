
<%@page import="com.entities.FIR"%>
<%@page import="com.dao.FIRDao"%>
<%@page import="com.entities.Complaint"%>
<%@page import="com.dao.ComplaintDao"%>
<%@page import="com.entities.chargesheet"%>
<%@page import="com.dao.chargesheetDao"%>
<%@page import="com.entities.report"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="com.dao.reportDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="allcomponet/allCss.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <center><h1><b>CASE REPORT</b></h1></center>
      
    <center>
        <div class="container-fluid">
    <div class="row p-2">
        <div class="col-md-5 offset-md-4">
            <div class="card" style="box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
                <div class="card-body">
                    <div class="row">
        
        <div class="center-table">
    <table border='1'>
        
       <%
    int id = Integer.parseInt(request.getParameter("reportId")); 
    System.out.println(id); 
    reportDao dao = new reportDao(DbConnect.getConn()); 
    List<report> list = dao.isReportReg1(id); 
%>



        <% 
            for(report r: list) {
                
             int chid = r.getChid();
              chargesheetDao dao1 = new chargesheetDao(DbConnect.getConn());
              chargesheet ch = dao1.getchargesheetById(chid); 

              int fid = ch.getFid();
              FIRDao dao2 = new FIRDao(DbConnect.getConn()); 
              FIR f = dao2.getFIRById(fid); 

              int cid = f.getId(); 
              ComplaintDao dao3 = new ComplaintDao(DbConnect.getConn()); 
              Complaint c = dao3.getComplaintById(cid);
        %>
        
       
        <!--report-->
        <h3>CASE DETAIL</h3>
        
        Case ID: <%= r.getRId() %> <br>
        Title: <%= c.getComplaint_detail() %><br>
        Date: <%= r.getCdate() %><br>
        Description: <%= r.getCdetail() %><br>
         
        <hr>
        
        <div class="form-row">
              <div class="form-group col-md-6">
              <b>ACCUSED DETAIL:</b><br>
              <%= c.getAccused_name() %><br><%= c.getAccused_add() %><br><%= c.getAccused_phno() %>
              </div>
              <div class="form-group col-md-6">
              <b>VICTIM DETAIL:</b><br>
              <%= c.getVictim_name() %><br><%= c.getVictim_add() %><br><%= c.getVictim_phno() %>
              </div>
          </div><hr>
          
        <!--fir-->
        <div class="form-row">
        <div class="form-group col-md-6">
        <b>FIR DETAILS</b> <br>
            FIR No.: <%= f.getFid() %> <br>
            Date: <%= f.getFir_start_date() %> <%= "-" %> <%= f.getFir_end_date() %><br>
            Section: <%= f.getSection() %><br>
            Description: <%= f.getFir_detail() %><br>
        </div>
        
        <!--complaint-->
        <div class="form-group col-md-6">
        <b>COMPLAINT DETAIL</b> <br>
           Complaint No. : <%= c.getId() %><br>
           Complaint Date: <%= c.getDate() %><br>
           Proof: 
        </div>
        </div>
           
           <hr>
           <div class="form-row">
        <div class="form-group col-md-6">
        <!--chargesheet-->
        <b>CHARGEHSEET DETAIL:</b> <br>
           Chargesheet No: <%= ch.getId() %><br>
           Chargesheet Date: <%= ch.getDate() %><br>
           Chargesheet Description: <%= ch.getBriefdesc() %><br>
        </div>
        
        <div class="form-group col-md-6">
            <b>PRISONARS DETAIL:</b> <br>
           Prisonor Name: <%= r.getName() %>  <br>
           Section: <%= r.getSection() %> <br>
           Prisonars Address: <%= r.getAdd() %> <br>
        </div>
           </div>
        <% } %>

    </table>
        </div>
       
                    </div>
                </div>
            </div>
        </div>
    </div>
        </div>
       
    </center> 
    </body>
</html>
