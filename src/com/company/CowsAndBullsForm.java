package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CowsAndBullsForm {
    private JButton newGameButton;
    private JTextField txtInput;
    private JButton okButton;
    private JTable tblResult2;
    public JPanel mainForm;
    private JScrollPane scrlPane;
    private JPanel gridPanel;

    private CowsAndBulls game;

    public CowsAndBullsForm() {

        game = new CowsAndBulls();

        // update UI
        String[] columns = new String[] {"Nr.","Number","Bulls","Cows"};

        Object[][] data = new Object[][] {  };

        tblResult2 = new JTable(data, columns);

        tblResult2.setVisible(true);
        tblResult2.setAutoCreateColumnsFromModel(true);
        tblResult2.setEnabled(false);
        scrlPane.setViewportView(tblResult2);

        newGameButton.addActionListener(e -> {
            game.restart();
            okButton.setEnabled(true);
            txtInput.setEnabled(true);
            DefaultTableModel tblModel = new DefaultTableModel(data, columns);
            tblResult2.setModel(tblModel);
        });
        okButton.addActionListener(e -> {
            if(txtInput.getText().isEmpty()) {
                return;
            }

            if(game.isGameOver()) {
                JOptionPane.showMessageDialog(null, "Sorry, game is already over!");
                return;
            }

            if(txtInput.getText().length() > 4) {
                JOptionPane.showMessageDialog(null, "Sorry, entered text is too long");
                return;
            }

            try {
                var number = Integer.parseInt(txtInput.getText());
                txtInput.setText("");
                var result = game.guess(number);

                var data2 = new Object[game.getResults().size()][4];

                int row = 0;
                for (var res:game.getResults()) {
                    data2[row][0] = row + 1;
                    data2[row][1] = res.getNumber();
                    data2[row][2] = res.getBulls();
                    data2[row][3] = res.getCows();
                    ++row;
                }

                DefaultTableModel tblModel = new DefaultTableModel(data2, columns);
                tblResult2.setModel(tblModel);

                if(result.getBulls() == 4) {
                    JOptionPane.showMessageDialog(null, "Great job, you won!");
                    okButton.setEnabled(false);
                    txtInput.setEnabled(false);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Input is not a number");
                return;
            }

        });
    }
}
