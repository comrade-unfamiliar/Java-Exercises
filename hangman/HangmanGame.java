public class HangmanGame {

	private String answer; 
	private StringBuffer triedLetters; 
	private StringBuffer correctGuess; 

	public HangmanGame(String word) {
		/*
		 * Sets up dashes for every letter in the answer word.
		 */
		answer = word;
		triedLetters = new StringBuffer();
		correctGuess = new StringBuffer(word);
		correctGuess = correctGuess.replace(0, answer.length(), "-");
		for (int i = 0; i < answer.length() - 1; i++) {
			correctGuess = correctGuess.append("-");
		}
	}

	public String getTried() {
		// returns the letters tried
		return triedLetters.toString();
	}

	public String getGuessed() {
		/*
		 * returns the result of what the user guessed, with dashes if they did not
		 * guess the letter
		 */
		return correctGuess.toString();
	}

	public String getWord() { 
		// returns the correct answer.
		return answer;

	}

	public int tryLetter(char in) {
		/*
		 * Checks the user's inputted letters by looping through and comparing.
		 */
		
		if (triedLetters.indexOf(in + "") == -1) {
			if (answer.indexOf(in) > -1) {
				triedLetters.append(in);
				for (int i = 0; i < answer.length(); i++) {
					if (answer.charAt(i) == in)
						correctGuess.replace(i, i + 1, in + "");
				}
				return 1; // if letter has not been guessed and exists in the word

			} else {
				triedLetters.append(in);
				return -1; // returns if letter doesn't exist in the word
			}
		} else {
			return 0; // returns if letter was already tried
		}
	}

}