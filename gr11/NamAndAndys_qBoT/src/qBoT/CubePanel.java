package qBoT;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CubePanel extends AppPanel
{
	private ThreeXThreeXThree cube;
	private Polygon[] cubies;

	private final Cursor DEFAULT_CURSOR   = Cursor.getDefaultCursor();
	private final Cursor HAND_CURSOR      = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	private final Cursor CROSSHAIR_CURSOR = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);

	private char selectedColour = 'y';


	CubePanel()
	{
		this(new ThreeXThreeXThree());
	}
	CubePanel(final ThreeXThreeXThree cube)
	{
		this.cube = cube;
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent ME)
			{
				for(int i=0;i<cubies.length;i++)
					if(cubies[i].contains(ME.getPoint()))
					{
						if(i%9==4)
							selectedColour = cube.state[i];
						else
							cube.state[i] = selectedColour;
						repaint();
						return;
					}
			}
		});
		addMouseMotionListener(new MouseAdapter()
		{
			@Override
			public void mouseMoved(MouseEvent ME)
			{
				for(int i=0;i<cubies.length;i++)
					if(cubies[i].contains(ME.getPoint()))
					{
						setCursor(i%9==4?CROSSHAIR_CURSOR:HAND_CURSOR);
						return;
					}
				setCursor(DEFAULT_CURSOR);
			}
		});
		final int S = (int)(SCREEN_WIDTH*SCALE/22.0)/3*3;
		final int H = (SCREEN_HEIGHT-8*S)/2;
		cubies = new Polygon[]
		{
				new Polygon(new int[]{S*15/3,S*18/3,16*S/3,13*S/3},new int[]{S* 0/3+H,S* 0/3+H,S* 2/3+H,S* 2/3+H},4),
				new Polygon(new int[]{S*18/3,S*21/3,19*S/3,16*S/3},new int[]{S* 0/3+H,S* 0/3+H,S* 2/3+H,S* 2/3+H},4),
				new Polygon(new int[]{S*21/3,S*24/3,22*S/3,19*S/3},new int[]{S* 0/3+H,S* 0/3+H,S* 2/3+H,S* 2/3+H},4),

				new Polygon(new int[]{S*13/3,S*16/3,14*S/3,11*S/3},new int[]{S* 2/3+H,S* 2/3+H,S* 4/3+H,S* 4/3+H},4),
				new Polygon(new int[]{S*16/3,S*19/3,17*S/3,14*S/3},new int[]{S* 2/3+H,S* 2/3+H,S* 4/3+H,S* 4/3+H},4),
				new Polygon(new int[]{S*19/3,S*22/3,20*S/3,17*S/3},new int[]{S* 2/3+H,S* 2/3+H,S* 4/3+H,S* 4/3+H},4),

				new Polygon(new int[]{S*11/3,S*14/3,12*S/3, 9*S/3},new int[]{S* 4/3+H,S* 4/3+H,S* 6/3+H,S* 6/3+H},4),
				new Polygon(new int[]{S*14/3,S*17/3,15*S/3,12*S/3},new int[]{S* 4/3+H,S* 4/3+H,S* 6/3+H,S* 6/3+H},4),
				new Polygon(new int[]{S*17/3,S*20/3,18*S/3,15*S/3},new int[]{S* 4/3+H,S* 4/3+H,S* 6/3+H,S* 6/3+H},4),


				new Polygon(new int[]{S*15/3,S*18/3,18*S/3,15*S/3},new int[]{S*21/3+H,S*21/3+H,S*24/3+H,S*24/3+H},4),
				new Polygon(new int[]{S*12/3,S*15/3,15*S/3,12*S/3},new int[]{S*21/3+H,S*21/3+H,S*24/3+H,S*24/3+H},4),
				new Polygon(new int[]{S* 9/3,S*12/3,12*S/3, 9*S/3},new int[]{S*21/3+H,S*21/3+H,S*24/3+H,S*24/3+H},4),

				new Polygon(new int[]{S*15/3,S*18/3,18*S/3,15*S/3},new int[]{S*18/3+H,S*18/3+H,S*21/3+H,S*21/3+H},4),
				new Polygon(new int[]{S*12/3,S*15/3,15*S/3,12*S/3},new int[]{S*18/3+H,S*18/3+H,S*21/3+H,S*21/3+H},4),
				new Polygon(new int[]{S* 9/3,S*12/3,12*S/3, 9*S/3},new int[]{S*18/3+H,S*18/3+H,S*21/3+H,S*21/3+H},4),

				new Polygon(new int[]{S*15/3,S*18/3,18*S/3,15*S/3},new int[]{S*15/3+H,S*15/3+H,S*18/3+H,S*18/3+H},4),
				new Polygon(new int[]{S*12/3,S*15/3,15*S/3,12*S/3},new int[]{S*15/3+H,S*15/3+H,S*18/3+H,S*18/3+H},4),
				new Polygon(new int[]{S* 9/3,S*12/3,12*S/3, 9*S/3},new int[]{S*15/3+H,S*15/3+H,S*18/3+H,S*18/3+H},4),


				new Polygon(new int[]{S* 9/3,S*12/3,12*S/3, 9*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S*12/3,S*15/3,15*S/3,12*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S*15/3,S*18/3,18*S/3,15*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),

				new Polygon(new int[]{S* 9/3,S*12/3,12*S/3, 9*S/3},new int[]{S* 9/3+H,S* 9/3+H,S*12/3+H,S*12/3+H},4),
				new Polygon(new int[]{S*12/3,S*15/3,15*S/3,12*S/3},new int[]{S* 9/3+H,S* 9/3+H,S*12/3+H,S*12/3+H},4),
				new Polygon(new int[]{S*15/3,S*18/3,18*S/3,15*S/3},new int[]{S* 9/3+H,S* 9/3+H,S*12/3+H,S*12/3+H},4),

				new Polygon(new int[]{S* 9/3,S*12/3,12*S/3, 9*S/3},new int[]{S*12/3+H,S*12/3+H,S*15/3+H,S*15/3+H},4),
				new Polygon(new int[]{S*12/3,S*15/3,15*S/3,12*S/3},new int[]{S*12/3+H,S*12/3+H,S*15/3+H,S*15/3+H},4),
				new Polygon(new int[]{S*15/3,S*18/3,18*S/3,15*S/3},new int[]{S*12/3+H,S*12/3+H,S*15/3+H,S*15/3+H},4),


				new Polygon(new int[]{S*24/3,S*27/3,27*S/3,24*S/3},new int[]{S* 0/3+H,S* 0/3+H,S* 3/3+H,S* 3/3+H},4),
				new Polygon(new int[]{S*27/3,S*30/3,30*S/3,27*S/3},new int[]{S* 0/3+H,S* 0/3+H,S* 3/3+H,S* 3/3+H},4),
				new Polygon(new int[]{S*30/3,S*33/3,33*S/3,30*S/3},new int[]{S* 0/3+H,S* 0/3+H,S* 3/3+H,S* 3/3+H},4),

				new Polygon(new int[]{S*24/3,S*27/3,27*S/3,24*S/3},new int[]{S* 3/3+H,S* 3/3+H,S* 6/3+H,S* 6/3+H},4),
				new Polygon(new int[]{S*27/3,S*30/3,30*S/3,27*S/3},new int[]{S* 3/3+H,S* 3/3+H,S* 6/3+H,S* 6/3+H},4),
				new Polygon(new int[]{S*30/3,S*33/3,33*S/3,30*S/3},new int[]{S* 3/3+H,S* 3/3+H,S* 6/3+H,S* 6/3+H},4),

				new Polygon(new int[]{S*24/3,S*27/3,27*S/3,24*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S*27/3,S*30/3,30*S/3,27*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S*30/3,S*33/3,33*S/3,30*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),


				new Polygon(new int[]{S*18/3,S*20/3,20*S/3,18*S/3},new int[]{S* 6/3+H,S* 4/3+H,S* 7/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S*20/3,S*22/3,22*S/3,20*S/3},new int[]{S* 4/3+H,S* 2/3+H,S* 5/3+H,S* 7/3+H},4),
				new Polygon(new int[]{S*22/3,S*24/3,24*S/3,22*S/3},new int[]{S* 2/3+H,S* 0/3+H,S* 3/3+H,S* 5/3+H},4),

				new Polygon(new int[]{S*18/3,S*20/3,20*S/3,18*S/3},new int[]{S* 9/3+H,S* 7/3+H,S*10/3+H,S*12/3+H},4),
				new Polygon(new int[]{S*20/3,S*22/3,22*S/3,20*S/3},new int[]{S* 7/3+H,S* 5/3+H,S* 8/3+H,S*10/3+H},4),
				new Polygon(new int[]{S*22/3,S*24/3,24*S/3,22*S/3},new int[]{S* 5/3+H,S* 3/3+H,S* 6/3+H,S* 8/3+H},4),

				new Polygon(new int[]{S*18/3,S*20/3,20*S/3,18*S/3},new int[]{S*12/3+H,S*10/3+H,S*13/3+H,S*15/3+H},4),
				new Polygon(new int[]{S*20/3,S*22/3,22*S/3,20*S/3},new int[]{S*10/3+H,S* 8/3+H,S*11/3+H,S*13/3+H},4),
				new Polygon(new int[]{S*22/3,S*24/3,24*S/3,22*S/3},new int[]{S* 8/3+H,S* 6/3+H,S* 9/3+H,S*11/3+H},4),


				new Polygon(new int[]{S* 0/3,S* 3/3, 3*S/3, 0*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S* 3/3,S* 6/3, 6*S/3, 3*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),
				new Polygon(new int[]{S* 6/3,S* 9/3, 9*S/3, 6*S/3},new int[]{S* 6/3+H,S* 6/3+H,S* 9/3+H,S* 9/3+H},4),

				new Polygon(new int[]{S* 0/3,S* 3/3, 3*S/3, 0*S/3},new int[]{S* 9/3+H,S* 9/3+H,S*12/3+H,S*12/3+H},4),
				new Polygon(new int[]{S* 3/3,S* 6/3, 6*S/3, 3*S/3},new int[]{S* 9/3+H,S* 9/3+H,S*12/3+H,S*12/3+H},4),
				new Polygon(new int[]{S* 6/3,S* 9/3, 9*S/3, 6*S/3},new int[]{S* 9/3+H,S* 9/3+H,S*12/3+H,S*12/3+H},4),

				new Polygon(new int[]{S* 0/3,S* 3/3, 3*S/3, 0*S/3},new int[]{S*12/3+H,S*12/3+H,S*15/3+H,S*15/3+H},4),
				new Polygon(new int[]{S* 3/3,S* 6/3, 6*S/3, 3*S/3},new int[]{S*12/3+H,S*12/3+H,S*15/3+H,S*15/3+H},4),
				new Polygon(new int[]{S* 6/3,S* 9/3, 9*S/3, 6*S/3},new int[]{S*12/3+H,S*12/3+H,S*15/3+H,S*15/3+H},4)
		};
		setBounds(SCREEN_WIDTH/4,0,11*S,SCREEN_HEIGHT/2+4*S);
	}


	public ThreeXThreeXThree getThreeXThreeXThree()
	{
		return cube;
	}


	private Color getColour(char colour)
	{
		switch(colour)
		{
			case 'y':
				return Color.YELLOW;
			case 'w':
				return Color.WHITE;
			case 'o':
				return new Color(255,128,0);
			case 'r':
				return Color.RED;
			case 'b':
				return Color.BLUE;
			case 'g':
				return Color.GREEN;
			default:
				return Color.GRAY;
		}
	}


	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(getColour(selectedColour));
		final int FONT_SIZE   = (int)(50*SCALE);
		g.setFont(new Font("MONOSPACED",Font.BOLD,FONT_SIZE));
		g.drawString("SELECTED COLOUR",(SCREEN_WIDTH/2-FONT_SIZE*9)/2,SCREEN_HEIGHT/4-SCREEN_WIDTH/11+FONT_SIZE*3/10);
		for(int i=0;i<cubies.length;i++)
		{
			g.setColor(getColour(cube.state[i]));
			g.fillPolygon(cubies[i]);
			g.setColor(Color.BLACK);
			g.drawPolygon(cubies[i]);
		}
	}
}