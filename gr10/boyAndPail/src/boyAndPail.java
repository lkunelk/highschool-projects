/**
 * @(#)boyAndPail.java
 *
 * boyAndPail application
 *
 * The program solves a simple riddle using loops.
 * It takes 3 numbers from user: height of the well, amount the pail goes up in a day and amount the pail falls at night.
 * Then it calculates amount of days it takes for the pail to be pulled out of the well and displays the answer.
 *
 * author: Nam Nguyen 
 * started 2013/3/22
 * finished 2013/4/5
 */
 
 import java.io.*;//FOR INPUT
 
public class boyAndPail {
	
    public static void main(String[] args) throws Exception{
    
    //CREATING INPUT OBJECT
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //DECLARE VARIABLES
    char choice;
    int height = 0;
   	int up = 0;
   	int down = 0;
   	int day = 0;
    	
    displayTitle(br);
    	
		do	//START LOOP
		{
			choice = displayMenu(br);
			
			    switch(choice){//MENU CHOICE
    		
    			case 'I':	//INSTRUCTIONS
				case 'i':	displayInstruction(br);
							break;
					
				case 'S':	//GAME
				case 's':	playGame(height, up, down, day, br);
							break;
				
				case 'Q':	//EXIT GAME	
				case 'q':	
							break;
				
				default: displayInvalid(br);
			   	}
	
		}//END LOOP
		while(choice != 'q' && choice!= 'Q');
		
    }//END MAIN METHOD
    
    //METHOD FOR DISPLAYING TITLE
    static void displayTitle(BufferedReader br) throws Exception{
    	System.out.println("");
        System.out.println("");
    	System.out.println("");
       	System.out.println("");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("        ______                                 _ ");
    	System.out.println("       ( ___  \\                               | |");
    	System.out.println("       | |__)  ) ___  _   _    _____ ____   __| |                 _______");
    	System.out.println("       |  __  ( / _ \\| | | |  (____ |  _ \\ / _  |             _.-()______)-._");
       	System.out.println("       | |__)  ) |_| | |_| |  / ___ | | | ( (_| |           .'               '.");
    	System.out.println("       |______/ \\___/ \\__  |  \\_____|_| |_|\\____|          /                   \\");
    	System.out.println("                      (____/                              :      _________      :");
    	System.out.println("                                                          |.--'''         '''--.|");
    	System.out.println("                                             ______       ( _                    )");
    	System.out.println("                                            ( ____ \\     (_) |..._________...--':");
    	System.out.println("                                    _____   | |___) )____ _| |                  :");
    	System.out.println("                                   (____ |  |  ____(____ | | |                  :");
    	System.out.println("                                   / ___ |  | |    / ___ | | |                 :");
    	System.out.println("                                   \\_____|  |_|    \\_____|_|\\_)               :");
    	System.out.println("                                                            :                 :");
    	System.out.println("                                                             :               :");
    	System.out.println("                                                             :               :");
    	System.out.println("                        Press Enter To Continue               :             :");
    	System.out.println("                                                              :_           _:");
    	System.out.println("                                                                '''-----''' ");
    	System.out.println("");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("");
    	
    	br.readLine();//PAUSING
    }//END displayTitle() METHOD
      
    //METHOD FOR DISPLAYING MENU
    static char displayMenu(BufferedReader br) throws Exception{
    	
    	System.out.println("");
        System.out.println("");
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
       	System.out.println("");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
       	System.out.println(""); 
       	System.out.println("");
    	System.out.println("");
       	System.out.println("                                               MENU");
       	System.out.println("                                               ----");
    	System.out.println("");
       	System.out.println("                                        'I' - instructions");
    	System.out.println("");
       	System.out.println("                                        'S' - play the game");
    	System.out.println("");
       	System.out.println("                                        'Q' - exit the game");
    	System.out.println("");
    	System.out.println("");
       	System.out.println(""); 
    	System.out.println("");
       	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("");
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    	System.out.println("");
    	System.out.print("Your choice is: ");
    	
    	return br.readLine().charAt(0);//RETURNING CHOICE
    }//END displayMenu() METHOD
    
