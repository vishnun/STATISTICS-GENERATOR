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
public class compareconnect {

    static String colnames[]=new String[10];
    static int cnt;
    static int col;
/**

@param args

*/

public static void connectcompare(boolean comp,String roll1,String roll2,String table,int type) throws Exception {
int maxkey=0;
int [] marks = new int[10];
String pkey;
int [] total=new int[10];
int [] marks2=new int[10];
int count=0;
for(int i=0;i<10;i++)
{
    total[i]=0;
}
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
Statement stmt2 = null;
ResultSet rs = null;
ResultSet rs2=null;
stmt = conn.createStatement();
stmt2 = conn.createStatement();
rs=stmt.executeQuery("SELECT * FROM " + table);
int numCols = rs.getMetaData().getColumnCount ();
for(int i=1;i<=numCols;i++)
{
    colnames[i]=rs.getMetaData().getColumnName(i);
}
rs.close();
pkey=colnames[1];
rs = stmt.executeQuery("SELECT * FROM " +table+ " where " + pkey + "=" + Integer.parseInt(roll1));

col=numCols;
System.out.println(numCols);
//******************* GET COLUMN marks************
while(rs.next()){
for (int i=1; i<=numCols; i++) {
//System.out.print("<td>" + rs.getString(i) + "</td>" );
marks[i]=Integer.parseInt(rs.getString(i));
}
    }
rs2=stmt2.executeQuery("SELECT * FROM "+table+" where " + pkey + "=" +Integer.parseInt(roll2));
while(rs2.next()){
for (int i=1; i<=numCols; i++) {
//System.out.print("<td>" + rs.getString(i) + "</td>" );
marks2[i]=Integer.parseInt(rs2.getString(i));
}
}

rs=stmt.executeQuery("SELECT * FROM " + table);
while(rs.next()){
    if(Integer.parseInt(rs.getString(2)) > maxkey)
             {
        maxkey=Integer.parseInt(rs.getString(2));
    }
count++;
}
rs.close();
for(int j=1;j<=numCols;j++)
{
    rs = stmt.executeQuery("SELECT * FROM " + table);
    while(rs.next())
    {
        total[j]=total[j]+Integer.parseInt(rs.getString(j));
    }
    total[j]=total[j]/count;
    rs.close();
}
} catch (SQLException ex) {

// handle any errors

System.out.println("SQLException: " + ex.getMessage());

System.out.println("SQLState: " + ex.getSQLState());

System.out.println("VendorError: " + ex.getErrorCode());

}
colnames[col+1]=roll1;
colnames[col+2]=roll2;
System.out.println("maxval=" + maxkey);
if(type==1)
{
linegraph2.plotgraph2(comp,marks,marks2,col,colnames,maxkey);
    }
else if(type==2)
comparegraph.plotgraph(comp, marks, marks2, col, colnames,maxkey);
else if (type==4)
averageGraph.plotgraph(total, col, colnames,maxkey);
}

}
