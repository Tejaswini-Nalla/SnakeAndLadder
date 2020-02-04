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
        for(int playerno = 0; playerno<noOfPlayers; playerno++)
            players[playerno] = new Player();
    }

    void playerturn(int player)
    {
        while(true)
        {
            System.out.println((player+1)+" 's turn");
            roll = players[player].rollDice(dice);
            System.out.println((player+1)+" rolled "+roll);
            board.placeMove(roll,player);
            if(!dice.isRolledSix(roll))
            {
                return;
            }
            System.out.println("As "+(player+1)+" rolled "+roll+"again "+(player+1)+" 's turn");
        }
    }

    void startGame()
    {
        while(true)
        {
            for(int playerno = 0; playerno<noOfPlayers; playerno++)
            {
                playerturn(playerno);
                board.displayBoard();
                if(board.isGameOver())
                {
                    board.displayWinner();
                    return;
                }
            }
        }

    }
}