import java.util.Random;
class Dice {
    Random rand = new Random();
    int diceValue;

    int generateValue()
    { 
        diceValue = rand.nextInt(6)+1;
        return diceValue;
    }

    boolean isRolledSix(int roll)
    {
        return roll==6;
    }
}