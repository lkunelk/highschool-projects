/**
 * @(#)ReversedTicTacToe.java
 *
 * ReversedTicTacToe application
 *
 * author: Nam Nguyen
 * @version 1.00 2013/5/4
 */
 
import java.io.*;//FOR INPUT
 
public class ReverseTicTacToe {
    
    public static void main(String[] args)throws Exception {
    
    	//CREATING INPUT OBJECT
   		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	
    	//DECLARING VARIABLES
    	char choice;
    	
    	displayTitle();
    	br.readLine();//PAUSING
    	
    	do
    	{
    		displayMenu();
    		choice = br.readLine().charAt(0); //GETTING CHOICE FROM USER
    		
    		//MENU CHOICES
    		switch(choice)
    		{
    			case 'H':	//INSTRUCTIONS
    			case 'h':	displayInstructions();
    						br.readLine();//PAUSING
    						break;
    						
    			case 'C':	//PLAYER VS COMPUTER
    			case 'c':	playPvC(br);
    						break;
    				
    			case 'P':	//PLAYER VS PLAYER
    			case 'p':	playPvP(br);
    						break;
    						
    			case 'f':	//COMPUTER VS COMPUTER
    			case 'F':	playCvC(br);
    						break;
    			
    			case 'Q':	//EXIT GAME
    			case 'q':	break;
    			
    			default:	displayInvalid();
    						br.readLine();//PAUSING
    			
    		}//END SWITCH
    			
    	}//END LOOP
    	while(choice != 'q' && choice != 'Q');
    	
    	displayThankYou();
    	br.readLine();//PAUSING
    	
    }//END main()
    
    //METHOD FOR DISPLAYING TITLE
    static void displayTitle() {
    	
    	System.out.println("");
    	System.out.println("");
    	System.out.println("            ___ ");
    	System.out.println("           |  _ \\");
    	System.out.println("           | (_) )   __   _   _    __   _ __   ___    __ ");
    	System.out.println("           |    /  / __ \\( ) ( ) / __ \\(  __)/  __) / __ \\");
        System.out.println("           | |\\ \\ (  ___/| \\_/ |(  ___/| |   \\__  \\(  ___/");
    	System.out.println("           (_) (_) \\____) \\___/  \\____)(_)   (____/ \\____)");
       	System.out.println("                              |              |              |              ");
    	System.out.println("                              |              |              |              ");
    	System.out.println("                              |   _____      |              |              ");
    	System.out.println("                              |  (_   _)_    |              |              ");
    	System.out.println("                --------------+--  | | (_)   ___------------+--------------");
    	System.out.println("                              |    | | | | / ___)           |              ");
    	System.out.println("                              |    | | | |( (___            |              ");
    	System.out.println("                              |    (_) (_) \\____)           |              ");
    	System.out.println("                              |                   _____     |              ");
    	System.out.println("                              |              |   (_   _)    |              ");
    	System.out.println("                              |              |     | |   _ _    ___        ");
    	System.out.println("                              |              |     | | / _  ) / ___)       ");
    	System.out.println("                --------------+--------------+---- | |( (_| |( (___ -------");
    	System.out.println("                              |              |     (_) \\__,_) \\____)       ");
    	System.out.println("                              |              |                       _____ ");
    	System.out.println("                              |              |              |       (_   _)            ");
    	System.out.println("                              |              |              |         | |   _      __  ");
    	System.out.println("                              |              |              |         | | / _ \\  / __ \\");
    	System.out.println("                              |              |              |         | |( (_) )(  ___/");
    	System.out.println("                              |              |              |         (_) \\___/  \\____)");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                  PRESS ENTER TO CONTINUE");	
    }//END displayTitle()

    //METHOD FOR DISPLAYING MENU
    static void displayMenu() {
    	
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                               |              |              |              ");
        System.out.println("                               |   __  __     |              |              ");
    	System.out.println("                               |  |  \\/  | ___ _ __  _   _   |              ");
       	System.out.println("                               |  | |\\/| |/ _ \\ '_ \\| | | |  |              ");
    	System.out.println("                               |  | |  | |  __/ | | | |_| |  |              ");
    	System.out.println("                               |  |_|  |_|\\___|_| |_|\\__,_|  |              ");
    	System.out.println("                               |                             |              ");
    	System.out.println("                 --------------+--------------+--------------+--------------");
    	System.out.println("                               |                             |              ");
    	System.out.println("                               |   h - How to Play           |              ");
    	System.out.println("                               |   p - player   vs. player   |              ");
    	System.out.println("                               |   c - computer vs. player   |              ");
    	System.out.println("                               |   f - computer vs. computer |              ");
    	System.out.println("                               |   q - exit the game         |              ");
    	System.out.println("                               |                             |              ");
    	System.out.println("                 --------------+--------------+--------------+--------------");
    	System.out.println("                               |              |              |              ");
    	System.out.println("                               |              |              |              ");
    	System.out.println("                               |              |              |              ");
    	System.out.println("                               |              |              |              ");
    	System.out.println("                               |              |              |              ");
    	System.out.println("                               |              |              |              ");
    	System.out.println("                               |              |              |              ");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("your choice is: ");	
    }//END displayMenu()

    //METHOD FOR DISPLPAYING INSTRUCTIONS
    static void displayInstructions() {
    	
    	System.out.println("");
        System.out.println("");
    	System.out.println("");
       	System.out.println("");
    	System.out.println("                       _   _                 _          ____  _  ");
    	System.out.println("                      | | | | _____     __  | |_ ___   |  _ \\| | __ _ _   _");
    	System.out.println("                      | |_| |/ _ | | /\\ | | | __/ _ \\  | |_) | |/ _` | | | |");
    	System.out.println("                      |  _  | (_) \\ V  V /  | || (_) | |  __/| | (_| | |_| |");
    	System.out.println("                      |_| |_|\\___/ \\_/\\_/    \\__\\___/  |_|   |_|\\__,_|\\__, |");
    	System.out.println("                                                                      |___/");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                           Reversed Tic Tac Toe has slightly different ");
    	System.out.println("                           rules than the normal Tic Tac Toe game");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                         1. The game is played on a grid of 3x4.");
    	System.out.println("                         2. The goal of the game is not to get a 3 in a row");
    	System.out.println("                             but to force your opponent to get a 3.");
    	System.out.println("                         3. If by the last turn no one gets a 3 in a row");
    	System.out.println("                             it's a tie.");
    	System.out.println("");
    	System.out.println("                       That's all you need to know to play Reversed Tic Tac Toe!");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                  Press Enter To Return To Menu");
    	System.out.print("");	
    	
    }//END displayInstructions()
        
    //METHOD FOR PLAYING PLAYER VS PLAYER
    static void playPvP(BufferedReader br)throws Exception {
    	
    	//DECLARING VARIABLES
    	int mode = 1; //tells displayBoard() what to display
    	int p1Win = 0; //player 1 score
    	int p2Win = 0; //player 2 score
    	int tie = 0; //number of ties
    	int player1 = 2; //decides whose turn it is
    	int player2 = 1; //decides whose turn it is
    	int lose = 0; //tells program when someone wins
    	int temporaryMemory = 0;
    	char choice = ' ';
		
    	do
    	{
    		//RESETTING VARIABLES FOR NEXT GAME
	    	int[] boardDecision = new int[12];
	    	char[][] boardDisplay = new char[23][62];
	    	int turn = 1;
	    	
	    	//SETTING UP GRID BOARD
	    	for(int row = 0; row < 23; row++)
	    	{
	    		boardDisplay[row][14] = boardDisplay[row][30] = boardDisplay[row][46] = '|';
	    	}
	    	
	    	for(int col = 0; col < 62; col++)
	    	{
	    		boardDisplay[7][col] = boardDisplay[15][col] = '-';
	    	}	
	    	
	    	for(int row = 0; row < 23; row++)
	    	{
	    		boardDisplay[row][14] = boardDisplay[row][30] = boardDisplay[row][46] = '|';
	    	}
	    		
    		//SWITCHING WHO GOES FIRST
    		temporaryMemory = player1;
    		player1 = player2;
    		player2 = temporaryMemory;
    		
    		//DISPLAYING NUMBERS ON GRID
    		boardDisplay[1][3] = '1';
      		boardDisplay[1][18] = '2';
    		boardDisplay[1][34] = '3';
    		boardDisplay[1][50] = '4';
    		boardDisplay[9][3] = '5';
    		boardDisplay[9][18] = '6';
    		boardDisplay[9][34] = '7';
    		boardDisplay[9][50] = '8';
    		boardDisplay[17][3] = '9';
    		boardDisplay[17][18] = '1'; boardDisplay[17][19] = '0';
    		boardDisplay[17][34] = '1'; boardDisplay[17][35] = '1';
    		boardDisplay[17][50] = '1'; boardDisplay[17][51] = '2';
    		
			displayBoard(mode, boardDisplay, turn, player1, p1Win, p2Win, tie);
			
    		do //STARTING THE GAME
    		{
    			//START TURN
    			move(br, boardDisplay, boardDecision, turn, p1Win, p2Win, tie, player1, mode);
    			lose = checkWhoWins(boardDecision, lose);
    			
    			turn++;//NEXT TURN
    			displayBoard(mode, boardDisplay, turn, player1, p1Win, p2Win, tie);
    			
    			if(lose > 0)//IF SOMEONE WINS SKIP TO RESULTS
    			{
    				System.out.print("GAME OVER!");
    				br.readLine();
    				break;
    			}
    			
    			
    			//START TURN	
    			move(br, boardDisplay, boardDecision, turn, p1Win, p2Win, tie, player1, mode);
    			lose = checkWhoWins(boardDecision, lose);
    		
    			turn++;//NEXT TURN
    			displayBoard(mode, boardDisplay, turn, player1, p1Win, p2Win, tie);
    			
    			if(lose > 0 || turn == 13)//IF SOMEONE WINS DISPLAY
    			{
    				System.out.print("GAME OVER!");
    				br.readLine();
    			}
    		}//END LOOP
    		while(lose == 0 && turn < 12);
    		
    		//DISPLAY BASED ON WHO WINS
    		if(player1 == lose)
    		{
    			p2Win++; 
    			displayResults(2);
    		} 	 			
    		else if(player2 == lose)
    		{
    			p1Win++;
    			displayResults(1);
    		} 	
    		else 
    		{
    			tie++;
    			displayResults(0);
    		} 			
    		
    		//TAKING USER INPUT
    		choice = br.readLine().charAt(0);
    	}//END LOOP
    	while(choice != 'q' && choice!= 'Q');
    		
    }//END playPvP()
    
    //METHOD FOR DISPLAYING BOARD
    static void displayBoard(int mode, char[][] boardDisplay, int turn, int player1,  int p1Win, int p2Win, int tie) {
    	
    	//DECLARING VARIABLES
		String word;
		char tic = ' ', tac = ' ';
		String p1 = " ", p2 = " ";
		
		//TELLING PROGRAM WHICH PLAYER IS WHAT - O or X
		if(player1 == 1)
		{
			tic = 'O';
			tac = 'X';
		}
		else
		{
			tic = 'X';
			tac = 'O';
		}
		
		//TELLS PROGRAM WHO IS PLAYING
		if(mode==1)
		{
			p1 = "Player 1";
			p2 = "Player 2";
		}
		
		if(mode==2)
		{
			p1 = "Player 1";
			p2 = "Computer";
		}
		
		if(mode==3)
		{
			p1 = "Computer 1";
			p2 = "Computer 2";
		}
		
		//BASED ON PLAYERS TURN SET THE VARIABLE
		if(player1 == 1)
		{
			if(turn % 2 == 1)
				word = "O's";
			else
				word = "X's";
		}
		else
		{
			if(turn % 2 == 0)
				word = "X's";
			else
				word = "O's";
		}
		
		//DISPLAYING BOARD
		System.out.println("");
    	System.out.println("");
    	System.out.println("____________________________________________SCORE_______________________________________________");
    	System.out.println("");
    	System.out.println("     ("+tic+")"+p1+": "+p1Win+"                         tie: " +tie+ "                         ("+tac+")"+p2+": " +p2Win);
    	System.out.println("________________________________________________________________________________________________");
       	System.out.println("");
       	
 
    	
    	for(int row = 0; row < 23; row++)
    	{
    		System.out.print("                ");
    		for(int col = 0; col < 62; col++)
    		{
    			
    			System.out.print(boardDisplay[row][col]);
    		}
    		System.out.println("");
    			
    	}//END LOOP
    	
    	System.out.println("");
		System.out.println("");
    	System.out.println("_____________________________________________ " +word+ " TURN__________________________________________");
    	System.out.print("");
    }//END displayBoard()
    
