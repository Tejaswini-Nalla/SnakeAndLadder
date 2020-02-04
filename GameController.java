class GameController{
    int noOfPlayers;
    int rollValue;
    Player[] players;
    GameBoard board;
    Dice dice = new Dice();
    Printer printer = new Printer();

    GameController(){}
    GameController(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        players = new Player[noOfPlayers];
        board = new GameBoard(noOfPlayers);
    }

    void createPlayers() {
        for(int playerNo = 0; playerNo<noOfPlayers; playerNo++)
            players[playerNo] = new Player();
    }

    boolean isRolledSix(int rollValue)
    {
        return rollValue == 6;
    }

    void playTurn(int player) {
        rollValue = players[player].rollDice(dice);
        board.placeMove(rollValue,player);
        if(isRolledSix(rollValue)) {
            playTurn(player);
        }
    }

    void playGame() {
        for(int playerNo = 0; playerNo<noOfPlayers; playerNo++) {
            playTurn(playerNo);
            printer.displayPositions(board);
        }
    }

    void start() {
        while(!board.isGameOver()) {
            playGame();
        }
        int winner = board.playerPositions.indexOf(board.finalSquare) + 1;
        printer.displayWinner(winner);
    }
}