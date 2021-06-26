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

    public ConfirmGUI(Sandwich sandwich, String customer, double price){                // Aqui é criada a GUI para a confirmar
        this.customer = customer;                                                       // a compra, onde aparecem os ingredientes
        this.sandwich = sandwich;                                                       // e o valor total a ser pago, o cliente
        this.price = price;                                                             // pode cancelar a compra.
        setOptions(sandwich);
        createCancelButtonListeners();
        createConfirmButtonListeners();
        priceLabel.setText("Preço total: R$"+sandwich.getPrice());


    }
    private void setOptions(Sandwich sandwich){                                         // Aqui é definida a função para listar
        for(Ingredient ingredient:sandwich.getIngredients()){                           // os ingredientes em uma textBox.
            if(ingredient.getName().startsWith("Pão")){                                 // É usado um loop para percorrer os
                populate(ingredient);                                                   // ingredientes e a função populate
                text.append("----------------------\n");                                // para popular e formatar as informações.
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
        confirmButton.addActionListener(new ActionListener() {                          // Aqui é criado um ActionListener
            @Override                                                                   // para ser executado quando
            public void actionPerformed(ActionEvent e) {                                // o botão de confirmação for
                Database.addDatabase(new Order(customer, sandwich, price));             // pressionado, que confirma a
                JButton button = (JButton)e.getSource();                                // compra.
                Window window = SwingUtilities.windowForComponent( button );
                window.dispose();
            }
        });

    }
    private void createCancelButtonListeners(){
        cancelButton.addActionListener(new ActionListener() {                           // ActionListener para o botão
            @Override                                                                   // de cancelar, que fecha a janela
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