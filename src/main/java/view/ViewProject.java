package main.java.view;


/**
 * Import part
 * BorderLayout - Cares about the borders
 * Dimension - Cares about the sizes
 * ActionEvent - Cares about 'do' the actions
 * ActionListenner - Cares about listen the actions buttons.
 * BorderFactory - 'Maker' of borders.
 * BoxLayout - Cares about the layout of the boxes components insight the frame.
 * ButtonGroup - Cares about the group of the radioButtons
 * JButton - Makes the button and cares about the actions.
 * JFrame - My "basic" frame.
 * JLabel - The label.
 * JOptionPane - The OptionPanel. Control the input, msgs, panel in general.
 * JPanel - Makes the panels which receive the radioButton.
 * JRadioButton - Cares about the radios buttons. 
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.java.commons.AppConstants;
import main.java.facade.ModelProject;
import main.java.facade.ModelProjectImpl;

/**
 * @author Tiago Rufino
 * 
 * Class View. Mount and control all the view part: frame, plane and radioButton
 * 
 */
public class ViewProject extends JPanel {
	//Serial.
	private static final long serialVersionUID = AppConstants.Numbers.SERIAL_NUMBER;
	
	//Interface of the model.
	private ModelProject modelProject = new ModelProjectImpl();
	
	//My frame
	private JFrame frame;
	
	//Quantity of the radionButtons
    private final int numButtons = AppConstants.Numbers.THREE;
    
    //Shuffle encode.
    private final String encode = modelProject.shuffleString()+AppConstants.ESPACE;

    public ViewProject(){
    }
    
    /**
     * Constructor which mounts the component and shown inside the frame's content pane.
     *  
     * @param frame - My frame
     */
    public ViewProject(JFrame frame) {
        super(new BorderLayout());
        this.frame = frame;

        //LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.VIEWPROJECT);
        
        //Mounting the components.
        JPanel frequentPanel = controllerActionRadio();
        JLabel label = new JLabel(AppConstants.TITTLE, JLabel.CENTER);

        add(frequentPanel, BorderLayout.CENTER);
        add(label, BorderLayout.PAGE_END);
        label.setBorder(BorderFactory.createEmptyBorder(AppConstants.Numbers.TEN, AppConstants.Numbers.TEN, 
        		AppConstants.Numbers.TEN, AppConstants.Numbers.TEN));
        
        frame.addWindowListener(new FrameDispose());
    }

