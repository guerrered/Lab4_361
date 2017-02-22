import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Atm {
	Bank bank;
	Scanner scan;

	public Atm(){
		bank = new Bank();
		scan = new Scanner(System.in);
	}
	
	public void start(){
		while(scan.hasNext()== true){
			int accountNum = scan.nextInt();
			boolean valid = false;
			while(valid != true){
					int PIN = scan.nextInt();
					valid = validate(accountNum, PIN);
					if(valid == false){
						System.out.println("Incorrect PIN");
					}
			}
			System.out.println("To deposit enter 'D'\n to withdraw enter 'W'\nto exit enter 'E'");
			String choice = scan.next();
			while( choice != "E"){
				double amount = 0;
				if(choice == "W"){
					System.out.println("How much would you like to Withdraw?");
					amount = scan.nextDouble();
					Withdraw(amount);
				}
				else if(choice == "D"){
					System.out.println("How much would you like to Deposit?");
					amount = scan.nextDouble();
					Deposit(amount);
				}
				printReceipt(choice, accountNum, amount);
				System.out.println("To deposit enter 'D'\n to withdraw enter 'W'\nto exit enter 'E'");
				choice = scan.next();
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
	
	public int getPIN(){
		return Integer.parseInt(scan.nextLine());
	}
	
	public int getNum(){
		return Integer.parseInt(scan.nextLine());
	}
	public void printReceipt(String action, int accountNum, double amount){
		System.out.println(action + "from " + accountNum +" : " + amount);
	}
	
	public String getCurrentTime(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    
		return df.format(dateobj);
	}
}
