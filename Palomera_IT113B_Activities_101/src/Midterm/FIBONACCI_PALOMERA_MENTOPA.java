package Midterm;

public class FIBONACCI_PALOMERA_MENTOPA {
    
    
    public static void main(String[] args) {
        int fibonacci = 10;
        for (int a = 0; a < fibonacci; a++) {
            System.out.print(fibonacci(a) + ", ");
        }
    }
    
    public static int fibonacci(int a) {
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        } else {
            return fibonacci(a - 1) + fibonacci(a - 2);
        }
    }
}
