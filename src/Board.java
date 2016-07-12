

public class Board {

    private static int board[][];
    private int numQueens;
    private static int size;

    public Board(int n) {
        numQueens = 0;
        size = n;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void start() {
        //starts the solve with 0 queens
        solve(0);
    }

    //solves the board
    public boolean solve(int numQueens) {
        //checks if the current number of queens is equal to the max
        if (numQueens == size) {
            this.printBoard();
            return true;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    //if its a valid move
                    if (validMove(i, j) == 0) {
                        //place queen
                        this.placeQueen(i, j, 0);
                        numQueens++;
                        //calles function again and checks if its true
                        if (solve(numQueens)) {
                            return true;
                        } else {
                            //if its not it removes queen and trys again
                            this.placeQueen(i, j, 1);
                            numQueens--;
                        }
                    }
                }
            }
        }
        return false;
    }

    //check to see if a spot if valid
    public static int validMove(int x, int y) {
        //checks horizontal
        for (int i = 0; i < size; i++) {
            if (get(x, i) == 1) {
                return -1;
            }
            //checks vertical
            if (get(i, y) == 1) {
                return -1;
            }
        }
        //check diagonal
        for (int i = 0; i < size; i++) {
            if (get(x - i, y - i) == 1) {
                return -1;
            }
            if (get(x - i, y + i) == 1) {
                return -1;
            }
            if (get(x + i, y - i) == 1) {
                return -1;
            }
            if (get(x + i, y + i) == 1) {
                return -1;
            }
        }
        return 0;
    }

    //0 is place queen, 1 is remove queen
    public int placeQueen(int x, int y, int type) {
        if (type == 0) {
            board[x][y] = 1;
            numQueens++;
            return 0;
        } else if (type == 1) {
            board[x][y] = 0;
            return 0;
        }
        return -3;
    }

    //gets value of tile
    public static int get(int x, int y) {
        if (x < 0 || y < 0 || x > size - 1 || y > size - 1) {
            return -1;
        }
        return board[x][y];
    }

    //prints board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.get(i, j) + " ");
            }
            System.out.println("");
        }
    }

}
