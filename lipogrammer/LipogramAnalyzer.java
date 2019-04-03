public class LipogramAnalyzer {

	private String userInput;

	public LipogramAnalyzer(String s) {
		userInput = s;
	}

	public String mark(char c) {
		/*
		 * We just find each occurrence of the banned character and replace it with '#'.
		 */
		String character = "" + c;
		String text = userInput.replace(character, "#");
		return text;
	}

	public String allWordsWith(char c)
	/*
	 * To check for words that contain the banned character, we distinguish
	 * individual words by finding the substring between a space and the next space
	 * from it. We remove punctuation from the input string so punctuation is not
	 * labeled in banned words column. Then, we loop through the word, and, if it
	 * contains the banned character, we add it to the list of banned words. We do
	 * this until there are no more spaces (meaning no more words).
	 */
	{
		String ch = "" + c;
		String text = userInput.replaceAll("[^A-Za-z0-9]", " ");
		String word = "";
		String output = "";
		text = text.trim();
		int nextSpace = text.indexOf(" ");
		while (nextSpace != -1) {
			nextSpace = text.indexOf(" ");
			if (nextSpace == -1) {
				if (text.contains(ch)) {
					output += text;
				}
				break;
			}
			word = text.substring(0, nextSpace);
			String finalString = "";
			Character myChar = ' ';
			for (int i = 0; i < word.length(); i++) {
				myChar = word.charAt(i);
				if (Character.isLetterOrDigit(myChar))
					finalString = finalString + myChar;
			}
			if (finalString.contains(ch) && !output.contains(finalString + "\n")) {
				output += finalString;
				output += "\n";
			}

			text = text.substring(nextSpace);
			text = text.trim();
		}
		return output;
	}
