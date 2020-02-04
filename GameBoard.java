import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

class GameBoard {
    int finalSquare = 30;
    boolean isGameOver = false;
    ArrayList<Integer> playerPositions; 
    Map<Integer,Integer> snakesAndLadders = Map.ofEntries(
        Map.entry(3, 22),
        Map.entry(5,8),
        Map.entry(11,26),
        Map.entry(17,4),
        Map.entry(20,29),
        Map.entry(21,9),
        Map.entry(27,1)       
    );
    Printer printer = new Printer();

    GameBoard(){}
    GameBoard(int noOfPlayers) {
        playerPositions = new ArrayList<Integer>(Collections.nCopies(noOfPlayers,0));
    }

    boolean isGameOver() {
        return playerPositions.contains(finalSquare); 
    }

    void checkSnakeOrLadder(int position, int nextPosition) {
        if(nextPosition > position)
            printer.displayLadder();
        else if(nextPosition < position)
            printer.displaySnake();
    }

    int getNextMove(int move) {
        int nextPos = snakesAndLadders.getOrDefault(move,move);
        checkSnakeOrLadder(move,nextPos);
        return nextPos;
    }

    boolean checkMove(int move) {
        return move > finalSquare;
    }

    void placeMove(int roll, int player) {
        int playerPosition = playerPositions.get(player);
        int position = playerPosition + roll;
        if(!checkMove(position)) {
            int nextPosition = getNextMove(position);
            playerPositions.set(player,nextPosition);
        }
    }
}