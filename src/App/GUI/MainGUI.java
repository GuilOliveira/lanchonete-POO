package App.GUI;

import App.Database.Database;
import App.Sandwich.Sandwich;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

public class MainGUI{
    //region Declaração dos elementos da interface
    private JPanel mainPanel;                                                       // Aqui fica a declaração dos elementos
    private JPanel confirmationPanel;                                               // localizados na interface, suas posições
    private JLabel nameLabel;                                                       // e outras informações ficam gravados
    private JTextField customerText;                                                // nos arquivos .form
    private JButton confirm;
    private JLabel confirmationName;
    private JPanel breadSelection;
    private JRadioButton breadButton1;
    private JRadioButton breadButton2;
    private JRadioButton breadButton3;
    private JRadioButton breadButton4;
    private JComboBox breadComboBox1;
    private JLabel breadCostLabel1;
    private JComboBox breadComboBox2;
    private JComboBox breadComboBox3;
    private JComboBox breadComboBox4;
    private JLabel breadCostLabel2;
    private JLabel breadCostLabel3;
    private JLabel breadCostLabel4;
    private JPanel cheeseSelection;
    private JCheckBox cheeseCheckBox1;
    private JCheckBox cheeseCheckBox2;
    private JCheckBox cheeseCheckBox3;
    private JCheckBox cheeseCheckBox4;
    private JCheckBox cheeseCheckBox5;
    private JPanel othersPanel;
    private JCheckBox othersCheckBox1;
    private JCheckBox othersCheckBox2;
    private JPanel greensPanel;
    private JCheckBox greensCheckBox1;
    private JCheckBox greensCheckBox2;
    private JCheckBox greensCheckBox3;
    private JPanel saucesPanel;
    private JCheckBox saucesCheckBox1;
    private JCheckBox saucesCheckBox2;
    private JCheckBox saucesCheckBox3;
    private JCheckBox saucesCheckBox4;
    private JCheckBox saucesCheckBox5;
    private JPanel meatPanel;
    private JCheckBox meatCheckBox6;
    private JCheckBox meatCheckBox1;
    private JCheckBox meatCheckBox2;
    private JCheckBox meatCheckBox3;
    private JCheckBox meatCheckBox4;
    private JCheckBox meatCheckBox5;
    private JComboBox cheeseComboBox5;
    private JComboBox cheeseComboBox1;
    private JComboBox cheeseComboBox2;
    private JComboBox cheeseComboBox3;
    private JComboBox cheeseComboBox4;
    private JLabel cheeseLabel1;
    private JLabel cheeseLabel2;
    private JLabel cheeseLabel3;
    private JLabel cheeseLabel4;
    private JLabel cheeseLabel5;
    private JComboBox othersComboBox2;
    private JComboBox othersComboBox1;
    private JLabel othersLabel1;
    private JLabel othersLabel2;
    private JComboBox saucesComboBox1;
    private JComboBox saucesComboBox2;
    private JComboBox saucesComboBox3;
    private JComboBox saucesComboBox4;
    private JComboBox saucesComboBox5;
    private JLabel saucesLabel1;
    private JLabel saucesLabel2;
    private JLabel saucesLabel3;
    private JLabel saucesLabel4;
    private JLabel saucesLabel5;
    private JComboBox meatComboBox6;
    private JComboBox meatComboBox5;
    private JComboBox meatComboBox4;
    private JComboBox meatComboBox3;
    private JComboBox meatComboBox2;
    private JComboBox meatComboBox1;
    private JLabel meatLabel1;
    private JLabel meatLabel2;
    private JLabel meatLabel3;
    private JLabel meatLabel4;
    private JLabel meatLabel5;
    private JLabel meatLabel6;
    private JComboBox greensComboBox1;
    private JComboBox greensComboBox2;
    private JComboBox greensComboBox3;
    private JLabel greensLabel1;
    private JLabel greensLabel2;
    private JLabel greensLabel3;
    private JLabel nameError;
    private JLabel totalValueLabel;
    private JButton visualizeButton;
    private JMenu ordersMenus;
    private Sandwich sandwich = new Sandwich();
    //endregion ------
    JCheckBox[] checkBoxes = new JCheckBox[]{cheeseCheckBox1, cheeseCheckBox2, cheeseCheckBox3, cheeseCheckBox4, cheeseCheckBox5, othersCheckBox1,                  // uma lista com todas as CheckBoxes, ComboBoxes
            othersCheckBox2, greensCheckBox1, greensCheckBox2, greensCheckBox3, saucesCheckBox1, saucesCheckBox2, saucesCheckBox3, saucesCheckBox4,                 // e RadioButtons, para depois no código servirem
            saucesCheckBox5, meatCheckBox6, meatCheckBox1, meatCheckBox2, meatCheckBox3, meatCheckBox4, meatCheckBox5};                                             // como fonte dos nomes dos ingredientes e seus
    JComboBox[] comboBoxes = new JComboBox[]{breadComboBox1, breadComboBox2, breadComboBox3, breadComboBox4, cheeseComboBox5,                                       // valores.
            cheeseComboBox1, cheeseComboBox2, cheeseComboBox3, cheeseComboBox4, othersComboBox2, othersComboBox1, saucesComboBox1,
            saucesComboBox2, saucesComboBox3, saucesComboBox4, saucesComboBox5, meatComboBox6, meatComboBox5,
            meatComboBox4, meatComboBox3, meatComboBox2, meatComboBox1, greensComboBox1, greensComboBox2, greensComboBox3};
    JRadioButton[] radioButtons = new JRadioButton[]{breadButton1, breadButton2, breadButton3, breadButton4};

