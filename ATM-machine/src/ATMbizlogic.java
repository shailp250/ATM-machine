import java.io.ObjectStreamException;
import java.util.NoSuchElementException;

public class ATMbizlogic {
	private boolean rightPinEntered;
	private boolean loggedIn;
	private dataBase dataTool = new dataBase();
	private double balance; 	
	private CustomerRecord account;

	/**
	 * Creates a new instance of ATMbizlogic
	 */
	public ATMbizlogic() {
		balance = 0.0;  
		rightPinEntered = true;
		loggedIn = false;
		account = null;
		dataTool.loadCustomers();
	}

	//doo login
	public void logIn(String name, int pin) throws ATMexception {
		System.out.println("logging in rn");
		account = dataTool.getAccount(name, pin);
		if (account == null) {
			throw new ATMexception("can't log in");
		} else {
			loggedIn = true;
			this.balance = account.getBalance();
		}
	}

	//do logout
	public void logOut() {
		balance = 0;
		rightPinEntered = true;
		loggedIn = false;
		account = null;
		this.saveData();
		dataTool.loadCustomers();

	}

		//get transaction
	public void Transaction(double withdraw, double deposit) throws ATMexception {
		if (withdraw < 0)
			throw new ATMexception("Negative withdraw not allowed");

		if (deposit < 0)
			throw new ATMexception("Negative deposit not allowed");

		if (balance < withdraw)
			throw new ATMexception("Can't have a negative balance");

		balance = balance - withdraw + deposit;
		account.setBalance(balance);

	}

	public double getBalance() {
		return this.balance;
	}

	public int getHashKey(String name, int pin) {
		int key = dataTool.getHash(name, pin);
		return key;
	}

	public void changePin(int newPin) {

	}

	public boolean isLoggedIn() {
		return (this.loggedIn == true);
	}

	public void saveData() {
		dataTool.updateRecords();

	}
}
