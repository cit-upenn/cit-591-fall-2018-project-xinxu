import java.util.ArrayList;

public class ArtworkCatalog {

	public static void main(String[] args) {
		CatalogFileReader cfr = new CatalogFileReader("catalog.txt");
		ArrayList<Artwork> aws = cfr.readCatalog();
		
		
	}
}
