
public class UnsortedWordList extends WordList{

	public void append(Word d) {
		WordNode n = new WordNode(d);
		last.next = n;
		last = n;
		length++;
	}
}

