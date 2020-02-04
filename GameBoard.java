import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
class GameBoard {
    int finalSquare = 30;
    boolean isGameOver = false;
    ArrayList<Integer> playerPositions;
    GameBoard(){}
    GameBoard(int noOfPlayers)
    {
        playerPositions = new ArrayList<Integer>(Collections.nCopies(noOfPlayers,0));
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

    void displayWinner()
    {
        System.out.println("Winner is "+(playerPositions.indexOf(finalSquare) + 1)+"player");
    }
    
    void displayBoard()
    {
        System.out.println(playerPositions);
    }

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