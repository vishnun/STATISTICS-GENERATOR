/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package statgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author vishnu
 */
public class compare {


  public static void getlist2(java.awt.Choice rlist,java.awt.Choice rlist2,String table) throws Exception {
    rlist.removeAll();
    rlist2.removeAll();
      try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
    }

catch (Exception ex) {
System.out.println("error \n");
}


Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/graph", "root", "vishnu");
// Do something with the Connection
Statement stmt = null;
ResultSet rs = null;
stmt = conn.createStatement();
rs = stmt.executeQuery("SELECT * FROM " + table);
int numCols = rs.getMetaData().getColumnCount ();
while(rs.next())
{   // colnames[i]=rs.getMetaData().getColumnName(i);
   rlist.addItem(rs.getString(1));
   rlist2.addItem(rs.getString(1));
}
//col=numCols;
System.out.println(numCols);
//******************* GET COLUMN marks************
while(rs.next()){
for (int i=1; i<=numCols; i++) {
//System.out.print("<td>" + rs.getString(i) + "</td>" );
//marks[i]=Integer.parseInt(rs.getString(i));
    }
   }//While

}//Main Ends
}//Class ends

