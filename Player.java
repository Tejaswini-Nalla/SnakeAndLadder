class Player{
    Printer printer = new Printer();
    
    int rollDice(Dice dice, int playerId)
    {
        int diceValue = dice.getDiceValue();
        printer.printDiceValue(diceValue, playerId);
        return diceValue;
    }
}