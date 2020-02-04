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

    void playerturn(int player) {
        while(true) {
            int currentPlayer = player+1;
            System.out.println(currentPlayer+" 's turn");
            roll = players[player].rollDice(dice);
            System.out.println(currentPlayer+" rolled "+roll);
            board.placeMove(roll,player);
            if(!dice.isRolledSix(roll)) {
                return;
            }
            System.out.println("As "+currentPlayer+" rolled "+roll+"again "+currentPlayer+" 's turn");
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