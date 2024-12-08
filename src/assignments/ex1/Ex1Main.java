package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        // לולאת הקלט ממשתמש עד שיכניס quit
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            // קלט למספר הראשון עם בדיקה אם תקין
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            int value1 = 0;
            while (true) {
                num1 = sc.next();
                if (num1.equalsIgnoreCase("quit")){
                    System.out.println("Quitting now...");
                    return;
                }

                boolean isNum1Valid = Ex1.isNumber(num1);
                value1 = isNum1Valid ? Ex1.number2Int(num1) : -1;
                if (value1 == -1) {
                    System.out.println("num1= " + num1 + " is number: false , value: -1");
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                    System.out.println("Please enter a valid number#1: ");
                } else {
                    System.out.println("num1= " + num1 + " is number: true , value: " + value1);
                    break;  // Move on if valid
                }
            }

            // קלט למספר השני עם בדיקה אם תקין
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
            int value2 = 0;
            while (true) {
                num2 = sc.next();
                if (num2.equalsIgnoreCase("quit")){
                    System.out.println("Quitting now...");
                    return;
                }

                boolean isNum2Valid = Ex1.isNumber(num2);
                value2 = isNum2Valid ? Ex1.number2Int(num2) : -1;

                if (value2 == -1) {
                    System.out.println("num2= " + num2 + " is number: false , value: -1");
                    System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                    System.out.println("Please enter a valid number#2: 12");
                } else {
                    System.out.println("num2= " + num2 + " is number: true , value: " + value2);
                    break;  // Move on if valid
                }
            }

            // קלט עבור הבסיס להמיר אליו
            System.out.println("Enter a base for output: (a number [2,16])");
            int base = sc.nextInt();
            sc.nextLine(); // Consume newline left by nextInt()
            if (base < 2 || base > 16) {
                System.out.println("Invalid base. Try again.");
                continue;
            }

            // חישוב סכום ומכפלה והמרה לבסיס המבוקש
            String sum = Ex1.int2Number(value1 + value2, base);
            String product = Ex1.int2Number(value1 * value2, base);
            System.out.println(num1 + " + " + num2 + " = " + sum);
            System.out.println(num1 + " * " + num2 + " = " + product);

            // מציאת המספר הגדול ביותר במערך
            String[] arr = {num1, num2, sum, product};
            int maxIdx = Ex1.maxIndex(arr);
            System.out.println("Max number over " + java.util.Arrays.toString(arr) + " is: " + arr[maxIdx]);
        }

        sc.close();
    }
}
