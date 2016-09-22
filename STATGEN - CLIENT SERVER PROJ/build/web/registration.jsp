<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.sql.*" %>

<%
String user = request.getParameter("rusername");
String pass = request.getParameter("rpassword1");
String name = request.getParameter("name");
String email = request.getParameter("email");
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
int flag=1;
while(rs.next())
if(rs.wasNull())
{
    flag=1;
}
else
{
    flag=0;
 %>
        <html>
        <body>
            <Br><b>Username already registered...</b>
        </body>
    </html>
    <%
}

if(flag==1)
   {
    command = "INSERT INTO userlogin VALUES ('"+user+"','"+pass+"','"+name+"','"+email+"')";
    stmt.executeUpdate(command);

%>
    <jsp:forward page="test.html"/>
    <html>
        <body>
            <Br><b>Congrats...you have been successfully registered..</b>
        </body>
    </html>
    <%
    }
%>
