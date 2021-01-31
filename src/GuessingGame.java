import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {

        //get maximum number for program to guess
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Enter maximum value: ");
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) {
                run = false;
                break;
            }
            if (!isNumeric(input)) {
                String msg = String.format("\"%s\"is not a text.\n", input);
                System.err.println(msg);
                continue;
            }
            int max = Integer.parseInt(input);
            //generate target number
            Random gen = new Random();
            int target = 1 + gen.nextInt(max);

            //start a guessing loop
            int curGuess = 0;
            System.out.println("Guess a number between 1 and " + max);

            for (int numGuess = 1; curGuess != target; numGuess++) {
                //get Users's next guess
                System.out.println("next guess: ");
                String temp = sc.next();
                try {
                    if (temp.equalsIgnoreCase("exit")) {
                        System.out.println("Вы пожелали выйти, господин!");
                        run = false;
                        break;
                    }
                    if (temp.equalsIgnoreCase("reset")) {
                        break;
                    }
                    curGuess = Integer.parseInt(temp);
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Ввод должен быть числом, не текстом");
                }
                if (curGuess < target) {
                    System.out.println(curGuess + " меньше заданного значения");
                } else if (curGuess > target) {
                    System.out.println(curGuess + " больше заданного значения");
                } else {
                    System.out.println("ты сделала это за " + numGuess + " попытки " + " правильный ответ: " + target);
                }
            }
        }
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
