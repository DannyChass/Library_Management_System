package My_Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

public class ManageGenresForm extends JFrame {

	private JPanel contentPane;
	private JTextField jtextField_ID;
	private JTextField jTextField_Name;
	private JTable jTable_Genres;

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
		func.displayImage(75,60, "/My_Images/hierarchy.png",jLabel_FromTitle);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(70, 127, 42, 37);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblName.setBounds(41, 175, 71, 37);
		panel.add(lblName);
		
		jtextField_ID = new JTextField();
		jtextField_ID.setBounds(122, 132, 132, 27);
		panel.add(jtextField_ID);
		jtextField_ID.setColumns(10);
		
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
					
					
					
				}else {
					
					Genre genre = new Genre();
					genre.addGenre(name);
				}
			}
			
		});
		
		JButton jButton_Edit = new JButton("Edit");
		jButton_Edit.setBounds(140, 250, 120, 27);
		panel.add(jButton_Edit);
		
		JButton jButton_Delete = new JButton("Delete");
		jButton_Delete.setBounds(270, 250, 120, 27);
		panel.add(jButton_Delete);
		
		jTable_Genres = new JTable();
		jTable_Genres.setColumnSelectionAllowed(true);
		jTable_Genres.setToolTipText("");
		jTable_Genres.setBorder(null);
		jTable_Genres.setCellSelectionEnabled(true);
		jTable_Genres.setForeground(new Color(0, 0, 0));
		jTable_Genres.setModel(new DefaultTableModel(
			new Object[][] {
				{"Title1", "Title 2", "Title 3", "Title 4"},
				{"test", "a", "b", "c"},
			},
			new String[] {
				"Title1", "Title 2", "Title 3", "Title 4"
			}
		));
		jTable_Genres.setBounds(417, 104, 250, 173);
		panel.add(jTable_Genres);
		
		
		jTable_Genres.setSelectionBackground(Color.LIGHT_GRAY);
		jTable_Genres.setShowGrid(true);
		jTable_Genres.setBackground(new Color(248,248,248));
		jTable_Genres.getTableHeader().setForeground(Color.white);
		jTable_Genres.getTableHeader().setOpaque(false);
	}
}
