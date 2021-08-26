/**
 * Mastermind takes care of being the mastermind for a game
 */
public class Mastermind {
    private String hiddenWord; // the word that the guesser has to guess

    /**
     * default constructor
     */
    public Mastermind(){
        hiddenWord = "";
    }

    /**
     * Constructor that takes in a word, sets class variable to the input
     * @param word
     */
    public Mastermind(String word){
        hiddenWord = word;
    }

    /**
     * constructor that gets a random word form the dictionary
     * @param d the inputted dictionary
     */
    public Mastermind(Dictionary d){
        hiddenWord = d.getRandomWord();
   }

    /**
     * @param str - a string input to set the hint
     * @return an object of the type Hint
     */
    public Hint getHint(String str){
        Hint h = new Hint(str, Hint.lettersInCommon(hiddenWord, str));
        return h;

    }

}
