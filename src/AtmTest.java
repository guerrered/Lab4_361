import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import Bank.Account;

public class AtmTest {
	static Atm atm;
	ByteArrayInputStream in;
	
	@Before
	public void setup()
	{
		atm = new Atm();
		atm.bank.addAccount(1234,6789,80.0);
		atm.bank.addAccount(6789,4321,60.0);
	}

	//Successfully validate	and	withdrawal	of	$20	from account 1234
	@Test
	public void testA() {
		assertEquals(true,atm.validate(1234,6789));
		atm.Withdraw(20);
		assertEquals("$60.0",atm.getBalance());
		System.out.println(atm.getBalance());
	}
	
	
	@Test
	public void testB(){
		assertEquals(true,atm.validate(1234,6789));
		atm.Withdraw(80);
		assertEquals("$0.0",atm.getBalance());
		System.out.println(atm.getBalance());
		
		
	}
	
	@Test
	public void testC()
	{
		assertEquals(false,atm.validate(6789,1234));
		
	}
	
	@Test
	public void testD()
	{
		assertEquals(true,atm.validate(6789,4321));
		atm.Deposit(20);
		assertEquals("$80.0",atm.getBalance());
		System.out.println(atm.getBalance());
		
	}
		/*//enter account
		in = new ByteArrayInputStream("6789".getBytes());
		System.setIn(in);
		atm.start();
		//enter pin
		
		
	}
	
	
	
	
	//Successfully validate	and	withdrawal	of	$80	from account 1234
//	@Test
//	public void testB() {
//		assertTrue(atm.validate(card1));
//		atm.withdraw(80);
//		atm.exit();
//	}
//	
//	//Incorrect validation of account 6789
//	@Test
//	public void testC() {
//		
//	}
//	
//	//Successfully deposit $20 into account 6789
//	@Test
//	public void testD() {
//		assertTrue(atm.validate(card2));
//		atm.deposit(20);
//		atm.exit();
//		
//	}
*/
}
