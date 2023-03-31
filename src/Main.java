/* Main.java
 * 8 February 2023
 * Deepesh Kothari
 * Purpose:
 * Prints out a mancala board by using two methods
 * Modified 31 March 2023 DK:
 *      moved mancala stuff to its own class. Made mancala game fully functional.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Mancala mancala = new Mancala();
        Player[] player = {null, new Player(getString("What is player 1's name?"), 1, 6, 0, 5), new Player(getString("What is player 2's name?"), 2, 13, 7, 12)};
        int playerTurn = 1, pit, opponent, input;
        boolean playAgain = true;
        while(playAgain) {
            while (playerTurn != 0) {
                if (playerTurn == 1) opponent = 2;
                else opponent = 1;
                mancala.print();
                System.out.println("It is now " + player[playerTurn].name + "'s turn");
                pit = getInt("What pit do you want to move?", player[playerTurn].firstPit, player[playerTurn].lastPit, mancala, true);
                playerTurn = mancala.move(pit, player[playerTurn], player[opponent]);
            }
            if (mancala.winner() == 0) System.out.println("It's a tie!");
            if (mancala.winner() == 1) {
                System.out.println(player[1].name + " wins!");
                player[1].wins++;
            }
            if (mancala.winner() == 2) {
                System.out.println(player[2].name + " wins!");
                player[2].wins++;
            }
            playerTurn = 1;
            input = getInt("Do you want to play again?(1:yes/2:no)", 1, 2, mancala, false);
            if (input == 2){
                break;
            }
        }
        System.out.println(player[1].name+" won "+player[1].wins+" times!");
        System.out.println(player[2].name+" won "+player[2].wins+" times!");
    }
    private static String getString(String prompt){
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true) {
            try {
                System.out.println(prompt);
                str = scanner.nextLine();
            }catch(Exception e){
                System.out.println(e);
                continue;
            }
            break;
        }
        return str;
    }
    private static int getInt(String prompt, int lowerBound, int upperBound, Mancala mancala, boolean spot){
        Scanner scanner = new Scanner(System.in);
        int num;
        while(true) {
            try {
                System.out.println(prompt);
                num = scanner.nextInt();
                if (num < lowerBound|| num > upperBound) throw new OutOfBoundsException("Enter an integer between "+ lowerBound +" and "+ upperBound);
                if (spot) if (mancala.getSpot (num) == 0) throw new OutOfBoundsException("The spot you selected had no stones");
            }catch(Exception e){
                System.out.println(e);
                continue;
            }
            break;
        }
        return num;
    }
}