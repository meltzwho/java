//Yim Yim
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvilHangman{
	
	//fields SPELT PROPERLY
	private ArrayList<String> tempList=new ArrayList<String>();
	private Map<String, String> wordMap=new HashMap<String, String>();
	private Map<String, Integer> patternMap=new HashMap<String, Integer>();
	private int guesses;
    private boolean knowsWordsLeft;
    private boolean correct=false;
    private String used = "";
    private String status= "";
    
    //constructor
    public EvilHangman(int wordLength, int guesses, boolean knowsWordsLeft, ArrayList<String> wordList) {
    	for (int i = 0; i < wordLength; i ++){
    	    status = status + '-';
        }
    	this.guesses = guesses;
        this.knowsWordsLeft = knowsWordsLeft;
        for(String word: wordList){
    		tempList.add(word);
        }
    }
    
    //public method "play"
    public void play(){
    	for( int i = guesses; i > 0 ; i--){
    		System.out.println("Number of guesses left: " + i);
    		if (knowsWordsLeft){
    			System.out.println("Possible words left: " + tempList.size());
        		System.out.println("Possible words left: " + tempList.toString());
    		}
    		System.out.println("Correct Letters: "+status);
    		System.out.println("Letters used: "+used);
    		char letter = getGuess();
    		map(letter);
    		String pattern=maxPatternOccurs();
    		changeList(pattern);
    		status(pattern);
    		if(tempList.size()==1&&status.equals(tempList.get(0))){
    			correct=true;
    			break;
    		}
    	}
    	if (!correct && knowsWordsLeft){
    		System.out.println("Words Remaining: "+tempList.size());
    	}
    	if(correct){
    		System.out.println("Congratulations you won!!!\nword was: " +tempList.get(0));
		}
    	System.out.println("Game over");
    }
    
    //private methods
    //returns valid guesses only
    //error - repeated letter entry
    private char getGuess(){
		System.out.print("<Letter> >> ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str= str.toLowerCase();
		char ch = str.charAt(0); 
		for(char c: used.toCharArray()){
			if(c==ch){
				System.out.println("Error: letter already guessed");
				return getGuess();
				}
		}
		used = used+ch;
		return ch;
	}

    //maps possible patterns
    private void map(char letter){
		for(String word: tempList){
			String pattern="";
			for(int i=0;i<word.length();i++){
				if(word.charAt(i)==letter)
					pattern+=letter;
				else
					pattern+='-';
				}
			//map every words pattern 
			wordMap.put(word, pattern);
			//map every pattern occurrences
			try{
			patternMap.put(pattern, patternMap.get(pattern)+1);
			}
			catch(NullPointerException ex){
				patternMap.put(pattern, 1);
			}
		}
	}

    //find largest word family
    private String maxPatternOccurs(){
		int max=0;
		String maxP="";
		for(String pattern: patternMap.keySet()){
			if(patternMap.get(pattern)>max){
				max=patternMap.get(pattern);
				if(max!=0)
					maxP=pattern;
			}
		}
		return maxP;
	}

    //switch to largest list
    private void changeList (String str){
		tempList.clear();
		for(String word: wordMap.keySet()){
			if(wordMap.get(word).equals(str))
				tempList.add(word);
				
		}
		wordMap.clear();
		patternMap.clear();
	} 

   //updates correct guesses
	private void status(String pattern){
		char[] tempStatus=status.toCharArray();
		char[] tempPattern=pattern.toCharArray();
    	status="";
	    for(int i=0;i<tempPattern.length;i++){
	    	if(tempPattern[i]!='-')
	    		if(tempStatus[i]=='-')
	    			tempStatus[i]=tempPattern[i];
	    	status+=tempStatus[i];
	    }
	}
}
