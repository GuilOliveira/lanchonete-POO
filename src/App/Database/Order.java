package App.Database;

import App.Sandwich.Sandwich;

public class Order extends ImplementId {
    private int id;
    private String customer;
    private Sandwich sandwich;
    private double price;
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
