package Model;

public class Player {
    String name;
    char piece;  

    public Player(String name, char piece) {
        this.name = name;
        this.piece = piece;
    }
    public String getName() {
        return this.name;
    }
    public char piece() {
        return this.piece;
    }
}
