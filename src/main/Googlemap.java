package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Googlemap{

	public static void main(String[] args) {
		
		try {
			URL map;
			URLConnection yc;
			map = new URL("https://maps.googleapis.com/maps/api/js?key=AIzaSyBCEgbTqI9cNDTE7Ig92HcGWVRgqS7OX3A&callback=initMap");
			yc = map.openConnection();
			BufferedReader in;
			String inputLine;
			in = new BufferedReader(new InputStreamReader(
	                 yc.getInputStream()));
			while ((inputLine = in.readLine()) != null) 
			     System.out.println(inputLine);
			in.close();
		} catch (MalformedURLException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
		
		e1.printStackTrace();
	   
	}

	}
	
}
