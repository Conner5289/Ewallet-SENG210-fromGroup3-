package org.ewallet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTransfer {
    public boolean importExpense(String filePath) {

        boolean trueFlase = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String bufferLine;

            while ((bufferLine = reader.readLine()) != null) {

                String[] lineParts = bufferLine.split(",", 4);

                String username = lineParts[0];
                int amount = Integer.parseInt(lineParts[1]);
                String dateString = lineParts[2];
                int yearlyFrequency = Integer.parseInt(lineParts[3]);

                Date date = null;
                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    date = dateFormat.parse(dateString);
                } catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("Could not conver dataString to data");
                }

                System.out.println(username);
                System.out.println(amount);
                System.out.println(date);
                System.out.println(yearlyFrequency);

                Expense localExpense = null;
                ExpenseCalculator inExpense = null;

                localExpense = new Expense(amount, date, yearlyFrequency);
                inExpense = new ExpenseCalculator();

                try {
                    inExpense.addExpense(localExpense, username);
                    trueFlase = true;
                } catch (Exception e) {
                    trueFlase = false;
                }

            }
        } catch (IOException e) {
            System.out.println("File not found");

        }
        return trueFlase;

    }

    public void importIncome(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String bufferLine;
            while ((bufferLine = reader.readLine()) != null) {
                bufferLine = reader.readLine();

                // sql goes here

                bufferLine = null;

            }
        } catch (IOException e) {
            System.out.println("File not found");

        }
    }

}
