<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*" %>

<%
String pass = request.getParameter("password");
String user = request.getParameter("username");
session.setAttribute( "users", user );
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
String command = "Select * from userlogin where username ='" + user + "'";
rs=stmt.executeQuery(command);
while(rs.next())
{
    if(rs.getString(2).equals(pass))
    {
        %>
        <html>
        <body>
            <jsp:forward page="home.jsp"/>
    </body>
    </html>
    <%
    }
    else
        {
        %>
        <html>
            <body>
                <script type="text/javascript">
                    window.location="index.html";
                    alert("Password and usrname do not match !");
                </script>
    </body>
        </html>
    <%
    }
}
%>
