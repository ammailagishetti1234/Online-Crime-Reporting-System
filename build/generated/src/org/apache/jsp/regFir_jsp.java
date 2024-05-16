package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entities.Admin;
import com.entities.User;
import java.util.List;
import com.entities.Complaint;
import com.dao.ComplaintDao;
import com.conn.DbConnect;

public final class regFir_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/allcomponet/allCss.jsp");
    _jspx_dependants.add("/navbar.jsp");
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

      out.write('\n');
      out.write('\n');
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
      out.write("        <style>\n");
      out.write("        body {\n");
      out.write("         text-align: center;\n");
      out.write("        }\n");
      out.write("         .center-container {\n");
      out.write("            text-align: left;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("         .center-container {\n");
      out.write("            text-align: left;\n");
      out.write("            display: inline-block;\n");
      out.write("            margin: 0 auto; \n");
      out.write("            width: 80%; \n");
      out.write("            border: 1px solid #ddd; \n");
      out.write("            padding: 20px; \n");
      out.write("        }\n");
      out.write("\n");
      out.write("    table {\n");
      out.write("        width: 100%; \n");
      out.write("        max-width: 100%; \n");
      out.write("        border-collapse: collapse;\n");
      out.write("        text-align: left;\n");
      out.write("    }\n");
      out.write("     th, td {\n");
      out.write("        border: 1px solid #ddd;\n");
      out.write("        padding: 8px;\n");
      out.write("    }\n");
      out.write("    .styled-table td:nth-child(6)\n");
      out.write("             {\n");
      out.write("                max-width: 150px;\n");
      out.write("                overflow: hidden;\n");
      out.write("                text-overflow: ellipsis;\n");
      out.write("            }\n");
      out.write("            .styled-table td:nth-child(7)\n");
      out.write("             {\n");
      out.write("                max-width: 150px;\n");
      out.write("                overflow: hidden;\n");
      out.write("                text-overflow: ellipsis;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <!--      admin navbar        -->\n");
      out.write("\n");
      out.write("\n");
      out.write("         ");
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
      out.write("\n");
      out.write("  \n");
      out.write("<!--navbar-->\n");
      out.write("\n");
      out.write("<div class=\"center-container\">\n");
      out.write("        <div class=\"center-table\">\n");
      out.write("            <table border='1' class=\"styled-table\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>Id</th>\n");
      out.write("                    <th>Complaint Detail</th>\n");
      out.write("                    <th>Complainer_Detail</th>\n");
      out.write("                    <th>Police_Station</th>\n");
      out.write("                    <th>Complaint type</th>\n");
      out.write("                    <th>Accused_detail</th>\n");
      out.write("                    <th>Victim_detail</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    Integer id = null;
                    String idParam = request.getParameter("id");
                    System.out.println("idParam: " + idParam);
//                    Integer fid = null;
//                    String fidParam = request.getParameter("fid");
                    if (idParam != null && !idParam.isEmpty()) {
                        id = Integer.parseInt(idParam);
                        System.out.println("idParam: " + idParam);
                        ComplaintDao dao = new ComplaintDao(DbConnect.getConn());
                        List<Complaint> list = dao.getComplaintFIR(id);
                    
                        for (Complaint c : list) {
                
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( c.getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getComplaint_detail() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getName() );
      out.write("<br> ");
      out.print( c.getEmail() );
      out.write(" <br> ");
      out.print( c.getPhone_no() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getPolice_city() );
      out.write("<br>");
      out.print( c.getPolice_state() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getTcrime() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getAccused_name() );
      out.write("<br>");
      out.print( c.getAccused_add() );
      out.write("<br>");
      out.print( c.getAccused_phno() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getVictim_name() );
      out.write("<br>");
      out.print( c.getVictim_add() );
      out.write("<br>");
      out.print( c.getVictim_phno() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write(" \n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <center><h3>FIR Registration</h3></center>\n");
      out.write("        \n");
      out.write("        ");
 String successMsg =(String)session.getAttribute("successMsg");
                       String errorMsg = (String)session.getAttribute("errorMsg");
                    if(successMsg!=null){
                    
      out.write("\n");
      out.write("                    <p class=\"text-sucess text-center\">");
      out.print(successMsg );
      out.write("</p>\n");
      out.write("                    ");
 session.removeAttribute("successMsg"); }

                     if(errorMsg!=null)
                    {
                    
      out.write("\n");
      out.write("                    <p class=\"text-danger text-center\">");
      out.print(errorMsg );
      out.write("</p>\n");
      out.write("                    ");
 
                        session.removeAttribute("errorMsg");
                    }
       
      out.write("\n");
      out.write("   <form action=\"regfir\" method=\"POST\">\n");
      out.write("  <div class=\"form-group row\">\n");
      out.write("      \n");
      out.write("       <input type=\"hidden\" name=\"id\" value=\"");
      out.print( c.getId() );
      out.write("\">\n");
      out.write("    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Section:</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <input type=\"text\" class=\"form-control\" name=\"section\" id=\"inputEmail3\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group row\">\n");
      out.write("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">Complaint Type</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <input type=\"text\" class=\"form-control\" name=\"comp_type\" id=\"inputPassword3\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <div class=\"form-group row\">\n");
      out.write("    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Reg Date:</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <input type=\"date\" class=\"form-control\" name=\"reg_date\" id=\"inputEmail3\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group row\">\n");
      out.write("    <label for=\"inputPassword3\" class=\"col-sm-2 col-form-label\">FIR Detail</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <textarea class=\"form-control\" name=\"fir\" id=\"exampleFormControlTextarea1\" rows=\"3\"></textarea>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <div class=\"form-group row\">\n");
      out.write("    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Fir Start Date:</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <input type=\"date\" class=\"form-control\" name=\"start_date\" id=\"inputEmail3\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    <div class=\"form-group row\">\n");
      out.write("    <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Fir End Date:</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <input type=\"date\" class=\"form-control\" name=\"end_date\" id=\"inputEmail3\">\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group row\">\n");
      out.write("      <label for=\"inputEmail3\" class=\"col-sm-2 col-form-label\">Status:</label>\n");
      out.write("      <select id=\"inputState\" class=\"col-sm-10\" name=\"status\">\n");
      out.write("        \n");
      out.write("        <option>Pending</option>\n");
      out.write("        <option>Active</option>\n");
      out.write("        <option>Under Progress</option>\n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("            \n");
      out.write(" \n");
      out.write("  <div class=\"form-group row\">\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("      <button type=\"submit\" class=\"btn btn-primary\"> FIR Register </button>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("   \n");
 
     }
        } else 
          {
             System.out.println("id is null");
           }

      out.write("\n");
      out.write("  \n");
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
