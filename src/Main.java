import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {





//        int number = -1;
//        while (true){
//            System.out.println("Zadej číslo od 1 do 10: ");
//            number = scanner.nextInt();
//            if (number >= 1 && number <= 10) {
//                break;
//            } else {
//                System.out.println("číslo není správně zadán o");
//            }
//        }
//
//
//        int sum = 0;
//        for (int i = 1; i <= 10; i++){
//            int currentResult = i * number;
//            System.out.println(number + " x" + i + " = " + currentResult);
//        }


//        for (int i = 1; i <= 100; i = i + 3) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//
//        }
//        System.out.println("End");


//
//        int[] newNumbers = {5, 8, 9, 99, 103, 2, -5, 19, 7, -81};
//
//        int sum = 0;
//        for (int number: newNumbers)
//        {
//            sum += number;
//        }
//
//        double avarage = (double) sum / newNumbers.length;
//        System.out.println(
//                "sum:" + sum
//        );
//        System.out.println("avg: " + avarage);


//    for (int i = 1; i <= 10; i++ ) {
//        System.out.println(i);
//        for (int j = 0; j < i; j++ ) {
//            System.out.print(i);
//        }
//        System.out.println();
//    }


        final String[] words = {"skillmena", "akademia", "volby", "pocitac"};
        final Random random = new Random();

        final String wordToGuess = selectRandomWord(random, words);
        String hiddenWord = generateHiddenWord(wordToGuess);





        final int MAX_INCORRECT_GUESSES = 6;
        int incorrectGuesses = 0;

        final Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word: " + hiddenWord);

        while (incorrectGuesses < MAX_INCORRECT_GUESSES && hiddenWord.contains("_")) {
            System.out.println("Enter a letter: ");
            final char guess = scanLetter(scanner);
            if (wordToGuess.contains(String.valueOf(guess))) {
                // aktualizujeme slovo a potom gratulace a vypíšeme znova hiddenword
                hiddenWord = revealLetters(wordToGuess, hiddenWord, guess);
                System.out.println("Correct guess!!! Update word: " + hiddenWord);
            } else {
                incorrectGuesses++;
                System.out.println("Incorrect guess :(. You have " + (MAX_INCORRECT_GUESSES - incorrectGuesses) + " guesses left");

            }
        }
        if (hiddenWord.contains("_")) {
            System.out.println("Sorry, you have run out of guesses. The word was " + wordToGuess);
        } else {
            System.out.println("Congratulations :D. You nailed it!");
            }


    }
    public static  String revealLetters(String word, String hiddeWord, char letter) {
        char[] hiddenWordChars = hiddeWord.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                hiddenWordChars[i] = letter;
            }
        }
        return String.valueOf(hiddenWordChars);
    }


    public static char scanLetter(Scanner scanner) {
        char guess;

        while (true) {
            try {
                String line = scanner.nextLine();
                if (line.length() != 1) {
                    throw new Exception("Line lenght is not 1. Please enter a single character");
                }

                guess = line.charAt(0);
                if (!Character.isLetter(guess)) {
                    throw new Exception("Character is not letter. Please enter a single character");

                }
                break;

            } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
            }
        }
        return guess;
    }

    public static String generateHiddenWord(String word) {
        return "_".repeat(word.length());
    }

    public static String selectRandomWord(Random random, String[] words) {
        return words[random.nextInt(words.length)];
    }
}
