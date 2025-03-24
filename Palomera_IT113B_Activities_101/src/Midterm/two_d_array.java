/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midterm;

/**
 *
 * @author Palomera
 */
public class two_d_array {
    public static void main(String[] args) {
        
        int number[][] = {
            {1, 3, 4, 5, 6},
            {2, 4, 5, 6, 1},
            {5, 6, 7, 8, 9}
        };
        
        for(int i= 0; i< number.length; i++) {
            for(int j= 0; j< number[i].length; j++) {
                System.out.print(number[i][j] + " ");
            }
            
            System.out.println();
        }


    }
}