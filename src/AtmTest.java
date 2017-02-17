import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AtmTest {
	static Atm atm;
	ByteArrayInputStream in;
	Card c1, c2;
	
	@Before
	public void setup()
	{
		atm = new Atm();
		atm.bank.addAccount(1234,6789,80.0);
		c1 = new Card(1234);
		atm.bank.addAccount(6789,4321,60.0);
		c2 = new Card(6789);
	}

	//Successfully validate	and	withdrawal	of	$20	from account 1234
	@Test
	public void testA() {
		assertEquals(true,atm.validate(c1.getAccountNum(),6789));
		atm.Withdraw(20);
		assertEquals("$60.0",atm.getBalance());
		System.out.println(atm.getBalance());
	}
	
	
	@Test
	public void testB(){
		assertEquals(true,atm.validate(c1.getAccountNum(),6789));
		atm.Withdraw(80);
		assertEquals("$0.0",atm.getBalance());
		System.out.println(atm.getBalance());
		
		
	}
	
	@Test
	public void testC()
	{
		assertEquals(false,atm.validate(c2.getAccountNum(),1234));
		
	}
	
	@Test
	public void testD()
	{
		assertEquals(true,atm.validate(c2.getAccountNum(),4321));
		atm.Deposit(20);
		assertEquals("$80.0",atm.getBalance());
		System.out.println(atm.getBalance());
		
	}
}
