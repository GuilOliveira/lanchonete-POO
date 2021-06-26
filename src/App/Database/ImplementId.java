package App.Database;

public class ImplementId {
    private static int lastId = 0;

    public int newId(){                     // Um auto-incrementador estático
        lastId+=1;                          // para calcular os id's dos pedidos.
        return lastId;
    }
}
