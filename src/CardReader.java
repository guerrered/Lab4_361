import java.util.*;

public class CardReader {
	Scanner Scan = new Scanner(System.in);
	public CardReader(){
		
	}
	
	public int read(){
		return Integer.parseInt(Scan.nextLine());
	}

}
