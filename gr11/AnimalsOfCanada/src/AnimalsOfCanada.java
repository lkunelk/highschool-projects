/**
 * @(#)AnimalsOfCanada.java
 *
 * AnimalsOfCanada application
 *
 * The goal of this game is to guess a word randomly selected from a pool of words. 
 * The user makes guesses letter by letter until s/he gets the word right
 * The theme of this game is animals of Canada.
 *
 * started: 2013/12/15
 * ended: 2013/12/20
 *
 * @Nam Nguyen
 * @version 1.00 
 */
 
import java.io.*;//for BufferedReader
 
public class AnimalsOfCanada {
    
    byte lives = 7; //lives for the player
    
    public static void main(String[] args)throws Exception{
    	new AnimalsOfCanada();
    }
    
    //CONSTRUCTOR
    AnimalsOfCanada()throws Exception{
    	
    	//VARIABLES
    	char letter = ' ';
    	String choice = " ";
    	
    	//CREATING INPUT OBJECT
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
    	displayTitle();
    	br.readLine();//PAUSING
    	
    	//RETURN TO MENU UNTIL PLAYER EXITS
    	while(letter != 'e' && letter != 'E')
    	{
	    	displayMenu();
	    	
	    	do
	    	{//GET USER CHOICE UNTIL VALID
	    		choice = br.readLine();
	    		if(choice.length() == 1){
	    			letter = choice.charAt(0);
	    			
	    			if(letter!='p' && letter!='i' && letter!='e' &&
	    				letter!='P' && letter!='I' && letter!='E'){
	    				displayInvalid();
	    				br.readLine();//PAUSING
	    				displayMenu();
	    			}
	    		}
	    		else{
	    			displayInvalid();
	    			br.readLine();//PAUSING
	    			displayMenu();
	    		}
	    			
	    		
	    	}while(letter!='p' && letter!='i' && letter!='e'&&
	    			letter!='P' && letter!='I' && letter!='E');   		    	
	    	
	    	
	    	
	    	switch(letter){//MENU
	    		case 'p':
	    		case 'P': play(br);
	    				  break;
	    			
	    		case 'i':
	    		case 'I': displayInstructions();
	    				  br.readLine();
	    				  break;
	    	}//end switch
    	}
    	
    	
    }
    
    //1 METHOD FOR DISPLAYING TITLE
    public void displayTitle()
    {
    	System.out.println("/                                                \\");
    	System.out.println("\\               ANIMALS OF CANADA                /");
    	System.out.println("/                -----------------               \\");
    	System.out.println("\\                                                /");
    	System.out.println("/                   hit Enter!                   \\");
    	System.out.print("\\                                                /");
    	System.out.print((int)' ');
    	
    }//END displayTitle()
    
    //2 METHOD FOR DISPLAYING MENU
    public void displayMenu()
    {
    	System.out.println("                            ");
    	System.out.println("  Menu           P -> play        ");
    	System.out.println("  ----           I -> instructions");
    	System.out.println("                 E -> quit        ");
    	System.out.println("");
    	System.out.print("your choice: ");
    }//END displayMenu()
    
    //3 METHOD FOR DISPLAYING INSTRUCTIONS
    public void displayInstructions()
    {	
    	
    	System.out.println("            Have you ever played Hangman?");
    	System.out.println("         Animals of Canada is basically that");
    	System.out.println("    you have to guess the words letter by letter");
    	System.out.println("       and You only have 7 lives so good luck");
    	System.out.println("");
    	System.out.print("                     Hit Enter!");
    	
    }//END displayInstructions()
    
    //4 METHOD FOR DISPLAYING INVALID
    public void displayInvalid()
    {
    	System.out.println("");
    	System.out.println("");
    	System.out.println("             Sorry, Invalid choice");
    	System.out.println("");
    	System.out.println("                  Hit Enter!");
    	System.out.println("hi");
    }//END displayInvalid()
    
    //5 METHOD FOR PLAYING THE GAME
    public void play(BufferedReader br)throws Exception{
    	
    	//DECLARING VARIABLES
    	boolean win = false;//LET'S PROGRAM KNOW IF PLAYER GUESSED THE WORD
    	boolean tracing = true;//TRACING PROGRAM
    	byte x = (byte)(Math.random()*78);//RANDOM NUMBER
    	//POOL OF WORDS
    	String[] words = {"elk's","kunek's cube","white-tailed deer","moose","caribou","beluga","cougar","canada lynx","bobcat","striped skunk","american marten","fisher",
    						"short-tailed weasel","least weasel","long-tailed weasel","mink","wolverine","badger","northern river otter","raccoon","walrus",
    						"harbour seal","ringed seal","bearded seal","black bear","polar bear","coyote","grey wolf","arctic fox","red fox",
    						"grey fox","porcupine","meadow jumping mouse","woodland jumping mouse","norway rat","house mouse","deer mouse","white-footed mouse",
    						"southern red-backed vole","eastern heather vole","meadow vole","rock vole","woodland vole","muskrat","southern bog lemming",
    						"beaver","eastern chipmunk","least chipmunk","wood chuck","red squirrel","eastern grey squirrel",
    						"eastern fox squirrel","southern flying squirrel","northern flying squirrel","white-tailed jackrabbit","european hare",
    						"snowshoe hare","eastern cottontail","northern bat","little brown bat","eastern small-footed bat","eastern red bat",
    						"hoary bat","silver-haired bat","big brown bat","eastern pipistrelle","virginia opossum","hairy-tailed mole","eastern mole",
    						"star-nosed mole","masked shrew","water shrew","smoky shrew","arctic shrew","pygmy shrew","least shrew"};
    	char[] answer = words[x].toCharArray();//STORES THE ANSWER
    	char[] word = new char[answer.length];//FOR DISPLAYING THE WORD
    	char[] alreadyGuessed = new char[26];//FOR STORING ALL LETTERS GUESSED BY USER
    	
    	//CONVERT LETTERS TO UNDERSCORES
    	for(int a = 0; a < answer.length; a++){
    		if(answer[a]==' ')
    			word[a] = ' ';
    		else if(answer[a]=='-')
    			word[a] = '-';
    		else if(answer[a]=='\'')
    			word[a] = '\'';
    		else
    			word[a] = '_';
    	}//end for
    	
    	lives = 7;//resseting lives
    	
    	do
    	{//START THE GAME
    		
	    	if(tracing){//-------------------------------          
	    		for(int a = 0; a < answer.length; a++)
	    			System.out.print(answer[a]);
	    		System.out.println("");
	    		for(int a = 0; a < answer.length; a++)
	    			System.out.print(word[a]);
	    		System.out.println("");	
	    	} //-----------------------------------------
	    	
	    	displayBoard(word, alreadyGuessed);
	    	
	    	//GETTING AND CHECKING USER'S GUESS
	    	win = checkGuess(getGuess(word, alreadyGuessed), answer, word);
	    	
	    	
	    	
    	}while(!win && lives>0);//UNTIL WORD IS GUESSED OR RUN OUT OF LIVES
    	
    	displayResults(win, answer);
    	br.readLine();//PAUSING
    	
    }//END play()
    
