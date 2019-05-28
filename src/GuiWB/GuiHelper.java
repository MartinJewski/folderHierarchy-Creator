package GuiWB;

import java.awt.Component;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * The GuiHelper class provides static methods which may be
 * useful while working with GUI's
 * @author Martin Machajewski
 *
 */
public class GuiHelper {
	
	/**
	 * 
	 * @param cmpt the parent component
	 * @return the path as a string or an empty string if the chooser 
	 * 			didn't open
	 */
    public static String selectPath(Component cmpt) {
        String lPath;
    	JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // optionally set chooser options ...
        if (chooser.showOpenDialog(cmpt) == JFileChooser.APPROVE_OPTION) {
            lPath = chooser.getSelectedFile().getAbsolutePath();
            return lPath;
            // read  and/or display the file somehow. ....
        } else {
        	if(chooser.CANCEL_OPTION == JFileChooser.CANCEL_OPTION) {
        		JOptionPane.showMessageDialog(cmpt, "No path selected.");
        	}
        	return "";
            // user changed their mind
        }
    }

}
