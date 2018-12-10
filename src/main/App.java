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
 * This class is the main class of the main package. It constructs all the
 * related objects and generate some windows.
 * 
 * @author keqin zhou 
 */

public class App {
	public static void main(String[] args) throws IOException {
		JButton button = new JButton("Search");
		BufferedImage errorWindowImage = ImageIO.read(new File("Wheatfield_with_crows.jpg"));
		JTextField textField = new JTextField(20);
		ArtSearcherWindow asw = new ArtSearcherWindow();
		asw.artSearcher(button, errorWindowImage, textField);
		CatalogFileReader cfr = new CatalogFileReader("catalog.csv");
		ArrayList<Artwork> aws = cfr.readCatalog();
		ArtAnalysis aa = new ArtAnalysis(aws);
		// add search window
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String author = textField.getText().trim();
				ArrayList<String> titlesFromDatabase = new ArrayList<String>();
				ArrayList<String> locationsFromDatabase = new ArrayList<String>();
				ArrayList<String> locationsForMap = new ArrayList<String>();
				ArrayList<String> titlesForMap = new ArrayList<String>();
				if (aa.getTitle(author).isEmpty()) {
					// add error window if error occurs
					ErrorWindow ew = new ErrorWindow();
					ew.errorWindow(errorWindowImage);
				} else {
					titlesFromDatabase.addAll(aa.getTitle(author));
					for (int i = 0; i < titlesFromDatabase.size(); i++) {
						locationsFromDatabase.add(aa.getInfo(titlesFromDatabase.get(i)).get(0));
					}
					// get 10 titles and locations for map
					if (locationsFromDatabase.size() > 10) {
						for (int i = 0; i < 10; i++) {
							locationsForMap.add(locationsFromDatabase.get(i));
							titlesForMap.add(titlesFromDatabase.get(i) + ", " + locationsFromDatabase.get(i));
							// format: "title, location"
						}
					} else {
						locationsForMap.addAll(locationsFromDatabase);
						for (int i = 0; i < locationsFromDatabase.size(); i++) {
							titlesForMap.add(titlesFromDatabase.get(i) + "," + locationsFromDatabase.get(i));
						}
					}
					for (int i = 1; i < locationsForMap.size(); i++) {
						for (int j = i - 1; j >= 0; j--) {
							if (locationsForMap.get(i).equals(locationsForMap.get(j))) {
								titlesForMap.set(i, titlesForMap.get(j) + "<br/>" + titlesForMap.get(i));
								//titlesForMap.set(j, " ");
								break;
							}
						}
					}
					locationsFromDatabase.add(aa.getInfo(aa.getTitle(author).get(0)).get(0));
					// artwork window
					JFrame frame1 = new JFrame();
					frame1.setTitle("Artworks");
					JPanel panel1 = new JPanel();
					JPanel panel2 = new JPanel();
					JButton whereButton = new JButton("Where are they");
					whereButton.setPreferredSize(new Dimension(200, 40));
					frame1.setLayout(new BorderLayout());
					panel1.add(whereButton);
					panel2.setLayout(new GridLayout(25, 6));
					ArrayList<JButton> jls = new ArrayList<JButton>();
					for (int i = 0; i < titlesFromDatabase.size(); i++) {
						JButton jl = new JButton(titlesFromDatabase.get(i));
						jls.add(jl);
						panel2.add(jl);
					}
					whereButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// construct DataSender
							DataSender ds = new DataSender("Geocoding Sample.html");
							// get 10 locations and set Private collection " "
							if (locationsForMap.size() == 10) {
								for (int i = 0; i < 10; i++) {
									if (locationsForMap.get(i).equals("Private collection")) {
										ds.changeFile(i, " ", " ");
									} else {
										ds.changeFile(i, locationsForMap.get(i), titlesForMap.get(i));
									}
								}
							} else {
								int size = locationsForMap.size();
								for (int i = 0; i < 10; i++) {
									if (i < size) {
										if (locationsForMap.get(i).equals("Private collection")) {
											ds.changeFile(i, " ", " ");
										} else {
											ds.changeFile(i, locationsForMap.get(i), titlesForMap.get(i));
										}
									} else {
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

					frame1.add(panel1, BorderLayout.NORTH);
					frame1.add(panel2, BorderLayout.SOUTH);
					frame1.pack();
					frame1.setVisible(true);
					frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					// buttons for all artwork
					for (int i = 0; i < titlesFromDatabase.size(); i++) {
						String title = titlesFromDatabase.get(i);
						jls.get(i).addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								ArrayList<String> info = new ArrayList<String>();
								info = aa.getInfo(title);
								String url = info.get(5);
								// parse url and get image path
								url = url.replaceFirst("html", "art");
								url = url.replaceFirst("html", "jpg");
								URL img = null;
								try {
									img = new URL(url);
								} catch (MalformedURLException e1) {
									e1.printStackTrace();
								}
								// information window
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