    //6 METHOD FOR DISPLAYING BOARD
    public void displayBoard(char[] word, char[] alreadyGuessed){
    	System.out.println("lives: "+lives);
    	System.out.println("");
    	
    	//ADDS BLANK SPACES FOR CENTERING THE OUTPUT
    	for(int a = 0; a < (50-(word.length*2))/2; a++){
    		System.out.print(" ");
    	}
    	
    	//DISPLAYS THE WORD TO BE GUESSED
    	for(int i = 0; i < word.length; i++){
    		System.out.print(word[i]+" ");
    	}
    	
    	System.out.println("\n");
    	
    	//DISPLAYS LETTERS THAT WERE ALREADY GUESSED
    	System.out.print("Guessed: ");
    	for(int i = 0; i < alreadyGuessed.length; i++){
    		System.out.print(" "+alreadyGuessed[i]);
    	}
    	System.out.println("");
    	System.out.print("your choice: ");
    	
    }//END displayBoard()
    
    //7 METHOD FOR GETTING GUESS
    public char getGuess(char[] word, char[] alreadyGuessed)throws Exception{
    
    	//CREATING INPUT OBJECT
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	boolean bad = true;//TELLS PROGRAM IF LETTER IS ALREADY GUESSED
    	char letter = ' ';
    	String guess = " ";
    	
    	
    	do
    	{//GET USER GUESS UNTIL IT'S VALID
    		
    		//GETTING USER INPUT
    		guess = br.readLine();
    		
    		if(guess.length() == 1)
    		{
    			guess.toLowerCase();
    			letter = guess.charAt(0);
    			bad = false;//ASSUMING THE LETTER WASN'T ALREADY GUESSED
    			
    			if(letter <= 'z' && letter >= 'a'){//IF IN RANGE OF THE ALPHABET
	    			//CHECKING THAT THE LETTER WASN'T ALREADY GUESSED
	    			for(int a=0; a<alreadyGuessed.length; a++){
	    				if(alreadyGuessed[a]==letter){
	    					bad = true;
	    				}	
	    			}//end for
	    			
	    			if(!bad){//IF VALID ADD THE LETTER TO alreadyGuessed ARRAY
	    				for(int a=0; a<alreadyGuessed.length; a++){
	    					if(alreadyGuessed[a]==(char)0){
	    						alreadyGuessed[a] = letter;
	    						break;
	    					}
	    				}
	    			}
    			}
    			else{
    				bad = true;
    			}
    			
    		}//END IF
    			
    		if(bad)
    		{
    			displayInvalid();
    			br.readLine();//PAUSING
    			displayBoard(word, alreadyGuessed);
    		}
    	}while(bad);
    	
    	return letter;
    	
    }//END getGuess()
    
    //8 METHOD FOR CHECKING GUESS
    public boolean checkGuess(char guess, char[] answer, char[] word){
    	
    boolean good = false;//HAS TWO FUNCTIONS HERE
    
    //CHECKING IF GUESS MATCHES A LETTER IN THE ANSWER
    for(int a=0; a<answer.length; a++){
    	if(guess == answer[a]){
    		word[a]=guess;
    		good = true;
    	}	
    }
    if(!good){
    		lives--;
    	}
    //CHECKING THAT THE USER GUESSED THE WORD
    good = true;//ASSUMING THE USER HAS GUESSED IT
    for(int a=0; a<answer.length; a++){
    	if(answer[a]!=word[a])
    		good = false;
    }
    
    return good;
    	
    }//END checkGuess()
    
    //9 METHOD FOR DISPLAYING RESULT
    public void displayResults(boolean win, char[] answer){
    	
    	System.out.println("");
    	
    	if(win){
    		System.out.println("             Nice, you've guessed it!");
    		System.out.println("     Your on your way to becoming a biologist");
    	}
    	else{
    		System.out.println("        Nice, try! But you run out of lives.");
    		System.out.println("       Maybe a quick review of bio will help");
    	}
    	System.out.println("");
    	
    	//FOR CENTERING TEXT
    	for(int a = 0; a <(50-(16+answer.length))/2; a++){
    		System.out.print(" ");
    	}
    	
    	System.out.print("the answer was: "); for(int a =0; a < answer.length; a++)System.out.print(answer[a]);
    	System.out.println("");
    	System.out.print("                   Hit Enter!");
    }//END displayResults()
   
}//END checkGuess()
