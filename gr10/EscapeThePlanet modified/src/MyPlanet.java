
 import java.io.*;
 
public class MyPlanet {
	
	private void DisplayTitle()
	{
	//title page
	System.out.println("");
  	System.out.println(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
   	System.out.println("");
   	System.out.println("    *                                                      *");
   	System.out.println("");
   	System.out.println("                   _____      ");
   	System.out.println("                  |   __|___ ___ ___ ___ ___          *                                   *");
   	System.out.println("                  |   __|_ -|  _| .'| . | -_|                            ___ ");
   	System.out.println("           *      |_____|___|___|__,|  _|___|                        ,o88888 ");
   	System.out.println("                      _   _         |_|                           ,o8888888'");
   	System.out.println("                     | |_| |_ ___           ,:o:o:oooo.        ,8O88Pd8888\"         *");
   	System.out.println("                     |  _|   | -_|      ,.::.::o:ooooOoOoO. ,oO8O8Pd888'");
   	System.out.println("      *              |_| |_|_|___|   ,.:.::o:ooOoOoOO8O8OOo.8OOPd8O8O\" ");
   	System.out.println("                _____ _             _,..:.::o:ooOoOOOO8OOOOo.FdO8O8\"                           *");
   	System.out.println("               |  _  | |___ ___ ___| |_:.::o:ooOoOO8O888O8O,COCOO");
   	System.out.println("               |   __| | .'|   | -_|  _|.::o:ooOoOOOO8OOOOCOCO");
   	System.out.println("               |__|  |_|__,|_|_|___|_|:.::o:ooOoOoOO8O8OCCCC\"o          *");
   	System.out.println("                                    . ..:.::o:ooooOoCoCCC\"o:o ");
   	System.out.println("                                   . ..:.::o:o:,cooooCo\"oo:o:");
   	System.out.println("               *                 `  . . ..:.:cocoooo\"'o:o:::' ");
   	System.out.println("                                 .`  . ..::ccccoc\"'o:o:o:::'");
   	System.out.println("                               :.:.    ,c:cccc\"':.:.:.:.:.");
   	System.out.println("                             ..:.:\"'`::::c:\"'..:.:.:.:.:.");
   	System.out.println("                           ...:.'.:.::::\"'    . . . . .'                               *");
   	System.out.println("       *                  .. . ....:.\"' `   .  . . '' ");
   	System.out.println("                        . . . ....\"'");
   	System.out.println("                        .. . .\"'     ");
   	System.out.println("                       . ");
   	System.out.println("                                                  *                          *");
   	System.out.println("");
   	System.out.print(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
   	System.out.print("to continue press enter");
	}
	
	private void DisplayInstruction()
	{
	//instruction page
	System.out.println("");
    System.out.println(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("                      _____           _                   _   _             ");
    System.out.println("                      \\_   \\_ __  ___| |_ _ __ _   _  ___| |_(_) ___  _ __  ");
    System.out.println("                       / /\\/ '_ \\/ __| __| '__| | | |/ __| __| |/ _ \\| '_ \\ ");
    System.out.println("                    /\\/ /_ | | | \\__ \\ |_| |  | |_| | (__| |_| | (_) | | | |");
    System.out.println("                    \\____/ |_| |_|___/\\__|_|   \\__,_|\\___|\\__|_|\\___/|_| |_|");
    System.out.println("");
    System.out.println("");
    System.out.println("                                   Welcome to Escape the Planet!");
    System.out.println("");
    System.out.println("        This program calculates the escape velocity - a minimum speed of any object required  ");
    System.out.println("");
    System.out.println("         to escape the gravitational pull of a planet. It will also calculate the radius ");
    System.out.println("");
    System.out.println("            and the mass of the planet. You will be asked to input the diameter and ");
    System.out.println("");
    System.out.println("                         acceleration due to gravity. The results will be ");
    System.out.println("");
    System.out.println("                                      printed on the screen ");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.print(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
    System.out.print("to continue press enter");
	}
	
	private void SayThankYou()
	{
	//thank you page
	System.out.println("");
    System.out.println(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("                         _   _                 _                        ");
    System.out.println("                        | | | |               | |  ");
    System.out.println("                        | |_| |__   __ _ _ __ | | __  _   _  ___  _   _ ");
    System.out.println("                        | __| '_ \\ / _` | '_ \\| |/ / | | | |/ _ \\| | | |");
    System.out.println("                        | |_| | | | (_| | | | |   <  | |_| | (_) | |_| |");
    System.out.println("                         \\__|_| |_|\\__,_|_| |_|_|\\_\\  \\__, |\\___/ \\__,_|");
    System.out.println("                                                       __/ |  ");
    System.out.println("                                                      |___/");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("                             I hoped you found my program useful.");
    System.out.println("");
    System.out.println("  If you have any questions or thoughts about Escape the Planet you can send me an email on:");
    System.out.println("");
    System.out.println("");
    System.out.println("                                       Nam.Nguyen@ham.ca");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.print(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
    System.out.print("");
	}
	
    public void Kunek(Double circumference, Double accel, BufferedReader br) throws Exception
    {
    	
    //BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    
    //declaring variables
	double radius;
	double mass;
	double vEscape;	//escape velocity
	final double G = 6.6726e-11; //gravitational constant
	
   	DisplayTitle();
   	//pausing program
   	br.readLine();

DisplayInstruction();    
    //pausing program
    br.readLine();
   	System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
   		
   	//input
   	System.out.println("Please enter circumference in km");
    System.out.print("\t");
    
    System.out.print("\n\n");
    
   	System.out.println("Please enter acceleration due to gravity");
   	System.out.print("\t");
   	
    //calculations	
	radius = circumference / Math.PI / 2;

	radius = Math.round(radius * 10);

	radius = radius * 100;	
	
	mass = (accel*radius*radius)/G;
	
	vEscape = (Math.sqrt((2*G*mass)/radius))/1000;

	vEscape = Math.round(vEscape * 100); 

	vEscape = vEscape / 100 ; 

	radius /= 1000;

DisplayResult(radius, mass, vEscape);
   	
   	//pausing program
	br.readLine();
		
    SayThankYou();
    }
    
    private void DisplayResult(Double radius, Double mass, Double vEscape)
{
	//output page
	System.out.println("");
  	System.out.println(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	Out.print("the radius of the planet is ",50);
 	Out.printLeft(radius+ "km",10);
   	System.out.println("");
   	System.out.println("");
   	Out.print("the mass of the planet is ",50);
 	Out.print(mass,20,1);
 	Out.printLeft("kg",5);
   	System.out.println("");
   	System.out.println("");
 	Out.print("the escape velocity is ",50);
 	Out.printLeft(vEscape+ "km/s",10);
	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.println("");
   	System.out.print(",:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,,:';,;'");
   	System.out.print("to continue press enter");
}	

}
