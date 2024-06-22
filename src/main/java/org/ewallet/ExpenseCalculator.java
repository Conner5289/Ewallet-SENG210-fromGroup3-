package org.ewallet;

public class ExpenseCalculator implements IExpenseCalculator {

    private User userAtHand = null;

    @Override
    public void setUser(User user) {
        userAtHand = user;
    }

    @Override
    public void addExpense(Expense expense) {
        if (userAtHand == null)
            return;

        userAtHand.addExpense(expense);
    }

    @Override
    public void addMonthlyIncome(Wage w) {
        if (userAtHand == null)
            return;

        userAtHand.addIncome(w);
    }

    @Override
    public void printFullReport() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void PrintExpenseReport() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void printIncomeReport() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void printIncomeReportByType() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void printExpenseByType() {
        if (userAtHand == null)
            return;
    }

    @Override
    public void exportReport(String reportTitle) {
        if (userAtHand == null)
            return;
    }

    @Override
    public Currency convertCurrency(Currency fromCurrency, CurrencyType toType) {
        Currency newCurrency = new Currency(0, toType);
        // Get the value in USD
        newCurrency.amount = fromCurrency.amount / Currency.toUSDValue[fromCurrency.type.getValue()];
        // Convert from USD to desired type
        newCurrency.amount *= Currency.toUSDValue[toType.getValue()];
        return newCurrency;
    }

    @Override
    public boolean loadExpenseFile(String filePath) {
        return false;
    }

    @Override
    public boolean loadIncomeFile(String filePath) {
        return false;
    }

    @Override
    public int whenCanIBuy(String itemName, double price) {
        return 0;
    }

    @Override
    public void updateMonthlySavings() {

    }
}
