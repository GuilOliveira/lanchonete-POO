package App.Database;

import App.Sandwich.Sandwich;

public class Order extends ImplementId {
    private int id;                                                     // Aqui são definidos os pedidos, cada
    private String customer;                                            // pedido deve ter um id, um cliente,
    private Sandwich sandwich;                                          // o sanduíche que ele comprou, e
    private double price;                                               // o preço final do lanche
    public Order(String customer, Sandwich sandwich, double price){
        id = super.newId();
        this.customer = customer;
        this.sandwich = sandwich;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getCustomer() {
        return customer;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public double getPrice() {
        return price;
    }
}
