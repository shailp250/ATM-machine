import java.io.*;
import java.io.File.*;
import java.util.*;

public class dataBase {
	private CustomerRecord[] anotherArray;
	public int max_size = 100;

	public void loadCustomers() {
		// ----------------------------------------------------------------
		// Read from customer data base data file
		CustomerRecord[] oneArray = new CustomerRecord[100];
		int counter = 0;
		try {
			String fileName = "src/Customer.dat";
			File f = new File(fileName);
			Scanner in = new Scanner(f);
			// while loop
			while (in.hasNextLine()) {
				// find next line
				String Name = in.nextLine();
				System.out.println(Name);
				int pin = Integer.parseInt(in.nextLine().trim());
				int initialAccount = Integer.parseInt(in.nextLine().trim());
				double initialBalance = Double.parseDouble(in.nextLine().trim());
				oneArray[counter++] = new CustomerRecord(Name, pin, initialAccount, initialBalance);
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// load anotherArray hash table with text file data
		int index = counter;
		// Print the records on screen
		System.out.println("\n\n***List of Customer Records:");
		for (int i = 0; i < index; i++) {
			oneArray[i].writeOutput();
		}

		// -------------------------------------------------------------------
		// them in anotherArray and Print the records on screen;

		anotherArray = new CustomerRecord[100];
		int hashIndex;
		System.out.println("\n\n***List of the Customer Records (copy):");

		int x = 0;
		while (x < index) {
			{
				hashIndex = getHash(oneArray[x].getName(), oneArray[x].getPin());
				anotherArray[hashIndex] = oneArray[x];
				anotherArray[hashIndex].writeOutput();
			}
			x++;
		}

	}

	// write customer information to data file
	public void updateRecords() {
		System.out.println("\n\nWriting to file.");
		try {
			File newFile = new File("src/Customer.dat");
			PrintWriter out = new PrintWriter(newFile);
			for (CustomerRecord anAnotherArray : anotherArray) {
				if (anAnotherArray != null) {
					out.println(anAnotherArray.getName());
					out.println(anAnotherArray.getPin());
					out.println(anAnotherArray.getAccount());
					out.println(anAnotherArray.getBalance());
				}
			}
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		//write to binary file
		try{
			String binOutputFile = "Customer.bin";
			FileOutputStream outputStream = new FileOutputStream(binOutputFile);
			BufferedOutputStream outputBuffer = new BufferedOutputStream(outputStream);
			DataOutputStream outputData = new DataOutputStream(outputBuffer);
			
			for(int i =0 ; i < anotherArray.length; i++){
				if(anotherArray[i] != null){
					outputData.writeUTF(anotherArray[i].getName());
					outputData.writeInt(anotherArray[i].getPin());
					outputData.writeInt(anotherArray[i].getAccount());
					outputData.writeDouble(anotherArray[i].getBalance());
				}
				
			}
			outputData.close();
			
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public CustomerRecord getAccount(String userName, int userPin) {
		int hashIndex = getHash(userName, userPin);
		CustomerRecord account = anotherArray[hashIndex];
		return account;
	}

	//gets the hash key for Fullname and pin combined
	public int getHash(String fullName, int pin) {
		String namePin = fullName;
		int key = 0;
		for (int i = 0; i < namePin.length(); i++) {
			key += namePin.charAt(i);

		}
		key = (key + (13 * pin)) % anotherArray.length;
		return key;
	}
		
	//searches for thorugh hash array usng key
	public boolean searchHash(int key, String name, int pin) {
		if (anotherArray[key] == null) {
			throw new NoSuchElementException();
		}
		if (anotherArray[key].getName().equals(name) && anotherArray[key].getPin() == pin) {
			return true;
		} else {
			for (int i = key; i < anotherArray.length; i++) {
				if (anotherArray[i].getName().equals(name) && anotherArray[i].getPin() == pin) {
					return true;
				}
			}
		}
		return false;
	}

}