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
					valid = validate(accountNum);
					System.out.println("Incorrect PIN");
			}
			String choice = courseofAction();
			while( choice != "E"){
				double amount = 0;
				if(choice == "W"){
					amount = Withdraw(accountNum);
				}
				else if(choice == "D"){
					amount = Deposit(accountNum);
				}
				printReceipt(choice, accountNum, amount);
				choice = courseofAction();
			}
		}
	}
	
	public boolean validate(int accountNum){
		System.out.println("Enter Pin");
		int PIN = enterPin();
		return bank.validate(accountNum, PIN);
	}
	public boolean validate(int accountNum, int PIN){
		System.out.println("Enter Pin");
		return bank.validate(accountNum, PIN);
	}
	
	public int enterPin(){
		int PIN = scan.nextInt();
		return PIN;
	}
	public int enterPin(int PIN){
		return PIN;
	}
	
	public String courseofAction(){
		System.out.println("To deposit enter 'D'\n to withdraw enter 'W'\nto exit enter 'E'");
		return scan.next();
	}
	public String courseofAction(String coA){
		System.out.println("To deposit enter 'D'\n to withdraw enter 'W'\nto exit enter 'E'");
		return coA;
	}
	
	public double Withdraw(int accountNum){
		System.out.println("How much would you like to Withdraw?\n");
		double amount = scan.nextDouble();
		if(!bank.withdraw(amount)){
			System.out.println("Not enough funds\nBalance: " + bank.getBalance() );
		}
		return amount;
	}
	public double Withdraw(int accountNum, double amount){
		System.out.println("How much would you like to Withdraw?\n");
		if(!bank.withdraw(amount)){
			System.out.println("Not enough funds\nBalance: " + bank.getBalance() );
		}
		return amount;
	}
	
	public double Deposit(int accountNum){
		System.out.println("How much would you like to Deposit?\n");
		double amount = scan.nextDouble();
		bank.deposit(amount);
		return amount;
	}
	public double Deposit(int accountNum, double amount){
		System.out.println("How much would you like to Deposit?\n");
		bank.deposit(amount);
		return amount;
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
