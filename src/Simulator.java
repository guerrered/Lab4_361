import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {

	

 ArrayList<String> list =new ArrayList<String>();
    Atm atm;	
    Card c1;

	public Simulator(){
	
		    atm=new Atm();
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
			commandExec(currentLine,null);
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
			commandExec(command,scan);
			System.out.println("Enter Command\n");
		}
	}
	
	public void commandExec(String command, Scanner scan){
		System.out.println(command);
		String [] instructions = command.split(" ");
		switch(instructions[0]){
		case("CARDREAD"):
		c1 = new Card(Integer.parseInt(instructions[1]));
		
		while(true)
		{
		atm.DIS.Print("Please enter your pin");
		 String cnt=scan.nextLine();
		 String sp[]=cnt.split(" ");
		 if(atm.validate(Integer.parseInt(instructions[1]), Integer.parseInt(sp[0])))
		 {
			 break;
		 }
		}
		  break;
		case("BUTTON"):
			commandBal(instructions[1],scan);
	        break;
		case("DIS"):
			atm.DIS.Print(instructions[1]);
			break;
		case("PRINT"):
			atm.printer.Print(instructions[1]);
			break;
		default:
			System.out.println("Not a valid command\n");
			break;
		}
	}
	
	public void commandBal(String str,Scanner scan)
	{
		switch(str)
		{
		case("W"):
			atm.DIS.Print("How much do you want to withdraw");
			System.out.println(atm.Withdraw(Double.parseDouble(scan.nextLine())));		
			break;
		case("CB"):
			atm.DIS.Print("Balance is: " +atm.getBalance());;
			break;
		case("CANCEL"):
			atm.Cancel();		
			//Display();
			break;
		
		}
		
		
		
		
	}
	
 }
	