    //METHOD FOR MAKING A MOVE
    static void move(BufferedReader br, char[][] boardDisplay, int[] boardDecision, int turn, int p1Win, int p2Win, int tie, int player1, int mode)throws Exception {
    	
    	//DECLARING VARIABLES
    	int x = 0;
    	int y = 0;
    	int choice = 0;
    	boolean valid = false;
    	
    	do	//GETTING USER'S CHOICE UNTIL IT'S VALID
    	{
    		System.out.print("Your choice: ");
    		choice = Integer.parseInt(br.readLine());//GETTING USER INPUT
    		
    		//CHECKING IF THE CHOICE IS VALID
	    	if(choice == 1 && boardDecision[0] == 0)
	    	{ 
	    		y = 3;
	    		x = 7;
				valid = true;
	    	}
	    	
	    	if(choice == 2 && boardDecision[1] == 0)
	    	{
	    		y = 3;
	    		x = 22;
	    		valid = true;
	    	}
	    	
	    	if(choice == 3 && boardDecision[2] == 0)
	    	{
	    		y = 3;
	    		x = 38;
	    		valid = true;
	    	}
	    	
	    	if(choice == 4 && boardDecision[3] == 0)
	    	{
	    		y = 3;
	    		x = 54;
	    		valid = true;
	    	}
		
	    	if(choice == 5 && boardDecision[4] == 0)
	    	{
	    		y = 11;
	    		x = 7;
	    		valid = true;
	    	}
	    	
	    	if(choice == 6 && boardDecision[5] == 0)
	    	{
	    		y = 11;
	    		x = 22;
	    		valid = true;
	    	}
	    	
	    	if(choice == 7 && boardDecision[6] == 0)
	    	{
	    		y = 11;
	    		x = 38;
	    		valid = true;
	    	}
	    	
	    	if(choice ==8 && boardDecision[7] == 0)
	    	{
	    		y = 11;
	    		x = 54;
	    		valid = true;
	    	}
	    	
	    	if(choice == 9&& boardDecision[8] == 0)
	    	{
	    		y = 19;
	    		x = 7;
	    		valid = true;
	    	}
	    	
	    	if(choice == 10 && boardDecision[9] == 0)
	    	{
	    		y = 19;
	    		x = 22;
	    		valid = true;
	    		boardDisplay[17][19] = ' ';
	    	}
	    	
	    	if(choice == 11 && boardDecision[10] == 0)
	    	{
	    		y = 19;
	    		x = 38;
	    		valid = true;	    	
    			boardDisplay[17][35] = ' ';
	    	}
	    	
	    	if(choice == 12 && boardDecision[11] == 0)
	    	{
	    		y = 19;
	    		x = 54;
	    		valid = true;
	    		boardDisplay[17][51] = ' ';
	    	}
	    	
	    	if(!valid || (choice < 1 || choice > 12))
	    	{
	    		displayInvalid();
    			br.readLine();//PAUSING
    			displayBoard(mode, boardDisplay, turn, player1, p1Win, p2Win, tie);
	    	}	
    	}//END LOOP
    	while(!valid);
	
    	if(turn % 2 == 1) 	//DISPLAY O IF IT'S AN ODD TURN
    	{
			boardDecision[choice - 1] =	1;//SETTING THE VALUE OF ARRAY TO THE CHOSEN SPOT
			
	    	boardDisplay[y][x+6] = 'o';
	    	boardDisplay[y][x-6] = 'o';
	    	
	    	boardDisplay[y+1][x-6] = 'o';
	    	boardDisplay[y-1][x-6] = 'o';
	    	
	    	boardDisplay[y+2][x-5] = 'o';
	    	boardDisplay[y-2][x-5] = 'o';
	    	
	    	boardDisplay[y+2][x-4] = 'o';
	    	boardDisplay[y-2][x-4] = 'O';
	    	
	    	boardDisplay[y+3][x-3] = 'O';
	    	boardDisplay[y-3][x-3] = 'o';
	    	
	    	boardDisplay[y+3][x-2] = 'o';
	    	boardDisplay[y-3][x-2] = 'o';
	    	
	    	boardDisplay[y+3][x-1] = 'o';
	    	boardDisplay[y-3][x-1] = 'o';
	    	
	    	boardDisplay[y+3][x] = 'o';
	    	boardDisplay[y-3][x] = 'o';
	    	
	    	boardDisplay[y+1][x+6] = 'o';
	    	boardDisplay[y-1][x+6] = 'o';
	    	
	    	boardDisplay[y+2][x+5] = 'o';
	    	boardDisplay[y-2][x+5] = 'o';
	    	
	    	boardDisplay[y+2][x+4] = 'o';
	    	boardDisplay[y-2][x+4] = 'O';
	    	
	    	boardDisplay[y+3][x+3] = 'O';
	    	boardDisplay[y-3][x+3] = 'o';
	    	
	    	boardDisplay[y+3][x+2] = 'o';
	    	boardDisplay[y-3][x+2] = 'o';
	    	
	    	boardDisplay[y+3][x+1] = 'o';
	    	boardDisplay[y-3][x+1] = 'o';
	    	
    	}
    	else if(turn % 2 == 0)	//DISPLAY X IF IT'S AN EVEN TURN
    	{
    		boardDecision[choice - 1] =	2;//SETTING THE VALUE OF ARRAY TO THE CHOSEN SPOT
    		
    	  	//X display
	    	boardDisplay[y][x] = 'x';
	    	
	    	boardDisplay[y+1][x-2] = 'x';
	    	boardDisplay[y+2][x-4] = 'x';
	    	boardDisplay[y+3][x-6] = 'x';
	    	
	    	boardDisplay[y+1][x+2] = 'x';
	    	boardDisplay[y+2][x+4] = 'x';
	    	boardDisplay[y+3][x+6] = 'x';
	    	
	    	boardDisplay[y-1][x-2] = 'x';
	    	boardDisplay[y-2][x-4] = 'x';
	    	boardDisplay[y-3][x-6] = 'x';
	    	
	    	boardDisplay[y-1][x+2] = 'x';
	    	boardDisplay[y-2][x+4] = 'x';
	    	boardDisplay[y-3][x+6] = 'x';
    	}
    }//END move()
    
