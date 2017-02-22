
public class CashDispenser {
static double TotalAmountInATM =10000.0;
	
public boolean CashDispen(double amount)
{
	if(amount>TotalAmountInATM)
	{
      System.out.println("No enough cash for dispen, transaction cancel");
		return false;
	}
	else
	{
	TotalAmountInATM-=amount;
	}
	return true;
}


public void CashDeposit(double amount)
{
	TotalAmountInATM+=amount;
	
}
	
	
}
