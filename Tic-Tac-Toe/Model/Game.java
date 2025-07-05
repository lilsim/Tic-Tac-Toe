package Model;
import java.util.Scanner;
public class  Game{
    Player P1;
    Player P2;
    Player currPlayer;
    Board board;
    public Game(Player P1, Player P2, int size) {
        this.P1 = P1;
        this.P2 = P2;
        this.currPlayer = P1;
        this.board = new Board(size);
    }
    public String startGame() {
        Scanner sc = new Scanner(System.in);  // User input once only

        while (true) {
            board.display();  // Show current board

            // Check if board is full
            if (!board.isEmpty()) {
                System.out.println("Board full. Match Draw!");
                return "tie";
            }

            // Ask user to enter position
            System.out.println(currPlayer.name + "'s turn (" + currPlayer.piece + ")");
            System.out.print("Enter row (0-2): ");
            int row = sc.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = sc.nextInt();

            // Check if cell is empty
            if (!board.isEmptyCell(row, col)) {
                System.out.println("That spot is already taken! Try again.\n");
                continue;
            }

            // Place the piece
            board.placePiece(row, col, currPlayer.piece);

            // Check for winner
            if (board.isWin(currPlayer.piece)) {
                board.display();  // Show final board
                System.out.println(currPlayer.name + " wins the game!");
                return currPlayer.name;
            }

            // Switch player
            if (currPlayer == P1) {
                currPlayer = P2;
            } else {
                currPlayer = P1;
            }
        }
    }
}
