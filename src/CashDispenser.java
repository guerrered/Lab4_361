
public class CashDispenser {
static double TotalAmountInATM =10000.0;
	
public void CashDispen(double amount)
{
	
	TotalAmountInATM-=amount;
}

public void CashDeposit(double amount)
{
	TotalAmountInATM+=amount;
	
}
	
	
}
