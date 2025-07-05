package Model;

public class Cell {
    PlayingPiece piece = null;
    public void placePiece(PlayingPiece piece) {
        this.piece = piece;
    }
    public boolean isEmpty() {
        if(this.piece == null) return true;
        return false;
    }
}