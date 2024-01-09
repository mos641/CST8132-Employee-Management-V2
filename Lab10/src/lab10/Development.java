// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10
// Description: Development type employees behaviours and attributes.

package lab10;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This abstract class will be the basis for all development type employees.
 * Implements the Employee interface.
 * 
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see Employee
 */
public abstract class Development implements Employee {
	/** Development employee ID */
	protected int dId;
	/** First name */
	protected String firstName;
	/** Last name */
	protected String lastName;
	/** Email */
	protected String email;
	/** The ID of their supervisor */
	protected int sId;
	/** Yearly salary */
	protected double salary;

	/**
	 * No argument constructor to create objects
	 */
	Development() {

	}

	/**
	 * Returns a formatted string of all the information.
	 * 
	 * @return A formatted string of the employee information.
	 */
	public String toString() {
		// for formatting salary
		DecimalFormat format = new DecimalFormat("0.##");

		// add all the details to one string
		String details;
		details = "Name: " + firstName + " " + lastName + " | Employee ID: " + dId + " | Email:" + email
				+ " | Supervisor ID: " + sId + " | Yearly Salary: " + format.format(salary);

		// return string
		return details;
	}

	/**
	 * Adds an employee with information from the users input.
	 */
	public void addEmployee(Scanner input) {
		// ask for name
		System.out.print("Enter first name of the employee: ");
		firstName = input.next();

		System.out.print("Enter last name of the employee: ");
		lastName = input.next();

		// loop for ID
		do {
			// ask for input
			System.out.print("Enter the ID of the employee: ");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			dId = input.nextInt();

			// validate it is positive
			if (dId < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (dId < 0);

		// ask for email
		System.out.print("Enter the email of the employee: ");
		email = input.next();

		// loop for salary
		do {
			// ask for input
			System.out.print("Enter salary of the Employee: ");

			// validate it is double
			while (!input.hasNextDouble()) {
				System.out.println("This is not a double, try again.");
				input.next();
			}

			// store the double
			salary = input.nextDouble();

			// validate it is positive
			if (salary < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (salary < 0);

		// loop for supervisor ID
		do {
			// ask for input
			System.out.print("Enter the Supervisor's ID of the employee: ");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			sId = input.nextInt();

			// validate it is positive
			if (sId < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (sId < 0);

	}
}
