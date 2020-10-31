package qBoT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class AppPanel extends JPanel
{
	private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	public final int SCREEN_WIDTH       = SCREEN_SIZE.width;
	public final int SCREEN_HEIGHT      = SCREEN_SIZE.height;
	public final double SCALE           = (double)SCREEN_HEIGHT/768.0;

	AppPanel()
	{
		Action exit = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		};
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),"exit");
		getActionMap().put("exit",exit);
		setLayout(null);
		setBounds(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
	}
}
//647 975 5694