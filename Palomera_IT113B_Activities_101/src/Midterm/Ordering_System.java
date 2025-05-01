package Midterm;

import java.io.*;
import java.util.*;

public class Ordering_System {
    static Scanner scanner = new Scanner(System.in);

    // Menu items and prices
    static String[] items = {"Pizza", "Burger", "Fries"};
    static double[] prices = {150.0, 100.0, 60.0};
    static int[] quantities = new int[items.length];

   
    static final String FILE_PATH = "C:\\Users\\Palomera\\OneDrive\\Desktop\\accounts.txt.txt";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Welcome to the Group 2 Ordering System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> createAccount();
                case 2 -> {
                    if (login()) {
                        orderMenu();
                    }
                }
                case 3 -> {
                    System.out.println("Thank you for visiting!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }


    public static String encrypt(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char)(c + 3));
        }
        return encrypted.toString();
    }


    public static String decrypt(String encryptedPassword) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedPassword.toCharArray()) {
            decrypted.append((char)(c - 3));
        }
        return decrypted.toString();
    }

    // Create a new user account
    public static void createAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String encryptedPassword = encrypt(password);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Palomera\\OneDrive\\Desktop\\accounts.txt.txt", true))) {
            writer.write(username + "," + encryptedPassword);
            writer.newLine();
            System.out.println("Account created successfully! (Saved to Desktop)");
        } catch (IOException e) {
            System.out.println("Error saving user data.");
        }
    }

    // User login
    public static boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Palomera\\OneDrive\\Desktop\\accounts.txt.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    String decryptedPassword = decrypt(parts[1]);
                    if (decryptedPassword.equals(inputPassword)) {
                        System.out.println("Login successful! Welcome, " + username + "!");
                        return true;
                    } else {
                        System.out.println("Incorrect password.");
                        return false;
                    }
                }
            }
            System.out.println("Username not found.");
        } catch (IOException e) {
            System.out.println("Error reading user data.");
        }
        return false;
    }

    // Ordering menu
    public static void orderMenu() {
        int choice; 
        do {
            System.out.println("\n--- Restaurant Menu ---");
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %s - %.2f%n", i + 1, items[i], prices[i]);
            }
            System.out.println("4. Exit & Show Bill");
            System.out.print("Choose an item: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= items.length) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                quantities[choice - 1] += quantity;
                System.out.println(quantity + " " + items[choice - 1] + "(s) added to order.");
            } else if (choice != 4) {
                System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        showOrderSummary();
    }

    // Display final order summary and total bill
    public static void showOrderSummary() {
        double total = 0;
        System.out.println("\n--- Order Summary ---");
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                double itemTotal = quantities[i] * prices[i];
                System.out.printf("%s x %d = %.2f%n", items[i], quantities[i], itemTotal);
                total += itemTotal;
            }
        }
        System.out.printf("Total Bill: %.2f%n", total);
        System.out.println("Thank you for your order!");
        Arrays.fill(quantities, 0);
    }
}
