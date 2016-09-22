/*
 * StatgenApp.java
 */
package statgen;

import java.awt.Choice;
import java.io.File;
import java.io.IOException;
//package xlsinclude;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.Workbook;
import java.io.*;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import java.sql.*;


/**
 * The main class of the application.
 */
public class StatgenApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new StatgenView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of StatgenApp
     */
    public static StatgenApp getApplication() {
        return Application.getInstance(StatgenApp.class);
    }

    /**
     * Main method launching the application.
     */

    public static String fname=new String();

    public static void readsheet()
    {File inputworkbook =new File(fname);

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
    connect(records,maxrow,maxcolumn);
    }
     catch (Exception e) {
			e.printStackTrace();
		}
    }

static String table = "mytable";

public static void connect(String str[][],int row,int column)
{
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
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graph", "root", "vishnu");
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
    public static void main(String[] args) {
        launch(StatgenApp.class, args);
               
        }
    }
