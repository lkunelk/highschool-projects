
/**
 * NamsMastermindGame.java
 *
 * This is a game where the computer generates a random combination of numbers from 1 to 6
 * and the player has 10 chances to guess. After each guess the player gets a hint: '+' for
 * correct number in correct spot, '-' for correct number in wrong spot and ' ' for wrong number.
 * The score for a game is based on number of turns the player takes to guess the given combination.
 * The average score is based on the average of scores from all games the player has played.
 *
 * Nam Nguyen
 * version 1.00 
 * Started 2013/9/23
 * Ended 2013/10/12
 */
import java.io.*;//FOR BUFFEREDREADER
 
public class NamsMastermindGame
{
	boolean tracing = false;//FOR TRACING PROGRAM
	
    public static void main(String[] args) throws Exception
    {
    	new NamsMastermindGame();
    }//END main()
	
	//CONSTRUCTOR
    NamsMastermindGame()throws Exception
    {
    	//DECLARING VARIABLES
    	char choice=' '; //FOR USER'S CHOICE
    	String input;
    	
    	//CREATING AN INPUT OBJECT
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	
    	//DISPLAYING CONSOLE DIMENSION
    	System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n              console dimensions\n             width=44, height=26\n\n\n\n\n\n\n\n\n\n           press enter to continue         \n\n");
    	br.readLine();//PAUSING
    	
    	displayTitle();
    	br.readLine();//PAUSING
    	
    	do
    	{
    		displayMenu();
    		input = br.readLine();
    		
    		
    		if(!input.equals(""))//PREVENTS PROGRAM FROM CRASHING
    		{
    			choice = input.charAt(0);
    				
    			switch(choice)//CALL METHODS BASED ON INPUT
    			{
    			case 'p'://PLAY GAME
    			case 'P': play(br);
    					  break;
    				
    			case 'i'://INSTRUCTIONS
    			case 'I': displayInstructions();
    					  br.readLine();//PAUSING
    					  break;
    				
    			case 'q'://QUIT PROGRAM
    			case 'Q': break;
    			
    			default : displayInvalid();
    			}
    		
    		}
    		else
    		{
    			displayInvalid();
    			br.readLine();//PAUSING
    		}
    		
    	}while(choice!='q'&&choice!='Q');
    	
    }//END NamsMastermindGame()
    
    //1 METHOD FOR DISPLAYING TITLE
    public void displayTitle()
    {
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("              ________ __     .     __  ");
    	System.out.println("     |\\/| /\\ /__`||__ |__)|\\/|||\\ ||  \\ ");
    	System.out.println("     |  |/--\\.__/||___|  \\|  ||| \\||__/");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("            hit Enter to continue");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("");
    }//END displayTitle()
    
    //2 METHOD FOR DISPLAYING INSTRUCTIONS
    public void displayInstructions()
    {
    	System.out.println("                                           ");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("         The computer will create");
    	System.out.println("          a 4 digit combination");
    	System.out.println("         using numbers from 1 to 6");
    	System.out.println("");
    	System.out.println("      You have to guess the combination");
    	System.out.println("");
    	System.out.println("         You only have 10 guesses");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("           based on your answers");
    	System.out.println("            you will get hints");
    	System.out.println("       (+) right number, right spot");
    	System.out.println("       (-) right number, wrong spot");
    	System.out.println("");
    	System.out.println("           Your score is based on");
    	System.out.println("    the number of turns you take to guess");
    	System.out.println("");
    	System.out.println("      if you don't guess it in 10 turns");
    	System.out.println("                 you loose");
    	System.out.println("");
    	System.out.println("            Hit enter to return");
    	System.out.println("");
    	System.out.print("");
    }//END displayInstructions()
    
    //3 METHOD FOR DISPLAYING INVALID
    public void displayInvalid()
    {
    	System.out.println("                                           ");
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
    	System.out.println("             Sorry, Invalid choice");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("              hit enter to return");
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
    	System.out.print("");
    }//END displayInvalid()
    
    //4 METHOD FOR DISPLAYING MENU
    public void displayMenu()
    {
    	System.out.println("         |                                 ");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |  MENU");
    	System.out.println("         +----------------------+");
    	System.out.println("         |                        +");
    	System.out.println("                                   |");
    	System.out.println("           P -> play                +");
    	System.out.println("           I -> instructions        |");
    	System.out.println("           Q -> quit                +");
    	System.out.println("                                   |");
    	System.out.println("         |                        +");
    	System.out.println("         +----------------------+");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         |");
    	System.out.println("         | Your choice");
    	System.out.print("         +--------------> ");
    }//END displayMenu()
    
