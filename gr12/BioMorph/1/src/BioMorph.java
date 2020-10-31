
import javax.swing.*;
import java.awt.*;
 
public class BioMorph extends JFrame{
	
	JLabel reproduce=new JLabel(new ImageIcon("reproduce.png"));
	JLabel viewGenes=new JLabel(new ImageIcon("genes.png"));
	JLabel animation=new JLabel(new ImageIcon("animation.png"));
			
    public static void main(String[] args){
    	new BioMorph();
    }
    
    BioMorph(){
    	//JFrame Settings    	
    	setTitle("BioMorph");		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setSize(500,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setUndecorated(true);
		//setLayout(null);
		Evolution e = new Evolution();
		add(e);
		setVisible(true);
		int[] genes={3,5,5,5,5,5,5,5,5,78,2};
		Organism parent = new Organism(genes, 1);
		e.setParent(parent);
    }
}
