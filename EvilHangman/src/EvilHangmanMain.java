
import java.util.*;
import java.io.*;

public class EvilHangmanMain {



    public static void main (String [] args) throws FileNotFoundException {
        // get the possible word lengths
        Set<Integer> wordLengths = getWordLengths();
	// get the length of word the player wants
        int wordLength = getWordLength(wordLengths);
	// get the number of guesses the player wants
        int guesses = getGuesses(wordLength);
	// ask the player if they want to know the words that
	// the system is still considering
	boolean knowsWordsLeft = getKnowWordsLeft(wordLength);
        // get all words from the dictionary of the correct length
	ArrayList<String> wordList = getWordList(wordLength);
        // Construct an instance of the game that gives the player
	// a word of length "wordLength" to guess in "guesses" guesses,
	// with information about how many words the system is still
	// considering  if "knowsWordsLeft" is true. "wordList"
	// is the starting list of candidate words all of the correct length
	// "wordLength".
        EvilHangman eh = new EvilHangman(wordLength, guesses,
                                         knowsWordsLeft, wordList);
        // Tell the game to start playing
        eh.play();
    }

    // Parameter: The length of word the player is guessing
    // Returns: A list of all the words in the dictionary with the given length
    public static ArrayList<String> getWordList(int length) 
                                        throws FileNotFoundException {
	Scanner sc = new Scanner(new File("dictionary.txt"));
	ArrayList<String> result = new ArrayList<String>();
	while (sc.hasNext()) {
	    String word = sc.next();
	    if (word.length() == length)
		result.add(word);
	}
	return result;
    }

    // Parameter: The length of word the player is guessing
    // Returns: true if the player wants to know the number of words the
    //          system is still considering at any point of play, false o/w
    // Postcondition: Prompts the user to see if he/she wants to know the
    //                words still under consideration by the system on each
    //                turn
    public static boolean getKnowWordsLeft(int length) {
        System.out.print("Do you want to know the number of " + 
                           "candidate words left of length " + length + "? " +
                           "y/n: ");
	Scanner sc = new Scanner(System.in);
        char answer = sc.next().charAt(0);
	return answer == 'Y' || answer == 'y';
    }

    // Returns: the number of guesses the play wants
    // Postcondition: Prompts the player for the number of guesses he/she
    //                wants until a positive value has been entered
    public static int getGuesses(int wordLength) {
	System.out.print("Enter the number of guesses you want to make: " );
	Scanner sc = new Scanner(System.in);	
	int guesses = sc.nextInt();
	while (guesses < wordLength||guesses >= 27) {
	    System.out.println("Guesses must be greater or equal to word length and less than 27.");
            System.out.print("Enter the number of guesses you want to make: " );
	    guesses = sc.nextInt();
	}
	return guesses;
    }

    // Parameter: The set of word lengths that are actually in the dictionary
    // Returns: the length of word the player wants to guess
    // Postcondition: Prompts the player for a word length until the player
    //                enters a word length that is in the set of word lengths
    public static int getWordLength(Set<Integer> wordLengths) {

	System.out.print("Enter word length you want to guess: " );
	Scanner sc = new Scanner(System.in);
	int wordLength = sc.nextInt();
	while (!wordLengths.contains(wordLength)) {
             System.out.println("There are no words that length." );
             System.out.print("Enter word length you want to guess: " );
             wordLength = sc.nextInt();
	}
	return wordLength;
    }

    // Returns: a set of all the word lengths found in the dictionary read
    //          from the file "dictionary.txt"
    // Throws: FileNotFoundException - if the file "dictionary.txt" is not in
    //         this directory/folder
    public static Set<Integer> getWordLengths() throws FileNotFoundException  {
	Scanner sc = new Scanner(new File("dictionary.txt"));
        Set<Integer> wordLengths = new TreeSet<Integer>();
        while (sc.hasNext())
	    wordLengths.add(sc.next().length());
	return wordLengths;
    }
}
