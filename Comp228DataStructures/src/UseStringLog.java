//Modified by: Eric Meltzer
//----------------------------------------------------------------------------
// UseStringLog.java           by Dale/Joyce/Weems                   Chapter 2
//
// Simple example of the use of a StringLog.
//----------------------------------------------------------------------------
import ch02.stringLogs.*;

public class UseStringLog
{
  public static void main(String[] args)
  { 
    StringLogInterface Movies;
    Movies = new ArrayStringLog("Movies");
    Movies.insert("The Bourne series");
    Movies.insert("Taken");
    Movies.insert("Charlie and the Chocolate Factory (Gene Wilder - 1970 version)");
    Movies.insert("Sausage Party");
    Movies.insert("Fast and Furious");
    Movies.insert("The Girl with the Dragon Tattoo (Swedish Original series)");
    Movies.insert("Forrest Gump?");

    System.out.println(Movies);
    System.out.println("The size of the log is " + Movies.size());
    System.out.println("The Great Escape is in the log: " + Movies.contains("The Great Escape"));
    System.out.println("The Empire Strikes Back is in the log: " + Movies.contains("The Empire Strikes Back"));
    System.out.println("Rosencrantz & Guildenstern Are Dead is in the log: " + Movies.contains("Rosencrantz & Guildenstern Are Dead"));    
  }
  /*
Log: Movies

1. The Bourne series
2. Taken
3. Charlie and the Chocolate Factory (Gene Wilder - 1970 version)
4. Sausage Party
5. Fast and Furious
6. The Girl with the Dragon Tattoo (Swedish Original series)
7. Forrest Gump?

The size of the log is 7
The Great Escape is in the log: false
The Empire Strikes Back is in the log: false
Rosencrantz & Guildenstern Are Dead is in the log: false
*/
}