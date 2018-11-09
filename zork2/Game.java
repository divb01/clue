/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author:  Michael Kolling
 * Version: 1.1
 * Date:    March 2000
 * 
 * Modified by: April Schermann
 * Date:        October 2018
 * 
 * Modified by: Amy Feeney
 * Date:        November 2018
 * 
 *  This class is the main class of the "Zork" application. Zork is a very
 *  simple, text based adventure game.  Users can walk around some scenery.
 *  That's all. It should really be extended to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  routine.
 * 
 *  This main class creates and initializes all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates the
 *  commands that the parser returns.
 */
import java.util.Scanner;
class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    /**
     * Create the game and initialize its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room study, hall, lounge, billiard, library, dining, conservatory, ballroom, kitchen, 
        wineCellar, bowlingAlley, storage, movie, catacombs, morgue, hallway1, hallway2, 
        hallway3, hallway4, hallway5, hallway6, hallway7, hallway8, hallway9, hallway10, 
        hallway11, hallway12, hallway13, hallway14, hallway15, hallway16, hallway17,
        hallway18, hallway19, hallway20, hallway21, hallway22, hallway23, hallway24, hallway25;
      
        // create the rooms
        study = new Room("the study room");
        hall = new Room("the hall");
        lounge = new Room("the lounge room");
        billiard = new Room("the billiard room");
        library = new Room("the stairs to go downstairs");
        dining = new Room("the dining room");
        conservatory = new Room("the conservatory");
        ballroom = new Room("the ballroom");
        kitchen = new Room("the kitchen");
        wineCellar = new Room("the wine cellar");
        bowlingAlley = new Room("the bowling alley");
        storage = new Room("the storage room");
        movie = new Room("the movie room");
        catacombs = new Room("the catacombs");
        morgue = new Room("the morgue");
        hallway1 = new Room("the hallway");
        hallway2 = new Room("the hallway");
        hallway3 = new Room("the hallway");
        hallway4 = new Room("the hallway");
        hallway5 = new Room("the hallway");
        hallway6 = new Room("the hallway");
        hallway7 = new Room("the hallway");
        hallway8 = new Room("the hallway");
        hallway9 = new Room("the hallway");
        hallway10 = new Room("the hallway");
        hallway11 = new Room("the hallway");
        hallway12 = new Room("the hallway");
        hallway13 = new Room("the hallway");
        hallway14 = new Room("the hallway");
        hallway15 = new Room("the hallway");
        hallway16 = new Room("the hallway");
        hallway17 = new Room("the hallway");
        hallway18 = new Room("the hallway");
        hallway19 = new Room("the hallway");
        hallway20 = new Room("the hallway");
        hallway21 = new Room("the hallway");
        hallway22 = new Room("the hallway");
        hallway23 = new Room("the hallway");
        hallway24 = new Room("the hallway");
        hallway25 = new Room("the hallway");
        // initialise room exits
        // main level
        study.setExits(null, hallway1, hallway3, null, null, null);
        hall.setExits(null, hallway2, hallway5, hallway1, null, null);
        lounge.setExits(null, null, hallway7, hallway6, null, null);
        billiard.setExits(hallway3, hallway8, hallway10, null, null, null);
        library.setExits(hallway5, hallway9, hallway12, hallway8, null, null);
        dining.setExits(hallway7, null, hallway14, hallway9, null, null);
        conservatory.setExits(hallway10, hallway15, null, null, null, null);
        ballroom.setExits(hallway12, hallway16, null, hallway15, null, null);
        kitchen.setExits(hallway14, null, null, hallway16, null, null);
        
        
        //basement
        wineCellar.setExits(hallway17, hallway23, null, null, null, null);
        bowlingAlley.setExits(hallway17, hallway20, null, null, null, null);
        storage.setExits(hallway24, null, null, null, null, null);
        movie.setExits(hallway18, hallway21, null, null, null, null);
        catacombs.setExits(hallway21, hallway19, null, null, null, null);
        morgue.setExits(hallway22, hallway19, null, null, null, null);
        
        //hallways
        hallway17.setExits(null, bowlingAlley, hallway18, wineCellar, null, null);
        hallway18.setExits(hallway17, hallway23, hallway19, hallway22, null, null);
        hallway19.setExits(hallway18, movie, hallway20, null, null, null);
        hallway20.setExits(hallway19, hallway24, hallway21, morgue, null, null);
        hallway21.setExits(hallway20, hallway23, hallway19, hallway22, null, null);
        hallway22.setExits(wineCellar, hallway18, null, null, null, null);
        hallway23.setExits(bowlingAlley, null, movie, hallway18, null, null);
        hallway24.setExits(null, hallway20, morgue, null, null, null);
        hallway25.setExits(movie, null, catacombs, hallway20, null, null);
        
        

        currentRoom = library;  // start game in library
    
        
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Goodbye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Clue!");
        System.out.println("You're objective is to figure out who the murderer is.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.longDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("butler") || commandWord.equals("call"))
            {System.out.println("Good evening, player one. How may I help you?  (Simply say bye to the butler to return to the game)");
                Butler buddy = new Butler();
                Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		while (!statement.equals("Bye") && !statement.equals("bye") && !statement.equals("goodbye"))
		{System.out.println (buddy.getResponse(statement));
			statement = in.nextLine();}
			System.out.println("Goodbye, player. Good luck, because you'll need it. ");
             }
        else if (commandWord.equals("quit"))
        {
            if(command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
        }
        return false;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are trying to find the murderer");
        System.out.println("in this mansion...");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord())
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else 
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.longDescription());
        }
    }
}