    /**
     * Control all the actions with the radios buttons.
     * 
     * @return JPanel - Create the panel.
     */
    private JPanel controllerActionRadio() {
    	
    	//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.ACTIONRADIO);
        
        JRadioButton[] radioButtons = new JRadioButton[numButtons];
        //for doesn't change the group created
        final ButtonGroup group = new ButtonGroup();
        JButton showItButton = null;

        radioButtons[AppConstants.Numbers.ZERO] = new JRadioButton(AppConstants.ENCRYPT_U);
        radioButtons[0].setActionCommand(AppConstants.ENCRYPT);

        radioButtons[AppConstants.Numbers.ONE] = new JRadioButton(AppConstants.DECRYPT_U);
        radioButtons[AppConstants.Numbers.ONE].setActionCommand(AppConstants.DECRYPT);

        radioButtons[AppConstants.Numbers.TWO] = new JRadioButton(AppConstants.EXIT_U);
        radioButtons[AppConstants.Numbers.TWO].setActionCommand(AppConstants.EXIT);

        for (int i = AppConstants.Numbers.ZERO; i < numButtons; i++) {
            group.add(radioButtons[i]);
        }
        radioButtons[AppConstants.Numbers.ZERO].setSelected(true);

        showItButton = new JButton(AppConstants.OK);
        
        //This part "listen" the actions of the radioBunttons.
        showItButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionsRadioButtom(group);
                return;
            }
        });
        return createPane(radioButtons, showItButton);
    }

    /**
     * Create the panel with the radio buttons - radioButtons, JButtons and the dimensions.
     * 
     * @param radioButtons - (the radio buttons)
     * @param showButton - (button response)
     * @return JPanel - Panel alredy creating
     */
    private JPanel createPane(JRadioButton[] radioButtons, JButton showButton) {
    	
    	//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.CREATEPANE);
    	
        JPanel box = new JPanel();
        JLabel label = new JLabel(AppConstants.CHOOSE_OPTION);

        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);

        for (int i = AppConstants.Numbers.ZERO; i < numButtons; i++) {
            box.add(radioButtons[i]);
        }

        JPanel pane = new JPanel(new BorderLayout());
        pane.setPreferredSize(new Dimension(AppConstants.Numbers.WIDTH, AppConstants.Numbers.HEIGHT));
        pane.add(box, BorderLayout.PAGE_START);
        pane.add(showButton, BorderLayout.PAGE_END);
        return pane;
    }

    /**
     * Create the GUI frame and show it, new contentPane(My pane), setting visible and the 
     * relative location null(default).
     */
    public static void creatingTheFrame() {
    	
    	//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.CREATINGTHEFRAME);
    	
        JFrame frame = new JFrame(AppConstants.APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ViewProject newContentPane = new ViewProject(frame);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    /**
     * Define all the actions for the radio bottoms. If the encrypt button is choose, call the interface encryptDecrypt 
     * method with the encrypt parameters(base, encode) else is decrypt call the interface encryptDecrypt method but 
     * with the decrypt parameters(encode, base). 
     * 
     * @param buttonGroup - Group of RadionButtons
     */
    private void actionsRadioButtom(final ButtonGroup buttonGroup) {
    	
    	//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.ACTIONSRADIOBUTTOM);
    	
		String command = buttonGroup.getSelection().getActionCommand();
        int yesNo = AppConstants.Numbers.ZERO;
        if (command.equals(AppConstants.ENCRYPT)) {
        	while(yesNo==AppConstants.Numbers.ZERO){
        		yesNo = runEncryptDecryptRule(yesNo, AppConstants.ENCRYPT);
        	}
        } else if (command.equals(AppConstants.DECRYPT)) {
        	while(yesNo==AppConstants.Numbers.ZERO){
                yesNo = runEncryptDecryptRule(yesNo, AppConstants.DECRYPT);
        	}
        } else {
        	closeFrame();
        }
	}

    /**
     * Closing msg
     */
	public void closeFrame() {
		
		//LOG
		System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD + AppConstants.Methods.CLOSING);
		
		JOptionPane.showMessageDialog(frame, AppConstants.FINISH);
		if (null!=frame){
			frame.dispose();
		}
	}

    /**
     * Control the options yes or no before call the encryptDecrypt method.
     * 
     * @param yesNo - options for repeat
     * @param option - If is ENCRYPT or DECRYPT
     * @return - yes or no
     */
	private int runEncryptDecryptRule(int yesNo, String option) {
		
		//LOG
        System.out.println(AppConstants.LOG + AppConstants.CALLINGMETHOD+ AppConstants.Methods.RUNENCRYPTDECRYPTRULE);
		
		String output =  AppConstants.EMPTY;
		if (yesNo == JOptionPane.YES_OPTION) {
			output = JOptionPane.showInputDialog(AppConstants.INPUT);
			if (output!=null){
		    	String[] returns = option.equals(AppConstants.DECRYPT)?
		    			modelProject.encryptDecrypt(output, encode, AppConstants.BASE_W_ESPACE):
		    				modelProject.encryptDecrypt(output, AppConstants.BASE_W_ESPACE, encode);
		    	if(returns!=null && !returns[AppConstants.Numbers.ZERO].isEmpty()){
		    		JOptionPane.showMessageDialog(frame, AppConstants.RESULT_ENCODE +AppConstants.NEXT_LINE
		    			+ returns[AppConstants.Numbers.ZERO]);
		    	}
		    	modelProject.exceptions(returns, frame);
			}
		}
		yesNo = JOptionPane.showConfirmDialog(frame, AppConstants.REDO_DECRYPT, AppConstants.RESULT, 
				JOptionPane.YES_NO_OPTION);
		return yesNo;
	}
}

/**
 * Class window listener for control the closing button
 * @author Tiago Rufino
 *
 */
class FrameDispose extends WindowAdapter{
	public void windowClosing(WindowEvent e){
	    ViewProject viewProject = new ViewProject();
	    viewProject.closeFrame();
	}
}