    String noText = customerText.getText();                 // define o texto vazio, para compara-lo
                                                            // e ver se o cliente digitou algo
    public MainGUI() {
        newSandwich();
        createCheckBoxListeners();                          // O construtor da classe chama todos os
        createRadioButtonListeners();                       // métodos, para criar um novo sanduiche
        createMainButtonListeners();                        // e criar os Listeners para os elementos
        createComboBoxListeners();                          // do programa
        createOrdersButtonListeners();
    }
    private void createOrdersButtonListeners(){                                                 // Chama o método que invoca a janela do banco de dados
        visualizeButton.addActionListener(new MenuGUI(Database.getDatabase()));
    }
    private void createMainButtonListeners(){
        confirm.addActionListener(new ActionListener() {                                // Cria um Listener para o botão de compra
            @Override
            public void actionPerformed(ActionEvent e) {
                if(customerText.getText().equals(noText)){                                                                                                                          // Para evitar que o lanche seja criado sem
                    JOptionPane.showMessageDialog(null, "Insira um nome para realizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);                 // comprador e nem pão, foram criadas as
                }                                                                                                                                                                   // condicionais.
                else if(!(breadButton1.isSelected() || breadButton2.isSelected()|| breadButton3.isSelected() || breadButton4.isSelected())){
                    JOptionPane.showMessageDialog(null, "Selecione o pão.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JFrame display = new JFrame("Confirmação");
                    display.setContentPane(new ConfirmGUI(sandwich, customerText.getText(), Double.parseDouble(sandwich.getPrice().replace(",","."))).getMasterPanel());        // Chama o método para invocação da tela de
                    display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                                                                                                                    // confirmação, faz as configurações e
                    display.setResizable(false);                                                                                                                                                  // exibe a tela
                    display.pack();
                    display.setVisible(true);

                }
                sandwich.deleteEmpty();
            }
        });
    }
    private void createRadioButtonListeners(){
        for(JRadioButton radioButton:radioButtons){                                                                                                         // Aqui são criados os Listeners para os RadioButtons.
            for(JComboBox comboBox:comboBoxes){                                                                                                             // Para evitar a alta replicação de código, foi feito
                String[] actualField = radioButton.getName().split("Button");                                                                         // um loop para iterar sobre a lista de RadioButtons
                if (Arrays.equals(actualField, comboBox.getName().split("ComboBox"))){                                                                // que são comparados com as ComboBoxes pelo seu
                    radioButton.addItemListener(new ItemListener() {                                                                                        // nome, se os dois forem iguais, então significa que os items
                        JComboBox comboBox;                                                                                                                 // pertencem ao mesmo ingrediente, esse código só é executado uma vez.
                        Sandwich sandwich;
                        JRadioButton radioButton;
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            String name = radioButton.getText().split( " - R\\$ ")[0];      // Separa o nome e valor dos ingredientes
                            String value = radioButton.getText().split( " - R\\$ ")[1];
                            if(comboBox.isEnabled()){                                                                                                       // Se o RadioButton for ativado, ele deixa a ComboBox dísponível
                                comboBox.setEnabled(false);                                                                                                 // para edição, da um update no sanduiche com os ingredientes e
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), false);         // atualiza o preço total da GUI.
                                updatePrice();
                            }else{                                                                                                                          // Já se o RádioButton for desátivado, ele bloqueia a ComboBox,
                                comboBox.setEnabled(true);                                                                                                  // tira o ingrediente e atualiza o preço.
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), true);
                                updatePrice();
                            }
                        }
                        private ItemListener setParams(JComboBox comboBox, Sandwich sandwich, JRadioButton radioButton) {               // Passagem de parâmetros para classes anônimas
                            this.comboBox = comboBox;
                            this.sandwich = sandwich;
                            this.radioButton = radioButton;
                            return this;
                        }
                    }.setParams(comboBox, sandwich, radioButton));
                }
            }
        }
    }
    private void createCheckBoxListeners(){
        for(JCheckBox checkBox:checkBoxes){                                                                                             // Aqui são criados os Listeners para as CheckBoxes.
            for(JComboBox comboBox:comboBoxes){                                                                                         // Para evitar a alta replicação de código, foi feito
                String[] actualField = checkBox.getName().split("CheckBox");                                                      // um loop para iterar sobre a lista de CheckBoxes
                if (Arrays.equals(actualField, comboBox.getName().split("ComboBox"))){                                            // que são comparadas com as ComboBoxes pelo seu
                    checkBox.addActionListener(new ActionListener() {                                                                   // nome, se os dois forem iguais, então significa que os items
                        Sandwich sandwich;                                                                                              // pertencem ao mesmo ingrediente, esse código só é executado uma vez.
                        JComboBox comboBox;
                        JCheckBox checkBox;
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String name = checkBox.getText().split( " - R\\$ ")[0];         // Separa o nome e valor dos ingredientes
                            String value = checkBox.getText().split( " - R\\$ ")[1];
                            if(comboBox.isEnabled()){                                                                                                           // Se a CheckBox for ativada, ela deixa a ComboBox disponível
                                comboBox.setEnabled(false);                                                                                                     // para edição, da um update no sanduiche com os ingredientes e
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), false);             // atualiza o preço total da GUI.
                                updatePrice();
                            }else{                                                                                                                              // Senão, ele bloqueia a ComboBox, tira o ingrediente e atualiza o preço.
                                comboBox.setEnabled(true);
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), true);
                                updatePrice();
                            }
                        }
                        private ActionListener setParams(JComboBox comboBox, Sandwich sandwich, JCheckBox checkBox){                    // Passagem de parâmetros para classes anônimas
                            this.comboBox = comboBox;
                            this.sandwich = sandwich;
                            this.checkBox = checkBox;
                            return this;
                        }
                    }.setParams(comboBox, sandwich, checkBox));
                }
            }
        }
    }
    private void createComboBoxListeners(){                                                                     // Método para criação dos Listeners das ComboBoxes, que
        for(JComboBox comboBox:comboBoxes){                                                                     // são chamados a cada alteração da ComboBox, esse
            for(JCheckBox checkBox:checkBoxes){                                                                 // método vai percorrer por todas as ComboBoxes e compará-las
                String[] actualCheckField = checkBox.getName().split("CheckBox");                         // com as CheckBoxes e os RadioButtons, para cada combinação
                if (Arrays.equals(actualCheckField, comboBox.getName().split("ComboBox"))){               // será criado um Listener para a sua ComboBox correspondente,
                    comboActionReceiver(comboBox, checkBox);                                                    // usando o método comboActionReceiver, que usa do polimorfismo.
                }
            }
            for(JRadioButton radioButton:radioButtons){
                String[] actualCheckField = radioButton.getName().split("Button");
                if (Arrays.equals(actualCheckField, comboBox.getName().split("ComboBox"))){
                    comboActionReceiver(comboBox, radioButton);
                }
            }
        }
    }
    private void comboActionReceiver(JComboBox comboBox, JCheckBox checkBox){
        comboBox.addActionListener(new ActionListener() {                                                                               // Para a CheckBox: é resgatado, o nome e valor do ingrediente,
            Sandwich sandwich;                                                                                                          // e o método updateIngredients do sanduiche atual é acionado,
            JComboBox comboBox;                                                                                                         // o ingrediente então é atualizado com o valor da ComboBox.
            JCheckBox checkBox;
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = checkBox.getText().split( " - R\\$ ")[0];
                String value = checkBox.getText().split( " - R\\$ ")[1];
                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), true);
                updatePrice();
            }
            private ActionListener setParams(JComboBox comboBox, Sandwich sandwich, JCheckBox checkBox){
                this.comboBox = comboBox;
                this.sandwich = sandwich;
                this.checkBox = checkBox;
                return this;
            }
        }.setParams(comboBox, sandwich, checkBox));}

        private void comboActionReceiver(JComboBox comboBox, JRadioButton radioButton){                                                 // Para o RadioButton: é resgatado, o nome e valor do ingrediente,
            comboBox.addActionListener(new ActionListener() {                                                                           // e o método updateIngredients do sanduiche atual é acionado,
                Sandwich sandwich;                                                                                                      // o ingrediente então é atualizado com o valor do RadioButton.
                JComboBox comboBox;
                JRadioButton radioButton;
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = radioButton.getText().split( " - R\\$ ")[0];
                    String value = radioButton.getText().split( " - R\\$ ")[1];
                    sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), true);
                    updatePrice();
                }
                private ActionListener setParams(JComboBox comboBox, Sandwich sandwich, JRadioButton radioButton){
                    this.comboBox = comboBox;
                    this.sandwich = sandwich;
                    this.radioButton = radioButton;
                    return this;
                }
            }.setParams(comboBox, sandwich, radioButton));
    }
    public void newSandwich(){
        this.sandwich = new Sandwich();
    }
    private void updatePrice(){
        totalValueLabel.setText("R$ "+sandwich.getPrice());                         // O preço total da compra é atualizado
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}