package Midterm;

import java.util.Scanner;

public class PALOMERA_SIMPLE_CALCULATOR {
        public static float add(float x, float y){
        return x + y;
    }
    public static float subtract(float x, float y){
        return x - y;
    }
    public static float multiply(float x, float y){
        return x * y;
    }
    public static float divide(float x, float y){
    if(y == 0){
    System.out.println("Error! Any number divided by zero is undefined.");
           return 0; 
}
    return x / y;
    }  
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        float x = in.nextFloat();
        
        System.out.println("Choose an operation: ");
        System.out.println("Add = +");
        System.out.println("Subtract = -");
        System.out.println("Multiply = *");
        System.out.println("Divide = /");
        
        System.out.print("Enter your choice: ");
        char operator = in.next().charAt(0);
        
        System.out.print("Enter second number: ");
        float y = in.nextFloat();

        float result = 0;

        switch (operator) {
            case '+':
                result = add(x, y);
                System.out.println("Result = " + result);
                break;
            case '-':
                result = subtract(x, y);
                System.out.println("Result = " + result);
                break;
            case '*':
                result = multiply(x, y);
                System.out.println("Result = " + result);
                break;
            case '/':
                result = divide(x, y);
                if (y != 0) {
                    System.out.println("Result = " + result);
                }
                break;
            default:
                System.out.println("Invalid choice! Please enter a valid operation.");
        }
    
        in.close();
    }
}
