package org.ewallet;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public JFrame frmEWalletApp;

    public JLabel testLabel;

    public GUI() {
        frmEWalletApp = new JFrame();
        frmEWalletApp.getContentPane().setBackground(new Color(192, 192, 192));

        testLabel = new JLabel("");
        frmEWalletApp.getContentPane().add(testLabel);

        frmEWalletApp.setTitle("EWallet App");
        frmEWalletApp.setBounds(100, 100, 800, 600);
        frmEWalletApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