    //5 METHOD FOR RESETTING BOARD
    public void resetBoard(char[][] board)
    {
    	//ERASE WHOLE BOARD
    	for(int row=1; row<26; row++)
    		for(int col=0; col<44; col++)
    			board[row][col] = ' ';
    			
    	//SETTING UP TOP AND BOTTOM BORDER
    	for(int row=1; row<26; row+=23)
    		for(int col=0; col<44; col++)
    			board[row][col] = 'o';
    	
    	for(int row=2; row<26; row+=23)
    		for(int col=0; col<44; col++)
    			board[row][col] = '.';
    			
    	//SETTING UP VERTICAL LINES		
    	for(int row=3; row<24; row++)
    	{
    		board[row][1]=board[row][10]=board[row][27]=board[row][41]= '|';
    	}
    	
    	//SETTING UP NUMBERS
    	board[4][4]='1';board[4][5]='0';
    	board[6][4]='9';
    	board[8][4]='8';
    	board[10][4]='7';
    	board[12][4]='6';
    	board[14][4]='5';
    	board[16][4]='4';
    	board[18][4]='3';
    	board[20][4]='2';
    	board[22][4]='1';
    }//END resetBoard()
    
    //6 METHOD FOR DISPLAYING BOARD
    public void displayBoard(char[][] board)
    {
    	for(int row=0; row<25; row++)
    	{
    		for(int col=0; col<44; col++)
    		{
    			System.out.print(board[row][col]);
    		}
    	}
    	
    }
    
    //8 METHOD FOR ASKING FOR A GUESS AND CHECKING THAT THE GUESS IS VALID
    public boolean askForGuess(BufferedReader br, byte[] guess) throws Exception
    {
    	String choice;//FOR USER INPUT
    	System.out.print("Your guess is:");//GETTING USER INPUT
    	choice = br.readLine();
    	
    	if(choice.length()==4)//CHECKING FOR CORRECT AMOUNT OF NUMBERS TYPED IN
    		//CHECKING IF NUMBERS ARE IN CORRECT RANGE 1to6
    		if(choice.charAt(0)>=49 && choice.charAt(0)<=54)//NUMBER 1
    			if(choice.charAt(1)>=49 && choice.charAt(1)<=54)//NUMBER 2
    				if(choice.charAt(2)>=49 && choice.charAt(2)<=54)//NUMBER 3
    					if(choice.charAt(3)>=49 && choice.charAt(3)<=54)//NUMBER 4
    					{
    						//SETTING CHOICES TO GUESS ARRAY 
    						for(int a=0; a<4; a++)
    							guess[a]=(byte)(choice.charAt(a)-48);
    							
    						return false;//NUMBERS ARE GOOD
    					}
    					
    	displayInvalid();
    	br.readLine();//pausing
    	return true;//NUMBERS ARE BAD
    	
    }//END askCombination()
    	
    //9 METHOD FOR RANDOMLY GENERATING COMBINATION
    public void chooseCombo(byte[] combo)
    {
    	for(int a = 0; a<=3; a++)
    		combo[a] = (byte)(Math.random()*6+1);
    	
    }
    
    //10 METHOD FOR DISPLAYING SCORE
    public void displayScore(byte turn, double averageScore, byte numGame, byte score)
    {
    	//CALCULATING AVERAGE SCORE
    	double avScore;
    	avScore = 10*(averageScore/numGame); if(tracing)System.out.print("1: "+avScore+"; ");
    	avScore = Math.round(avScore);       if(tracing)System.out.print("2: "+avScore+"; ");
    	avScore /= 10;                       if(tracing)System.out.print("3: "+avScore+"; ");
    	
    	if(!tracing)System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("          Your Score This Round");
    	System.out.println("                      ----------> "+score);
    	System.out.println("");
    	System.out.println("          Your Average Score");
    	System.out.println("                   ----------> "+avScore);
    	System.out.println("");
    	System.out.print("          You played "+numGame+" game");if(numGame>1)System.out.println("s");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("          Hit Enter to play Again");
    	System.out.println("           (or press q to quit)");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("");
    }//END displayScore
    
