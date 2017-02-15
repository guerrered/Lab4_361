import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AtmTest {
	
	@BeforeClass
	public void setup()
	{
		Atm atm = new Atm();
		Card card1 = new Card(1234);
		Card card2 = new Card(6789);
	}

	//Successfully validate	and	withdrawal	of	$20	from account 1234
	@Test
	public void testA() {
		assertTrue(atm.validate(card1));
		atm.withdraw(20);
		atm.exit();
	}
	
	//Successfully validate	and	withdrawal	of	$80	from account 1234
	@Test
	public void testB() {
		assertTrue(atm.validate(card1));
		atm.withdraw(80);
		atm.exit();
	}
	
	//Incorrect validation of account 6789
	@Test
	public void testC() {
		
	}
	
	//Successfully deposit $20 into account 6789
	@Test
	public void testD() {
		assertTrue(atm.validate(card2));
		atm.deposit(20);
		atm.exit();
		
	}

}
