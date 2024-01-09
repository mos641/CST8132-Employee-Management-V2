// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: Contains the array lists of the employees, and manipulates the employees.

package lab10;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains the array lists of the employees, and manipulates the employees.
 * 
 * @author mos
 * @version 2.0
 * @since 1.8
 * @see Development, Management, Manager, ITDeveloper, ITAnalyst
 */
public class EmployeeList {
	// array lists
	private ArrayList<Management> managers = new ArrayList<Management>();
	private ArrayList<Development> developers = new ArrayList<Development>();
	// Scanner for user input
	private Scanner input;
	// loop variable
	private boolean loop = true;

	/**
	 * Constructor to create the employee management system
	 * 
	 * @param input A scanner to be fed in so it can be closed at the end of the
	 *              main method.
	 */
	EmployeeList(Scanner input) {
		// set the scanner
		this.input = input;
	}

	/**
	 * Add an employee to an array list
	 */
	public void addEmployee() {
		// employee type
		String type;

		// header
		System.out.println("Enter details of the employee " + (managers.size() + developers.size() + 1)
				+ "\n===============================");
		// ask for employee type, validate input
		do {
			// prompt
			System.out.print("Please select the type of employee you wish to add. \n"
					+ "Type (without quotations) 'm' for Manager or 'd' for IT Developer or 'a' for IT Analyst : ");

			// capture input
			type = input.next();
			// if it a valid choice, set loop condition to exit loop
			if (type.equalsIgnoreCase("m") || type.equalsIgnoreCase("d") || type.equalsIgnoreCase("a")) {
				loop = false;
			} else {
				// else throw exception
				System.out.println("Invalid account type, try again.");
			}

		} while (loop == true);
		// reset loop variable
		loop = true;

		// determine which array object needs to be created based on account type
		if (type.equalsIgnoreCase("m")) {
			// if they selected Manager
			Manager manager = new Manager();
			manager.addEmployee(input);
			managers.add(manager);
		} else if (type.equalsIgnoreCase("d")) {
			// if they selected IT developer
			Development developer = new ITDeveloper();
			developer.addEmployee(input);
			developers.add(developer);
		} else {
			// if they selected IT analyst
			Development developer = new ITAnalyst();
			developer.addEmployee(input);
			developers.add(developer);
		}

	}

	/**
	 * Print the details of all the employees
	 */
	public void printEmployeeDetails() {
		// Header
		System.out.println("Employee Management System\n" + "******************\n" + "Number of Employees : "
				+ (managers.size() + developers.size()) + "\n\nList of Management Employees\n");
		// print each index of the managers array
		for (int i = 0; i < managers.size(); i++) {
			// print to console
			System.out.print(managers.get(i).toString() + "\n");
		}
		// print each index of the developers array
		System.out.println("\nList of Development Employees\n");
		for (int i = 0; i < developers.size(); i++) {
			// print to console
			System.out.print(developers.get(i).toString() + "\n");
		}
	}

	/**
	 * Update an email of a user specified employee
	 */
	public void updateEmail() {
		int id;
		int index = -1;
		boolean manager = true;
		// ask for Id, loop to validate
		do {
			// ask for input
			System.out.print("Enter the ID of the employee whose email needs to be update: ");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			id = input.nextInt();

			// validate it is positive
			if (id < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (id < 0);

		// check the id to the available ones in managers list
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).mId == id) {
				index = i;
				i = managers.size();
				manager = true;
			}
		}

		// if the account was found in the managers array, skip checking developers
		if (index == -1) {
			for (int i = 0; i < developers.size(); i++) {
				if (developers.get(i).dId == id) {
					index = i;
					i = managers.size();
					manager = false;
				}
			}
		}

