import java.awt.TextArea;
import java.util.LinkedList;

/**
 * This class is word list, it will be a linked list used in Project2
 * @author Sample Project
 *
 */
public class WordList{
	
	public WordNode first = new WordNode(null);
	public WordNode last = first;
	public int length = 0;
/**
 * this method returns the length of the word list
 */
	public int getLength(){
	return length;
	}//get length

	/**
	 * adds the word d, to the end of the list
	 * @param d the word to be added to the list
	 */
	public void append(Word d){
		WordNode n = new WordNode(d);
		last.next = n;
		last = n;
		length++;
	}//append
	/**
	 * this method prints out the elements of a list
	 */
	public void printList(){
		WordNode p = first.next;
		while(p != null){
			System.out.println(p.data);
			p = p.next;
		}//while
	}//printlist
	/**
	 * This method checks to see if a word is in the list
	 * @param s the word to check
	 * @return true if word is there, false if not
	 */
	public boolean contains(Word s){
		WordNode curr = first.next;
		while (curr != null){
			if (curr.data.equals(s)) return true;
			curr = curr.next;
		}///while
		return false;
	}//contains
	
	/**
	 * Adds the wordList to a textArea, to be displayed in a GUI
	 * @param t the textArea where the list will be added to
	 */
	public void toTextArea(TextArea t){
		WordNode p = first.next;
		while(p != null){
			t.append(p.data + "\n");
			p = p.next;
		}
	}//method
	/**
	 * This method adds the String s, into a sorted list
	 * the method uses some ideas I found online, to help me understand
	 * how linked list work
	 * @param s the word to be added to the list
	 */
	public void addMiddle(Word s){
		WordNode n = new WordNode(s);
		WordNode p = first.next;
		//adds new word to front of list, if thats where it belongs
		if(p.data.theWord.compareTo(n.data.theWord) > 0){
			n.next = p;
			first.next = n;
			return;
		}//if
		//the node curr is used, to represent what comes after the new word, while p
		//represents what comes previously
		WordNode curr = first.next.next;
		//adds new word between first and second Node, if that is where it belongs
		if(p.data.theWord.compareTo(n.data.theWord) < 0 && curr.data.theWord.compareTo(n.data.theWord) > 0){
			p.next = n;
			n.next = curr;
			return;
		}//if
		
		if (curr.data.theWord.compareTo(n.data.theWord) < 0){
			//this while loops finds where the new word belongs in the list
			while (curr.data.theWord.compareTo(n.data.theWord) < 0 && curr.next != null){
				curr = curr.next;
				p = p.next;
			}//while
			//this if statement places the word last, if thats where it belongs
			if(curr.data.theWord.compareTo(n.data.theWord) < 0 && curr.next == null){
				curr.next = n;
				curr = curr.next;
				p = p.next;
			}//if
			else{
				p.next = n;
				n.next = curr;
			}//else
		}//outer if
		
		//increases length
		length++;
	}//addMiddle
	
	/**
	 * Removes a word from the list
	 * @param s the word to be deleted
	 */
	public void removeNode(Word s){
		//only runs the body of the method if the word, is on list
		if(contains(s)){
		WordNode p = first.next;
			if(p.data.equals(s)){
				first.next = p.next;
				p.next = null;
			}//if
			else if (!p.data.equals(s)){
				WordNode curr = first.next.next;
				while(!curr.data.equals(s)){
					curr = curr.next;
					p = p.next;
				}//while
				p.next = curr.next;
				curr.next = null;
			}//else
		}// if contains
		else return;
	}//removeNode
}//class
