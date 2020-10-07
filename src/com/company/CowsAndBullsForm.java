package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CowsAndBullsForm {
    private JButton newGameButton;
    private JTextField txtInput;
    private JButton okButton;
    private JTable table1;
    private JPanel mainForm;

    private CowsAndBulls game;

    public CowsAndBullsForm() {

        game = new CowsAndBulls();

        newGameButton.addActionListener(e -> {
            game.restart();
        });
        okButton.addActionListener(e -> {
            if(txtInput.getText().isEmpty()) {
                return;
            }

            if(game.isGameOver()) {
                JOptionPane.showMessageDialog(null, "Sorry, game is already over!");
            }

            var number = Integer.parseInt(txtInput.getText());

            txtInput.setText("");

            var result = game.guess(number);

            // update UI
        });
    }
}
