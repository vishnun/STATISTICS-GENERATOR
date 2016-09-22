/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package statgen;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
/**
 *
 * @author vishnu
 */
public class averageGraph extends Frame {
  /*
   * Name: Vishnu Narang
   * Subject: STATGEN Java project
   * College: PICT
	 */

static String str;
static int maxvallen=0;
static int maxkey=0;
static int i,j;
static int pcol;
static int[] mrks=new int[10];
static String colnames[]=new String[10];
private static final long serialVersionUID = 1L;
  public void paint(Graphics g) {
    Graphics2D ga = (Graphics2D)g;
    ga.drawLine(100,10,100,600 );   //X-axis
    ga.drawLine(100,600,800,600);	//Y-axis
    int m=0,mx=120,my=600;
        int maxy=0;
    //****************** GET power function
    maxy = (int) Math.pow(10, maxvallen - 1);
    int mxy=maxy;
    //To get maxy for scaling y axis
    while(maxy<maxkey)
    {
        maxy=maxy + mxy;
     }

    System.out.println("maxy: " + maxy);
    for(int i=0;i<11;i++)
    {
      String ms=String.valueOf(m);
      ga.drawString(ms, 50, my);
      m=m+maxy/10; // change needed here
      my=my-50; //Make needed changes here
      ga.drawLine(100, my, 700, my);
    }

    for(int i=2;i<=pcol;i++)
    {
        ga.drawString(colnames[i], mx, 620);
        mx=mx+60;
    }

    ga.drawString("AVERAGE", 650, 100);
    int rx=120;
    for(int i=2;i<=pcol;i++)
    {
        ga.setPaint(Color.RED);
        Shape r=new Rectangle2D.Double(rx,600-mrks[i]*(50/(maxy/10)) - maxy/10,20,mrks[i]*(50/(maxy/10)) + maxy/10);
        ga.fill(r);
        rx=rx+60;
      }
 }

  public static void plotgraph(int marks[],int col,String colname[],int maxval) throws Exception {
maxvallen=Integer.toString(maxval).length();
        maxkey=maxval;
        
        for(int i=1;i<=col;i++)
        {
                mrks[i]=marks[i];
                colnames[i]=colname[i];
        }
        colnames[col+1]=colname[col+1];
        pcol=col;
        final Frame frame = new averageGraph();
                frame.addWindowListener(new WindowAdapter(){
            @Override
    	public void windowClosing(WindowEvent we){
        frame.dispose();
      }
    });

    frame.setSize(1000,750);
    frame.setBounds(500, 0, 800, 750);
    frame.setVisible(true);
  }


}
