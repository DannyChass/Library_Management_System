package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import My_Classes.DB;
import My_Classes.Func_Class;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.*;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField jTextField_Username;
	private JPasswordField jPassword_Pass;
	private JButton jButton_Login;
	private JLabel JLabel_Logo;

	Func_Class func = new Func_Class();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 459, 484);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel_Logo = new JLabel("");
		JLabel_Logo.setOpaque(true);
		JLabel_Logo.setBackground(Color.WHITE);
		JLabel_Logo.setBounds(127, 11, 207, 164);
		panel.add(JLabel_Logo);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(51, 102, 153));
		panel_1.setBounds(10, 186, 439, 299);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 23, 98, 14);
		panel_1.add(lblNewLabel_1);

		jTextField_Username = new JTextField();
		jTextField_Username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jTextField_Username.setBounds(10, 48, 419, 30);
		panel_1.add(jTextField_Username);
		jTextField_Username.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 92, 98, 14);
		panel_1.add(lblNewLabel_1_1);

		jPassword_Pass = new JPasswordField();
		jPassword_Pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jPassword_Pass.setBounds(10, 117, 419, 30);
		panel_1.add(jPassword_Pass);

		JLabel lblNewLabel_1_1_1 = new JLabel("User Type:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 158, 98, 27);
		panel_1.add(lblNewLabel_1_1_1);

		JComboBox comboBox_UserType = new JComboBox();
		comboBox_UserType.setForeground(Color.WHITE);
		comboBox_UserType.setEnabled(false);
		comboBox_UserType.setBackground(Color.WHITE);
		comboBox_UserType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_UserType.setBounds(10, 186, 419, 27);
		panel_1.add(comboBox_UserType);

		jButton_Login = new JButton("Login ");
		jButton_Login.setForeground(Color.WHITE);
		jButton_Login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jButton_Login.setBackground(Color.DARK_GRAY);
		jButton_Login.setBounds(10, 236, 419, 41);

		// action of the login button
		jButton_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = jTextField_Username.getText();
				String password = String.valueOf(jPassword_Pass.getPassword());

				ResultSet rs;
				PreparedStatement ps;

				String query = "SELECT * FROM users WHERE username = ? AND password = ?";

				// check if the fields are empty
				if (username.trim().equals("") || password.trim().equals("")) {

					JOptionPane.showMessageDialog(null, "Enter The Username & Password", "Empy Fields", 2);
				} else {

					try {

						// get the connection from class DB
						ps = DB.getConnection().prepareStatement(query);
						ps.setString(1, username);
						ps.setString(2, password);

						rs = ps.executeQuery();

						// chech if the user exists

						// if the user exists
						if (rs.next()) {

							DashboardForm dash_f = new DashboardForm();
							dash_f.setVisible(true);
							dispose();

							// close the login form
							// if not
						} else {

							JOptionPane.showMessageDialog(null, "Invalid Username Or Password", "Wrong Data", 0);

						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		panel_1.add(jButton_Login);

		// center the position
		this.setLocationRelativeTo(null);

		func.displayImage(JLabel_Logo.getWidth(), JLabel_Logo.getHeight(), null, "/My_Images/book_login_logo.png",
				JLabel_Logo);

	}

	public Color getBtnNewButtonBackground() {
		return jButton_Login.getBackground();
	}

	public void setBtnNewButtonBackground(Color background) {
		jButton_Login.setBackground(background);
	}

	// create a fonction to display the image in Jlabel
	public void displayImage() {
		// get the image
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Images/book_login_logo.png"));

		// make the image fit the JLabel
		Image image = imgIco.getImage().getScaledInstance(JLabel_Logo.getWidth(), JLabel_Logo.getHeight(),
				Image.SCALE_SMOOTH);

		// set the image int the JLabel
		JLabel_Logo.setIcon(new ImageIcon(image));

	}

}
