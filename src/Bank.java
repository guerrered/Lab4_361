import java.util.ArrayList;
import java.util.List;

public class Bank {
	 List<Account> bankAcc = new ArrayList<Account>();
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
		
		
	}
	
	public Bank(){
	
	}
	
	public void addAccount(int accountNum, int pin, double bal){
		Account acc = new Account(accountNum, pin, bal);
		bankAcc.add(acc);
	}
	
	
	public boolean deposit(double dop){
		if(dop<0){
			return false;
		}
		else
		{
			System.out.println("Depositing amount: $" +dop);
			curAccount.balance+=dop;
			return true;
		}
		
		
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
			System.out.println("Withdrawing amount: $" +wit);
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

	public boolean validate(int userIn,int pin) {
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
