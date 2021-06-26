package App.Sandwich;

public interface IIngredient {

    public void setInSandwich(Boolean inSandwich);          // Aqui temos a definição do contrato
    public Boolean isInSandwich();                          // do ingrediente, todas os métodos
    public String getName();                                // públicos que um ingrediente deve ter,
    public double getPrice();                               // como: nome, preço, se ele está no lanche
    public void setAmount(int amount);                      // e a quantidade.
    public int getAmount();
}
