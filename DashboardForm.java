package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class DashboardForm extends JFrame {

	private JPanel contentPane;
	private final JLabel JLabel_Dashboard_Logo = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardForm frame = new DashboardForm();
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
	public DashboardForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, -11, 922, 457);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 241, 457);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel JPanel_Header = new JPanel();
		JPanel_Header.setBackground(new Color(51, 102, 153));
		JPanel_Header.setBounds(0, 0, 241, 105);
		panel_1.add(JPanel_Header);
		JPanel_Header.setLayout(null);
		JLabel_Dashboard_Logo.setBounds(10, 16, 75, 78);
		JPanel_Header.add(JLabel_Dashboard_Logo);
		
		JLabel lblNewLabel_1 = new JLabel("Library");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(102, 24, 139, 52);
		JPanel_Header.add(lblNewLabel_1);
		
		JPanel JPanel_1 = new JPanel();
		JPanel_1.setBackground(new Color(51, 102, 153));
		JPanel_1.setBounds(251, 49, 210, 150);
		panel.add(JPanel_1);
		JPanel_1.setLayout(null);
		
		JPanel JPanel_1_Header = new JPanel();
		JPanel_1_Header.setBackground(Color.DARK_GRAY);
		JPanel_1_Header.setBounds(0, 0, 210, 33);
		JPanel_1.add(JPanel_1_Header);
		JPanel_1_Header.setLayout(null);
		
		JPanel JPanel_2 = new JPanel();
		JPanel_2.setBackground(new Color(51, 102, 153));
		JPanel_2.setBounds(471, 49, 210, 150);
		panel.add(JPanel_2);
		JPanel_2.setLayout(null);
		
		JPanel JPanel_2_Header = new JPanel();
		JPanel_2_Header.setBackground(Color.DARK_GRAY);
		JPanel_2_Header.setBounds(0, 0, 210, 33);
		JPanel_2.add(JPanel_2_Header);
		
		JPanel JPanel_3 = new JPanel();
		JPanel_3.setBackground(new Color(51, 102, 153));
		JPanel_3.setBounds(691, 49, 210, 150);
		panel.add(JPanel_3);
		JPanel_3.setLayout(null);
		
		JPanel JPanel_3_Header = new JPanel();
		JPanel_3_Header.setBackground(Color.DARK_GRAY);
		JPanel_3_Header.setBounds(0, 0, 210, 33);
		JPanel_3.add(JPanel_3_Header);
		JPanel_3_Header.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Authors");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 11, 113, 14);
		JPanel_3_Header.add(lblNewLabel_3);
		
		this.setLocationRelativeTo(null);
		
		displayImage();
		
		//add a border
		Border panelHeaderBorder = BorderFactory.createMatteBorder(0,0,1,0, Color.white);
		JPanel_Header.setBorder(panelHeaderBorder);
		
		Border panelHeader_1_Border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		JPanel_1_Header.setBorder(panelHeader_1_Border);
		
		JLabel lblNewLabel = new JLabel("Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 95, 14);
		JPanel_1_Header.add(lblNewLabel);
		
		Border panelHeader_2_Border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		JPanel_2_Header.setBorder(panelHeader_2_Border);
		JPanel_2_Header.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Members");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 11, 99, 14);
		JPanel_2_Header.add(lblNewLabel_2);
		
		Border panelHeader_3_Border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		JPanel_3_Header.setBorder(panelHeader_3_Border);
	}
	
	public void displayImage() {
		//get the image
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Images/book_dash_logo.png"));
		
		//make the image fit the JLabel
		Image image = imgIco.getImage().getScaledInstance(JLabel_Dashboard_Logo.getWidth(),JLabel_Dashboard_Logo.getHeight(), Image.SCALE_SMOOTH);
		
		//set the image int the JLabel
		JLabel_Dashboard_Logo.setIcon(new ImageIcon(image));
	}
}
