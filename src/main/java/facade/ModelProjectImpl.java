package main.java.facade;


/**
 * ArrayList - Implements using array the List
 * Collections - Implements some arrays 'functions'
 * List - Cares about the list collections
 * 
 * JFrame, JOptionPane - Explain in the VIewProject
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.java.commons.AppConstants;
import main.java.commons.AppConstants.Methods;
import main.java.commons.AppConstants.Numbers;

/**
 * Model Class. Controller class which has the encrypt and decrypt methods.
 * @author Tiago Rufino
 */
public class ModelProjectImpl implements ModelProject{

	/**
	 * SuperClass constructor
	 */
	public ModelProjectImpl() {
		super();
	}

	/**
	 * The encrypt/decrypt method. The same is use for the encrypt and decrypt. The difference is the order of the signs.
	 * In encrypt mode, base is plan and encode is de cypher. In decrypt mode, base is the cypher and the encode is base.
	 * 
	 * @param input - Input
	 * @param base - Based which has the information to compare
	 * @param encode - Code which will be changed
	 * @return String [] vector of strings with the output and the error
	 */
	public String[] encryptDecrypt(String input, String base, String encode) {
		
		//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.ENCRYPTDECRYPT);
		
		String output = AppConstants.EMPTY;
		String buffer = AppConstants.EMPTY;
		String erros = AppConstants.EMPTY;
		for (int i = AppConstants.Numbers.ZERO; i< input.length(); i++) {
			for (int j = AppConstants.Numbers.ZERO; j < base.length(); j++) {
				if (input.charAt(i)==base.charAt(j)){
					buffer += encode.charAt(j);
					break;
				}
			}
			if (buffer.isEmpty()){
				erros += input.charAt(i) + AppConstants.ESPACE;
			} else {
				output += buffer;
				buffer = AppConstants.EMPTY;
			}
			
		}
		
		return new String[]{output, erros};
	}
	
	/**
	 * Shuffle the string in randomly way. very time you run the app will exist a new encode.
	 * 
	 * @return String - A encode.
	 */
	public String shuffleString(){
		
		//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.SHUFFLESTRING);
		
		char[] caracteres = AppConstants.BASE.toCharArray();
		List<Character> ocharaters  = new ArrayList<Character>(caracteres.length);
		for (char c:  caracteres ){
		  ocharaters.add(c);
		}
		Collections.shuffle(ocharaters);
		for ( int i = AppConstants.Numbers.ZERO; i < caracteres.length ; i++ ){
		     caracteres[i] = ocharaters.get(i);
		}
		return new String(caracteres);
	}
	
	/**
	 * Return the characters not found in the data base.
	 * 
	 * @param returns - Returns vectors where the first position is the encrypt/decrypt information and the 
	 * second position what wasn't found(error).
	 * 
	 * @param frame - Frame use to build the msg
	 */
	public void exceptions(String[] returns, JFrame frame) {
		
		//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.EXCEPTIONS);
		
		if(returns!=null && !returns[1].isEmpty()){
			JOptionPane.showMessageDialog(frame, AppConstants.ERROR +AppConstants.NEXT_LINE+ returns[AppConstants.Numbers.ONE]);
		}
	}
}