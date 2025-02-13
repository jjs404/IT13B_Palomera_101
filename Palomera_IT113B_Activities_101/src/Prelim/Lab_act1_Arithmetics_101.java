package Prelim;

import java.util.Scanner;

public class Lab_act1_Arithmetics_101 {
    public static void main(String [] args) {
        
        int x;
        int y;
        int z;
        
        Scanner in= new Scanner(System.in);
        
        System.out.println("Enter 1st Number: ");
        x = in.nextInt ();
        System.out.println("Enter 2st Number: ");
        y = in.nextInt ();
        System.out.println("Enter 3st Number: ");
        z = in.nextInt ();
        
        System.out.println(x + " * " + y + " + " + z + " = " + (x * y + z));
        System.out.println("(" + x + " - " + y + " ) " + " % " + z + " = " + ((x - y) % z));
        System.out.println("(" + x + " + " + y + " + " + z + ")" + " /" + " 3 " + " = " + ((x + y + z) / 3 ));
        System.out.println(x + " * " + z + " - " + "(" + y + " * " + y + ")" + " = " + (x * z - (y * y)));
        
    }

}