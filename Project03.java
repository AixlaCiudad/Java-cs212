/*
 Aixla Ciudad CS212 Lab Professor Di Wu Lab section D
 For this project, the program displays a GUI with two text areas:  the one on left showing the contents of the unsorted list, and the one on the right showing the contents of the sorted list. The program reads in a file using TextfileInput and is read line by line.As the words are read the program decides if it is a noun or verb and displayed on a verb list or noun list.
 
 There are three classes for the linked list,an abstract class called WordList which contains all the functionality of the linked list, and classes called UnsortedWordList and SortedWordList which inherit from WordList. Each of these two classes have an insert method that adds a new word in the appropriate position on the list.
import javax.swing.JOptionPane;


import java.util.Collection;
import java.util.StringTokenizer;
/**
 * 
 * @author Sample Project
 *
 */
public class Project03 {

	public static void main(String[] args){
		
		//Program uses the TextFileInput.java file from Lab5
				//Creates an instance of TextFileInput for the import file
				TextFileInput in = new TextFileInput("InputFile.txt");
				
				//Creates an Array for all valid words, uses large size, for adding 
				//words later on in the project
				String[] wordArray = new String[85];
				//creates the wordlist		
				WordList wl = new WordList();
				
				//index allows you to place a word into the next open index of an array
				//by keeping track of what that is
				int index = 0;
				
				//initializes the string nextLine for the first line of the InputFile
				String nextLine = in.readLine();
				
				//While loop ensures that all lines from the input file are read
				
				while(nextLine != null){
			
					//Uses the method isAlpha to separate between valid words, and invalid words
			//printing invalids to the console, and adding valids to wordArray
					
					if (isAlpha(nextLine) == false){
						System.out.println(nextLine);
					}//if
					
					else {
						wordArray[index] = nextLine;
						index++;
					}//else
					
						nextLine = in.readLine();	
				}//while loop
				
				//creates the array for the sorted list containing all the elements of the unsorted array
				String[] sorted = new String[85];
				for(int i = 0; i<index+1; i++) sorted[i] = wordArray[i];
				
				//double for-loop does selection sort.
				for (int i = 0; i < index - 1; ++i){
					
					//int i lets us know what place in the array we are up to
					//minIndex represents the location of the lowest(earliest in alphabet)
					//String not yet sorted
					int minIndex = i;
					
					//Test all other elements not yet sorted to see if lower
					//than current minIndex
					for (int j = i + 1; j < index; ++j){
						
					//If element j is lower than element minIndex, it replaces it as the new minIndex
						if (sorted[j].compareTo(sorted[minIndex]) < 0) minIndex = j;
					}//inner for loop
					
					//switches around two elements to put them in order
						String temp = sorted[i];
						sorted[i] = sorted[minIndex];
						sorted[minIndex] = temp;
				}//outer for loop
				//while loops adds the elements of the sorted array into the word list
				int k = 0;
				while (sorted[k] != null){
					wl.append(sorted[k]);
					k++;
				}//while
				
		//creates a new GUI by using the constructor for Project2GUI
		Project3GUI display = new Project3GUI("Sorted words", wl);
		//Dispose on Close so that the program runs after the GUI is closed
		display.setDefaultCloseOperation(Project3GUI.DISPOSE_ON_CLOSE);
		display.setVisible(true);
		
		//Allows the user to input additional words or delete words to/from the string
		String command = JOptionPane.showInputDialog(null,"Enter a command");
		
		//set to lower case for easy comparisons
		command.toLowerCase();
		
		//if statement ensures valid command is entered.
		if(!command.startsWith("add") && !command.equals("stop") && !command.startsWith("delete")){
			JOptionPane.showMessageDialog(null, "invalid command");
			System.exit(0);
		}//if
		
			//while loop makes the process repeat until the word stop comes in
		while(!command.equalsIgnoreCase("stop")){
			
			//This next block deals with what to do once a new word is added
			if(command.startsWith("add")){
				//if only one word is to be added (i.e. no ',' special code to be uses
				//to add one word
				if (!command.substring(4).contains(",")){
					wordArray[index] = command.substring(4);
					wl.addMiddle(command.substring(4));
					sorted[index] = command.substring(4);
					index++;
				}
			
				else{
				//StringTokenizer helps delineate words
			//substring method is used to exclude the word add from being added to the list
			StringTokenizer st = new StringTokenizer(command.substring(4),",");
			//index variable from before, so we can add right to the end of the array
			
			//for loop adds the words to the old arrays and the list
			for(int i = 0; i < st.countTokens() + 2;i++){
			String nextWord = st.nextToken();
			wordArray[index] = nextWord;
			wl.addMiddle(nextWord);
			sorted[index] = nextWord;
			index++;
				}//for
			}// else
			
			//the next block uses selection sort, for the sorted array
			for(int i = 0; i < index - 1; i++){
				int indexLowest = i;
				for (int l = i + 1; l < index; l++){
					if(sorted[l].compareToIgnoreCase(sorted[indexLowest]) < 0) indexLowest = l;
				}
				if (sorted[indexLowest] != sorted[i] ){
				String temp = sorted[indexLowest];
				sorted[indexLowest] = sorted[i];
				sorted[i] = temp;
				}//if
				
			}//SelectionSort
			Project3GUI test = new Project3GUI("New List", wl);
			test.setVisible(true);
			}//if
			
			//what happens when first word is delete
			if(command.startsWith("delete")){
				//if only one word is to be deleted (i.e. no ',' special code to be uses
				//to delete one word
				if (!command.substring(7).contains(",")){
					String wordToDelete = command.substring(7);
					wordArray = removeWord(wordArray,wordToDelete);
					wl.removeNode(wordToDelete);
					sorted = removeWord(sorted,wordToDelete);
					index--;
				}//if
				else {
				//StringTokenizer helps delineate words
				//substring method is used to exclude the word add from being added to the list
				StringTokenizer st = new StringTokenizer(command.substring(7),",");
				//index variable from before, so we can add right to the end of the array
				
				//for loop adds the words to the old arrays and the list
				for(int i = 0; i < st.countTokens() + 2;i++){
				String nextWord = st.nextToken();
				wordArray = removeWord(wordArray, nextWord);
				wl.removeNode(nextWord);
				sorted = removeWord(sorted,nextWord);
				index--;
				}//for
				}//else
				
				Project3GUI test = new Project3GUI("New List", wl);
				test.setVisible(true);
			}//if
			
			command = JOptionPane.showInputDialog(null,"Enter a command");
			if(!command.startsWith("add") && !command.equals("stop") && !command.startsWith("delete")){
				JOptionPane.showMessageDialog(null, "invalid command");
				System.exit(0);
			}//if
		}//while loop
		
	}//main
	

 */
		public static boolean isAlpha(String name) {
		    return name.matches("[a-zA-Z]+");
		}//end method

		public static String[] removeWord(String[] array, String s){
			int lengthOld = 1;
			while (array[lengthOld] != null){
				lengthOld++;
			}
			//newArray is at large length because user might want to add words later
			String[] newArray = new String[85];
			int index = 0;
			//goes through original array looking for word s, if word in index i, does not
			//equal s, than that word is copied into the new Array
			for(int i = 0; i < lengthOld; i++){
				if(!array[i].equalsIgnoreCase(s)){
					newArray[index] = array[i];
					index++;
				}
			}
			return newArray;
		}
}//class
		