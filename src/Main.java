/* Main.java
 * 8 February 2023
 * Deepesh Kothari
 * Purpose:
 * Prints out a mancala board by using two methods
 * Modified 28 March 2023 DK:
 *      moved mancala stuff to its own class
 *
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Mancala mancala = new Mancala();
        Player[] player = {null, new Player(), new Player()};
        int playerTurn = 1;
        player[1].name = getString("What is player 1's name?");
        player[1].firstPit = 0;
        player[1].lastPit = 5;
        player[1].mancala = 6;
        player[2].name = getString("What is player 2's name?");
        player[2].firstPit = 7;
        player[2].lastPit = 12;
        player[2].mancala = 13;
        while(playerTurn != 0){
            mancala.print();
            System.out.println("It is now "+player[playerTurn].name+"'s turn");
        }
    }
    private static String getString(String prompt){
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true) {
            try {
                System.out.println(prompt);
                str = scanner.nextLine();
            }catch(Exception e){
                System.out.println(e.toString());
                continue;
            }
            break;
        }
        return str;
    }
    private static int getInt(String prompt, int lowerBound, int upperBound){
        Scanner scanner = new Scanner(System.in);
        int num;
        while(true) {
            try {
                num = scanner.nextInt();
                System.out.println(prompt);
                if (num < lowerBound|| num > upperBound) throw new OutOfBoundsException("Enter an integer between "+ lowerBound +" and "+ upperBound);
            }catch(Exception e){
                System.out.println(e.toString());
                continue;
            }
            break;
        }
        return num;
    }
}