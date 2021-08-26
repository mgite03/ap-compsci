import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    private static String [] words;
    private int nextWordIndex;

    /**
     * default constructor, has a set list of dumb words
     */
    public Dictionary(){
        String[] allWords = {"thing", "house", "nacho", "bagel", "punch", "quits", "stick", "tours", "yurts", "joust"};
        words = allWords;
        nextWordIndex = 0;
    }

    /**
     * constructs a dictionary with a file inputted
     * @param fileName
     */
    public Dictionary (String fileName){
        File wordz = new File(fileName);
        String[] allWords = new String[1000];
        int count = 0;
        try {
            Scanner newScanner = new Scanner(wordz);
            while (newScanner.hasNextLine()){
                allWords[count] = newScanner.nextLine();
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found");
        }
        words = allWords;
    }

    /**
     * @return a random word from the dictionary
     */
    public String getRandomWord(){
       int i = (int)(Math.random()*words.length);
       return words[i];
    }

    /**
     * checks if word is in the dictionary
     *
     * @param str is the inputted word
     * @return true if the word is in the dictionary
     */
    public static boolean isValidWord(String str){
        for (int i = 0; i <words.length; i ++){
            if (words[i].equals(str))
                return true;
        }
        return false;
    }

    /**
     * "starts reading" the dictionary
     */
    public void startReading(){
        nextWordIndex = 0;
    }

    /**
     * @return true if dictionary has a next word, false if it doesn't
     */
    public boolean hasNextWord(){
        return nextWordIndex < words.length;
    }

    /**
     *  and the nextWordIndex++
     * @return the next word
     */
    public String getNextWord(){
        String retStr = words[nextWordIndex];
        nextWordIndex++;
        return retStr;
    }








}
