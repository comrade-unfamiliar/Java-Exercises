import java.util.Scanner;

public class StringToolBox {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * Changes the 2nd word in a phrase (word after 1st space) to uppercase.
	 */
	public static String nameEcho(String s) {
		s = s.trim();
		int x = s.indexOf(" ");
		String s1 = s.substring(0, x + 1);
		String s2 = s.substring(x + 1);
		s2 = s2.toUpperCase();
		return s1 + s2;
	}

	/**
	 * Checks if the last character in the string is a star.
	 */
	public static boolean endsWithStar(String s) {
		int length = s.length();
		int star = s.lastIndexOf("*");
		boolean out = false;
		if (star == length - 1)
			out = true;
		if (length == 0)
			out = false;
		return out;
	}

	/**
	 * Checks if the last 2 characters in a string are both stars. We just look at
	 * the substring of the last 2 chars.
	 */
	public static boolean endsWithTwoStars(String s) {
		int length = s.length();
		boolean out = false;
		if (length >= 2) {
			String lastTwo = s.substring(length - 2);
			if (lastTwo.equals("**"))
				out = true;
		}
		return out;
	}

	/**
	 * Removes all dashes in a string by replacing them with empty strings.
	 */
	public static String removeDashes(String s) {
		s = s.trim();
		String g = s.replace("-", "");
		return g;
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		String str = " ";
		for (int j = 0; j < s.length(); j++) {
			/*
			 * This loop gets all the letters in the string and puts them in String str, so
			 * the program only looks at the letters and no characters other than lowercase
			 * letters.
			 */
			char letter = s.charAt(j);
			if (Character.isLowerCase(letter))
				str = str + letter;
			str = str.trim();
		}

		if (str.length() == 0 || str.length() == 1)
			return true;
		if (str.charAt(0) == str.charAt(str.length() - 1))
			/*
			 * check for first and last char of String: if they are same then do the same
			 * thing for a substring with first and last char removed. and carry on this
			 * until you string completes or condition fails. Slightly recursive. :)
			 */
			return isPalindrome(str.substring(1, str.length() - 1));

		// If it reaches this, that means the string isn't a palindrome.

		return false;

	}

	/**
	 * Converts mm/dd/yy date to dd-mm-yy. We look for the first and last indices of
	 * "/" to find the month, day, and year. The substrings between these are the
	 * m/d/y, so we take those and concatenate them in the desired output.
	 */
	public static String dateStr(String s) {
		s = s.trim();
		int slashIndex = s.indexOf("/");
		int slashIndex2 = s.lastIndexOf("/");
		String month = s.substring(0, slashIndex);
		String day = s.substring(slashIndex + 1, slashIndex2);
		String year = s.substring(slashIndex2 + 1);
		String output = day + "-" + month + "-" + year;
		return output;
	}

	/**
	 * Creates negative binary number by replacing all 0's with 1's, and vice versa.
	 * Done by replacing all 0's with a placeholder, 1's with 0, then replacing the
	 * placeholder with 1.
	 */
	public static String negativeBits(String s) {
		s = s.replace('0', '2');
		s = s.replace('1', '0');
		s = s.replace('2', '1');
		return s;
	}

	public static boolean containsSameChar(String s) {
		/*
		 * ALTERNATIVE METHOD:
		 * String matchingChars[] = s.split(s.substring(0, 1) + "+");
		 * return matchingChars.length == 0;
		 */
		/*
		 * Checks if all the chars in the string are the same. We replace every
		 * occurence of the 1st character of the string with an empty string. If all the
		 * string's chars are the same, this should produce an empty string.
		 */
		String firstChar = s.substring(0, 1);
		String replacedString = s.replace(firstChar, "");
		boolean output = replacedString.isEmpty();
		return output;
	}

	/**
	 * Removes all text between begin-comment and end-comment signs. Loops through
	 * string, finds substrings that aren't in comments, and concatenates them.
	 */
	public static String removeComments(String s) {
		s = s.trim();
		while (s.contains("/*") && s.contains("*/")) {
			int startIndex = s.indexOf("/*");
			int endIndex = s.indexOf("*/");
			String oldStr = s.substring(0, startIndex);
			String newStr = s.substring(endIndex + 2);
			s = oldStr + newStr;
		}
		return s;
	}

