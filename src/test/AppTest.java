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

public class AppTest {

ArtAnalysis myaa;
CatalogFileReader mycfr;
ArrayList<Artwork> myaws;
DataSender ds;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException {			
		mycfr = new CatalogFileReader("catalog.csv");
		myaws = mycfr.readCatalog();
		myaa = new ArtAnalysis(myaws);
		ds = new DataSender("Test1.txt");
	}
	
	//Test Purpose: tests basic functionality
	@Test
	public void test1() {
		assertEquals("Medal commemorating Charles II embarkation at Scheveningen", myaa.getTitle("ABEELE, Pieter van").get(0));	
	}	
	
	@Test
	public void test2() {
		assertEquals("Boy with a Basket of Fish", myaa.getTitle("CERUTI, Giacomo").get(4));	
	}	
	
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
		assertEquals("(active 1372, Orvieto, d. 1401, Perugia)", myaa.getInfo("Virgin and Child Enthroned with Saints").get(6));	
	}	
	
	
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
	
	@Test
	public void test13() {
		assertEquals("Oil on canvas, 287 x 268 cm", myaa.getInfo("Santo Spirito Altarpiece").get(3));	
	}	
	@Test
	public void test14() {
		assertEquals("1517-18",myaws.get(34000).getDate());	
	}	
	@Test
	public void test15() {
		assertEquals("Italian", myaws.get(34000).getSchool());	
	}	
	@Test
	public void test16() {
		assertEquals("(b. ca. 1480, Venezia, d. 1556, Loreto)", myaa.getInfo("Santo Spirito Altarpiece").get(6));	
	}	
	
	
	@Test
	public void test17() {
		assertEquals("1501-1550", myaws.get(34000).getTimeframe());	
	}	
	
	@Test
	public void test18() {
		assertEquals("abcde<div id = \"address0\">abcfg</div>abcde<div id = \"title0\">abcta</div>", ds.changeFile(0, "abcfg", "abcta"));	
	}	
	
	
	

}
