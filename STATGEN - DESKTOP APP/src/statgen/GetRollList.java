package statgen;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class GetRollList {

  public static void main(String [] args,java.awt.Choice rlist) throws Exception {
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
rs = stmt.executeQuery("SELECT * FROM student");
int numCols = rs.getMetaData().getColumnCount ();
while(rs.next())
{   // colnames[i]=rs.getMetaData().getColumnName(i);
   rlist.addItem(rs.getString(1));
}
//col=numCols;
System.out.println(numCols);
}//Main Ends
}//Class ends
