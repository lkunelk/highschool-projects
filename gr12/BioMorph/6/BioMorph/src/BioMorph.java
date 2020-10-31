/*
Name of Application: bioMorph
Name of Progammers: Thomas Lien, Nam Nguyen, Ana Vila
Name of Company: TriHelix Solutions
Client: Monika Szoke
Application Purpose: Our application loosely mimics the concept of natural selection found in nature, whereby an organism reproduces 
and creates a child with a slightly modified genetic makeup. The survival of this new organism, as well as any of its offspring, 
will be entirely in the hands of the user of the application.

Date Started: April 13th, 2015
Date Finished: June 3rd, 2015
*/
 
/*
BioMorph Class (Main Class)
Purpose: To setup the JFrame containing all the different screens, and adjust its changing properties
Also to setup the JMenuBar with its different options and events
*/

//Imported JAVA Libraries/Folders/Files
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;
 
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
    //Pre-Condition: Main method was run
    BioMorph()
    {
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
		
		defOrg.addActionListener(this); //Adding ActionListeners to the Menu Options
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
    //Post-Condition: Frame, menu bar, action listeners and evolution settings were all set
    
    
    //New Organism Method - Purpose: To start over form the default parent organism!
    //Pre-Condition: The 'New Organism' menu bar option was clicked
    public void newOrg()
    {
		int[] genes={1,1,1,1,1,1,1,1,1,1,1}; //Setting the gene values to the basic, default values
		Organism parent=new Organism(genes,1); //Creating the organism with the specified set of genes, and as the first generation
		e.setParent(parent); //Setting the curent parent organism to the default starting organism
		ArrayList<Organism> treeTemp=new ArrayList<Organism>(); 
		e.setTree(treeTemp); //Setting new succession tree to an empty tree
		repaint();
    } //Post-Condition: The default parent organism is displayed on screen
    
    //Create Your Own! Method - Purpose: To allow the user to create their own organism by entering the gene values!
    //Pre-Condition: The 'Create Your Own!' menu bar option was clicked
    public void userOrg() throws Exception
    {
    	
    	String[] messages={"Depth ","Vertical Translation - Right Branches, Even Levels ",
    	"Horizontal Translation - Right Branches, Even Levels","Vertical Translation - Right Branches, Odd Levels",
    	"Horizontal Translation - Right Branches, Odd Levels","Vertical Translation - Left Branches, Even Levels",
    	"Horizontal Translation - Left Branches, Even Levels","Vertical Translation - Left Branches, Odd Levels",
    	"Horizontal Translation - Left Branches, Odd Levels","Color","Thickness"};
    	int[][] res=Organism.getRestrictions();
    	int[] genesTemp=new int[11];
    	
    	String invalid="",in="";
    	
    	for(int i=0; i<genesTemp.length; i++)
    	{
    		do
    		{
    			try
    			{
    				in=JOptionPane.showInputDialog("Gene "+(i+1)+": "+messages[i]+" ( "+res[i][0]+" to "+res[i][1]+" )"+invalid);
    				genesTemp[i]=Integer.parseInt(in);
    				invalid=""; //Set it back to normal
    				if(genesTemp[i]<res[i][0]||genesTemp[i]>res[i][1])invalid="\nOut of Range! Try again!";
    			}
    			catch(NumberFormatException e)
    			{
    				if(in==null)return; //If no input, then return
    				invalid="\nInvalid Input!"; //If incorrect input
    			}
    		}
    		while(genesTemp[i]<res[i][0]||genesTemp[i]>res[i][1]);
    	}
    	
		e.setTree(new ArrayList<Organism>()); //Setting new succession tree to an empty tree
		e.setParent(new Organism(genesTemp,1)); //Setting the curent parent organism to the default starting organism
		repaint();
    } //Post-Condition: The organism matching the genes entered by the user is displayed
    
    //Save Method - Purpose: To save the current parent organism!
    //Pre-Condition: The 'Save' menu bar option was clicked
    public void save()
    {
    	fc=new JFileChooser();
	    fc.setCurrentDirectory(new File(""));
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
    } //Post-Condition: The current parent's genes and those of its ancestors were saved to a text file
    
    //Load Method - Purpose: To load a previously saved organism!
    //Pre-Condition: The 'Load' menu bar option was clicked
    public void load()
    {
    	fc.setAcceptAllFileFilterUsed(false);
		fc.setDialogTitle("Select the text file representing your organism!");
		fc.setFileFilter(new FileNameExtensionFilter("Text Files (Organism)", new String[]{"txt"}));
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
    } //Post-Condition: A previously saved organism was printed onto the screen
    
    //Help Method - Purpose: To display a help/instructions screen!
    //Pre-Condition: The 'Instructions' menu bar option was clicked
    public void help()
    {
    	JFrame insScr=new JFrame("Instructions");
    	JLabel instructions=new JLabel(new ImageIcon(getClass().getResource("Instructions.png")));
    	
        insScr.add(instructions);
        insScr.setSize(900,600);
        insScr.setVisible(true);
        
        Dimension screenLoc=Toolkit.getDefaultToolkit().getScreenSize();
		insScr.setLocation(screenLoc.width/2-insScr.getSize().width/2, screenLoc.height/2-insScr.getSize().height/2);
            
    } //Post-Condition: The instructions screen was displayed
    
    //Action Listener Events
    public void actionPerformed(ActionEvent ae)
    {
    	try
    	{
    		if(ae.getSource()==save) save();
    	}
    	catch(Exception e)
    	{
    		System.err.println("Caught Exception");
    	}
    	
    	try
    	{
    		if(ae.getSource()==load) load();
    	}
    	catch(Exception e)
    	{
    		System.err.println("Caught Exception");
    	}
    	
    	if(ae.getSource()==defOrg) newOrg();
    	try
    	{
    		if(ae.getSource()==userOrg) userOrg();
    	}
    	catch(Exception e)
    	{
    		System.err.println("Caught Exception");
    	}
    	
    	if(ae.getSource()==helpItem) help();
    	if(ae.getSource()==close) System.exit(0);
    }
} //End of BioMorph Class (Main Class)
