package main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArtSearcherWindow {

	public ArtSearcherWindow() {
		// TODO Auto-generated constructor stub
	}
	
	public void artSearcher(JButton button, BufferedImage ex,JTextField textField  ) throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(700,400);		
		frame.setTitle("Art Searcher");	
		JPanel panel = new JPanel();	
		JLabel label = new JLabel("The Name of Artist:");	
		String imageLocation = "Water_Lilies.jpg";
		BufferedImage pic = ImageIO.read(new File(imageLocation));
		JLabel picture = new JLabel(new ImageIcon(pic));
		
		
		panel.add(label);
		panel.add(textField);
		panel.add(button); 
		panel.add(picture);
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
