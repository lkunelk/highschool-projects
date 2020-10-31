package qBoT;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class CreditsPanel extends AppPanel
{
	private final double SCALE_X = (double)SCREEN_WIDTH/1366.0;
	private final double SCALE_Y = SCALE;

	private final Image ABOUT_IMAGE = new ImageIcon("img/about.png").getImage();

	private final int FONT_SIZE = (int)(60*SCALE_X);
	private final Font FONT = new Font("Monospaced",Font.ITALIC,FONT_SIZE);

	private final String[] TEXT = {"qBoT","Andy Rock","Nam Nguyen"};
	private final Point[] TEXT_LOCATION = 
	{
		new Point((int)(610*SCALE_X),(int)(150*SCALE_Y)),
		new Point((int)( 45*SCALE_X),(int)(281*SCALE_Y)),
		new Point((int)(979*SCALE_X),(int)(281*SCALE_Y)),
		new Point((int)(610*SCALE_X),(int)(695*SCALE_Y))
	};


	private final RoundRectangle2D.Double BACK_BUTTON = new RoundRectangle2D.Double(582*SCALE_X,647*SCALE_Y,200*SCALE_X,60*SCALE_Y,60*SCALE_Y,60*SCALE_Y);

	private boolean hover = false;

	private final Cursor DEFAULT_CURSOR = Cursor.getDefaultCursor();
	private final Cursor HAND_CURSOR    = new Cursor(Cursor.HAND_CURSOR);


	CreditsPanel()
	{
		addMouseMotionListener(new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent ME)
			{
				if(hover != (hover = BACK_BUTTON.contains(ME.getPoint())))
					repaint((int)BACK_BUTTON.x,(int)BACK_BUTTON.y,(int)BACK_BUTTON.width+1,(int)BACK_BUTTON.height+1);
				else
					return;
				setCursor(hover?HAND_CURSOR:DEFAULT_CURSOR);
			}
		});
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent ME)
			{
				if(BACK_BUTTON.contains(ME.getPoint()))
					setVisible(false);
			}
		});
		setVisible(false);
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(ABOUT_IMAGE,0,0,SCREEN_WIDTH,SCREEN_HEIGHT,null);
		g.setFont(FONT);
		g.setColor(hover?Color.WHITE:Color.BLACK);
		g.fillRoundRect((int)BACK_BUTTON.x,(int)BACK_BUTTON.y,(int)BACK_BUTTON.width,(int)BACK_BUTTON.height,(int)BACK_BUTTON.arcwidth,(int)BACK_BUTTON.archeight);
		g.setColor(hover?Color.BLACK:Color.WHITE);
		g.drawRoundRect((int)BACK_BUTTON.x,(int)BACK_BUTTON.y,(int)BACK_BUTTON.width,(int)BACK_BUTTON.height,(int)BACK_BUTTON.arcwidth,(int)BACK_BUTTON.archeight);
		g.drawString("back",TEXT_LOCATION[3].x,TEXT_LOCATION[3].y);
		g.setColor(Color.WHITE);
		for(int i=0;i<TEXT.length;i++)
			g.drawString(TEXT[i],TEXT_LOCATION[i].x,TEXT_LOCATION[i].y);
	}
}