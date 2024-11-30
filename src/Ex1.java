import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string as number1# (or 'quit' to end the program)."); // the user need to input a certain number.
        String num1 = scanner.nextLine();

        if (num1.equalsIgnoreCase("quit")){    //if the word is 'quit', the program ends.
            System.out.println("Quitting now...");
            scanner.close();
            return;
        }

        System.out.println("Enter a string as number2# (or 'quit' to end the program)."); // the user need to input a second number.
        String num2 = scanner.nextLine();

        if (num2.equalsIgnoreCase("quit")){    //if the word is 'quit', the program ends.
            System.out.println("Quitting now...");
            scanner.close();
            return;
        }

        int numBase=0;   // base input

        while (true){  //while loop which continues until the user type the required input.
            System.out.println("Enter a base for output: (a number [2,16])");
            String baseInput = scanner.nextLine();
            numBase = Integer.parseInt(baseInput);

            try {    // try-catch format that catches input errors.

                if (numBase>=2 && numBase<=16){
                    break; // if the number is valid, continue the program.
                } else {

                    System.out.println("Error, the base number must be between 2 and 16");
                }
            } catch (NumberFormatException e) {

                System.out.println("Error, please enter a valid base number as required."); // the input must be a number, not a string.
            }

        }







        scanner.close();

    }


}
