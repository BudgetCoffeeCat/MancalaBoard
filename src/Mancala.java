/* Mancala.java
 * 28 March 2023
 * Deepesh Kothari
 * Purpose:
 * Prints out a mancala board by using two methods
 * Stores data for the stones on a Mancala board
 */
public class Mancala {
    private int[] stones = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};
    public Mancala(){

    }
    public void print(){
        System.out.println("Mancala Board!");
        System.out.print("   ");
        for (int j = 12; j>6; j--){
            System.out.printf("%4d ", j);
        }
        System.out.println();
        printLine(36, true);
        System.out.print("    ");
        printDots(8, true);
        System.out.print("  ");
        for (int j = 12; j>6; j--){
            System.out.printf("%4d ", stones[j]);
        }
        System.out.println();
        System.out.print("    ");
        printDots(8, true);
        System.out.print(" "+stones[13]+" ");
        printLine(30, false);
        System.out.println(" "+stones[6]);
        System.out.print("    ");
        printDots(8, true);
        System.out.print("  ");
        for (int j = 0; j<6; j++){
            System.out.printf("%4d ", stones[j]);
        }
        System.out.println();
        System.out.print("    ");
        printDots(8, true);
        printLine(36, true);
        System.out.print("  ");
        for (int j = 1; j<7; j++){
            System.out.printf("%4d ", j);
        }
    }
    private static void printLine(int number, boolean newLine){
        for(int i = 0; i < number; i++){
            System.out.print("*");
        }
        if (newLine){
            System.out.println();
        }
    }
    private static void printDots(int number, boolean newLine){
        for(int i = 0; i < number; i++){
            System.out.print("*   ");
        }
        if(newLine){
            System.out.println();
        }
    }
}
