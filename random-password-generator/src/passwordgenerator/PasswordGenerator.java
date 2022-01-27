package passwordgenerator;
/**
 * 
 * This program generate random passwords of numbers, letters, and letters
 * 
 */
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// random password generator
public class PasswordGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char [] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		           'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
		           'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char [] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		char [] symbols = {'!', '#', '$', '%', '&', '(', ')', '*', '+'};
		System.out.println("\t\t******************************************************");
		System.out.println("\t\t\tWelcome to the JavaPassword Generator!");
		System.out.println("\t\t******************************************************\n");
		System.out.print("\t\tHow many letters would you like in your password? ");
		int numberOfLetters = scanner.nextInt();
		System.out.print("\t\tHow many symbols would you like in your password? ");
		int numberOfSymbols = scanner.nextInt();
		System.out.print("\t\tHow many numbers would you like in your password? ");
		int numberOfNumbers = scanner.nextInt();
		
		// list to keep track password generated
		List<Character> passwordList = new ArrayList<>();
		
		// generate random letters, symbols, and numbers
		Random random = new Random();
		int temp = numberOfLetters - 1;
		while(temp >= 0) {
			passwordList.add(letters[random.nextInt(numberOfLetters) + 1]);
			temp--;
		}
		
		temp = numberOfSymbols - 1;
		while(temp >= 0) {
			passwordList.add(symbols[random.nextInt(numberOfSymbols) + 1]);
			temp--;
		}
		temp = numberOfNumbers - 1;
		while(temp >= 0) {
			passwordList.add(numbers[random.nextInt(numberOfNumbers) + 1]);
			temp--;
		}
		
		 // before shuffling password list
		String passwordString = passwordList.toString().substring(1, 3 * passwordList.size() - 1)
                .replaceAll(", ", "");
		System.out.println("\n\t\tHere is your password before shuffling: " + passwordString);
		// after shuffling the password list.
		
		Collections.shuffle(passwordList);
		 passwordString = passwordList.toString().substring(1, 3 * passwordList.size() - 1)
                .replaceAll(", ", "");
		
		System.out.println("\n\t\tHere is your password after shuffling: " + passwordString);
		

	}

}
