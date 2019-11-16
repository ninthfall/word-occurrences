
//Author Name: Xue Ying Ou
//Date: 11/13/2019
//Program Name: Ou_module10_javadoc
//Purpose: adding JavaDoc to word occurrences application 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * Module 10 Assignment 
 * 
 * @author Xue Ying Ou
 *
 */

public class Ou_module10_javadoc extends Application {


	@Override
	public void start(Stage stage) throws Exception {

		// code for text analyzer
		// create http://shakespeare.mit.edu/macbeth/full.html url
		URL text = new URL("http://shakespeare.mit.edu/macbeth/full.html");
		BufferedReader in = new BufferedReader(new InputStreamReader(text.openStream()));

		// lists for storage
		List<Pair<String, Integer>> list = new ArrayList<Pair<String, Integer>>();
		List<String> wordList = new ArrayList<String>();


		// remove html tags, space, punctuation
		// place individual words into String list
		String inputLine;
		while ((inputLine = in.readLine()) != null) {

			String str = inputLine.replaceAll("<.*?>", "");
			String str1 = str.replaceAll("<.*", "");
			String str2 = str1.replaceAll(".*>", "");
			String str3 = str2.replaceAll("[,|\\.|:|;|!|?|-]", "");
			String[] split = str3.trim().split("\\s+");

			for (int i = 0; i < split.length; i++) {
				if (split[i].matches("\\S+")) {
					wordList.add(split[i]);
				}
			}
		}


		// Count words in String list and put results into Pair list
		String word;
		String word2;
		int wordCount;
		Boolean addWord;
		for (int i = 0; i < wordList.size(); i++) {
			addWord = true;
			wordCount = 0;
			word = wordList.get(i);
			for (int j = 0; j < wordList.size(); j++) {
				word2 = wordList.get(j);
				if (word2.equalsIgnoreCase(word)) {
					wordCount++;
				}
			}

			for (Pair<String, Integer> temp : list) {
				if (word.equalsIgnoreCase(temp.getKey())) {
					addWord = false;
				}
			}

			if (addWord) {
				list.add(new Pair<String, Integer>(word, wordCount));
			}

		}


		// sort Pair list from most to least by word count
		Collections.sort(list, new Comparator<Pair<String, Integer>>() {
			@Override
			public int compare(final Pair<String, Integer> list1, final Pair<String, Integer> list2) {
				if (list1.getValue() > list2.getValue()) {
					return -1;
				} else if (list1.getValue() < list2.getValue()) {
					return 1;
				} else {
					return 0;
				}
			}
		});



		// print Pair list results
		// int numbering = 0;
		// for (Pair<String, Integer> temp : list) {
		// numbering++;
		// System.out.println(numbering + ". " + temp.getKey() + " " +
		// temp.getValue());
		// }

		// put pairs into arrays
		String[] wordsArray = new String[20];
		int[] wordsArrayCounts = new int[20];

		int numbering = 0;
		for (Pair<String, Integer> temp : list) {
			wordsArray[numbering] = temp.getKey();
			wordsArrayCounts[numbering] = temp.getValue();
			numbering++;

			if (numbering == 20)
				break;
		}

		in.close();

		// text
		Text text1 = new Text();
		text1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
		text1.setText("Top 20 words in the play: Tragedy of Macbeth");

		// create gridpane
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(400, 200);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.setAlignment(Pos.CENTER);

		// put word and wordcounts in text
		Text word1 = new Text("Word: " + wordsArray[0]);
		Text wordCount1 = new Text("Count: " + Integer.toString(wordsArrayCounts[0]));
		Text word_2 = new Text("Word: " + wordsArray[1]);
		Text wordCount2 = new Text("Count: " + Integer.toString(wordsArrayCounts[1]));
		Text word3 = new Text("Word: " + wordsArray[2]);
		Text wordCount3 = new Text("Count: " + Integer.toString(wordsArrayCounts[2]));
		Text word4 = new Text("Word: " + wordsArray[3]);
		Text wordCount4 = new Text("Count: " + Integer.toString(wordsArrayCounts[3]));
		Text word5 = new Text("Word: " + wordsArray[4]);
		Text wordCount5 = new Text("Count: " + Integer.toString(wordsArrayCounts[4]));
		Text word6 = new Text("Word: " + wordsArray[5]);
		Text wordCount6 = new Text("Count: " + Integer.toString(wordsArrayCounts[5]));
		Text word7 = new Text("Word: " + wordsArray[6]);
		Text wordCount7 = new Text("Count: " + Integer.toString(wordsArrayCounts[6]));
		Text word8 = new Text("Word: " + wordsArray[7]);
		Text wordCount8 = new Text("Count: " + Integer.toString(wordsArrayCounts[7]));
		Text word9 = new Text("Word: " + wordsArray[8]);
		Text wordCount9 = new Text("Count: " + Integer.toString(wordsArrayCounts[8]));
		Text word10 = new Text("Word: " + wordsArray[9]);
		Text wordCount10 = new Text("Count: " + Integer.toString(wordsArrayCounts[9]));
		Text word11 = new Text("Word: " + wordsArray[10]);
		Text wordCount11 = new Text("Count: " + Integer.toString(wordsArrayCounts[10]));
		Text word12 = new Text("Word: " + wordsArray[11]);
		Text wordCount12 = new Text("Count: " + Integer.toString(wordsArrayCounts[11]));
		Text word13 = new Text("Word: " + wordsArray[12]);
		Text wordCount13 = new Text("Count: " + Integer.toString(wordsArrayCounts[12]));
		Text word14 = new Text("Word: " + wordsArray[13]);
		Text wordCount14 = new Text("Count: " + Integer.toString(wordsArrayCounts[13]));
		Text word15 = new Text("Word: " + wordsArray[14]);
		Text wordCount15 = new Text("Count: " + Integer.toString(wordsArrayCounts[14]));
		Text word16 = new Text("Word: " + wordsArray[15]);
		Text wordCount16 = new Text("Count: " + Integer.toString(wordsArrayCounts[15]));
		Text word17 = new Text("Word: " + wordsArray[16]);
		Text wordCount17 = new Text("Count: " + Integer.toString(wordsArrayCounts[16]));
		Text word18 = new Text("Word: " + wordsArray[17]);
		Text wordCount18 = new Text("Count: " + Integer.toString(wordsArrayCounts[17]));
		Text word19 = new Text("Word: " + wordsArray[18]);
		Text wordCount19 = new Text("Count: " + Integer.toString(wordsArrayCounts[18]));
		Text word20 = new Text("Word: " + wordsArray[19]);
		Text wordCount20 = new Text("Count: " + Integer.toString(wordsArrayCounts[19]));

		// add content
		gridPane.add(text1, 0, 0);
		GridPane.setColumnSpan(text1, 4);
		gridPane.add(word1, 0, 1);
		gridPane.add(wordCount1, 1, 1);
		gridPane.add(word_2, 0, 2);
		gridPane.add(wordCount2, 1, 2);
		gridPane.add(word3, 0, 3);
		gridPane.add(wordCount3, 1, 3);
		gridPane.add(word4, 0, 4);
		gridPane.add(wordCount4, 1, 4);
		gridPane.add(word5, 0, 5);
		gridPane.add(wordCount5, 1, 5);
		gridPane.add(word6, 0, 6);
		gridPane.add(wordCount6, 1, 6);
		gridPane.add(word7, 0, 7);
		gridPane.add(wordCount7, 1, 7);
		gridPane.add(word8, 0, 8);
		gridPane.add(wordCount8, 1, 8);
		gridPane.add(word9, 0, 9);
		gridPane.add(wordCount9, 1, 9);
		gridPane.add(word10, 0, 10);
		gridPane.add(wordCount10, 1, 10);
		gridPane.add(word11, 2, 1);
		gridPane.add(wordCount11, 3, 1);
		gridPane.add(word12, 2, 2);
		gridPane.add(wordCount12, 3, 2);
		gridPane.add(word13, 2, 3);
		gridPane.add(wordCount13, 3, 3);
		gridPane.add(word14, 2, 4);
		gridPane.add(wordCount14, 3, 4);
		gridPane.add(word15, 2, 5);
		gridPane.add(wordCount15, 3, 5);
		gridPane.add(word16, 2, 6);
		gridPane.add(wordCount16, 3, 6);
		gridPane.add(word17, 2, 7);
		gridPane.add(wordCount17, 3, 7);
		gridPane.add(word18, 2, 8);
		gridPane.add(wordCount18, 3, 8);
		gridPane.add(word19, 2, 9);
		gridPane.add(wordCount19, 3, 9);
		gridPane.add(word20, 2, 10);
		gridPane.add(wordCount20, 3, 10);

		// stage and scene
		Scene scene = new Scene(gridPane);
		stage.setTitle("Module 7 Word Occurrence");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * This is the main method for launching the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		launch(args);

	}
}
