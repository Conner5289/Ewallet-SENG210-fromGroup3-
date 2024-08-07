package org.ewallet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.ewallet.ExpenseRepository;

public class FileTransfer {
    public int importExpense(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String bufferLine;

            while ((bufferLine = reader.readLine()) != null) {

                String[] lineParts = bufferLine.split(",", 4);

                String userName = null;
                int amount = 0;
                String dateString = null;
                int yearlyFrequency = 0;

                try {
                    userName = lineParts[0];
                    amount = Integer.parseInt(lineParts[1]);
                    dateString = lineParts[2];
                    yearlyFrequency = Integer.parseInt(lineParts[3]);
                } catch (Exception e) {
                    return 2;
                }

                Date date = null;
                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    date = dateFormat.parse(dateString);
                } catch (Exception e) {
                    return 2;
                }

                Expense localExpense = null;

                localExpense = new Expense(amount, date, yearlyFrequency);

                try {
                    ExpenseRepository.saveExpense(localExpense, userName);
                } catch (Exception e) {
                    return 1;
                }

            }
        } catch (IOException e) {
            System.out.println("File not found");

        }
        return 0;

    }

    public int importIncome(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String bufferLine;

            while ((bufferLine = reader.readLine()) != null) {

                String[] lineParts = bufferLine.split(",", 4);

                String username = null;
                int amount = 0;
                String source = null;
                String dateString = null;

                try {
                    username = lineParts[0];
                    amount = Integer.parseInt(lineParts[1]);
                    source = lineParts[2];
                    dateString = lineParts[3];

                } catch (Exception e) {
                    return 2;
                }

                Date date = null;
                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    date = dateFormat.parse(dateString);
                } catch (Exception e) {
                    System.out.println("Could not conver dataString to data");
                    return 2;
                }

                Wage localWage = null;

                localWage = new Wage(amount, source, date);

                try {
                    WageRepository.saveWage(localWage, username);
                } catch (Exception e) {
                    return 1;
                }

            }
        } catch (IOException e) {
            System.out.println("File not found");
            return 1;
        }
        return 0;
    }

    public void exportIncome() {

    }

    public void exportExpense() {

    }

}
