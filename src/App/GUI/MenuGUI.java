package App.GUI;

import App.Database.Order;
import App.Sandwich.Ingredient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuGUI implements ActionListener {

    private JPanel mainPanel;
    private JTextArea orderTextArea;
    StringBuilder text = new StringBuilder();
    ArrayList<Order> database;

    public MenuGUI(ArrayList<Order> database) {
        this.database = database;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame dialog = new JFrame("Pedidos");
        MenuGUI menuGUI = new MenuGUI(database);
        dialog.setContentPane(menuGUI.getMainPanel());
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
        setDataVisualization();
        menuGUI.setOrderTextArea(text.toString());

    }

    private JPanel getMainPanel() {
        return mainPanel;
    }
    private void setDataVisualization(){
        text.delete(0, text.length());
        text.append("------ Lista de Pedidos ------\n");
        text.append("Numero | Nome (preço) - lanche\n\n");
        for(Order order:database){
            ordersToLines(order);
        }
    }
    private void ordersToLines(Order order){
        text.append(order.getId()+"| "+order.getCustomer()+"( R$"+order.getPrice()+") - ");
        for (Ingredient ingredient:order.getSandwich().getIngredients()){
            text.append(ingredient.getName()+"/ ");
        }
        text.append("\n");
    }
    public void setOrderTextArea(String text){
        this.orderTextArea.setText(text);
    }

}
