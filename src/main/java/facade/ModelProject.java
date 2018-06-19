package main.java.facade;


/**
 * JFrame - Detail in the ViewProject class
 */
import javax.swing.JFrame;

/**
 * Interface of the control
 * 
 * @author Tiago Rufino
 *
 */
public interface ModelProject {
	
	public String[] encryptDecrypt(String input, String base, String encode);

	public String shuffleString();
	
	public void exceptions(String[] returns, JFrame frame);
}
