package org.ewallet;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

// Date Picker Imports
import com.toedter.calendar.JDateChooser;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBalance;
	private JTextField txtSavings;
	private JTextField txtAmountExpense;
	private JTextField txtYearlyFrequency;
	private JTextField txtSourceIncome;
	private JTextField txtAmountIncome;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtAmountExpence;
	private JTextField txtSourceExpence;
	private JTextField txtMonthIcome;

	private IExpenseCalculator expenseC = new ExpenseCalculator();
	private Date selectedDateIncome = null;
	private Date selectedDateExpense = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {

		// testing Setup

		// User user = new User("admin", "admin");
		// expenseC.setUser(user);

		Wage temp = new Wage(100.00);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1433, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnImportExpenses = new JButton("Import Expenses");
		btnImportExpenses.setBounds(943, 10, 135, 33);
		contentPane.add(btnImportExpenses);
		// Expenses
		btnImportExpenses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser("expense");
			}

		});

		JButton btnImportIncome = new JButton("Import Income");
		btnImportIncome.setBounds(943, 53, 135, 33);
		contentPane.add(btnImportIncome);
		// Income
		btnImportIncome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser("income");
			}
		});

		JLabel dirSelect = new JLabel("No directory selected");
		contentPane.add(dirSelect);

		JButton btnExportIncome = new JButton("Export Income");
		btnExportIncome.setBounds(943, 105, 135, 33);
		contentPane.add(btnExportIncome);
		btnExportIncome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportFile("income");

			}
		});

		JButton btnExportExpense = new JButton("Export Expense");
		btnExportExpense.setBounds(943, 145, 135, 33);
		contentPane.add(btnExportExpense);
		btnExportExpense.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportFile("expense");

			}
		});

		JButton btnIncomeReport = new JButton("Income Report");
		btnIncomeReport.setBounds(943, 192, 135, 33);
		contentPane.add(btnIncomeReport);

		JButton btnExpenseReport = new JButton("Expense Report");
		btnExpenseReport.setBounds(943, 235, 135, 33);
		contentPane.add(btnExpenseReport);

		JButton btnFullReport = new JButton("Full Report");
		btnFullReport.setBounds(943, 298, 135, 33);
		contentPane.add(btnFullReport);

		JButton btnFullCertainType = new JButton("Certain Type Report");
		btnFullCertainType.setBounds(943, 341, 135, 33);
		contentPane.add(btnFullCertainType);

		JLabel lblNewLabel = new JLabel("Balance");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 93, 124, 33);
		contentPane.add(lblNewLabel);

		JLabel lblSavings = new JLabel("Savings");
		lblSavings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSavings.setBounds(276, 93, 124, 33);
		contentPane.add(lblSavings);

		// Bal
		txtBalance = new JTextField();
		txtBalance.setEditable(false);
		txtBalance.setBounds(74, 121, 147, 38);
		contentPane.add(txtBalance);
		txtBalance.setColumns(10);

		txtBalance.setText("100.0");

		// save
		txtSavings = new JTextField();
		txtSavings.setEditable(false);
		txtSavings.setColumns(10);
		txtSavings.setBounds(266, 121, 147, 38);
		contentPane.add(txtSavings);
		txtSavings.setText("100.0");

		JLabel lblAddExpence = new JLabel("Add Expense:");
		lblAddExpence.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddExpence.setBounds(100, 192, 124, 33);
		contentPane.add(lblAddExpence);

		JLabel lblAddIncome = new JLabel("Add Income:");
		lblAddIncome.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddIncome.setBounds(464, 192, 124, 33);
		contentPane.add(lblAddIncome);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(82, 254, 124, 33);
		contentPane.add(lblAmount);

		txtAmountExpence = new JTextField();
		txtAmountExpence.setColumns(10);
		txtAmountExpence.setBounds(202, 252, 147, 38);
		contentPane.add(txtAmountExpence);

		JLabel lblAmount_1 = new JLabel("Source:");
		lblAmount_1.setBounds(82, 311, 124, 33);
		contentPane.add(lblAmount_1);

		txtSourceExpence = new JTextField();
		txtSourceExpence.setColumns(10);
		txtSourceExpence.setBounds(202, 309, 147, 38);
		contentPane.add(txtSourceExpence);

		JLabel lblAmount_2 = new JLabel("Yearly Frequency:");
		lblAmount_2.setBounds(82, 308, 124, 33);
		contentPane.add(lblAmount_2);

		txtYearlyFrequency = new JTextField();
		txtYearlyFrequency.setColumns(10);
		txtYearlyFrequency.setBounds(202, 306, 147, 38);
		contentPane.add(txtYearlyFrequency);

		JLabel lblAmount_2_1 = new JLabel("Month:");
		lblAmount_2_1.setBounds(415, 376, 124, 33);
		contentPane.add(lblAmount_2_1);

		txtMonthIcome = new JTextField();
		txtMonthIcome.setColumns(10);
		txtMonthIcome.setBounds(535, 374, 147, 38);
		contentPane.add(txtMonthIcome);

		JLabel lblAmount_1_1 = new JLabel("Source:");
		lblAmount_1_1.setBounds(415, 308, 124, 33);
		contentPane.add(lblAmount_1_1);

		txtSourceIncome = new JTextField();
		txtSourceIncome.setColumns(10);
		txtSourceIncome.setBounds(535, 306, 147, 38);
		contentPane.add(txtSourceIncome);

		JLabel lblAmount_3 = new JLabel("Amount:");
		lblAmount_3.setBounds(415, 251, 124, 33);
		contentPane.add(lblAmount_3);

		txtAmountIncome = new JTextField();
		txtAmountIncome.setColumns(10);
		txtAmountIncome.setBounds(535, 249, 147, 38);
		contentPane.add(txtAmountIncome);

		// Date picker setup for Expense
		JDateChooser dateChooserExpense = new JDateChooser();
		dateChooserExpense.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDateExpense = dateChooserExpense.getDate();
				if (selectedDateExpense != null) {
					JOptionPane.showMessageDialog(contentPane,
							"Selected Date: " + selectedDateExpense.toString());
				} else {
					JOptionPane.showMessageDialog(contentPane, "No date selected.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dateChooserExpense.setBounds(202, 376, 147, 30);
		contentPane.add(dateChooserExpense);

		JButton btnAddExpense = new JButton("Add Expense");
		btnAddExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double amount = 0.0;

				try {
					amount = Double.parseDouble(txtAmountExpense.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane,
							"Invalid input. Please enter a valid expense amount.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				int yearlyFrequency = 0;

				try {
					yearlyFrequency = Integer.parseInt(txtYearlyFrequency.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane,
							"Invalid input. Please enter a valid yearly frequency.",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (selectedDateExpense == null) {
					JOptionPane.showMessageDialog(contentPane, "Please select a date.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				expenseC.addExpense(amount, yearlyFrequency, selectedDateExpense);

				// Get the current user Username
				String CurrentUser = expenseC.getUserAtHand().getUsername();

				txtSavings.setText(Double.toString(expenseC.updateMonthlySavings(CurrentUser)));

				txtBalance.setText(Double.toString(expenseC.calculateBalance(CurrentUser)));

			}
		});
		btnAddExpense.setBounds(214, 438, 135, 33);
		contentPane.add(btnAddExpense);

		// Date picker setup for Income
		JDateChooser dateChooserIcome = new JDateChooser();
		dateChooserIcome.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedDateIncome = dateChooserIcome.getDate();
				if (selectedDateIncome != null) {
					JOptionPane.showMessageDialog(contentPane,
							"Selected Date: " + selectedDateIncome.toString());
				} else {
					JOptionPane.showMessageDialog(contentPane, "No date selected.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		dateChooserIcome.setBounds(535, 376, 147, 30);
		contentPane.add(dateChooserIcome);

		JButton btnAddIncome = new JButton("Add Income");
		btnAddIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double amount = 0.0;

				try {
					amount = Double.parseDouble(txtAmountIncome.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(contentPane,
							"Invalid input. Please enter a valid income amount.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				String source = txtSourceIncome.getText();

				if (selectedDateIncome == null) {
					JOptionPane.showMessageDialog(contentPane, "Please select a date.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				expenseC.addMonthlyIncome(amount, source, selectedDateIncome);

				// Get the current user Username
				String CurrentUser = expenseC.getUserAtHand().getUsername();
				txtSavings.setText(Double.toString(expenseC.updateMonthlySavings(CurrentUser)));
				txtBalance.setText(Double.toString(expenseC.calculateBalance(CurrentUser)));

			}
		});

		btnAddIncome.setBounds(547, 438, 135, 33);
		contentPane.add(btnAddIncome);

		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setBounds(82, 20, 124, 33);
		contentPane.add(lblWelcome);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "USD", "CAD" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(819, 16, 29, 21);
		comboBox.setSize(60, 25);
		contentPane.add(comboBox);

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Bal
				String dollar = (String) comboBox.getSelectedItem();
				if (dollar.equals("CAD")) {
					double cadAmout = temp.getAmount() * 1.38;
					txtBalance.setText(Double.toString(cadAmout));
					txtSavings.setText(Double.toString(cadAmout));

				} else {
					double usdAmout = temp.getAmount();
					txtBalance.setText(Double.toString(usdAmout));
					txtSavings.setText(Double.toString(usdAmout));
				}

			}
		});

		JLabel lblCurrency = new JLabel("Currency:");
		lblCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrency.setBounds(702, 10, 124, 33);
		contentPane.add(lblCurrency);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(91, 118, 107, 40);
		panel.add(lblLogin);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(106, 217, 78, 40);
		panel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(106, 326, 78, 40);
		panel.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(26, 271, 239, 38);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(26, 380, 239, 38);
		panel.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (expenseC.Login(txtUsername.getText(), txtPassword.getText()) == false) {

					JOptionPane.showMessageDialog(contentPane, "Wrong Credectials, Try again",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		btnLogin.setBounds(78, 435, 135, 33);
		panel.add(btnLogin);

		JLabel lblAmount_2_2 = new JLabel("Start Date:");
		lblAmount_2_2.setBounds(82, 376, 115, 33);
		contentPane.add(lblAmount_2_2);

		JLabel lblAmount_2_2_1 = new JLabel("Date:");
		lblAmount_2_2_1.setBounds(415, 376, 105, 33);
		contentPane.add(lblAmount_2_2_1);
	}

	public void fileChooser(String expenseOrIncome) {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("CSV files", "csv");

		chooser.setDialogTitle("Import File");
		chooser.setFileFilter(fileFilter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int retrunVal = chooser.showOpenDialog(contentPane);
		if (retrunVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();

			FileTransfer transfer = new FileTransfer();
			if (expenseOrIncome.equals("expense")) {
				if (transfer.importExpense(selectedFile.getAbsolutePath()) == 0) {
					JOptionPane.showMessageDialog(contentPane, "Expense file has been uploaded!",
							"Transfer",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (transfer.importExpense(selectedFile.getAbsolutePath()) == 1) {
					JOptionPane.showMessageDialog(contentPane,
							"Expense file has been not been uploaded", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (transfer.importExpense(selectedFile.getAbsolutePath()) == 2) {
					JOptionPane.showMessageDialog(contentPane, "Bad input file, Plase check format",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}

			if (expenseOrIncome.equals("income")) {

				if (transfer.importIncome(selectedFile.getAbsolutePath()) == 0) {
					JOptionPane.showMessageDialog(contentPane, "Income file has been uploaded!",
							"Transfer",
							JOptionPane.INFORMATION_MESSAGE);
				} else if ((transfer.importIncome(selectedFile.getAbsolutePath()) == 1)) {
					JOptionPane.showMessageDialog(contentPane,
							"Income file has been NOT been uploaded", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (transfer.importIncome(selectedFile.getAbsolutePath()) == 2) {
					JOptionPane.showMessageDialog(contentPane, "Bad input file, Plase check format",
							"Warning",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		} else {
			JOptionPane.showMessageDialog(contentPane, "No file was selected", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	public void exportFile(String expenseIncomeOrAll) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Export File");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		if (expenseIncomeOrAll.equals("expense")) {

		} else if (expenseIncomeOrAll.equals("income")) {

		} else {
			JOptionPane.showMessageDialog(contentPane, "No opration was selected", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
