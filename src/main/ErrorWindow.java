package main;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class builds the error window.
 * 
 * @author keqin zhou
 *
 */
public class ErrorWindow {
	// constructor
	public ErrorWindow() {

	}

	// add error window with input image
	public void errorWindow(BufferedImage ex) {
		JFrame errorframe = new JFrame();
		errorframe.setSize(1000, 1000);
		JPanel errorpanel = new JPanel();
		errorframe.setTitle("Oops!");
		JLabel message = new JLabel("<html> Oops! Something went wrong. <br/>"
				+ "Incompatible name format or unfound artist. <br/>" + "<html>");
		Image dimg = ex.getScaledInstance(1500, 600, Image.SCALE_SMOOTH);
		errorpanel.add(message);
		JLabel picture = new JLabel(new ImageIcon(dimg));
		errorpanel.add(picture);
		errorframe.add(errorpanel);
		errorframe.pack();
		errorframe.setVisible(true);
		errorframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
