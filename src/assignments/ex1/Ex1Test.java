package assignments.ex1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {

    @Test
    void computeNumberTest() {
        String s2 = "1011b2"; // Binary number
        int v = Ex1.number2Int(s2); // Convert binary to decimal
        Assertions.assertEquals(11, v); // Assert that 1011b2 equals 11

        String s10 = "17"; // Decimal representation of 17
        v = Ex1.number2Int(s10); // Convert to decimal
        s2 = Ex1.int2Number(v, 2); // Convert back to binary
        int v2 = Ex1.number2Int(s2); // Convert the binary back to decimal
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123b16", "ABb16", "0b10"};
        for (String s : good) {
            assertTrue(Ex1.isNumber(s), "Expected true for: " + s);
        }

        String[] notGood = {"b2", "2b2", "1G3b16", " Bb16", "0bb10", "!@b2", "A", "1bb2" , "123b"};
        for (String s : notGood) {
            assertFalse(Ex1.isNumber(s), "Expected false for: " + s);
        }
    }

    @Test
    void int2NumberTest() {
        Assertions.assertEquals("1001b2", Ex1.int2Number(9, 2));  // 9 in binary is 1001
        Assertions.assertEquals("AbG", Ex1.int2Number(10, 16));   // 10 in hexadecimal is A
        Assertions.assertEquals("1111b2", Ex1.int2Number(15, 2));  // 15 in binary is 1111
        Assertions.assertEquals("1CbG", Ex1.int2Number(28, 16));   // 28 in hexadecimal is 1C
    }

    @Test
    void maxIndexTest() {
        // Test valid array with different bases
        String[] arr1 = {"1011b2", "1Fb16", "1Ab16"};
        Assertions.assertEquals(1, Ex1.maxIndex(arr1));  // Largest value is 1Fb16 (31 in decimal)

        // Test array with invalid numbers
        String[] arr2 = {"1011b2", "abc", "1234b10"};
        Assertions.assertEquals(2, Ex1.maxIndex(arr2));  // Max valid number is "1234b10"

        // Test array with all invalid numbers
        String[] arr3 = {"abc", "xyz", "b2b"};
        // All values are invalid, should return -1
    }
}
