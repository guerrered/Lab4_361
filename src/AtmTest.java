import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AtmTest {
	static Atm atm;
	ByteArrayInputStream in;
	
	@BeforeClass
	public static void setup()
	{
		atm = new Atm();
		
	}

	//Successfully validate	and	withdrawal	of	$20	from account 1234
	@Test
	public void testA() {
		atm.validate(1234,6789);
		atm.Withdraw(1234, 20);
		System.out.println(atm.bank.getBalance());
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
