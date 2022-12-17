import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        
        Random rand = new Random();
        int correct = rand.nextInt(1000000) + 1;

        System.out.println("Enter your guess: (1 - 1000000)");
        Scanner scanner = new Scanner(System.in);
        int terribleGuess = scanner.nextInt();

        if(terribleGuess == correct) {
            System.out.println("You guessed correctly!");
        }
        else if(terribleGuess < correct){
            System.out.println("Try guessing higher.");
        }
        else if(terribleGuess > correct){
            System.out.println("Try guessing lower.");
        }
    }
}
