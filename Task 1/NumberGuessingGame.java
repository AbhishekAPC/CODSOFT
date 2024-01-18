import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Random random = new Random();

       int maxNumber = 100; // You can change this to adjust the range
       int numAttempts = 10; // Number of attempts allowed
       int score = 0; // Keep track of the score

       boolean playAgain = true;

       while (playAgain) {
           int randomNumber = random.nextInt(maxNumber) + 1;
           int attempts = 0;

           System.out.println("I'm thinking of a number between 1 and " + maxNumber + ". Can you guess it?");

           while (attempts < numAttempts) {
               System.out.print("Enter your guess: ");
               int guess = scanner.nextInt();
               attempts++;

               if (guess == randomNumber) {
                   System.out.println("Congratulations! You guessed the number in " + attempts + " attempts!");
                   score++;
                   break;
               } else if (guess < randomNumber) {
                   System.out.println("Too low! Try again.");
               } else {
                   System.out.println("Too high! Try again.");
               }
           }

           if (attempts == numAttempts) {
               System.out.println("Sorry, you ran out of attempts. The number was " + randomNumber + ".");
           }

           System.out.print("Would you like to play again? (y/n): ");
           char playAgainChoice = scanner.next().charAt(0);
           playAgain = (playAgainChoice == 'y' || playAgainChoice == 'Y');

           System.out.println("Your current score is: " + score);
       }

       System.out.println("Thanks for playing! Your final score is: " + score);
   }
}
