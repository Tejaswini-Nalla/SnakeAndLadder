import java.util.ArrayList;
import java.util.Map;
class GameBoard {
    int finalSquare = 30;
    boolean isGameOver = false;
    ArrayList<Integer> playerPositions;
    GameBoard(int noOfPlayers)
    {
        playerPositions = new ArrayList<Integer>(noOfPlayers);
    }
    Map<Integer,Integer> snakesAndLadders = Map.ofEntries(
        Map.entry(3, 22),
        Map.entry(5,8),
        Map.entry(11,26),
        Map.entry(17,4),
        Map.entry(20,29),
        Map.entry(21,9),
        Map.entry(27,1)       
    );

    boolean isGameOver()
    {
        return isGameOver; 
    }

    void placeMove()
    {
        
    }

}