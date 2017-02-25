
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JFrame;

	/**
	 * This class is the GUI to be used for project 2
	 * @author Sample Project
	 *
	 */
	public class Project4GUI extends JFrame {
	/**
	 * This constructor intializes a GUI that contains a grid layout with three columns
	 * The column on the left contains an unsorted array, the middle a sorted array, and
	 * the right a sorted linked list
	 * 
	 * @param t The title of the GUI
	 * @param presort The unsorted array to be displayed
	 * @param postsort The sorted array to be displayed
	 * @param wl The word list to be displayed
	 */
		public Project4GUI (String t,TreeMap <String, String>, HashMap <string, String>){
			setTitle(t);
			setSize(400,300);
			setLocation(200,200);
			
			
			Container contentPane = getContentPane();
			JTextArea right = new JTextArea();
			TextArea left = new JTextArea();
			//TextArea list = new TextArea();
			setLayout(new GridLayout(1,2));
			contentPane.add(right, BorderLayout.EAST);
			contentPane.add(left, BorderLayout.WEST);
			
			hashToTextArea(hash, left);
			treeToTextArea(tree, right);
			setDefaultCloseOperation(Project4GUI.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		//method to put hash words to text area
		public void hashToTextArea(HashMap<String, String> hash, Jtextarea L){
			
			for(int i = 0; i < postsort.length; i++){
				if(presort[i] != null){
					unsorted.append(presort[i] + "\n");
				}//if
			}//while loop
			

			for (int k = 0; k < postsort.length ; k++){
				if(postsort[k] !=null) {
					sorted.append(postsort[k] + "\n");
				}//if
			}//for loop
			//uses the method addToTextArea to add content of the list to the TextArea
			wl.toTextArea(list);

		}//constructor
	
		public void createMenu(){
			JMenuBar menuBar  = new JMenuBar();
			   JMenu fileMenu = new JMenu("File");//create file on menubar
			   JMenuItem item;//items under file
			   FileMenuHandler fmh  = new FileMenuHandler(this);
			   item = new JMenuItem("Open"); 
			   item.addActionListener( fmh );
			   fileMenu.add( item );
			   fileMenu.addSeparator(); 
			   item = new JMenuItem("Quit"); 
			   item.addActionListener( fmh );
			   fileMenu.add( item );
			   setJMenuBar(menuBar);
			   menuBar.add(fileMenu);
			} //createMenu

	public void createMenu2(){
	JMenuBar menuBar  = new JMenuBar();
	   JMenu fileMenu = new JMenu("Display");//create file on menubar
	   JMenuItem item;//items under file
	   FileMenuHandler fmh  = new FileMenuHandler(this);
	   item = new JMenuItem("Noun"); 
	   item.addActionListener( fmh );
	   fileMenu.add( item );
	   fileMenu.addSeparator(); 
	   item = new JMenuItem("Verb"); 
	   item.addActionListener( fmh );
	   fileMenu.add( item );
	   setJMenuBar(menuBar);
	   menuBar.add(fileMenu);
	} //createMenu




	}//class


