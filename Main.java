package project;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int choice = 0;

		while (choice != 14) {

			choice = menu(keyboard);

			switch (choice) {
			case 1:
				addProperty(keyboard);
				break;
			case 2:
				break;
			case 3:
				break;

			case 4:
				
				break;

			case 5:
				break;

			case 6:
			
				break;
			}

		}
		System.exit(0);
	}
	
	public static int menu(Scanner keyboard) {
		int choice = 0;
		
		System.out.println("*** Menu Options ****");
		System.out.println(
			 "1. Add a new Property" 
			+ "\n2. Add a new Real Estate Agency"
			+ "\n3. Add a new Real Estate Agent, assign the agent to an agency"
			+ "\n4. Assign a Property to an agent"
			+ "\n5. Modify the sale price of a Property that is currently listed"
			+ "\n6. Modify the rent price of a Property that is currently listed"
			+ "\n7. Change the status of a Property to off market and record the sale or rental transaction, date of transaction and the price at the time of the transaction"
			+ "\n8. Display Properties currently for sale of specific zip code" 
			+ "\n9. Display Properties currently for rent of specific zip code"
			+ "\n10. Display Properties current for sale within price range"
			+ "\n11. For a given zip code, identify whether prices have increased or decreased and by what percentage amount"
			+ "\n12. Display list of agents assigned to Properties in a specific zip code"
			+ "\n13. Save all data that has been entered from RAM to disk as one unit using Object Serialization"  
		);
		
		System.out.print("What would you like to do? ");

		try {
			choice = keyboard.nextInt();
		} catch (InputMismatchException e) {
			keyboard.nextLine();
			System.out.println("Input mismatch! Enter a new number: ");
		}
		return choice;
	
	}
	
	
	public static void addProperty(Scanner keyboard) {
		keyboard.nextLine();

		System.out.print("Enter property ID: ");
		int propertyID = keyboard.nextInt();
		
		LocalDate dateListed = getDateListed(keyboard);
		
		
		System.out.print("\nEnter agency ID: ");
		int agencyID = keyboard.nextInt();
		
		
		System.out.print("\nEnter agent ID: ");
		int agentID = keyboard.nextInt();

		PropertyType propertyType = getPropertyType(keyboard);
		
		
		PropertyStatus propertyStatus = getPropertyStatus(keyboard);
		
		Stack<Transaction> transactions = null;
		
		Property property = new Property(propertyID, dateListed, agencyID, agentID, propertyType, propertyStatus, transactions);

	}
	
	public static LocalDate getDateListed(Scanner keyboard) {
		System.out.println("Use format January 1, 2001");
		boolean tryAgain;
		String dateListedString = null;
		LocalDate dateListed = null;
		
		do {
			tryAgain = false;
			dateListedString = keyboard.nextLine();
			try {
				dateListed = LocalDate.parse(dateListedString, DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH));
			} catch (DateTimeParseException e) {
				tryAgain = true;
				System.out.println("Please use the proper format! Enter date again: ");
			}
		} while (tryAgain);
		
		return dateListed;
		
	}
	
	public static PropertyType getPropertyType(Scanner keyboard) {
		System.out.print("\nEnter the property type: ");
		String propertyTypeString = keyboard.nextLine();
        PropertyType propertyType = PropertyType.valueOf(propertyTypeString.toUpperCase());
        
        return propertyType;
	}
	
	public static PropertyStatus getPropertyStatus(Scanner keyboard) {
		System.out.print("\nEnter the property status: ");
		String propertyStatusString = keyboard.nextLine();
        PropertyStatus propertyStatus = PropertyStatus.valueOf(propertyStatusString.toUpperCase());
        
        return propertyStatus;
	}
	
	
	
	
	
	
}













