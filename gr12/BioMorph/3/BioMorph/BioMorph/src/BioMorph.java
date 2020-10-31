/*
*/
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
 
public class BioMorph extends JFrame implements ActionListener{
	
	private JMenuBar menuBar=new JMenuBar();
	private JMenu file=new JMenu("File");
	private JMenuItem newOrg=new JMenuItem("New Organism");
	private JMenuItem save=new JMenuItem("Save");
	private JMenuItem load=new JMenuItem("Load");
	private JMenu help=new JMenu("Help");
	private JMenu exit=new JMenu("Exit");
	private JMenuItem close=new JMenuItem("Close");
	private JMenuItem helpItem=new JMenuItem("Instructions");
	private PrintWriter pw;
	private BufferedReader infile;
	private Evolution e;
			
    public static void main(String[] args){
    	new BioMorph();
    }
    
    BioMorph(){
    	//JFrame Settings    	
    	setTitle("BioMorph");		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screenSize.getWidth();
		int height=(int)screenSize.getHeight();
		setSize(width,height);		setUndecorated(true);
		
		//Menu Bar Settings
		menuBar.add(file);
		file.add(newOrg);
		file.add(save);
		file.add(load);
		menuBar.add(help);
		help.add(helpItem);
		menuBar.add(exit);
		exit.add(close);
		setJMenuBar(menuBar);
		
		newOrg.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		helpItem.addActionListener(this);
		close.addActionListener(this);
		
		e=new Evolution();
		add(e);
		setVisible(true);
		int[] genes={1,1,1,1,1,1,1,1,1,1,1};
		Organism parent=new Organism(genes,1);
		e.setParent(parent);
    }
    
    public void save() throws Exception
    {
    	String orgName=JOptionPane.showInputDialog(this,"Please enter the name of your organism.","Save",JOptionPane.PLAIN_MESSAGE);
    	pw=new PrintWriter(new FileWriter(orgName+".txt"));
    	for(Organism o: e.getTree()){
			int[] genes=o.getGenes();
			for(int i=0; i<genes.length; i++){
				pw.print(genes[i]+" ");
			}
			pw.println();
		}
		pw.close();
    }
    
    public void load() throws Exception
    {
    	String orgName=JOptionPane.showInputDialog(this,"Please enter the name of your saved organism.","Load",JOptionPane.PLAIN_MESSAGE);
    	infile=new BufferedReader(new FileReader(orgName+".txt"));
    	
    	ArrayList<Organism> treeTemp=new ArrayList<Organism>();
    	String line=infile.readLine();
    	int x=0;
    	while(line!=null)
    	{
 			String[] genesSt=line.split(" ");
 			int[] genes=new int[genesSt.length];
 			for(int y=0; y<genesSt.length; y++)
 				genes[y]=Integer.parseInt(genesSt[y]);
 				
 			treeTemp.add(new Organism(genes,x));
    		line=infile.readLine();
    		x++;
    	}
    	infile.close();
    	e.setTree(treeTemp);
    	e.setParent(treeTemp.get(treeTemp.size()-1));
		repaint();
    }
    
    public void help() throws Exception
    {
    	JOptionPane.showMessageDialog(null, "Please refer to the user manual for assistance.", "Help", JOptionPane.INFORMATION_MESSAGE);
    	JFrame tempFrame = new JFrame("Instructions");
    	JPanel tempPanel = new JPanel();
    	JLabel tempLabel = new JLabel("When the application is run, the first screen displayed will be that of the default parent organism. Atop the screen you will find a menu bar with clickable buttons: “File”, “Help”, and “Exit”.“File” contains a small drop-down menu of button options: “New Organism”, “Save”, and “Load”. Clicking “New Organism” will display the beginning screen with the default parent organism. Clicking “Save” will allow you to save your current parent organism by following the prompts, and “Load” will let you load a previously saved organism by again following the prompts. “Help” contains an “Instructions” button thatwill bring you here, and “Exit” contains a “Close” button that will  close the application. Click “Reproduce” on the bottom left to allow your parent organism to create 3 children,Click “View Genes” to view the current parent organism’s genes. Click “Animation” toview a small animation of the current parent organism’s ancestors leading up to thepresent. You may stop this animation at any time by clicking anywhere on the screen.Once the 3 children have been created click the one you wish to survive. Whicheveryou select will become the new parent. Scroll with the mouse wheel, or mouse pad to resize the organisms.");
    	
    	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screenSize.getWidth();
		int height=(int)screenSize.getHeight();
		tempFrame.setSize(width,height);
		tempFrame.add(tempPanel);
		tempPanel.add(tempLabel);
		tempFrame.setVisible(true);
    }
    
    public void newOrg() throws Exception
    {
		int[] genes={1,1,1,1,1,1,1,1,1,1,1};
		Organism parent=new Organism(genes,1);
		e.setParent(parent);
		ArrayList<Organism> treeTemp=new ArrayList<Organism>();
		e.setTree(treeTemp);
		repaint();
    }
    
    public void actionPerformed(ActionEvent ae){
    	try{
    		if(ae.getSource()==save) save();
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception");
    	}
    	
    	try{
    		if(ae.getSource()==load) load();
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception");
    	}
    	
    	try{
    		if(ae.getSource()==close) System.exit(0);
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception");
    	}
    	
    	try{
    		if(ae.getSource()==newOrg) newOrg();
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception");
    	}
    	
    	try{
    		if(ae.getSource()==helpItem) help();
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception");
    	}
    }
}
