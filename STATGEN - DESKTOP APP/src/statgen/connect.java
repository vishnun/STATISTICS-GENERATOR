/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package statgen;

import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vishnu
 */

public class connect {

    static String colnames[]=new String[10];
    static int cnt;
    static int col;
/**

@param args

*/

public static void main(String [] args,String roll) throws Exception {
int [] marks = new int[10];
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
}

catch (Exception ex) {
System.out.println("error \n");
}

try {
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graph", "root", "vishnu");
// Do something with the Connection
Statement stmt = null;
ResultSet rs = null;
stmt = conn.createStatement();
rs = stmt.executeQuery("SELECT * FROM student where roll ="+ Integer.parseInt(roll));
int numCols = rs.getMetaData().getColumnCount ();
for(int i=1;i<=numCols;i++)
{
    colnames[i]=rs.getMetaData().getColumnName(i);
}
col=numCols;
System.out.println(numCols);
//******************* GET COLUMN marks************
while(rs.next()){
for (int i=1; i<=numCols; i++) {
//System.out.print("<td>" + rs.getString(i) + "</td>" );
marks[i]=Integer.parseInt(rs.getString(i));
}
   }

} catch (SQLException ex) {

// handle any errors

System.out.println("SQLException: " + ex.getMessage());

System.out.println("SQLState: " + ex.getSQLState());

System.out.println("VendorError: " + ex.getErrorCode());

}
colnames[col+1]=roll;
bargraph.main(null,marks,col,colnames);
}
}
