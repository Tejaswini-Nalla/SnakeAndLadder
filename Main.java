import java.util.Scanner;
class Main {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No Of Players");
        int noOfPlayers = input.nextInt();
        GameController game = new GameController(noOfPlayers);
        game.createPlayers();
        game.start();
    }
}