package App.Database;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Order> database = new ArrayList<Order>();

    public static void addDatabase(Order order){
        database.add(order);
    }
    public static ArrayList<Order> getDatabase(){
        return database;
    }
}
