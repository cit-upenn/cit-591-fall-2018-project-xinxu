
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javafx.scene.control.Hyperlink;
/**
 * 
 * @author keqin zhou
 *
 */

public class Gui {

	
	public static void main(String[] args) throws IOException {
		
		JFrame frame = new JFrame();
		frame.setSize(700,400);		
		frame.setTitle("Art Searcher");	
	
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("The Name of Artist:");	
		JTextField textField = new JTextField(20);
		JButton button = new JButton("Search");	
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
		
		CatalogFileReader cfr = new CatalogFileReader("acatalog.csv");
		ArrayList<Artwork> aws = cfr.readCatalog();
		ArtAnalysis aa = new ArtAnalysis(aws);

	
	    button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String author = textField.getText().trim();
			ArrayList<String> ts = new ArrayList<String>();
			ts.addAll(aa.getTitle(author));	
			
			
			JFrame frame1 = new JFrame();
			frame1.setSize(700,400);		
			frame1.setTitle("Artworks");
		
			JPanel panel1 = new JPanel();
			Box box = Box.createVerticalBox();
			ArrayList<JButton> jls = new ArrayList<JButton>();
			for(int i=0;i<ts.size();i++) {
			JButton jl = new JButton(ts.get(i));
			jls.add(jl);
			box.add(jl);
			}
			JScrollPane scrollPane = new JScrollPane(box);
			JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
			JButton b = new JButton("Where are they");	
			panel1.add(b);
			frame1.add(scrollPane);
			frame1.add(vbar, BorderLayout.EAST);
			frame1.add(box);
			frame1.setVisible(true);
			frame1.pack();
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			for(int i=0;i<ts.size();i++) {
		     String title = ts.get(i);
			 jls.get(i).addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
			
	        ArrayList<String> info = new ArrayList<String>();
	   
			info = aa.getInfo(title); 
			String url = info.get(5);
			url = url.replaceFirst("html","art");
			url = url.replaceFirst("html","jpg");

			
			URL img = null;
			try {
				img = new URL(url);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			
			ImageIcon image = new ImageIcon(img);
			JLabel p = new JLabel("", image, JLabel.CENTER);
			
			JFrame frame2 = new JFrame();
			frame2.setSize(400,400);
			frame2.setTitle("Info and Location");
			JPanel panel2 = new JPanel();
			JLabel label3 = new JLabel("<html>"+
			"Title: "+title+"<br/>"+
			"Artist: "+author+"<br/>"+
			"Lifespan: "+info.get(5)+"<br/>"+
			"Date: "+info.get(1)+"<br/>"+
			"School: "+info.get(2)+"<br/>"+
			"Technique: "+info.get(3)+"<br/>"+
			"Type: "+info.get(4)+"<br/>"+
			"Form: "+info.get(6)+"<br/>"+
			"Location: "+info.get(0)+"<br/>"+
			"<html>");			
			panel2.add(p);
			panel2.add(label3);	
			frame2.add(panel2);
			frame2.setVisible(true);
			frame2.pack();
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		}
	});
			}
				
		}
		});
	}
	  
	
}
