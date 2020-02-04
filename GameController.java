class GameController{
    int noOfPlayers;
    int roll;
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

    boolean isRolledSix(int roll)
    {
        return roll == 6;
    }

    void playerturn(int player) {
        while(true) {
            roll = players[player].rollDice(dice);
            board.placeMove(roll,player);
            if(!isRolledSix(roll)) {
                return;
            }
        }
    }

    void start() {
        while(true) {
            for(int playerNo = 0; playerNo<noOfPlayers; playerNo++) {
                playerturn(playerNo);
                printer.display(board);
                if(board.isGameOver()) {
                    printer.displayWinner(board);
                    return;
                }
            }
        }
    }
}