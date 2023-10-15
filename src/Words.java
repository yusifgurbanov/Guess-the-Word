import java.util.Random;

public class Words {
    private String[] randomWords = {"animal", "happy", "study", "birthday", "university", "faculty", "professor", "staff",
            "ceremony", "information", "student", "instructor", "law", "nervous", "excited", "handsome"};

    private String selectedWord;
    private Random random = new Random();
    private char[] letters;


    public Words(){
        selectedWord = randomWords[random.nextInt(randomWords.length)];
        letters = new char[selectedWord.length()];
    }// end Words

    public String toString(){
        StringBuilder word = new StringBuilder();

        for(char letter : letters){
            if(letter == '\u0000') word.append('-');
            else word.append(letter); // logic of the game

            word.append(' ');
        }
        return word.toString();
    }// end toString()

    public boolean guess(char letter) {
        boolean guessedRight = false;
        for(int i = 0; i < selectedWord.length(); i++){
            if(letter == selectedWord.charAt(i)) {
                letters[i] = letter;
                guessedRight = true;
            }// end if
        }// end loop
        return guessedRight;
    }// end guess()

    public boolean isGuessedRight(){
        for(char letter : letters){
            if(letter == '\u0000') return false;
        }// end loop
        return true;
    }
}
