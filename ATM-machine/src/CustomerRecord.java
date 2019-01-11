 

import java.io.Serializable;
import java.util.Scanner;

/**
 Serialized class for data on endangered species.
 Includes a main method.
*/
public class CustomerRecord implements Serializable
{
    private String name;
    private int pin;
    private int account;
    private double balance;

    public CustomerRecord( )
    {
        name = null;
        pin = 0;
        account = 0;
        balance = 0.00;
    }

    public CustomerRecord(String initialName, int initialPin, int initialAccount, double initialBalance)
    {
        name = initialName;

        if (initialPin >= 1111 && initialPin <= 9999)
            	pin = initialPin;
        else
        {
            	System.out.println("ERROR: Pin is not acceptable.");
            	System.exit(0);
        }
	
        if (initialAccount >= 400111 && initialAccount <= 500111)
        	account = initialAccount;
		else
		{
			System.out.println("ERROR: Account number is not acceptable.");
            	System.exit(0);
		}

        if (initialBalance >= 0)
        	balance = initialBalance;
		else
		{
			System.out.println("ERROR: Initial Balance is not acceptable.");
            	System.exit(0);
		}
    }

    public String toString()
    {
        return (  name+ " " + pin + " "
              	+   account + " "
              	+ balance + "\n");
    }

    public void setCustomerRecord( )
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nEnter new customer's name: ");
        name = keyboard.nextLine( );

        System.out.println("Enter new customer's pin: ");
        pin = keyboard.nextInt( );
        while (pin < 1111 || pin > 9999)
        {
            System.out.println("Pin should be in the range of 1111-9999.");
            System.out.println("Reenter pin:");
            pin = keyboard.nextInt( );
        }

        System.out.println("Enter new customer's account no: ");
        account = keyboard.nextInt( );
        while (account < 400111 || pin > 500111)
        {
            System.out.println("Account should be in the range of 400111-500111.");
            System.out.println("Reenter account number:");
            account = keyboard.nextInt( );
        }

        System.out.println("Enter new customer's initial balance: ");
        balance = keyboard.nextDouble( );
        while (balance < 0)
        {
            System.out.println("Initial balance should be positive or zero.");
            System.out.println("Reenter initial balance:");
            balance = keyboard.nextDouble( );
        }
    }

    public void writeOutput( )
    {
         System.out.print("Name = " + name + "\t");
         System.out.print("Account = " + account + "\t");
         System.out.print("Balance = " + "$" + balance + "\n");
    }

    public String getName( )
    {
        return name;
    }

    public int getPin( )
    {
        return pin;
    }
    public void setPin(int pin)
    {
    	this.pin = pin;
    }

    public int getAccount( )
    {
        return account;
    }

    public double getBalance( )
    {
        return balance;
    }
    
    public void setBalance(double amount)
    {
        balance = amount;
    }

    public boolean equal(CustomerRecord otherObject)
    {
        return (name.equalsIgnoreCase(otherObject.name) &&
               (pin == otherObject.pin) &&
               (account == otherObject.account) &&
               (balance == otherObject.balance));
    }

}

