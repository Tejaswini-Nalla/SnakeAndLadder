class Printer{
    
    void displayWinner(GameBoard board) {
        int winner = board.playerPositions.indexOf(board.finalSquare) + 1;
        System.out.println("Winner is: "+"player "+winner);
    }
    
    void display(GameBoard board) {
        System.out.println("Player Positions: "+board.playerPositions);
    }

    void displaySnakeOrLadder(int move,int pos) {
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
}