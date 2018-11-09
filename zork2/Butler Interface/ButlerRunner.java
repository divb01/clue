package Clue;

/**
 * Ethan Potts
 * AP Compsci Java
 */

 
import java.util.Scanner;
public class ButlerRunner
{
	public static void main(String[] args)
	{
		Butler buddy = new Butler();
		
		System.out.println (buddy.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("Bye"))
		{
			System.out.println (buddy.getResponse(statement));
			statement = in.nextLine();
		}
		if(statement == ("bye") || statement == ("Bye") || statement == ("BYE") || statement == ("goodbye"))
		{
		    //return to game
		}
	}

}