package App.GUI;

import App.Database.Database;
import App.Database.Order;
import App.Sandwich.Ingredient;
import App.Sandwich.Sandwich;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmGUI {
    private JPanel masterPanel;
    private JPanel mainPanel;
    private JTextPane optionsTextPane;
    private JButton confirmButton;
    private JButton cancelButton;
    private JPanel confirmPanel;
    private JLabel priceLabel;
    StringBuilder text = new StringBuilder();
    private String customer;
    private Sandwich sandwich;
    private double price;

    public ConfirmGUI(Sandwich sandwich, String customer, double price){
        this.customer = customer;
        this.sandwich = sandwich;
        this.price = price;
        setOptions(sandwich);
        createCancelButtonListeners();
        createConfirmButtonListeners();
        priceLabel.setText("Preço total: R$"+sandwich.getPrice());


    }
    private void setOptions(Sandwich sandwich){
        for(Ingredient ingredient:sandwich.getIngredients()){
            if(ingredient.getName().startsWith("Pão")){
                populate(ingredient);
                text.append("----------------------\n");
            }
        }
        for(Ingredient ingredient:sandwich.getIngredients()){
            if(!ingredient.getName().startsWith("Pão")){
                populate(ingredient);
                }
        }
        optionsTextPane.setText(text.toString());

    }
    private void populate(Ingredient ingredient){
        text.append(ingredient.getName());
        text.append(" - ");
        text.append(ingredient.getAmount());
        text.append("\n");
    }
    private void createConfirmButtonListeners(){
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database.addDatabase(new Order(customer, sandwich, price));
                JButton button = (JButton)e.getSource();
                Window window = SwingUtilities.windowForComponent( button );
                window.dispose();
            }
        });

    }
    private void createCancelButtonListeners(){
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                Window window = SwingUtilities.windowForComponent( button );
                window.dispose();
            }
        });
    }
    public JPanel getMasterPanel(){
        return masterPanel;
    }
}