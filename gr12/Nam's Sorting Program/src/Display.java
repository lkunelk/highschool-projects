//import classes
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Display extends JPanel{
	
	//class variables
	ArrayList<Colour> array;//stores values to be displayed
	int xCenter, yCenter;//stores the center of the lines
	int elementWidth = 6;//width of each line
	int elementHeight = 300;//height of each line
	int heightRange = 200;//the range from smallest to biggest element
	
	//constructor
	public Display(ArrayList<Colour> a){
		array = a;
	}//end constructor
	
	//method for updating the screen
	public void update(){
		repaint();
		validate();
	}//end update()
	
	//method for painting the array on screen
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		
		//recalculating the center
		xCenter = getWidth()/2 - elementWidth*(array.size()-1);
		yCenter = getHeight()/2 - (elementHeight-heightRange)/2;
		
		//draw background
		g2d.fillRect(0, 0, getWidth(), getHeight());
		
		//for each element in the array
		for(int i = 0; i < array.size(); i++){
			//drawing the line
			g2d.setStroke(new BasicStroke(elementWidth));
			g2d.setColor(new Color(Color.HSBtoRGB(array.get(i).getHue(), 1.0f,1.0f)));
			g2d.drawLine( (xCenter+i*(elementWidth*2) ), (0+yCenter - (int)(array.get(i).getHue()*heightRange)) , xCenter+i*(elementWidth*2) , (yCenter+elementHeight) );
		}
		
	}//end paintComponent()
}//end class
