
/* NOUN class

*/
 public class Noun extends Word {

	public Noun (String n) {
		//constructor in an inheritance situation
		super(n); //superclass
	}
	public String ToString(){
		return theWord + "(n)"; //puts its a verb after word

	}

			}

/*----------------------------------------------------------------
 VERB class
 */


public class Verb extends Word{
    
    public Verb (String v){
        //constructor in an inheritance situation
        super(v); //superclass
    }
    public String ToString(){
        return theWord + "(v)"; //puts its a verb after word
        
    }
    
}




