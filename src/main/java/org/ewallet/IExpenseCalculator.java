package org.ewallet;

import java.util.Date;

public interface IExpenseCalculator {
	public void setUser(User user);

	public void addExpense(double amount, int yearlyFrequency, Date date);

	public boolean addMonthlyIncome(double amount, String source, Date date);

	// As a user I would like to view a detailed report of all expenses, income, and
	// summary information
	// summary information include : total income, total income for each type, total
	// income for each month, total expense, total expense for each type,
	// total savings (total income- total expenses) to date, if the total savings
	// are less than zero it should be reported as total new debt.
	public void printFullReport(boolean pretty);

	// As a user I would like to view a detailed report of all expenses, and summary
	// information for expenses
	public void printExpenseReport();

	// As a user I would like to view a detailed report of all income, and summary
	// information for income
	public void printIncomeReport();

	// As a user I would like to view a detailed report of income of a certain type,
	// and summary information for income
	public void printIncomeReportByType();

	// As a user I would like to view a detailed report of expense of a certain type
	// , and summary information for expenses
	public void printExpenseByType();

	// As a user I would like to choose a report and export it as an external file
	// (any type is fine preferences are csv or JSON)
	public void exportReport(String reportTitle);

	public Currency convertCurrency(Currency fromCurrency, CurrencyType toType);

	// As a user I would like to load multiple expenses from an external file all at
	// once returning true if loaded successfully and false otherwise
	public boolean loadExpenseFile(String filePath);

	// As a user I would like to load multiple income from an external file all at
	// once returning true if loaded successfully and false otherwise
	public boolean loadIncomeFile(String filePath);

	// As a user I would like to provide an item and a price and get an estimate in
	// number of months needed to save up to buy this item. (based on current
	// monthly saving.
	public int whenCanIBuy(double price, String itemName);

	// updates monthly savings based on latest added income and expenses. This is an
	// internal function not called by the users. Bonus: what is the most efficient
	// way to call it (when?)?
	public double updateMonthlySavings(String username);

	public double calculateBalance(String username);

	public User getUserAtHand();

	public boolean Login(String username, String Password);
}
