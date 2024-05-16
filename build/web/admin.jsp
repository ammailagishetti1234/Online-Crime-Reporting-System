
<%@page import="com.entities.Police"%>
<%@page import="com.dao.PoliceDao"%>
<%@page import="com.entities.chargesheet"%>
<%@page import="com.dao.chargesheetDao"%>
<%@page import="com.entities.FIR"%>
<%@page import="com.dao.FIRDao"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.Complaint"%>
<%@page import="com.dao.ComplaintDao"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.entities.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <%@include file="allcomponet/allCss.jsp" %>
    
        <link href="allcomponet/style3.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        .page-content {
    background: #fff;   /*Set the background color of the side body to white */
    width: calc(100% - 17rem);
    margin-left: 17rem;
    transition: all 0.4s;
}
    </style>
    <body>
       
<div class="container-fluid">
    <div class="row">
   <div class="vertical-nav" id="sidebar">
                        <div class="py-4 px-3 mb-4">
                            <div class="media d-flex align-items-center"><img src="" alt="..." width="80" height="80" class="mr-3 rounded-circle img-thumbnail shadow-sm">
                                <div class="media-body">
                                    <h4 class="m-0">Hello Admin</h4>
                                    <p class="font-weight-normal text-muted mb-0">Welcome</p>
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
                                <a href="displayadmin" class="nav-link text-dark">
                                    <i class="fa fa-address-card mr-3 text-dark fa-fw"></i>
                                    View Complaint
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="chooseCdata.jsp" class="nav-link text-dark">
                                    <i class="fa fa-bar-chart mr-3 text-dark fa-fw"></i>
                                    Crime Rate Graph
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="displayAccptedComplaint.jsp" class="nav-link text-dark">
                                    <i class="fa fa-address-book mr-3 text-dark fa-fw"></i>
                                    FIR
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="displayAccptedFir.jsp" class="nav-link text-dark">
                                    <i class="fa fa-building mr-3 text-dark fa-fw"></i>
                                    ChargeSheet
                                </a>
                            </li>
                        </ul>
                        
                        <p class=" font-weight-bold text-uppercase px-3 small py-4 mb-0">Other Features</p>
                        <ul class="nav flex-column mb-0">
                           <li class="nav-item">
                                <a href="chat.jsp" class="nav-link text-dark">
                                    <i class="fa fa-commenting mr-3 text-dark fa-fw"></i>
                                    ChatBot
                                </a>
                            </li> 
                            <li class="nav-item">
                                <a href="email.jsp" class="nav-link text-dark">
                                    <i class="fa fa-envelope mr-3 text-dark fa-fw"></i>
                                    Email
                                </a>
                            </li>
                        </ul>
                    </div> 

<script>
    $(function(){
        $('#sidebarCollapse').on('click', function() {
            $('#sidebar, #content').toggleClass('active');
        })
    })
</script>

<% 
  ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
    List<Complaint> list = dao.getComplaintinfo(); 
%>


<%
    FIRDao dao1 = new FIRDao(DbConnect.getConn());
    List<FIR> list1 = dao1.getFIRinfo();
%>

<% 
   chargesheetDao dao2 = new chargesheetDao(DbConnect.getConn());
   List<chargesheet> list2 = dao2.getChargeinfo();
%>

<% 
   PoliceDao dao3 = new PoliceDao(DbConnect.getConn());
   List<Police> list3 = dao3.getPoliceinfo();
%>

<div class="page-content">
    <%@include file="adminnavbar.jsp" %>
    <div class="cards d-flex justify-content-between">
        <div class="card-single mx-2">
        <div>
                <h1 class="fa"><%= list.size() %></h1><br>
            <span class="fa">Complaint</span>
        </div>
            <div>
                <span class="lass la-users"></span>
            </div>
        </div>
        <div class="card-single mx-2">
        <div>
                <h1 class="fa"><%= list1.size() %></h1><br>
            <span class="fa">FIR</span>
        </div>
            <div>
                <span class="lass la-users"></span>
            </div>
        </div>
        <div class="card-single mx-2">
        <div>
            <h1 class="fa"><%= list2.size() %></h1><br>
            <span class="fa">Chargesheet</span>
        </div>
            <div>
                <span class="lass la-users"></span>
            </div>
        </div>
        <div class="card-single mx-2">
        <div>
                <h1 class="fa"><%= list3.size() %></h1><br>
            <span class="fa">Police</span>
        </div>
            <div>
                <span class="lass la-users"></span>
            </div>
        </div>
    </div>
</div>
               <br><br><br>
       <div class="news">
        <div class="row">
            <div class="news-card">
            <div class="col-md-8 mx-auto">
                <div class="card" style="background: green;">
                    <center><h2 class="mb-4" >News Articles</h2></center>
                <div class="card-deck">
                    <% try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_report", "root", "111");

                        Statement st = con.createStatement();

                        String query = "select * from News";
                        ResultSet rs = st.executeQuery(query);
                        while (rs.next()) {
                    %>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title"><%= rs.getString("title") %></h5>
                                <p class="card-text"><strong>Date:</strong> <%= rs.getString("date_time") %></p>
                                <p class="card-text"><%= rs.getString("content") %></p>
                            </div>
                        </div>
                    <%
                        }
                        rs.close();
                        st.close();
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>
                </div>
                </div>
            </div>
            </div>
        </div>
       </div>
</div>
    </div>
</div>
                
    </body>
</html>
