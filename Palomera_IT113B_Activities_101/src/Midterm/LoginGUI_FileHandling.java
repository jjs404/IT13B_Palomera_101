package Midterm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI_FileHandling {
        public static void main(String[] args) {
        JFrame jFrame = new JFrame("Login");

        JTextField jTextFieldUsername = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();
        JLabel labelUsername = new JLabel("Username:");
        JLabel labelPassword = new JLabel("Password:");
        JButton buttonLogin = new JButton("Login");

        buttonLogin.setForeground(Color.blue);

        jFrame.setLayout(new GridLayout(3, 2));
        jFrame.getContentPane().add(labelUsername);
        jFrame.getContentPane().add(jTextFieldUsername);
        jFrame.getContentPane().add(labelPassword);
        jFrame.getContentPane().add(jPasswordField);
        jFrame.getContentPane().add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = jTextFieldUsername.getText();
                String enteredPassword = new String(jPasswordField.getPassword());

                int key = 3;
                String encryptedenteredPassword = encrypt(enteredPassword, key);

                boolean correct = authenticateUser(enteredUsername, encryptedenteredPassword);

                if (correct) {
                    JOptionPane.showMessageDialog(jFrame, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(jFrame, "Invalid username or password.");
                }
            }
        });

        jFrame.setBounds(600, 300, 400, 250);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(3);
    }

    public static String encrypt(String password, int key) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return new String(chars);
    }

    public static boolean authenticateUser(String username, String encryptedPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Documents\\NetBeansProjects\\Balendez.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String storedUsername = parts[0].trim();
                    String storedEncryptedPassword = parts[1].trim();

                    if (username.equals(storedUsername) && encryptedPassword.equals(storedEncryptedPassword)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ An error occurred while reading the file.");
        }
        return false;
    }
    
}
