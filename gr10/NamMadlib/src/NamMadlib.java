 /**
 * @(#)NamHalloweenMadlib.java
 *
 * NamHalloweenMadlib application
 * this program takes words from a user and puts them in a story creating unique and often funny story each time
 * author: Nam Nguyen 
 * @version 1.00 
 * started: 2012/10/5
 * ended: 2012/11/2
 */
 
//allows for input
import java.io.*;

public class NamMadlib {
    
    public static void main(String[] args)throws Exception {
    	
    	
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	int age = 17;
    	System.out.println("Happy"+(++age)+"Birthday!!");br.readLine();
    	//variables
    	String monster, person, ppronoun, object,  city;
    	String adj1, bodypart, animal, shape;
    	String adj2;
    	String adj3, object2, object3;
    	String adj4, adj5;
    	int num2;
    	long num1;
    	
    	//required dimension of window
    	System.out.print("\n\n\n\n\n\n\n\n\n\n               Before proceding make sure that the dimensions of the window are:");
    	System.out.println("                                                      width - 97");
    	System.out.println("                                       height - 33");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("                            to continue please press enter");
    	br.readLine();
    	
    	// Title page
       	System.out.println("");
       	System.out.println("");
    	System.out.println("                *               *                             *                         *");
    	System.out.println("");
    	System.out.println("                  *                           * ");
    	System.out.println("      _   _         _  _                                       _   _  _         _      _   ");
    	System.out.println("     | | | |       | || |                                     | \\ | |(_)       | |    | |  ");
    	System.out.println("     | |_| |  __ _ | || |  ___  __      __  ___   ___  _ __   |  \\| | _   __ _ | |__  | |_ ");
    	System.out.println("     |  _  | / _` || || | / _ \\ \\ \\ /\\ / / / _ \\ / _ \\| '_ \\  | . ` || | / _` || '_ \\ | __|");
    	System.out.println("     | | | || (_| || || || (_) | \\ V  V / |  __/|  __/| | | | | |\\  || || (_| || | | || |_ ");
    	System.out.println("     \\_| |_/ \\__,_||_||_| \\___/   \\_/\\_/   \\___| \\___||_| |_| \\_| \\_/|_| \\__, ||_| |_| \\__|");
    	System.out.println("                                                                          __/ | ");
    	System.out.println("     *                                      *                            |___/   ");
    	System.out.println("");
    	System.out.println("                        *             _________                                     *");
    	System.out.println("                                    .//////////                    *");
    	System.out.println("                                  /////////");
    	System.out.println("           *                    ////////|");
    	System.out.println("                               |////////");
    	System.out.println("                              //////////");
    	System.out.println("                              |||||||||                                                 *");
    	System.out.println("                             //////////            *");
    	System.out.println("                 *           |\\\\\\\\\\\\\\\\                           *");
    	System.out.println("                  *           \\||||||||||                 *");
    	System.out.println("                             \\\\\\\\\\||||[ ");
    	System.out.println("                              |||||||||\\                                                   ");
    	System.out.println("                                \\\\\\\\\\\\\\\\\\_____ ");
    	System.out.println("     *                           \\\\\\\\\\\\\\\\\\\\\\\\/                 *");
    	System.out.println("                    *               \\\\\\\\\\\\\\\\\\ ");
    	System.out.println(""); 
       	System.out.println("         *                        *                  *  *                     *                    ");
    	System.out.println("");
    	System.out.print("press enter to continue");
    	br.readLine();

	
    	// Instructions
    	System.out.println("");
    	System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-");
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
    	System.out.println("                                   Welcome to Nams madlib!");
    	System.out.println("");
    	System.out.println("         You will be asked random questions, to which you have to answer. Afterwards, your");
    	System.out.println("");
    	System.out.println("         answers will be inserted in a text creating a unique and humorous Halloween story.");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                                               _     ");
    	System.out.println("                                   ___ ___    (_)__  __ __");
    	System.out.println("                                  / -_) _ \\  / / _ \\/ // /");
    	System.out.println("                                  \\__/_//_/_/ /\\___/\\_, / ");
    	System.out.println("                                         |___/     /___/");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-");
    	System.out.print("to continue press enter");
    	br.readLine();
    	System.out.print("\n\n");
		System.out.println("          QUESTIONS:");
		
    		//word input 
       	System.out.println("If you had a dog what would you name it?");
       	System.out.print("\t");
    	person=br.readLine();
    	System.out.println("Think of a magical creature from your dreams. Now type it in.");
    	System.out.print("\t");
    	monster=br.readLine();

    	System.out.println("If there was a fire and you are allowed to save one object, which one would it be?\n(except for yourself)");
    	System.out.print("\t");
    	object=br.readLine();
    	System.out.println("Which possesive pronoun refers to you: his or her?");
    	System.out.print("\t");
    	ppronoun=br.readLine();
    	System.out.println("What is your dream place you want to live in?");
    	System.out.print("\t");
    	city=br.readLine();
    	
    	System.out.println("How old are you?");
    	System.out.print("\t");
    	num1=Long.parseLong(br.readLine()); 
    		
    	System.out.println("How would you describe pepperoni pizza in terms of taste?");
    	System.out.print("\t");
    	adj1=br.readLine();
    	System.out.println("If you were hit by " + object + " what body part would you rather get hit?");
    	System.out.print("\t");
    	bodypart=br.readLine();
    	System.out.println("     You are halfway done answering.");
    	System.out.println("What is your favourite animal?(add a or an before)");
    	System.out.print("\t");
    	animal=br.readLine();
    	System.out.println("What is your favourite geometric shape?");
    	System.out.print("\t");
    	shape=br.readLine();
    	
    	System.out.println("What is your favourite numberbetween between 1-100");
    	System.out.print("\t");
    	num2=Integer.parseInt(br.readLine());
    	System.out.println("How would you describe abstract art?");
    	System.out.print("\t");
    	adj2=br.readLine();
    	
    	System.out.println("Enter adjective discribing your appearance");
    	System.out.print("\t");
    	adj3=br.readLine();
    	System.out.println("Name one material used in building a house");
    	System.out.print("\t");
    	object3=br.readLine();
    	System.out.println("Name a random insect?");
    	System.out.print("\t");
    	object2=br.readLine();
    
    	System.out.println("     This is the last question :)");
    	System.out.println("Enter adjective describing green cheese.");
    	System.out.print("\t");
    	adj4=br.readLine();
    	
    		// page 1
    	System.out.println("");
    	System.out.println("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
       	System.out.println("");
    	System.out.println("");
    	System.out.println("              	              ,____                         ");
    	System.out.println("                                |---.\\                    .--.  ");
    	System.out.println("                        ___     |    `                   /  ..\\ ");
    	System.out.println("                       / .-\\  ./=)                  ____.'  _o/  ");
    	System.out.println("                      |  |\"|_/\\/|                   '--.     |.__ ");
    	System.out.println("                      ;  |-;| /_|                   _.-'     /--' ");
    	System.out.println("                     / \\_| |/ \\ |              _.--'        /                .--.  ");
    	System.out.println("                    /      \\/\\( |             ~'--....___.-'                | = o\\  ");
    	System.out.println("                    |   /  |` ) |                                           \\= =_/    ");
       	System.out.println("                    /   \\ _/    |                                            )= \\____ ");
    	System.out.println("                   /--._/  \\    |                                           ; = _|__-\\  ");
    	System.out.println("                   `/|)    |    /                                           |= ----.\\");
    	System.out.println("                     /     |   |                                            ('.==| ");
    	System.out.println("                   .'      |   |                                           / \\=\\=\\ ");
    	System.out.println("                  /         \\  |                                        _.'  /=/\\=\\_ ");
    	System.out.println("                 (_.-.__.__./  /       It was Halloween,             ..-'    /__) \\__) ");  
      	System.out.println("");
    	System.out.println("          an awful night. Vampires, trolls, zombies, ghosts and other monsters ");
    	System.out.println("               came out to scare people. Only " + person + " was not scared.");
    	System.out.println("                        He took " + ppronoun + " " + object + " and set for");
    	System.out.println("           the haunted streets of " + city + " . Not long after, he met a group of ");
    	System.out.println("                                                                           zombies.");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.print("to continue press enter");
    	br.readLine();

    		// page 2
    	System.out.println("");
    	System.out.println("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_"); 
    	System.out.println("");
    	System.out.println("                                                                           __");
    	System.out.println("            .--.               .--.                                       /c \\");
    	System.out.println("              = o\\             | = o\\                             -=      \\ _/");
    	System.out.println("            \\= =_/             \\= =_/                           -=     __ /(  /(");
    	System.out.println("            )= \\____           )= \\____                       -=      /--/ \\\\// ");
    	System.out.println("           ; = _|__-\\         ; = _|__-\\                          __ )/ /\\/ \\/");
       	System.out.println("           |= ----.\\          |= ----.\\                           -.\\  //\\\\");
    	System.out.println("           ('.==|             ('.==|                                \\\\//  \\\\");
    	System.out.println("          / \\=\\=\\            / \\=\\=\\                                 \\/    \\\\");
    	System.out.println("       _.'  /=/\\=\\_       _.'  /=/\\=\\_                                      \\\\");
    	System.out.println("    .-'    /__) \\__)   .-'    /__) \\__)                                      —-`");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("                There were " + num1 + " zombies and they were ");
    	System.out.println("                      looking for some " + adj1 + " brains. They ");
    	System.out.println("                             were coming closer and closer. " + person);
    	System.out.println("                    threw the " + object + " at the closest zombie.");
    	System.out.println("                         The " + object + " got stuck in the zombie's");
    	System.out.println("                      "+ bodypart + " . Disarmed, " + person);
    	System.out.println("                          was forced to run. " + person + " ran as fast as ");
    	System.out.println("                      " + animal + " . He ran in " + shape +"s" );
    	System.out.println("                   to confuse the zombies and then sprinted into the forest.");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.print("to continue press enter");
    	br.readLine();

	 
    		// page3
    	System.out.println("");
    	System.out.println("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.println("");
    	System.out.println("                         [[[[[[[[\\_(X)_/]]]]]         ");
    	System.out.println("                 .-.     /-_--__-/_--_-\\-_--\\          ");
    	System.out.println("                 |=|    /-_---__/__-__-_\\__-_\\         ");
    	System.out.println("             . . |=| ._/-__-__\\===========/-__\\_       ");
    	System.out.println("             !!!!!!!!!\\========[ /]]|[[\\ ]=====/       ");
    	System.out.println("            /-_--_-_-_[[[[[[[[[||==  == ||]]]]]]       ");
    	System.out.println("           /-_--_--_--_|=  === ||=/^|^\\ ||== =|       	"+ person + " thought that he ");
    	System.out.println("          /-_-/^|^\\-_--| /^|^\\=|| | | | ||^\\= |     	got away. And he got away");
    	System.out.println("         /_-_-| | |-_--|=| | | ||=|_|_|=||\"|==|       	just to find the monster");
    	System.out.println("        /-__--|_|_|_-_-| |_|_|=||______=||_| =|            straight from his");
    	System.out.println("       /_-__--_-__-___-|_=__=_.`---------'._=_|__   nightmares: the " + monster + ".");
    	System.out.println("      /-----------------------\\===========/-----/        	" + person + "");
    	System.out.println("     ^^^\\^^^^^^^^^^^^^^^^^^^^^^[[|]]|[[|]]=====/       was running "	+ num2 + " mph");
    	System.out.println("         |.' ..==::'\"'::==.. '.[ /~~~~~\\ ]]]]]]]      (slightly slower than");
    	System.out.println("         | .'=[[[|]]|[[|]]]=`._||==  =  || =\\ ]  	the " + monster + ") and was getting");
    	System.out.println("         ||== =|/ _____ \\|== = ||=/^|^\\=||^\\ ||          really tired.");
    	System.out.println("         || == `||-----||' = ==|| | | |=|| |=||      Luckily, there was a " + adj2 + "");
    	System.out.println("         ||= == ||:^s^:|| = == ||=| | | || |=||    	        hut  nearby.");
    	System.out.println("         || = = ||:___:||= == =|| |_|_| ||_|=||       " + person + " entered the");
    	System.out.println("        _||_ = =||o---.|| = ==_||_= == =||==_||_         hut and locked the doors");
    	System.out.println("        \\__/= = ||:   :||= == \\__/[][][][][]\\__/       ");
    	System.out.println("        [||]= ==||:___:|| = = [||]\\\\//\\\\//\\\\[||]       ");
    	System.out.println("         }{- --'\"'-----'\"'- -- }{\\//\\\\//\\\\//\\}{        ");
    	System.out.println("      __[==]__________________[==]\\\\//\\\\//\\\\[==]_      ");
    	System.out.println("     |`|~~~~|================|~~~~|~~~~~~~~|~~~~||     ");
    	System.out.println("     |^| ^  |================|^   | ^ ^^ ^ |  ^ ||     ");
    	System.out.println("");
    	System.out.print("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.print("to continue press enter");
    	br.readLine();
    	
    		// page4
       	System.out.println("");
    	System.out.println("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.println("");
    	System.out.println("          ___");
    	System.out.println("        .'   `\"-._");
    	System.out.println("       / ,        `'-.-.");
    	System.out.println("      / /`'.       ,' _ \\ ");
    	System.out.println("     `-'    `-.  ,' ,'\\\\/ ");
    	System.out.println("               \\, ,'  ee`-.            The inside of the hut was dark and creepy. ");
       	System.out.println("               / ./  ,(_   \\      ,       In the middle stood a big cauldron and a " + adj3);
    	System.out.println("              (_/\\\\\\ \\__|`--'     ||     witch was stirring a hot boiling soup inside it. ");
    	System.out.println("              ///\\\\|     \\        ||  Upon seeing " + person + " the witch's face brightened.");
    	System.out.println("              ////||-./`-.}    .--||      She rarely has guests on Halloween nights. " + person );
    	System.out.println("                 /     `-.__.-`_.-.|   sat there in awkward  silence watching ");
    	System.out.println("                 |      '._,-'`|___}    `;   the witch throw in " + object2 + "s , " + object3);
    	System.out.println("                 /   '.        |/ || ,;'`   and head of " + animal + " into the cauldron.");
    	System.out.println("                 |     '.__,.-`   || ':,       Suddenly  3 loud knocks sounded at the door.");
    	System.out.println("                 |       |        || ,;'");
    	System.out.println("                 /       /     _,.||oOoO.,_");
    	System.out.println("                |        |     \\-.O,o_O..-/");
    	System.out.println("               /         /     /          \\");
    	System.out.println("              |         /     /            \\");
    	System.out.println("              |         |    |      ,       |");
    	System.out.println("              /         |    \\   ) (     )  /");
    	System.out.println("             |           \\   ,'.(:, ),: (_.'.");
    	System.out.println("            /            /'.' =\"`\"\"=\"=\"==\"= '.");
    	System.out.println("           `'\"---'-.__.'\"\"\"`    ` \"\" \"\" `\"\"");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.print("to continue press enter");
    	br.readLine();

    		// page5
    	System.out.println("");
    	System.out.println("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("          	                                                     ____");
    	System.out.println("                                                                    |    |");
    	System.out.println("           O    ~O  O   O_  ~O    _O   O   ~O  O   O_  ~O     O     |    |");
    	System.out.println("          /|\\   /|\\ |\\ /|   /|\\    |\\ /|\\  /|\\ |\\ /|   /|\\   /|\\    |   o|");
    	System.out.println("           |\\   /|  |\\  |\\   |\\   /|   |\\  /|  |\\  |\\   |\\   /|     |    |");
    	System.out.println("           |/  / |  / | | \\  | | / |   |/ / |  / | | \\  |/  / |     |____|");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("           "+ person + " knew who it was and shouted,\"don't open the door\". But the witch");
    	System.out.println("      eager to see another guest opened the door. The " + monster + " and his friend monsters");
    	System.out.println("              entered and surrounded " + person + ". They were really hungry and were ");
    	System.out.println("           about to eat him when suddenly the witch interrupted them by inviting everyone");
    	System.out.println("                to the table for a " + adj4 + " soup. No one refused the offer and in");
    	System.out.println("                     a while the soup was served. Everyone loved it, except for");
    	System.out.println("                      " + person + ". But he was thankful that he was still alive.");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    	System.out.print("to continue press enter");
    	br.readLine();

    		// thank you and credit page
    	System.out.println("");
    	System.out.println("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
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
    	System.out.println("                          I hoped you liked the story you created. ");
    	System.out.println("         If you have any questions or thoughts about my madlib you can send me an email on:");
    	System.out.println("                                        Nam.Nguyen@ham.ca");
    	System.out.println("");
    	System.out.println("                                             Credits");
    	System.out.println("                                     Ascii art by Joan Stark");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.println("");
    	System.out.print("_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_2_");
    }
}

/** 4 Broblems:
*In the line "br.readline" L had to be capitalised
*forgot to end a line with ';'
*used wrong back slash '/' instead of '\' for quotation marks: /"(wrong), \"(right)
*couldn't turn input into integer with "=br.readLine()" with Chirag's assistance fixed the problem by using the "=Integer.parseInt(br.readLine());"
*/