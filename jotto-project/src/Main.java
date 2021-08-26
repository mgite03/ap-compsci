import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

		String ret = "";
		Scanner mainScanner = new Scanner(System.in);
		System.out.print("human or ai? (lowercase)");
		ret = mainScanner.nextLine();

		Guesser player = new Guesser(ret);
		Dictionary dictionary = new Dictionary("yes_better_wordz.txt");
		Mastermind m = new Mastermind(dictionary);
		Hint[] hints = new Hint[0];
		Hint h = null;




		while (h == null || h.getValue() != 5) {
			for (Hint hint: hints){
				System.out.println(hint);
			}
			System.out.println("----------");
			String guess = player.makeValidGuess(hints, dictionary);
			h = m.getHint(guess.toLowerCase());
			hints = addHint(hints, h);
		}
		h.winning();
	}

	/**
	 * @param hints - array of hints
	 * @param newHint - the new hint
	 * @return - newHint added onto old array
	 */
	static public Hint [] addHint (Hint[] hints, Hint newHint){
		Hint [] newArray = new Hint [hints.length +1];
		for (int i = 0; i <hints.length; i ++){
			newArray [i] = hints[i];
		}
		newArray[hints.length] = newHint;
		return newArray;
	}




}

