import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Atm {
	Bank bank;
	Scanner scan;
	Display DIS;
	Printer printer;
	CardReader cr;
	CashDispenser CD;
	String lastTime;
	String lastAct;
	Double lastAmount; 
	
	public Atm(){
		bank = new Bank();
		scan = new Scanner(System.in);
		DIS = new Display();
		printer = new Printer();
		cr = new CardReader();
		CD = new CashDispenser();
		bank.addAccount(1234,6789,80.0);
		bank.addAccount(6789,4321,60.0);
	}
	
	public void start(){
		while(scan.hasNext()){
			int accountNum = cr.read();
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

	public void LastTractT()
	{ 
		lastTime=getCurrentTime();
		
	}
	
	public void LastAct(String str)
	{
		lastAct=str;
	}
	
	public void LastAmount(double cnt)
	{
		lastAmount=cnt;
	}
	
	public double Withdraw(double amount){
		if(!bank.withdraw(amount)){
			DIS.Print("Not enough funds\nBalance: " + bank.getBalance() );
		}
		else{
			CD.CashDispen(amount);
			LastTractT();
			LastAmount(amount);
			LastAct("Withdraw");
		}
		return amount;
	}
	
	public double Deposit(double amount){
		bank.deposit(amount);
		LastTractT();
		LastAmount(amount);
		LastAct("Deposit");
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
	
	public void Cancel(){
		bank.closeInstance();
		printer.Print("<"+lastTime+">"+"<"+lastAct+">"+"<"+lastAmount+">");
		lastTime=null;
		lastAct=null;
		lastAmount=null;
	}
}
