/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Midterm;

/**
 *
 * @author Palomera
 */
public class PALOMERA_MULTI_DIMENTIONAL {
    public static void main(String[] args) {
        
        int marks [][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        for (int i = 0; i < marks. length; i++) {
            System.out.print("the element in Row " + (i + 1) + ": ");
            for (int j = 0; j< marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }
    }
}
