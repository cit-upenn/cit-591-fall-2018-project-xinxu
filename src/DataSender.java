package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataSender {
	static String readFile(String filePath)
    {
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input hmtl file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
            reader.close();
            
            return oldContent;
            
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "error";
        }

    }
	
	static void changeFile(String filePath, int caseValue, String oldContent, String newString) {
		File fileToBeModified = new File(filePath);
		FileWriter writer = null;
		int index = 0;
        
		try {
	        if(caseValue == 0) {
	        	index = oldContent.indexOf("<div id = \"address0\">");
	        }else if(caseValue == 1) {
	        	index = oldContent.indexOf("<div id = \"address1\">");
	        }else if(caseValue == 2) {
		    	index = oldContent.indexOf("<div id = \"address2\">");
		    } 
	        //System.out.println(index);
	        
		    //Replacing oldString with newString in the oldContent
	        int startIndex = index + 21;
	        int endIndex = 0;
	        for(int i = startIndex;;i++) {
	        	if(oldContent.charAt(i) == ('<')) {
	        		endIndex = i - 1;
	        		break;
	        	}
	        }
	        String s1 = oldContent.substring(0, startIndex);
	        String s2 = oldContent.substring(endIndex + 1, oldContent.length());
	        String newContent = s1 + newString + s2;
	         
	        //Rewriting the input text file with newContent
	         
	        writer = new FileWriter(fileToBeModified);
	         
	        writer.write(newContent);
	        
	        writer.close();
		}
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
     
    public static void main(String[] args)
    {	
    	ArrayList<String> locations = new ArrayList<>();
    	locations.add("Paris");
    	locations.add("Rome");
    	locations.add("Barcelona");
    	
        for(int i = 0; i < 3; i++) {
        	String oldContent = readFile("Geocoding Sample.html");
        	changeFile("Geocoding Sample.html", i, oldContent, locations.get(i));
        }
         
        System.out.println("done");
    }


}
