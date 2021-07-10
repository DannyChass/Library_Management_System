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

public class EditMemberForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_FirstName;
	private JLabel jLabel_EmptyFirstName = new JLabel("* enter the first name");
	private JLabel jLabel_EmptyLastName = new JLabel("* enter the last name");
	private JTextField jTextField_LastName;
	private JTextField jTextField_PhoneNumber;
	private JTextField jTextField_Email;
	private JComboBox jComboBox_Gender = new JComboBox();
	JLabel jLabel_EmptyPhone = new JLabel("* enter the phone number");

	// create a member object
	Member member = new Member();

	// create a variable to store the profile picture path

	String imagePath = null;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMemberForm frame = new EditMemberForm();
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
	public EditMemberForm() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 454, 594);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setForeground(new Color(60, 179, 113));
		panel_1.setBounds(0, 0, 390, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel jLabel_FromTitle = new JLabel("Edit Member");
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
		func.displayImage(90, 60, "/My_Images/members.png", jLabel_FromTitle);

		JLabel jLabel_FirstName = new JLabel("First Name:");
		jLabel_FirstName.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_FirstName.setBounds(18, 135, 180, 27);
		panel.add(jLabel_FirstName);

		jTextField_FirstName = new JTextField();
		jTextField_FirstName.setBounds(18, 167, 250, 27);
		panel.add(jTextField_FirstName);
		jTextField_FirstName.setColumns(10);

		JButton jButton_Add = new JButton("Add New Member");
		jButton_Add.setBounds(10, 562, 434, 27);
		panel.add(jButton_Add);
		jButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// add a new genre
				String fname = jTextField_FirstName.getText();
				String lname = jTextField_LastName.getText();
				String phone = jTextField_PhoneNumber.getText();
				String gender = jComboBox_Gender.getSelectedItem().toString();
				String email = jTextField_Email.getText();

				// check is the textfield is empty
				if (fname.isEmpty()) {

					jLabel_EmptyFirstName.setVisible(true);

				} else if (lname.isEmpty()) {

					jLabel_EmptyLastName.setVisible(true);

				} else if (phone.isEmpty()) {

					jLabel_EmptyPhone.setVisible(true);

				} else { // if the textfields are not empty
					byte[] img = null;
					if (imagePath != null) {

						try {
							Path path = Paths.get(imagePath);
							img = Files.readAllBytes(path);
							member.addMember(fname, lname, phone, email, gender, img);

						} catch (IOException e1) {
							e1.printStackTrace();

						}

					} else {
						JOptionPane.showMessageDialog(null, "Select a Profile Picture For This Member",
								"No picture Selected", 2);
					}
				}

			}

		});
		jLabel_EmptyFirstName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// hide the jlabel on click

				jLabel_EmptyFirstName.setVisible(false);

			}
		});

		jLabel_EmptyFirstName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel_EmptyFirstName.setForeground(new Color(204, 0, 0));
		jLabel_EmptyFirstName.setBounds(272, 169, 122, 20);
		panel.add(jLabel_EmptyFirstName);

		JLabel jLabel_LastName = new JLabel("Last Name:");
		jLabel_LastName.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_LastName.setBounds(16, 205, 250, 27);
		panel.add(jLabel_LastName);

		jTextField_LastName = new JTextField();
		jTextField_LastName.setColumns(10);
		jTextField_LastName.setBounds(16, 231, 250, 27);
		panel.add(jTextField_LastName);

		JLabel jLabel_Expertise = new JLabel("Phone Number:");
		jLabel_Expertise.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_Expertise.setBounds(18, 267, 120, 27);
		panel.add(jLabel_Expertise);

		jTextField_PhoneNumber = new JTextField();
		jTextField_PhoneNumber.setColumns(10);
		jTextField_PhoneNumber.setBounds(16, 294, 250, 27);
		panel.add(jTextField_PhoneNumber);

		jLabel_EmptyLastName = new JLabel("* enter the last name");
		jLabel_EmptyLastName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				jLabel_EmptyLastName.setVisible(false);
			}
		});
		jLabel_EmptyLastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel_EmptyLastName.setForeground(Color.RED);
		jLabel_EmptyLastName.setBounds(272, 233, 120, 20);
		panel.add(jLabel_EmptyLastName);
		jLabel_EmptyPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				jLabel_EmptyPhone.setVisible(false);
			}
		});

		jLabel_EmptyPhone.setForeground(Color.RED);
		jLabel_EmptyPhone.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel_EmptyPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		jLabel_EmptyPhone.setBounds(272, 296, 149, 20);
		panel.add(jLabel_EmptyPhone);
		jLabel_EmptyPhone.setVisible(false);

		JLabel jLabel_Expertise_1 = new JLabel("Email:");
		jLabel_Expertise_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_Expertise_1.setBounds(18, 332, 380, 27);
		panel.add(jLabel_Expertise_1);

		jTextField_Email = new JTextField();
		jTextField_Email.setColumns(10);
		jTextField_Email.setBounds(18, 358, 250, 27);
		panel.add(jTextField_Email);

		JLabel jLabel_Expertise_1_1 = new JLabel("Gender:");
		jLabel_Expertise_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_Expertise_1_1.setBounds(10, 396, 380, 27);
		panel.add(jLabel_Expertise_1_1);

		jComboBox_Gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jComboBox_Gender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female", "Non Binary" }));
		jComboBox_Gender.setBounds(10, 425, 434, 22);
		panel.add(jComboBox_Gender);

		JLabel jLabel_Expertise_1_1_1 = new JLabel("Profile Picture:");
		jLabel_Expertise_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_Expertise_1_1_1.setBounds(18, 457, 380, 27);
		panel.add(jLabel_Expertise_1_1_1);

		JButton jButton_SelectProfilePicture = new JButton("Select profile");

		jButton_SelectProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Select Profile Picture");
				fileChooser.setCurrentDirectory(new File("C:\\images"));

				FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Image", ".png", ".jpg", "jpeg");
				fileChooser.addChoosableFileFilter(extensionFilter);

				int fileState = fileChooser.showSaveDialog(null);

				if (fileState == JFileChooser.APPROVE_OPTION) {

					String path = fileChooser.getSelectedFile().getAbsolutePath();

					

					imagePath = path;
				}
			}
		});

		jButton_SelectProfilePicture.setBounds(317, 480, 112, 23);
		panel.add(jButton_SelectProfilePicture);
		
		JLabel jLabel_FirstName_1 = new JLabel("Enter Member ID:");
		jLabel_FirstName_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		jLabel_FirstName_1.setBounds(18, 92, 130, 27);
		panel.add(jLabel_FirstName_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 94, 124, 27);
		panel.add(textField);
		
		JButton jButton_SelectProfilePicture_1 = new JButton("Search");
		jButton_SelectProfilePicture_1.setBounds(278, 96, 112, 23);
		panel.add(jButton_SelectProfilePicture_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(144, 238, 144));
		lblNewLabel.setBounds(122, 465, 185, 86);
		panel.add(lblNewLabel);

		jLabel_EmptyFirstName.setVisible(false);
		jLabel_EmptyLastName.setVisible(false);

	}

	public void setTextInTheFields(String id, String name) {
		jTextField_FirstName.setText(name);
	}
}