package App.Database;

import java.util.ArrayList;

public class Database {
    private static ArrayList<Order> database = new ArrayList<Order>();      // Cria uma classe estatica para
                                                                            // armazenar todos os dados dos
    public static void addDatabase(Order order){                            // lanches que foram vendidos
        database.add(order);
    }
    public static ArrayList<Order> getDatabase(){
        return database;
    }
}