    //METHOD FOR PLAYING GAME
    static void playGame(int height, int up, int down, int day, BufferedReader br) throws Exception{

		
		//USER INPUT
    	height = askForHeight(height, br);
        down = askForDown(down, br);
    	up = askForUp(up, down, br);
   		
   		int distanceLeft = height;
   
   		do	//START LOOP
   		{
   			//CALCULATIONS
   			distanceLeft -= up;
   			
   			if(distanceLeft > 0)
   			{
   				distanceLeft += down;
   			}
   		
   			day++;
      		
   		}//END LOOP
   		while(distanceLeft > 0);
   		
   		displayResult(height, up, down, day, br);
   		
    }//END playGame() METHOD
    
    	//METHOD FOR ASKING FOR HEIGHT
    	static int askForHeight(int height, BufferedReader br)throws Exception {
    	
    	do //START LOOP
    	{
    		System.out.println("");
        	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                               PLEASE ENTER THE HEIGHT OF THE WELL");
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
	    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("the height is: ");
	    	
	    	//TAKE USER'S INPUT
	    	height = Integer.parseInt(br.readLine());
	    	
	    	if(height < 3 )
	    		displayInvalid(br);
	    		
    	}//CHECK FOR INVALID VALUE
    	while(height < 3 );
    	
    	return height;//RETURN THE VALUE OF HEIGHT
    }
    
		//METHOD FOR ASKING FOR UP
    	static int askForUp(int up, int down, BufferedReader br)throws Exception {
    	
    	do
    	{
    		System.out.println("");
        	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                         PLEASE ENTER A LENGTH THE PAIL GOES UP ON A DAY");
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
	    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("the amount is: ");
	    	
	    	//TAKE USER'S INPUT
	    	up = Integer.parseInt(br.readLine());
	    	
	    	if(up <= down )
	    		displayInvalid(br);
	    		
    	}//CHECK FOR INVALID NUMBER
    	while(up <= down );
    	
    	return up;//RETURN VALUE
    	
    }//END askForUp()
    
    	//METHOD FOR ASKING FOR DOWN
    	static int askForDown(int down, BufferedReader br)throws Exception {
    	
    	do	//START LOOP
    	{
    		System.out.println("");
        	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                  PLEASE ENTER A LENGTH THE PAIL GOES DOWN AT NIGHT");
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
	    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("the amount is: ");
	    	
	    	//TAKE USER'S INPUT
	    	down = Integer.parseInt(br.readLine());
	    	
	    	if(down < 0 )
	    		displayInvalid(br);
	    		
    	}//CHECK FOR INBVALID VALUE
    	while(down < 1 );
    	
    	return down;//RETURN VALUE
    }//END askForDown()
   	
