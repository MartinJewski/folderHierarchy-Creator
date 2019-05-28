package GuiWB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Factory.FolderHierarchy;
import SaveCounter.SaveCounter;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JSplitPane;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GuiBase extends JFrame {
	private JTextField pathField;
	
	private String filePath;
	
	FolderHierarchy folderHierarchy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBase frame = new GuiBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GuiBase() throws IOException {
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 323);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		SpringLayout sl_layeredPane = new SpringLayout();
		layeredPane.setLayout(sl_layeredPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 102, 102));
		panel.setBackground(new Color(51, 51, 51));
		sl_layeredPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, panel, 296, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.EAST, panel, 87, SpringLayout.WEST, layeredPane);
		layeredPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_layeredPane.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.EAST, panel);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreate.setFocusable(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnCreate.setRequestFocusEnabled(false);
		btnCreate.setForeground(new Color(0, 204, 255));
		btnCreate.setBorder(null);
		btnCreate.setBackground(new Color(51, 51, 51));
		panel.add(btnCreate);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setForeground(new Color(0, 204, 255));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(51, 51, 51));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setRequestFocusEnabled(false);
		btnNewButton_4.setForeground(new Color(0, 204, 255));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(new Color(51, 51, 51));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setForeground(new Color(0, 204, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(51, 51, 51));
		panel.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setFocusable(false);
		button.setRequestFocusEnabled(false);
		button.setForeground(new Color(0, 204, 255));
		button.setBorder(null);
		button.setBackground(new Color(51, 51, 51));
		panel.add(button);
		sl_layeredPane.putConstraint(SpringLayout.SOUTH, panel_1, 296, SpringLayout.NORTH, layeredPane);
		sl_layeredPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, layeredPane);
		layeredPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel card1 = new JPanel();
		card1.setBackground(new Color(248, 248, 255));
		card1.setForeground(new Color(51, 255, 51));
		panel_1.add(card1, "name_21854547643209");
		card1.setLayout(null);
		
		pathField = new JTextField();
		pathField.setText("insert or select a path...");
		pathField.setBackground(new Color(248, 248, 255));
		pathField.setBounds(12, 201, 289, 20);
		card1.add(pathField);
		pathField.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Path:");
		lblNewLabel.setBounds(12, 180, 55, 16);
		card1.add(lblNewLabel);
		
		JLabel AppTitle = new JLabel("FolderHierarchy Creator");
		AppTitle.setFont(new Font("Adobe Hebrew", Font.ITALIC, 20));
		AppTitle.setHorizontalAlignment(SwingConstants.CENTER);
		AppTitle.setBounds(74, 0, 227, 44);
		card1.add(AppTitle);
		
		JLabel lblNewLabel_1 = new JLabel(
				"<html>\r\n\t Description: <br/>\r\n\t This application creates a folder hierarchy for the current year,\r\n\t which contains all months and for every month <br/>\r\n\t it creates a folder with the dates as the name. <br/>\r\n\t Leapyears are included. <br/>\r\n\t <br/>\r\n\t How to use: Chose the path where you want <br/>\r\n\t your folder hierarchy to be created. <br/>\r\n</html>");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(12, 43, 378, 135);
		card1.add(lblNewLabel_1);
		
		JButton btnSelectPathButton = new JButton("select");
		btnSelectPathButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filePath = GuiHelper.selectPath(btnSelectPathButton);
				pathField.setText(filePath);
			}
		});
		btnSelectPathButton.setRequestFocusEnabled(false);
		btnSelectPathButton.setForeground(new Color(0, 204, 255));
		btnSelectPathButton.setFocusable(false);
		btnSelectPathButton.setBorder(null);
		btnSelectPathButton.setBackground(new Color(51, 51, 51));
		btnSelectPathButton.setBounds(303, 201, 87, 20);
		card1.add(btnSelectPathButton);
		
		//logic that starts the creation of a file hierarchy, if and only if 
		// the path inside the textBox "pathField" is equals the selected path we got
		// from the FileChooser!
		JButton btnCreateHierarchy = new JButton("Create hierarchy");
		btnCreateHierarchy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(filePath == null) {
	        		JOptionPane.showMessageDialog(panel, "No path selected.");
				}else {
					
					//when the chosen path is the same as the savedPath
					if(pathField.getText().equals(filePath)) {
						
						int counter = 0;
						try {
							counter = SaveCounter.load();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						//we add a counter to the folder name "FolderHierarchy"
						//to be able to create a new folder without overwrite the old
						File tempDir = new File(filePath + "/FolderHierarchy" + counter);
						tempDir.mkdir();//creates folder with name FolderHierarchyX, X is a number
						int tempCounter = counter + 1; //increase counter
						//try to save the new counter to our SaveFileSystemCounter.txt
						try {
							SaveCounter.save(tempCounter);
						} catch (IOException e) {
							//show the person the error, can be send to the developer
							JOptionPane.showMessageDialog(panel,"Error Code[1]: \n" +  e.toString());
						}
						//creates the folder Hierarchy
						folderHierarchy = new FolderHierarchy(tempDir.getAbsolutePath());
					}

				}
				
			}
		});
		
		btnCreateHierarchy.setRequestFocusEnabled(false);
		btnCreateHierarchy.setForeground(new Color(0, 204, 255));
		btnCreateHierarchy.setFocusable(false);
		btnCreateHierarchy.setBorder(null);
		btnCreateHierarchy.setBackground(new Color(51, 51, 51));
		btnCreateHierarchy.setBounds(130, 233, 112, 37);
		card1.add(btnCreateHierarchy);
		Image img = new ImageIcon(this.getClass().getResource("/btnCloseImage.png")).getImage();
		Image img2 = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img2);
		
	}
}
