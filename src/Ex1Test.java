import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

        @Test
        void int2NumberTest() {
            assertEquals("101b2", Ex1.int2Number(5, 2)); // Binary
            assertEquals("15", Ex1.int2Number(15, 10)); // Base 10
            assertEquals("2Fb16", Ex1.int2Number(47, 16)); // Base 16 (Hex)
            assertEquals("", Ex1.int2Number(-1, 10)); // Invalid number
            assertEquals("", Ex1.int2Number(10, 20)); // Invalid base
        }

        @Test
        void maxIndexTest() {
            //                      18,       52,      48,      107,     100,     45,     24,      32
            String[] numbers = {"10010b2", "1221b3", "300b4", "412b5", "100bA", "39bC", "1AbE", "100000b2" };
            int max1 = Ex1.maxIndex(numbers); // "412b5" is the maximum number.
            assertEquals(3 ,max1);

            String[] InvalidNumbers = {"1b", "45b11"};
            int max2 = Ex1.maxIndex(InvalidNumbers);
            assertEquals(-1, max2);
        }

        @Test
        void number2IntTest(){
            //Checking if these numbers converts correctly to decimal.
            String[] numbers = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            String[] toDecimal = {"1", "1", "1", "123", "171", "0"};

            for(int i = 0; i < numbers.length; i++){
                boolean ok = Ex1.number2Int(numbers[i]) == Ex1.number2Int(toDecimal[i]);
                assertTrue(ok);
            }

            String n1 = "100b11";
            String n2 = "ACb G";

            int not_good1 = Ex1.number2Int(n1);
            int not_good2 = Ex1.number2Int(n2);

            assertEquals(not_good1, not_good2);

        }

        @Test
        void digit2IntTest(){
            char[] baseDigit = {'1', '2', '5', '7', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}; // Before converting to Integer value.
            int[] result = {1, 2, 5, 7, 10, 11, 12, 13, 14, 15, 16}; // After converting to Integer value

            for(int i = 0; i < baseDigit.length; i++){
                boolean ok = Ex1.digit2Int(baseDigit[i]) == result[i];
                assertTrue(ok);
            }

        }

        @Test
        void isNumberValidTest(){
            assertTrue(Ex1.isNumberValid("101", 2)); // Base 2 (Binary)
            assertTrue(Ex1.isNumberValid("A3", 16)); // Base 16 (Hex)

            assertFalse(Ex1.isNumberValid("2F", 10)); // Invalid number for base 10
            assertFalse(Ex1.isNumberValid("G1", 16)); // Invalid number for base 16
            assertFalse(Ex1.isNumberValid("123", 3)); // Invalid number for base 3
        }

        @Test
        void baseTest(){
            assertEquals(2, Ex1.base("2")); // Base 2
            assertEquals(16, Ex1.base("G")); // Base 16 = 'G'(Hex)
            assertEquals(10, Ex1.base("A")); // Base 10 = 'A'
            assertEquals(-1, Ex1.base("1b")); // Invalid base
            assertEquals(-1, Ex1.base("H")); // Not in range
        }

        @Test
        void isNumberTest(){
            String[] trueIsNumber = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"}; // Valid numbers
            for (String number : trueIsNumber) {
                assertTrue(Ex1.isNumber(number));
            }

            String[] falseIsNumber = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"}; // Invalid numbers
            for(String number : falseIsNumber){
                assertFalse(Ex1.isNumber(number));
            }
        }

        @Test
        void int2DigitTest(){
            // Convert a number to its digit.
            assertEquals("0", Ex1.int2Digit(0));
            assertEquals("5", Ex1.int2Digit(5));
            assertEquals("A", Ex1.int2Digit(10));
            assertEquals("F", Ex1.int2Digit(15));
        }

        @Test
        void equalsTest(){
            assertTrue(Ex1.equals("1011b2", "11")); //"1011b2" = 11
            assertTrue(Ex1.equals("27b8", "23")); // "27b8" = 23
            assertTrue(Ex1.equals("13bA", "13")); // "13bA" = 13
            assertTrue(Ex1.equals("ABbG", "171")); //"ABbG" = 171


            assertFalse(Ex1.equals("5CbG", "84")); // "5CbG = 92 not 12
            assertFalse(Ex1.equals("1011b2", null)); // "1011b2" = 11 not null
            assertFalse(Ex1.equals("1234", "12")); // 1234 = 1234
            assertFalse(Ex1.equals("189bC", "678")); // "189bC" = 249 not 678
        }

    }
