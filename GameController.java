class GameController{
    int noOfPlayers;
    int roll;
    Player[] players = new Player[noOfPlayers];
    GameBoard board = new GameBoard(noOfPlayers);
    Dice dice = new Dice();
    GameController(int noOfPlayers)
    {
        this.noOfPlayers = noOfPlayers;
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
                    return;
                }
                board.displayBoard();
            }
        }

    }
}