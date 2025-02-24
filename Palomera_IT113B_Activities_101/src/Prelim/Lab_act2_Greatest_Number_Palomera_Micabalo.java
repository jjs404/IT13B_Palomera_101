package Prelim;

import java.util.Scanner;

public class Lab_act2_Greatest_Number_Palomera_Micabalo {
    public static void main(String[] args) {
        
        int a, b, c, d ;

        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter First number: ");
        a = in.nextInt();
        System.out.println("Enter Second number: ");
        b = in.nextInt();
        System.out.println("Enter Third number: ");
        c = in.nextInt();

            if (b > a && b > c) {
                d = b;
                
            } else if (c > b && c > a) {
                d = c;
                
            }else { d = a;
            
            }
            System.out.println("The Greatest is : " + d);
    }
}