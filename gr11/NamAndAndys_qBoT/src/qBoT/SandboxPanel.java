package qBoT;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class SandboxPanel extends AppPanel implements MouseListener
{
	ThreeXThreeXThree cube = new ThreeXThreeXThree();

	Button cleanB    = new Button("Clean");
	Button scrambleB = new Button("Scramble:");
	Button solveB    = new Button("Solve:");
	Button[] moveB   = 
	{
		new Button("U"),new Button("R"),new Button("F"),
		new Button("D"),new Button("L"),new Button("B"),
		new Button("Y"),new Button("X"),new Button("Z")
	};
	Button menuB     = new Button("Back");

	JTextField scrambleT = new JTextField();
	JTextField solveT    = new JTextField();
	JScrollPane scrambleL  = new JScrollPane(scrambleT,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	JScrollPane solveL     = new JScrollPane(solveT,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


	SandboxPanel()
	{
		CubePanel cPanel = new CubePanel(cube);
		add(cPanel);
		JPanel movePanel = new JPanel(new GridLayout(3,3));
		for(int i=0;i<moveB.length;i++)
		{
			moveB[i].addMouseListener(this);
			movePanel.add(moveB[i]);
		}
		cleanB   .setBounds(  0,                SCREEN_HEIGHT-150,            100,50);
		scrambleB.setBounds(  0,                SCREEN_HEIGHT-100,            100,50);
		solveB   .setBounds(  0,                SCREEN_HEIGHT-50,             100,50);
		scrambleL.setBounds(100,                SCREEN_HEIGHT-100,SCREEN_WIDTH-100,50);
		solveL   .setBounds(100,                SCREEN_HEIGHT-50,SCREEN_WIDTH-100,50);
		movePanel.setBounds(SCREEN_WIDTH/8-50,  SCREEN_HEIGHT/2,               99,99);
		menuB    .setBounds(SCREEN_WIDTH*7/8-50,SCREEN_HEIGHT/2,              100,25);
		cleanB   .addMouseListener(this);
		scrambleB.addMouseListener(this);
		solveB   .addMouseListener(this);
		menuB    .addMouseListener(this);
		add(cleanB);
		add(scrambleB);
		add(scrambleL);
		add(solveB);
		add(solveL);
		add(movePanel);
		add(menuB);
		setVisible(false);
	}


	public void mousePressed(MouseEvent ME)
	{
		Object clicked = ME.getSource();
		for(int i=0;i<moveB.length;i++)
			if(clicked == moveB[i])
			{
				cube.doMoves(Moves.getMove(moveB[i].getLabel()+(ME.getButton()==MouseEvent.BUTTON3?"i":"")));
				scrambleT.setText("");
				solveT   .setText("");
			}
		repaint();
	}
	public void mouseReleased(MouseEvent ME){}
	public void mouseClicked(MouseEvent ME)
	{
		Object clicked = ME.getSource();
		solveT.setText("");
		if(clicked == cleanB)
		{
			cube.setState(ThreeXThreeXThree.SOLVED_STATE);
			scrambleT.setText("");
		}
		else if(clicked == scrambleB)
			scrambleT.setText(Moves.getString(cube.scramble(20)));
		else if(clicked == solveB)
			solveT.setText(Moves.getString(cube.solve("Cross","Corner","Corner","Corner","Corner","Edge","Edge","Edge","Edge",
					"Top Edge Orientation","Top Edge Permutation","Top Corner Permutation","Top Corner Orientation")));
		else if(clicked == menuB)
			setVisible(false);
		repaint();
	}
	public void mouseEntered(MouseEvent ME){}
	public void mouseExited(MouseEvent ME){}
}