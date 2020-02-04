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
        System.out.println("Winner is: "+"player "+(playerPositions.indexOf(finalSquare) + 1));
    }
    
    void displayBoard()
    {
        System.out.println("Player Positions: "+playerPositions);
    }

    void displaySnakeOrLadder(int move,int pos)
    {
        if(pos>move)
        {
            System.out.println("Climbed Ladder");
        }
        else if(pos<move)
        {
            System.out.println("Swallowed By Snake");
        }
        else
        {
            System.out.println("No snake No Ladder");
        }
    }

    boolean isGameOver()
    {
        return playerPositions.contains(finalSquare); 
    }

    int nextMove(int move)
    {
        int pos = snakesAndLadders.getOrDefault(move,move);
        displaySnakeOrLadder(move,pos);
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