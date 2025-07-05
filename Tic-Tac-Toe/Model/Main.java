package Model;

public class Main {
    public static void main(String[] args) {
        Player P1 = new Player("Simran", 'O');
        Player P2 = new Player("Meera", 'X');
        Game game = new Game(P1, P2, 3);
        System.out.println("Game winner is: " + game.startGame());
    }
}
