
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataSender {
	
	private File fileName;
	
	DataSender(String filename){
		this.fileName = new File(filename);
	}
	
	
	public String readFile()
    {    
        String oldContent = "";
         
        BufferedReader reader = null;
         
        
         
        try
        {
            reader = new BufferedReader(new FileReader(fileName));
             
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
	
	public void changeFile(int caseValue, String oldContent, String newString) {
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
	         
	        writer = new FileWriter(fileName);
	         
	        writer.write(newContent);
	        
	        writer.close();
		}
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
     


}
