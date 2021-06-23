package App.Sandwich;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Sandwich {
    private double price;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    public String getPrice() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        price= 0;
        deleteEmpty();
        for(Ingredient ingredient:ingredients){
            price+=ingredient.getPrice()* ingredient.getAmount();
        }
        return formatter.format(price);
    }

    public void updateIngredients(String name, String price, int amount, Boolean inSandwich){
        double newPrice = Double.parseDouble(price);
        for (Ingredient i:ingredients){
            if(name.equals(i.getName())){
                i.setAmount(amount);
                i.setInSandwich(inSandwich);
                return;
            }
        }
        Ingredient ingredient = new Ingredient(name, newPrice);
        ingredient.setAmount(amount);
        ingredient.setInSandwich(inSandwich);
        ingredients.add(ingredient);
    }
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }

    public void deleteEmpty(){
        ingredients.removeIf(ingredient -> !ingredient.isInSandwich());
    }
}
