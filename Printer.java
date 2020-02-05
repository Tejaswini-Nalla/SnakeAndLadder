class Printer{

    void displayWinner(int winner) {
        System.out.println("Winner is: "+"player "+winner);
    }
    
    void displayPositions(GameBoard board) {
        System.out.println("Player Positions: "+board.playerPositions);
    }

    void displaySnake()
    {
        System.out.println("Swallowed by Snake");
    }

    void displayLadder()
    {
        System.out.println("Climbed Ladder");
    }

    void printDiceValue(int value, int playerId)
    {
        System.out.println("Player "+playerId+" rolled "+value);
    }
}