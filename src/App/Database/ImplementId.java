package App.Database;

public class ImplementId {
    private static int lastId = 0;

    public int newId(){
        lastId+=1;
        return lastId;
    }
}