   		//METHOD FOR DISPLAYING RESULT
    	static void displayResult(int height, int up, int down, int day, BufferedReader br) throws Exception{
    		
    		//DECLARE VARIABLE
    	   	String s = "day";
    		
    		if(day > 1)//CHECKING IF NUMBER OF DAYS IS PLURAL
    			s = "days";	
    		
    		System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");		
    	 	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");		
    		System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");		
    	 	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
		   	System.out.println("                  xX                           S                         Xx");
    		System.out.println("                  xX                           S                         Xx"); pausing();
	       	System.out.println("                  xX                           S                         Xx"); pausing();
		   	System.out.println("                  xX                           S                         Xx"); pausing();
		   	System.out.println("                  xX                        ___S___                      Xx"); pausing();
		   	System.out.println("                  xX                    _.-()______)-._                  Xx"); pausing();
		   	System.out.println("                  xX                  .'               '.                Xx"); pausing();
		   System.out.println("                  xX                 /                   \\               Xx"); pausing();
		   	System.out.println("                  xX                :      _________      :              Xx"); pausing();
		   	System.out.println("                  xX                |.--'''         '''--.|              Xx"); pausing();
		  	System.out.println("                  xX                (                     )              Xx"); pausing();
		   	System.out.println("                  xX                :'--..._________...--':              Xx"); pausing();
		   	System.out.println("                  xX                :                     :              Xx"); pausing();
		   	System.out.println("                  xX                 :                   :               Xx"); pausing();
		   	System.out.println("                  xX                 :                   :               Xx"); pausing();
		   	System.out.println("                  xX                  :                 :                Xx"); pausing();
		   	System.out.println("                  xX                  :                 :                Xx"); pausing();
		   	System.out.println("                  xX                   :               :                 Xx"); pausing();
		   	System.out.println("                  xX                   :               :                 Xx"); pausing();
		   	System.out.println("                  xX                    :             :                  Xx"); pausing();
		   	System.out.println("                  xX                    :_           _:                  Xx"); pausing();
		   	System.out.println("                  xX                      '''-----'''                    Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
	       	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
	       	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
	       	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
	       	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
    		System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
	   		System.out.println("                  xX                                                     Xx"); pausing();
	       	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xX                                                     Xx"); pausing();
		   	System.out.println("                  xXxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxXx"); pausing();
		   	System.out.println("                                                                           "); pausing();
		   	System.out.println("                               RESULTS:                                    "); pausing();
		   	System.out.println("                             it took the boy " +day+ " " +s+ " to pull     "); pausing();
		   	System.out.println("                               the pail out of the well                    "); pausing();
		  	System.out.println("                                                                           "); pausing();
		   	System.out.println("                                                                           "); pausing();
		   	System.out.println("                           These are the numbers you chose:                "); pausing();
		   	System.out.println("                             height of the well:  " +height                 ); pausing();
		   	System.out.println("                              going up on a day:  " +up                     );pausing();
		   	System.out.println("                            going down at night:  " +down                   );pausing();
		   	System.out.println("                                                                           ");pausing();
		   	System.out.println("                  xXxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxXx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX           Press enter to go back to menu            Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	System.out.println("                  xX                                                     Xx");pausing();
		   	
		   	br.readLine();//PAUSING
   	}//END displayResult() 
   	
    //METHOD FOR DISPLAYING INSTRUCTIONS
   	static void displayInstruction(BufferedReader br) throws Exception{
    	System.out.println("");
        System.out.println("");
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
       	System.out.println("");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                           Instructions");
       	System.out.println("                                           ------------");
       	System.out.println("");
    	System.out.println("                A boy is pulling a pail of water from a well. He can pull up the ");
    	System.out.println("            pail a certain amount during the day but during night the pail slips down. ");
       	System.out.println("                       How many days will it take the boy to get his water?");
       	System.out.println("                                           You decide!");
       	System.out.println("");
    	System.out.println("                                You will be asked for 3 numbers:");
    	System.out.println("                                     the height of the well");
    	System.out.println("                            number of metres the boy pulls the pail up");
    	System.out.println("                           number of metres the pail goes down at night");
    	System.out.println("");
       	System.out.println("            Based on these numbers, the program will calculate the number of days "); 
    	System.out.println("                            it will take the boy to pull out the pail.");
       	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    	System.out.println("");
    	System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    	System.out.println("");
    	System.out.print("Press enter go back to menu");
    	
    	br.readLine();//PAUSING
    }// END displayInstruction()
    
	//METHOD FOR DISPLAYING INVALID
	static void displayInvalid(BufferedReader br) throws Exception {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
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
    	System.out.println("                               Sorry, this is an invalid choice");
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
    	System.out.println("");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");	
    	
    	br.readLine();//PAUSING
	}//END displayInvalid()
    
    //METHOD FOR PAUSING
    static void pausing() throws InterruptedException{
    	Thread.sleep(90);
    }//END pausing()
    
}//end class
