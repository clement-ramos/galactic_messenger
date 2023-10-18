package edu.laplateforme.messenger;


import edu.laplateforme.messenger.auth.RegisterUserClient;

import java.io.IOException;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) throws IOException {
        RegisterUserClient registerUserClient = new RegisterUserClient();
        Scanner scanner = new Scanner(System.in);

        System.out.println("To register: /register <username> <password>");
        System.out.println("To login: /login <username> <password>\n");

        while (true) {
            String input = scanner.nextLine();

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                String command = parts[0];
                String username = parts[1];
                String password = parts[2];

                if (command.equals("/register")) {
                    registerUserClient.registerUser(username, password);
//                    System.out.println("User registered successfully.\n");
                } else if (command.equals("/login")) {
                    System.out.println("User logged in successfully.\n");
                } else {
                    System.out.println("Commande invalide.\n");
                }
            }
            // End of main
        }
    }
}
