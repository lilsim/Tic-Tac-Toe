package Model;

public class Board {
    public int size;
    private char[][] grid;
    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        initializeBoard();
    }
    private void initializeBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    public boolean isEmptyCell(int row, int col) {
        return grid[row][col] == ' ';
    }

    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == ' ') return true;
            }
        }
        return false;
    }
    public void placePiece(int row, int col, char piece) {
        grid[row][col] = piece;
    }
    public boolean isWin(char piece) {
        // row check
        for(int i = 0;i < size; i++) {
            boolean rowCheck = true;
            for(int j = 0;j < size; j++) {
                if(grid[i][j] != piece) {
                    rowCheck = false;
                    break;
                }
            }
            if(rowCheck) return true;
        }
        //col check
        for(int j = 0;j < size; j++) {
            boolean colCheck = true;
            for(int i = 0;i < size; i++) {
                if(grid[i][j] != piece) {
                    colCheck = false;
                    break;
                }
            }
            if(colCheck) return colCheck;
        }
        // diagonal check
        // D1 & D2
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != piece) diag1 = false;
            if (grid[i][size - i - 1] != piece) diag2 = false;
        }

        return diag1 || diag2;
    }
    public void display() {
        System.out.println("\nBoard:");
        for (int i = 0; i < size; i++) {
            System.out.print(" ");
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] == ' ' ? '-' : grid[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.print("---".repeat(size - 1));
                System.out.println("-");
            }
        }
        System.out.println();
    }
}