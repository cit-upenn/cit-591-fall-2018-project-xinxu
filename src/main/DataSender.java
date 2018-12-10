package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that sends the location data and the painting info to the html file
 * @author XuDF
 *
 */
public class DataSender {
	
	private File fileName;
	
	/**
	 * Constructor of the class
	 * @param filename
	 */
	DataSender(String filename){
		this.fileName = new File(filename);
	}
	
	/**
	 * method that pass the location data to the html file
	 * @param caseValue: decides which location and title should be changed
	 * @param newAddress: location of the art
	 * @param newTitle: title of the art
	 */
	public void changeFile(int caseValue, String newAddress, String newTitle) {
        String oldContent = "";
        BufferedReader reader = null;
		FileWriter writer = null;
		int addressIndex = 0;
		int titleIndex = 0;
        
		try {
            reader = new BufferedReader(new FileReader(fileName));
            //Reading all the lines of input hmtl file into oldContent
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            reader.close();
			
	        if(caseValue == 0) {
	        	addressIndex = oldContent.indexOf("<div id = \"address0\">");
	        	titleIndex = oldContent.indexOf("<div id = \"title0\">");
	        }else if(caseValue == 1) {
	        	addressIndex = oldContent.indexOf("<div id = \"address1\">");
	        	titleIndex = oldContent.indexOf("<div id = \"title1\">");
	        }else if(caseValue == 2) {
		    	addressIndex = oldContent.indexOf("<div id = \"address2\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title2\">");
		    }else if(caseValue == 3) {
		    	addressIndex = oldContent.indexOf("<div id = \"address3\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title3\">");
		    }else if(caseValue == 4) {
		    	addressIndex = oldContent.indexOf("<div id = \"address4\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title4\">");
		    }else if(caseValue == 5) {
		    	addressIndex = oldContent.indexOf("<div id = \"address5\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title5\">");
		    }else if(caseValue == 6) {
		    	addressIndex = oldContent.indexOf("<div id = \"address6\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title6\">");
		    }else if(caseValue == 7) {
		    	addressIndex = oldContent.indexOf("<div id = \"address7\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title7\">");
		    }else if(caseValue == 8) {
		    	addressIndex = oldContent.indexOf("<div id = \"address8\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title8\">");
		    }else if(caseValue == 9) {
		    	addressIndex = oldContent.indexOf("<div id = \"address9\">");
		    	titleIndex = oldContent.indexOf("<div id = \"title9\">");
		    }
	        //System.out.println(index);
	        
		    //Replacing oldString with newString in the oldContent
	        int startAddressIndex = addressIndex + 21;
	        int endAddressIndex = 0;
	        int startTitleIndex = titleIndex + 19;
	        int endTitleIndex = 0;
	        
	        for(int i = startAddressIndex;;i++) {
	        	if(oldContent.charAt(i) == ('<')) {
	        		endAddressIndex = i - 1;
	        		break;
	        	}
	        }
	        
	        for(int i = startTitleIndex;;i++) {
	        	if(oldContent.charAt(i) == ('<') && oldContent.charAt(i+1)==('/')) {
	        		endTitleIndex = i - 1;
	        		break;
	        	}
	        }
	        
	        //replace the old locations and titles with new ones
	        String s1 = oldContent.substring(0, startAddressIndex);
	        String s2 = oldContent.substring(endAddressIndex + 1, startTitleIndex);
	        String s3 = oldContent.substring(endTitleIndex + 1, oldContent.length());
	        String newContent = s1 + newAddress + s2 + newTitle + s3;
	         
	        //Rewriting the input text file with newContent
	         
	        writer = new FileWriter(fileName);
	         
	        writer.write(newContent);
	        
	        writer.close();
		}catch (IOException e){
			
            e.printStackTrace();
        }
	}     

}
