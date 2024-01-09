// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: This is the class for the main method for an employee management system.

package lab10;

import java.util.Scanner;

/**
 * This class is for the main method.
 * 
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see EmployeeList
 */
public class Lab10 {

	/**
	 * Main method to call and run the code. Includes the menu system.
	 * 
	 * @param String[]
	 * @throws Exception
	 */
	// main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String menu = "q";
		EmployeeList employees = new EmployeeList(input);

		// loop condition
		Boolean loop = true;
		// welcome message
		System.out.println("======= Welcome to the Employee Management System =======");

		// loop to loop through program until quitting
		do {

			// loop to throw and catch any exceptions
			do {
				// menu output for choices
				System.out.print(
						"a: Add a new employee (Management/Development) \n" + "u: Update email address of an employee\n"
								+ "d: Display the employees supervised by a Team Manager\n"
								+ "p: Print the info of all employees\n" + "m: Run monthly payroll\n" + "s: Search an employee\n"
								+ "r: Remove a list of employees\n" + "e: promote an employee\n" + "q: Quit\n"
								+ "\n" + "Enter your option: ");

				// store input
				menu = input.next();
				// menu = menu.toLowerCase();
				// if it a valid choice, set loop condition to exit loop
				if (menu.equalsIgnoreCase("a") || menu.equalsIgnoreCase("u") || menu.equalsIgnoreCase("d")
						|| menu.equalsIgnoreCase("p") || menu.equalsIgnoreCase("m") || menu.equalsIgnoreCase("s")
						|| menu.equalsIgnoreCase("r") || menu.equalsIgnoreCase("e") || menu.equalsIgnoreCase("q")) {
					loop = false;
				} else {
					// else print error message
					System.out.println("Wrong menu choice. Try again.");
				}

			} while (loop == true);

			// switch for each option
			switch (menu.toLowerCase()) {
			case "a":
				System.out.println();
				employees.addEmployee();
				System.out.println();
				//input.nextLine();
				break;
			case "u":
				System.out.println();
				employees.updateEmail();
				System.out.println();
				//input.nextLine();
				break;
			case "d":
				System.out.println();
				employees.displayTeamEmployee();
				System.out.println();
				//input.nextLine();
				break;
			case "p":
				System.out.println();
				employees.printEmployeeDetails();
				System.out.println();
				break;
			case "m":
				System.out.println();
				employees.monthlyPayroll();
				System.out.println("\n");
				break;
			case "s":
				System.out.println();
				employees.searchEmployee();
				System.out.println("\n");
				//input.nextLine();
				break;
			case "r":
				System.out.println();
				employees.removeEmployee();
				System.out.println("\n");
				//input.nextLine();
				break;
			case "e":
				System.out.println();
				employees.promoteEmployee();
				System.out.println("\n");
				//input.nextLine();
				break;
			}
			// default case for error message (verification) instead of inner loop

		} while (!menu.equalsIgnoreCase("q"));

		// quit message
		System.out.println("\nQuit: Successfully exited the program");

		// close scanner
		input.close();
	}

}
