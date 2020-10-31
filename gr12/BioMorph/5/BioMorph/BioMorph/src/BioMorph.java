/*
Name of Application: bioMorph
Name of Progammers: Thomas Lien, Nam Nguyen, Ana Vila
Name of Company: TriHelix Solutions
Client: Monika Szoke
Application Purpose:

Date Started: April 13th, 2015
Date Finished: June 3rd, 2015
*/
 
/*
BioMorph Class (Main Class)
Purpose: To setup the JFrame containing all the different screens, and adjust its changing properties
Also to setup the JMenuBar with its different options and events
*/

//Imported JAVA Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
 
//Start of BioMorph Class (Main Class)
public class BioMorph extends JFrame implements ActionListener
{	
	//Class Variables
	
	//Menu Bar Variables	
	private JMenuBar menuBar=new JMenuBar();
	private JMenu file=new JMenu("File");
	private JMenu newOrg=new JMenu("New Organism");
	private JMenuItem defOrg=new JMenuItem("Default Organism");
	private JMenuItem userOrg=new JMenuItem("Create Your Own!");
	private JMenuItem save=new JMenuItem("Save");
	private JMenuItem load=new JMenuItem("Load");
	private JMenu help=new JMenu("Help");
	private JMenu exit=new JMenu("Exit");
	private JMenuItem close=new JMenuItem("Close");
	private JMenuItem helpItem=new JMenuItem("Instructions");
	
	//Reading/Writing to Files Variables
	private PrintWriter pw;
	private BufferedReader br;
	private JFileChooser fc=new JFileChooser();
	
	//Evolution Object Variable
	private Evolution e;
			
    //Start of Main Method
    public static void main(String[] args)
    {
    	new BioMorph();
    } //End of Main Method
    
    //Start of Constructor
    BioMorph()
    {
    	try{//making the splash screen display a second longer
    		Thread.sleep(1000);
    	}catch(Exception e){
    		
    	}
    	//JFrame Settings    		
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screenSize.getWidth();
		int height=(int)screenSize.getHeight();
		setSize(width,height);
		setUndecorated(true);
		
		//Menu Bar Settings
		menuBar.add(file); //Setting up the Menu Bar
		file.add(newOrg);
		newOrg.add(defOrg);
		newOrg.add(userOrg);
		file.add(save);
		file.add(load);
		menuBar.add(help);
		help.add(helpItem);
		menuBar.add(exit);
		exit.add(close);
		setJMenuBar(menuBar);
		
		defOrg.addActionListener(this); //Adding ActionnListeners to the Menu Options
		userOrg.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		helpItem.addActionListener(this);
		close.addActionListener(this);
		
		//Evolution and Organism Settings
		e=new Evolution();
		addKeyListener(e);
		add(e);
		setVisible(true);
		
		int[] genes={1,1,1,1,1,1,1,1,1,1,1}; //Setting the gene values to the basic, default values
		Organism parent=new Organism(genes,1); //Creating the organism with the specified set of genes, and as the first generation
		e.setParent(parent); //Setting the curent parent organism to the default starting organism
    } //End of Constructor
    
    
    //New Organism Method - Purpose: To start over form the default parent organism!
    public void newOrg()
    {
		int[] genes={1,1,1,1,1,1,1,1,1,1,1}; //Setting the gene values to the basic, default values
		Organism parent=new Organism(genes,1); //Creating the organism with the specified set of genes, and as the first generation
		e.setParent(parent); //Setting the curent parent organism to the default starting organism
		ArrayList<Organism> treeTemp=new ArrayList<Organism>(); 
		e.setTree(treeTemp); //Setting new succession tree to an empty tree
		repaint();
    }
    
    //Create Your Own! Method - Purpose: 
    public void userOrg() throws Exception
    {
    	
    	String[] messages = {"Depth ","Vertical Translation - Right Branches, Even Levels ",
    	"Horizontal Translation - Right Branches, Even Levels","Vertical Translation - Right Branches, Odd Levels",
    	"Horizontal Translation - Right Branches, Odd Levels","Vertical Translation - Left Branches, Even Levels",
    	"Horizontal Translation - Left Branches, Even Levels","Vertical Translation - Left Branches, Odd Levels",
    	"Horizontal Translation - Left Branches, Odd Levels","Color","Thickness"};
    	int[][] res = Organism.getRestrictions();
    	int[] genesTemp=new int[11];
    	
    	String invalid="",in="";
    	
    	for(int i = 0; i<genesTemp.length; i++){
    		do{
    			try{
    				in = JOptionPane.showInputDialog("Gene "+(i+1)+": "+messages[i]+" ( "+res[i][0]+" to "+res[i][1]+" )"+invalid);
    				genesTemp[i]=Integer.parseInt(in);
    				invalid = "";//set it back to normal
    				if(genesTemp[i]<res[i][0] || genesTemp[i]>res[i][1])invalid = "\nOut of Range!!!";
    			}catch(NumberFormatException e){
    				
    				if(in==null)return;//if no input then return
    				
    				invalid = "\nInvalid Input!!!";//if bad input
    				
    			}
    			
    		}while(genesTemp[i]<res[i][0] || genesTemp[i]>res[i][1]);
    	}
    	
		e.setTree(new ArrayList<Organism>()); //Setting new succession tree to an empty tree
		e.setParent(new Organism(genesTemp,1)); //Setting the curent parent organism to the default starting organism
		repaint();
    }
    
