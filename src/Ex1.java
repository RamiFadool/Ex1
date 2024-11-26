/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
/*******************************************************************************
 * הוספתי כמה פונקציות עזר למחלקה
 * digit2Int, isNumberValid, base, int2Digit
 * */
public class Ex1 {

        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return Decimal integer value of the number, otherwise -1.
         *
         *
         *
         * In order to convert from a specific base to decimal base, we start by multiplying each digit
         * starting from the right side by the positional power(for example: base = 2, digit1 * 2^0 → digit2 * 2^1...)
         * and in the end we add all the values to the total, which will be the decimal value.
         */
        public static int number2Int(String num) {
            int ans = 0; // Changed from -1 to 0
            int power = 1; // We start to multiply the digits with 1, (base^0 = 1)


            if(!isNumber(num)){ return -1;} //Check if the number is valid.
            if (!num.contains("b")) {// If the number format is valid and it doesn't contain b, then it's base 10.
                return Integer.parseInt(num);// Convert to integer and return.
            }

            String[] numberFormat = num.split("b");
            String number = numberFormat[0];
            String numberBase = numberFormat[1];

            int base = base(numberBase); // Convert base from String into integer, if invalid return -1.
            if (base == -1) {
                return -1;
            }

            char[] numberDigits = number.toCharArray();

            //From right to left
            for(int i = numberDigits.length - 1 ; i >= 0; i--){
                char digit = numberDigits[i];
                int intDigit = digit2Int(digit);

                if (intDigit >= base) { // Check if the digit is valid for the base.
                    return -1;
                }

                ans += intDigit * power;
                power *= base;
            }

            return ans;
        }

    /*******************************************************************************
     * This function converts a single char digit (0-9 or A-G) to its Integer value.
     * @param digit a char digit we want to convert.
     * @return Integer value of the digit.
     * */
        public static int digit2Int(char digit){
            if(digit >= '0' && digit <= '9'){
                return (int)(digit - '0'); // Convert digit from '0' - '9' to Integer value.
            }
            return (int)(digit - 'A' + 10); // Convert digit from 'A' - 'G' to Integer value(10-16).
        }

        /***************************************************************************
         * This function checks if a number is valid, based on it's base.
         * it checks every digit if it belongs to the base.
         * for bases 2-10, the digits are numbers between [0 - base-1],
         * for bases 11-16, the digits are [0-9] and 'A' to the letter of the base,
         * for example:
         * base 10 ('A'): digits are 0-9.
         * base 16 ('G'): digits are 0-9 and A-F.
         * @param number the number we want to check, represented as a String.
         * @param base the base we want to check against.
         * @return true if the number is valid to the base.
         * */
        public static boolean isNumberValid(String number, int base){
            char[] numberDigits = number.toCharArray();
            for(char digit : numberDigits){
                int d = digit2Int(digit); // Convert digit to integer.
                if (d < 0 || d >= base) { // Check if the digit is in a valid range for the base.
                    return false;
                }
            }
            return true;
        }

    /***************************************************************
     * This function converts a base value from String to Integer.
     * @param b String that represents the base.
     * @return Integer value of the base, -1 if invalid.
     */
        public static int base(String b){
            int base = 0;
            if (b.length() == 1 && b.charAt(0) >= 'A' && b.charAt(0) <= 'G') {
                base = 10 + (b.charAt(0) - 'A');
            }
            else{// base < 10
                try {
                    base = Integer.parseInt(b); //convert from String to int.
                } catch (NumberFormatException e) {
                    return -1; // Invalid base format.
                }
            }
            if(base < 2 || base > 16){
                return -1; // Invalid base.
            }
            return base;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;

            if (a == null || a.isEmpty()){
                return false;
            }

            //if a is a String of numbers (format = <number> without b), we define the base to 10
            if (!a.contains("b")) {
                return isNumberValid(a, 10);
            }

            //split the string for two pieces, the number and the base.
            String[] numberFormat = a.split("b");
            if (numberFormat.length != 2){return !ans;}
            String number = numberFormat[0];
            String numberBase = numberFormat[1];

            //BASE VALIDATION
            // if the base is 10-16, we change the value from A-G to numbers accordingly.
            //for example:(A = 10),(B = 11)...
            int base = base(numberBase);
            if(base == -1){
                ans = false;
            }

            //NUMBER VALIDATION
            if(!isNumberValid(number, base)){
                ans = false;
            }

            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            if(num < 0 || base < 2 || base > 16){ //If input valid.
                return ans;
            }
            if (num == 0) { //If the number is 0, we return "0" because it's the same in all bases.
                return "0";
            }
            while(num > 0){
                int remainder = num % base; //calculating the שארית
                ans = int2Digit(remainder) + ans; //Convert to the digit representation
                num /= base; // Moving to next digit

            }
            return ans;
        }

        /**********************************************************************************************
         * This function converts an integer remainder (0-15) to its digit representation (0-9,'A'-'F')
         * @param remainder The integer we want to convert
         * @return String representation of the digit.
         * Example: 2 → "2"
         * 10 → "A"
         * 13 → "C"
         * */
        private static String int2Digit(int remainder){
            switch (remainder){
                case 10:
                    return "A";
                case 11:
                    return "B";
                case 12:
                    return "C";
                case 13:
                    return "D";
                case 14:
                    return "E";
                case 15:
                    return "F";
                default: // For numbers 0-9
                    return String.valueOf(remainder);
            }
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            int number1 = number2Int(n1);
            int number2 = number2Int(n2);

            if(number1 == -1 || number2 == -1 || number1 != number2){ //If the numbers are invalid, we should return false.
                ans = false;
            }
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            int max = 0;
            boolean foundValid = false; // To check if the array have only invalid numbers, if yes then return -1.
            for(int i = 0; i  < arr.length; i++){
                int number = number2Int(arr[i]);
                if(number != -1){ // If number is valid
                    if(number > max){ // if there is more than one maximum, return the first index (that's why i used >)
                        max = number;
                        ans = i; //save the index of the maximum number
                        foundValid = true;
                    }
                }
            }
            if(!foundValid){
                return -1;
            }

            return ans;
        }
}
