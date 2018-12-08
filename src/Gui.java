
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

public class Gui {

	
	
	public static void main(String[] args) throws IOException {
		JButton button = new JButton("Search");	
		BufferedImage ex = ImageIO.read(new File("Wheatfield_with_crows.jpg"));
		JTextField textField = new JTextField(20);
		ArtSearcherWindow asw = new ArtSearcherWindow();
		asw.artSearcher(button,ex,textField );
		
		CatalogFileReader cfr = new CatalogFileReader("acatalog.csv");
		ArrayList<Artwork> aws = cfr.readCatalog();
		ArtAnalysis aa = new ArtAnalysis(aws);

	
	    button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String author = textField.getText().trim();
			ArrayList<String> ts = new ArrayList<String>();
			ArrayList<String> ls = new ArrayList<String>();
			ArrayList<String> ls20 = new ArrayList<String>();
			ArrayList<String> tls = new ArrayList<String>();
			
			if(aa.getTitle(author).isEmpty()) {
				ErrorWindow ew = new ErrorWindow();
				ew.errorWindow(ex);
			}else {
			ts.addAll(aa.getTitle(author));	
			
			for (int i=0;i<ts.size();i++) {
				ls.add(aa.getInfo(ts.get(i)).get(0));
			}
			
			
			if (ls.size() > 20) {
				for(int i=0;i<20;i++) {
					ls20.add(ls.get(i));    //20 locations
					tls.add(ts.get(i)+", "+ls.get(i)); //20 "titles, locations"
				}		
			}else {
				ls20.addAll(ls);
				for(int i=0;i<ls.size();i++) {
					tls.add(ts.get(i)+","+ls.get(i));
				}
			}
							
			ls.add(aa.getInfo(aa.getTitle(author).get(0)).get(0));	
			
			JFrame frame1 = new JFrame();
			frame1.setTitle("Artworks");		
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JButton b = new JButton("Where are they");	
			frame1.setLayout(new BorderLayout());
			panel1.add(b);
			panel2.setLayout(new GridLayout(25,6));
			ArrayList<JButton> jls = new ArrayList<JButton>();
			for(int i=0;i<ts.size();i++) {
			JButton jl = new JButton(ts.get(i));
			jls.add(jl);
			panel2.add(jl);
			}
			
			 b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String l  = ls.get(0);
						DataSender ds = new DataSender ("Geocoding Sample.html");
						String oldContent = ds.readFile();
						ds.changeFile(0, oldContent, l);
						
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
			
			InfoLocationWindow ilw = new InfoLocationWindow();
			ilw.infoLocation(title, author, info, img);
				
		}
	});
			}
		}		
		}
		});
	}
	  
	
}
