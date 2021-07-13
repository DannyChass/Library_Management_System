package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import My_Classes.Member;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

public class DeleteMemberForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_ID;
	private JLabel jLabel_EmptyID = new JLabel("* you must enter the member id");
	private JLabel jLabel_EmptyLastName = new JLabel("* enter the last name");

	// create a member object
	Member member = new Member();

	// create a variable to store the profile picture path

	String imagePath = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMemberForm frame = new DeleteMemberForm();
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
	public DeleteMemberForm() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 454, 227);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setForeground(new Color(60, 179, 113));
		panel_1.setBounds(0, 0, 390, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel jLabel_FromTitle = new JLabel("Delete Member");
		jLabel_FromTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_FromTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		jLabel_FromTitle.setForeground(Color.WHITE);
		jLabel_FromTitle.setBounds(0, 0, 390, 70);
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
		jLabel_CloseForm.setBounds(388, 0, 66, 70);
		panel.add(jLabel_CloseForm);

		this.setLocationRelativeTo(null);

		// add a gray border to the panel
		Border panelHeaderBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
		panel.setBorder(panelHeaderBorder);

		Func_Class func = new Func_Class();
		func.displayImage(90, 60,null, "/My_Images/members.png", jLabel_FromTitle);

		JLabel jLabel_FirstName = new JLabel("Enter The ID:");
		jLabel_FirstName.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_FirstName.setBounds(4, 102, 104, 27);
		panel.add(jLabel_FirstName);

		jTextField_ID = new JTextField();
		jTextField_ID.setBounds(110, 104, 334, 27);
		panel.add(jTextField_ID);
		jTextField_ID.setColumns(10);

		JButton jButton_Delete = new JButton("Delete Member");
		jButton_Delete.setBounds(10, 186, 434, 27);
		panel.add(jButton_Delete);
		
		
		jButton_Delete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				// delete a member
				
				try 
				{
					Integer id = Integer.parseInt(jTextField_ID.getText());
					
					
					//show a confirmation message before deleting
					int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure Yoy Want To Delete This Member?","Confirmation Box",JOptionPane.YES_NO_OPTION);
					member.removeMember(id);
					
				}catch(Exception ex) 
				{
					jLabel_EmptyID.setForeground(Color.red);
				}

			}

		});
		jLabel_EmptyID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// hide the jlabel on click

				jLabel_EmptyID.setForeground(Color.LIGHT_GRAY);

			}
		});

		jLabel_EmptyID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel_EmptyID.setForeground(new Color(204, 0, 0));
		jLabel_EmptyID.setBounds(109, 141, 222, 20);
		panel.add(jLabel_EmptyID);
		
		jLabel_EmptyID.setForeground(Color.LIGHT_GRAY);
	}

	public void setTextInTheFields(String id, String name) {
		jTextField_ID.setText(name);
	}

}