    //11 METHOD FOR CHECKING THE GUESS AND SETTING THE BOARD BASED ON THE GUESS
    public boolean checkGuess(char[][] board, byte[] combo, byte[] guess, byte turn)
    {
    	//DECLARING VARIABLES
    	byte x=0;
    	char[] hints = new char[4]; //HINTS FOR THE USER
    	boolean[] checkedCombo = new boolean[4];
    	boolean[] checkedGuess = new boolean[4];//TO LET PROGRAM KNOW WHICH PAIRS OF NUMBERS TO CHECK
    	
    	//CHECKING FOR RIGHT NUMBERS IN THE RIGHT SPOT
    	for(int a=0; a<4;a++)
	    	if(guess[a]==combo[a])
	    		{	
	    			checkedGuess[a] = checkedCombo[a]= true;//NO NEED TO CHECK THESE COLUMNS ANYMORE
	    			hints[x] = '+';
	    			x++;
	    		}
    		
    	//CHECKING FOR RIGHT NUMBERS IN WRONG SPOTS
    	for(int a=0; a<4;a++)
    		for(int b=0; b<4;b++)
    			if(!checkedGuess[a] && !checkedCombo[b] && guess[a]==combo[b])
    				{	
    					checkedCombo[b]=true;//NO NEED TO CHECK THESE NUMBERS ANYMORE
    					hints[x] = '-';
    					x++;
    					break;
					}
	    	
	    	
	    		
    	//SETTING THE USERS GUESS ON BOARD based on turn
       	board[22-(turn-1)*2][16]=(char)(guess[0]+48);
    	board[22-(turn-1)*2][18]=(char)(guess[1]+48);
    	board[22-(turn-1)*2][20]=(char)(guess[2]+48);
    	board[22-(turn-1)*2][22]=(char)(guess[3]+48);
    	
    	//SETTING THE HINTS ON BOARD
    	board[22-(turn-1)*2][31]=hints[0];
    	board[22-(turn-1)*2][33]=hints[1];
    	board[22-(turn-1)*2][35]=hints[2];
    	board[22-(turn-1)*2][37]=hints[3];
    	
    	//IF THE PLAYER GUESSES CORRECTLY RETURN FALSE
    	return !(hints[0]=='+' && hints[1]=='+' && hints[2]=='+' && hints[3]=='+');
    }//END checkGuess()
    
    //12 METHOD FOR PLAYING GAME
    public void play(BufferedReader br) throws Exception
    {
    	//DECLARING VARIABLES
    	char[][] board = new char[26][44]; //BOARD
    	byte[] combo = new byte[4]; //THE SECRET NUMBER
    	byte[] guess = new byte[4]; //USER'S GUESS
    	
    	byte numGame = 0; //FOR COUNTING THE NUMBER OF GAMES PLAYED
    	byte turn = 0; //FOR KEEPING TRACK OF TURNS IN GAME
    	byte score;
    	double averageScore = 0; //KEEPING TRACK OF TOTAL SCORE
    	boolean notWin = true; //TO LET PROGRAM KNOW IF PLAYER IS WON
    	boolean notGood = true; //TO LET PROGRAM KNOW IF THE GUESS IS VALID
    	String choice = " "; //USER'S CHOICE
    	
    	do//START GAME
    	{
    		//RESETTING VALUES
    		turn=0;
    		score=0;
    		notWin = true;
    		chooseCombo(combo);
			resetBoard(board);
			
    		do
    		{
    			turn++;
    			
    			do//Ask For Guess Until Valid
    			{
    				displayBoard(board);                if(tracing){System.out.print("turn: ["+turn+"] ");System.out.print("("+combo[0]+combo[1]+combo[2]+combo[3]+")");}
    				notGood = askForGuess(br, guess);         
    			}while(notGood);
    			notWin=checkGuess(board, combo, guess, turn);
    			
    		}while(notWin && turn<10);
    		
    		displayBoard(board);
    		if(!notWin)
    			System.out.print("You've guessed it!");
    		else
    			System.out.print("Game Over!");
    		br.readLine();
    		
    		//CALCULATING SCORE
    		numGame++;
    		score = (byte)(11-turn);
    		if(notWin)//DID NOT GUESS=NO POINTS
    			score=0;
    		averageScore+=score;
    		
    		
    		
    		displayScore(turn, averageScore, numGame, score);
    		choice = br.readLine();
    		
    	}while(!choice.equals("q")&&!choice.equals("Q"));
    }//END playGame()
    
}//END CLASS
