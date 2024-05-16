
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.FIRDao;
import com.entities.Complaint;
import com.entities.FIR;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet("/upFIR")
public class updateFIR extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("nav.jsp");
        dispatcher.include(request, response);
        
         out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        out.println("    <title>Update FIR</title>");
        out.println("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
        
        out.println("<style>");
        
        out.println("    body {");
        out.println("        text-align: center;");
        out.println("    }");
        out.println("    .form-container {");
        out.println("        text-align: left;");
        out.println("        display: inline-block;");
        out.println("        margin: 0 auto;");
        out.println("        width: 70%;");
        out.println("        border: 1px solid #ddd;");
        out.println("        padding: 20px;");
        out.println("        box-sizing: border-box;");
        out.println("        margin-top: 50px;");
        out.println("    }");
        out.println("    .form-group {");
        out.println("        margin-bottom: 15px;");
        out.println("    }");
        out.println("    .form-group label {");
        out.println("        display: block;");
        out.println("    }");
        out.println("    .form-group input, .form-group select, .form-group textarea {");
        out.println("        width: 100%;");
        out.println("        box-sizing: border-box;");
        out.println("    }");
        
        out.println(".icon-container {\n" +
"    background-color: white;\n" +
"    border-radius: 50%;\n" +
"    width: 20px;\n" +
"    height: 20px;\n" +
"    display: flex;\n" +
"    align-items: center;\n" +
"    justify-content: center;\n" +
"    margin: 0 5px;\n" +
"    position: relative;\n" +
"}\n" +
"\n" +
".icon-container i {\n" +
"    color: #007bff; /* Primary color for the icon */\n" +
"}\n" +
"\n" +
".view-link {\n" +
"    margin-left: 20px;\n" +
"}\n" +
"\n" +
"/* Optional: Add some hover effect */\n" +
".icon-container:hover {\n" +
"    background-color: #007bff;\n" +
"}\n" +
"\n" +
".icon-container:hover i {\n" +
"    color: white;\n" +
"}");
        
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");
        
        int fid = Integer.parseInt(request.getParameter("fid"));
FIRDao dao1 = new FIRDao(DbConnect.getConn());
FIR f = dao1.getFIRById(fid);



out.println("<div class=\"form-container\">");
out.println("    <center><h1>Update FIR</h1></center>");
out.println("    <form action=\"updateFIR2\" method=\"GET\">");

// Form Fields
out.println("        <div class=\"form-group row\">");
out.println("            <label for=\"inputPoliceId\" class=\"col-sm-2 col-form-label\">Police ID:</label>");
out.println("            <div class=\"col-sm-10\">");
out.println("                <input type=\"text\" class=\"form-control\" name=\"fid\" id=\"inputPoliceId\" value='" + f.getFid() + "' readonly>");
out.println("            </div>");
out.println("        </div>");

out.println("        <div class=\"form-group row\">");
out.println("            <label for=\"inputComplaintId\" class=\"col-sm-2 col-form-label\">Complaint ID:</label>");
out.println("            <div class=\"col-sm-10\">");
out.println("                <input type=\"text\" class=\"form-control\" name=\"cid\" id=\"inputComplaintId\" value='" + f.getId() + "'readonly>");
out.println("            </div>");
out.println("        </div>");

// section
out.println("        <div class='form-group row'>");
out.println("            <label for='inputPassword3' class='col-sm-2 col-form-label'>Section</label>");
out.println("            <div class='col-sm-10'>");
out.println("                <input type='text' class='form-control' name='section' id='inputPassword3' value='" + f.getSection() + "'readonly>");
out.println("            </div>");
out.println("        </div>");

// Complaint Type
out.println("        <div class='form-group row'>");
out.println("            <label for='inputPassword3' class='col-sm-2 col-form-label'>Complaint Type</label>");
out.println("            <div class='col-sm-10'>");
out.println("                <input type='text' class='form-control' name='comp_type' id='inputPassword3' value='" + f.getComplaint_type() + "'readonly>");
out.println("            </div>");
out.println("        </div>");

// Registration Date
out.println("        <div class='form-group row'>");
out.println("            <label for='inputEmail3' class='col-sm-2 col-form-label'>Reg Date:</label>");
out.println("            <div class='col-sm-10'>");
out.println("                <input type='date' class='form-control' name='reg_date' id='inputEmail3' value='" + f.getReg_date() + "'readonly>");
out.println("            </div>");
out.println("        </div>");

// FIR Detail
out.println("        <div class='form-group row'>");
out.println("            <label for='inputPassword3' class='col-sm-2 col-form-label'>FIR Detail</label>");
out.println("            <div class='col-sm-10'>");
out.println("                <textarea class='form-control' name='fir_detail' id='exampleFormControlTextarea1' rows='3' readonly>" + f.getFir_detail() + "</textarea>");
out.println("            </div>");
out.println("        </div>");

// FIR Start Date
out.println("        <div class='form-group row'>");
out.println("            <label for='inputEmail3' class='col-sm-2 col-form-label'>FIR Start Date:</label>");
out.println("            <div class='col-sm-10'>");
out.println("                <input type='date' class='form-control' name='start_date' id='inputEmail3' value='" + f.getFir_start_date() + "'readonly>");
out.println("            </div>");
out.println("        </div>");

// FIR End Date
out.println("        <div class='form-group row'>");
out.println("            <label for='inputEmail3' class='col-sm-2 col-form-label'>FIR End Date:</label>");
out.println("            <div class='col-sm-10'>");
out.println("                <input type='date' class='form-control' name='end_date' id='inputEmail3' value='" + f.getFir_end_date() + "'readonly>");
out.println("            </div>");
out.println("        </div>");

// Status
out.println("        <div class='form-group row'>");
out.println("            <label for='inputEmail3' class='col-sm-2 col-form-label'>Status:</label>");
out.println("            <select id='inputState' class='col-sm-10' name='status' value='" + f.getStatus() + "'readonly>");
out.println("                <option" + (isStatusSelected(f.getStatus(), "Active") ? " selected" : "") + ">Active</option>");
out.println("                <option" + (isStatusSelected(f.getStatus(), "Inactive") ? " selected" : "") + ">Inactive</option>");
out.println("                <option" + (isStatusSelected(f.getStatus(), "Under Process") ? " selected" : "") + ">Under Process</option>");
out.println("            </select>");
out.println("        </div>");


// Submit Button
out.println("        <div class='form-group row'>");
out.println("            <div class='col-sm-10'>");
out.println("                <button type='submit' class='btn btn-primary'>Update</button>");
out.println("            </div>");
out.println("        </div>");

out.println("    </form>");
out.println("</div>");
     out.println("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>");
        out.println("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>");
        out.println("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
        out.println("</body>");
        out.println("</html>");
        
    }
    
    private boolean isStatusSelected(String currentStatus, String targetStatus) {
    return (currentStatus != null && currentStatus.equals(targetStatus));
}
}
