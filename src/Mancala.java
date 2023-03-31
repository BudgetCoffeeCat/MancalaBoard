/* Mancala.java
 * 28 March 2023
 * Deepesh Kothari
 * Purpose:
 * Prints out a mancala board by using two methods
 * Stores data for the stones on a Mancala board
 * Modified 31 March 2023
 *      Added a function to move a pit and functions to access data and add up stones. Also removed dots in the print function.
 */
public class Mancala {
    private int[] stones;
    public int move(int pit, Player player, Player opponent){
        int retVal, currentPit = pit;
        if (player.playerNumber == 1){
            retVal = 2;
        } else {
            retVal = 1;
        }
        while (stones[pit] != 0){
            currentPit++;
            if (currentPit == opponent.mancala){
                currentPit++;
            }
            if(currentPit == 14 ){
                currentPit = 0;
            }
            stones[currentPit]++;
            stones[pit]--;
        }
        if(stones[currentPit] == 1) {
            if (currentPit != player.mancala) {
                if (stones[12-currentPit] != 0) {
                    System.out.println(player.name + " stole " + (stones[12 - currentPit] + 1) + " stones.");
                    stones[player.mancala] += stones[12 - currentPit] + 1;
                    stones[12 - currentPit] = 0;
                    stones[currentPit] = 0;
                }
            }
        }
        if(totalStones(opponent) == 0)retVal = 0;
        if(currentPit == player.mancala)retVal = player.playerNumber;
        return retVal;
    }
    public int getSpot(int spot){
        return stones[spot];
    }
    public Mancala(){
        reset();
    }
    public int winner(){
        int retval = 0;
        if (stones[6]>stones[13])retval = 1;
        if (stones[6]<stones[13])retval = 2;
        return retval;
    }
    public void reset(){
         stones = new int[]{4,4,4,4,4,4,0,4,4,4,4,4,4,0};
    }
    public void endStones(){
        int pl1 = 0, pl2 = 0;
        for (int i = 0; i < 6; i++){
            pl1 += stones[i];
            pl2 += stones[i+7];
        }
        stones = new int[]{0,0,0,0,0,0,pl1,0,0,0,0,0,0,pl2};
    }
    private int totalStones(Player player){
        int retVal = 0;
        for (int i = player.firstPit; i < player.mancala; i++){
            retVal += stones[i];
        }
        return retVal;
    }
    public void print(){
        System.out.println("Mancala Board!");
        System.out.print("   ");
        for (int j = 12; j>6; j--){
            System.out.printf("%4d ", j);
        }
        System.out.println();
        printLine(36, true);
        System.out.print("  ");
        for (int j = 12; j>6; j--){
            System.out.printf("%4d ", stones[j]);
        }
        System.out.println();
        System.out.print(" "+stones[13]+" ");
        printLine(30, false);
        System.out.println(" "+stones[6]);
        System.out.print("  ");
        for (int j = 0; j<6; j++){
            System.out.printf("%4d ", stones[j]);
        }
        System.out.println();
        printLine(36, true);
        System.out.print("  ");
        for (int j = 0; j<6; j++){
            System.out.printf("%4d ", j);
        }
        System.out.println();
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
