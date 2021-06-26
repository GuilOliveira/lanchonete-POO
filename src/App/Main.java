package App;

import App.GUI.MainGUI;

import javax.swing.*;

public class Main {


    public static void main(String[] args){                            // Aqui ocorre a inicialização da janela
        JFrame display = new JFrame("Lanchonete");                // principal, define o conteúdo, não deixa
        display.setContentPane(new MainGUI().getMainPanel());          // a janela ser ajustável e deixa-a visível.
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setResizable(false);
        display.pack();
        display.setVisible(true);
    }
}
