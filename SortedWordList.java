
public class SortedWordList extends WordList {


//insert() method

public void addMiddle(Word s){
	WordNode n = new WordNode(s);
	WordNode p = first.next;
	//adds new word to front of list, if thats where it belongs
	if(p.data.theWord.compareTo(n.data.theWord) > 0){
		n.next = p;
		first.next = n;

		return;
	}
}
}