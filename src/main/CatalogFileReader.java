package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class reads in file, construct Artwork objects and add into
 * ArrayList<Artwork>.
 * 
 * @author keqin zhou
 *
 */

public class CatalogFileReader {
	File fileName;

	/**
	 * Constructor of the class
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public CatalogFileReader(String fileName) throws FileNotFoundException {
		this.fileName = new File(fileName);
	}

	public ArrayList<Artwork> readCatalog() {
		ArrayList<Artwork> aws = new ArrayList<Artwork>();
		try {
			// scan file
			Scanner scan = new Scanner(this.fileName);
			scan.nextLine();
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] parts = line.split(",");
				ArrayList<String> s = new ArrayList<String>();
				int i = 0;
				// parse and get rid of ""
				while (i < parts.length) {
					if (parts[i].charAt(0) == '"' && parts[i].charAt(parts[i].length() - 1) != '"') {
						int j = i + 1;

						while (parts[j].charAt(parts[j].length() - 1) != '"') {
							parts[i] = parts[i] + "," + parts[j];
							j++;
						}
						String q = parts[i] + "," + parts[j];
						s.add(q.substring(1, q.length() - 1));
						i = j + 1;

					} else {
						s.add(parts[i]);
						i++;
					}
				}
				// assign variables
				String author = s.get(0);
				String lifespan = s.get(1);
				String title = s.get(2);
				String date = s.get(3);
				String technique = s.get(4);
				String location = s.get(5);
				String url = s.get(6);
				String form = s.get(7);
				String type = s.get(8);
				String school = s.get(9);
				String timeframe = s.get(10);
				// constructor Artwork object and add to ArrayList<Artwork> aws
				Artwork aw = new Artwork(author, lifespan, title, date, technique, location, url, form, type, school,
						timeframe);
				aws.add(aw);
			}
			scan.close();
		} catch (IOException e) {
			System.out.println("Error reading file ");
			e.printStackTrace();
		}
		return aws;
	}

}
