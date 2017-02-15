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
			boolean valid = bank.validate(accountNum);
			String choice = courseofAction();
			if(choice == "W"){
				Withdraw(accountNum);
			}
			else if(choice == "D"){
				Deposit(accountNum);
			}
		}
	}
	
	public boolean validate(int accountNum){
		int PIN = enterPin();
		return bank.validate(accountNum, PIN);
	}
	
	public int enterPin(){
		int PIN = scan.nextInt();
		return PIN;
	}
	
	public String courseofAction(){
		System.out.println("To deposit enter 'D' to withdraw enter 'W'\n");
		return scan.next();
	}
	
	public void Withdraw(int accountNum){
		System.out.println("How much would you like to Withdraw?\n");
		double amount = scan.nextDouble();
		bank.withdraw(amount);
		printReceipt("Deposit", accountNum, amount);
	}
	public void Deposit(int accountNum){
		System.out.println("How much would you like to Deposit?\n");
		double amount = scan.nextDouble();
		bank.deposit(amount);
		printReceipt("Deposit", accountNum, amount);
	}
	
	public void printReceipt(String action, int accountNum, double amount){
		System.out.println(action + "from " + accountNum +" : " + amount);
	}
}
/*
 * String userIn;
		Scanner stdIn = new Scanner(System.in);
		System.out.println("ATM is ready for use!");
		System.out.println("---------------------");
		System.out.println("Please enter your account number!");
		userIn = stdIn.nextInt();
		if(!Bank.validate(userIn)){
			System.out.println("Account not found. Exiting");
			System.exit(0);
		}
 */
