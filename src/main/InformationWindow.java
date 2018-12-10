package main;
import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class builds the information window.
 * @author keqin zhou
 *
 */
public class InformationWindow {
   //constructor 
	public InformationWindow() {
		// TODO Auto-generated constructor stub
	}
	//add the information window
	public void infoLocation(String title, String author, ArrayList<String> info, URL img) {
		JFrame frame2 = new JFrame();
		frame2.setTitle("Information");	
		ImageIcon image = new ImageIcon(img);
		JLabel pic = new JLabel("", image, JLabel.CENTER);
		pic.setPreferredSize(new Dimension(950, 1000));
		JPanel panel1 = new JPanel();
		JLabel label3 = new JLabel("<html>"+	
		"Title: "+title+"<br/>"+
		"Artist: "+author+"<br/>"+
		"Lifespan: "+info.get(6)+"<br/>"+
		"Date: "+info.get(1)+"<br/>"+
		"School: "+info.get(2)+"<br/>"+
		"Technique: "+info.get(3)+"<br/>"+
		"Type: "+info.get(4)+"<br/>"+
		"Form: "+info.get(7)+"<br/>"+
		"Location: "+info.get(0)+"<br/>"+
		"<html>");	
		panel1.add(pic);
		panel1.add(label3);			
		frame2.add(panel1);	
		frame2.setResizable(true);
		frame2.pack();
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

}
