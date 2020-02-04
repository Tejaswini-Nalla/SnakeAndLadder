import java.util.Scanner;
class SnakeAndLadder {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter No Of Players");
        int noOfPlayers = input.nextInt();
        GameController controller = new GameController(noOfPlayers);
        controller.startGame();
    }
}