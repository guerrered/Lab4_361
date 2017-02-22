import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Atm {
	Bank bank;
	Scanner scan;
	Display DIS;
	Printer printer;

	public Atm(){
		bank = new Bank();
		scan = new Scanner(System.in);
		DIS = new Display();
		printer = new Printer();
	}
	
	public void start(){
		while(){
			int accountNum = scan.nextInt();
			boolean valid = false;
			
			while(valid != true){
					DIS.Print("Enter PIN");
					int PIN = getNum();
					valid = validate(accountNum, PIN);
					if(valid == false){
						DIS.Print("Incorrect PIN");
					}
			}
			DIS.Print("To Withdraw enter W\n to check balance enter CB\n to end transactino enter CANCEL");
			String choice = getChoice();
			while( choice != "CANCEL"){
				double amount = 0;
				if(choice == "W"){
					DIS.Print("How much would you like to Withdraw?");
					amount = getNum();
					Withdraw(amount);
				}
				else if(choice == "CB"){
					DIS.Print("Balance: " + bank.getBalance());
				}
				printReceipt(choice, amount);
				DIS.Print("To deposit enter 'D'\n to withdraw enter 'W'\nto exit enter 'E'");
				choice = getChoice();
			}
		}
	}
	
	public boolean validate(int accountNum, int PIN){
		return bank.validate(accountNum, PIN);
	}

	public double Withdraw(double amount){
		if(!bank.withdraw(amount)){
			System.out.println("Not enough funds\nBalance: " + bank.getBalance() );
		}
		return amount;
	}
	
	public double Deposit(double amount){
		bank.deposit(amount);
		return amount;
	}
	public String getBalance(){
		return bank.getBalance();
	}
	
	public int getNum(){
		return Integer.parseInt(scan.nextLine());
	}
	
	public String getChoice(){
		return scan.nextLine();
	}
	public void printReceipt(String action,  double amount){
		printer.Print(getCurrentTime() + action + " : " + amount);
	}
	
	public String getCurrentTime(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    
		return df.format(dateobj);
	}
}
