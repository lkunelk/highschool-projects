/**
 * @(#)MyNotFirstGUI.java
 *
 *
 * @author 
 * @version 1.00 2014/2/26
 */
 
import javax.swing.*;
import java.awt.*;
import java.io.*;
 
public class MyNotFirstGUI implements ActionListener extends JPanel{

	int x = 100;
	int y = 100;
	
	public static void main(String[] arg){
		MyNotFirstGUI gui = new MyNotFirstGUI();
		gui.begin();
	}//END main()

    public void begin() {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	JFrame frame = new JFrame("MyNotFirstGUI program");
    	
    	JButton button = new JButton();
    	button.addActionListener(this);
    	
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().add(this);
    	frame.setSize(1000,1000);
    	frame.setVisible(true);
    	frame.setResizable(false);
    }
    
    
    public void paintComponent(Graphics g){
    	System.out.println("Erno here!");
    	
    	Graphics2D g2d = (Graphics2D) g;
    	
    	g2d.setColor(Color.black);
    	g2d.fillRect(0,0,this.getWidth(),this.getHeight());
    	
    	int red = (int)(Math.random()*255);
    	int green = (int)(Math.random()*255);
    	int blue = (int)(Math.random()*255);
    	Color color1 = new Color(red,green,blue);
    	
    	red = (int)(Math.random()*255);
    	green = (int)(Math.random()*255);
    	blue = (int)(Math.random()*255);
    	Color color2 = new Color(red,green,blue);
    	
    	red = (int)(Math.random()*255);
    	green = (int)(Math.random()*255);
    	blue = (int)(Math.random()*255);
    	Color color3 = new Color(red,green,blue);
    	
    	
    	Polygon p = new Polygon();
    	p.addPoint(100,300);
    	p.addPoint(500,300);
    	p.addPoint(700,100);
    	p.addPoint(300,100);
    	
    	Polygon a = new Polygon();
    	a.addPoint(100,300);
    	a.addPoint(100,700);
    	a.addPoint(500,700);
    	a.addPoint(500,300);
    	
    	Polygon b = new Polygon();
    	b.addPoint(500,300);
    	b.addPoint(500,700);
    	b.addPoint(700,500);
    	b.addPoint(700,100);
    	
    	g2d.setColor(color1);
    	g2d.fillPolygon(p);
    	g2d.setColor(color2);
    	g2d.fillPolygon(a);
    	g2d.setColor(color3);
    	g2d.fillPolygon(b);
    	
    	GradientPaint gradient = new GradientPaint(70,70,color1,150,150,color2);
    	
    	g2d.setPaint(gradient);
    	g2d.fillOval(70,70,100,100);
    	
    }
    
}
