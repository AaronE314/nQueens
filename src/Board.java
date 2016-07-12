

public class Board {

    private static int board[][];
    private int numQueens;
    private static int size;
    private static int numofcalls = 0;

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
        solve(0);
    }

    public boolean solve(int numQueens) {
        //numofcalls++;
        //System.out.println("call: " + numofcalls);
        if (numQueens == size) {
            this.printBoard();
            return true;
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (validMove(i, j) == 0) {
                        this.placeQueen(i, j, 0);
                        numQueens++;
                        if (solve(numQueens)) {
                            return true;
                        } else {
                            this.placeQueen(i, j, 1);
                            numQueens--;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int validMove(int x, int y) {
        for (int i = 0; i < size; i++) {
            if (get(x, i) == 1) {
                return -1;
            }
            if (get(i, y) == 1) {
                return -1;
            }
        }
        //check diag
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

    public static int get(int x, int y) {
        if (x < 0 || y < 0 || x > size - 1 || y > size - 1) {
            return -1;
        }
        return board[x][y];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.get(i, j) + " ");
            }
            System.out.println("");
        }
    }

}
