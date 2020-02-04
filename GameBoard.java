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
        return playerPositions.contains(finalSquare); 
    }

    int nextMove(int move)
    {
        int pos = snakesAndLadders.getOrDefault(move,move);
        return pos;
    }

    boolean checkMove(int move)
    {
        return move>finalSquare;
    }

    void placeMove(int roll, int player)
    {
        int playerCurPos = playerPositions.get(player);
        int move = playerCurPos + roll;
        if(!checkMove(move))
        {
            int nextPos = nextMove(move);
            playerPositions.set(player,nextPos);
        }
    }

}