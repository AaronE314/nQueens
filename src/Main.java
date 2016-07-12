import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        System.out.println("how big?");
        int n = sin.nextInt();
        Board board = new Board(n);
        board.start();
    }
}
