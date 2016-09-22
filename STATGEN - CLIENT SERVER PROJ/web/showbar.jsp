<%--
    Document   : home
    Created on : Apr 13, 2011, 2:39:43 PM
    Author     : vishnu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<%
   String usersh=(String)session.getAttribute("userh");
   session.setAttribute("usersh",usersh);
    String key=(String) request.getParameter("drop");
   String user1;
   //String table=(String)session.getAttribute("fname");
    //String temp=table;
    //table=temp.substring(0,temp.lastIndexOf("."));
String table="user1";
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
rs=stmt.executeQuery("select * from " + table);
int numCols = rs.getMetaData().getColumnCount ();
String colnames[]=new String[numCols + 1];
for(int ic=1;ic<=numCols;ic++)
{
    colnames[ic]=rs.getMetaData().getColumnName(ic);
}
user1=colnames[1];
rs.close();
%>
<table border="0" align="center" width="60%">
    <tr height="400px">
    <%
    String command = "Select * from " + table + " where "+user1+"  = '" + key + "'";
    rs=stmt.executeQuery(command);
    int max=0;
    while(rs.next())
    {
    for(int i=2;i<=numCols;i++)
    {
        if(Integer.parseInt(rs.getString(i))>=max)
            max=Integer.parseInt(rs.getString(i));
    }
    }
    int maxscale=(max/100)+1;
    maxscale*=100;
    rs.close();
 %>
 <td valign="bottom" width="">
     <table height="100%" cellpadding="0" cellspacing="0" >
         <%
         int x=0;
         for(int i=1;i<=10;i++)
         {
         %>
         <tr>
             <td height="40" valign="top" >
             <%= (maxscale -x) %>
             <% x=x + (maxscale/10); %>
             </td>
         </tr>
         <%
         }
         %>
     </table>
 </td>
 <%
    rs=stmt.executeQuery(command);
    while(rs.next())
    {
    for(int j=2;j<=numCols;j++)
    {
        %>
        <td valign="bottom" bgcolor="black" >
            <%= j %>
            <img src="blue.jpg" height="<%= (((float)Integer.parseInt(rs.getString(j))/maxscale) * 100)%>%" width="100%" >
        </td>
        <%
        }
    }
    %>
    </tr>

    <tr>
        <td></td>
        <%
rs.close();
rs=stmt.executeQuery(command);
while(rs.next())
{
for(int i=2;i<=numCols;i++){
    %>
    <td align="center" > <h4> <%= colnames[i] %> <br> ( <%=rs.getString(i)%> ) </h4></td>
    <%
}
}
%>

    </tr>
</table>
    