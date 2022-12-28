package project;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// ??
		ArrayList<Property> properties = new ArrayList<Property>();
		
		int choice = 0;

		while (choice != 14) {

			choice = menu(keyboard);

			switch (choice) {
			case 1:
				addProperty(keyboard, properties);
				break;
			case 2:
				break;
			case 3:
				break;

			case 4:
				// can only do this if the array list has something in it
				if (!properties.isEmpty()) {
					assignPropertyToAgent(keyboard, properties);
				}
				else {
					System.out.println("Error! You must add a property to assign an agent!\n");
				}
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
	
	
	public static void addProperty(Scanner keyboard, ArrayList<Property> properties) {
		keyboard.nextLine();

		System.out.print("Enter property ID: ");
		int propertyID = keyboard.nextInt();
		
		LocalDate dateListed = getDateListed(keyboard);
		
		
		System.out.print("\nEnter agency ID: ");
		int agencyID = keyboard.nextInt();
		
		
		System.out.print("\nEnter agent ID. If no agent is assigned, enter 0: ");
		int agentID = keyboard.nextInt();
		// agent ID can be nothing here, will assign later

		PropertyType propertyType = getPropertyType(keyboard);
		
		
		PropertyStatus propertyStatus = getPropertyStatus(keyboard);
		
		Stack<Transaction> transactions = null;
		
		Property property = new Property(propertyID, dateListed, agencyID, agentID, propertyType, propertyStatus, transactions);

		properties.add(property);
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
	
	public static void assignPropertyToAgent(Scanner keyboard, ArrayList<Property> properties) {

		
		// show list of properties to assign agent to
		displayProperties(properties);
		
		// ask which one
		System.out.println("Which property would you like to assign an agent to? Enter number: ");
		int propertyNum = keyboard.nextInt();
		Property property = properties.get(propertyNum-1);
		
		// get the agent id
		System.out.println("Enter agent ID: ");
		int agentID = keyboard.nextInt();
		
		// get property from array list, use setter to set agent
		property.setAgentID(agentID);
	}
	
	public static void displayProperties(ArrayList<Property> properties) {
		for (int i = 0; i < properties.size(); i++) {
			System.out.println((i+1) + ". " + properties.get(i));	
		}
	}
	
	public static void displayPropertiesInPriceRange(Scanner keyboard, ArrayList<Property>properties) {
		// get the price range
		// add to a list if it's in that price range
		// display list, use displayProperties method
		
		// price is in Transaction class
		// have to get it from there? 
		// when add property, have to add it to the transaction stack
		
		
		// loop through array os properties
		for (int i = 0; i < properties.size(); i++) {
			// if it's for sale
			Property property = properties.get(i);
			if (property.getPropertyStatus().equals(PropertyStatus.SALE)) {
				// check if it's in price range
				// have to get from the stack... everythingi s pushed on the stack so how do I know if it's the one I want
				// have to make a new stack and peek at the top to see if it's the one I'm dealing with now
				Stack<Transaction> newStack = new Stack<Transaction>();
				Transaction currTran = property.getTransactions().peek();
				
				
			//	Transaction price = property.getTransactions().get(i);
			}
		}
		// property has a property status
		// have to get the status
		// if it's for sale then continue here
	}
	
	public static void sortByZip(Scanner keyboard, ArrayList<Property> properties) {
		
	}
	
	
	
	
	
}













