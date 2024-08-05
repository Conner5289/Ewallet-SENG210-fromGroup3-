package org.ewallet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Import Expenses");
		btnNewButton.setBounds(943, 10, 135, 33);
		contentPane.add(btnNewButton);
		
		JButton btnImportIncome = new JButton("Import Income");
		btnImportIncome.setBounds(943, 53, 135, 33);
		contentPane.add(btnImportIncome);
		
		JButton btnExportCsv = new JButton("Export CSV");
		btnExportCsv.setBounds(943, 126, 135, 33);
		contentPane.add(btnExportCsv);
		
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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(74, 121, 147, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(266, 121, 147, 38);
		contentPane.add(textField_1);
		
		JLabel lblAddExpence = new JLabel("Add Expence:");
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(202, 252, 147, 38);
		contentPane.add(textField_2);
		
		JLabel lblAmount_1 = new JLabel("Source:");
		lblAmount_1.setBounds(82, 311, 124, 33);
		contentPane.add(lblAmount_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(202, 309, 147, 38);
		contentPane.add(textField_3);
		
		JLabel lblAmount_2 = new JLabel("Yearly Frequency:");
		lblAmount_2.setBounds(82, 379, 124, 33);
		contentPane.add(lblAmount_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(202, 377, 147, 38);
		contentPane.add(textField_4);
		
		JLabel lblAmount_2_1 = new JLabel("Month:");
		lblAmount_2_1.setBounds(415, 376, 124, 33);
		contentPane.add(lblAmount_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(535, 374, 147, 38);
		contentPane.add(textField_5);
		
		JLabel lblAmount_1_1 = new JLabel("Source:");
		lblAmount_1_1.setBounds(415, 308, 124, 33);
		contentPane.add(lblAmount_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(535, 306, 147, 38);
		contentPane.add(textField_6);
		
		JLabel lblAmount_3 = new JLabel("Amount:");
		lblAmount_3.setBounds(415, 251, 124, 33);
		contentPane.add(lblAmount_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(535, 249, 147, 38);
		contentPane.add(textField_7);
		
		JButton btnAddExpence_1 = new JButton("Add Expence");
		btnAddExpence_1.setBounds(214, 438, 135, 33);
		contentPane.add(btnAddExpence_1);
		
		JButton btnAddExpence = new JButton("Add Income");
		btnAddExpence.setBounds(547, 438, 135, 33);
		contentPane.add(btnAddExpence);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcome.setBounds(82, 20, 124, 33);
		contentPane.add(lblWelcome);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"USD", "CAD"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(819, 16, 29, 21);
		contentPane.add(comboBox);
		
		JLabel lblCurrency = new JLabel("Currency:");
		lblCurrency.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrency.setBounds(702, 10, 124, 33);
		contentPane.add(lblCurrency);
	}
}