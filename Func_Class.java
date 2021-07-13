package My_Classes;

import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Func_Class {

	public void displayImage(int width, int height, byte[] imagebyte, String imagePath, JLabel label)
	{
		// get the image
		if(imagebyte != null) 
		{
			ImageIcon imgIco = new ImageIcon(imagebyte); //get image by using bytes
			
			// make the image fit the JLabel
			Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			
			// set the image int the JLabel
			label.setIcon(new ImageIcon(image));
		}
		else
		{
			try {
				
				//get the image from the project ressources
				ImageIcon imgIco = new ImageIcon(getClass().getResource(imagePath));
				
				// make the image fit the JLabel
				Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				
				// set the image int the JLabel
				label.setIcon(new ImageIcon(image));
			}
			catch(Exception ex) {
				
				//get the image from the desktop
				ImageIcon imgIco = new ImageIcon(imagePath);
				
				// make the image fit the JLabel
				Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				
				// set the image int the JLabel
				label.setIcon(new ImageIcon(image));
				
			}
	
		}

	}

	public ResultSet getData(String query) {

		PreparedStatement ps;
		ResultSet rs = null;

		try {

			ps = DB.getConnection().prepareStatement(query);
			rs = ps.executeQuery();

		} catch (SQLException ex) {
			Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
	
		}
		return rs;
	}
	

}
