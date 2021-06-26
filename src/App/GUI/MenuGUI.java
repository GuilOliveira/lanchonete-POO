package App.GUI;

import App.Database.Order;
import App.Sandwich.Ingredient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuGUI implements ActionListener {
                                                                                                   // Classe que gera o menu com a base
    private JPanel mainPanel;                                                                      // de dados contendo os lanches comprados
    private JTextArea orderTextArea;                                                               // e os clientes.
    StringBuilder text = new StringBuilder();
    ArrayList<Order> database;

    public MenuGUI(ArrayList<Order> database) {
        this.database = database;                       // Importando o database para a classe
    }

    @Override
    public void actionPerformed(ActionEvent e) {                                                    // Essa ActionEvent inicia a janela contida
        JFrame dialog = new JFrame("Pedidos");                                                 // na mesma, e passa as configurações
        MenuGUI menuGUI = new MenuGUI(database);                                                    // necessárias. Também chama os métodos
        dialog.setContentPane(menuGUI.getMainPanel());                                              // necessários para a exibição do conteúdo
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
        setDataVisualization();
        menuGUI.setOrderTextArea(text.toString());

    }

    private JPanel getMainPanel() {
        return mainPanel;
    }
    private void setDataVisualization(){                                                            // Limpa os dados antigos e substitui
        text.delete(0, text.length());                                                              // Pelos novos, e formata o ambiente
        text.append("------ Lista de Pedidos ------\n");                                            // para a função ordersToLines, que
        text.append("Numero | Nome (preço) - lanche\n\n");                                          // recebe o banco de dados e transforma
        for(Order order:database){                                                                  // em um formato de texto.
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
