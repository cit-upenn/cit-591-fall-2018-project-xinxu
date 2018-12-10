package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ArtAnalysis;
import main.CatalogFileReader;
import main.DataSender;
import main.Artwork;

/**
 * This class tests all classes and
 * 
 * @author keqin zhou
 *
 */
public class AppTest {
    
	ArtAnalysis myaa;
	CatalogFileReader mycfr;
	ArrayList<Artwork> myaws;
	DataSender ds0;
	DataSender ds1;
	DataSender ds2;
	DataSender ds3;
	DataSender ds4;
	DataSender ds5;
	DataSender ds6;
	DataSender ds7;
	DataSender ds8;
	DataSender ds9;
	

	@BeforeEach
	public void setUp() throws FileNotFoundException {
		//construct all objects
		mycfr = new CatalogFileReader("catalog.csv");
		myaws = mycfr.readCatalog();
		myaa = new ArtAnalysis(myaws);
		ds0 = new DataSender("Test0.txt");
		ds1 = new DataSender("Test1.txt");
		ds2 = new DataSender("Test2.txt");
		ds3 = new DataSender("Test3.txt");
		ds4 = new DataSender("Test4.txt");
		ds5 = new DataSender("Test5.txt");
		ds6 = new DataSender("Test6.txt");
		ds7 = new DataSender("Test7.txt");
		ds8 = new DataSender("Test8.txt");
		ds9 = new DataSender("Test9.txt");
	}

	// Test Purpose: tests getTitle() in ArtAnalysis
	@Test
	public void test1() {
		assertEquals("Medal commemorating Charles II embarkation at Scheveningen",
				myaa.getTitle("ABEELE, Pieter van").get(0));
	}

	@Test
	public void test2() {
		assertEquals("Boy with a Basket of Fish", myaa.getTitle("CERUTI, Giacomo").get(4));
	}

	// Test Purpose: tests getInfo() in ArtAnalysis
	@Test
	public void test3() {
		assertEquals("Italian", myaa.getInfo("Virgin and Child Enthroned with Saints").get(2));
	}

	@Test
	public void test4() {
		assertEquals("religious", myaa.getInfo("Virgin and Child Enthroned with Saints").get(4));
	}

	@Test
	public void test5() {
		assertEquals("1521", myaa.getInfo("Santo Spirito Altarpiece").get(1));
	}

	@Test
	public void test6() {
		assertEquals("(active 1372, Orvieto, d. 1401, Perugia)",
				myaa.getInfo("Virgin and Child Enthroned with Saints").get(6));
	}

	// Test Purpose: tests getters in Artwork
	@Test
	public void test7() {
		assertEquals("AACHEN, Hans von", myaws.get(0).getAuthor());
	}

	@Test
	public void test8() {
		assertEquals("Oil on copper, 56 x 47 cm", myaws.get(0).getTechnique());
	}

	@Test
	public void test9() {
		assertEquals("(b. ca. 1680, London, d. 1751, London)", myaws.get(16350).getLifespan());
	}

	@Test
	public void test10() {
		assertEquals("Metropolitan Museum of Art, New York", myaws.get(16212).getLocation());
	}

	@Test
	public void test11() {
		assertEquals("https://www.wga.hu/html/k/kneller/howard.html", myaws.get(21755).getUrl());
	}

	@Test
	public void test12() {
		assertEquals("https://www.wga.hu/html/s/stoss/annuncib.html", myaws.get(39208).getUrl());
	}

	// Test Purpose: tests getInfo() in ArtAnalysis
	@Test
	public void test13() {
		assertEquals("Oil on canvas, 287 x 268 cm", myaa.getInfo("Santo Spirito Altarpiece").get(3));
	}

	// Test Purpose: tests getters in Artwork
	@Test
	public void test14() {
		assertEquals("1517-18", myaws.get(34000).getDate());
	}

	@Test
	public void test15() {
		assertEquals("Italian", myaws.get(34000).getSchool());
	}

	// Test Purpose: tests getInfo() in ArtAnalysis
	@Test
	public void test16() {
		assertEquals("(b. ca. 1480, Venezia, d. 1556, Loreto)", myaa.getInfo("Santo Spirito Altarpiece").get(6));
	}

	// Test Purpose: tests getters in Artwork
	@Test
	public void test17() {
		assertEquals("1501-1550", myaws.get(34000).getTimeframe());
	}

	// Test Purpose: tests changeFile() in DataSender
	@Test
	public void test18() {
		assertEquals('a',
				ds0.changeFile(0, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test19() {
		assertEquals('a',
				ds1.changeFile(1, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test20() {
		assertEquals('a',
				ds2.changeFile(2, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test21() {
		assertEquals('a',
				ds3.changeFile(3, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test22() {
		assertEquals('a',
				ds4.changeFile(4, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test23() {
		assertEquals('a',
				ds5.changeFile(5, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test24() {
		assertEquals('a',
				ds6.changeFile(6, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test25() {
		assertEquals('a',
				ds7.changeFile(7, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test26() {
		assertEquals('a',
				ds8.changeFile(8, "abcaa", "abccc").charAt(29));
	}
	
	@Test
	public void test27() {
		assertEquals('a',
				ds9.changeFile(9, "abcaa", "abccc").charAt(29));
	}

}
