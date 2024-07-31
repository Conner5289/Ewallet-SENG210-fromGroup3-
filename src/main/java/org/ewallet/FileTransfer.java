package org.ewallet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileTransfer {

    public void importFile(String filePath) {

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

    public void exportFiles(String filePath) {

    }

}
