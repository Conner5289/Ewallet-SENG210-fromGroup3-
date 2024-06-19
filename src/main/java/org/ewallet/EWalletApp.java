package org.ewallet;

import java.awt.*;
import java.util.ArrayList;

public class EWalletApp extends GUI {
    //this is the app class, has the GUI and create one object of your expense calculator class. The expense calculator class is the implementation of the Expenser interface

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EWalletApp window = new EWalletApp();
                window.frmEWalletApp.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public EWalletApp() {
        super();
        initialize();
    }

    public void initialize() {

    }

    private ArrayList<User> AllData;
    public void CreateUser(String username, String password) {}
}