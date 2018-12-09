package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.ArtAnalysis;
import main.CatalogFileReader;
import main.Artwork;

public class Test {

ArtAnalysis myaa;
CatalogFileReader mycfr;
ArrayList<Artwork> myaws;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException {			
		mycfr = new CatalogFileReader("acatalog.csv");
		myaws = mycfr.readCatalog();
		myaa = new ArtAnalysis(myaws);
	}
	
	//Test Purpose: tests basic functionality
	@Test
	public void test1() {
		assertEquals("Commemorative Medal for Admiral Maarten Harpertszoon Tromp", myaa.getTitle("ABEELE, Pieter van").get(0));	
	}	
	
	@Test
	public void test2() {
		assertEquals("Little Beggar Girl and Woman Spinning", myaa.getTitle("CERUTI, Giacomo").get(4));	
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
		assertEquals("(b. ca. 1325, Firenze, d. ca. 1399, Firenze)", myaa.getInfo("Virgin and Child Enthroned with Saints").get(6));	
	}	
	
	
	@Test
	public void test7() {
		assertEquals("AACHEN, Hans von", myaws.get(0).getAuthor());	
	}	
	
	@Test
	public void test8() {
		assertEquals("Oil on canvas, 53 x 44 cm", myaws.get(0).getTechnique());	
	}
	
	@Test
	public void test9() {
		assertEquals("(b. ca. 1680, London, d. 1751, London)", myaws.get(16350).getLifespan());	
	}	
	
	@Test
	public void test10() {
		assertEquals("British Museum, London", myaws.get(16212).getLocation());	
	}	
	@Test
	public void test11() {
		assertEquals("https://www.wga.hu/html/k/kneller/chinese.html", myaws.get(21755).getUrl());	
	}	
	@Test
	public void test12() {
		assertEquals("https://www.wga.hu/html/s/stoss/annuncia.html", myaws.get(39208).getUrl());	
	}
	
	@Test
	public void test13() {
		assertEquals("Commemorative Medal for Admiral Maarten Harpertszoon Tromp", myaa.getTitle("ABEELE, Pieter van").get(0));	
	}	
	@Test
	public void test14() {
		assertEquals("Commemorative Medal for Admiral Maarten Harpertszoon Tromp", myaa.getTitle("ABEELE, Pieter van").get(0));	
	}	
	@Test
	public void test15() {
		assertEquals("Commemorative Medal for Admiral Maarten Harpertszoon Tromp", myaa.getTitle("ABEELE, Pieter van").get(0));	
	}	
	@Test
	public void test16() {
		assertEquals("Commemorative Medal for Admiral Maarten Harpertszoon Tromp", myaa.getTitle("ABEELE, Pieter van").get(0));	
	}	

}
