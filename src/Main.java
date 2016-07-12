import java.util.Scanner;


/* nQueens problem
     find out how to place n number of queens in an nxn board so that they can't attack each other (can't share same vertical, horizontal, or diagonal) */
public class Main {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        System.out.println("how big?");
        int n = sin.nextInt();
        Board board = new Board(n);
        board.start();
    }
}
