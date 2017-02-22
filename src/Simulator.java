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
				readFromFile("transactions.txt");	
			}
			else{
				System.out.println("Reading from console");
				readFromConsole(scan);
			}
		
	}	
		
	public void readFromFile(String file)
	{
	try(BufferedReader buff = new BufferedReader(new FileReader("transactions.txt"))){
		String currentLine;
		while((currentLine = buff.readLine()) != null){
		//	commandExec(currentLine);
		}
	}catch(IOException e){
		e.printStackTrace();
	}
	
	}
	
	public void readFromConsole(Scanner scan){
		//whole system exits with exit command
		String command;
		long timeStamp;
		String toExec;
		System.out.println("Enter Command\n");
		while(scan.hasNext()){
			command = scan.nextLine();
			timeStamp = System.currentTimeMillis();
			toExec = timeStamp + " " + command;
			commandExec(toExec);
			System.out.println("Enter Command\n");
		}
	}
	
	public void commandExec(String command){
		System.out.println(command);
		String [] instructions = command.split(" ");
		switch(instructions[1]){
		case("CARDREAD"):
			
			break;
		case("NUM"):
			
			break;
		case("DIS"):
			this.exit();
			break;
		case("Time"):
			console.Time();
			break;
		case("newRun"):
			console.newRun();
			break;
		case("endRun"):
			console.endRun(Integer.parseInt(instructions[2]));//might have to find and remove run with this name/ number ;
			break;
		case("Swap"):
			console.Swap(Integer.parseInt(instructions[2]), Integer.parseInt(instructions[3]));
			break;
		case("DNF"):
			console.DNF(Integer.parseInt(instructions[2]));
			break;
		case("Clear"):
			console.Clear(Integer.parseInt(instructions[2]));
			break;
		case("Cancel"):
			console.Cancel();
			break;
		case("Print"):
			console.Print();
			break;
		case("Connect"):
			console.Connect();
			break;
		case("Disconnect"):
			console.Disconnect();
			break;
		case("Tog"):
			console.Tog();
			break;
		case("Trig"):
			console.Trig(Integer.parseInt(instructions[2]));
			break;
		case("Start"):
			console.Start();
			break;
		case("Finish"):
			console.Finish();
			break;
		default:
			System.out.println("Not a valid command\n");
			break;
		}
	}
	
 }
	

