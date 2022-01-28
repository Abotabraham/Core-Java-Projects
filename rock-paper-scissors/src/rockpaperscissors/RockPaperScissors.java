package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;
// this program models rock-paper-scissor game
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random randomNum = new Random();
        int computerGeneratedChoice = randomNum.nextInt(3)+1;


        System.out.println("Let's play Rock, Paper, and Scissors!");
        System.out.println("Enter you choice: ");
        System.out.println("1.Rock");
        System.out.println("2.Paper");
        System.out.println("3.Scissors");
        System.out.print("Your Choice: ");
        int userChoice = userInput.nextInt();

        // Game logic
         if (userChoice > 3 || userChoice < 0) // in case user choice is out of range
             System.out.println("Invalid Choice. Try Again");
        if (computerGeneratedChoice == 1) {
            if (userChoice == 1) {
                System.out.println("Tie. Try Again!");
            } else if (userChoice == 2) {
                System.out.println("You Win!");
            } else if (userChoice == 3){
                System.out.println("You Lose. Wanna try again?");
            }
        } else if (computerGeneratedChoice == 2) {
            if (userChoice == 1) {
                System.out.println("You Lose! Wanna try again?");
            } else if (userChoice == 2) {
                System.out.println("Tie. Try Again!");
            } else if (userChoice == 3){
                System.out.println("You Win!");
            }
        } else {
            if (userChoice == 1) {
                System.out.println("You Win!");
            } else if (userChoice == 2) {
                System.out.println("You Lose! Wanna try again?");
            } else if (userChoice == 3){
                System.out.println("Tie. Try again!");
            }
        }
        userInput.close();
    }
    }



