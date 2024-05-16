
package com.servlet;

import com.conn.DbConnect;
import com.dao.ComplaintDao;
import com.dao.PoliceDao;
import com.entities.Complaint;
import com.entities.Police;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/upPolice")
public class updatePolice extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
        String pid = request.getParameter("id");
        int id = Integer.parseInt(pid);
        PoliceDao dao = new PoliceDao(DbConnect.getConn());
        Police c = dao.getPoliceById(id);
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Your Form Title</title>");
            
            out.println("<style>"
                    + ".icon-container {\n" +
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
"}</style>");
            
            
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" \n" +
                    "      integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" \n" +
                    "      crossorigin=\"anonymous\">");
            
//            navbar
          
RequestDispatcher dispatcher = request.getRequestDispatcher("nav.jsp");
        dispatcher.include(request, response);

            out.println("<style>");
            out.println("    body {");
            out.println("        text-align: center;");
            out.println("    }");
            out.println("    .center-container {");
            out.println("         text-align: left;");
            out.println("        display: inline-block;");
            out.println("       margin: 0 auto; ");
            out.println("        width: 80%; ");
            out.println("        border: 1px solid #ddd;");
            out.println("        padding: 20px; ");
            out.println("       box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");  
            out.println("    }");
            out.println("    .form-container {");
            out.println("        width: 60%;");
            out.println("        display: inline-block;");
            out.println("        vertical-align: top;");
            out.println("    }");
            out.println("    .image-column {");
            out.println("        width: 35%;");
            out.println("        display: inline-block;");
            out.println("        vertical-align: top;");
            out.println("        padding-left: 5%;");
            out.println("    }");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");
            

            out.println("<div class=\"center-container\">");
            out.println("<div class=\"form-container\">");
            out.println("<center><h3 >Assign police</h3></center>");
            out.println("<form action=\"upPolice2\" method=\"GET\" enctype=\"multipart/form-data\">");
            out.println("    <div class=\"form-group row\">");
            out.println("        <input type=\"hidden\" name=\"id\" value='" + c.getId() + "'readonly>");
            out.println("        <input type=\"hidden\" name=\"pid\">");
            out.println("        <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Name:</label>");
            out.println("        <div class=\"col-sm-10\">");
            out.println("            <input type=\"text\" class=\"form-control\" name=\"pname\" id=\"inputEmail3\" value='" + c.getName() + "'readonly>");
            out.println("        </div>");
            out.println("    </div>");
            
            out.println("<div class=\"form-group row\">");
            out.println("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">Station:</label>");
            out.println("    <div class=\"col-sm-10\">");
            out.println("        <input type=\"text\" class=\"form-control\" name=\"station\" id=\"inputPassword3\" value='" + c.getStation() + "'readonly>");
            out.println("    </div>");
            out.println("</div>");
            
           out.println("<div class=\"form-group row\">");
out.println("    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Gender</label>");
out.println("    <select id=\"inputState\" class=\"col-sm-10\" name=\"gender\" readonly>");

// Define an array of gender options
String[] genderOptions = {"Male", "Female"};

// Iterate through the options and set the selected attribute for the matching value
for (String option : genderOptions) {
    out.print("        <option");
    if (option.equals(c.getGender())) {
        out.print(" selected");
    }
    out.println(">" + option + "</option>");
}

out.println("    </select>");
out.println("</div>");
            
            out.println("<div class=\"form-group row\">");
            out.println("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">Designation:</label>");
            out.println("    <div class=\"col-sm-10\">");
            out.println("        <input type=\"text\" class=\"form-control\" name=\"designation\" id=\"inputPassword3\" value='" + c.getDesignation() + "'readonly>");
            out.println("    </div>");
            out.println("</div>");
            
            out.println("<div class=\"form-group row\">");
            out.println("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">Image:</label>");
            out.println("    <div class=\"col-sm-10\">");
            out.println("        <input type=\"file\" name=\"files\">");
            out.println("    </div>");
            out.println("</div>");
            
            out.println("<div class=\"form-group row\">");
            out.println("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">Contact No:</label>");
            out.println("    <div class=\"col-sm-10\">");
            out.println("        <input type=\"text\" class=\"form-control\" name=\"cont_no\" id=\"inputPassword3\" value='" + c.getCont_no() + "'readonly>");
            out.println("    </div>");
            out.println("</div>");
            
            out.println("<div class=\"form-group row\">");
            out.println("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">Email Id:</label>");
            out.println("    <div class=\"col-sm-10\">");
            out.println("        <input type=\"email\" class=\"form-control\" name=\"email\" id=\"inputPassword3\" value='" + c.getEmail() + "'readonly>");
            out.println("    </div>");
            out.println("</div>");
            
            out.println("<div class=\"form-group row\">");
            out.println("    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Status:</label>");
            out.println("    <select id=\"inputState\" class=\"col-sm-10\" name=\"status\">");
            out.println("        <option" + (isStatusSelected(c.getPstatus(), "Active") ? " selected" : "") + ">Active</option>");
            out.println("        <option" + (isStatusSelected(c.getPstatus(), "Inactive") ? " selected" : "") + ">Inactive</option>");
            out.println("    </select>");
            out.println("</div>");
            
            
            // Add other form elements here...

            out.println("    <div class=\"form-group row\">");
            out.println("        <div class=\"col-sm-10 text-center\">");
            out.println("            <button type=\"submit\" class=\"btn btn-primary\">Add</button>");
            out.println("        </div>");
            out.println("    </div>");
            
            out.println("</form>");
            
            out.println("</div>");

            out.println("<div class=\"image-column justify-content-center align-items-center\">");
            out.println("<img src=\"img/police.png\" alt=\"\" class=\"img-fluid\" style=\"box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\">");
            out.println("</div>");
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(updatePolice.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
     private boolean isStatusSelected(String currentStatus, String targetStatus) {
    return (currentStatus != null && currentStatus.equals(targetStatus));
}
}
