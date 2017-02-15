import java.util.ArrayList;
import java.util.List;

public class Bank {
	static List<Account> bankAcc = new ArrayList<Account>();
	private Account curAccount;
	
	public class Account{
		private int	accountNumber;
		private int pin;
		private double balance;

		public Account(int accountNumber, int pin){
			this.pin = pin;
			this.accountNumber = accountNumber;
		}
	}
	
	
	
	public boolean deposit(){
		return false;
	}
	
	public boolean withdraw(){
		return false;
	}
	
	public String getBalance(){
		if(curAccount!=null){
			return "$" + curAccount.balance;
		}
		return null;
	}

	public static boolean validate(String userIn) {
		// TODO Auto-generated method stub
		return false;
	}


}
