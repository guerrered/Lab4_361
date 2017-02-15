import java.util.ArrayList;
import java.util.List;

public class Bank {
	static List<Account> bankAcc = new ArrayList<Account>();
	private Account curAccount;
	
	public class Account{
		private int	accountNumber;
		private int pin;
		private double balance;

		public Account(int accountNumber, int pin,double balance){
			this.pin = pin;
			this.accountNumber = accountNumber;
			this.balance=balance;
		}
	}
	
	public void AccountSetup(){
	
		Account acc1=new Account(1234,6789,80);
		Account acc2= new Account(6789,4321,60);
		bankAcc.add(acc1);
		bankAcc.add(acc2);
		
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

	public static boolean validate(int userIn) {
		// TODO Auto-generated method stub
		return false;
	}


}
