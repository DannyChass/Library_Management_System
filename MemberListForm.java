package My_Forms;


import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import My_Classes.Member;
import My_Classes.Func_Class;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberListForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_Search;

	// create a member object
	Member member = new Member();
	
	Func_Class func = new Func_Class();

	// create a variable to store the profile picture path

	String imagePath = null;
	private JTable jTable_Members;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberListForm frame = new MemberListForm();
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
	public MemberListForm() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 740, 475);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setForeground(new Color(60, 179, 113));
		panel_1.setBounds(0, 0, 675, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel jLabel_FromTitle = new JLabel("Member List");
		jLabel_FromTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_FromTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		jLabel_FromTitle.setForeground(Color.WHITE);
		jLabel_FromTitle.setBounds(0, 0, 675, 70);
		panel_1.add(jLabel_FromTitle);

		JLabel jLabel_CloseForm = new JLabel("X\r\n");
		jLabel_CloseForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// close the form
				dispose();
			}
		});
		jLabel_CloseForm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabel_CloseForm.setOpaque(true);
		jLabel_CloseForm.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jLabel_CloseForm.setForeground(Color.WHITE);
		jLabel_CloseForm.setBackground(Color.DARK_GRAY);
		jLabel_CloseForm.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_CloseForm.setBounds(674, 0, 66, 70);
		panel.add(jLabel_CloseForm);

		this.setLocationRelativeTo(null);

		// add a gray border to the panel
		Border panelHeaderBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
		panel.setBorder(panelHeaderBorder);

		Func_Class func = new Func_Class();
		func.displayImage(90, 60, null, "/My_Images/members.png", jLabel_FromTitle);

		JLabel jLabel_FirstName = new JLabel("Value to Search:");
		jLabel_FirstName.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_FirstName.setBounds(4, 102, 140, 27);
		panel.add(jLabel_FirstName);

		jTextField_Search = new JTextField();
		jTextField_Search.setBounds(154, 104, 348, 27);
		panel.add(jTextField_Search);
		jTextField_Search.setColumns(10);
		
		jTable_Members = new JTable();
		jTable_Members.setBounds(10, 157, 690, 307);
		panel.add(jTable_Members);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//search and display data in the jtable
				String value = jTextField_Search.getText();
				String query = "SELECT * FROM members WHERE firstname LIKE %"+value+"% or lastName LIKE %"+value+"%";
				populateJtableWithMembers(query);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(516, 106, 184, 23);
		panel.add(btnNewButton);
		
		//display image in the top
		func.displayImage(90, 60,null, "/My_Images/members.png", jLabel_FromTitle);
		
		//center the form
		this.setLocationRelativeTo(null);
		
		
		populateJtableWithMembers("");
		
		
		
	}

	public void setTextInTheFields(String id, String name) {
		jTextField_Search.setText(name);
	}
	
	
	//create a function to populate the jtable with authors
		public void populateJtableWithMembers(String query){
			
			ArrayList<Member> membersList = member.membersList(query);
			
			//jTables columns
			
			String[] colNames = {"ID","F-Name","L-Name","Phone","Email","Gender"};
			
			// row
			Object [][] rows = new Object[membersList.size()][colNames.length];
			
			for(int i = 0; i<membersList.size(); i++) {
				
				rows[i][0]= membersList.get(i).getId();
				
				rows[i][1]= membersList.get(i).getFirstName();
				
				rows[i][2]= membersList.get(i).getLastName();
				
				rows[i][3] = membersList.get(i).getPhone();
				
				rows[i][4] = membersList.get(i).getEmail();
				
				rows[i][5] = membersList.get(i).getGender();
				
			}
			
			DefaultTableModel model = new DefaultTableModel(rows,colNames);
			jTable_Members.setModel(model);
			
		}
}