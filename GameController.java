class GameController{
    int noOfPlayers;
    int roll;
    Player[] players;
    GameBoard board;
    Dice dice = new Dice();
    GameController(){}
    GameController(int noOfPlayers)
    {
        this.noOfPlayers = noOfPlayers;
        players = new Player[noOfPlayers];
        board = new GameBoard(noOfPlayers);
    }

    void createPlayers()
    {
        for(int playerno=0; playerno<noOfPlayers; playerno++)
            players[playerno] = new Player();
    }

    void playerturn(int player)
    {
        while(true)
        {
            roll = players[player].rollDice(dice);
            board.placeMove(roll,player);
            if(!dice.isRolledSix(roll))
            {
                return;
            }
        }
    }

    void startGame()
    {
        while(true)
        {
            for(int playerno = 0; playerno<noOfPlayers; playerno++)
            {
                playerturn(playerno);
                if(board.isGameOver())
                {
                    board.displayWinner();
                    board.displayBoard();
                    return;
                }
                board.displayBoard();
            }
        }

    }
}