// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: This is an interface for an employee to be implemented elsewhere.

package lab10;

import java.util.Scanner;

/**
 * This is an interface for an employee to be implemented elsewhere.
 *  
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see
 */
interface Employee {
	
	/**
	 * Format all the information to a string.
	 * @return The string of all the information
	 */
	public String toString();
	
	/**
	 * Add an employee to the array list.
	 */
	public void addEmployee(Scanner input);

}
