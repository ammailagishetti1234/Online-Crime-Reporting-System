
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.entities.Complaint;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/updateCom1")
public class updateCom1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
        Complaint c=dao.getComplaintById(id);
        
        out.println("");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("nav.jsp");
        dispatcher.include(request, response);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Complaint</title>");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" \n" +
"      integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" \n" +
"      crossorigin=\"anonymous\">");
       out.println(" <link href=\"allcomponet/style1.css\" rel=\"stylesheet\" type=\"text/css\"/>");
       out.println("<link href=\"allcomponet/styleser.css\" rel=\"stylesheet\" type=\"text/css\"/>");
        
        out.println("</head>");
        out.println("<body>");

        out.println("<main class='p-15' style='padding-bottom: 50px;'>");
        out.println("<div class='container'>");
        out.println("<div class='row justify-content-end'>");
        out.println("<div class='col-md-11 mt-4 ml-auto'>");
        out.println("<div class='card mx-auto'>");
        out.println("<div class='card-header text-center text-black'>");
        out.println("<h3>Edit Complaint</h3>");
        out.println("</div>");
        out.println("<div class='card-body'>");
        out.println("<form action='updateCom2' method='POST' onsubmit='return validatePhone()' enctype='multipart/form-data'>");
        out.println("<input type='hidden' name='id' value='" + c.getId() + "'readonly>");
        out.println("<input type='hidden' name='uid' value='" + c.getUserId() + "'readonly>");

        // Form rows
        out.println("<b>Complainer Detail:</b>");
        out.println("<div class='form-row'>");
        out.println("<div class='form-group col-md-4'>");
        out.println("<input type='text' name='name' class='form-control' id='inputname1' placeholder='Your Name' value='" + c.getName() + "'readonly>");
        out.println("</div>");
        out.println("<div class='form-group col-md-4'>");
        out.println("<input type='email' name='email' class='form-control' id='inputemail1' placeholder='Your Email' value='" + c.getEmail() + "'readonly>");
        out.println("</div>");
        out.println("<div class='form-group col-md-4'>");
        out.println("<input type='text' name='phone_no' class='form-control' id='phone_no' placeholder='Your Phone No' value='" + c.getPhone_no() + "'readonly>");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<div class='form-row'>");
        out.println("<div class='form-group col-md-6'>");
        out.println("<b>Police_Station detail:</b>");
        out.println("<input type=\"text\" name=\"pcity\" class=\"form-control\" id=\"inputname1\" placeholder=\"Police_Station city\" value='" + c.getPolice_city() + "' readonly>");
        out.println("<input type=\"text\" name=\"pstate\" class=\"form-control\" id=\"inputname1\" placeholder=\"Police_Station state\" value='" + c.getPolice_state() + "' readonly>");
        out.println("</div>");
        out.println("<div class='form-group col-md-6'>");
        out.println("<b>Complaint Detail:</b>");
        out.println("<textarea class='form-control' name='complaint_detail' id='exampleFormControlTextarea1' rows='3' placeholder='Complaint Title' readonly>" + c.getComplaint_detail() + "</textarea>");
        out.println("</div>");
        out.println("</div>");
        
        out.println("<b>Incident Detail:</b>");
       out.println("<div class='form-row'>");
            out.println("<div class='form-group col-md-3'>");
            out.println("<select id='inputarea' name='area' class='form-control' placeholder='Area' value='" + c.getArea() + "'readonly>");
            out.println("<option>Bandra</option>");
            out.println("<option>Dadar</option>");
            out.println("<option>Powai</option>");
            out.println("<option>Andheri</option>");
            out.println("<option>Malad</option>");
            out.println("<option>Vasant Kunj</option>");
            out.println("<option>Dwarka</option>");
            out.println("<option>Chanakyapuri</option>");
            out.println("<option>Saket</option>");
            out.println("<option>Pitampura</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group col-md-3'>");
            out.println("<select id='inputcity' name='icity' class='form-control' placeholder='City' value='" + c.getIcity() + "'readonly>");
            out.println("<option>Mumbai</option>");
            out.println("<option>Delhi</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-group col-md-3'>");
            out.println("<select class='form-control' name='tcrime' value='" + c.getTcrime() + "'readonly>");
            out.println("<option>Theft</option>");
            out.println("<option>Burglary</option>");
            out.println("<option>Assault</option>");
            out.println("<option>Robbery</option>");
            out.println("<option>Fraud</option>");
            out.println("<option>Cyber crime</option>");
            out.println("<option>Homicide</option>");
            out.println("<option>Drug Offense</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<div class='form-row'>");
out.println("<div class='form-group '>");
out.println("<input type='date' class='form-control' name='date' id='exampleInputdate1' value='" + c.getDate() + "'readonly>");
out.println("</div>");
out.println("</div>");

out.println("<div class='form-row'>");
out.println("<div class='form-group col-md-6'>");
out.println("<b>Accused Detail:</b>");
out.println("<input type='text' name='aname' class='form-control' id='inputname1' placeholder='Accused name' value='" + c.getAccused_name() + "'readonly>");
out.println("<input type='text' name='aadd' class='form-control' id='inputname1' placeholder='Accused address' value='" + c.getAccused_add() + "'readonly>");
out.println("<input type='text' name='aphno' class='form-control' id='inputname1' placeholder='Accused phone_no' value='" + c.getAccused_phno() + "'readonly>");
out.println("</div>");

out.println("<div class='form-group col-md-6'>");
out.println("<b>Victim Detail:</b>");
out.println("<input type='text' name='vname' class='form-control' id='inputname1' placeholder='Victim name' value='" + c.getVictim_name() + "'readonly>");
out.println("<input type='text' name='vadd' class='form-control' id='inputname1' placeholder='Victim address' value='" + c.getVictim_add() + "'readonly>");
out.println("<input type='text' name='vphno' class='form-control' id='inputname1' placeholder='Victim phone_no' value='" + c.getVictim_phno() + "'readonly>");
out.println("</div>");
out.println("</div>");

//out.println("<div class='form-row'>");
//out.println("    <div class='form-group col-md-4'>");
out.println("        <b>Evidence Detail:</b>");
String fileName = c.getFileName();
// Display the file name in the form
out.println("<div class='form-row'>");
out.println("<div class='form-group col-md-8'>");
out.println("<b>Evidence Detail:</b>");
out.println("<input type='text' name='files' class='form-control' name=filename id='inputname1' value='" + fileName + "' readonly>");
out.println("</div>");
//out.println("</div>");
//out.println("</div>");


out.println("</div>");

out.println("</div>");

out.println("<select id='inputState' class='form-control' name='status'>");
out.println("<option>--</option>");
out.println("<option" + (isStatusSelected(c.getStatus(), "Accepted") ? " selected" : "") + ">Accepted</option>");
out.println("<option" + (isStatusSelected(c.getStatus(), "Rejected") ? " selected" : "") + ">Rejected</option>");
out.println("</select>");

         
        out.println("<br>");
        out.println("<div class='text-center'>");
        out.println("  <button class='btn btn-success' type='submit'>Edit</button>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</main>");

        out.println("</body>");
        out.println("</html>");
        
        out.close();
       }

private boolean isStatusSelected(String currentStatus, String targetStatus) {
    return (currentStatus != null && currentStatus.equals(targetStatus));
}

    }



