import java.util.ArrayList;
import java.util.List;

public class Bank {
	static List<Account> bankAcc = new ArrayList<Account>();
	private static Account curAccount;
	
	public class Account{
		private int	accountNumber;
		private int pin;
		private double balance;

		public Account(int accountNumber, int pin,double balance){
			this.pin = pin;
			this.accountNumber = accountNumber;
			this.balance=balance;
		}
		
		private int getAccountNum()
		{
			return accountNumber;
		}
		private int getPin()
		{
			return pin;
		}
		
		private double getBalance()
		{
			return balance;
		}
		
	}
	
	private void AccountSetup(){
	
		Account acc1=new Account(1234,6789,80);
		Account acc2= new Account(6789,4321,60);
		bankAcc.add(acc1);
		bankAcc.add(acc2);
		
	}
	
	
	
	public boolean deposit(double dop){
		if(dop<0){
			return false;
		}
		else
		{
			curAccount.balance+=dop;
		}
		
		return false;
	}
	
	public boolean withdraw(double wit){
		if(wit<0)
		{
			return false;
		}
		else if(wit>curAccount.balance)
		{
			return false;
		}
		else{
		curAccount.balance-=wit;
			
		return true;
		}
	}
	
	public String getBalance(){
		if(curAccount!=null){
			return "$" + curAccount.balance;
		}
		return null;
	}

	public static boolean validate(int userIn,int pin) {
		// TODO Auto-generated method stub
		Account acc;
		for(int i=0;i<bankAcc.size();i++)
		{
			acc=bankAcc.get(i);
			if(acc.getAccountNum()==userIn&&acc.getPin()==pin)
			{
				curAccount=acc;
				return true;
			}
		}
		
		return false;
	}


}
