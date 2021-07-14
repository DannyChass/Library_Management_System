package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import My_Classes.DB;
import My_Classes.Func_Class;
import My_Classes.Genre;

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

public class ManageGenresForm extends JFrame {

	private JPanel contentPane;
	public  JTextField jTextField_ID = new JTextField();
	private JTextField jTextField_Name;
	private JTable jTable_Genres;
	private JLabel jLabel_EmptyName = new JLabel("* enter the genre name");
	Genre genre = new Genre();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageGenresForm frame = new ManageGenresForm();
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
	public ManageGenresForm() {
		setUndecorated(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 689, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 626, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jLabel_FromTitle = new JLabel("Manage Books Genres");
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
		func.displayImage(75,60, null,"/My_Images/hierarchy.png",jLabel_FromTitle);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(70, 127, 42, 37);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblName.setBounds(41, 175, 71, 37);
		panel.add(lblName);
		
		jTextField_ID.setBounds(122, 132, 132, 27);
		panel.add(jTextField_ID);
		jTextField_ID.setColumns(10);
		
		jTextField_Name = new JTextField();
		jTextField_Name.setBounds(122, 180, 180, 27);
		panel.add(jTextField_Name);
		jTextField_Name.setColumns(10);
		
		JButton jButton_Add = new JButton("Add");
		jButton_Add.setBounds(10, 250, 120, 27);
		panel.add(jButton_Add);
		jButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//add a new genre
				String name = jTextField_Name.getText();
				
				//check is the textfield is empty
				if(name.isEmpty()) {
					
					jLabel_EmptyName.setVisible(true);
					
				}else {
					
					genre.addGenre(name);
					//refresh the JTable with Genres
					populateJtableWithGenres();
				}
			}
			
		});
		
		JButton jButton_Edit = new JButton("Edit");
		jButton_Edit.setBounds(140, 250, 120, 27);
		panel.add(jButton_Edit);
		jButton_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = jTextField_Name.getText();
				
				if(name.isEmpty()) {
					
					jLabel_EmptyName.setVisible(true);
					
				}else {
					
					try {
						int id = Integer.valueOf(jTextField_ID.getText());
						genre.editGenre(id, name);
						populateJtableWithGenres();
						
					}catch(NumberFormatException ex) {
						
						JOptionPane.showMessageDialog(null, "Invalid Genre ID", "error",0);
					}
				}
				
			}
		});
		
		
		JButton jButton_Delete = new JButton("Delete");
		jButton_Delete.setBounds(270, 250, 120, 27);
		panel.add(jButton_Delete);
		jButton_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//delete the selected genre
				
				try {
					
					int id = Integer.parseInt(jTextField_ID.getText());
					genre.removeGenre(id);
					populateJtableWithGenres();
					
				}catch(NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Invalid Genre ID - " + ex.getMessage(), "error",0);
				}
				
			}
			
			
		});
		jTable_Genres = new JTable();
		jTable_Genres.setSelectionBackground(new Color(249,105,14));
		jTable_Genres.setSelectionForeground(Color.white);
		jTable_Genres.setRowHeight(30);
		jTable_Genres.setShowGrid(false);
		jTable_Genres.setBackground(new Color(248,248,248));
		
		
		//customize the jtable header show
		
		
		jTable_Genres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//display the selected genre
				// get the selected row index
				int index = jTable_Genres.getSelectedRow();
				
				//get values
				String id = jTable_Genres.getValueAt(index, 0).toString();
				String name = jTable_Genres.getValueAt(index, 1).toString();
				
				// show data in the TextFields
				jTextField_ID.setText(id);
				jTextField_Name.setText(name);
			}
			
			
			
		});
		jTable_Genres.setColumnSelectionAllowed(true);
		jTable_Genres.setToolTipText("");
		jTable_Genres.setCellSelectionEnabled(true);
		jTable_Genres.setForeground(new Color(0, 0, 0));
		jTable_Genres.setModel(new DefaultTableModel(
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
		jTable_Genres.setBounds(417, 104, 250, 173);
		panel.add(jTable_Genres);
		
		
		jTable_Genres.setSelectionBackground(Color.LIGHT_GRAY);
		jTable_Genres.setShowGrid(true);
		jTable_Genres.setBackground(new Color(248,248,248));
		jLabel_EmptyName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//hide the jlabel on click
				
				jLabel_EmptyName.setVisible(false);
				
				
			}
		});
		
		
		jLabel_EmptyName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel_EmptyName.setForeground(new Color(204, 0, 0));
		jLabel_EmptyName.setBounds(122, 213, 180, 26);
		panel.add(jLabel_EmptyName);
		
		jLabel_EmptyName.setVisible(false);
		
		
		jTable_Genres.getTableHeader().setForeground(Color.white);
		jTable_Genres.getTableHeader().setOpaque(false);
		
		
		// populate JTable 
		populateJtableWithGenres();
		
	}
	
	//create a function to populate the jtable with genres
	public void populateJtableWithGenres() {

		
		
		ArrayList<Genre> genresList = genre.genreList();
		
		//jTables columns
		
		String[] colNames = {"ID","NAME"};
		
		// row
		Object [][] rows = new Object[genresList.size()][colNames.length];
		
		for(int i = 0; i<genresList.size(); i++) {
			
			rows[i][0]= genresList.get(i).getId();
			
			rows[i][1]=genresList.get(i).getName();
			
		}
		
		DefaultTableModel model = new DefaultTableModel(rows,colNames);
		jTable_Genres.setModel(model);
		
	}
	
	public void setTextInTheFields(String id, String name) {
		jTextField_ID.setText(id);
		jTextField_Name.setText(name);
	}
}
