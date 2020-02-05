import java.util.Random;

class Dice {

    int getDiceValue() { 
        return new Random().nextInt(6)+1;
    }
}