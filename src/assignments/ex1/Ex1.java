package assignments.ex1;

public class Ex1 {

    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) return -1;

        // If the string contains "b", we will process the number and its base
        if (num.contains("b")) {
            int bIndex = num.indexOf('b');
            String numberPart = num.substring(0, bIndex); // Number part
            String basePart = num.substring(bIndex + 1); // Base part

            // Ensure the base is within the valid range [2, 16]
            int base;
            try {
                base = parseBase(basePart); // Convert the base to an integer
                if (base < 2 || base > 16) return -1; // Invalid base
            } catch (NumberFormatException e) {
                return -1; // Invalid base
            }

            // Convert the number according to the specified base
            try {
                return Integer.parseInt(numberPart, base); // Convert to base 10
            } catch (NumberFormatException e) {
                return -1; // Invalid number
            }
        }

        // If there's no "b", assume the input is a decimal number
        try {
            return Integer.parseInt(num); // Convert to decimal
        } catch (NumberFormatException e) {
            return -1; // Invalid number
        }
    }

    public static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;

        String numberPart = s;
        int base = 10; // Default base

        // Check for 'b' separator between number and base
        if (s.contains("b")) {
            int bIndex = s.indexOf('b');
            // If 'b' is at the beginning or end of the string, it's invalid
            if (bIndex == 0 || bIndex == s.length() - 1) return false;

            numberPart = s.substring(0, bIndex); // Extract the number part
            try {
                base = parseBase(s.substring(bIndex + 1));
            } catch (NumberFormatException e) {
                return false; // Invalid base
            }
        }

        // If the base is outside the range 2-16, return false
        if (base < 2 || base > 16) return false;

        // Verify that the digits and characters are valid for the base
        for (char c : numberPart.toUpperCase().toCharArray()) {
            if (Character.digit(c, base) == -1) return false; // Invalid character for the base
        }
        return true; // All characters are valid
    }

    public static String int2Number(int num, int base) {
        return int2Number(num, base, true); // Default behavior includes the base information
    }

    public static String int2Number(int num, int base, boolean includeBase) {
        if (num < 0 || base < 2 || base > 16) return ""; // Invalid inputs
        String number = Integer.toString(num, base).toUpperCase(); // Convert to the target base
        if (includeBase) {
            return number + "b" + formatBase(base); // Include base information
        }
        return number; // Return only the number
    }


    public static boolean equals(String num1, String num2) {
        return number2Int(num1) == number2Int(num2); // Compare after converting to decimal
    }

    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        return maxValue == Integer.MIN_VALUE ? -1 : maxIndex; // If no valid values, return -1
    }

    private static int parseBase(String basePart) throws NumberFormatException {
        // Convert base from 10 to 16 using letters A-G
        if (basePart.matches("[A-G]")) {
            return 10 + (basePart.charAt(0) - 'A');
        }
        return Integer.parseInt(basePart);
    }

    private static String formatBase(int base) {
        // Represent the base as a string using A-G or a number
        return base > 9 ? String.valueOf((char) ('A' + base - 10)) : String.valueOf(base);
    }
}
