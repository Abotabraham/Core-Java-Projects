package tipcalculator;
/**
 * This program models bill sharing among friends when they are out. 
 *
 *@author George Abot Abraham Ret
 *@version 1.0, 05/09/2021
 */
import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
		 
		System.out.println("Welcome to the tip calculator!");
		System.out.print("What was the total bill? $");
		Scanner scanner = new Scanner(System.in);
		float bill = scanner.nextFloat();
		System.out.print("How much tip would you like to give? 10, 12, or 15? ");
		int tip = scanner.nextInt();
		System.out.print("How many people to split the bill? ");
		int people = scanner.nextInt();

		float tip_as_percent = (float)tip / 100;
		System.out.println(tip_as_percent);
		float total_tip_amount = bill * tip_as_percent;
		float total_bill = bill + total_tip_amount;
		float bill_per_person = total_bill / people;
		String final_amount = String.format("%.2f",bill_per_person);

		//print individual amount
	   System.out.println("Each person should pay: $" + final_amount);
	   scanner.close();

	}

}
