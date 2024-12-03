# Ex1: Number Converter and Calculator

This project is my implementaion of this assignment.

In this assignment, we will design a number formatting converter and calculator. In general, we will use Strings as numbers over the base of binary till Hexa (2-16), 10-16 are represented by A,B,..G. The general representation of the numbers is as a String with the following format: <number><b><base> e.g., “135bA” (i.e., “135”), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
The following are NOT in the format:
“b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, “”, null.

## Implementation Details

---

### How to convert numbers between bases?
- In order to convert numbers between bases we do a step-by-step conversion process:
   1. Converts the input number to base 10 (decimal) first.
   2. Converts the base 10 (decimal) number into the desired base.
   - Example: `"1011b2"` is first converted to `11` in decimal, and then it can be converted to another base like `16`.

## Classes to implement

---

### 1. Ex1:
- Required functions:

   - `number2Int(String num)`: Convert the given number (num) to a decimal representation (as int).
   - `isNumber(String a)`: This static function checks if the given String (g) is in a valid "number" format.
   - `int2Number(int num, int base)`: Calculate the number representation (in basis base) of the given natural number (represented as an integer).
   - `equals(String n1, String n2)`: Checks if the two numbers have the same value.
   - `maxIndex(String[] arr)`: This static function search for the array index with the largest number (in value).

- Help Methods:
   - `digit2Int(char c)`: Converts a single character (digit or letter like `A` for base 16) into its integer value.
   - `int2Digit(int n)`: Converts an integer back into a character for representation in other bases.
   -  `isNumberValid(String number, int base)`: Checks if a number is valid, based on it's base, converts each character to its integer value.
   - `base(String b)`: This function converts a base value from String to Integer.

### 2. Ex1Test:
This class tests each function using JUnit.

### 3. Ex1Main:
The entry point for running the program.             
The main takes user input for numbers and processes them using the functions from the Ex1.


