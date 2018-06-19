package main.java.commons;


/**
 * Class of Strings
 * @author Tiago Rufino
 */
public interface AppConstants {
	
	String APP_NAME = "ENCRYPT/DECRYPT APP";
	
	String BASE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	String BASE_W_ESPACE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	
	String BASE_JAPONESE = "\u304A\u306F\u3088\u3045!";
	
	String CALLINGMETHOD = "Calling the method...";
	
	String CHOOSE_OPTION = "Choose a Option: ";
	
	String DECRYPT = "decrypt";
	
	String DECRYPT_U = "Decrypt";
	
	String EMPTY = "";
	
	String ENCRYPT = "encrypt";
    
	String ENCRYPT_U = "Encrypt";
	
	String ESPACE = " ";
	
	String ERROR = "This characteres weren't found in our database:";
	
	String EXIT = "exit";
	
	String EXIT_U = "Exit";
    
    String INFORMATION_DOESNT_FIND = "It isn't possible to find the letter: %s in our database. Sorry. Please try again.";
    
    String INITIATING = "Iniciating the program...";
    
    String INPUT = "Please insert the information: ";
    
    String FINISH = "Thank you for used the app. See you.";
    
    String LOG = "Log...";
    
    String NEXT_LINE = "\n";
    
    String OK = "OK";
    
    String REDO_ENCRYPT = "Would you like to Encrypt other code?";
    
    String REDO_DECRYPT = "Would you like to Decrypt other code?";
    
    String RESULT = "Result";
    
    String RESULT_ENCODE = "This is your: "; 
    
	String TITTLE = "Welcome to the Encrypt program.";
    
    //NUMBERS
    interface Numbers{
	    int ZERO = 0;
	    
	    int ONE = 1;
	    
	    int TWO = 2;
	    
	    int THREE = 3;
	    
	    int TEN = 10;
	    
	    int WIDTH = 400;
	    
	    int HEIGHT = 200;
	    
	    long SERIAL_NUMBER = -6628012530681684210L;
    }
    
    interface Methods{
    	String ACTIONRADIO = "controllerActionRadio";
    	String ACTIONSRADIOBUTTOM = "actionsRadioButtom";
    	String CLOSING = "closeFrame";
    	String CREATEPANE = "createPane";
		String CREATINGTHEFRAME = "creatingTheFrame";
		String ENCRYPTDECRYPT = "encryptDecrypt";
		String EXCEPTIONS = "exceptions";
    	String MAIN = "Main";
    	String RUNENCRYPTDECRYPTRULE = "runEncryptDecryptRule";
    	String SHUFFLESTRING = "shuffleString";
    	String VIEWPROJECT = "ViewProject construct";
    	String WINDOWLISTENER = "windomListener(windowClosing)";
    }
}