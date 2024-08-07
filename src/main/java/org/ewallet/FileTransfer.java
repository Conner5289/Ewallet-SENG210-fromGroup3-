package org.ewallet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public int exportExpense(File filePath, String user) {

        if (!filePath.getName().endsWith(".csv")) {
            filePath = new File(filePath + ".csv");
        }

        try {
            FileWriter writer = new FileWriter(filePath);
            List<Expense> loaclArray = ExpenseRepository.queryExpenseByUsername(user);

            for (int i = 0; i < loaclArray.size(); i++) {

                Expense loaclExpense = loaclArray.get(i);

                double amount = loaclExpense.getAmount();
                Date date = loaclExpense.getDate();
                int yearFrequency = loaclExpense.getYearlyFrequency();

                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
                String stringDate = formatter.format(date);

                writer.write(user + "," + amount + "," + stringDate + "," + yearFrequency + "\n");

            }
            writer.close();

        } catch (Exception e) {
            return 1;
        }

        return 0;
    }

    public int exportIncome(File filePath, String user) {

        if (!filePath.getName().endsWith(".csv")) {
            filePath = new File(filePath + ".csv");
        }

        try {
            FileWriter writer = new FileWriter(filePath);
            List<Wage> loaclArray = WageRepository.queryWageByUsername(user);

            for (int i = 0; i < loaclArray.size(); i++) {

                Wage loaclExpense = loaclArray.get(i);

                double amount = loaclExpense.getAmount();
                String source = loaclExpense.getSource();
                Date date = loaclExpense.getDate();

                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
                String stringDate = formatter.format(date);

                writer.write(user + "," + amount + "," + stringDate + "," + source + "\n");

            }
            writer.close();

        } catch (Exception e) {
            return 1;
        }

        return 0;
    }

}
