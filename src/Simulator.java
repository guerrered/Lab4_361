import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {

	
	
 ArrayList<String> list =new ArrayList<String>();
	
	public Simulator(){
	
		    Atm atm=new Atm();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter 'C' for console input or 'F' for file input\n");
			String choice = scan.nextLine();
			while(!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("F")){
				System.out.println("Enter 'C' for console input or 'F' for file input\n");
				choice = scan.nextLine();
			}
			if(choice.equalsIgnoreCase("f")){
				System.out.println("Enter the name of the input file");
				String fileName = scan.nextLine();
				scan.close();
				readFromFile(fileName);	
			}
			else{
				System.out.println("Reading from console");
				readFromConsole(scan);
			}
		
	}	
		
	public void readFromFile(String file)
	{
	try(BufferedReader buff = new BufferedReader(new FileReader(file))){
		String currentLine;
		while((currentLine = buff.readLine()) != null){
			commandExec(currentLine);
		}
	}catch(IOException e){
		e.printStackTrace();
	}
	
	}
	
	public void readFromConsole(Scanner scan){
		//whole system exits with exit command
		String command;
		System.out.println("Enter Command\n");
		while(scan.hasNext()){
			command = scan.nextLine();
			commandExec(command);
			System.out.println("Enter Command\n");
		}
	}
	
	public void commandExec(String command){
		System.out.println(command);
		String [] instructions = command.split(" ");
		switch(instructions[0]){
		case("CARDREAD"):
			
			
			break;
		case("NUM"):
			
			break;
		case("DIS"):
			
			break;
	
		default:
			System.out.println("Not a valid command\n");
			break;
		}
	}
	
 }
	

