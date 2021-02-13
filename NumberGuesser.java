/*
 Instructions: 
 Write an application that plays “guess the number” as follows: Your program chooses the number to be by selecting a random number 
 in the range 1 to 1000. The application then displays a prompt: Guess a number between 1 and 1000. 
The player inputs a first guess. If the guess is wrong the program your program should display
Too Low. Try again:
  or
Too High. Try again
Then prompt the user for the next guess.  When the user enters the correct answer display:
Congratulations you are correct.
Enter true to play again, false to terminate the game:
This program must use a method checkNumber that return 0 if the number is correct, 1 if it is too low, and 2 if it is too high.  
The header for this method would be: public static int checkNumber(int correctNum, int guess)
 */
import java.util.*;

public class NumberGuesser 
{
	public static int checkNumber(int correctNum, int guess)
    {
        if(guess == correctNum) // we have a match!
            return 0;
        else if(guess < correctNum) // too low
            return 1;
        else
            return 2; // too high
    }
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        int response, randomNum, guess, highest, least, attempts = 0;
        boolean playAgain = true;
       
        while(playAgain == true)
        {
            least = 1;
            highest = 100;
            guess = -1;
            randomNum = (int)(Math.random() * 100 + 1);
            
            do 
            {               
                while(guess < least || guess > highest) 
                {
                    try 
                    {
                    	System.out.printf("Please enter your guess from %d to %d inclusive: ", least, highest);
                    	guess = input.nextInt();
                    
                    } catch (InputMismatchException ex) 
                    {
                        System.out.println("\n\tInvalid input. Program terminating.");
                        System.exit(0);
                    }
                }
                response = checkNumber(randomNum, guess);
                attempts++;
               
                if (response == 0)
                    System.out.printf("\nCongratulations! You guessed it. It only took you %d tries.\n", attempts);
                else if(response == 1)
                {
                    least = guess + 1;
                    System.out.printf("Too low. Try again.\n\n");
                }
                else if (response == 2)
                {
                    highest = guess - 1;
                    System.out.printf("Too high. Try again.\n\n");
                }
                
            } while(response != 0);
            
            System.out.printf("\nPlease enter true if you want to play again, false otherwise: ");
            playAgain = input.nextBoolean();
        }
        System.out.printf("\nThank you for guessing.\n", attempts);
    }

}
