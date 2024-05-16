package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entities.report;
import com.dao.reportDao;
import java.util.List;
import com.entities.chargesheet;
import com.dao.chargesheetDao;
import com.conn.DbConnect;

public final class displayaccptedcharge_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/navbar.jsp");
    _jspx_dependants.add("/allcomponet/allCss.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("  body {\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h2 {\n");
      out.write("        color: #333; \n");
      out.write("        background-color: #f2f2f2; \n");
      out.write("        padding: 10px; \n");
      out.write("        border-radius: 5px; \n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .center-table {\n");
      out.write("        margin: 60px;\n");
      out.write("        width: 80%;\n");
      out.write("        text-align: center;\n");
      out.write("        /*overflow-x: auto;*/ \n");
      out.write("    }\n");
      out.write("\n");
      out.write("    table {\n");
      out.write("        width: 100%; \n");
      out.write("        max-width: 100%; \n");
      out.write("        border-collapse: collapse;\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    th, td {\n");
      out.write("        border: 1px solid #ddd;\n");
      out.write("        padding: 8px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    th {\n");
      out.write("        background-color: #4CAF50; \n");
      out.write("        color: white;\n");
      out.write("    }\n");
      out.write("   .btn-p1 {\n");
      out.write("    background-color: purple;\n");
      out.write("    color: white;\n");
      out.write("    padding: 10px 20px;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    text-decoration: none; /* Remove default underline for links */\n");
      out.write("    display: inline-block; /* Ensures proper inline display */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".back-img {\n");
      out.write("    background: url(\"img/c4.png\");\n");
      out.write("    width: 100%;\n");
      out.write("    height: 30%; /* Set the height to 30% of the viewport */\n");
      out.write("    background-repeat: no-repeat;\n");
      out.write("    background-size: cover;\n");
      out.write("    background-position: center center; /* Position the background image in the center */\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" \n");
      out.write("      integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" \n");
      out.write("      crossorigin=\"anonymous\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\n");
      out.write("    integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" \n");
      out.write("    crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\"\n");
      out.write("integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\" \n");
      out.write("integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\n");
      out.write("crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css\"\n");
      out.write("      integrity=\"sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==\"\n");
      out.write("      crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("\n");
      out.write("<link href=\"style1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <link href=\"allcomponet/style1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    \n");
      out.write("        <style>\n");
      out.write("    .icon-container {\n");
      out.write("    background-color: white;\n");
      out.write("    border-radius: 50%;\n");
      out.write("    width: 20px;\n");
      out.write("    height: 20px;\n");
      out.write("    display: flex;\n");
      out.write("    align-items: center;\n");
      out.write("    justify-content: center;\n");
      out.write("    margin: 0 5px;\n");
      out.write("    position: relative;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".icon-container i {\n");
      out.write("    color: #007bff; /* Primary color for the icon */\n");
      out.write("}\n");
      out.write("\n");
      out.write(".view-link {\n");
      out.write("    margin-left: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Optional: Add some hover effect */\n");
      out.write(".icon-container:hover {\n");
      out.write("    background-color: #007bff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".icon-container:hover i {\n");
      out.write("    color: white;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark nav\" >\n");
      out.write("    <a class=\"navbar-brand\"><span class=\"fa fa-plus-square\"></span>Crime Management System</a>\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"index.jsp\"><span class=\"fa fa-institution\"></span>Home</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("          <a class=\"nav-link\" href=\"admin.jsp\"><span class=\"fa fa-id-card\"></span>DashBoard</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("          <a class=\"nav-link\" href=\"addnews.jsp\"><span class=\"fa fa-id-card\"></span>News Update</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"displayadmin\"><span class=\"fa fa-institution\"></span>View Complaint</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("          <a class=\"nav-link\" href=\"displayFIR.jsp\"><span class=\"fa fa-id-card\"></span>View FIR</a>\n");
      out.write("      </li>\n");
      out.write("     <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"displayAccptedFir.jsp\"><span class=\"fa fa-institution\"></span>View Chargesheet</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"displayaccptedcharge.jsp\"><span class=\"fa fa-institution\"></span>Crime Report</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link disabled\" href=\"#\">Disabled</a>\n");
      out.write("      </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"#\" target=\"_blank\">\n");
      out.write("                    <div class=\"icon-container\"><i class=\"fab fa-facebook-f\"></i></div></a>\n");
      out.write("            </li>\n");
      out.write("             <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"#\" target=\"_blank\">\n");
      out.write("                    <div class=\"icon-container\"><i class=\"fab fa-twitter\"></i></div></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"#\" target=\"_blank\">\n");
      out.write("                    <div class=\"icon-container\"><i class=\"fab fa-instagram\"></i></div></a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("        <a href=\"LogOut\" class=\"btn btn-danger\">LogOut</a>\n");
      out.write("       \n");
      out.write("    </div>\n");
      out.write("    </nav>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write(" <br>\n");
      out.write("        <br>\n");
      out.write("    <div class=\"back-img\">\n");
      out.write("    <div class=\"container-fluid p-0 m-0\" >\n");
      out.write("        <center><h1 class=\"card-title\" style=\"font-family: Algerian; font-size: 60px;\">FIR DETAIL</1></center>\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"center-table\">\n");
      out.write("    <table border='1'>\n");
      out.write("        ");

            chargesheetDao dao2 = new chargesheetDao(DbConnect.getConn());
            List<chargesheet> list = dao2.getAccptedcharge();
        
      out.write("\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <th>FIR Id</th>\n");
      out.write("            <th>chargesheet Id</th>\n");
      out.write("            <th>Section</th>\n");
      out.write("            <th>Brief Description</th>\n");
      out.write("            <th>Chargesheet Report</th>\n");
      out.write("            <th>Chargesheet Date</th>\n");
      out.write("            <th>Chargesheet Status</th>\n");
      out.write("        </tr>\n");
      out.write("       ");
 
            for(chargesheet ch: list) {
        
      out.write("\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("         <td>");
      out.print( ch.getId() );
      out.write("</td> \n");
      out.write("         <td>");
      out.print( ch.getFid() );
      out.write("</td> \n");
      out.write("         <td>");
      out.print( ch.getSection() );
      out.write("</td> \n");
      out.write("         <td>");
      out.print( ch.getBriefdesc() );
      out.write("</td> \n");
      out.write("         <td>");
      out.print( ch.getBriefdesc() );
      out.write("</td> \n");
      out.write("         <td>");
      out.print( ch.getDate() );
      out.write("</td> \n");
      out.write("         <td>");
      out.print( ch.getStatus() );
      out.write("</td>\n");
      out.write("         \n");
      out.write("         <td>\n");
      out.write("            ");
 
                int id = ch.getId();
                reportDao dao1 = new reportDao(DbConnect.getConn());
                List<report> reList = dao1.isReportReg(id);
                if (reList != null && !reList.isEmpty()) {
            
      out.write("\n");
      out.write("                    <a href='' class='btn-purple'>View FIR</a>\n");
      out.write("            ");

                } else {
            
      out.write("\n");
      out.write("                    <a href='report1.jsp?id=");
      out.print( ch.getFid() );
      out.write("' class='btn-purple'>File report</a>\n");
      out.write("            ");

        }
           
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("         ");
  }
      out.write("\n");
      out.write("    </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
