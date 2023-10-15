import java.util.Scanner;

public class GuessTheWord {
    private boolean play = true;
    private Words randomWord = new Words();
    private Scanner input = new Scanner(System.in);
    private int tries = 5;
    private char round;


    public void start(){
        do{
            // steps to build the game
            showWord();
            getInput();
            checkInput();

        }while(play);
    }// end start

    void showWord(){
        System.out.println("You have "+ tries + " tries left");
        System.out.println(randomWord);
    }

    void getInput(){
        System.out.println("Enter a letter to guess the word: ");
        String userGuess = input.nextLine();
        round = userGuess.charAt(0); // first character from user input


    }

    void checkInput(){
        boolean isGuessedRight = randomWord.guess(round);

        if(isGuessedRight){
            if(randomWord.isGuessedRight()){
                System.out.println("Congratulations, You won! \uD83D\uDC4F");
                System.out.println("The word is " + randomWord);
                play = false; // end the game
            }// end nested if
        }// end if
        else {
            tries--;
            if(tries == 0){
                System.out.println("You lose \uD83D\uDE14");
                System.out.println("Game over!");
                play = false;
            }
        }
    }// end checkInput(

    public void end() {
        input.close();
    }
}
