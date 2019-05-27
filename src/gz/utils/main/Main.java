package gz.utils.main;

import javax.transaction.TransactionRequiredException;

public class Main {

	public static void main(String[] args) {
		System.out.println("T'as plus qu'a coder ici");
		
		new TransactionRequiredException();

	}

}