    //METHOD FOR CHECKING WHO WINS
    static int checkWhoWins(int[] boardDecision, int lose) {
 	
    	//4 VERTICAL SPOTS
    	if(boardDecision[0] > 0 && boardDecision[0] == boardDecision[4] && boardDecision[4] == boardDecision[8])
    	{
    		if(boardDecision[0] == 1)
    			return 1;
    		if(boardDecision[0] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[1] > 0 && boardDecision[1] == boardDecision[5] && boardDecision[5] == boardDecision[9])
    	{
    		if(boardDecision[1] == 1)
    			return 1;
    		if(boardDecision[1] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[2] > 0 && boardDecision[2] == boardDecision[6] && boardDecision[6] == boardDecision[10])
    	{
    		if(boardDecision[2] == 1)
    			return 1;
    		if(boardDecision[2] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[3] > 0 && boardDecision[3] == boardDecision[7] && boardDecision[7] == boardDecision[11])
    	{
    		if(boardDecision[3] == 1)
    			return 1;
    		if(boardDecision[3] == 2)
    			return 2;
    	}
    	
    	//6 HORIZONTAL SPOTS
    	if(boardDecision[0] > 0 && boardDecision[0] == boardDecision[1] && boardDecision[1] == boardDecision[2])
    	{
    		if(boardDecision[0] == 1)
    			return 1;
    		if(boardDecision[0] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[1] > 0 && boardDecision[1] == boardDecision[2] && boardDecision[2] == boardDecision[3])
    	{
    		if(boardDecision[1] == 1)
    			return 1;
    		if(boardDecision[1] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[4] > 0 && boardDecision[4] == boardDecision[5] && boardDecision[5] == boardDecision[6])
    	{
    		if(boardDecision[4] == 1)
    			return 1;
    		if(boardDecision[4] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[5] > 0 && boardDecision[5] == boardDecision[6] && boardDecision[6] == boardDecision[7])
    	{
    		if(boardDecision[5] == 1)
    			return 1;
    		if(boardDecision[5] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[8] > 0 && boardDecision[8] == boardDecision[9] && boardDecision[9] == boardDecision[10])
    	{
    		if(boardDecision[8] == 1)
    			return 1;
    		if(boardDecision[8] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[9] > 0 && boardDecision[9] == boardDecision[10] && boardDecision[10] == boardDecision[11])
    	{
    		if(boardDecision[9] == 1)
    			return 1;
    		if(boardDecision[9] == 2)
    			return 2;
    	}
    	
    	//4 DIAGONAL SPOTS
    	if(boardDecision[0] > 0 && boardDecision[0] == boardDecision[5] && boardDecision[5] == boardDecision[10])
    	{
    		if(boardDecision[0] == 1)
    			return 1;
    		if(boardDecision[0] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[1] > 0 && boardDecision[1] == boardDecision[6] && boardDecision[6] == boardDecision[11])
    	{
    		if(boardDecision[1] == 1)
    			return 1;
    		if(boardDecision[1] == 2)
    			return 2;
    	}
    	
    	if(boardDecision[2] > 0 && boardDecision[2] == boardDecision[5] && boardDecision[5] == boardDecision[8])
    	{
    		if(boardDecision[2] == 1)
    			return 1;
    		if(boardDecision[2] == 2)
    			return 2;
    	}
   	
    	if(boardDecision[3] > 0 && boardDecision[3] == boardDecision[6] && boardDecision[6] == boardDecision[9])
    	{
    		if(boardDecision[3] == 1)
    			return 1;
    		if(boardDecision[3] == 2)
    			return 2;
    	}

    		return 0;

    }//END checkWhoWins()
    
    //METHOD FOR DISPLAYING RESULTS
    static void displayResults(int win) {
    	//DEPENDING ON WHO WON DISPLAY THE FOLLOWING
    	if(win == 1)
    	{
    		System.out.println("");
	        System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                 ____  _                         _ ");
	    	System.out.println("                                |  _ \\| | __ _ _   _  ___ _ __  / |");
	    	System.out.println("                                | |_) | |/ _` | | | |/ _ \\ '__| | |");
	    	System.out.println("                                |  __/| | (_| | |_| |  __/ |    | |");
	    	System.out.println("                                |_|   |_|\\__,_|\\__, |\\___|_|    |_|");
	    	System.out.println("                                               |___/  ");
	    	System.out.println("");
	    	System.out.println("                                               _           _ ");
	    	System.out.println("                                     __      _(_)_ __  ___| |");
	    	System.out.println("                                     \\ \\ /\\ / / | '_ \\/ __| |");
	    	System.out.println("                                      \\ V  V /| | | | \\__ \\_|");
	    	System.out.println("                                       \\_/\\_/ |_|_| |_|___(_)");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                      press 'p' to play again");
	    	System.out.println("");
	    	System.out.println("                                      press 'q' to return to menu");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("");
    	}
    	
    	if(win == 2)
    	{
    		System.out.println("");
	        System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                ____  _                         ____  ");
	    	System.out.println("                               |  _ \\| | __ _ _   _  ___ _ __  |___ \\ ");
	    	System.out.println("                               | |_) | |/ _` | | | |/ _ \\ '__|   __) |");
	    	System.out.println("                               |  __/| | (_| | |_| |  __/ |     / __/ ");
	    	System.out.println("                               |_|   |_|\\__,_|\\__, |\\___|_|    |_____|");
	    	System.out.println("                                              |___/    ");
	    	System.out.println("");
	    	System.out.println("                                               _           _ ");
	    	System.out.println("                                     __      _(_)_ __  ___| |");
	    	System.out.println("                                     \\ \\ /\\ / / | '_ \\/ __| |");
	    	System.out.println("                                      \\ V  V /| | | | \\__ \\_|");
	    	System.out.println("                                       \\_/\\_/ |_|_| |_|___(_)");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                      press 'p' to play again");
	    	System.out.println("");
	    	System.out.println("                                     press 'q' to return to menu");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("");
    	}
    	
    	if(win == 0)
    	{
    		System.out.println("o");
	        System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                ___ _   _               _   _ ");
	    	System.out.println("                               |_ _| |_( )___    __ _  | |_(_) ___ ");
	    	System.out.println("                                | || __|// __|  / _` | | __| |/ _ \\");
	    	System.out.println("                                | || |_  \\__ \\ | (_| | | |_| |  __/");
	    	System.out.println("                               |___|\\__| |___/  \\__,_|  \\__|_|\\___|");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                      press 'p' to play again");
	    	System.out.println("");
	    	System.out.println("                                    press 'q' to return to menu");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("o");
    	}
    	if(win == 3)
    	{
    		System.out.println("");
	        System.out.println("");
	    	System.out.println("");
	       	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                           ____                            _         ");
	    	System.out.println("                          / ___|___  _ __ ___  _ __  _   _| |_ ___ _ __ ");
	    	System.out.println("                         | |   / _ \\| '_ ` _ \\| '_ \\| | | | __/ _ \\ '__|");
	    	System.out.println("                         | |__| (_) | | | | | | |_) | |_| | ||  __/ |   ");
	    	System.out.println("                          \\____\\___/|_| |_| |_| .__/ \\__,_|\\__\\___|_|   ");
	    	System.out.println("                                              |_| ");
	    	System.out.println("");
	    	System.out.println("                                               _           _ ");
	    	System.out.println("                                     __      _(_)_ __  ___| |");
	    	System.out.println("                                     \\ \\ /\\ / / | '_ \\/ __| |");
	    	System.out.println("                                      \\ V  V /| | | | \\__ \\_|");
	    	System.out.println("                                       \\_/\\_/ |_|_| |_|___(_)");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("                                      press 'p' to play again");
	    	System.out.println("");
	    	System.out.println("                                    press 'q' to return to menu");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.println("");
	    	System.out.print("");
    	}
    }//END displayResults()
    
    //METHOD FOR PLAYING AGAINST COMPUTER
    static void playPvC(BufferedReader br)throws Exception {
    	//DECLARING VARIABLES
    	int mode = 2;
    	int difficulty = 0;
    	int p1Win = 0; //player 1 score
    	int computerWin = 0; //player 2 score
    	int tie = 0; //number of ties
    	int player1 = 2; //decides whose turn it is
    	int computer = 1; //decides whose turn it is
    	int lose = 0; //tells program when someone wins
    	int temporaryMemory = 0;
    	char choice = ' ';
		
		do//SETTING THE DIFFICULTY OF COMPUTER
		{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("                                What difficulty do you want to play?\n");
		System.out.println("                                          'e' for easy");
		System.out.println("                                          'm' for medium");
		System.out.println("                                          'h' for hard");
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\nyour choice: ");
		choice = br.readLine().charAt(0);//TAKING USER CHOICE
		
			switch(choice)
			{
				case 'E':
				case 'e':	difficulty = 1;
							break;
					
				case 'M':
				case 'm':	difficulty = 2;
							break;
					
				case 'H':
				case 'h':	difficulty = 3;
							break;
					
				default: 	choice = ' ';
							displayInvalid();
							br.readLine();
			}//END SWITCH
		}//END LOOP
		while(choice == ' ');
		
    	do
    	{
    		//RESETTING VARIABLES FOR NEXT GAME
    		int[] computerDecision = new int[12];
	    	int[] boardDecision = new int[12];
	    	char[][] boardDisplay = new char[23][62];
	    	int turn = 1;
	    	
	    	//SETTING UP GRID BOARD
	    	for(int row = 0; row < 23; row++)
	    	{
	    		boardDisplay[row][14] = boardDisplay[row][30] = boardDisplay[row][46] = '|';
	    	}
	    	
	    	for(int col = 0; col < 62; col++)
	    	{
	    		boardDisplay[7][col] = boardDisplay[15][col] = '-';
	    	}	
	    	
	    	for(int row = 0; row < 23; row++)
	    	{
	    		boardDisplay[row][14] = boardDisplay[row][30] = boardDisplay[row][46] = '|';
	    	}	
    		//SWITCHING WHO GOES FIRST
    		temporaryMemory = player1;
    		player1 = computer;
    		computer = temporaryMemory;
    		
    		//DISPLAYING NUMBERS ON BOARD
    		boardDisplay[1][3] = '1';
      		boardDisplay[1][18] = '2';
    		boardDisplay[1][34] = '3';
    		boardDisplay[1][50] = '4';
    		boardDisplay[9][3] = '5';
    		boardDisplay[9][18] = '6';
    		boardDisplay[9][34] = '7';
    		boardDisplay[9][50] = '8';
    		boardDisplay[17][3] = '9';
    		boardDisplay[17][18] = '1'; boardDisplay[17][19] = '0';
    		boardDisplay[17][34] = '1'; boardDisplay[17][35] = '1';
    		boardDisplay[17][50] = '1'; boardDisplay[17][51] = '2';
    		
			displayBoard(mode, boardDisplay, turn, player1, p1Win, computerWin, tie);
			
    		do //STARTING THE GAME
    		{
    			//START TURN
    			if(player1 == 1)
    			{
    				move(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, mode);
    			}
    			else
    			{
    				computerMove(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, computer, mode, difficulty);
    			}
    			
	    		lose = checkWhoWins(boardDecision, lose);
	    		
	    		turn++;//NEXT TURN
	    		
	    		displayBoard(mode, boardDisplay, turn, player1, p1Win, computerWin, tie);
	    		
	    		if(lose > 0)//IF SOMEONE WINS SKIP TO RESULTS
	    		{
	    			System.out.print("GAME OVER!");
	    			br.readLine();
	    			break;
	    		}
    			

    			//START TURN	
    			if(player1 == 2)
    			{
    				move(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, mode);	
    			}
    			else
    			{
    				computerMove(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, computer, mode, difficulty);
    			}
    			
    			lose = checkWhoWins(boardDecision, lose);
    		
    			turn++;//NEXT TURN
    			
    			displayBoard(mode, boardDisplay, turn, player1, p1Win, computerWin, tie);
    			
    			if(lose > 0 || turn == 13)//IF SOMEONE WINS DISPLAY
    			{
    				System.out.print("GAME OVER!");
    				br.readLine();
    			}
    		}//END LOOP
    		while(lose == 0 && turn < 12);
			
			//BASED ON WHO WON DISPLAY RESULTS AND ADD TO THE SCORE
    		if(player1 == lose)
    		{
    			computerWin++; 
    			displayResults(3);
    		} 	 			
    		else if(computer == lose)
    		{
    			p1Win++;
    			displayResults(1);
    		} 	
    		else 
    		{
    			tie++;
    			displayResults(0);
    		} 			
    		
    		choice = br.readLine().charAt(0);//TAKING USER CHOICE
    		
    	}//END LOOP
    	while(choice != 'q' && choice!= 'Q');
    		
    }//END playPvC()
 
    //METHOD FOR COMPUTER PLAYING AGAINST COMPUTER
    static void playCvC(BufferedReader br)throws Exception {
    	//DECLARING VARIABLES
    	int mode = 2;
    	int p1Win = 0; //player 1 score
    	int computerWin = 0; //player 2 score
    	int tie = 0; //number of ties
    	int player1 = 2; //decides whose turn it is
    	int computer = 1; //decides whose turn it is
    	int lose = 0; //tells program when someone wins
    	int temporaryMemory = 0;
    	char choice = ' ';
		int difficulty = 3;
		
    	do
    	{
    		//RESETTING VARIABLES FOR NEXT GAME
    		int[] computerDecision = new int[12];
	    	int[] boardDecision = new int[12];
	    	char[][] boardDisplay = new char[23][62];
	    	int turn = 1;
	    	
	    	//SETTING UP GRID BOARD
	    	for(int row = 0; row < 23; row++)
	    	{
	    		boardDisplay[row][14] = boardDisplay[row][30] = boardDisplay[row][46] = '|';
	    	}
	    	
	    	for(int col = 0; col < 62; col++)
	    	{
	    		boardDisplay[7][col] = boardDisplay[15][col] = '-';
	    	}	
	    	
	    	for(int row = 0; row < 23; row++)
	    	{
	    		boardDisplay[row][14] = boardDisplay[row][30] = boardDisplay[row][46] = '|';
	    	}	
    		//SWITCHING WHO GOES FIRST
    		temporaryMemory = player1;
    		player1 = computer;
    		computer = temporaryMemory;
    		
			displayBoard(mode, boardDisplay, turn, player1, p1Win, computerWin, tie);
			
    		do //STARTING THE GAME
    		{
    			//START TURN
    			if(player1 == 1)
    			{
    				computerMove(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, computer, mode, difficulty);
    			}
    			else
    			{
    				computerMove2(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, computer, mode);
    			}
    			displayBoard(mode, boardDisplay, turn, player1, p1Win, computerWin, tie);
	    		lose = checkWhoWins(boardDecision, lose);
	    		
	    		turn++;//NEXT TURN

	    		if(lose > 0)//IF SOMEONE WINS SKIP TO RESULTS
	    		{
	    			time();time();
	    			break;
	    		}
    			

    			//START TURN	
    			if(player1 == 2)
    			{
    				computerMove(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, computer, mode, difficulty);	
    			}
    			else
    			{
    				computerMove2(br, boardDisplay, boardDecision, turn, p1Win, computerWin, tie, player1, computer, mode);
    			}
    			displayBoard(mode, boardDisplay, turn, player1, p1Win, computerWin, tie);
    			lose = checkWhoWins(boardDecision, lose);
				
				if(lose > 0)//IF SOMEONE WINS SKIP TO RESULTS
	    		{
	    			time();time();
	    			break;
	    		}
	    		
    			turn++;//NEXT TURN
   
    		}//END LOOP
    		while(lose == 0 && turn < 12);

    		if(player1 == lose)
    		{
    			computerWin++; 
				displayResults(1);
    		} 	 			
    		else if(computer == lose)
    		{
    			p1Win++;
 				displayResults(3);
    		} 	
    		else 
    		{
    			tie++;
				displayResults(0);
    		} 			
    		
    		time();time();time();
    	}//END LOOP
    	while(choice != 'q' && choice!= 'Q');
    		
    }//END playPvC() 
    
    //METHOD FOR PAUSING
    static void time()throws InterruptedException{
    	    	Thread.sleep(500);  	
    }//END time()
    
    //METHOD FOR COMPUTER MAKING A MOVE
    static void computerMove(BufferedReader br, char[][] boardDisplay, int[] boardDecision, int turn, int p1Win, int computerWin, int tie, int player1, int computer, int mode, int difficulty)throws Exception {
    	
    	//DECLARING VARIABLES
    	int x = 0;
    	int y = 0;
    	boolean tracing = false;
    	int test = 0;
    	int choice = 0;
    	int number = 0;
    	boolean valid = false;
    	int[] compDecision = new int[12];
    	int[] random = new int[12];
    
    	if(difficulty>1)//IF DIFFICULTY IS MEDIUM OR HARD
    	{
			//LOOKING FOR SPOTS NOT BESIDE PLAYER1
    		//4 vertical spots
	    	if(boardDecision[0] == player1 || boardDecision[4] == player1 || boardDecision[8] == player1)
	    	{
	    		compDecision[0]=1;
	    		compDecision[4]=1;
	    		compDecision[8]=1;
	    	}
	    	
	    	if(boardDecision[1] == player1 || boardDecision[5] == player1 || boardDecision[9] == player1)
	    	{
	    		compDecision[1]=1;
	    		compDecision[5]=1;
	    		compDecision[9]=1;
	    	}
	    	
	    	if(boardDecision[2] == player1 || boardDecision[6] == player1 || boardDecision[10] == player1)
	    	{
	    		compDecision[2]=1;
	    		compDecision[6]=1;
	    		compDecision[10]=1;
	    	}
	    	
	    	if(boardDecision[3] == player1 || boardDecision[7] == player1 || boardDecision[11] == player1)
	    	{
	    		compDecision[3]=1;
	    		compDecision[7]=1;
	    		compDecision[11]=1;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if(boardDecision[0] == player1 || boardDecision[1] == player1 || boardDecision[2] == player1)
	    	{
	    		compDecision[0]=1;
	    		compDecision[1]=1;
	    		compDecision[2]=1;
	    	}
	    	
	    	if(boardDecision[1] == player1 || boardDecision[2] == player1 || boardDecision[3] == player1)
	    	{
	    		compDecision[1]=1;
	    		compDecision[2]=1;
	    		compDecision[3]=1;
	    	}
	    	
	    	if(boardDecision[4] == player1 || boardDecision[5] == player1 || boardDecision[6] == player1)
	    	{
	    		compDecision[4]=1;
	    		compDecision[5]=1;
	    		compDecision[6]=1;
	    	}
	    	
	    	if(boardDecision[5] == player1 || boardDecision[6] == player1  || boardDecision[7] == player1)
	    	{
	    		compDecision[5]=1;
	    		compDecision[6]=1;
	    		compDecision[7]=1;
	    	}
	    	
	    	if(boardDecision[8] == player1 || boardDecision[9] == player1  || boardDecision[10] == player1)
	    	{
	    		compDecision[8]=1;
	    		compDecision[9]=1;
	    		compDecision[10]=1;
	    	}
	    	
	    	if(boardDecision[9] == player1 || boardDecision[10] == player1 || boardDecision[11] == player1)
	    	{
	    		compDecision[9]=1;
	    		compDecision[10]=1;
	    		compDecision[11]=1;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if(boardDecision[0] == player1 || boardDecision[5] == player1 || boardDecision[10] == player1)
	    	{
	    		compDecision[0]=1;
	    		compDecision[5]=1;
	    		compDecision[10]=1;
	    	}
	    	
	    	if(boardDecision[1] == player1 || boardDecision[6] == player1 || boardDecision[11] == player1)
	    	{
	    		compDecision[1]=1;
	    		compDecision[6]=1;
	    		compDecision[11]=1;
	    	}
	    	
	    	if(boardDecision[2] == player1 || boardDecision[5] == player1 || boardDecision[8]== player1)
	    	{
	    		compDecision[2]=1;
	    		compDecision[5]=1;
	    		compDecision[8]=1;
	    	}
	   	
	    	if(boardDecision[3] == player1 || boardDecision[6] == player1 || boardDecision[9] == player1)
	    	{
	    		compDecision[3]=1;
	    		compDecision[6]=1;
	    		compDecision[9]=1;
	    	}
	    	
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't block p1's one");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING

    		//ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    		
    		//DON'T GET A TWO IN A LINE
    		//4 VERTICAL SPOTS
	    	if(boardDecision[0] == computer || boardDecision[4] == computer || boardDecision[8] == computer)
	    	{
	    		compDecision[0]=2;
	    		compDecision[4]=2;
	    		compDecision[8]=2;
	    	}
	    	
	    	if(boardDecision[1] == computer || boardDecision[5] == computer || boardDecision[9] == computer)
	    	{
	    		compDecision[1]=2;
	    		compDecision[5]=2;
	    		compDecision[9]=2;
	    	}
	    	
	    	if(boardDecision[2] == computer || boardDecision[6] == computer || boardDecision[10] == computer)
	    	{
	    		compDecision[2]=2;
	    		compDecision[6]=2;
	    		compDecision[10]=2;
	    	}
	    	
	    	if(boardDecision[3] == computer || boardDecision[7] == computer || boardDecision[11] == computer)
	    	{
	    		compDecision[3]=2;
	    		compDecision[7]=2;
	    		compDecision[11]=2;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if(boardDecision[0] == computer || boardDecision[1] == computer || boardDecision[2] == computer)
	    	{
	    		compDecision[0]=2;
	    		compDecision[1]=2;
	    		compDecision[2]=2;
	    	}
	    	
	    	if(boardDecision[1] == computer || boardDecision[2] == computer || boardDecision[3] == computer)
	    	{
	    		compDecision[1]=2;
	    		compDecision[2]=2;
	    		compDecision[3]=2;
	    	}
	    	
	    	if(boardDecision[4] == computer || boardDecision[5] == computer || boardDecision[6] == computer)
	    	{
	    		compDecision[4]=2;
	    		compDecision[5]=2;
	    		compDecision[6]=2;
	    	}
	    	
	    	if(boardDecision[5] == computer || boardDecision[6] == computer  || boardDecision[7] == computer)
	    	{
	    		compDecision[5]=2;
	    		compDecision[6]=2;
	    		compDecision[7]=2;
	    	}
	    	
	    	if(boardDecision[8] == computer || boardDecision[9] == computer  || boardDecision[10] == computer)
	    	{
	    		compDecision[8]=2;
	    		compDecision[9]=2;
	    		compDecision[10]=2;
	    	}
	    	
	    	if(boardDecision[9] == computer || boardDecision[10] == computer || boardDecision[11] == computer)
	    	{
	    		compDecision[9]=2;
	    		compDecision[10]=2;
	    		compDecision[11]=2;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if(boardDecision[0] == computer || boardDecision[5] == computer || boardDecision[10] == computer)
	    	{
	    		compDecision[0]=2;
	    		compDecision[5]=2;
	    		compDecision[10]=2;
	    	}
	    	
	    	if(boardDecision[1] == computer || boardDecision[6] == computer || boardDecision[11] == computer)
	    	{
	    		compDecision[1]=2;
	    		compDecision[6]=2;
	    		compDecision[11]=2;
	    	}
	    	
	    	if(boardDecision[2] == computer || boardDecision[5] == computer || boardDecision[8]== computer)
	    	{
	    		compDecision[2]=2;
	    		compDecision[5]=2;
	    		compDecision[8]=2;
	    	}
	   	
	    	if(boardDecision[3] == computer || boardDecision[6] == computer || boardDecision[9] == computer)
	    	{
	    		compDecision[3]=2;
	    		compDecision[6]=2;
	    		compDecision[9]=2;
	    	}
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't create 2 in a row");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    	}//END IF difficulty > 1
    		
//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    	
    	if(difficulty > 2)//IF DIFFICULTY IS HARD
    	{
    		//LOOKING FOR SPECIAL CASES #1 OXO
    		
	    	if(boardDecision[4] == player1  && (boardDecision[0] == computer|| boardDecision[8] == computer))
	    	{
	    		compDecision[0]=0;
	    		compDecision[4]=0;
	    		compDecision[8]=0;
	    	}
	    	/*NOT PART OF STRATEGY*
	    	if(boardDecision[5] == player1  && (boardDecision[1] == computer || boardDecision[9] == computer))
	    	{
	    		compDecision[1]=0;
	    		compDecision[5]=0;
	    		compDecision[9]=0;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[2] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[2]=0;
	    		compDecision[6]=0;
	    		compDecision[10]=0;
	    	}
	    	*/
	    	if(boardDecision[7] == player1 && (boardDecision[3] == computer  || boardDecision[11] == computer))
	    	{
	    		compDecision[3]=0;
	    		compDecision[7]=0;
	    		compDecision[11]=0;
	    	}
	    	
	    	/*6 HORIZONTAL SPOTS *NOT PART OF STRATEGY*
	    	if(boardDecision[1] == player1 && (boardDecision[0] == computer || boardDecision[2] == computer))
	    	{
	    		compDecision[0]=0;
	    		compDecision[1]=0;
	    		compDecision[2]=0;
	    	}
	    	
	    	if(boardDecision[2] == player1 && (boardDecision[1] == computer || boardDecision[3] == computer))
	    	{
	    		compDecision[1]=0;
	    		compDecision[2]=0;
	    		compDecision[3]=0;
	    	}
	    	
	    	if(boardDecision[5] == player1 && (boardDecision[4] == computer || boardDecision[6] == computer))
	    	{
	    		compDecision[4]=0;
	    		compDecision[5]=0;
	    		compDecision[6]=0;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[5]== computer || boardDecision[7] == computer))
	    	{
	    		compDecision[5]=0;
	    		compDecision[6]=0;
	    		compDecision[7]=0;
	    	}
	    	
	    	if(boardDecision[9] == player1 && (boardDecision[8] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[8]=0;
	    		compDecision[9]=0;
	    		compDecision[10]=0;
	    	}
	    	
	    	if(boardDecision[10] == player1 && (boardDecision[9] == computer || boardDecision[11] == computer))
	    	{
	    		compDecision[9]=0;
	    		compDecision[10]=0;
	    		compDecision[11]=0;
	    	}
	    	*/
	    	/*4 DIAGONAL SPOTS
	    	if(boardDecision[5] == player1 && (boardDecision[0] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[0]=0;
	    		compDecision[5]=0;
	    		compDecision[10]=0;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[1] == computer || boardDecision[11] == computer))
	    	{
	    		compDecision[1]=0;
	    		compDecision[6]=0;
	    		compDecision[11]=0;
	    	}
	    	
	    	if(boardDecision[5] == player1 && (boardDecision[2] == computer || boardDecision[8]== computer))
	    	{
	    		compDecision[2]=0;
	    		compDecision[5]=0;
	    		compDecision[8]=0;
	    	}
	   	
	    	if(boardDecision[6] == player1 && (boardDecision[3] == computer || boardDecision[9] == computer))
	    	{
	    		compDecision[3]=0;
	    		compDecision[6]=0;
	    		compDecision[9]=0;
	    	}
	    	*/
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't block p1's one");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
	    	
	    	//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
	    	
	    	//LOOKING FOR SPECIAL CASES #2 XOO
    		
	    	if((boardDecision[4] == computer  && (boardDecision[0] == player1|| boardDecision[8] == player1)) ||
	    		 ((boardDecision[0] == computer && boardDecision[8] == player1)||(boardDecision[8] == computer && boardDecision[0]==player1)))
	    	{
	    		compDecision[0]=0;
	    		compDecision[4]=0;
	    		compDecision[8]=0;
	    	}
	    	/*NOT PART OF STRATEGY*
	    	if((boardDecision[5] == computer  && (boardDecision[1] == player1 || boardDecision[9] == player1)) ||
	    		 ((boardDecision[1]==computer && boardDecision[9]==player1)||(boardDecision[9]==computer && boardDecision[1]==player1)))
	    	{
	    		compDecision[1]=0;
	    		compDecision[5]=0;
	    		compDecision[9]=0;
	    	}
	    	
	    	if((boardDecision[6] == computer && (boardDecision[2] == player1 || boardDecision[10] == player1)) ||
	    		 ((boardDecision[2]==computer && boardDecision[10]==player1)||(boardDecision[10]==computer && boardDecision[2]==player1)))
	    	{
	    		compDecision[2]=0;
	    		compDecision[6]=0;
	    		compDecision[10]=0;
	    	}
	    	*/
	    	if((boardDecision[7] == computer && (boardDecision[3] == player1  || boardDecision[11] == player1)) ||
	    		 ((boardDecision[3]==computer && boardDecision[11]==player1)||(boardDecision[11]==computer && boardDecision[3]==player1)))
	    	{
	    		compDecision[3]=0;
	    		compDecision[7]=0;
	    		compDecision[11]=0;
	    	}
	    	
	    	/*6 HORIZONTAL SPOTS*NOT PART OF STRATEGY*
	    	if((boardDecision[1] == computer && (boardDecision[0] == player1 || boardDecision[2] == player1)) ||
	    		 ((boardDecision[0]==computer && boardDecision[2]==player1)||(boardDecision[2]==computer && boardDecision[0]==player1)))
	    	{
	    		compDecision[0]=0;
	    		compDecision[1]=0;
	    		compDecision[2]=0;
	    	}
	    	
	    	if((boardDecision[2] == computer && (boardDecision[1] == player1 || boardDecision[3] == player1)) ||
	    		 ((boardDecision[1]==computer && boardDecision[3]==player1)||(boardDecision[3]==computer && boardDecision[1]==player1)))
	    	{
	    		compDecision[1]=0;
	    		compDecision[2]=0;
	    		compDecision[3]=0;
	    	}
	    	/*
	    	if((boardDecision[5] == computer && (boardDecision[4] == player1 || boardDecision[6] == player1)) ||
	    		 ((boardDecision[4]==computer && boardDecision[6]==player1)||(boardDecision[6]==computer && boardDecision[4]==player1)))
	    	{
	    		compDecision[4]=0;
	    		compDecision[5]=0;
	    		compDecision[6]=0;
	    	}
	    	
	    	if((boardDecision[6] == computer && (boardDecision[5]== player1 || boardDecision[7] == player1)) ||
	    		 ((boardDecision[5]==computer && boardDecision[7]==player1)||(boardDecision[7]==computer && boardDecision[5]==player1)))
	    	{
	    		compDecision[5]=0;
	    		compDecision[6]=0;
	    		compDecision[7]=0;
	    	}
	    	
	    	if((boardDecision[9] == computer && (boardDecision[8] == player1 || boardDecision[10] == player1)) ||
	    		 ((boardDecision[8]==computer && boardDecision[10]==player1)||(boardDecision[10]==computer && boardDecision[8]==player1)))
	    	{
	    		compDecision[8]=0;
	    		compDecision[9]=0;
	    		compDecision[10]=0;
	    	}
	    	
	    	if((boardDecision[10] == computer && (boardDecision[9] == player1 || boardDecision[11] == player1)) ||
	    		 ((boardDecision[9]==computer && boardDecision[11]==player1)||(boardDecision[11]==computer && boardDecision[9]==player1)))
	    	{
	    		compDecision[9]=0;
	    		compDecision[10]=0;
	    		compDecision[11]=0;
	    	}
	    	*/
	    	/*4 DIAGONAL SPOTS
	    	if(boardDecision[5] == player1 && (boardDecision[0] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[0]=0;
	    		compDecision[5]=0;
	    		compDecision[10]=0;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[1] == computer || boardDecision[11] == computer))
	    	{
	    		compDecision[1]=0;
	    		compDecision[6]=0;
	    		compDecision[11]=0;
	    	}
	    	
	    	if(boardDecision[5] == player1 && (boardDecision[2] == computer || boardDecision[8]== computer))
	    	{
	    		compDecision[2]=0;
	    		compDecision[5]=0;
	    		compDecision[8]=0;
	    	}
	   	
	    	if(boardDecision[6] == player1 && (boardDecision[3] == computer || boardDecision[9] == computer))
	    	{
	    		compDecision[3]=0;
	    		compDecision[6]=0;
	    		compDecision[9]=0;
	    	}
	    	*/
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't block p1's one");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
	    	
	    	//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    	}//END IF difficulty > 2
    	
    	if(difficulty > 1)
    	{
    		//DON'T BLOCK PLAYER1'S 2'S
    		//4 VERTICAL SPOTS
	    	if((boardDecision[0] == player1 && (boardDecision[4] == player1 || boardDecision[8] == player1)) || (boardDecision[4] == player1 && boardDecision[8] == player1))
	    	{
	    		compDecision[0]=3;
	    		compDecision[4]=3;
	    		compDecision[8]=3;
	    	}
	    	
	    	if((boardDecision[1] == player1 && (boardDecision[5] == player1 || boardDecision[9] == player1)) || (boardDecision[5] == player1 && boardDecision[9] == player1))
	    	{
	    		compDecision[1]=3;
	    		compDecision[5]=3;
	    		compDecision[9]=3;
	    	}	
	    	if((boardDecision[2] == player1 && (boardDecision[6] == player1 || boardDecision[10] == player1)) || (boardDecision[6] == player1 && boardDecision[10] == player1))
	    	{
	    		compDecision[2]=3;
	    		compDecision[6]=3;
	    		compDecision[10]=3;
	    	}

	    	if((boardDecision[3] == player1 && (boardDecision[7] == player1 || boardDecision[11] == player1)) || (boardDecision[7] == player1 && boardDecision[11] == player1))
	    	{
	    		compDecision[3]=3;
	    		compDecision[7]=3;
	    		compDecision[11]=3;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if((boardDecision[0] == player1 && (boardDecision[1] == player1 || boardDecision[2] == player1)) || (boardDecision[1] == player1 && boardDecision[2] == player1))
	    	{
	    		compDecision[0]=3;
	    		compDecision[1]=3;
	    		compDecision[2]=3;
	    	}
	    	
	    	if((boardDecision[1] == player1 && (boardDecision[2] == player1 || boardDecision[3] == player1)) || (boardDecision[2] == player1 && boardDecision[3] == player1))
	    	{
	    		compDecision[1]=3;
	    		compDecision[2]=3;
	    		compDecision[3]=3;
	    	}
	    	
	    	if((boardDecision[4] == player1 && (boardDecision[5] == player1 || boardDecision[6] == player1)) || (boardDecision[5] == player1 && boardDecision[6] == player1))
	    	{
	    		compDecision[4]=3;
	    		compDecision[5]=3;
	    		compDecision[6]=3;
	    	}
	    	
	    	if((boardDecision[5] == player1 && (boardDecision[6] == player1 || boardDecision[7] == player1)) || (boardDecision[6] == player1 && boardDecision[7] == player1))
	    	{
	    		compDecision[5]=3;
	    		compDecision[6]=3;
	    		compDecision[7]=3;
	    	}
	    	
	    	if((boardDecision[8] == player1 && (boardDecision[9] == player1 || boardDecision[10] == player1)) || (boardDecision[9] == player1 && boardDecision[10] == player1))
	    	{
	    		compDecision[8]=3;
	    		compDecision[9]=3;
	    		compDecision[10]=3;
	    	}
	    	
	    	if((boardDecision[9] == player1 && (boardDecision[10] == player1 || boardDecision[11] == player1)) || (boardDecision[10] == player1 && boardDecision[11] == player1))
	    	{
	    		compDecision[9]=3;
	    		compDecision[10]=3;
	    		compDecision[11]=3;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if((boardDecision[0] == player1 && (boardDecision[5] == player1 || boardDecision[10] == player1)) || (boardDecision[5] == player1 && boardDecision[10] == player1))
	    	{
	    		compDecision[0]=3;
	    		compDecision[5]=3;
	    		compDecision[10]=3;
	    	}
	    	
	    	if((boardDecision[1] == player1 && (boardDecision[6] == player1 || boardDecision[11] == player1)) || (boardDecision[6] == player1 && boardDecision[11] == player1))
	    	{
	    		compDecision[1]=3;
	    		compDecision[6]=3;
	    		compDecision[11]=3;
	    	}
	    	
	    	if((boardDecision[2] == player1 && (boardDecision[5] == player1 || boardDecision[8] == player1)) || (boardDecision[5] == player1 && boardDecision[8] == player1))
	    	{
	    		compDecision[2]=3;
	    		compDecision[5]=3;
	    		compDecision[8]=3;
	    	}
	   	
	    	if((boardDecision[3] == player1 && (boardDecision[6] == player1 || boardDecision[9] == player1)) || (boardDecision[6] == player1 && boardDecision[9] == player1))
	    	{
	    		compDecision[3]=3;
	    		compDecision[6]=3;
	    		compDecision[9]=3;
	    	}
    		
    		if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't block p1's two in a row");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    }//END IF		
    		//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    		
    		//DON'T FORM A 3
    		//4 VERTICAL SPOTS
	    	if((boardDecision[0] == computer && (boardDecision[4] == computer && boardDecision[8] == computer)) || (boardDecision[4] == computer && boardDecision[8] == computer))
	    	{
	    		compDecision[0]=4;
	    		compDecision[4]=4;
	    		compDecision[8]=4;
	    	}
	    	
	    	if((boardDecision[1] == computer && (boardDecision[5] == computer || boardDecision[9] == computer)) || (boardDecision[5] == computer && boardDecision[9] == computer))
	    	{
	    		compDecision[1]=4;
	    		compDecision[5]=4;
	    		compDecision[9]=4;
	    	}
	    	
	    	if((boardDecision[2] == computer && (boardDecision[6] == computer || boardDecision[10] == computer)) || (boardDecision[6] == computer && boardDecision[10] == computer))
	    	{
	    		compDecision[2]=4;
	    		compDecision[6]=4;
	    		compDecision[10]=4;
	    	}
	    	
	    	if((boardDecision[3] == computer && (boardDecision[7] == computer || boardDecision[11] == computer)) || (boardDecision[7] == computer && boardDecision[11] == computer))
	    	{
	    		compDecision[3]=4;
	    		compDecision[7]=4;
	    		compDecision[11]=4;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if((boardDecision[0] == computer && (boardDecision[1] == computer || boardDecision[2] == computer)) || (boardDecision[1] == computer && boardDecision[2] == computer))
	    	{
	    		compDecision[0]=4;
	    		compDecision[1]=4;
	    		compDecision[2]=4;
	    	}
	    	
	    	if((boardDecision[1] == computer && (boardDecision[2] == computer || boardDecision[3] == computer)) || (boardDecision[2] == computer && boardDecision[3] == computer))
	    	{
	    		compDecision[1]=4;
	    		compDecision[2]=4;
	    		compDecision[3]=4;
	    	}
	    	
	    	if((boardDecision[4] == computer && (boardDecision[5] == computer || boardDecision[6] == computer)) || (boardDecision[5] == computer && boardDecision[6] == computer))
	    	{
	    		compDecision[4]=4;
	    		compDecision[5]=4;
	    		compDecision[6]=4;
	    	}
	    	
	    	if((boardDecision[5] == computer && (boardDecision[6] == computer || boardDecision[7] == computer)) || (boardDecision[6] == computer && boardDecision[7] == computer))
	    	{
	    		compDecision[5]=4;
	    		compDecision[6]=4;
	    		compDecision[7]=4;
	    	}
	    	
	    	if((boardDecision[8] == computer && (boardDecision[9] == computer || boardDecision[10] == computer)) || (boardDecision[9] == computer && boardDecision[10] == computer))
	    	{
	    		compDecision[8]=4;
	    		compDecision[9]=4;
	    		compDecision[10]=4;
	    	}
	    	
	    	if((boardDecision[9] == computer && (boardDecision[10] == computer || boardDecision[11] == computer)) || (boardDecision[10] == computer && boardDecision[11] == computer))
	    	{
	    		compDecision[9]=4;
	    		compDecision[10]=4;
	    		compDecision[11]=4;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if((boardDecision[0] == computer && (boardDecision[5] == computer || boardDecision[10] == computer)) || (boardDecision[5] == computer && boardDecision[10] == computer))
	    	{
	    		compDecision[0]=4;
	    		compDecision[5]=4;
	    		compDecision[10]=4;
	    	}
	    	
	    	if((boardDecision[1] == computer && (boardDecision[6] == computer || boardDecision[11] == computer)) || (boardDecision[6] == computer && boardDecision[11] == computer))
	    	{
	    		compDecision[1]=4;
	    		compDecision[6]=4;
	    		compDecision[11]=4;
	    	}
	    	
	    	if((boardDecision[2] == computer && (boardDecision[5] == computer || boardDecision[8] == computer)) || (boardDecision[5] == computer && boardDecision[8] == computer))
	    	{
	    		compDecision[2]=4;
	    		compDecision[5]=4;
	    		compDecision[8]=4;
	    	}
	   	
	    	if((boardDecision[3] == computer && (boardDecision[6] == computer || boardDecision[9] == computer)) || (boardDecision[6] == computer && boardDecision[9] == computer))
	    	{
	    		compDecision[3]=4;
	    		compDecision[6]=4;
	    		compDecision[9]=4;
	    	}
    		
    		if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't create three in a row");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    		
    		//SET TAKEN SPOTS TO 5
    		for(int num = 0; num < 12; num++)
    		{
    			if(boardDecision[num] > 0) compDecision[num] = 5;
    		}
    		
    		if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't choose spots that are taken");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    		
	    	//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
	    	
    		//SETTING THE RANDOM NUMBERS TO DESIRED SPOT NUMBERS
    		for(int num = 0; num < 12; num++)
    		{
	    			if(compDecision[num] == 0 )
	    			{
	    				random[number] = num+1;
	    				number++;
	    			}	
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 1 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 2 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 3 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 4 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(tracing)
			{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
				System.out.println("my choices");
				for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(random[num]+", ");
	    		}
	    		System.out.println("");
	    		System.out.println("");
			}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
			
			//PICKING RANDOM NUMBER
    		number =(int)(number*Math.random()+1);
    		
    		//SETTING CHOICE TO THE PICKED RANDOM NUMBER	
    		if(number == 12)
    		{
    			choice = random[11];
    		}
    		
    		if(number == 11)
    		{
    			choice = random[10];
    		}
    		
    		if(number == 10)
    		{
    			choice = random[9];
    		}
    		
    		if(number == 9)
    		{
    			choice = random[8];
    		}
    		
    		if(number == 8)
    		{
    			choice = random[7];
    		}
    		
    		if(number == 7)
    		{
    			choice = random[6];
    		}
    		
    		if(number == 6)
    		{
    			choice = random[5];
    		}
    		
    		if(number == 5)
    		{
    			choice = random[4];
    		}
    		
    		if(number == 4)
    		{
    			choice = random[3];
    		}
    		
    		if(number == 3)
    		{
    			choice = random[2];
    		}
    		
    		if(number == 2)
    		{
    			choice = random[1];
    		}
    		
    		if(number == 1)
    		{
    			choice = random[0];
    		}

   			//SETTING SPOTS BASED ON THE CHOICE
	    	if(choice == 1)
	    	{ 
	    		y = 3;
	    		x = 7;
	    	}
	    	
	    	if(choice == 2)
	    	{
	    		y = 3;
	    		x = 22;
	    	}
	    	
	    	if(choice == 3)
	    	{
	    		y = 3;
	    		x = 38;
	    	}
	    	
	    	if(choice == 4)
	    	{
	    		y = 3;
	    		x = 54;
	    	}
		
	    	if(choice == 5)
	    	{
	    		y = 11;
	    		x = 7;
	    	}
	    	
	    	if(choice == 6)
	    	{
	    		y = 11;
	    		x = 22;
	    	}
	    	
	    	if(choice == 7)
	    	{
	    		y = 11;
	    		x = 38;
	    	}
	    	
	    	if(choice ==8)
	    	{
	    		y = 11;
	    		x = 54;
	    	}
	    	
	    	if(choice == 9)
	    	{
	    		y = 19;
	    		x = 7;
	    	}
	    	
	    	if(choice == 10)
	    	{
	    		y = 19;
	    		x = 22;
	    		boardDisplay[17][19] = ' ';
	    	}
	    	
	    	if(choice == 11)
	    	{
	    		y = 19;
	    		x = 38;	    	
    			boardDisplay[17][35] = ' ';
	    	}
	    	
	    	if(choice == 12)
	    	{
	    		y = 19;
	    		x = 54;
	    		boardDisplay[17][51] = ' ';
	    	}
	
		if(!tracing)//IMPRESSION OF COMPUTER THINKING
    		{
    			System.out.print("computer is thinking");
    			time();
				System.out.print(".");
    			time();
    			System.out.print(".");
    			time();
    			System.out.print(".");
    			time();
    		}
		
    	if(turn % 2 == 1) 	//DISPLAY O IF IT'S AN ODD TURN
    	{
			boardDecision[choice - 1] =	1;//SETTING THE VALUE OF ARRAY TO THE CHOSEN SPOT
			
	    	boardDisplay[y][x+6] = 'o';
	    	boardDisplay[y][x-6] = 'o';
	    	
	    	boardDisplay[y+1][x-6] = 'o';
	    	boardDisplay[y-1][x-6] = 'o';
	    	
	    	boardDisplay[y+2][x-5] = 'o';
	    	boardDisplay[y-2][x-5] = 'o';
	    	
	    	boardDisplay[y+2][x-4] = 'o';
	    	boardDisplay[y-2][x-4] = 'O';
	    	
	    	boardDisplay[y+3][x-3] = 'O';
	    	boardDisplay[y-3][x-3] = 'o';
	    	
	    	boardDisplay[y+3][x-2] = 'o';
	    	boardDisplay[y-3][x-2] = 'o';
	    	
	    	boardDisplay[y+3][x-1] = 'o';
	    	boardDisplay[y-3][x-1] = 'o';
	    	
	    	boardDisplay[y+3][x] = 'o';
	    	boardDisplay[y-3][x] = 'o';
	    	
	    	boardDisplay[y+1][x+6] = 'o';
	    	boardDisplay[y-1][x+6] = 'o';
	    	
	    	boardDisplay[y+2][x+5] = 'o';
	    	boardDisplay[y-2][x+5] = 'o';
	    	
	    	boardDisplay[y+2][x+4] = 'o';
	    	boardDisplay[y-2][x+4] = 'O';
	    	
	    	boardDisplay[y+3][x+3] = 'O';
	    	boardDisplay[y-3][x+3] = 'o';
	    	
	    	boardDisplay[y+3][x+2] = 'o';
	    	boardDisplay[y-3][x+2] = 'o';
	    	
	    	boardDisplay[y+3][x+1] = 'o';
	    	boardDisplay[y-3][x+1] = 'o';
	    	
    	}
    	else if(turn % 2 == 0)	//DISPLAY X IF IT'S AN EVEN TURN
    	{
    		boardDecision[choice - 1] =	2;//SETTING THE VALUE OF ARRAY TO THE CHOSEN SPOT
    		
    	  	//X display
	    	boardDisplay[y][x] = 'x';
	    	
	    	boardDisplay[y+1][x-2] = 'x';
	    	boardDisplay[y+2][x-4] = 'x';
	    	boardDisplay[y+3][x-6] = 'x';
	    	
	    	boardDisplay[y+1][x+2] = 'x';
	    	boardDisplay[y+2][x+4] = 'x';
	    	boardDisplay[y+3][x+6] = 'x';
	    	
	    	boardDisplay[y-1][x-2] = 'x';
	    	boardDisplay[y-2][x-4] = 'x';
	    	boardDisplay[y-3][x-6] = 'x';
	    	
	    	boardDisplay[y-1][x+2] = 'x';
	    	boardDisplay[y-2][x+4] = 'x';
	    	boardDisplay[y-3][x+6] = 'x';
    	}
    	
    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(boardDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		br.readLine();
	    	}
    }//END computerMove()
 	
 	//METHOD FOR COMPUTER MAKING A MOVE SECOND STRATEGY(ONLY FOR TESTING)
    static void computerMove2(BufferedReader br, char[][] boardDisplay, int[] boardDecision, int turn, int p1Win, int computerWin, int tie, int player1, int computer, int mode)throws Exception {
    	
    	//DECLARING VARIABLES
    	int x = 0;
    	int y = 0;

    	boolean tracing = false;
    	int test = 0;
    	int choice = 0;
    	int number = 0;
    	boolean valid = false;
    	int[] compDecision = new int[12];
    	int[] random = new int[12];
    	
    	if(turn<12)
    	{
    	
			//LOOKING FOR SPOTS NOT BESIDE PLAYER1
    		//4 vertical spots
    		if(turn < 3 )
    		{
	    	if(boardDecision[0] == player1 || boardDecision[4] == player1 || boardDecision[8] == player1)
	    	{
	    		compDecision[0]+=1;
	    		compDecision[4]+=1;
	    		compDecision[8]+=1;
	    	}
	    	
	    	if(boardDecision[1] == player1 || boardDecision[5] == player1 || boardDecision[9] == player1)
	    	{
	    		compDecision[1]+=1;
	    		compDecision[5]+=1;
	    		compDecision[9]+=1;
	    	}
	    	
	    	if(boardDecision[2] == player1 || boardDecision[6] == player1 || boardDecision[10] == player1)
	    	{
	    		compDecision[2]+=1;
	    		compDecision[6]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if(boardDecision[3] == player1 || boardDecision[7] == player1 || boardDecision[11] == player1)
	    	{
	    		compDecision[3]+=1;
	    		compDecision[7]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if(boardDecision[0] == player1 || boardDecision[1] == player1 || boardDecision[2] == player1)
	    	{
	    		compDecision[0]+=1;
	    		compDecision[1]+=1;
	    		compDecision[2]+=1;
	    	}
	    	
	    	if(boardDecision[1] == player1 || boardDecision[2] == player1 || boardDecision[3] == player1)
	    	{
	    		compDecision[1]+=1;
	    		compDecision[2]+=1;
	    		compDecision[3]+=1;
	    	}
	    	
	    	if(boardDecision[4] == player1 || boardDecision[5] == player1 || boardDecision[6] == player1)
	    	{
	    		compDecision[4]+=1;
	    		compDecision[5]+=1;
	    		compDecision[6]+=1;
	    	}
	    	
	    	if(boardDecision[5] == player1 || boardDecision[6] == player1  || boardDecision[7] == player1)
	    	{
	    		compDecision[5]+=1;
	    		compDecision[6]+=1;
	    		compDecision[7]+=1;
	    	}
	    	
	    	if(boardDecision[8] == player1 || boardDecision[9] == player1  || boardDecision[10] == player1)
	    	{
	    		compDecision[8]+=1;
	    		compDecision[9]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if(boardDecision[9] == player1 || boardDecision[10] == player1 || boardDecision[11] == player1)
	    	{
	    		compDecision[9]+=1;
	    		compDecision[10]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if(boardDecision[0] == player1 || boardDecision[5] == player1 || boardDecision[10] == player1)
	    	{
	    		compDecision[0]+=1;
	    		compDecision[5]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if(boardDecision[1] == player1 || boardDecision[6] == player1 || boardDecision[11] == player1)
	    	{
	    		compDecision[1]+=1;
	    		compDecision[6]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	if(boardDecision[2] == player1 || boardDecision[5] == player1 || boardDecision[8]== player1)
	    	{
	    		compDecision[2]+=1;
	    		compDecision[5]+=1;
	    		compDecision[8]+=1;
	    	}
	   	
	    	if(boardDecision[3] == player1 || boardDecision[6] == player1 || boardDecision[9] == player1)
	    	{
	    		compDecision[3]+=1;
	    		compDecision[6]+=1;
	    		compDecision[9]+=1;
	    	}
	    	
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't block p1's one");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]+",");
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    		}//end big if
    		//ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    		
    		//DON'T GET A TWO IN A LINE
    		//4 VERTICAL SPOTS

	    	if(boardDecision[0] == computer || boardDecision[4] == computer || boardDecision[8] == computer)
	    	{
	    		compDecision[0]+=1;
	    		compDecision[4]+=1;
	    		compDecision[8]+=1;
	    	}
	    	
	    	if(boardDecision[1] == computer || boardDecision[5] == computer || boardDecision[9] == computer)
	    	{
	    		compDecision[1]+=1;
	    		compDecision[5]+=1;
	    		compDecision[9]+=1;
	    	}
	    	
	    	if(boardDecision[2] == computer || boardDecision[6] == computer || boardDecision[10] == computer)
	    	{
	    		compDecision[2]+=1;
	    		compDecision[6]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if(boardDecision[3] == computer || boardDecision[7] == computer || boardDecision[11] == computer)
	    	{
	    		compDecision[3]+=1;
	    		compDecision[7]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if(boardDecision[0] == computer || boardDecision[1] == computer || boardDecision[2] == computer)
	    	{
	    		compDecision[0]+=1;
	    		compDecision[1]+=1;
	    		compDecision[2]+=1;
	    	}
	    	
	    	if(boardDecision[1] == computer || boardDecision[2] == computer || boardDecision[3] == computer)
	    	{
	    		compDecision[1]+=1;
	    		compDecision[2]+=1;
	    		compDecision[3]+=1;
	    	}
	    	
	    	if(boardDecision[4] == computer || boardDecision[5] == computer || boardDecision[6] == computer)
	    	{
	    		compDecision[4]+=1;
	    		compDecision[5]+=1;
	    		compDecision[6]+=1;
	    	}
	    	
	    	if(boardDecision[5] == computer || boardDecision[6] == computer  || boardDecision[7] == computer)
	    	{
	    		compDecision[5]+=1;
	    		compDecision[6]+=1;
	    		compDecision[7]+=1;
	    	}
	    	
	    	if(boardDecision[8] == computer || boardDecision[9] == computer  || boardDecision[10] == computer)
	    	{
	    		compDecision[8]+=1;
	    		compDecision[9]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if(boardDecision[9] == computer || boardDecision[10] == computer || boardDecision[11] == computer)
	    	{
	    		compDecision[9]+=1;
	    		compDecision[10]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if(boardDecision[0] == computer || boardDecision[5] == computer || boardDecision[10] == computer)
	    	{
	    		compDecision[0]+=1;
	    		compDecision[5]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if(boardDecision[1] == computer || boardDecision[6] == computer || boardDecision[11] == computer)
	    	{
	    		compDecision[1]+=1;
	    		compDecision[6]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	if(boardDecision[2] == computer || boardDecision[5] == computer || boardDecision[8]== computer)
	    	{
	    		compDecision[2]+=1;
	    		compDecision[5]+=1;
	    		compDecision[8]+=1;
	    	}
	   	
	    	if(boardDecision[3] == computer || boardDecision[6] == computer || boardDecision[9] == computer)
	    	{
	    		compDecision[3]+=1;
	    		compDecision[6]+=1;
	    		compDecision[9]+=1;
	    	}
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't create 2 in a row");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]+",");
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    	}
    		//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    		
    		//LOOKING FOR SPECIAL CASES #1 OXO
    		
	    	if(boardDecision[4] == player1  && (boardDecision[0] == computer|| boardDecision[8] == computer))
	    	{
	    		compDecision[0]-=2;
	    		compDecision[4]-=2;
	    		compDecision[8]-=2;
	    	}
	    	
	    	if(boardDecision[5] == player1  && (boardDecision[1] == computer || boardDecision[9] == computer))
	    	{
	    		compDecision[1]-=2;
	    		compDecision[5]-=2;
	    		compDecision[9]-=2;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[2] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[2]-=2;
	    		compDecision[6]-=2;
	    		compDecision[10]-=2;
	    	}
	    	
	    	if(boardDecision[7] == player1 && (boardDecision[3] == computer  || boardDecision[11] == computer))
	    	{
	    		compDecision[3]-=2;
	    		compDecision[7]-=2;
	    		compDecision[11]-=2;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if(boardDecision[1] == player1 && (boardDecision[0] == computer || boardDecision[2] == computer))
	    	{
	    		compDecision[0]-=2;
	    		compDecision[1]-=2;
	    		compDecision[2]-=2;
	    	}
	    	
	    	if(boardDecision[2] == player1 && (boardDecision[1] == computer || boardDecision[3] == computer))
	    	{
	    		compDecision[1]-=2;
	    		compDecision[2]-=2;
	    		compDecision[3]-=2;
	    	}

	    	if(boardDecision[5] == player1 && (boardDecision[4] == computer || boardDecision[6] == computer))
	    	{
	    		compDecision[4]-=2;
	    		compDecision[5]-=2;
	    		compDecision[6]-=2;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[5]== computer || boardDecision[7] == computer))
	    	{
	    		compDecision[5]-=2;
	    		compDecision[6]-=2;
	    		compDecision[7]-=2;
	    	}

	    	if(boardDecision[9] == player1 && (boardDecision[8] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[8]-=2;
	    		compDecision[9]-=2;
	    		compDecision[10]-=2;
	    	}
	    	
	    	if(boardDecision[10] == player1 && (boardDecision[9] == computer || boardDecision[11] == computer))
	    	{
	    		compDecision[9]-=2;
	    		compDecision[10]-=2;
	    		compDecision[11]-=2;
	    	}
	    	/*
	    	//4 DIAGONAL SPOTS
	    	if(boardDecision[5] == player1 && (boardDecision[0] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[0]-=2;
	    		compDecision[5]-=2;
	    		compDecision[10]-=2;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[1] == computer || boardDecision[11] == computer))
	    	{
	    		compDecision[1]-=2;
	    		compDecision[6]-=2;
	    		compDecision[11]-=2;
	    	}
	    	
	    	if(boardDecision[5] == player1 && (boardDecision[2] == computer || boardDecision[8]== computer))
	    	{
	    		compDecision[2]-=2;
	    		compDecision[5]-=2;
	    		compDecision[8]-=2;
	    	}
	   	
	    	if(boardDecision[6] == player1 && (boardDecision[3] == computer || boardDecision[9] == computer))
	    	{
	    		compDecision[3]-=2;
	    		compDecision[6]-=2;
	    		compDecision[9]-=2;
	    	}
	    	*/
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("special case oxo");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]+",");
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
	    	
	    	//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
	    	
	    	//LOOKING FOR SPECIAL CASES #2 XOO
    		
	    	if((boardDecision[4] == computer  && (boardDecision[0] == player1|| boardDecision[8] == player1)) ||
	    		 ((boardDecision[0] == computer && boardDecision[8] == player1)||(boardDecision[8] == computer && boardDecision[0]==player1)))
	    	{
	    		compDecision[0]-=2;
	    		compDecision[4]-=2;
	    		compDecision[8]-=2;
	    	}
	    	
	    	if((boardDecision[5] == computer  && (boardDecision[1] == player1 || boardDecision[9] == player1)) ||
	    		 ((boardDecision[1]==computer && boardDecision[9]==player1)||(boardDecision[9]==computer && boardDecision[1]==player1)))
	    	{
	    		compDecision[1]-=2;
	    		compDecision[5]-=2;
	    		compDecision[9]-=2;
	    	}
	    	
	    	if((boardDecision[6] == computer && (boardDecision[2] == player1 || boardDecision[10] == player1)) ||
	    		 ((boardDecision[2]==computer && boardDecision[10]==player1)||(boardDecision[10]==computer && boardDecision[2]==player1)))
	    	{
	    		compDecision[2]-=2;
	    		compDecision[6]-=2;
	    		compDecision[10]-=2;
	    	}
	    	
	    	if((boardDecision[7] == computer && (boardDecision[3] == player1  || boardDecision[11] == player1)) ||
	    		 ((boardDecision[3]==computer && boardDecision[11]==player1)||(boardDecision[11]==computer && boardDecision[3]==player1)))
	    	{
	    		compDecision[3]-=2;
	    		compDecision[7]-=2;
	    		compDecision[11]-=2;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if((boardDecision[1] == computer && (boardDecision[0] == player1 || boardDecision[2] == player1)) ||
	    		 ((boardDecision[0]==computer && boardDecision[2]==player1)||(boardDecision[2]==computer && boardDecision[0]==player1)))
	    	{
	    		compDecision[0]-=2;
	    		compDecision[1]-=2;
	    		compDecision[2]-=2;
	    	}
	    	
	    	if((boardDecision[2] == computer && (boardDecision[1] == player1 || boardDecision[3] == player1)) ||
	    		 ((boardDecision[1]==computer && boardDecision[3]==player1)||(boardDecision[3]==computer && boardDecision[1]==player1)))
	    	{
	    		compDecision[1]-=2;
	    		compDecision[2]-=2;
	    		compDecision[3]-=2;
	    	}
	    	
	    	if((boardDecision[5] == computer && (boardDecision[4] == player1 || boardDecision[6] == player1)) ||
	    		 ((boardDecision[4]==computer && boardDecision[6]==player1)||(boardDecision[6]==computer && boardDecision[4]==player1)))
	    	{
	    		compDecision[4]-=2;
	    		compDecision[5]-=2;
	    		compDecision[6]-=2;
	    	}
	    	
	    	if((boardDecision[6] == computer && (boardDecision[5]== player1 || boardDecision[7] == player1)) ||
	    		 ((boardDecision[5]==computer && boardDecision[7]==player1)||(boardDecision[7]==computer && boardDecision[5]==player1)))
	    	{
	    		compDecision[5]-=2;
	    		compDecision[6]-=2;
	    		compDecision[7]-=2;
	    	}
	    	
	    	if((boardDecision[9] == computer && (boardDecision[8] == player1 || boardDecision[10] == player1)) ||
	    		 ((boardDecision[8]==computer && boardDecision[10]==player1)||(boardDecision[10]==computer && boardDecision[8]==player1)))
	    	{
	    		compDecision[8]-=2;
	    		compDecision[9]-=2;
	    		compDecision[10]-=2;
	    	}
	    	
	    	if((boardDecision[10] == computer && (boardDecision[9] == player1 || boardDecision[11] == player1)) ||
	    		 ((boardDecision[9]==computer && boardDecision[11]==player1)||(boardDecision[11]==computer && boardDecision[9]==player1)))
	    	{
	    		compDecision[9]-=2;
	    		compDecision[10]-=2;
	    		compDecision[11]-=2;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if(boardDecision[5] == player1 && (boardDecision[0] == computer || boardDecision[10] == computer))
	    	{
	    		compDecision[0]-=2;
	    		compDecision[5]-=2;
	    		compDecision[10]-=2;
	    	}
	    	
	    	if(boardDecision[6] == player1 && (boardDecision[1] == computer || boardDecision[11] == computer))
	    	{
	    		compDecision[1]-=2;
	    		compDecision[6]-=2;
	    		compDecision[11]-=2;
	    	}
	    	
	    	if(boardDecision[5] == player1 && (boardDecision[2] == computer || boardDecision[8]== computer))
	    	{
	    		compDecision[2]-=2;
	    		compDecision[5]-=2;
	    		compDecision[8]-=2;
	    	}
	   	
	    	if(boardDecision[6] == player1 && (boardDecision[3] == computer || boardDecision[9] == computer))
	    	{
	    		compDecision[3]-=2;
	    		compDecision[6]-=2;
	    		compDecision[9]-=2;
	    	}
	    
	    	
	    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("special case 2 xoo");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]+",");
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
	    	
	    	//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    		
    		//DON'T BLOCK PLAYER1'S 2'S
    		//4 VERTICAL SPOTS
	    	if((boardDecision[0] == player1 && (boardDecision[4] == player1 || boardDecision[8] == player1)) || (boardDecision[4] == player1 && boardDecision[8] == player1))
	    	{
	    		compDecision[0]+=1;
	    		compDecision[4]+=1;
	    		compDecision[8]+=1;
	    	}
	    	
	    	if((boardDecision[1] == player1 && (boardDecision[5] == player1 || boardDecision[9] == player1)) || (boardDecision[5] == player1 && boardDecision[9] == player1))
	    	{
	    		compDecision[1]+=1;
	    		compDecision[5]+=1;
	    		compDecision[9]+=1;
	    	}
	    		
	    	if((boardDecision[2] == player1 && (boardDecision[6] == player1 || boardDecision[10] == player1)) || (boardDecision[6] == player1 && boardDecision[10] == player1))
	    	{
	    		compDecision[2]+=1;
	    		compDecision[6]+=1;
	    		compDecision[10]+=1;
	    	}

	    	if((boardDecision[3] == player1 && (boardDecision[7] == player1 || boardDecision[11] == player1)) || (boardDecision[7] == player1 && boardDecision[11] == player1))
	    	{
	    		compDecision[3]+=1;
	    		compDecision[7]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if((boardDecision[0] == player1 && (boardDecision[1] == player1 || boardDecision[2] == player1)) || (boardDecision[1] == player1 && boardDecision[2] == player1))
	    	{
	    		compDecision[0]+=1;
	    		compDecision[1]+=1;
	    		compDecision[2]+=1;
	    	}
	    	
	    	if((boardDecision[1] == player1 && (boardDecision[2] == player1 || boardDecision[3] == player1)) || (boardDecision[2] == player1 && boardDecision[3] == player1))
	    	{
	    		compDecision[1]+=1;
	    		compDecision[2]+=1;
	    		compDecision[3]+=1;
	    	}
	    	
	    	if((boardDecision[4] == player1 && (boardDecision[5] == player1 || boardDecision[6] == player1)) || (boardDecision[5] == player1 && boardDecision[6] == player1))
	    	{
	    		compDecision[4]+=1;
	    		compDecision[5]+=1;
	    		compDecision[6]+=1;
	    	}
	    	
	    	if((boardDecision[5] == player1 && (boardDecision[6] == player1 || boardDecision[7] == player1)) || (boardDecision[6] == player1 && boardDecision[7] == player1))
	    	{
	    		compDecision[5]+=1;
	    		compDecision[6]+=1;
	    		compDecision[7]+=1;
	    	}
	    	
	    	if((boardDecision[8] == player1 && (boardDecision[9] == player1 || boardDecision[10] == player1)) || (boardDecision[9] == player1 && boardDecision[10] == player1))
	    	{
	    		compDecision[8]+=1;
	    		compDecision[9]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if((boardDecision[9] == player1 && (boardDecision[10] == player1 || boardDecision[11] == player1)) || (boardDecision[10] == player1 && boardDecision[11] == player1))
	    	{
	    		compDecision[9]+=1;
	    		compDecision[10]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if((boardDecision[0] == player1 && (boardDecision[5] == player1 || boardDecision[10] == player1)) || (boardDecision[5] == player1 && boardDecision[10] == player1))
	    	{
	    		compDecision[0]+=1;
	    		compDecision[5]+=1;
	    		compDecision[10]+=1;
	    	}
	    	
	    	if((boardDecision[1] == player1 && (boardDecision[6] == player1 || boardDecision[11] == player1)) || (boardDecision[6] == player1 && boardDecision[11] == player1))
	    	{
	    		compDecision[1]+=1;
	    		compDecision[6]+=1;
	    		compDecision[11]+=1;
	    	}
	    	
	    	if((boardDecision[2] == player1 && (boardDecision[5] == player1 || boardDecision[8] == player1)) || (boardDecision[5] == player1 && boardDecision[8] == player1))
	    	{
	    		compDecision[2]+=1;
	    		compDecision[5]+=1;
	    		compDecision[8]+=1;
	    	}
	   	
	    	if((boardDecision[3] == player1 && (boardDecision[6] == player1 || boardDecision[9] == player1)) || (boardDecision[6] == player1 && boardDecision[9] == player1))
	    	{
	    		compDecision[3]+=1;
	    		compDecision[6]+=1;
	    		compDecision[9]+=1;
	    	}
    		
    		if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't block p1's two in a row");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]+",");
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    		
    		//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    		
    		//DON'T BLOCK PLAYER1'S 2'S
    		//4 VERTICAL SPOTS
	    	if((boardDecision[0] == computer && (boardDecision[4] == computer && boardDecision[8] == computer)) || (boardDecision[4] == computer && boardDecision[8] == computer))
	    	{
	    		compDecision[0]+=2;
	    		compDecision[4]+=2;
	    		compDecision[8]+=2;
	    	}
	    	
	    	if((boardDecision[1] == computer && (boardDecision[5] == computer || boardDecision[9] == computer)) || (boardDecision[5] == computer && boardDecision[9] == computer))
	    	{
	    		compDecision[1]+=2;
	    		compDecision[5]+=2;
	    		compDecision[9]+=2;
	    	}
	    	
	    	if((boardDecision[2] == computer && (boardDecision[6] == computer || boardDecision[10] == computer)) || (boardDecision[6] == computer && boardDecision[10] == computer))
	    	{
	    		compDecision[2]+=2;
	    		compDecision[6]+=2;
	    		compDecision[10]+=2;
	    	}
	    	
	    	if((boardDecision[3] == computer && (boardDecision[7] == computer || boardDecision[11] == computer)) || (boardDecision[7] == computer && boardDecision[11] == computer))
	    	{
	    		compDecision[3]+=2;
	    		compDecision[7]+=2;
	    		compDecision[11]+=2;
	    	}
	    	
	    	//6 HORIZONTAL SPOTS
	    	if((boardDecision[0] == computer && (boardDecision[1] == computer || boardDecision[2] == computer)) || (boardDecision[1] == computer && boardDecision[2] == computer))
	    	{
	    		compDecision[0]+=2;
	    		compDecision[1]+=2;
	    		compDecision[2]+=2;
	    	}
	    	
	    	if((boardDecision[1] == computer && (boardDecision[2] == computer || boardDecision[3] == computer)) || (boardDecision[2] == computer && boardDecision[3] == computer))
	    	{
	    		compDecision[1]+=2;
	    		compDecision[2]+=2;
	    		compDecision[3]+=2;
	    	}
	    	
	    	if((boardDecision[4] == computer && (boardDecision[5] == computer || boardDecision[6] == computer)) || (boardDecision[5] == computer && boardDecision[6] == computer))
	    	{
	    		compDecision[4]+=2;
	    		compDecision[5]+=2;
	    		compDecision[6]+=2;
	    	}
	    	
	    	if((boardDecision[5] == computer && (boardDecision[6] == computer || boardDecision[7] == computer)) || (boardDecision[6] == computer && boardDecision[7] == computer))
	    	{
	    		compDecision[5]+=2;
	    		compDecision[6]+=2;
	    		compDecision[7]+=2;
	    	}
	    	
	    	if((boardDecision[8] == computer && (boardDecision[9] == computer || boardDecision[10] == computer)) || (boardDecision[9] == computer && boardDecision[10] == computer))
	    	{
	    		compDecision[8]+=2;
	    		compDecision[9]+=2;
	    		compDecision[10]+=2;
	    	}
	    	
	    	if((boardDecision[9] == computer && (boardDecision[10] == computer || boardDecision[11] == computer)) || (boardDecision[10] == computer && boardDecision[11] == computer))
	    	{
	    		compDecision[9]+=2;
	    		compDecision[10]+=2;
	    		compDecision[11]+=2;
	    	}
	    	
	    	//4 DIAGONAL SPOTS
	    	if((boardDecision[0] == computer && (boardDecision[5] == computer || boardDecision[10] == computer)) || (boardDecision[5] == computer && boardDecision[10] == computer))
	    	{
	    		compDecision[0]+=2;
	    		compDecision[5]+=2;
	    		compDecision[10]+=2;
	    	}
	    	
	    	if((boardDecision[1] == computer && (boardDecision[6] == computer || boardDecision[11] == computer)) || (boardDecision[6] == computer && boardDecision[11] == computer))
	    	{
	    		compDecision[1]+=2;
	    		compDecision[6]+=2;
	    		compDecision[11]+=2;
	    	}
	    	
	    	if((boardDecision[2] == computer && (boardDecision[5] == computer || boardDecision[8] == computer)) || (boardDecision[5] == computer && boardDecision[8] == computer))
	    	{
	    		compDecision[2]+=2;
	    		compDecision[5]+=2;
	    		compDecision[8]+=2;
	    	}
	   	
	    	if((boardDecision[3] == computer && (boardDecision[6] == computer || boardDecision[9] == computer)) || (boardDecision[6] == computer && boardDecision[9] == computer))
	    	{
	    		compDecision[3]+=2;
	    		compDecision[6]+=2;
	    		compDecision[9]+=2;
	    	}
    		
    		if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't create three in a row");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]+",");
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		System.out.println("");
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    		
    		for(int num = 0; num < 12; num++)
    		{
    			if(boardDecision[num] > 0) compDecision[num] = 100;
    		}
    		
    		
    		if(compDecision[6]!=100)
    		compDecision[6] += 1;
    		if(compDecision[5]!=100) 
    		compDecision[5] += 1; 
    		
    		if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	System.out.println("don't choose spots that are taken");
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(compDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    	}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
    		
	    	//oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
	    	
	    	for(int num = 0; num < 12; num++)
    		{
	    			if(compDecision[num] < -3 )
	    			{
	    				random[number] = num+1;
	    				number++;
	    			}	
    		}
	    	
	    	for(int num = 0; num < 12; num++)
    		{
	    			if(compDecision[num] == -3 )
	    			{
	    				random[number] = num+1;
	    				number++;
	    			}	
    		}
	    	
	    	for(int num = 0; num < 12; num++)
    		{
	    			if(compDecision[num] == -2 )
	    			{
	    				random[number] = num+1;
	    				number++;
	    			}	
    		}
	    	
    		for(int num = 0; num < 12; num++)
    		{
	    			if(compDecision[num] == -1 )
	    			{
	    				random[number] = num+1;
	    				number++;
	    			}	
    		}
    		
    		for(int num = 0; num < 12; num++)
    		{
	    			if(compDecision[num] == 0 )
	    			{
	    				random[number] = num+1;
	    				number++;
	    			}	
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 1 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 2 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 3 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 4 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 5 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] == 6 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		
    		if(number == 0)
    		{
	    		for(int num = 0; num < 12; num++)
	    		{
		    			if(compDecision[num] != 100 )
		    			{
		    				random[number] = num+1;
		    				number++;
		    			}	
	    		}
    		}
    		if(tracing)
			{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
				System.out.println("my choices");
				for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(random[num]+", ");
	    		}
	    		System.out.println("");
	    		System.out.println("");
			}//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
			
    		number =(int)(number*Math.random()+1);
    			
    		if(number == 12)
    		{
    			choice = random[11];
    		}
    		
    		if(number == 11)
    		{
    			choice = random[10];
    		}
    		
    		if(number == 10)
    		{
    			choice = random[9];
    		}
    		
    		if(number == 9)
    		{
    			choice = random[8];
    		}
    		
    		if(number == 8)
    		{
    			choice = random[7];
    		}
    		
    		if(number == 7)
    		{
    			choice = random[6];
    		}
    		
    		if(number == 6)
    		{
    			choice = random[5];
    		}
    		
    		if(number == 5)
    		{
    			choice = random[4];
    		}
    		
    		if(number == 4)
    		{
    			choice = random[3];
    		}
    		
    		if(number == 3)
    		{
    			choice = random[2];
    		}
    		
    		if(number == 2)
    		{
    			choice = random[1];
    		}
    		
    		if(number == 1)
    		{
    			choice = random[0];
    		}
    		
   			//SETTING SPOTS BASED ON THE CHOICE
	    	if(choice == 1 && boardDecision[0] == 0)
	    	{ 
	    		y = 3;
	    		x = 7;
	    	}
	    	
	    	if(choice == 2 && boardDecision[1] == 0)
	    	{
	    		y = 3;
	    		x = 22;
	    	}
	    	
	    	if(choice == 3 && boardDecision[2] == 0)
	    	{
	    		y = 3;
	    		x = 38;
	    	}
	    	
	    	if(choice == 4 && boardDecision[3] == 0)
	    	{
	    		y = 3;
	    		x = 54;
	    	}
		
	    	if(choice == 5 && boardDecision[4] == 0)
	    	{
	    		y = 11;
	    		x = 7;
	    	}
	    	
	    	if(choice == 6 && boardDecision[5] == 0)
	    	{
	    		y = 11;
	    		x = 22;
	    	}
	    	
	    	if(choice == 7 && boardDecision[6] == 0)
	    	{
	    		y = 11;
	    		x = 38;
	    	}
	    	
	    	if(choice ==8 && boardDecision[7] == 0)
	    	{
	    		y = 11;
	    		x = 54;
	    	}
	    	
	    	if(choice == 9&& boardDecision[8] == 0)
	    	{
	    		y = 19;
	    		x = 7;
	    	}
	    	
	    	if(choice == 10 && boardDecision[9] == 0)
	    	{
	    		y = 19;
	    		x = 22;
	    		boardDisplay[17][19] = ' ';
	    	}
	    	
	    	if(choice == 11 && boardDecision[10] == 0)
	    	{
	    		y = 19;
	    		x = 38;   	
    			boardDisplay[17][35] = ' ';
	    	}
	    	
	    	if(choice == 12 && boardDecision[11] == 0)
	    	{
	    		y = 19;
	    		x = 54;
	    		boardDisplay[17][51] = ' ';
	    	}
		
    	if(turn % 2 == 1) 	//DISPLAY O IF IT'S AN ODD TURN
    	{
			boardDecision[choice - 1] =	1;//SETTING THE VALUE OF ARRAY TO THE CHOSEN SPOT
			
	    	boardDisplay[y][x+6] = 'o';
	    	boardDisplay[y][x-6] = 'o';
	    	
	    	boardDisplay[y+1][x-6] = 'o';
	    	boardDisplay[y-1][x-6] = 'o';
	    	
	    	boardDisplay[y+2][x-5] = 'o';
	    	boardDisplay[y-2][x-5] = 'o';
	    	
	    	boardDisplay[y+2][x-4] = 'o';
	    	boardDisplay[y-2][x-4] = 'O';
	    	
	    	boardDisplay[y+3][x-3] = 'O';
	    	boardDisplay[y-3][x-3] = 'o';
	    	
	    	boardDisplay[y+3][x-2] = 'o';
	    	boardDisplay[y-3][x-2] = 'o';
	    	
	    	boardDisplay[y+3][x-1] = 'o';
	    	boardDisplay[y-3][x-1] = 'o';
	    	
	    	boardDisplay[y+3][x] = 'o';
	    	boardDisplay[y-3][x] = 'o';
	    	
	    	boardDisplay[y+1][x+6] = 'o';
	    	boardDisplay[y-1][x+6] = 'o';
	    	
	    	boardDisplay[y+2][x+5] = 'o';
	    	boardDisplay[y-2][x+5] = 'o';
	    	
	    	boardDisplay[y+2][x+4] = 'o';
	    	boardDisplay[y-2][x+4] = 'O';
	    	
	    	boardDisplay[y+3][x+3] = 'O';
	    	boardDisplay[y-3][x+3] = 'o';
	    	
	    	boardDisplay[y+3][x+2] = 'o';
	    	boardDisplay[y-3][x+2] = 'o';
	    	
	    	boardDisplay[y+3][x+1] = 'o';
	    	boardDisplay[y-3][x+1] = 'o';
	    	
    	}
    	else if(turn % 2 == 0)	//DISPLAY X IF IT'S AN EVEN TURN
    	{
    		boardDecision[choice - 1] =	2;//SETTING THE VALUE OF ARRAY TO THE CHOSEN SPOT
    		
    	  	//X display
	    	boardDisplay[y][x] = 'x';
	    	
	    	boardDisplay[y+1][x-2] = 'x';
	    	boardDisplay[y+2][x-4] = 'x';
	    	boardDisplay[y+3][x-6] = 'x';
	    	
	    	boardDisplay[y+1][x+2] = 'x';
	    	boardDisplay[y+2][x+4] = 'x';
	    	boardDisplay[y+3][x+6] = 'x';
	    	
	    	boardDisplay[y-1][x-2] = 'x';
	    	boardDisplay[y-2][x-4] = 'x';
	    	boardDisplay[y-3][x-6] = 'x';
	    	
	    	boardDisplay[y-1][x+2] = 'x';
	    	boardDisplay[y-2][x+4] = 'x';
	    	boardDisplay[y-3][x+6] = 'x';
    	}
    	
    	System.out.print("hi I'm thinking");
    	time();
    	System.out.print(".");
    	time();
    	System.out.print(".");
    	time();
    	
    	if(tracing)
	    	{//TRACING TRACING TRACING TRACING TRACING TRACING TRACING
		    	test=0;
		    	for(int num = 0; num < 12; num++)
	    		{
		    		System.out.print(boardDecision[num]);
		    		test++;
		    		if(test%4==0)System.out.println();
	    		}
	    		br.readLine();
	    	}
    }//END computerMove2()
 	   
    //METHOD FOR DISPLAYING THANK YOU
    static void displayThankYou() {
    	
    	System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
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
    	System.out.println("                             Hope you enjoyed Reversed Tic Tac Toe :)");
    	System.out.println("");
    	System.out.println("                   If you have any questions or comments you can send me an em@il:");
    	System.out.println("");
    	System.out.println("                                      Namster@ufacademy.ca");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                      Press enter to exit");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");		
    	
    }//END displayThankYou()
    
	//METHOD FOR DISPLAYING INVALID
	static void displayInvalid()  {
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
    	System.out.println("                                    press enter to continue");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("");	

	}//END displayInvalid()
}//END CLASS
