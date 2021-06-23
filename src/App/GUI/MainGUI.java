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
    private JPanel mainPanel;
    private JPanel confirmationPanel;
    private JLabel nameLabel;
    private JTextField customerText;
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
    JCheckBox[] checkBoxes = new JCheckBox[]{cheeseCheckBox1, cheeseCheckBox2, cheeseCheckBox3, cheeseCheckBox4, cheeseCheckBox5, othersCheckBox1,
            othersCheckBox2, greensCheckBox1, greensCheckBox2, greensCheckBox3, saucesCheckBox1, saucesCheckBox2, saucesCheckBox3, saucesCheckBox4,
            saucesCheckBox5, meatCheckBox6, meatCheckBox1, meatCheckBox2, meatCheckBox3, meatCheckBox4, meatCheckBox5};
    JComboBox[] comboBoxes = new JComboBox[]{breadComboBox1, breadComboBox2, breadComboBox3, breadComboBox4, cheeseComboBox5,
            cheeseComboBox1, cheeseComboBox2, cheeseComboBox3, cheeseComboBox4, othersComboBox2, othersComboBox1, saucesComboBox1,
            saucesComboBox2, saucesComboBox3, saucesComboBox4, saucesComboBox5, meatComboBox6, meatComboBox5,
            meatComboBox4, meatComboBox3, meatComboBox2, meatComboBox1, greensComboBox1, greensComboBox2, greensComboBox3};

    JRadioButton[] radioButtons = new JRadioButton[]{breadButton1, breadButton2, breadButton3, breadButton4};
    String noText = customerText.getText();;

    public MainGUI() {
        newSandwich();
        createCheckBoxListeners();
        createRadioButtonListeners();
        createMainButtonListeners();
        createComboBoxListeners();
        createOrdersButtonListeners();
    }
    private void createOrdersButtonListeners(){
        visualizeButton.addActionListener(new MenuGUI(Database.getDatabase()));
    }
    private void createMainButtonListeners(){
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(customerText.getText().equals(noText)){
                    JOptionPane.showMessageDialog(null, "Insira um nome para realizar a compra.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else if(!(breadButton1.isSelected() || breadButton2.isSelected()|| breadButton3.isSelected() || breadButton4.isSelected())){
                    JOptionPane.showMessageDialog(null, "Selecione o pão.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JFrame display = new JFrame("Confirmação");
                    display.setContentPane(new ConfirmGUI(sandwich, customerText.getText(), Double.parseDouble(sandwich.getPrice().replace(",","."))).getMasterPanel());
                    display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    display.setResizable(false);
                    display.pack();
                    display.setVisible(true);

                }
                sandwich.deleteEmpty();
            }
        });
    }
    private void createRadioButtonListeners(){
        for(JRadioButton radioButton:radioButtons){
            for(JComboBox comboBox:comboBoxes){
                String[] actualField = radioButton.getName().split("Button");
                if (Arrays.equals(actualField, comboBox.getName().split("ComboBox"))){
                    radioButton.addItemListener(new ItemListener() {
                        JComboBox comboBox;
                        Sandwich sandwich;
                        JRadioButton radioButton;
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            String name = radioButton.getText().split( " - R\\$ ")[0];
                            String value = radioButton.getText().split( " - R\\$ ")[1];
                            if(comboBox.isEnabled()){
                                comboBox.setEnabled(false);
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), false);
                                updatePrice();
                            }else{
                                comboBox.setEnabled(true);
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), true);
                                updatePrice();
                            }
                        }
                        private ItemListener setParams(JComboBox comboBox, Sandwich sandwich, JRadioButton radioButton) {
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
        for(JCheckBox checkBox:checkBoxes){
            for(JComboBox comboBox:comboBoxes){
                String[] actualField = checkBox.getName().split("CheckBox");
                if (Arrays.equals(actualField, comboBox.getName().split("ComboBox"))){
                    checkBox.addActionListener(new ActionListener() {
                        Sandwich sandwich;
                        JComboBox comboBox;
                        JCheckBox checkBox;
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String name = checkBox.getText().split( " - R\\$ ")[0];
                            String value = checkBox.getText().split( " - R\\$ ")[1];
                            if(comboBox.isEnabled()){
                                comboBox.setEnabled(false);
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), false);
                                updatePrice();
                            }else{
                                comboBox.setEnabled(true);
                                sandwich.updateIngredients(name, value, Integer.parseInt(comboBox.getSelectedItem().toString()), true);
                                updatePrice();
                            }
                        }
                        private ActionListener setParams(JComboBox comboBox, Sandwich sandwich, JCheckBox checkBox){
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
    private void createComboBoxListeners(){
        for(JComboBox comboBox:comboBoxes){
            for(JCheckBox checkBox:checkBoxes){
                String[] actualCheckField = checkBox.getName().split("CheckBox");
                if (Arrays.equals(actualCheckField, comboBox.getName().split("ComboBox"))){
                    comboActionReceiver(comboBox, checkBox);
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
        comboBox.addActionListener(new ActionListener() {
            Sandwich sandwich;
            JComboBox comboBox;
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

        private void comboActionReceiver(JComboBox comboBox, JRadioButton radioButton){
            comboBox.addActionListener(new ActionListener() {
                Sandwich sandwich;
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
        totalValueLabel.setText("R$ "+sandwich.getPrice());
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}