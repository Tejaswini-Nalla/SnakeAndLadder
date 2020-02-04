import java.util.Random;

class Dice {
    Random rand = new Random();
    int diceValue;

    int getDiceValue()
    { 
        diceValue = rand.nextInt(6)+1;
        return diceValue;
    }
}