package main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
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

public class App {

	
	
	public static void main(String[] args) throws IOException {
		JButton button = new JButton("Search");	
		BufferedImage ex = ImageIO.read(new File("Wheatfield_with_crows.jpg"));
		JTextField textField = new JTextField(20);
		ArtSearcherWindow asw = new ArtSearcherWindow();
		asw.artSearcher(button,ex,textField );
		
		CatalogFileReader cfr = new CatalogFileReader("acatalog.csv");
		ArrayList<Artwork> aws = cfr.readCatalog();
		ArtAnalysis aa = new ArtAnalysis(aws);
		System.out.println(aws.get(34000).getTimeframe());

	    button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String author = textField.getText().trim();
			ArrayList<String> titlesFromDatabase = new ArrayList<String>();
			ArrayList<String> locationsFromDatabase = new ArrayList<String>();
			ArrayList<String> locationsForMap = new ArrayList<String>();
			ArrayList<String> titlesForMap = new ArrayList<String>();
			
			if(aa.getTitle(author).isEmpty()) {
				ErrorWindow ew = new ErrorWindow();
				ew.errorWindow(ex);
			}else {
			titlesFromDatabase.addAll(aa.getTitle(author));	
			
			for (int i=0;i<titlesFromDatabase.size();i++) {
				locationsFromDatabase.add(aa.getInfo(titlesFromDatabase.get(i)).get(0));
			}
			
			
			if (locationsFromDatabase.size() > 10) {
				for(int i=0;i<10;i++) {
					locationsForMap.add(locationsFromDatabase.get(i));    //20 locations
					titlesForMap.add(titlesFromDatabase.get(i)+", "+locationsFromDatabase.get(i)); //20 "titles, locations"
				}		
			}else {
				locationsForMap.addAll(locationsFromDatabase);
				for(int i=0;i<locationsFromDatabase.size();i++) {
					titlesForMap.add(titlesFromDatabase.get(i)+","+locationsFromDatabase.get(i));
				}
			}
			
			for(int i = 1; i < locationsForMap.size();i++) {
				for(int j = i - 1; j >= 0; j--) {
					if(locationsForMap.get(i).equals(locationsForMap.get(j))) {
						titlesForMap.set(i, titlesForMap.get(j)+ "<br/>" + titlesForMap.get(i));
						titlesForMap.set(j, " ");
						break;
					}
				}
			}
     		locationsFromDatabase.add(aa.getInfo(aa.getTitle(author).get(0)).get(0));	
			
			JFrame frame1 = new JFrame();
			frame1.setTitle("Artworks");		
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JButton b = new JButton("Where are they");	
			b.setPreferredSize(new Dimension(200, 40));
			frame1.setLayout(new BorderLayout());
			panel1.add(b);
			panel2.setLayout(new GridLayout(25,6));
			ArrayList<JButton> jls = new ArrayList<JButton>();
			for(int i=0;i<titlesFromDatabase.size();i++) {
			JButton jl = new JButton(titlesFromDatabase.get(i));
			jls.add(jl);
			panel2.add(jl);
			}
			
			 b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						DataSender ds = new DataSender ("Geocoding Sample.html");
						
						if(locationsForMap.size() == 10) {
							for(int i = 0; i < 10; i++) {
								if(locationsForMap.get(i).equals("Private collection")) {
									ds.changeFile(i, " ", " ");
								}else {
									ds.changeFile(i, locationsForMap.get(i), titlesForMap.get(i));
								}
							}
						}else {
							int size = locationsForMap.size();
							for(int i = 0; i < 10; i++) {
								if(i < size) {
									if(locationsForMap.get(i).equals("Private collection")) {
										ds.changeFile(i, " ", " ");
									}else {
										ds.changeFile(i, locationsForMap.get(i), titlesForMap.get(i));
									}
								}else {
									ds.changeFile(i, " ", " ");
								}
							}	
							
						}
						
						
						if (Desktop.isDesktopSupported()) {
						    try {
						        File myFile = new File("Geocoding Sample.html");
						        Desktop.getDesktop().open(myFile);
						    } catch (IOException ex) {
						       
						    }
						}
			
					}
			 });
					
			frame1.add(panel1,BorderLayout.NORTH);
			frame1.add(panel2,BorderLayout.SOUTH);
			frame1.pack();
			frame1.setVisible(true);
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			for(int i=0;i<titlesFromDatabase.size();i++) {
		     String title = titlesFromDatabase.get(i);
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
			
			InformationWindow ilw = new InformationWindow();
			ilw.infoLocation(title, author, info, img);
				
		}
	});
			}
		}		
		}
		});
	}
	  
	
}
