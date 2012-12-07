package jhc.ws;

import java.rmi.Remote;

public interface BankServices_SEI extends Remote {
	public String validateCreditCard(String number, String month, String year);
}