		// if the id was not found, display error message otherwise update the email
		if (index == -1) {
			System.out.println("Account not found. Returning to menu.");
		} else {
			System.out.print("Enter the new Email address of the employee: ");
			// if they were a manager or not
			if (manager == true) {
				managers.get(index).email = input.next();
				System.out.println("The new email address of " + managers.get(index).firstName + " "
						+ managers.get(index).lastName + " is:" + managers.get(index).email);
			} else {
				developers.get(index).email = input.next();
				System.out.println("The new email address of " + developers.get(index).firstName + " "
						+ developers.get(index).lastName + " is:" + developers.get(index).email);
			}
		}

	}

	/**
	 * Process through the employees and calculate their monthly salary
	 */
	public void monthlyPayroll() {
		// for formatting pay
		DecimalFormat format = new DecimalFormat("0.##");
		// to store pay
		double pay;

		// loop through arrays and calculate monthly salary
		// print and calculate the payroll of the managers array
		for (int i = 0; i < managers.size(); i++) {
			pay = (managers.get(i).salary / 12) * .8;
			System.out.println("Deposit " + format.format(pay) + "$ into " + managers.get(i).firstName + " "
					+ managers.get(i).lastName + "'s bank account");
		}

		// print and calculate the payroll of the developers array
		for (int i = 0; i < developers.size(); i++) {
			pay = (developers.get(i).salary / 12) * .8;
			System.out.println("Deposit " + format.format(pay) + "$ into " + developers.get(i).firstName + " "
					+ developers.get(i).lastName + "'s bank account");
		}

	}

	/**
	 * Display all employees managed by a specific manager/supervisor
	 */
	public void displayTeamEmployee() {
		// store input id
		int id;
		// index of manager
		int index = -1;

		// verify ID input
		do {
			// ask for input
			System.out.println("Enter the ID of the manager to display the members of his team");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println(
						"This is not an integer, try again. \nEnter the ID of the manager to display the members of his team");
				input.next();
			}

			// store the int
			id = input.nextInt();

			// validate it is positive
			if (id < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (id < 0);

		// find the manager in the array list
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).mId == id) {
				index = i;
				i = managers.size();
			}
		}

		// if manager was not found display an error message, otherwise find developers
		// with the same sId
		if (index == -1) {
			System.out.println("Manager not found. Returning to menu.");
		} else {
			System.out.println("Manager's Name: " + managers.get(index).firstName + " " + managers.get(index).lastName
					+ "\nDetail info for the members of " + managers.get(index).team + " team:");
			for (int i = 0; i < developers.size(); i++) {
				if (developers.get(i).sId == id) {
					System.out.println(developers.get(i).toString());
				}
			}
		}

	}

	/**
	 * Search for a specific employee by name.
	 */
	public void searchEmployee() {
		// variables
		String name;
		String option;
		int index = -1;

		// prompt for search type
		System.out.print(
				"Please enter search criteria.\nType (without quotations) 'f' for searching by first name or 'l' for searching by last name: ");
		option = input.next();
		// validate menu option
		while (!option.equalsIgnoreCase("f") && !option.equalsIgnoreCase("l")) {
			System.out.print("Invalid option. Try again: ");
			option = input.next();
		}

		// search depending on last or first name
		if (option.equalsIgnoreCase("f")) {
			// ask for first name
			System.out.println("Enter the first name of the employee you are looking for");
			name = input.next();
			// loop through the managers array searching for the name
			for (int i = 0; i < managers.size(); i++) {
				if (managers.get(i).firstName.equalsIgnoreCase(name)) {
					index = i;
					// print the found employee
					System.out.println(managers.get(index).toString());
				}
			}

			// loop through developers array to look for name
				for (int i = 0; i < developers.size(); i++) {
					if (developers.get(i).firstName.equalsIgnoreCase(name)) {
						index = i;
						// print the found employee
						System.out.println(developers.get(index).toString());
					}
				}
			
			// if the employee was not found let them know
			if (index == -1) {
				System.out.println("There is no employee with the first name of " + name);
			}
		} else {
			// ask for last name
			System.out.println("Enter the last name of the employee you are looking for");
			name = input.next();
			// loop through the managers array searching for the name
			for (int i = 0; i < managers.size(); i++) {
				if (managers.get(i).lastName.equalsIgnoreCase(name)) {
					index = i;
					// print the found employee
					System.out.println(managers.get(index).toString());
				}
			}

				// loop through developers array and look for the name
				for (int i = 0; i < developers.size(); i++) {
					if (developers.get(i).lastName.equalsIgnoreCase(name)) {
						index = i;
						// print the found employee
						System.out.println(developers.get(index).toString());
					}
				}
			// if the employee was not found let them know
			if (index == -1) {
				System.out.println("There is no employee with the last name of " + name);
			}
		}
	}

	/**
	 * Remove a specific employee if you have a manager's id.
	 */
	public void removeEmployee() {
		int removed = -1;
		int id;
		int size;
		boolean found = false;

		// verify ID input
		do {
			// ask for input
			System.out.println("Only Managers are allowed to remove an employee. Please provide your employee ID");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			id = input.nextInt();

			// validate it is positive
			if (id < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (id < 0);

		// verify they are an manager
		try {
			// check id to managers
			for (int i = 0; i < managers.size(); i++) {
				if (id == managers.get(i).mId) {
					// exit loop if found, set removed to 0 to begin counting how many were removed
					i = managers.size();
					removed = 0;
				}
			}
			// if id was not found, removed is still -1 and throw exception
			if (removed == -1) {
				throw new UnAuthorizedOperationException();
			}
		} catch (UnAuthorizedOperationException e) {
			// print error
			System.out.println(e);
			System.out.println("Returning to main menu");
		}

		// if they are a manager, take the id's and attempt to remove
		if (removed == 0) {
			// verify how many to remove input
			do {
				// ask for input
				System.out.println("How many employees do you want to remove?");

				// validate it is int
				while (!input.hasNextInt()) {
					System.out.println("This is not an integer, try again.");
					input.next();
				}

				// store the int
				size = input.nextInt();

				// validate it is positive
				if (size < 0) {
					System.out.println("Enter a positive value. Try again.");
				}

			} while (size < 0);

			// create an array list for all the IDs
			Integer[] remove = new Integer[size];
			
			// loop for repeated input
			for (int i = 0; i < size; i++) {

				// verify ID input
				do {
					// ask for input
					System.out.println("Enter the ID of the Employee " + (i + 1) + " to remove from the organization");

					// validate it is int
					while (!input.hasNextInt()) {
						System.out.println("This is not an integer, try again.");
						input.next();
					}

					// store the int
					id = input.nextInt();

					// validate it is positive
					if (id < 0) {
						System.out.println("Enter a positive value. Try again.");
					}

				} while (id < 0);

				// add id to the array
				remove[i] = id;
			}

			// loops to check and remove the employees
			// loop through the IDs to be removed
			for (int i = 0; i < size; i++) {
				int j;
				// loop through the array list of developers to check against the ID to be
				// removed
				for (j = 0; j < developers.size(); j++) {
					if (remove[i] == developers.get(j).dId) {
						developers.remove(j);
						removed++;
						//exit loop set found to true
						found = true;
						j = developers.size();
					}
				}
				// if it was not found, print so on the screen
				if (found == false) {
					System.out.println("Employee with ID " + remove[i] + " does not exist.");
				}
				//reset found to false
				found = false;
			}

			// Print how many employees were removed
			System.out.println(removed + " employees were removed from the system");
		
		} //end of removed

	}

	/**
	 * Promote an development employee to a manager if you have a manager's id.
	 */
	public void promoteEmployee() {
		int id;
		boolean found = false;
		int index = -1;
		String team = "team";

		// verify ID input
		do {
			// ask for input
			System.out.println("Only Managers are allowed to promote an employee. Please provide your employee ID");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			id = input.nextInt();

			// validate it is positive
			if (id < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (id < 0);

		// verify they are an manager
		try {
			// check id to managers
			for (int i = 0; i < managers.size(); i++) {
				if (id == managers.get(i).mId) {
					// store their team name to set the promoted employee
					team = managers.get(i).team;
					// exit loop if found, set found to true to indicate they are a manager
					i = managers.size();
					found = true;
				}
			}
			// if they are not a manager throw exception
			if (found == false) {
				throw new UnAuthorizedOperationException();
			}
		} catch (UnAuthorizedOperationException e) {
			// print error
			System.out.println(e);
			System.out.println("Returning to main menu");
		}

		// if they are a manager, take the id's and attempt to promote
		if (found == true) {
					
			// verify ID input
			do {
				// ask for input
				System.out.println("Enter the ID of the Employee you want to promote");

				// validate it is int
				while (!input.hasNextInt()) {
					System.out.println("This is not an integer, try again.");
					input.next();
				}

				// store the int
				id = input.nextInt();

				// validate it is positive
				if (id < 0) {
					System.out.println("Enter a positive value. Try again.");
				}

			} while (id < 0);

			// loop through developers and check their IDs
			for (int i = 0; i < developers.size(); i++) {
				if (developers.get(i).dId == id) {
					// if the ID is equal exit loop and set found
					index = i;
					i = developers.size();
				}
			}
			// if index is -1 and developer was not found tell them so
			if (index == -1) {
				System.out.println("There is no employee with the id number of " + id);
			} else {
				// if they were found add them create a new manager with their attributes
				Manager employee = new Manager();
				employee.mId = developers.get(index).dId;
				employee.firstName = developers.get(index).firstName;
				employee.lastName = developers.get(index).lastName;
				employee.email = developers.get(index).email;
				employee.salary = developers.get(index).salary;
				employee.setRank("Assistant Manager");
				// set their team name as the same as the manager who promoted them
				employee.team = team;

				// add this manager to the array list
				managers.add(employee);

				// remove from the developers
				developers.remove(index);
			}

		}
	}

}
