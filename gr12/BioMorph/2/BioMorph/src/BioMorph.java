/*
*/
 
import javax.swing.*;
import java.awt.*;
 
public class BioMorph extends JFrame{
	
	JMenuBar menuBar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenuItem newOrg=new JMenuItem("New Organism");
	JMenuItem save=new JMenuItem("Save");
	JMenuItem load=new JMenuItem("Load");
	JMenu help=new JMenu("Help");
	JMenuItem instructions=new JMenuItem("Instructions");
	JMenu exit=new JMenu("Exit");
			
    public static void main(String[] args){
    	new BioMorph();
    }
    
    BioMorph(){
    	//Menu Bar Settings
		menuBar.add(file);
		file.add(newOrg);
		file.add(save);
		file.add(load);
		menuBar.add(help);
		help.add(instructions);
		menuBar.add(exit);
		setJMenuBar(menuBar);
		
    	//JFrame Settings    	
    	setTitle("BioMorph");	
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		
		
		Evolution e=new Evolution();
		
		add(e);
		
		Organism parent=new Organism(new int[]{3,1,1,1,1,1,1,1,1,50,0}, 1);
		
		setVisible(true);
		e.setParent(parent);
    }
}
