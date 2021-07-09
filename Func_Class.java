package My_Classes;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Func_Class {
	
	public void displayImage(int width, int height, String imagePath, JLabel label) {
		// get the image
		ImageIcon imgIco = new ImageIcon(getClass().getResource(imagePath));

		// make the image fit the JLabel
		Image image = imgIco.getImage().getScaledInstance(width,
				height, Image.SCALE_SMOOTH);

		// set the image int the JLabel
		label.setIcon(new ImageIcon(image));
	}

}
