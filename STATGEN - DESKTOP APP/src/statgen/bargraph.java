package statgen;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vishnu
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
public class bargraph extends Frame {
  /*
   * Name: Vishnu Narang
   * Subject: STATGEN Java project
   * College: PICT
	 */

static String str;
static int i,j;
static int pcol;
static int[] mrks=new int[10];
static String colnames[]=new String[10];
private static final long serialVersionUID = 1L;
  public void paint(Graphics g) {
    Graphics2D ga = (Graphics2D)g;
    ga.drawLine(100,100,100,600 );   //X-axis
    ga.drawLine(100,600,600,600);	//Y-axis
    int m=0,mx=120,my=600;
    for(int i=0;i<10;i++)
    {
      String ms=String.valueOf(m);
      ga.drawString(ms, 50, my);
      m=m+10;
      my=my-50;
    }
    for(int i=2;i<=pcol;i++)
    {
        ga.drawString(colnames[i], mx, 620);
        mx=mx+60;
    }
    ga.drawString("Roll No: :" + colnames[pcol+1], 650, 100);

    int rx=120;
    for(int i=2;i<=pcol;i++)
    {
        ga.setPaint(Color.RED);
        Shape r=new Rectangle2D.Double(rx,600-mrks[i]*5,40,mrks[i]*5);
        ga.fill(r);
        rx=rx+60;
    }

 }

  public static void main(String args[],int marks[],int col,String colname[]) throws Exception {


        for(int i=1;i<=col;i++)
        {
                mrks[i]=marks[i];
                colnames[i]=colname[i];
        }
        colnames[col+1]=colname[col+1];
        pcol=col;
        final Frame frame = new bargraph();
        frame.addWindowListener(new WindowAdapter(){
            @Override
    	public void windowClosing(WindowEvent we){
        frame.dispose();
      }
    });

    frame.setSize(1000,750);
    frame.setVisible(true);
  }
}