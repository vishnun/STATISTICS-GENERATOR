<%--
    Document   : home
    Created on : Apr 13, 2011, 2:39:43 PM
    Author     : vishnu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<%
    String user1=(String)session.getAttribute( "userh" );
    int w[]=new int[5];
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
String command = "Select * from user1 where user ='" + user1 + "'";
rs=stmt.executeQuery(command);
int i=0;
while(rs.next())
{
    w[1]=Integer.parseInt(rs.getString(2));
    w[2]=Integer.parseInt(rs.getString(3));
    w[3]=Integer.parseInt(rs.getString(4));
    //w[4]=Integer.parseInt(rs.getString(4));
}
int totw=w[1]+w[2]+w[3]+w[4];
int mul;
if(totw > 0)
mul=900/totw;
else
{
%>
<html
    <body>
    <script type="text/javascript">
                    window.location="index.html";
                    alert("User data not found .. !");
     </script>
    </body>
</html>

<%
mul=1;
}
rs.close();


String colnames[]=new String[10];
rs=stmt.executeQuery("select * from user1");
int numCols = rs.getMetaData().getColumnCount ();
for(int ic=2;ic<=numCols;ic++)
{
    colnames[ic]=rs.getMetaData().getColumnName(ic);
}
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title> BAR GRAPH for USER <%= user1 %></title>
</head>
<body>
    BAR GRAPH for USER <b><font size="50" ><%= user1 %></b>
    <br></br>
    <br></br>

<table width="<%= totw * mul  +100%> " height="52" border="0" align="center">
  <tr>

      <td width ="100" align="centre"><%= colnames[1] %></td>
      <td   width=" <%= ((w[1])*totw/100) * mul %> "  height="46" bgcolor="#00FF00"></td>
    <td width="<%=( totw- ((w[1])*totw/100 ))*mul%>" bgcolor="#000000"></td>
  </tr>
</table>

<table width="<%= mul*totw +100 %>" height="52" border="0" align="center">
  <tr>
      <td width ="100" align="centre"><%= colnames[2] %></td>
    <td width="<%= ((w[2])*totw/100)*mul %>" height="46" bgcolor="#00FF00"></td>
    <td width="<%= (totw -  (w[2])*totw/100)*mul %>" bgcolor="#000000"></td>
  </tr>
</table>
<table width="<%= totw * mul   +100 %>" height="52" border="0" align="center">

  <tr>
      <td width ="100" align="centre"><%= colnames[3] %>  </td>
    <td width="<%= mul* ((w[3])*totw/100) %>" height="46" bgcolor="#00FF00"></td>
    <td width="<%=mul*( totw - (w[3])*totw/100) %>" bgcolor="#000000"></td>
  </tr>
</table>

<table width="<%= mul * totw  + 100 %> " height="52" border="0" align="center">
  <caption>
  </caption>
  <tr>
      <td width ="100" align="centre"><%= colnames[4] %></td>
    <td width="<%=mul* ( (w[4])*totw/100) %>" height="46" bgcolor="#00FF00"></td>
    <td width=" <%= mul* (totw - (w[4])*totw/100) %> *5" bgcolor="#000000"></td>
  </tr>
</table>
<p></p>
<p></p>
<p></p>
</body>
</html>
