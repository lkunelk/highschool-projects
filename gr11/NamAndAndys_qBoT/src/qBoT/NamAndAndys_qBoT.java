/* qBoT
 * By: Andy Rock & Nam Nguyen
 *
 * Start Date: October 23, 2013
 * End Date: 
 */

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
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NamAndAndys_qBoT extends AppPanel
{
	private final Image[] COLOURS   = 
	{
		new ImageIcon("img/white.png") .getImage(),
		new ImageIcon("img/yellow.png").getImage(),
		new ImageIcon("img/orange.png").getImage(),
		new ImageIcon("img/blue.png")  .getImage(),
		new ImageIcon("img/green.png") .getImage(),
		new ImageIcon("img/red.png")   .getImage(),
		new ImageIcon("img/black.png") .getImage()
	};
	private final Image[] CUBEFACES = 
	{
		COLOURS[(int)(Math.random()*5+1)],COLOURS[(int)(Math.random()*5+1)],COLOURS[(int)(Math.random()*5+1)],
		null,                             COLOURS[(int)(Math.random()*5+1)],                             null,
		null,                             COLOURS[(int)(Math.random()*5+1)],                             null
	};
	private final Image TITLE = new ImageIcon("img/title.png").getImage();

	private final RoundRectangle2D.Double[] BUTTONS;
	private final Point[] BUTTON_LOCATIONS;
	private final String[] BUTTON_STRINGS = 
	{
		"robot (disabled)","sandbox","timer","credits","exit"
	};
	private boolean[] buttonHover = new boolean[5];

	private final int  FONT_SIZE   = (int)(50*SCALE);
	private final Font NORMAL_FONT = new Font("Monospaced",Font.ITALIC,          FONT_SIZE);
	private final Font HOVER_FONT  = new Font("Monospaced",Font.ITALIC+Font.BOLD,FONT_SIZE);

	private final Cursor DEFAULT_CURSOR = Cursor.getDefaultCursor();
	private final Cursor HAND_CURSOR    = new Cursor(Cursor.HAND_CURSOR);

	public static final boolean TRACING = false;

	public static void main(String[] args)
	{
		/*new JFrame()
		{{
			setSize(700,700);
			add(new QTimer());
			setVisible(true);
		}};*/
		new NamAndAndys_qBoT();
	}

	NamAndAndys_qBoT()
	{
		JFrame mainFrame = new JFrame();
		final SandboxPanel sandbox = new SandboxPanel();
		final QTimer timer = new QTimer();
		final CreditsPanel credits = new CreditsPanel();
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setUndecorated(true);
		mainFrame.setResizable(false);

		addMouseMotionListener(new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent ME)
			{
				if(credits.isVisible() || sandbox.isVisible() || timer.isVisible())
					return;
				Point mouseLocation = ME.getPoint();
				boolean changed = false;
				for(int i=1;i<BUTTONS.length;i++)
					if(buttonHover[i] != (buttonHover[i] = BUTTONS[i].contains(mouseLocation)))
					{
						changed = true;
						repaint((int)BUTTONS[i].x,(int)BUTTONS[i].y,(int)BUTTONS[i].width+1,(int)BUTTONS[i].height+1);
					}
				if(!changed)
					return;
				boolean hand = false;
				for(boolean h:buttonHover)
					hand = hand||h;
				setCursor(hand?HAND_CURSOR:DEFAULT_CURSOR);
			}
		});
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent ME)
			{
				if(credits.isVisible() || sandbox.isVisible() || timer.isVisible())
					return;
				Point location = ME.getPoint();
				if(BUTTONS[1].contains(location))
				{
					sandbox.setVisible(true);
				}
				else if(BUTTONS[2].contains(location))
				{
					timer.setVisible(true);
				}
				else if(BUTTONS[3].contains(location))
				{
					credits.setVisible(true);
				}
				else if(BUTTONS[4].contains(location))
					System.exit(0);
			}
		});

		final int BUTTON_WIDTH       = SCREEN_HEIGHT*2/3;
		final int BUTTON_HEIGHT      = (int)((SCREEN_HEIGHT-265*SCALE)/9);
		final int BUTTON_ARC         = BUTTON_HEIGHT;
		final int BUTTON_RIGHT_START = (SCREEN_WIDTH-SCREEN_HEIGHT)/2;
		final int BUTTON_LEFT_START  = BUTTON_RIGHT_START+BUTTON_WIDTH/2;
		final int BUTTON_SEPARATION  = BUTTON_HEIGHT*3/2;
		final int BUTTON_TOP_START   = (int)(265*SCALE)+BUTTON_HEIGHT;
	
		final int FONT_WIDTH  = FONT_SIZE*3/5;
		final int FONT_HEIGHT = FONT_SIZE*27/50;

		BUTTONS = new RoundRectangle2D.Double[]
		{
			new RoundRectangle2D.Double(BUTTON_RIGHT_START,BUTTON_TOP_START+0*BUTTON_SEPARATION,BUTTON_WIDTH,BUTTON_HEIGHT,BUTTON_ARC,BUTTON_ARC),
			new RoundRectangle2D.Double(BUTTON_LEFT_START, BUTTON_TOP_START+1*BUTTON_SEPARATION,BUTTON_WIDTH,BUTTON_HEIGHT,BUTTON_ARC,BUTTON_ARC),
			new RoundRectangle2D.Double(BUTTON_RIGHT_START,BUTTON_TOP_START+2*BUTTON_SEPARATION,BUTTON_WIDTH,BUTTON_HEIGHT,BUTTON_ARC,BUTTON_ARC),
			new RoundRectangle2D.Double(BUTTON_LEFT_START, BUTTON_TOP_START+3*BUTTON_SEPARATION,BUTTON_WIDTH,BUTTON_HEIGHT,BUTTON_ARC,BUTTON_ARC),
			new RoundRectangle2D.Double(BUTTON_RIGHT_START,BUTTON_TOP_START+4*BUTTON_SEPARATION,BUTTON_WIDTH,BUTTON_HEIGHT,BUTTON_ARC,BUTTON_ARC)
		};
		BUTTON_LOCATIONS = new Point[]
		{
			new Point((int)(BUTTONS[0].x+25)                                                   ,(int)(BUTTONS[0].y+BUTTON_HEIGHT-(BUTTON_HEIGHT-FONT_HEIGHT)/2)),
			new Point((int)(BUTTONS[1].x+BUTTON_WIDTH-BUTTON_STRINGS[1].length()*FONT_WIDTH-25),(int)(BUTTONS[1].y+BUTTON_HEIGHT-(BUTTON_HEIGHT-FONT_HEIGHT)/2)),
			new Point((int)(BUTTONS[2].x+25)                                                   ,(int)(BUTTONS[2].y+BUTTON_HEIGHT-(BUTTON_HEIGHT-FONT_HEIGHT)/2)),
			new Point((int)(BUTTONS[3].x+BUTTON_WIDTH-BUTTON_STRINGS[3].length()*FONT_WIDTH-25),(int)(BUTTONS[3].y+BUTTON_HEIGHT-(BUTTON_HEIGHT-FONT_HEIGHT)/2)),
			new Point((int)(BUTTONS[4].x+25)                                                   ,(int)(BUTTONS[4].y+BUTTON_HEIGHT-(BUTTON_HEIGHT-FONT_HEIGHT)/2))
		};

		mainFrame.add(sandbox);
		mainFrame.add(timer);
		mainFrame.add(credits);
		mainFrame.add(this);
		mainFrame.setVisible(true);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("Andy Rock & Nam Nguyen",SCREEN_WIDTH-180,SCREEN_HEIGHT-20);
		g.drawString("Copyleft © 2014 Rock Software",SCREEN_WIDTH-180,SCREEN_HEIGHT-5);
		for(int i=0;i<BUTTONS.length;i++)
		{
			g.setColor(buttonHover[i]?Color.BLACK:Color.WHITE);
			g.fillRoundRect((int)BUTTONS[i].x,(int)BUTTONS[i].y,(int)BUTTONS[i].width,(int)BUTTONS[i].height,(int)BUTTONS[i].arcwidth,(int)BUTTONS[i].archeight);
			g.setColor(buttonHover[i]?Color.WHITE:Color.BLACK);
			g.drawRoundRect((int)BUTTONS[i].x,(int)BUTTONS[i].y,(int)BUTTONS[i].width,(int)BUTTONS[i].height,(int)BUTTONS[i].arcwidth,(int)BUTTONS[i].archeight);
			g.setFont(buttonHover[i]?HOVER_FONT:NORMAL_FONT);
			g.drawString(BUTTON_STRINGS[i],BUTTON_LOCATIONS[i].x,BUTTON_LOCATIONS[i].y);
		}
		g.drawImage(TITLE,(SCREEN_WIDTH-SCREEN_HEIGHT)/2+(int)(68*SCALE),(int)(54*SCALE),(int)(476*SCALE),(int)(211*SCALE),null);
		int cubieSize = (int)(58*SCALE);
		for(int y=0;y<3;y++)
			for(int x=0;x<3;x++)
				g.drawImage(CUBEFACES[x*3+y],(SCREEN_WIDTH-SCREEN_HEIGHT)/2+(int)(526*SCALE)+y*cubieSize,(int)(54*SCALE)+x*cubieSize,cubieSize,cubieSize,null);
	}
}