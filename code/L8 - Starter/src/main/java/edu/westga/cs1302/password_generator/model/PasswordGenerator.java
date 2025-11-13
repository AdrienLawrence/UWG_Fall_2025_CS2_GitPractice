package edu.westga.cs1302.password_generator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Generates a random password based on the characteristics required.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class PasswordGenerator {

	private int minimumLength;
	private boolean mustHaveAtLeastOneDigit;
	private boolean mustHaveAtLeastOneUpperCaseLetter;
	private boolean mustHaveAtLeastOneLowerCaseLetter;
	private Random randomNumberGenerator;

	/**
	 * Creates a new password generator. The generator will initially create a
	 * password with minimum length of 1 as the only requirement.
	 * 
	 * @precondition none
	 * @postcondition getMinimumLength() == 1 && getMustHaveAtLeastOneDigit() ==
	 *                false && getMustHaveAtLeastOneUpperCaseLetter() == false &&
	 *                getMustHaveAtLeastOneLowerCaseLetter() == false
	 * 
	 * @param seed the seed for the random number generator
	 */
	public PasswordGenerator(long seed) {
		this.randomNumberGenerator = new Random(seed);
		this.minimumLength = 1;
		this.mustHaveAtLeastOneDigit = false;
		this.mustHaveAtLeastOneUpperCaseLetter = false;
		this.mustHaveAtLeastOneLowerCaseLetter = false;
	}

	/**
	 * Returns the minimum length for a password generated.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the minimum length for a password generated.
	 */
	public int getMinimumLength() {
		return this.minimumLength;
	}

	/**
	 * Returns if the password generated must have at least one digit.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the password generated must have at least one digit.
	 */
	public boolean getMustHaveAtLeastOneDigit() {
		return this.mustHaveAtLeastOneDigit;
	}

	/**
	 * Returns if the password generated must have at least one upper case letter.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the password generated must have at least one upper case letter.
	 */
	public boolean getMustHaveAtLeastOneUpperCaseLetter() {
		return this.mustHaveAtLeastOneUpperCaseLetter;
	}

	/**
	 * Returns if the password generated must have at least one lower case letter.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the password generated must have at least one lower case letter.
	 */
	public boolean getMustHaveAtLeastOneLowerCaseLetter() {
		return this.mustHaveAtLeastOneLowerCaseLetter;
	}

	/**
	 * Sets the minimum length for passwords generated
	 * 
	 * @precondition length >= 1
	 * @postcondition getMinimumLength() == length
	 * 
	 * @param length the new minimum length for passwords generated
	 */
	public void setMinimumLength(int length) {
		if (length < 1) {
			throw new IllegalArgumentException("minimum length must be at least 1");
		}
		this.minimumLength = length;
	}

	/**
	 * Sets the requirement for whether passwords generated must have at least one
	 * digit
	 * 
	 * @precondition none
	 * @postcondition getMustHaveAtLeastOneDigit() == mustHaveAtLeastOneDigit
	 * 
	 * @param mustHaveAtLeastOneDigit whether passwords generated must have at least
	 *                                one digit
	 */
	public void setMustHaveAtLeastOneDigit(boolean mustHaveAtLeastOneDigit) {
		this.mustHaveAtLeastOneDigit = mustHaveAtLeastOneDigit;
	}

	/**
	 * Sets the requirement for whether passwords generated must have at least one
	 * upper case letter
	 * 
	 * @precondition none
	 * @postcondition getMustHaveAtLeastOneUpperCaseLetter() ==
	 *                mustHaveAtLeastOneUpperCaseLetter
	 * 
	 * @param mustHaveAtLeastOneUpperCaseLetter whether passwords generated must
	 *                                          have at least one upper case letter
	 */
	public void setMustHaveAtLeastOneUpperCaseLetter(boolean mustHaveAtLeastOneUpperCaseLetter) {
		this.mustHaveAtLeastOneUpperCaseLetter = mustHaveAtLeastOneUpperCaseLetter;
	}

	/**
	 * Sets the requirement for whether passwords generated must have at least one
	 * lower case letter
	 * 
	 * @precondition none
	 * @postcondition getMustHaveAtLeastOneLowerCaseLetter() ==
	 *                mustHaveAtLeastOneLowerCaseLetter
	 * 
	 * @param mustHaveAtLeastOneLowerCaseLetter whether passwords generated must
	 *                                          have at least one lower case letter
	 */
	public void setMustHaveAtLeastOneLowerCaseLetter(boolean mustHaveAtLeastOneLowerCaseLetter) {
		this.mustHaveAtLeastOneLowerCaseLetter = mustHaveAtLeastOneLowerCaseLetter;
	}

	/**
	 * Generates a password according to the established requirements.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the generated password
	 */
	public String generatePassword() {
		ArrayList<Character> passwordCharacters = new ArrayList<Character>();

		if (this.mustHaveAtLeastOneDigit) {
			passwordCharacters = this.addDigits(passwordCharacters);
		}
		if (this.mustHaveAtLeastOneUpperCaseLetter) {
			passwordCharacters = this.addUpperCaseLetters(passwordCharacters);
		}
		if (this.mustHaveAtLeastOneLowerCaseLetter) {
			passwordCharacters = this.addLowerCaseLetters(passwordCharacters);
		}
		int length = this.minimumLength + this.randomNumberGenerator.nextInt(this.minimumLength);
		while (passwordCharacters.size() < length) {
			passwordCharacters = this.addRandomCharacter(passwordCharacters);
		}

		return this.combineCharacters(passwordCharacters);
	}

	private ArrayList<Character> addRandomCharacter(ArrayList<Character> passwordCharacters) {
		int charType = this.randomNumberGenerator.nextInt(3);
		if (charType == 0) {
			passwordCharacters.add(this.getRandomUpperCaseLetter());
		} else if (charType == 1) {
			passwordCharacters.add(this.getRandomLowerCaseLetter());
		} else {
			passwordCharacters.add(this.getRandomDigit());
		}
		return passwordCharacters;
	}

	private ArrayList<Character> addLowerCaseLetters(ArrayList<Character> passwordCharacters) {
		double numberOfLowerCaseLettersToAdd = this.minimumLength / 3.0;
		for (int lettersAddedCount = 0; lettersAddedCount < numberOfLowerCaseLettersToAdd; lettersAddedCount++) {
			passwordCharacters.add(this.getRandomLowerCaseLetter());
		}
		return passwordCharacters;
	}

	private Character getRandomLowerCaseLetter() {
		return Character.toLowerCase(this.getRandomUpperCaseLetter());
	}

	private ArrayList<Character> addUpperCaseLetters(ArrayList<Character> passwordCharacters) {
		double numberOfUpperCaseLettersToAdd = this.minimumLength / 3.0;
		for (int lettersAddedCount = 0; lettersAddedCount < numberOfUpperCaseLettersToAdd; lettersAddedCount++) {
			passwordCharacters.add(this.getRandomUpperCaseLetter());
		}
		return passwordCharacters;
	}

	private Character getRandomUpperCaseLetter() {
		int letterToAdd = this.randomNumberGenerator.nextInt(26);
		return Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
							 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
							).get(letterToAdd);
	}

	private ArrayList<Character> addDigits(ArrayList<Character> passwordCharacters) {
		double numberOfDigitsToAdd = this.minimumLength / 3.0;
		for (int digitsAddedCount = 0; digitsAddedCount < numberOfDigitsToAdd; digitsAddedCount++) {
			passwordCharacters.add(this.getRandomDigit());
		}
		return passwordCharacters;
	}

	private char getRandomDigit() {
		return ((Integer) (this.randomNumberGenerator.nextInt(10))).toString().charAt(0);
	}

	private String combineCharacters(ArrayList<Character> passwordCharacters) {
		String password = "";
		for (Character currentChar : passwordCharacters) {
			password += currentChar;
		}
		return password;
	}
}
