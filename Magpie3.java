/**
 * A program to carry on conversations with a human user.
 * This version:
 * <ul><li>
 *    Uses advanced search for keywords
 * </li></ul>
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3 {
	/**
	 * Get a default greeting
	 *
	 * @return a greeting
	 */
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	 public String getResponse(String statement) {
 		String response = "";
 		if (statement.indexOf("no") >= 0) {
 			response = "Why so negative?";
 		} else if (statement.indexOf("mother") >= 0
 				   || statement.indexOf("father") >= 0
 				   || statement.indexOf("sister") >= 0
 				   || statement.indexOf("brother") >= 0)
 		{
 			response = "Tell me more about your family.";

 		} else if (statement.indexOf("bearded dragon") >= 0
 				 || statement.indexOf("dog") >= 0
 				 || statement.indexOf("cat") >= 0
 				 || statement.indexOf("bird") >= 0)
 	{
 		response = "Tell me more about your pet.";
 	}

 	else if (statement.indexOf("I am hungry") >= 0
 			 || statement.indexOf("I want lunch") >= 0)
 {
 	response = "What do you want for lunch?";
 }


 	else if (statement.indexOf("Chicken") >= 0)
 {
 response = "Chicken is very yummy.";
 }
 	else if (statement.indexOf("Chicken") >= 0)
 {
 response = "Yes it is. What else are you doing today?";
 }
 	else if (statement.indexOf("I am going running") >=0)
 {
  response = "I cannot physically run. I am a laptop.";

 }

 	else if (statement.indexOf("Abby") >=0)
   {
  	 response = "Abby is my mom.";

   }
 	else if (statement.indexOf("AP Biology") >=0)
   {
  	 response = "Abby doesn't like AP Biology.";

   }
 	else if (statement.indexOf("I like to watch YouTube videos") >=0)


 	 if (statement.indexOf("I like to watch Netflix") >=0)
   {
  	 response = "My favorite show on Netflix is Disenchanted.";

   }

 	else if (statement.indexOf("I hate AP Biology") >=0)
   {
  	 response = "I want all of my cells to be in metabolic equilibrium.";

   }

 	else if (statement.indexOf("How are you") >=0)
   {
  	 response = "I am doing well, how are you?";
  }

 			else {
 			response = getRandomResponse();
 			}
 			return response;
 			}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0) {
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn);
			} if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal) {
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 *
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}

}
