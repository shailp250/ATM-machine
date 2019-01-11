
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ATMgui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500; // 200 original

	public JPanel mainPanel;
	public JPanel botPanel;
	public JLabel totalBalanceLabel;
	public JTextField withdrawTextField;
	public JTextField depositTextField;
	public JTextField pinTextField;
	public JTextField nameTextField;
	public JTextField descriptionField;
	public Container contentPane;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton zero;
	public String name;
	public int pin;
	public ATMbizlogic logicTool;

	/**
	 * Creates a new instance of ATMgui
	 */
	public ATMgui() {

		setTitle("ATM Transactions");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		contentPane = getContentPane();
		// contentPane.setBackground(Color.GREEN);
		contentPane.setLayout(new BorderLayout());
		mainPanel = new JPanel(new BorderLayout());
		contentPane.add(mainPanel);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Welcome to the Canadian ATM");
		mainPanel.setBorder(title);

		// Do the panel for the rest stop
		nameTextField = new JTextField();
		JLabel nameLabel = new JLabel("Please enter your full name:");

		pinTextField = new JTextField();
		JLabel pinLabel = new JLabel("Please enter your PIN using the keypad:");
		pinTextField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				getPinKeyPad(); // gets the keypad selected to the correct
								// actionListener
				one.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "1";
						pinTextField.setText(pinTextField.getText());
					}
				});

				two.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "2";
						pinTextField.setText(pinTextField.getText());

					}
				});
				three.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "3";
						pinTextField.setText(pinTextField.getText());

					}
				});
				four.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "4";
						pinTextField.setText(pinTextField.getText());

					}
				});
				five.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "5";
						pinTextField.setText(pinTextField.getText());
					}
				});
				six.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "6";
						pinTextField.setText(pinTextField.getText());
					}
				});
				seven.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "7";
						pinTextField.setText(pinTextField.getText());
					}
				});
				eight.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "8";
						pinTextField.setText(pinTextField.getText());
					}
				});
				nine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "9";
						pinTextField.setText(pinTextField.getText());
					}
				});
				zero.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "0";
						pinTextField.setText(pinTextField.getText());
					}
				});
			}

			public void focusLost(FocusEvent e) {

			}
		});

		JButton pinButton = new JButton("Login");
		JButton logOutButton = new JButton("Logout");
		logOutButton.addActionListener(this);
		JPanel pinPanel = new JPanel();
		pinButton.addActionListener(this);
		pinPanel.setLayout(new GridLayout(6, 1, 30, 13));

		pinPanel.add(nameLabel);
		pinPanel.add(nameTextField);
		pinPanel.add(pinLabel);
		pinPanel.add(pinTextField);
		pinPanel.add(pinButton);
		pinPanel.add(logOutButton);

		mainPanel.add(pinPanel, BorderLayout.WEST);

		// Do the panel for the amount & type of transactions
		withdrawTextField = new JTextField();
		JLabel withdrawLabel = new JLabel("Withdraw (0)");
		withdrawTextField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				removeActionListener(); // removes past action listeners
				one.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "1";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});

				two.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "2";
						withdrawTextField.setText(withdrawTextField.getText() + value);

					}
				});
				three.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "3";
						withdrawTextField.setText(withdrawTextField.getText() + value);

					}
				});
				four.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "4";
						withdrawTextField.setText(withdrawTextField.getText() + value);

					}
				});
				five.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "5";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});
				six.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "6";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});
				seven.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "7";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});
				eight.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "8";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});
				nine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "9";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});
				zero.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "0";
						withdrawTextField.setText(withdrawTextField.getText() + value);
					}
				});

			}

			public void focusLost(FocusEvent e) {

			}
		});

		depositTextField = new JTextField();
		JLabel depositLabel = new JLabel("Deposit (0)");
		depositTextField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				removeActionListener(); // removes past action listeners
				one.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "1";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});

				two.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "2";
						depositTextField.setText(depositTextField.getText() + value);

					}
				});
				three.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "3";
						depositTextField.setText(depositTextField.getText() + value);

					}
				});
				four.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "4";
						depositTextField.setText(depositTextField.getText() + value);

					}
				});
				five.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "5";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});
				six.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "6";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});
				seven.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "7";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});
				eight.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "8";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});
				nine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "9";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});
				zero.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = "0";
						depositTextField.setText(depositTextField.getText() + value);
					}
				});

			}

			public void focusLost(FocusEvent e) {

			}
		});

		JButton txButton = new JButton("Transactions OK");
		txButton.addActionListener(this);

		JButton updateButton = new JButton("Change Pin");
		updateButton.addActionListener(this);

		JButton resultButton = new JButton("Print Result");
		resultButton.addActionListener(this);

		JPanel txPanel = new JPanel();
		txPanel.setLayout(new GridLayout(7, 1, 30, 10));

		txPanel.add(withdrawLabel);
		txPanel.add(withdrawTextField);
		txPanel.add(depositLabel);
		txPanel.add(depositTextField);
		txPanel.add(txButton);
		txPanel.add(updateButton);
		txPanel.add(resultButton);

		mainPanel.add(txPanel, BorderLayout.EAST);

		totalBalanceLabel = new JLabel("Your balance after transactions: ");
		logicTool = new ATMbizlogic();
		PinnumberPad();

	}

	public void PinnumberPad() {
		botPanel = new JPanel(new BorderLayout());
		JPanel numberPanel = new JPanel(new BorderLayout());
		numberPanel.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.setLayout(new GridLayout(3, 1, 0, 0));
		leftPanel.setSize(3, 3);
		JPanel middlePanel = new JPanel(new BorderLayout());
		middlePanel.setLayout(new GridLayout(3, 1, 0, 0));
		middlePanel.setSize(3, 3);
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setLayout(new GridLayout(3, 1, 0, 0));
		rightPanel.setSize(3, 3);

		JPanel zeroPanel = new JPanel(new BorderLayout());

		// Left panel
		one = new JButton("1");
		four = new JButton("4");
		seven = new JButton("7");

		leftPanel.add(one);
		leftPanel.add(four);
		leftPanel.add(seven);

		numberPanel.add(leftPanel, BorderLayout.WEST);

		// Middle Panel
		two = new JButton("2");

		five = new JButton("5");

		eight = new JButton("8");

		middlePanel.add(two);
		middlePanel.add(five);
		middlePanel.add(eight);

		numberPanel.add(middlePanel, BorderLayout.CENTER);

		// Right Panel
		three = new JButton("3");

		six = new JButton("6");

		nine = new JButton("9");

		rightPanel.add(three);
		rightPanel.add(six);
		rightPanel.add(nine);

		numberPanel.add(rightPanel, BorderLayout.EAST);

		// Zero Panel
		zero = new JButton("0");

		zeroPanel.add(zero);

		numberPanel.add(zeroPanel);
		JPanel descriptionPanel = new JPanel(new BorderLayout());
		descriptionPanel.setLayout(new GridLayout(1, 1, 0, 0));
		descriptionField = new JTextField();
		// descriptionField.setSize(300,300);
		descriptionPanel.add(descriptionField);

		botPanel.add(totalBalanceLabel, BorderLayout.NORTH);
		botPanel.add(numberPanel, BorderLayout.CENTER);
		botPanel.add(descriptionPanel, BorderLayout.SOUTH);

		contentPane.add(botPanel, BorderLayout.SOUTH);

	}

	public void getPinKeyPad() {
		// removes all past action listeners;
		removeActionListener();

		// selects the addACtionLsitener so the output goes to Pin textfield
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
	}

	public void removeActionListener() {
		for (ActionListener act : one.getActionListeners()) {
			one.removeActionListener(act);
		}
		for (ActionListener act : two.getActionListeners()) {
			two.removeActionListener(act);
		}
		for (ActionListener act : three.getActionListeners()) {
			three.removeActionListener(act);
		}
		for (ActionListener act : four.getActionListeners()) {
			four.removeActionListener(act);
		}
		for (ActionListener act : five.getActionListeners()) {
			five.removeActionListener(act);
		}
		for (ActionListener act : six.getActionListeners()) {
			six.removeActionListener(act);
		}
		for (ActionListener act : seven.getActionListeners()) {
			seven.removeActionListener(act);
		}
		for (ActionListener act : eight.getActionListeners()) {
			eight.removeActionListener(act);
		}
		for (ActionListener act : nine.getActionListeners()) {
			nine.removeActionListener(act);
		}
		for (ActionListener act : zero.getActionListeners()) {
			zero.removeActionListener(act);
		}
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		// Container contentPane = getContentPane();
		if (actionCommand.equals("1")) {
			String value = "1";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("2")) {
			String value = "2";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("3")) {
			String value = "3";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("4")) {
			String value = "4";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("5")) {
			String value = "5";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("6")) {
			String value = "6";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("7")) {
			String value = "7";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("8")) {
			String value = "8";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("9")) {
			String value = "9";
			pinTextField.setText(pinTextField.getText() + value);
		}
		if (actionCommand.equals("0")) {
			String value = "0";
			pinTextField.setText(pinTextField.getText() + value);
		}

		if (actionCommand.equals("Change Pin")) {
			try {
				int newPin = Integer.parseInt(pinTextField.getText());

			}

			catch (Exception ex) {
				totalBalanceLabel.setText("Error in deposit or withdraw amount: " + ex.getMessage());
			}
		}

		//Confirms the transaction
		if (actionCommand.equals("Transactions OK"))

		{
			try {
				double deposit = Double.parseDouble(depositTextField.getText());
				double withdraw = Double.parseDouble(withdrawTextField.getText());
				logicTool.Transaction(withdraw, deposit);
				// logicTool.Transaction(500, 500);
				System.out.println(logicTool.getBalance());
				totalBalanceLabel.setText("Your balance after transactions: " + logicTool.getBalance());

			} catch (ATMexception ex) {
				totalBalanceLabel.setText("Error: " + ex.getMessage());
			} catch (Exception ex) {
				totalBalanceLabel.setText("Error in deposit or withdraw amount: " + ex.getMessage());
			}
		}
		//Prints the transaction so far on the description text box and into the log file
		if (actionCommand.equals("Print Result")) {
			try {
				double deposit = Double.parseDouble(depositTextField.getText().trim());
				double withdraw = Double.parseDouble(withdrawTextField.getText().trim());

				descriptionField.setText(
						"Total Balance: " + logicTool.getBalance() + " Withdraw: " + withdraw + " Deposit: " + deposit);
				System.out.println(logicTool.getBalance());
				File file = new File("src/LogFile.txt");
				PrintWriter out = new PrintWriter(new FileWriter(file, true));
				out.print("Your total balance now:" + logicTool.getBalance() +"/n"+ "Deposit: "+deposit+ "/n"+ "Withdraw: "+withdraw);
			} catch (Exception ex) {
				totalBalanceLabel.setText("Error in deposit or withdraw amount: " + ex.getMessage());
			}
		}
		//Emptys out the entire GUI and saves the data
		if (actionCommand.equals("Logout")) {

			if (logicTool.isLoggedIn()) {
				nameTextField.setText("");
				pinTextField.setText("");
				withdrawTextField.setText("");
				depositTextField.setText("");
				descriptionField.setText("");
				totalBalanceLabel.setText("You have logged out!");
				logicTool.logOut();
			} else {
				totalBalanceLabel.setText("Not logged in");
			}

		}
		
		//checks for login
		if (actionCommand.equals("Login")) {
			try {
				// calls dataBase to copy customer.dat into hash array
				String name = nameTextField.getText();
				int pin = Integer.parseInt(pinTextField.getText());
				System.out.println(name);
				System.out.println(pin);
				logicTool.logIn(name, pin);

				if (logicTool.isLoggedIn()) {
					totalBalanceLabel.setText("Enter transaction:");
				} else {
					totalBalanceLabel.setText("thus not work");
				}

			} catch (Exception ex) {
				totalBalanceLabel.setText("Error in pin: " + ex.getMessage());
			}
		} else {
			System.out.println("Error in button interface.");
		}

	}
	
	//starts the gui and buttons
	public static void main(String[] args) {
		ATMgui gui = new ATMgui();
		gui.setVisible(true);

	}

}