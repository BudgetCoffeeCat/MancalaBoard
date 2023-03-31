/* Player.java
 * 31 March 2023
 * Deepesh Kothari
 * Purpose:
 *      Creates a struct player which holds all the information for each player
 */
public class Player {
    public Player(String name, int playerNumber, int mancala, int firstPit, int lastPit){
        this.playerNumber = playerNumber;
        this.name = name;
        this.mancala = mancala;
        this.firstPit = firstPit;
        this.lastPit = lastPit;
    }
    public final String name;
    public final int playerNumber, mancala, firstPit, lastPit;
    public int wins = 0;
}