    //Save Method - Purpose: To save the current parent organism!
    public void save()
    {
    	fc=new JFileChooser();
	    //fc.setCurrentDirectory(new File(""));
	    if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
	    	//Try-Catch Block
	        try
	        {
	            pw=new PrintWriter(new FileWriter(fc.getSelectedFile()+".txt")); //Print to the user-selected file
		    	for(Organism o: e.getTree()) //IN PROGESS
		    	{
					int[] genes=o.getGenes(); //Getting genes from 
					for(int i=0; i<genes.length; i++)
						pw.print(genes[i]+" "); //Print each gene value in a line
						
					pw.println(); //Starts printing on a new line
				}
				pw.close(); //Closes the File
	        }
	        catch (Exception ex) //Catch Any Exception
	        {
	            ex.printStackTrace();
	        }
    }
    
    //Load Method - Purpose: To load a previously saved organism!
    public void load()
    {
    	fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("Select the text file representing your organism!");
		//fc.setFileFilter(new FileNameExtensionFilter("Text Files (Organism)", new String[]{"txt"}));
		if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
			//Try-Catch Block
			try
			{
				br=new BufferedReader(new FileReader(fc.getSelectedFile()));
				ArrayList<Organism> treeTemp=new ArrayList<Organism>();
		    	String line=br.readLine();
		    	int x=0;
		    	while(line!=null)
		    	{
		 			String[] genesSt=line.split(" ");
		 			int[] genes=new int[genesSt.length];
		 			for(int y=0; y<genesSt.length; y++)
		 				genes[y]=Integer.parseInt(genesSt[y]);
		 				
		 			treeTemp.add(new Organism(genes,x));
		    		line=br.readLine();
		    		x++;
		    	}
		    	br.close();
		    	e.setTree(treeTemp);
		    	e.setParent(treeTemp.get(treeTemp.size()-1));
				repaint();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
    }
    
    //Help Method - Purpose: To display a help/instructions screen!
    public void help()
    {
    	JOptionPane.showMessageDialog(null, "Please refer to the user manual for assistance.", "Help", JOptionPane.INFORMATION_MESSAGE);
    	JFrame tempFrame=new JFrame("Instructions");
    	JPanel tempPanel=new JPanel();
    	JLabel tempLabel=new JLabel("When the application is run, the first screen displayed will be that of the default parent organism. Atop the screen you will find a menu bar with clickable buttons: “File”, “Help”, and “Exit”.“File” contains a small drop-down menu of button options: “New Organism”, “Save”, and “Load”. Clicking “New Organism” will display the beginning screen with the default parent organism. Clicking “Save” will allow you to save your current parent organism by following the prompts, and “Load” will let you load a previously saved organism by again following the prompts. “Help” contains an “Instructions” button thatwill bring you here, and “Exit” contains a “Close” button that will  close the application. Click “Reproduce” on the bottom left to allow your parent organism to create 3 children,Click “View Genes” to view the current parent organism’s genes. Click “Animation” toview a small animation of the current parent organism’s ancestors leading up to thepresent. You may stop this animation at any time by clicking anywhere on the screen.Once the 3 children have been created click the one you wish to survive. Whicheveryou select will become the new parent. Scroll with the mouse wheel, or mouse pad to resize the organisms.");
    	
    	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screenSize.getWidth();
		int height=(int)screenSize.getHeight();
		tempFrame.setSize(width,height);
		tempFrame.add(tempPanel);
		tempPanel.add(tempLabel);
		tempFrame.setVisible(true);
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
    		if(ae.getSource()==defOrg) newOrg();
    	}
    	catch(Exception e){
    		System.err.println("Caught Exception");
    	}
    	
    	try{
    		if(ae.getSource()==userOrg) userOrg();
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
} //End of BioMorph Class (Main Class)
