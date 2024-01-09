// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: An IT analyst employee, of the development type.

package lab10;

import java.util.Scanner;

/**
 * An IT analyst employee, of the development type.
 * 
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see Development
 */
public class ITAnalyst extends Development {
	// area of analysis
	private String area;

	/**
	 * No argument constructor to create objects
	 */
	ITAnalyst() {

	}

	/**
	 * Returns a formatted string of all the information.
	 * 
	 * @return A formatted string of the employee information.
	 */
	public String toString() {
		String details;

		// call super method and store
		details = super.toString() + " | Designation: IT Analyst" + " | Area of analysis: " + area;

		return details;
	}

	/**
	 * Adds an employee with information from the users input.
	 */
	public void addEmployee(Scanner input) {
		// call super classes method
		super.addEmployee(input);

		// ask for area of analysis
		System.out.print("Enter the area of analysis of the IT Analyst: ");
		area = input.next();
	}

}
