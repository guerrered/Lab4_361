import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {

	
	
 ArrayList<String> list =new ArrayList<String>();
	
	public Simulator(){
	
	try(BufferedReader buff = new BufferedReader(new FileReader("transactions.txt"))){
		String currentLine;
		while((currentLine = buff.readLine()) != null){
		//	commandExec(currentLine);
		}
	}catch(IOException e){
		e.printStackTrace();
	}
	
	}
	
	
}
