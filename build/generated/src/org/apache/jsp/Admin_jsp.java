package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("       <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        \n");
      out.write("        <title>Admin Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"data\">\n");
      out.write("        <div id=\"data6\">\n");
      out.write("         <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <h2>System Administration</h2>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("         \n");
      out.write("      <table border=\"0\">\n");
      out.write("            \n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                       <form method=\"POST\" action=\"LoginServlet\">                \n");
      out.write("                            <table border=\"0\">\n");
      out.write("                                \n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><label for=\"NewItem\"> Register new item:: </label></td>\n");
      out.write("                                        <td>\n");
      out.write("                                                                                 </select></td>\n");
      out.write("                                        <select>\n");
      out.write("                                         <option>workers</option>\n");
      out.write("                                         <option>Route</option>\n");
      out.write("                                        </select></td>\n");
      out.write("                                        \n");
      out.write("                               \n");
      out.write("                                    </tr>\n");
      out.write("                                   \n");
      out.write("                                  \n");
      out.write("                                    \n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                         \n");
      out.write("                             <input type=\"submit\" value=\"submit\"  />\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        </form>\n");
      out.write("                       \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("               \n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write(" </div>\n");
      out.write("      <div id=\"data7\">      \n");
      out.write("<div id=\"data3\">\n");
      out.write("                 <a href=\"index.jsp\"><img src=\"images/download.jpg\" ></a>\n");
      out.write(" </div>  \n");
      out.write("          </div>\n");
      out.write("  </div>\n");
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
