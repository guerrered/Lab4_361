import java.util.Scanner;

public class Atm {
	
	public static void main(String [] args){
		String userIn;
		Scanner stdIn = new Scanner(System.in);
		System.out.println("ATM is ready for use!");
		System.out.println("---------------------");
		System.out.println("Please enter your account number!");
		userIn = stdIn.next();
		if(!Bank.validate(userIn)){
			System.out.println("Account not found. Exiting");
			System.exit(0);
		}
		
	}
}
