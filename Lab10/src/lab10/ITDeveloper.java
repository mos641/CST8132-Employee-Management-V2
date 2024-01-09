// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: An IT Developer employee, of a development type.

package lab10;

import java.util.Scanner;

/**
 * An IT Developer employee, of a development type.
 * 
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see Development
 */
public class ITDeveloper extends Development {
	// programming platform
	private String platform;

	/**
	 * No argument constructor to create objects
	 */
	ITDeveloper() {

	}

	/**
	 * Returns a formatted string of all the information.
	 * 
	 * @return A formatted string of the employee information.
	 */
	public String toString() {
		String details;

		// call super method and store
		details = super.toString() + " | Designation: IT Developer" + " | Programming Platform: " + platform;

		return details;
	}

	/**
	 * Adds an employee with information from the users input.
	 */
	public void addEmployee(Scanner input) {
		// call super classes method
		super.addEmployee(input);

		// ask for area of analysis
		System.out.print("Enter the programming platform of the IT Developer: ");
		platform = input.next();

	}

}
