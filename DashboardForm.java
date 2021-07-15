package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import My_Classes.Func_Class;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Cursor;

public class DashboardForm extends JFrame {

	private JPanel contentPane;
	private final JLabel JLabel_Dashboard_Logo = new JLabel("");
	private JPanel jPanel_Menu;
	private JPanel jPanel_Header;

	// the button border
	Border buttonBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
	Border buttonBorder0 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY);
	
	
	Func_Class func = new Func_Class();

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
		setBounds(100, 100, 942, 492);
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

		jPanel_Menu = new JPanel();
		jPanel_Menu.setBackground(new Color(64, 64, 64));
		jPanel_Menu.setBounds(0, 11, 225, 446);
		panel.add(jPanel_Menu);
		jPanel_Menu.setLayout(null);

		jPanel_Header = new JPanel();
		jPanel_Header.setBackground(new Color(51, 102, 153));
		jPanel_Header.setBounds(0, 0, 225, 105);
		jPanel_Menu.add(jPanel_Header);
		jPanel_Header.setLayout(null);
		JLabel_Dashboard_Logo.setBounds(7, 16, 75, 78);
		jPanel_Header.add(JLabel_Dashboard_Logo);

		JLabel lblNewLabel_1 = new JLabel("Library");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(84, 31, 139, 52);
		jPanel_Header.add(lblNewLabel_1);

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

		// add a border
		Border panelHeaderBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		jPanel_Header.setBorder(panelHeaderBorder);

		JLabel lblNewLabel_5 = new JLabel("Members");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(0, 258, 207, 25);
		jPanel_Menu.add(lblNewLabel_5);

		JButton jButton_Add_Member = new JButton("Add Member");
		jButton_Add_Member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMemberForm addMemberF = new AddMemberForm();
				addMemberF.setVisible(true);
			}
		});
		jButton_Add_Member.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Add_Member.setBorderPainted(false);
		jButton_Add_Member.setContentAreaFilled(false);
		jButton_Add_Member.setFocusable(false);
		jButton_Add_Member.setAlignmentX(Component.CENTER_ALIGNMENT);
		jButton_Add_Member.setBackground(Color.DARK_GRAY);
		jButton_Add_Member.setForeground(Color.WHITE);
		jButton_Add_Member.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jButton_Add_Member.setBounds(0, 294, 113, 23);
		jPanel_Menu.add(jButton_Add_Member);

		JButton jButton_Edit_Member = new JButton("Edit Member");
		jButton_Edit_Member.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Edit_Member.setBorderPainted(false);
		jButton_Edit_Member.setBorder(UIManager.getBorder("Button.border"));
		jButton_Edit_Member.setFocusable(false);
		jButton_Edit_Member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditMemberForm editMemberF = new EditMemberForm();
				editMemberF.setVisible(true);
			}
		});
		jButton_Edit_Member.setForeground(Color.WHITE);
		jButton_Edit_Member.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jButton_Edit_Member.setContentAreaFilled(false);
		jButton_Edit_Member.setBackground(Color.DARK_GRAY);
		jButton_Edit_Member.setAlignmentX(0.5f);
		jButton_Edit_Member.setBounds(0, 319, 113, 23);
		jPanel_Menu.add(jButton_Edit_Member);

		JButton jButton_Delete_Member = new JButton("Delete Member");
		jButton_Delete_Member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//show the DeleteMember Form
				DeleteMemberForm deleteMemberF = new DeleteMemberForm();
				deleteMemberF.setVisible(true);
			}
		});
		jButton_Delete_Member.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Delete_Member.setBorderPainted(false);
		jButton_Delete_Member.setFocusable(false);
		jButton_Delete_Member.setForeground(Color.WHITE);
		jButton_Delete_Member.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jButton_Delete_Member.setContentAreaFilled(false);
		jButton_Delete_Member.setBackground(Color.DARK_GRAY);
		jButton_Delete_Member.setAlignmentX(0.5f);
		jButton_Delete_Member.setBounds(0, 344, 113, 23);
		jPanel_Menu.add(jButton_Delete_Member);

		JButton jButton_Members_List = new JButton("Members List");
		jButton_Members_List.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Members_List.setBorderPainted(false);
		jButton_Members_List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//show the member list form
				MemberListForm membersListF = new MemberListForm();
				membersListF.setVisible(true);
						
			}
		});
		jButton_Members_List.setFocusable(false);
		jButton_Members_List.setForeground(Color.WHITE);
		jButton_Members_List.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jButton_Members_List.setContentAreaFilled(false);
		jButton_Members_List.setBackground(Color.DARK_GRAY);
		jButton_Members_List.setAlignmentX(0.5f);
		jButton_Members_List.setBounds(0, 369, 113, 23);
		jPanel_Menu.add(jButton_Members_List);

		Border panelHeader_1_Border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		JPanel_1_Header.setBorder(panelHeader_1_Border);

		JLabel lblNewLabel = new JLabel("Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 95, 14);
		JPanel_1_Header.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("0");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_4.setBounds(0, 44, 210, 95);
		JPanel_1.add(lblNewLabel_4);

		Border panelHeader_2_Border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		JPanel_2_Header.setBorder(panelHeader_2_Border);
		JPanel_2_Header.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Members");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 11, 99, 14);
		JPanel_2_Header.add(lblNewLabel_2);

		JLabel lblNewLabel_4_1 = new JLabel("0");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_4_1.setBounds(0, 44, 210, 95);
		JPanel_2.add(lblNewLabel_4_1);

		Border panelHeader_3_Border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
		JPanel_3_Header.setBorder(panelHeader_3_Border);

		JLabel lblNewLabel_4_1_1 = new JLabel("0");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_4_1_1.setBounds(0, 44, 210, 95);
		JPanel_3.add(lblNewLabel_4_1_1);

		JPanel JPanel_1_1 = new JPanel();
		JPanel_1_1.setLayout(null);
		JPanel_1_1.setBackground(new Color(51, 102, 153));
		JPanel_1_1.setBounds(251, 296, 650, 150);
		panel.add(JPanel_1_1);

		JPanel JPanel_1_Header_1 = new JPanel();
		JPanel_1_Header_1.setLayout(null);
		JPanel_1_Header_1.setBackground(Color.DARK_GRAY);
		JPanel_1_Header_1.setBounds(0, 0, 650, 33);
		JPanel_1_1.add(JPanel_1_Header_1);

		JLabel lblWeWillAd = new JLabel("\r\n");
		lblWeWillAd.setForeground(Color.WHITE);
		lblWeWillAd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWeWillAd.setBounds(10, 11, 630, 14);
		JPanel_1_Header_1.add(lblWeWillAd);

		JLabel lblNewLabel_4_2 = new JLabel("0");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_4_2.setBounds(0, 44, 650, 95);
		JPanel_1_1.add(lblNewLabel_4_2);
		
		//diplay the logo
		func.displayImage(JLabel_Dashboard_Logo.getWidth(),  JLabel_Dashboard_Logo.getHeight(),null,"/My_Images/book_dash_logo.png", JLabel_Dashboard_Logo);
		
		JLabel lblNewLabel_5_1 = new JLabel("Genre");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(10, 116, 207, 25);
		jPanel_Menu.add(lblNewLabel_5_1);
		
		JButton jButton_Manage_Genres = new JButton("Manage Genres");
		jButton_Manage_Genres.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Manage_Genres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//show the Manage_Genres form
				ManageGenresForm mngGenresF = new ManageGenresForm();
				mngGenresF.setVisible(true);
			}
		});
		jButton_Manage_Genres.setForeground(Color.WHITE);
		jButton_Manage_Genres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jButton_Manage_Genres.setFocusable(false);
		jButton_Manage_Genres.setContentAreaFilled(false);
		jButton_Manage_Genres.setBorderPainted(false);
		jButton_Manage_Genres.setBackground(Color.DARK_GRAY);
		jButton_Manage_Genres.setAlignmentX(0.5f);
		jButton_Manage_Genres.setBounds(0, 153, 113, 23);
		jPanel_Menu.add(jButton_Manage_Genres);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Authors");
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(10, 187, 207, 25);
		jPanel_Menu.add(lblNewLabel_5_1_1);
		
		JButton jButton_Manage_Authors = new JButton("Manage Authors");
		jButton_Manage_Authors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAuthorsForm mngAuthorsForm = new ManageAuthorsForm();
				mngAuthorsForm.setVisible(true);
			}
		});
		jButton_Manage_Authors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButton_Manage_Authors.setForeground(Color.WHITE);
		jButton_Manage_Authors.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jButton_Manage_Authors.setFocusable(false);
		jButton_Manage_Authors.setContentAreaFilled(false);
		jButton_Manage_Authors.setBorderPainted(false);
		jButton_Manage_Authors.setBackground(Color.DARK_GRAY);
		jButton_Manage_Authors.setAlignmentX(0.5f);
		jButton_Manage_Authors.setBounds(0, 224, 113, 23);
		jPanel_Menu.add(jButton_Manage_Authors);
		
		buttonsHoverEffect();

	}

	// create a fonction to add hover effect on the menu
	public void buttonsHoverEffect() {

		// get all the componentr inside the Jpanel_Menu
		Component[] comps = jPanel_Menu.getComponents();

		for (Component comp : comps) {

			// check if the component is a button
			if (comp instanceof JButton) {

				JButton button = (JButton) comp;

				button.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseEntered(MouseEvent evt) {

						button.setBorder(buttonBorder1);
						button.setBorderPainted(true);

					}

					@Override
					public void mouseExited(MouseEvent evt) {

						button.setBorder(buttonBorder0);
						button.setBorderPainted(true);

					}
				});
			}
		}

	}
}
