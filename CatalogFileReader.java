import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class CatalogFileReader {
	
	File fileName;

	public CatalogFileReader(String fileName){
		this.fileName = new File(fileName);
	}

	public ArrayList<Artwork> readCatalog(){		
		ArrayList<Artwork> aws = new ArrayList<Artwork>();
		try {
			Scanner scan = new Scanner(this.fileName);
			scan.nextLine();
			while(scan.hasNextLine()){
					String line = scan.nextLine();
					String[] parts = line.split("\t");
				    String author = parts[0];
				    String lifespan = parts[1];
				    String title = parts[2];
				    String date = parts[3];
				    String technique = parts[4];
				    String location = parts[5];
				    String url = parts[6];
				    String form = parts[7];
				    String type = parts[8];
				    String school = parts[9];
				    String timeframe = parts[10];
				    Artwork aw = new Artwork(author, lifespan, title, date, technique, location, url, form, type, school, timeframe);
				   aws.add(aw);
			}
			scan.close();
			
	}catch(IOException e){
		System.out.println("Error reading file ");
		e.printStackTrace();
	}
    return aws;
		}
	
}
