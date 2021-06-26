package App.Sandwich;

public class Ingredient implements IIngredient{
    private String name;                                // A classe ingrediente assina o contrato
    private double price;                               // da interface, logo, é obrigada a implementar
    private int amount;                                 // seus métodos, além de ter métodos privados que
    private Boolean inSandwich;                         // só podem ser chamados pelo construtor da classe,
                                                        // impedindo assim o acesso por outras classes.
    public Ingredient(String name, double price){
        setName(name);
        setPrice(price);
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
