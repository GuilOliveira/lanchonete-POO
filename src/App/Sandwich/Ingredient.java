package App.Sandwich;

public class Ingredient implements IIngredient{
    private String name;
    private double price;
    private int amount;
    private Boolean inSandwich;

    public Ingredient(String name, double price){
        this.name = name;
        this.price = price;
    }
    @Override
    public void setInSandwich(Boolean inSandwich) {
        this.inSandwich = inSandwich;
    }
    @Override
    public Boolean isInSandwich() {
        return inSandwich;
    }
    private void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    private void setPrice(double price) {
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }
    @Override
    public int getAmount() {
        return amount;
    }
}