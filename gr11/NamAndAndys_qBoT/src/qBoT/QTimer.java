package qBoT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class QTimer extends AppPanel{

	ArrayList<String> timeScores = new ArrayList<String>();
	
	int numberOfTries;
	
	Timer timer;
	
	JLabel scramble = new JLabel("Scramble:  "+Moves.getString(new ThreeXThreeXThree().scramble(20)));

	String min = "";
	String sec = "";
	String cen = "";

	int minutes;
	int seconds;
	int centiseconds;

	JTextArea scores;

	boolean tracing = false;

	byte decision = 1;

	boolean timing = false;
	boolean inspection = false;
	boolean wait = false;
	
	TimerTask timeUser, inspectUser;
	
	JLabel time, label, prompt;
	public boolean isFocusTraversable(){
		return true;
	}
	
	QTimer(){
		setVisible(false);
		
		scramble.setFont(new Font("times new roman",Font.PLAIN,18));
		
		prompt = new JLabel("Press Space To Start Inspection Time");
		prompt.setFont(new Font("times new roman",Font.PLAIN,30));
		
		JLabel title = new JLabel("Cube Timer");
		title.setFont(new Font("times new roman",Font.PLAIN,100));
		
		timer = new Timer();
		
		timeUser = new TimerTask(){

			public void run() {
				if(timing){
					
					tracing(minutes+" : "+seconds+"."+centiseconds);
					centiseconds++;
					if(centiseconds == 100){
						centiseconds = 0;
						seconds++;
						if(seconds == 60){
							seconds = 0;
							minutes++;
							if(minutes == 60){
								timing = false;
							}
						}
					}
					if(centiseconds < 10) cen = "0"+centiseconds; else cen=""+centiseconds;
					if(seconds < 10) sec = "0"+seconds; else sec=""+seconds;
					min = ""+minutes;
					time.setText(min+" : "+sec+"."+cen);
				}
				if(inspection){
					prompt.setText("Press Space To Begin Timing");
					tracing(minutes+" : "+seconds+"."+centiseconds);
					centiseconds--;
					if(centiseconds < 0){
						centiseconds = 99;
						seconds--;
						
						if(seconds == 0){
							inspection = false;
							timing = true;
							time.setForeground(Color.WHITE);
							centiseconds = seconds = 0;
							prompt.setText("Press Space When You're Finished");
						}
					}
					
					
					time.setText(""+seconds);
				}
			}
			
		};
		
		time = new JLabel("0 : 00.00");
		time.setFont(new Font("times new roman",Font.PLAIN,60));
		time.setForeground(Color.WHITE);
		
		scores = new JTextArea(20,33);
		scores.setFocusable(false);
		scores.setLineWrap(true);
		
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		JPanel scorePanel = new JPanel();
		JPanel titlePanel = new JPanel(new GridLayout(2,1));
		JPanel promptPanel = new JPanel();
		
		mainPanel.setOpaque(false);
		
		titlePanel.add(title);
		titlePanel.add(scramble);
		mainPanel.add(time);
		scorePanel.add(scores);
		promptPanel.add(prompt);
		
		setLayout(new BorderLayout());
		
		add(scorePanel , BorderLayout.EAST);
		add(titlePanel , BorderLayout.NORTH);
		add(mainPanel , BorderLayout.CENTER);
		add(promptPanel , BorderLayout.SOUTH);
		
		Action space = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				tracing("space!");
					if(!inspection && !timing && !wait){
						prompt.setText("Press Space To Begin Timing");
						inspection = true;
						seconds = 16;
						minutes = centiseconds = 0;
						time.setText("15");
						time.setForeground(Color.RED);
						tracing("inspection!");
						try
						{
							timer.scheduleAtFixedRate(timeUser,0,10);
						}
						catch(Exception e3){}
					}
					else if(inspection){
						prompt.setText("Press Space When You're Finished");
						time.setForeground(Color.WHITE);
						inspection = false;
						timing = true;
						tracing("timing!");
						minutes = seconds = centiseconds = 0;
						
					}
					else if(timing){
						timing = false;
						numberOfTries++;
						
						if(minutes < 10)min = "0"+minutes; else min = ""+minutes;
						if(seconds < 10)sec = "0"+seconds; else sec = ""+seconds;
						if(centiseconds < 10)cen = "0"+centiseconds; else cen = ""+centiseconds;
						
						scores.insert(min+" : "+sec+"."+cen+",     ",(numberOfTries-1)*16);
						
						scramble.setText("Scramble:  "+Moves.getString(new ThreeXThreeXThree().scramble(20)));
						prompt.setText("Press Space To Start Inspection Time");
						
						tracing("stop!");
					}
					tracing(""+timing);
			}
		};
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0),"space");
		getActionMap().put("space",space);
	}

	public void tracing(String x){
		if(tracing)System.out.println(x);
	}
}