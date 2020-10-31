import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Screen extends JPanel{
	
	private ImageIcon background = new ImageIcon("bin/floor.png");//the background of the level
	boolean menu = true; // for deciding when to display the menu
	
	/*
	 * method for painting objects to screen
	 * pre-condition: planes, bullets arrays can't be null, 
	 * post-condition: planes and bullets are drawn on screen facing proper directions
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		//g2d.drawImage(background.getImage(), 0, 0, null);
		
	}//end paintComponent()
}
