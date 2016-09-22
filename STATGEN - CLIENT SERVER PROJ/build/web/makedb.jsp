<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@page import="java.awt.*" %>
<%@page import="java.io.*" %>
<%@page import="java.io.IOException"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="jxl.*" %>
<%@page import="jxl.Workbook" %>
<%@page import="org.jdesktop.application.*" %>
<%@page import="java.sql.*" %>

<%
    String fname1=(String)session.getAttribute("fname");
    File inputworkbook =new File(fname1);
    Workbook w;
    try
    {w=Workbook.getWorkbook(inputworkbook);
     Sheet sheet =w.getSheet(0);
     int size;
     if(sheet.getRows()>sheet.getColumns())
          size=sheet.getRows();
     else
          size=sheet.getColumns();
     String[][] records=new String[size][size];
     //String[][] records=new String[sheet.getRows()][sheet.getColumns()];
     int maxrow=sheet.getRows();
     int maxcolumn=sheet.getColumns();
     //System.out.println(sheet.getColumns());
     //System.out.println(sheet.getRows());
     for (int i = 0; i < sheet.getColumns(); i++) {
				for (int j = 0; j < sheet.getRows(); j++) {
					Cell cell = sheet.getCell(i, j);
					CellType type = cell.getType();
					/*if (cell.getType() == CellType.LABEL) {
						System.out.println("I got a label "
								+ cell.getContents());
					}

					if (cell.getType() == CellType.NUMBER) {
						System.out.println("I got a number "
								+ cell.getContents());
					}

                                         */
                                records[j][i]=(String)cell.getContents();
				System.out.println(records[i][j]+i+j);
                                }



			}
     /*for (int i = 0; i < maxrow; i++) {
		for (int j = 0; j < maxcolumn; j++) {
			System.out.print(records[i][j]);
		}
        }*/
//    String temp=fname1;
//    fname1=temp.substring(0,temp.lastIndexOf("."));

String table = "user1" ;//fname1;
String str[][]=records;
int row=maxrow,column=maxcolumn;
 //String[][] str = new String[20][20];   // 2D array
//String[][] str={{"n","i","l"},{"4","5","6"},{"7","8","9"}};
for (int i = 0; i < row; i++) {
    System.out.println();
    for (int j = 0; j < column; j++) {
			System.out.print(str[i][j]);
		}
        }
//int row = 3;                           // rows
//int column = 3;                        // column
// Drivers for connection to MySQL
try{
// gets the jdbc driver
Class.forName("com.mysql.jdbc.Driver").newInstance();
}
catch (Exception ex){
// exception handling for jdbc driver
System.out.println("error \n");
}

// Making the connection using the driver
try{
// URL settings
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/statgen", "root", "vishnu");
// Do something with the Connection
Statement stmt = null;
stmt = conn.createStatement();
// Drop the table if existing
try{
    stmt.executeUpdate("DROP TABLE " + table);
}
catch(Exception ex){

}
// Dynamic creation of table

// string for query
String query = "Create table "+table+" (";
    int i=0;
    for(int j=0 ; j<column;j++)
    {
        if(j==0)
        {
            query = query + str[i][j]+" varchar(4) primary key,";
        }
        else if(j==column-1)
        {
            query = query + str[i][j]+" varchar(4))";
        }
        else
        {
            query = query + str[i][j]+" varchar(4),";
        }
    }
// executing the query
stmt.executeUpdate(query);
System.out.println(query);

// Insertion into the table

// string for query
for(i=1;i<row;i++)
{
    query= null;
    query="Insert into "+table+" values (";
    for(int j=0;j<column;j++)
    {
        if(j==column-1)
        {
            query=query+"'"+str[i][j]+"')";
        }
        else
        {
            query=query+"'"+str[i][j]+"',";
        }
    }
    // execute the query
    stmt.executeUpdate(query);
}
}

 catch (SQLException ex) {
// handle any errors of connection
System.out.println("SQLException: " + ex.getMessage());
System.out.println("SQLState: " + ex.getSQLState());
System.out.println("VendorError: " + ex.getErrorCode());
}



    }
     catch (Exception e) {
			e.printStackTrace();
		}

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:forward page="home.jsp" />
    </body>
</html>
