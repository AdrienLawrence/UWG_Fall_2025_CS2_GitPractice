package edu.westga.cs1302.contact_manager.model;

/** Stores information for a contact.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Contact {
	private String name;
	private String phoneNumber;
	
	/** Create a new Contact with the provided information.
	 * 
	 * @precondition checkName(name) &&
	 * 				 checkPhoneNumber(phoneNumber)
	 * 
	 * @param name name of the contact
	 * @param phoneNumber phone number of the contact
	 */
	public Contact(String name, String phoneNumber) {
		if (!Contact.checkName(name)) {
			throw new IllegalArgumentException("name is not valid");
		}
		if (!Contact.checkPhoneNumber(phoneNumber)) {
			throw new IllegalArgumentException("phone number is not valid");
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	/** Checks if a phone number matches standard style for a phone number without area code
	 * Must be either ###-#### or #######
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param phoneNumber the text to be checked
	 * @return true 	if phoneNumber matches expected style
	 * 		   false 	if phoneNumber does not match expected style
	 */
	public static boolean checkPhoneNumber(String phoneNumber) {
		String noDashFormat = "\\d{7}";
		String dashFormat = "\\d{3}-\\d{4}";
		return phoneNumber != null && (phoneNumber.matches(noDashFormat) || phoneNumber.matches(dashFormat));
	}
	
	/** Checks if a name matches standard style
	 * Must have at least one character and only contain letters
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param name the text to be checked
	 * @return true 	if name matches expected style
	 * 		   false 	if name does not match expected style
	 */
	public static boolean checkName(String name) {
		return name != null && name.matches("[a-zA-Z]+");
	}

	/** Return the name for the Contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name for the Contact
	 */
	public String getName() {
		return this.name;
	}

	/** Return the phone number for the Contact
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the phone number for the Contact
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/** Return a string representation of the object state.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a string representation of the object state
	 */
	@Override
	public String toString() {
		return this.name + ", " + this.phoneNumber;
	}
}
