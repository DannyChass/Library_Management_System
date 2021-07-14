package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import My_Classes.Author;
import My_Classes.DB;
import My_Classes.Func_Class;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class ManageAuthorsForm extends JFrame {

	private JPanel contentPane;
	public  JTextField jTextField_ID = new JTextField();
	private JTextField jTextField_FirstName;
	private JTable jTable_Authors;
	private JLabel jLabel_EmptyFirstName = new JLabel("* enter the first name");
	private JLabel jLabel_EmptyLastName = new JLabel("* enter the last name");
	Author author = new Author();
	private JTextField jTextField_LastName;
	private JTextField jTextField_Expertise;
	private JTextArea jTextArea_About = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAuthorsForm frame = new ManageAuthorsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageAuthorsForm() {
		setUndecorated(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 689, 594);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 626, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jLabel_FromTitle = new JLabel("Manage Authors");
		jLabel_FromTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_FromTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		jLabel_FromTitle.setForeground(Color.WHITE);
		jLabel_FromTitle.setBounds(0, 0, 625, 70);
		panel_1.add(jLabel_FromTitle);
		
		JLabel jLabel_CloseForm = new JLabel("X\r\n");
		jLabel_CloseForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//close the form
				dispose();
			}
		});
		jLabel_CloseForm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabel_CloseForm.setOpaque(true);
		jLabel_CloseForm.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jLabel_CloseForm.setForeground(Color.WHITE);
		jLabel_CloseForm.setBackground(new Color(165, 42, 42));
		jLabel_CloseForm.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_CloseForm.setBounds(625, 0, 64, 70);
		panel.add(jLabel_CloseForm);
		
		this.setLocationRelativeTo(null);
		
		//add a gray border to the panel
		Border panelHeaderBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
		panel.setBorder(panelHeaderBorder);
		
		Func_Class func = new Func_Class();
		func.displayImage(75,60, null,"/My_Images/notepad.png",jLabel_FromTitle);
		
		JLabel jLabel_ID = new JLabel("ID:");
		jLabel_ID.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel_ID.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_ID.setBounds(10, 81, 42, 37);
		panel.add(jLabel_ID);
		
		JLabel jLabel_FirstName = new JLabel("First Name:");
		jLabel_FirstName.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_FirstName.setBounds(10, 129, 180, 27);
		panel.add(jLabel_FirstName);
		
		jTextField_ID.setBounds(62, 88, 132, 27);
		panel.add(jTextField_ID);
		jTextField_ID.setColumns(10);
		
		jTextField_FirstName = new JTextField();
		jTextField_FirstName.setBounds(10, 155, 380, 27);
		panel.add(jTextField_FirstName);
		jTextField_FirstName.setColumns(10);
		
		JButton jButton_Add = new JButton("Add");
		jButton_Add.setBounds(10, 562, 120, 27);
		panel.add(jButton_Add);
		jButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//add a new genre
				String fname = jTextField_FirstName.getText();
				String lname = jTextField_LastName.getText();
				String expertise = jTextField_Expertise.getText();
				String about = jTextArea_About.getText();
				
				//check is the textfield is empty
				if(fname.isEmpty()) {
					
					jLabel_EmptyFirstName.setVisible(true);
					
				}else if (lname.isEmpty()){
					
					jLabel_EmptyLastName.setVisible(true);
					
				}else { // if the textfields are not empty
					
					author.addAuthor(fname, lname, expertise, about);
					populateJtableWithAuthors();
					
				}
				
			}
			
		});
		
		JButton jButton_Edit = new JButton("Edit");
		jButton_Edit.setBounds(140, 562, 120, 27);
		panel.add(jButton_Edit);
		jButton_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//edit the selected author
				
				String fname = jTextField_FirstName.getText();
				String lname = jTextField_LastName.getText();
				String expertise = jTextField_Expertise.getText();
				String about = jTextArea_About.getText();
				
				
				if(fname.isEmpty()) {
					
					jLabel_EmptyFirstName.setVisible(true);
					
				}else if (lname.isEmpty()) {
					
					jLabel_EmptyLastName.setVisible(true);

				}else {
					try {
						
						int id = Integer.parseInt(jTextField_ID.getText());
						author.editAuthor(id, fname, lname, expertise, about);
						populateJtableWithAuthors();
						
						
						//refresh the jtable author
						//populateJTableWithGnenres();
						
						//clear text from the textfields
						jTextField_ID.setText("");
						jTextField_FirstName.setText("");
						jTextField_LastName.setText("");
						jTextField_Expertise.setText("");
						jTextArea_About.setText("");
						
					}catch(NumberFormatException ex) {
						
						JOptionPane.showMessageDialog(null, "Invalid Author ID - " + ex.getMessage(), "error",0);
						
					}
				}
				
			}
		});
		
		
		JButton jButton_Delete = new JButton("Delete");
		jButton_Delete.setBounds(270, 562, 120, 27);
		panel.add(jButton_Delete);
		jButton_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete the selected genre
				
				try {
					
					int id = Integer.parseInt(jTextField_ID.getText());
					author.removeAuthor(id);
					populateJtableWithAuthors();
					
				}catch(NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Invalid Genre ID - " + ex.getMessage(), "error",0);
				}
				
			}
			
			
		});
		jTable_Authors = new JTable();
		jTable_Authors.setSelectionBackground(new Color(249,105,14));
		jTable_Authors.setSelectionForeground(Color.white);
		jTable_Authors.setRowHeight(30);
		jTable_Authors.setShowGrid(false);
		jTable_Authors.setBackground(new Color(248,248,248));
		jTable_Authors.setShowHorizontalLines(true);
		
		
		//customize the jtable header show
		
		
		jTable_Authors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//display the selected genre
				// get the selected row index
				int index = jTable_Authors.getSelectedRow();
				
				//get values
				String id = jTable_Authors.getValueAt(index, 0).toString();
				String firstName = jTable_Authors.getValueAt(index, 1).toString();
				String lastName = jTable_Authors.getValueAt(index,2).toString();
				String expertise = jTable_Authors.getValueAt(index, 3).toString();
				String about = jTable_Authors.getValueAt(index, 4).toString();
				
				// show data in the TextFields
				jTextField_ID.setText(id);
				jTextField_FirstName.setText(firstName);
				jTextField_LastName.setText(lastName);
				jTextField_Expertise.setText(expertise);
				jTextArea_About.setText(about);
				
			}
			
			
			
		});
		jTable_Authors.setColumnSelectionAllowed(true);
		jTable_Authors.setToolTipText("");
		jTable_Authors.setCellSelectionEnabled(true);
		jTable_Authors.setForeground(new Color(0, 0, 0));
		jTable_Authors.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "NAME"
			}
		));
		jTable_Authors.setBounds(408, 104, 259, 447);
		panel.add(jTable_Authors);
		
		
		jTable_Authors.setSelectionBackground(Color.LIGHT_GRAY);
		jTable_Authors.setShowGrid(true);
		jTable_Authors.setBackground(new Color(248,248,248));
		jLabel_EmptyFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//hide the jlabel on click
				
				jLabel_EmptyFirstName.setVisible(false);
				
				
			}
		});
		
		
		jLabel_EmptyFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel_EmptyFirstName.setForeground(new Color(204, 0, 0));
		jLabel_EmptyFirstName.setBounds(10, 190, 380, 20);
		panel.add(jLabel_EmptyFirstName);
		
		JLabel jLabel_LastName = new JLabel("Last Name:");
		jLabel_LastName.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_LastName.setBounds(10, 215, 250, 27);
		panel.add(jLabel_LastName);
		
		jTextField_LastName = new JTextField();
		jTextField_LastName.setColumns(10);
		jTextField_LastName.setBounds(10, 241, 380, 27);
		panel.add(jTextField_LastName);
		
		JLabel jLabel_About = new JLabel("About:");
		jLabel_About.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_About.setBounds(10, 382, 380, 27);
		panel.add(jLabel_About);
		
		JLabel jLabel_Expertise = new JLabel("Expertise:");
		jLabel_Expertise.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_Expertise.setBounds(10, 310, 380, 27);
		panel.add(jLabel_Expertise);
		
		jTextField_Expertise = new JTextField();
		jTextField_Expertise.setColumns(10);
		jTextField_Expertise.setBounds(10, 337, 380, 27);
		panel.add(jTextField_Expertise);
		
		jLabel_EmptyLastName = new JLabel("* enter the last name");
		jLabel_EmptyLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				jLabel_EmptyLastName.setVisible(false);
			}
		});
		jLabel_EmptyLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel_EmptyLastName.setForeground(Color.RED);
		jLabel_EmptyLastName.setBounds(10, 279, 380, 20);
		panel.add(jLabel_EmptyLastName);
		
		
		jTextArea_About.setBounds(10, 410, 380, 141);
		panel.add(jTextArea_About);
		
		jLabel_EmptyFirstName.setVisible(false);
		jLabel_EmptyLastName.setVisible(false);
		
		
		jTable_Authors.getTableHeader().setForeground(Color.white);
		jTable_Authors.getTableHeader().setOpaque(false);
		jTable_Authors.setGridColor(Color.ORANGE);
		
		// populate JTable 
		populateJtableWithAuthors();
		
	}
	
	//create a function to populate the jtable with authors
	public void populateJtableWithAuthors() {

		
		
		ArrayList<Author> authorsList = author.authorsList();
		
		//jTables columns
		
		String[] colNames = {"ID","First Name","Last Name","Expertise","About"};
		
		// row
		Object [][] rows = new Object[authorsList.size()][colNames.length];
		
		for(int i = 0; i<authorsList.size(); i++) {
			
			rows[i][0]= authorsList.get(i).getId();
			
			rows[i][1]= authorsList.get(i).getFirstName();
			
			rows[i][2]= authorsList.get(i).getLastName();
			
			rows[i][3] = authorsList.get(i).getFieldOfExpertise();
			
			rows[i][4] = authorsList.get(i).getAbout();
			
		}
		
		DefaultTableModel model = new DefaultTableModel(rows,colNames);
		jTable_Authors.setModel(model);
		
	}
	
	public void setTextInTheFields(String id, String name) {
		jTextField_ID.setText(id);
		jTextField_FirstName.setText(name);
	}
}