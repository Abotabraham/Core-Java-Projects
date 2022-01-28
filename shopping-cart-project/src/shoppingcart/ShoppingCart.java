package shoppingcart;
 

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while(true){
            displayMenu();
            int choice = input.nextInt();

            // add item
            if (choice <= 4){
                if (choice == 1){
                System.out.print("Enter item to add: ");
                myList.add(input.nextInt());
                System.out.println("Item Added. ");
                } else if (choice == 2){
                // remove item
                System.out.print("Enter item to remove: ");
                int itemToRemove = input.nextInt();
                if (myList.contains(itemToRemove)){
                    myList.remove(Integer.valueOf(itemToRemove));
                    System.out.println("Item removed!");
                } else {
                    System.out.println("Item not found.");
                }
                } else if (choice == 3 ){
                // display list items
                System.out.println("Your List: " + myList);

                } else if (choice == 4){
                // exit the menu
                System.out.println("Exit. Thank You !");
                break;
            }

            } else {
                System.out.println("Invalid Choice.");
            }
            
            input.close();
        }

    }
 // Display to the user
    public static void displayMenu(){
        System.out.println();
        System.out.println("Option Menu: ");
        System.out.println(" 1. Add Item ");
        System.out.println(" 2. Remove Item ");
        System.out.println(" 3. Display List ");
        System.out.println(" 4. CheckOut");
        System.out.print( " Your Choice: ");
    }
}
