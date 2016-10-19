package ch02.stringLogs;
//Modified by: Eric Meltzer
//----------------------------------------------------------------------------
// UseStringLog.java           by Dale/Joyce/Weems                   Chapter 2
//
// Simple example of the use of a StringLog.
//----------------------------------------------------------------------------

public class UseStringLog
{
  public static void main(String[] args)
  { 
	  LinkedStringLog<Integer> intLog=new LinkedStringLog<Integer>("intLog");
	  intLog.insert(3);
	  intLog.insert(2);
	  intLog.insert(1);
	  System.out.println(intLog.toString());
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