// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 10 
// Description: Throws an exception when the user is not authorized to execute a command.

package lab10;

/**
 * Throws a more detailed exception, extends Exception. For when user's id is
 * not a manager id.
 * 
 * @author mos
 * @version 1.1
 * @since 1.8
 * @see Exception
 */
public class UnAuthorizedOperationException extends Exception {
	/**
	 * To satisfy compiler warning.
	 */
	private static final long serialVersionUID = 5749603824235195376L;

	/**
	 * Throw an exception for when the Id is not one of a manager's
	 */
	public UnAuthorizedOperationException() {
		System.err.println("You are NOT authorized to run this operation");
	}
}
