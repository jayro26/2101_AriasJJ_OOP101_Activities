// Scanner Library
import java.util.Scanner;

class Canteen{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		// The MENU
		System.out.println("===== \tM E N U\t =====");
		System.out.println("1. Burger	- $80.00");
		System.out.println("2. Pizza	- $120.00");
		System.out.println("3. Pasta	- $100.00");
		System.out.println("4. Sandwich	- $70.00");
		System.out.println("5. Milk Tea	- $90.00");

		// Variables
		String studentOrNot, orderAgain;
		int itemNum, quantity, item = 0;
		double subtotal = 0, discount, total, beforeDiscount = 0, afterDiscount = 0, totalDiscount = 0;

		// Using the do-while loop to repeat the process when the user wants to order again. 
		do {
			System.out.println();
			// Another do-while loop if the user input is not on the menu.
			do {
				// Another do-while loop if the user input a quantity less than 1 or more than 10.
				do {
					System.out.print("Enter item number: ");
					itemNum = input.nextInt();
					System.out.print("Enter quantity: ");
					quantity = input.nextInt();

				// Using the switch statement
					switch (itemNum) {
						case 1:
							if (quantity > 10 || quantity < 1){
								System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
							}
							else {
								subtotal = 80.00 * quantity;
							}
							break; // The break statement only in the switch case to prevent execution from falling through into subsequent cases.
						case 2:
							if (quantity > 10 || quantity < 1){
								System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
							}
							else {
								subtotal = 120.00 * quantity;
							}
							break;
						case 3:
							if (quantity > 10 || quantity < 1){
								System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
							}
							else {
								subtotal = 100.00 * quantity;
							}
							break;
						case 4:
							if (quantity > 10 || quantity < 1){
								System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
							}
							else {
								subtotal = 70.00 * quantity;
							}
							break;
						case 5:
							if (quantity > 10 || quantity < 1){
								System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
							}
							else {
								subtotal = 90.00 * quantity;
							}
							break;
						default:
							System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
					}
				} while (quantity < 1 || quantity > 10);
			} while (itemNum < 1 || itemNum > 5);

			// Student
			System.out.print("Are you a student (Y/N): ");
			studentOrNot = input.next();

			// Discounts
			// using .equalsIgnoreCase so the program will ignore whether the character is uppercase or lowercase.
			if (studentOrNot.equalsIgnoreCase("Y") && subtotal >= 500)  {
				discount = subtotal * 0.15;
				total = subtotal - discount; 
			}	
			else if (studentOrNot.equalsIgnoreCase("Y")) {
				discount = subtotal * 0.10;
				total = subtotal - discount; 
			}
			else if (subtotal >= 500) {
				discount = subtotal * 0.05;
				total = subtotal - discount; 
			}
			else{
				discount = 0;
				total = subtotal - discount; 
			}

			// Printing Results
			System.out.printf("\nSubtotal: $%.2f%n", subtotal);
			System.out.printf("Discount: $%.2f%n", discount);
			System.out.printf("Order Total: $%.2f%n", total);

			// Asking the user to order again.
			System.out.print("\nDo you want to order again? (Y/N): ");
			orderAgain = input.next();

			// For Summary of Orders
			item += quantity;
			beforeDiscount += subtotal;
			totalDiscount += discount;
			afterDiscount += total;

		} while (orderAgain.equalsIgnoreCase("Y"));
		
		// closing the scanner to avoid memory leak.
		input.close();

		// Summary of Orders
		System.out.println("\n===== \tORDER SUMMARY \t=====");
		System.out.println("Total items: " + item);
		System.out.printf("Total before discount: $%.2f%n", beforeDiscount);
		System.out.printf("Total discount: $%.2f%n", totalDiscount);
		System.out.printf("Final Amount: $%.2f%n", afterDiscount);
		System.out.println("Thank you for ordering! :)\n");
	}
} 


// :)