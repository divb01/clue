package Clue;

/**
 * Ethan Potts
 * Clue Game 
 * AP java
 */

 
import java.util.Scanner;
public class Butler extends ButlerRunner

{
    public String getGreeting()
    {
        return "Good evening, player one. How may I help you?  (Simply say bye to the butler to return to the game)";
    }
    public String getResponse(String statement)
    {   Scanner in= new Scanner (System.in);

        String response = "";
        if (statement.length() == 0)
            
            {response = "Say something, please.";}
            
        else if (findKeyword(statement, "no") >= 0)
        
                {response = "Why so negative? I'm trying to help you solve the mystery.";}
    
        
        else if (findKeyword(statement, "who is") >= 0)
        
                {response = "I am not sure who the murderer is.";}
                
        else if (findKeyword(statement, "clue") >= 0)        
                
                { int NUMBER_OF_CLUES = 3;
                double r = Math.random();
                int whichClue = (int) (r * NUMBER_OF_CLUES);
                String giveClue = "";
                        if(whichClue == 0)
                        {response = "Oh... so you would like a clue.\nWithin the walls of this mansion lies a key, a key to help you solve the mystery.\n" +  
                        "Ask the people hiding in each room if they know where that key is.";}
                        else if(whichClue == 1)
                        {response = "This mansion is bigger than you could ever imagine.\nBelow your feet there is a basement containing the remains of"
                         + " countless bodies.\nIf I were searching for a murderer, that would be the first place I'd look.";}
                        else if(whichClue == 2)
                        {response = "In each room of this masion a person is hiding.\nMost are innocent, but one, one of them is a murderer.\n"
                         + "Keep searching the house to find the murderer before the murderer finds you...";}
                }        
                
        else if (findKeyword(statement, "I like") >= 0)
                {response = "Why do you like" + statement.substring(6) + "?";}
                
        else
                {response = getRandomResponse();}   
        return response;
    }
    private int findKeyword(String statement, String goal,
    int startPos)
    {
        String phrase = statement.trim();
       
        int psn = phrase.toLowerCase().indexOf(
                goal.toLowerCase(), startPos);

        while (psn >= 0)
        {
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn)
                .toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                    psn + goal.length(),
                    psn + goal.length() + 1)
                .toLowerCase();
            }
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) 
            
            && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }
            psn = phrase.indexOf(goal.toLowerCase(),
                psn + 1);

        }

        return -1;
    }
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "I'm not sure what you're asking, player.";
        }
        else if (whichResponse == 1)
        {
            response = "I can't answer that. But I can tell you that you're safety is at great risk right now.";
        }
        else if (whichResponse == 2)
        {
            response = "Somewhere in this mansion a murderer lurks,\nso you saying silly things like this is just delaying your inevitable death.";
        }
        else if (whichResponse == 3)
        {
            response = "Shhh! did you see that?? Behind you! A shadow lurks...";
        }
        else if (whichResponse == 4)
        {
            response = "Stop saying dumb things. Your time is ticking...";
        }
        else if (whichResponse == 5)
        {
            response = "You're not very good at this game. The murderer is much smarter than you. Pick it up.";
        }

        return response;
    }
    

}