import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogReader {
	
	String fileName;

	public CatalogReader(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public ArrayList<Painting> readCatalog() throws FileNotFoundException, IOException{
		ArrayList<Painting> paintings = new ArrayList<>();
		
		Scanner scan = new Scanner(this.fileName);
		scan.nextLine();
		System.out.println(scan.nextLine());
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] lineParts = line.split("\t");
			//System.out.println("check");
			
		}
		
		scan.close();
		
		return paintings;
	}

}