	/**
	 * Finds last 4 numbers of a credit card number.
	 */
	public static String last4(String s) {
		return s.substring(s.length() - 4);
	}

	/**
	 * Returns last 5 numbers in a credit card.
	 */
	public static String last5(String s) {
		String lastBefore = s.substring(s.length() - 6, s.length() - 5);
		lastBefore = lastBefore.trim();
		return lastBefore + s.substring(s.length() - 4);
	}

	/**
	 * Moves the first character to the end of the string.
	 */
	public static String scroll(String s) {
		s = s.trim();
		char first = s.charAt(0);
		s = s.replace(first, ' ');
		s = s.trim();
		return s + first;
	}

	/**
	 * Converts lastname, firstname to firstname lastname format.
	 */
	public static String convertName(String s) {
		s = s.trim();
		int x = s.indexOf(',');
		String lastName = s.substring(0, x);
		String firstName = s.substring(x + 2);
		return firstName + " " + lastName;
	}

	/**
	 * You first find the index of a character in the string to be encoded, then
	 * compare that to the index of that character in the alphabet. However, since
	 * you are shifting the alphabet basically, you add n to the alphabet index. So
	 * I put the alphabet, upper and lowercase, into a string: Then I make an empty
	 * string which will contain the encrypted string. Then, I have a loop which
	 * runs through all characters in the input; if it is a letter, the letter is
	 * encrypted by shifting it on the alphabet string and then adding it to the
	 * "encrypted" string. If it is another character, like a space or a comma, the
	 * program just adds it to the encrypted string, so you keep the punctuation
	 * &etc. When the loop has run through the whole thing, it returns the encrypted
	 * string.
	 */
	public static String caesar(String s, int n) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = s.length();
		String str = "";
		String encrypted = "";
		for (int k = 0; k < length; k++) {
			if (s.charAt(k) != '\"')
				str = str + s.charAt(k);
		}
		for (int i = 0; i < length; i++) {
			char letter = s.charAt(i);
			int alphabetIndex = alphabet.indexOf(letter);
			if (alphabetIndex == -1)
				encrypted = encrypted + letter;
			else {
				if (n >= 0) {
					String substring = alphabet.substring(alphabetIndex + n, alphabetIndex + 1 + n);
					encrypted = encrypted + substring;
				} else {
					String substring = alphabet.substring(alphabetIndex + 26 + n, alphabetIndex + 27 + n);
					encrypted = encrypted + substring;
				}

			}
		}
		return encrypted;
	}

	/**
	 * this caesar method encrypts spaces, which is slightly more secure.
	 */
	public static String caesarBetter(String s, int n) {
		s = s.toLowerCase();
		String cipherText = "";

		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (x != ' ') {
				int charPosition = ALPHABET.indexOf(s.charAt(i));
				int keyVal = (n + charPosition) % 26;
				char replaceVal = ALPHABET.charAt(keyVal);
				cipherText += replaceVal;
			}
		}
		return cipherText;
	}

	/**
	 * Checks if the password string is more than 7 characters long, has no spaces,
	 * and at least 1 uppercase, lowercase, and digit character. To do this, we loop
	 * through the string and check for spaces. We set up counters for number of
	 * digits, uppercase, and lowercase, and increment those when you loop through
	 * the string. Afterwards, we compare the counters to make sure there is at
	 * least 1 of each of these kinds.
	 */
	public static boolean validPassword(String s) {
		boolean isValid = true;
		int upperCaseCounter = 0, lowerCaseCounter = 0, digitCounter = 0;
		if (s.length() < 7)
			isValid = false;
		else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (Character.isSpace(c))
					isValid = false;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isUpperCase(c))
				upperCaseCounter++;
			if (Character.isLowerCase(c))
				lowerCaseCounter++;

		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c))
				digitCounter++;
		}
		if (upperCaseCounter < 1 || lowerCaseCounter < 1 || digitCounter < 1)
			isValid = false;
		return isValid;
	}

}
