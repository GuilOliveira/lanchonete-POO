package App.Sandwich;

public interface IIngredient {

    public void setInSandwich(Boolean inSandwich);
    public Boolean isInSandwich();
    public String getName();
    public double getPrice();
    public void setAmount(int amount);
    public int getAmount();
}
