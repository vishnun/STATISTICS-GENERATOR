package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");


String user1=(String)session.getAttribute( "users" );
session.setAttribute("userh",user1);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title> Statistics Generator </title>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("    .main {\n");
      out.write("        height:100%;\n");
      out.write("}    \n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div id=\"main\" class=\"main\">\n");
      out.write("\n");
      out.write("<table border=\"1px\" width=\"100%\" height=\"100%\" cellpadding=\"0px\" cellspacing=\"0px\">\n");
      out.write("<tr>\n");
      out.write("<td height=\"15%\" width=\"50%\" align=\"left\"> <img src=\"\" width=\"50%\" /> </td>\n");
      out.write("\n");
      out.write("<td align=\"center\" >\n");
      out.write("\n");
      out.write("    <table border=\"0px\"  width=\"100%\" height=\"100%\" cellpadding=\"0px\" cellspacing=\"0px\">\n");
      out.write("<tr>\n");
      out.write("<td align=\"center\">\n");
      out.write("    Hello,<font size=\"6\" > <i><b>");
      out.print( (String) session.getAttribute("users") );
      out.write("</b></i></font>\n");
      out.write("[ <a href=\"index.html\">Home</a> ]\n");
      out.write("[ <a href=\"#\">Help</a> ]\n");
      out.write("[ <a href=\"#\">Gallery</a> ]\n");
      out.write("[ <a href=\"#\">Videos</a> ]\n");
      out.write("[ <a href=\"#\">Developers</a> ]\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("    <td align=\"center\" colspan=\"2\" height=\"600\" >\n");
      out.write("<form METHOD=post ACTION=\"fileupload.jsp\" ENCTYPE=\"multipart/form-data\">\n");
      out.write("<input TYPE=\"file\" NAME=\"filename\"/> <br><br>\n");
      out.write("<input type=\"submit\" value=\"Send\" />\n");
      out.write("</form>\n");
      out.write("        <br>\n");
      out.write(" <br>\n");
      out.write("\n");
      out.write("<FORM\tAction=\"showbar.jsp\">\n");
      out.write("<SELECT\tNAME=\"drop\"\tSIZE=3 multiple>\n");

try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
    }

catch (Exception ex) {
System.out.println("error \n");
}

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/statgen", "root", "vishnu");
// Do something with the Connection
Statement stmt = null;
ResultSet rs = null;
stmt = conn.createStatement();
String table=(String)session.getAttribute("fname");
String temp=table;
table=temp.substring(0,temp.lastIndexOf("."));

String command = "Select * from user1"; //+ table;
rs=stmt.executeQuery(command);
while(rs.next())
{

      out.write("\n");
      out.write("<OPTION> ");
      out.print( rs.getString(1) );
      out.write('\n');

}

      out.write("\n");
      out.write("</SELECT>\n");
      out.write("<input type =\"submit\">\n");
      out.write("</FORM>\n");
      out.write("</font>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td height=\"10%\" width=\"40%\" align=\"right\"> <a href=\"#\">&copy; Project StatGen 2011 </a></td>\n");
      out.write("<td height=\"10%\" width=\"60%\"> </td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("function go()\n");
      out.write("{\n");
      out.write("    PageIndex2=document.form2.select2.selectedIndex\n");
      out.write("if (document.form2.select2.options[PageIndex2].value != \"none\")\n");
      out.write("{\n");
      out.write("    myfile=\"showbar.jsp\";\n");
      out.write("    window.open(myfile);\n");
      out.write("}\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
