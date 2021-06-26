package App.Sandwich;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Sandwich {                                                     // Definição da classe do sanduiche, cada
    private double price;                                                   // sanduíche deve ter um preço e a lista
    private ArrayList<Ingredient> ingredients = new ArrayList<>();          // de ingredientes que ele contém.
    public String getPrice() {
        NumberFormat formatter = new DecimalFormat("#0.00");        // Essa função cálcula o preço do
        price= 0;                                                           // sanduíche com base nos ingredientes
        deleteEmpty();                                                      // e retorna o valor já formatado.
        for(Ingredient ingredient:ingredients){
            price+=ingredient.getPrice()* ingredient.getAmount();
        }
        return formatter.format(price);
    }

    public void updateIngredients(String name, String price, int amount, Boolean inSandwich){
        double newPrice = Double.parseDouble(price);                        // Atualiza o ingrediente do lanche
        for (Ingredient i:ingredients){                                     // mas se o lanche não tiver o mesmo
            if(name.equals(i.getName())){                                   // ele o adiciona.
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
        ingredients.removeIf(ingredient -> !ingredient.isInSandwich());     // Se o ingrediente não tiver no lanche, é deletado
    }
}
