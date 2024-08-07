package org.ewallet;

import java.awt.*;
import com.formdev.flatlaf.FlatDarkLaf;

public class EWalletApp {

        public static void main(String[] args) {
                FlatDarkLaf.setup();
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
}
