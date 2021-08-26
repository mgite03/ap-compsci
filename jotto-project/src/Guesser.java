import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {
    private String guesserType;// type of guesser

    /**
     * Default constructor, sets guesser type to human
     */
    public Guesser(){
        guesserType = "human";
    }

    /**
     * constructor that takes in a string that sets the string as the type
     * @param type - the inputted string
     */
    public Guesser(String type){
        guesserType = type.toLowerCase();
    }

    /**
     * if guesserType is human, calls makeValidHumanGuess
     * if guesserType is ai, calls makeRandomAIGuess
     * @param hints - the inputted hint array
     * @param d - the inputted dictionary
     * @return guess, either human or ai
     */
    public String makeValidGuess(Hint[] hints, Dictionary d){
        if (guesserType.equals("human"))
            return makeValidHumanGuess(hints, d);
        else if (guesserType.equals("ai"))
            return makeRandomAIGuess(hints, d);
        else
            return "Nope, sorry";
    }

    /**
     * the big function
     * @param hints is an array of hints
     * @param d is the dictionary
     * @returns ret, the inputted  string, if it's valid
     */
    public String makeValidHumanGuess(Hint[] hints, Dictionary d){
        String ret = "";
        Scanner scanner = new Scanner(System.in);

        //runs if the word is in the dictionary, and if the hint is different form the previous hints
        while (!Dictionary.isValidWord(ret) ||!Hint.guessIsValid(ret, hints)) {
            System.out.print("Enter your guess:");
            ret = scanner.nextLine();
        }


        return ret;
    }


    /**
     * the ai makes a random guess
     * @param hints
     * @param d
     * @return a random word in d that works
     */
    public String makeRandomAIGuess(Hint[] hints, Dictionary d){
        ArrayList<String>  allValidGuesses = getAllValidGuesses(hints, d);
        String guess = allValidGuesses.get((int)(Math.random()* allValidGuesses.size()));
        return guess;
    }


    /**
     *creates an Array List of all valid guesses
     * @param hints takes in previous hints
     * @param d takes in all words in the dictionary
     * @return an arrayList of all possible words given the hints
     */
    public ArrayList<String> getAllValidGuesses(Hint[] hints, Dictionary d){
        d.startReading();
        ArrayList<String> validWords = new ArrayList<String>();
        while (d.hasNextWord()){
            String word = d.getNextWord();
            if (Hint.guessIsValid(word, hints))
                validWords.add(word);
        }
        return validWords;
    }
}
