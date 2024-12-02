import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        int base = 0;
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.nextLine();

            if (!num1.equals("quit")) {
                System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));
                if(!Ex1.isNumber(num1)){
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                    continue;
                }
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.nextLine();

                if(!num2.equals("quit")){
                    System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));
                    if(!Ex1.isNumber(num2)){
                        System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        continue;
                    }
                    System.out.println("Enter a base for output: (a number [2,16])");
                    base = sc.nextInt();
                    sc.nextLine(); //After using nextInt(), the next readLine() reads the \n of the enter press.

                    int decimalNumber1 = Ex1.number2Int(num1);
                    int decimalNumber2 = Ex1.number2Int(num2);

                    int sum = decimalNumber1 + decimalNumber2;
                    int multiply = decimalNumber1 * decimalNumber2;

                    int max = Math.max(decimalNumber1, Math.max(decimalNumber2, Math.max(sum, multiply)));

                    String sumS = Ex1.int2Number(sum,base);
                    String multiplyS = Ex1.int2Number(multiply, base);

                    System.out.println(num1 + " + " + num2 + " = " + sumS);
                    System.out.println(num1 + " * " + num2 + " = " + multiplyS);
                    System.out.print("Max number over ["+ num1 + ", " +  num2 + ", " + sumS + ", " + multiplyS + "] is: ");
                    if(max == sum){
                        System.out.println(sumS);
                    } else if(max == multiply){
                        System.out.println(multiplyS);
                    }
                    else if(max == decimalNumber2){
                        System.out.println(num2);
                    }
                    else{
                        System.out.println(num1);
                    }
                }
            }
        }
        System.out.println("quiting now...");
    }
}
