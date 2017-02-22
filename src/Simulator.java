import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Simulator {

 ArrayList<String> list =new ArrayList<String>();
	
	File file =new File("transactions.txt");
	
	try
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine())!=null)
		{
		 list.add(line);	
		}
		reader.close();
		
	}
	catch(Exception e)
	{
	
		
	}
	
	
	
	
}
