package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entities.User;

public final class adminreg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/allcomponet/allCss.jsp");
    _jspx_dependants.add("/normal_navbar.jsp");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<link href=\"allcomponet/style1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("<style>\n");
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
      out.write("\n");
      out.write("</style>\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark nav\" >\n");
      out.write("    <a class=\"navbar-brand\" href=\"index.jsp\"><span class=\"fa fa-star\"></span>Home</a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("        <ul class=\"navbar-nav\">\n");
      out.write("            <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"#\"><span class=\"fa fa-plus-square\"></span>About us <span class=\"sr-only\">(current)</span></a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"login.jsp\"><span class=\"fa fa-user-circle\"></span>Login</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"register.jsp\"><span class=\"fa fa-user-plus\"></span>Sign up</a>\n");
      out.write("            </li>\n");
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
      out.write("\n");
      out.write("        ");
 User user = (User) session.getAttribute("user");
        if (user == null) { 
      out.write("\n");
      out.write("            <form class=\"form-inline my-2 my-lg-0 ml-auto\">\n");
      out.write("                <a href=\"index.jsp\" class=\"btn btn-success\">Login</a>\n");
      out.write("                <a href=\"register.jsp\" class=\"btn btn-danger ml-2\">Register</a>\n");
      out.write("            </form>\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("            <form class=\"form-inline my-2 my-lg-0 ml-auto\">\n");
      out.write("                <a data-toggle=\"modal\" data-target=\"#exampleModal\" class=\"btn btn-success ml-2 text-white\">");
      out.print( user.getName() );
      out.write("</a>\n");
      out.write("                <a data-toggle=\"modal\" data-target=\"#exampleModalCenter\" class=\"btn btn-danger ml-2 text-white\">LogOut</a>\n");
      out.write("            </form>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- User Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header bg-primary text-white text-center\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Crime Management System</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"container text-center\">\n");
      out.write("                        ");
 if (user != null) { 
      out.write("\n");
      out.write("                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">");
      out.print( user.getName() );
      out.write("</h5>\n");
      out.write("                            <!-- User table -->\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th scope=\"row\">ID</th>\n");
      out.write("                                        <td>");
      out.print( user.getId() );
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th scope=\"row\">Name</th>\n");
      out.write("                                        <td>");
      out.print( user.getName() );
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th scope=\"row\">Email</th>\n");
      out.write("                                        <td>");
      out.print( user.getEmail() );
      out.write("</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                            <p>No user data available.</p>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\">EDIT</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Modal -->\n");
      out.write("\n");
      out.write("    <!-- logout -->\n");
      out.write("\n");
      out.write("    <!-- Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"exampleModalCenter\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLongTitle\">LogOut</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body text-center\">\n");
      out.write("                    <h6>Do You want LogOut..</h6>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    <a href=\"LogOut\" class=\"btn btn-primary\">LogOut</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- logout -->\n");
      out.write("    \n");
      out.write("   \n");
      out.write("</nav>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("    <div class=\"row p-2\">\n");
      out.write("        <div class=\"col-md-6 offset-md-3\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h4 class=\"text-center text-success\">Admin Registration Page</h4>\n");
      out.write("                    \n");
      out.write("<form action=\"register\" method=\"post\">\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"exampleInputEmail1\">Email address</label>\n");
      out.write("    <input type=\"email\" class=\"form-control\" name=\"email\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" required>\n");
      out.write("    <small id=\"emailHelp\" class=\"form-text text-muted\">We'll never share your email with anyone else.</small>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"exampleInputPassword1\">Password</label>\n");
      out.write("    <input type=\"password\" class=\"form-control\" name=\"password\" id=\"exampleInputPassword1\" required>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"exampleInputText1\">Code</label>\n");
      out.write("    <input type=\"text\" class=\"form-control\" name=\"code\" id=\"exampleInputPassword1\" required>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-check\">\n");
      out.write("    <input type=\"checkbox\" class=\"form-check-input\" id=\"exampleCheck1\" required>\n");
      out.write("    <label class=\"form-check-label\" name=\"check\" for=\"exampleCheck1\">accept terms & condition</label>\n");
      out.write("  </div>\n");
      out.write("    <div class=\"text-center mt-2\">\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary\">Register</button>\n");
      out.write("    </div> \n");
      out.write("</form>\n");
      out.write("                    \n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
