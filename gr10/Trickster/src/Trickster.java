/**
 * @(#)Trickster.java
 *
 * Trickster application
 *
 * This program is a quiz that test the users wit. The user will be asked 10 question plus 1 optional question,
 * each question being worth 2 points. The user also can request a hint, but the question will be worth only 1 point.
 * At the end of the quiz the program calculates the final score.
 *
 * author: Nam Nguyen
 *
 * date started: 2013/1/25
 * date finished: 2013/2/15
 */
 
import java.io.*; 
 
public class Trickster {
		  	
    public static void main(String[] args) throws Exception {
    	
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
	//Declaring Variables
	String answer; 
	String name; 
	boolean animationOnOff = true; //for turning on and off animation
	boolean pausingOnOff = true; //for turning on and off pausing
	boolean tracing = false; // for checking values of minus point and question nmber
	int score;
	int hint;
	int hintsUsed;
	int random;
	int minusPoint;
	int questionNumber;
	
	do
	{
		
		//Resetting variables
		questionNumber = 1;
		hint = 3;
		minusPoint = 0;
		score = 0;
		random = (int)(80 * Math.random()+7);
		hintsUsed = 0;
		
		displayTitle(br);
			
		displayInstructions(br);
		
		displayRequestForName();
		
		name = br.readLine(); //Input
		
		do
		{
			//QUESTION SELECTOR...displays titles based on question number
			switch(questionNumber) // Displaying Question Title
			{
				case 1: 	if(animationOnOff)displayQuOneTitle();
							displayQuestionOne(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 2:		if(animationOnOff)displayQuTwoTitle();
							displayQuestionTwo(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 3:		if(animationOnOff)displayQuThreeTitle();
							displayQuestionThree(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 4:		if(animationOnOff)displayQuFourTitle();
							displayQuestionFour(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 5:		if(animationOnOff)displayQuFiveTitle();
							displayQuestionFive(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 6:		if(animationOnOff)displayQuSixTitle();
							displayQuestionSix(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 7:		if(animationOnOff)displayQuSevenTitle();
							displayQuestionSeven(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 8:		if(animationOnOff)displayQuEightTitle();
							displayQuestionEight(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 9:		if(animationOnOff)displayQuNineTitle();
							displayQuestionNine(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				case 10:	if(animationOnOff)displayQuTenTitle();
							displayQuestionTen(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
							break;
							
				default:	if(animationOnOff)displayFinalQuTitle();
							displayFinalQuestion(score, hint, name);
							if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
			}
		
			do 
			{
				answer = br.readLine(); //Input
				
					if(answer.equals("hint") && hint > 0 && questionNumber != 12 )
					{
						if(minusPoint == 0)
						{
							hint -= 1;
							minusPoint +=1;	
						}
						
						switch(questionNumber) // Displaying Question Hint Based On Question Number
						{
							case 1:		displayQuestionOneHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 2:		displayQuestionTwoHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 3:		displayQuestionThreeHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 4:		displayQuestionFourHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 5:		displayQuestionFiveHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 6:		displayQuestionSixHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 7:		displayQuestionSevenHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 8:		displayQuestionEightHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 9:		displayQuestionNineHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							case 10:	displayQuestionTenHint(score, hint, name);
										if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
										break;
										
							default:
						}
						


				}
				else if(answer.equals("hint")||answer.equals(""))
				{	
					if(answer.equals("hint"))
					{
						displayNoHint();
						Thread.sleep(2000); //Pausing
					}
					
					if(answer.equals(""))
					{
						displayInvalid(answer);
						Thread.sleep(2000); //Pausing
					}
					
					
					displayNoHint();
					Thread.sleep(2000); //Pausing
					
					switch(questionNumber) // Displaying Question Again Based On Question Number
					{
						case 1:		displayQuestionOne(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 2:		displayQuestionTwo(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 3:		displayQuestionThree(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 4:		displayQuestionFour(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 5:		displayQuestionFive(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 6:		displayQuestionSix(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 7:		displayQuestionSeven(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 8:		displayQuestionEight(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 9:		displayQuestionNine(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						case 10:	displayQuestionTen(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
									break;
									
						default:	displayFinalQuestion(score, hint, name);
									if(tracing)System.out.print("question number:" + questionNumber + "  minus point:" + minusPoint);
					}
				}
		}//End of loop
		while(answer.equalsIgnoreCase("hint")||answer.equalsIgnoreCase(""));
		
		switch(questionNumber) // Checking The Answer And Adding Points Based On Question Number
		{
			case 1:		if(answer.equalsIgnoreCase("match"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 2:		if(answer.equals("8") || answer.equals("a"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 3:		if(answer.equalsIgnoreCase("gravity"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 4:		if(answer.equals("1"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 5:		if(answer.equalsIgnoreCase("mount everest"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 6:		if(answer.equals("70"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 7:		if(answer.equalsIgnoreCase("larry"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 8:		if(answer.equals("12") || answer.equals("all") || answer.equals("a"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 9:		if(answer.equalsIgnoreCase("window"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			case 10:		if(answer.equals("0"))
						{
							score += 2 - minusPoint;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							if(pausingOnOff)pausing();
						}
						break;
						
			default:		if(answer.equalsIgnoreCase(name))
						{
							score += 5 ;
							displayCorrect();
							if(pausingOnOff)pausing();
						}
						else
						{
							displayIncorrect();
							score -= 5;
							if(pausingOnOff)pausing();
						}
		}
			
			questionNumber += 1; //tells program to go to the next question
			minusPoint = 0; //reset the value
			  
			//Final Question
			if(questionNumber == 11)
			{
				do
				{
					askUser();
					answer = br.readLine();//Input
					
					if(answer.equalsIgnoreCase("yes"))
					{
						questionNumber += 1;
					}
					else if(!(answer.equalsIgnoreCase("no")))
					{
						displayInvalid(answer);
						pausing();
					}
				}//end of loop
				while(!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")));
			
			}
		
		}//end of loop
		while(questionNumber < 11 || questionNumber == 12);
		
		
		
		do
		{
			displayScore(score, name);
			answer = br.readLine();
			if(answer.equalsIgnoreCase("score"))
			{
				hintsUsed = 3 - hint;//Calculates number of hints used
				displayHighscore( hintsUsed, score, random, name);
				br.readLine();
			}
			else if(!(answer.equalsIgnoreCase("retry") || answer.equalsIgnoreCase("quit")))
			{
				displayInvalid(answer);
				pausing();
			
			}
		}//end of loop
		while(!(answer.equalsIgnoreCase("retry") || answer.equalsIgnoreCase("quit")));
	}//end of loop
	while(answer.equalsIgnoreCase("retry"));
		
	displayThankYou();
	br.readLine(); //Pausing
	

    }//End of main method
    
    
    
    
	//DISPLAYING TITLE METHOD
	static void displayTitle(BufferedReader br) throws Exception {		
    	System.out.println("");
       	System.out.println("");
    	System.out.println("");
        System.out.println("................................................................................................");
    	System.out.println("");
       	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("        /$$$$$$$$        /$$           /$$                   /$$ ");
    	System.out.println("       |__  $$__/       |__/          | $$                  | $$ ");
    	System.out.println("          | $$  /$$$$$$  /$$  /$$$$$$$| $$   /$$  /$$$$$$$ /$$$$$$    /$$$$$$   /$$$$$$ ");
    	System.out.println("          | $$ /$$__  $$| $$ /$$_____/| $$  /$$/ /$$_____/|_  $$_/   /$$__  $$ /$$__  $$");
    	System.out.println("          | $$| $$  \\__/| $$| $$      | $$$$$$/ |  $$$$$$   | $$    | $$$$$$$$| $$  \\__/");
    	System.out.println("          | $$| $$      | $$| $$      | $$_  $$  \\____  $$  | $$ /$$| $$_____/| $$  ");
    	System.out.println("          | $$| $$      | $$|  $$$$$$$| $$ \\  $$ /$$$$$$$/  |  $$$$/|  $$$$$$$| $$  ");
    	System.out.println("          |__/|__/      |__/ \\_______/|__/  \\__/|_______/    \\___/   \\_______/|__/ ");
    	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                  Press enter to continue");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("");	
    		
    	br.readLine();//Pausing
	}

	//DISPLAYING INSTRUCTIONS METHOD
	static void displayInstructions(BufferedReader br) throws Exception{
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                   Welcome to Trickster!");
       	System.out.println("                                   ---------------------");
       	System.out.println("");
    	System.out.println("             There are ten mindblowing trick questions, that you have to answer,");
       	System.out.println("");
    	System.out.println("                                   each worth 2 points. ");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("Press enter to continue");	
    		
    	br.readLine();//Pausing
    		
    	System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
       	System.out.println("");
       	System.out.println("");
    	System.out.println("");
       	System.out.println("");
    	System.out.println("                         If you're stuck on a question you can use a hint ");
       	System.out.println("");
    	System.out.println("             by entering the word \"hint\". However, doing so will make the question ");
       	System.out.println("");
    	System.out.println("                   worth only 1 point. You only have 3 hints so use them wisely.");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("Press enter to continue");
    	
    	br.readLine();//Pausing
    	
    	System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
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
    	System.out.println("                                      Keep in mind, that your ");
    	System.out.println("");
       	System.out.println("       answers have to be words or numbers. You don't have to capitalize your answers."); 
    	System.out.println("");
    	System.out.println("                      Also, please press enter only when you are asked to :) "); 
       	System.out.println("                                               ----");
    	System.out.println("                         With that said, press enter when you are ready.");
       	System.out.println("");
       	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("Press enter to start the quiz");
    	
    	br.readLine();//Pausing
	}

	//DISPLAYING REQUEST FOR NAME METHOD
	static void displayRequestForName() {
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
    	System.out.println("                                        What is your name?");
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
    	System.out.println("");
    	System.out.println("");
    	System.out.print("          My name is ");	
	}
	
	//DISPLAYING SCORE METHOD
	static void displayScore(int score, String name) {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println(""); 
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                   Congratulation, " +name+ ". You have finished the quiz.");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                          Your final score is:");
    	System.out.println("                              " +score+ " out of 20");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                       - enter \"score\" to see the highscore");
    	System.out.println("                       - enter \"retry\" to restart the game");
    	
    	
    	
    	
    	System.out.println("                       - enter \"quit\" to exit the game ");
    	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");	
	}
	
	// DISPLAYING NO HINT METHOD
	static void displayNoHint() {
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
    	System.out.println("");
    	System.out.println("                                    Sorry, you have no more hints.");
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
	}
	
	//DISPLAYING HIGH SCORE METHOD
	static void displayHighscore(int hintsUsed, int score, int random, String name) {
		System.out.println("");
        System.out.println("");
    	System.out.println(".......................................     HIGHSCORE      .....................................");
       	System.out.println("ooooooooooooooooooooooooooooooooooooooo                    ooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                          Name          |   score         |   hints used            ");
    	System.out.println("                         ******         |  *******        |  ************");
       	System.out.println("                                        |                 |");
    	System.out.println("                     1. Nam Nguyen      |    1,000,000    |      -5");
    	System.out.println("                                        |                 |");
    	System.out.println("                     2. Nam the Man     |    77           |      -0.5");
    	System.out.println("                                        |                 |");
    	System.out.println("                     3. Nammy Wammy     |    25           |       0");
    	System.out.println("                                        |                 |");
    	System.out.println("                     4.     Taco        |   lol wut       |      idk ");
    	System.out.println("                                        |                            |");
    	System.out.print("                    " +random+ ". "); Out.printLeft(name,16); Out.printLeft("|",5); Out.print(score,2); Out.print("|",12); Out.println(hintsUsed,8);
    	System.out.println("                                        |                 |");
    	System.out.println("                           ...          |   ...           |      ...");
    	System.out.println("                                        |                 |");
    	System.out.println("                    99. Namster         |    -0           |       11");
    	System.out.println("                                        |                 |");
    	System.out.println("                   100. No Name         |    -1,345,765   |       10e10");
    	System.out.println("                                        |                 |");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("        Press enter to go back");	
	}
	
	//METHOD FOR DISPLAYING INCORRECT
	static void displayIncorrect() {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
      	System.out.println("");
       	System.out.println("                d d s  b   sSSs.   sSSSs   d ss.  d ss.  d sss     sSSs. sss sssss ");
    	System.out.println("                S S  S S  S       S     S  S    b S    b S        S          S  ");
    	System.out.println("                S S   SS S       S       S S    P S    P S       S           S ");
    	System.out.println("                S S    S S       S       S S sS'  S sS'  S sSSs  S           S");
    	System.out.println("                S S    S S       S       S S   S  S   S  S       S           S");
    	System.out.println("                S S    S  S       S     S  S    S S    S S        S          S");
    	System.out.println("                P P    P   \"sss'   \"sss\"   P    P P    P P sSSss   \"sss'     P");
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
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");	
	}
	
	//METHOD FOR DISPLAYING CORRECT
	static void displayCorrect() {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("                       sSSs.   sSSSs   d ss.  d ss.  d sss     sSSs. sss sssss ");
    	System.out.println("                      S       S     S  S    b S    b S        S          S ");
    	System.out.println("                     S       S       S S    P S    P S       S           S ");
    	System.out.println("                     S       S       S S sS'  S sS'  S sSSs  S           S ");
    	System.out.println("                     S       S       S S   S  S   S  S       S           S");
    	System.out.println("                      S       S     S  S    S S    S S        S          S ");
    	System.out.println("                       \"sss'   \"sss\"   P    P P    P P sSSss   \"sss'     P");
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
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("................................................................................................");
    	System.out.println("");
    	System.out.print("");	
	}
	
	//ASKING USER METHOD 
	static void askUser() {
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
    	System.out.println("                                 You finished the 10 questions!");
       	System.out.println("");
    	System.out.println("                                  Howerver it's not over yet,");
       	System.out.println("");
    	System.out.println("                       There is one final question, that you can answer.");
       	System.out.println("");
    	System.out.println("                It is worth 5 points! But if you get it wrong, you lose 5 points.");
       	System.out.println("");
       	System.out.println("");
    	System.out.println("                          Do you want to do the final question? (yes/no)");
    	System.out.println("                          -------------------------------------");
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
	}
	
	//METHOD FOR DISPLAYING INVALID
	static void displayInvalid(String answer) {
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
    	System.out.println("                               Sorry, \"" +answer+ "\" is an invalid choice");
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
	}	
		
	//MOVING TEXT METHOD
    static void moveUp() throws InterruptedException{
    		
   		for(int count=1; count !=15; ++count)
   		{
   		Thread.sleep(75);
    	System.out.println("");	
   		}
    	Thread.sleep(1500);
	}
	
	//PAUSING METHOD
    static void pausing() throws InterruptedException{
    	Thread.sleep(2000);
	}
	
	//DISPLAYING THANKYOU PAGE METHOD
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
    	System.out.println("                                   Hope you enjoyed Trickster :)");
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
	}
	//QUESTION.1......................................................................
	//DISPLAYING QUESTION 1 TITLE
 	static void displayQuOneTitle()throws InterruptedException {
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
		System.out.println("                           .--.              .                    .  ");
    	System.out.println("                          :    :            _|_   o             .'|  ");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.     |  ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |     |  ");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-  '---'");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 1 METHOD
	static void displayQuestionOne(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                        If you had only one match, and entered a dark");
    	System.out.println("                          room containing an oil lamp, some newspaper, ");
    	System.out.println("                       and some kindling wood, which would you light first?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

		//DISPLAYING QUESTION 1 HINT METHOD
	static void displayQuestionOneHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                        If you had only one match, and entered a dark");
    	System.out.println("                          room containing an oil lamp, some newspaper, ");
    	System.out.println("                       and some kindling wood, which would you light first?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                       hint: What is the very first thing you must light?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	
	//QUESTION.2......................................................................
	//DISPLAYING QUESTION 2 TITLE
	static void displayQuTwoTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                   .-. ");
    	System.out.println("                          :    :            _|_   o             (   )");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.     .' ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |    /   ");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-  '---'");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 2 METHOD
	static void displayQuestionTwo(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                  A farmer had 18 sheeps, and all but 8 died. How many are left? ");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

		//DISPLAYING QUESTION 2 HINT METHOD
	static void displayQuestionTwoHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                  A farmer had 16 sheeps, and all but 8 died. How many are left? ");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                  hint:   a) 8     c) 6");
    	System.out.println("");
    	System.out.println("                          b) 2     d) 10");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}
	
	
	//QUESTION.3......................................................................
	//DISPLAYING QUESTION 3 TITLE
	static void displayQuThreeTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                  .--.");
    	System.out.println("                          :    :            _|_   o                 )");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.    --: ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |       ) ");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-  `--' ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 3 METHOD
	static void displayQuestionThree(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                         A recent scientist has claimed to be able to make");
    	System.out.println("                any object move on a straight line for a certain amount of time,");
    	System.out.println("                         then slowly stop and move the opposite direction.");
    	System.out.println("                                        How is that possible?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 3 HINT METHOD
	static void displayQuestionThreeHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                         A recent scientist has claimed to be able to make");
    	System.out.println("                any object move on a straight line for a certain amount of time,");
    	System.out.println("                         then slowly stop and move the opposite direction.");
    	System.out.println("                                        How is that possible?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                             hint: Anyone could do it...");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	
	//QUESTION.4......................................................................
	//DISPLAYING QUESTION 4 TITLE
	static void displayQuFourTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                  .  . ");
    	System.out.println("                          :    :            _|_   o             |  | ");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.   '--|-");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |      | ");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-     ' ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 4 METHOD
	static void displayQuestionFour(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                             If a doctor gives you 3 pills and tells you");
    	System.out.println("                                   to take one pill every half hour,");
    	System.out.println("                  how many hours would it take before all the pills had been taken?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 4 HINT METHOD
	static void displayQuestionFourHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                             If a doctor gives you 3 pills and tells you");
    	System.out.println("                                   to take one pill every half hour,");
    	System.out.println("                    how long would it take before all the pills had been taken?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                          hint: what time is it when you take the first pill");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	
	//QUESTION.5......................................................................
	//DISPLAYING QUESTION 5 TITLE
	static void displayQuFiveTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                  .---.");
    	System.out.println("                          :    :            _|_   o             |    ");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.   '--. ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |   .   )");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-   `-' ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 5 METHOD
	static void displayQuestionFive(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                              Before Mount Everest was discovered,");
    	System.out.println("                           what was the highest mountain in the world?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 5 HINT METHOD
	static void displayQuestionFiveHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                              Before Mount Everest was discovered,");
    	System.out.println("                           what was the highest mountain in the world?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                       hint: you don't need to know any names of mountains");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	
	//QUESTION.6......................................................................
	//DISPLAYING QUESTION 6 TITLE
	static void displayQuSixTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                     , ");
    	System.out.println("                          :    :            _|_   o               / ");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.    /-. ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |   (   )");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-   `-'");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 6 METHOD
	static void displayQuestionSix(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                  If you divide 30 by half and add ten. What do you get?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 6 HINT METHOD
	static void displayQuestionSixHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                  If you divide 30 by half and add ten. What do you get?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                hint: dividing by 1/2 which is the same as multiplying by 2/1");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}


	//QUESTION.7......................................................................
	//DISPLAYING QUESTION 7 TITLE
	static void displayQuSevenTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                  .---.");
    	System.out.println("                          :    :            _|_   o                 / ");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.      / ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |     / ");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-   '   ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 7 METHOD
	static void displayQuestionSeven(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                 Larry's father has five sons named Ten, Twenty, Thirty, Forty...");
    	System.out.println("                            Guess what would be the name of the fifth?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 7 HINT METHOD
	static void displayQuestionSevenHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                 Larry's father has five sons named Ten, Twenty, Thirty, Forty...");
    	System.out.println("                            Guess what would be the name of the fifth?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                  hint: Read the question again.");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}
	
	
	//QUESTION.8......................................................................
	//DISPLAYING QUESTION 8 TITLE
	static void displayQuEightTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                   .-. ");
    	System.out.println("                          :    :            _|_   o             (   )");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.    >-< ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |   (   )");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-   `-' ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 8 METHOD
	static void displayQuestionEight(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("             Some months have 31 days, others have 30 days. How many have 28 days?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 8 HINT METHOD
	static void displayQuestionEightHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("             Some months have 31 days, others have 30 days. How many have 28 days?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                        hint: January has 28 days");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	
	//QUESTION.9......................................................................
	//DISPLAYING QUESTION 9 TITLE
	static void displayQuNineTitle()throws InterruptedException {
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
    	System.out.println("                           .--.              .                   .-. ");
    	System.out.println("                          :    :            _|_   o             (   )");
    	System.out.println("                          |    |.  . .-. .--.|    .  .-. .--.    `-/ ");
    	System.out.println("                          :  ( ;|  |(.-' `--.|    | (   )|  |     /  ");
    	System.out.println("                           `--`-`--`-`--'`--'`-'-' `-`-' '  `-   '   ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 9 METHOD
	static void displayQuestionNine(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                       There is an ancient invention still used in some parts");
    	System.out.println("                     of the world today that allows people to see through walls. ");
    	System.out.println("                                             What is it?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 9 HINT METHOD
	static void displayQuestionNineHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                       There is an ancient invention still used in some parts");
    	System.out.println("                     of the world today that allows people to see through walls. ");
    	System.out.println("                                             What is it?");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                     hint: this invention allows light to pass through the wall");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	
	//QUESTION.10......................................................................
	//DISPLAYING QUESTION 10 TITLE
	static void displayQuTenTitle()throws InterruptedException {
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
		System.out.println("                         .--.              .                    .    .-. ");
    	System.out.println("                        :    :            _|_   o             .'|   :   :");
    	System.out.println("                        |    |.  . .-. .--.|    .  .-. .--.     |   |   |");
    	System.out.println("                        :  ( ;|  |(.-' `--.|    | (   )|  |     |   :   ;");
    	System.out.println("                         `--`-`--`-`--'`--'`-'-' `-`-' '  `-  '---'  `-' ");
    	
    	moveUp();
	}

	//DISPLAYING QUESTION 10 METHOD
	static void displayQuestionTen(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                          What is the product of the following series? ");
    	System.out.println("                            (X-A) x (X-B) x (X-C) x (X-D)....(X-Z)");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//DISPLAYING QUESTION 10 METHOD
	static void displayQuestionTenHint(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                          What is the product of the following series? ");
    	System.out.println("");
       	System.out.println("           hint: here's the whole expression");
      	System.out.println("");
    	System.out.println("           (X-A) x (X-B) x (X-C) x (X-D) x (X-E) x (X-F) x (X-G) x (X-H) x (X-I) x  ");
       	System.out.println("");
    	System.out.println("           (X-J) x (X-K) x (X-L) x (X-M) x (X-N) x (X-O) x (X-P) x (X-Q) x (X-R) x "); 
       	System.out.println("");
    	System.out.println("           (X-S) x (X-T) x (X-U) x (X-V) x (X-W) x (X-X) x (X-Y) x (X-Z)");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}

	//FINAL.QUESTION...................................................................
	//DISPLAYING FINALQUESTION TITLE
	static void displayFinalQuTitle()throws InterruptedException {
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
    	System.out.println("                    .---.             .     .--.              .                  ");
    	System.out.println("                    |    o            |    :    :            _|_   o             ");
    	System.out.println("                    |--- .  .--. .-.  |    |    |.  . .-. .--.|    .  .-. .--.   ");
    	System.out.println("                    |    |  |  |(   ) |    :  ( ;|  |(.-' `--.|    | (   )|  |   ");
    	System.out.println("                    '  -' `-'  `-`-'`-`-    `--`-`--`-`--'`--'`-'-' `-`-' '  `-  ");
    	
    	moveUp();
	}

	//DISPLAYING FINAL QUESTION METHOD
	static void displayFinalQuestion(int score, int hint, String name)  {
		System.out.println("");
        System.out.println("");
    	System.out.println("................................................................................................");
       	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("");
       	System.out.println(" " +name);
    	System.out.println("  score: " +score);
    	System.out.println("  hints: " +hint);
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                      What was the answer to the first question you were asked?");
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
    	System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
    	System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	System.out.println(".........                 ......................................................................");
    	System.out.println("          Your answer is:");
    	System.out.print("                    ");	
	}
	
	


}//End of class

		
/*
 	questions
 	1.If you had only one match, and entered a dark room containing an oil lamp, some newspaper, and some kindling wood, which would you light first?
 	2.A farmer had 18 sheeps, and all but 8 died. How many are left? 
 	3.A recent scientist has claimed to be able to make any object move on a straight line for a certain amount of time, then slowly stop and move the opposite direction. How is that possible?
 	4.If a doctor gives you 3 pills and tells you to take one pill every half hour, how long would it take before all the pills had been taken?
 	5.Before Mount Everest was discovered, what was the highest mountain in the world? 
 	6.If you divide 30 by half and add ten. What do you get?
 	7.Larry's father has five sons named Ten, Twenty, Thirty, Forty...Guess what would be the name of the fifth? 
 	8.Some months have 31 days, others have 30 days. How many have 28 days? 
 	9.There is an ancient invention still used in some parts of the world today that allows people to see through walls. What is it? 
 	10.What is the product of the following series? (X-A) x (X-B) x (X-C) x (X-D)....(X-Z)
 	final. What was the first question asked in the quiz?
 	
 	problems
 misspelled .equals to . euqals	
 named two methods the same name
 logic problem: using hint -1, fix by creating variable, if use hint variable has vale of 1 and if user gets question wrong no negative number
 */
 	