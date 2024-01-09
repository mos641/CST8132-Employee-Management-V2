// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: Manager employee type.

package lab10;

import java.util.Scanner;

/**
 * This is a class for a Manager, extends the management class.
 * 
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see Management
 */
public class Manager extends Management {
	// manager rank
	private String rank;

	/**
	 * No argument constructor to create objects
	 */
	Manager() {

	}

	/**
	 * Returns a formatted string of all the information.
	 * 
	 * @return A formatted string of the employee information.
	 */
	public String toString() {
		String details;
		
		//call super method and store
		details = super.toString() + " | Designation: Manager" + " | Rank: " + rank;
		
		return details;
	}

	/**
	 * Adds an employee with information from the users input.
	 */
	public void addEmployee(Scanner input) {
		// call super classes method
		super.addEmployee(input);

		// ask for manager rank
		System.out.print("Enter the rank of the manager: ");
		rank = input.next();
	}
	
	/**
	 * Set the rank of the manager.
	 * @param rank The rank to set to the manager.
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

}
