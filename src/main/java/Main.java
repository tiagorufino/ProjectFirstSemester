package main.java;
import main.java.commons.AppConstants;
import main.java.view.ViewProject;

/**
 * Main class. Call the view class.
 * 
 * @author Tiago Rufino
 */
public class Main {
	
	/**
	 * Main class. Just call the view.
	 * @param args
	 */
	public static void main (String args[]){
		//LOG
		System.out.println(AppConstants.LOG + AppConstants.INITIATING);
		System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+AppConstants.Methods.MAIN);
    	ViewProject.creatingTheFrame();
	}
	
}
