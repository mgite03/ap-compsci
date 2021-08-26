public class Hint {
    private String hint;
    private int value;

    /**
     * default constructor, sets hint to an empty string
     */
    public Hint(){
        hint = "";
        value = 0;
    }
    /**
     * constructor takes in a string hint, and sets hint to the input
     * @param hint
     */
    public Hint(String hint, int value){
        this.hint = hint;
        this.value = value;
    }

    /**
     *accessor for the word
     * @return the hint
     */
    public String getWord(){
        return hint;
    }

    /**
     * accessor for the value
     * @return value
     */
    public int getValue(){ return value; }


    /**
     * @returns "hint, value" --> example: "CHAIR, 1"
     */
    public String toString() {
        return hint.toLowerCase()+ ", "+ value;
    }

    /**
     * happens when winning condition is met
     */
    public void winning(){
        if (value == 5) {
            System.out.println("The word was "+ hint);
            System.out.println("You guessed the word! :))");
        }
    }

    /**
     * @param str is the  hidden word
     * @param guess is the guess
     * @return the number of letters in common between them
     */
    public static int lettersInCommon(String str, String guess){
        str = str.toLowerCase();
        guess = guess.toLowerCase();
        int count = 0;
        for (int i = 0; i <5; i ++){
            for (int j = 0; j <5; j ++){
                if (guess.substring(i,i+1).equals(str.substring(j,j+1)))
                    count ++;
            }
        }
        return count;
    }

    /**
     * @param str inputted guess
     * @param hints the array of previous hints
     * @returns true if the guess works w numbers of all the previous hints, and if the inputted string doesn't match the rest of the hints
     */
    public static boolean guessIsValid(String str, Hint[] hints){
        for (Hint hint : hints)
            if (lettersInCommon(str, hint.getWord()) != hint.getValue() || hint.getWord().equals (str))
                return false;
        return true;
    }


}
