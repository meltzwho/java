import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EvilHangmanGUI extends Application{
	
	CheckBox knowsWordsLeft=new CheckBox("Know words left?");
	TextField wordLength=new TextField("Word length?"),
			guesses=new TextField("Number of guesses?"),
			guessIn=new TextField("Guess?");
	Button play=new Button("Play"),
			reset=new Button("Reset"),
			guess=new Button("Guess");
	Label gameControlLabel=new Label("Game controls"),
			guessControlLabel=new Label("Guess controls");
	boolean inProgress=false;
	EvilHangmanGUI_Logic eh;
	
	public void start(Stage stg){
		
		BorderPane root=new BorderPane();
		
		gameControlLabel.setTextFill(Color.GREEN);
		VBox gameControls=new VBox(1, gameControlLabel,knowsWordsLeft,wordLength,guesses,play,reset);
		gameControls.setAlignment(Pos.CENTER);
		
		guessControlLabel.setTextFill(Color.GREEN);
		VBox guessControls=new VBox(1, guessControlLabel,guessIn,guess);
		guessControls.setAlignment(Pos.CENTER);
		
		VBox allControls=new VBox(50, gameControls, guessControls);
		allControls.setAlignment(Pos.CENTER);
		
		VBox usedArea=new VBox();
		
		root.setRight(allControls);
		root.setBottom(usedArea);
		root.setPadding(new Insets(10,10,10,10));
		root.setBackground(new Background(new BackgroundFill(Color.GAINSBORO,null,null)));
		
		play.setOnAction(e->{
			if(!inProgress)
			buildGame(root);
		});
		
		reset.setOnAction(e->{
			inProgress=false;
			root.setTop(null);
			root.setBottom(null);
			root.setCenter(null);
			wordLength.setText("Word length?");
			guesses.setText("Number of guesses?");
			knowsWordsLeft.setSelected(false);
			guessIn.setText("Guess?");
		});
		
		guess.setOnAction(e->{
			if(inProgress){
				if(eh.guesses>0)
					outer:do{
						char ch = guessIn.getText().charAt(0);
						ch=Character.toLowerCase(ch);
						if(!Character.isLetter(ch)){
							root.setTop(new Label("error: guess isn't a letter"));
							break outer;
						}
						for(char c: eh.used.toCharArray()){
							if(c==ch){
								root.setTop(new Label("error: letter already guessed"));
								break outer;
							}
						}
						eh.used = eh.used+ch;
						eh.guesses=eh.guesses-1;
						guesses.setText(""+eh.guesses);
						eh.play(ch);
						root.setTop(null);
						usedArea.getChildren().clear();
						root.setBottom(usedArea);
						usedArea.getChildren().add(new Label("Letters used: "+eh.used));
						root.setCenter(new Label("Letters correct: "+eh.status));
						if(eh.knowsWordsLeft)
							usedArea.getChildren().add(new Label("Possible words left: " + eh.tempList.size()));
					}while(false);
			}
			else
				root.setTop(new Label("error: must create game first"));
		});
		
		Scene sc=new Scene(root,700,500);
		stg.setScene(sc);
		stg.setTitle("Evil Hangman");
		stg.setResizable(false);
		stg.show();
	}
	
	public void buildGame(BorderPane root){
		Set<Integer> wordLengths = new TreeSet<>();			
		ArrayList<String> wordList=new ArrayList<>();
		try{
			wordLengths = getWordLengths();
			if(wordLengths.contains(Integer.parseInt(wordLength.getText())))
				wordList= getWordList(Integer.parseInt(wordLength.getText()));
			else
				root.setTop(new Label("error: no words of that length"));
			if(Integer.parseInt(guesses.getText())<Integer.parseInt(wordLength.getText())||Integer.parseInt(guesses.getText())>26){
				root.setTop(new Label("Guesses must be greater or equal to word length and less than 27"));
			}
			else if(!wordList.isEmpty()){
				root.setTop(new Label("game build successful"));
				eh = new EvilHangmanGUI_Logic(Integer.parseInt(wordLength.getText()), Integer.parseInt(guesses.getText()),knowsWordsLeft.isSelected(), wordList);
				inProgress=true;
			}
		}
		catch(FileNotFoundException ex){
			root.setTop(new Label("error: dictionary.txt is missing\n"+ex.toString()));
		}
		catch(NumberFormatException ex){
			root.setTop(new Label("error: "+ex.toString()));
		}
		
	}
	
	public Set<Integer> getWordLengths() throws FileNotFoundException  {
		Scanner sc = new Scanner(new File("dictionary.txt"));
	        Set<Integer> wordLengths = new TreeSet<Integer>();
	        while (sc.hasNext())
		    wordLengths.add(sc.next().length());
		return wordLengths;
	    }
	
	public ArrayList<String> getWordList(int length) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("dictionary.txt"));
		ArrayList<String> result = new ArrayList<String>();
		while (sc.hasNext()) {
			String word = sc.next();
			if (word.length() == length)
				result.add(word);
		}
		return result;
	}
	public static void main(String args[]){
		launch(args);
	}
}
