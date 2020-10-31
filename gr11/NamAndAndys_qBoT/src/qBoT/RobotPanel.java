package qBoT;

import java.awt.Graphics;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

@SuppressWarnings("serial")
public class RobotPanel extends AppPanel
{
	Webcam cam = Webcam.getDefault();
	WebcamPanel camPanel;

	RobotPanel()
	{
		super.setVisible(false);
	}

	@Override
	public void setVisible(boolean visible)
	{
		super.setVisible(visible);
		if(visible)
		{
			camPanel = new WebcamPanel(cam);
			add(camPanel);
		}
		else
			remove(camPanel);
	}

	public void paintComponents(Graphics g)
	{
		super.paintComponents(g);
	}
}