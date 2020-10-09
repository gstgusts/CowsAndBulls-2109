package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cows and Bulls");
        frame.setContentPane(new CowsAndBullsForm().mainForm);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(450, 500);
        frame.setVisible(true);
    }
}
