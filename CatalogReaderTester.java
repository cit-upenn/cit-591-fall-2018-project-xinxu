import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CatalogReaderTester {
	
	public static void main(String[] args) {
		CatalogReader cr = new CatalogReader("catalog.txt");
		ArrayList<Painting> paintings = new ArrayList<>();
		
		try {
			paintings = cr.readCatalog();
			System.out.println(paintings);
		}catch(FileNotFoundException e) {
			System.out.println("File not found ");
	    	e.printStackTrace();
		}catch(IOException e) {
			System.out.println("Error reading file ");
	    	e.printStackTrace();
		}
		
	}

}
