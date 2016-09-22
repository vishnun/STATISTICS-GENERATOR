<%
String user1=(String)session.getAttribute( "users" );
session.setAttribute("userh",user1);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<html>
<head>
<title> Statistics Generator </title>

<style type="text/css">
    .steps{
        margin-left:50px;
}
</style>

</head>

<body>
<div id="main">
<table border="0px" width="100%" height="100%" cellpadding="0px" cellspacing="0px">
<tr bgcolor="">
<td height="15%" width="60%" align="middle"> <img src="images\stats.png" /> </td>

<td align="center">

<table border="0px" width="100%" height="100%" cellpadding="0px" cellspacing="0px">
<tr>
<td align="center">
Hello, <b><%= (String) session.getAttribute("users") %></b>
[ <a href="help.html">Help</a> ]
[ <a href="gallery.html">Gallery</a> ]
[ <a href="videos.html">Videos</a> ]
[ <a href="developers.html">Developers</a> ]
</td>
</tr>
<tr>
<td>
</td>
</tr>
<tr>
<td></td>
</tr>
</table>
</td>
</tr>

<tr>
<td align="center" height="500px">
    <div class="steps">
        <font face="calibri" size="5">
        <table width="100%">
        <tr>
            <td> Step 1 -> Upload a file (Choose a file by clicking on choose file button and then click on upload button) </td>
        </tr>
        <tr>
            <td align="center">
<form METHOD=post ACTION="fileupload.jsp" ENCTYPE="multipart/form-data">
<input TYPE="file" NAME="filename"/> 
<input type="submit" value="Upload" />
</form>
            </td>
        </tr>
        <tr>
            <td> <br><br><br>
                Step 2 -> Select a member from dropdown menu and click on showgraph
            </td>
        </tr>
        <tr>
            <td align="center">
<FORM	Action="showbar.jsp" target="right">
<SELECT	NAME="drop"	SIZE=3 multiple>
<%
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
//String table=(String)session.getAttribute("fname");
//String temp=table;
//table=temp.substring(0,temp.lastIndexOf("."));

String command = "Select * from user1"; //+ table;
rs=stmt.executeQuery(command);
while(rs.next())
{
%>
<OPTION> <%= rs.getString(1) %>
<%
}
%>
</SELECT><br>
<input type ="submit" value="show graph">
</FORM>
</font>
            </td>
        </tr>
    </table>
        </font>
    </div>
    </td>
<td>
<frameset frameborder="yes" border="1px">
    <iframe scrolling="yes" width="100%" height="100%" name="right" frameborder="1" src="#">
        
    </iframe>
</frameset>
</td>
</tr>

<tr>
<td height="75%" width="60%" align="top">
 </td>
<td height="75%" width="40%" >




<table width="100%">
<tr>
<td width="15%"></td>
<td align="left">


</td>
</tr>
</table>

</td>
</tr>

<tr>
<td height="10%" width="60%" align="right"> <a href="#">&copy; Project StatGen 2011 </a></td>
<td height="10%" width="40%"> </td>
</tr>
</table>
</div>
</body>
</html>