package edu.laplateforme.messenger;


import edu.laplateforme.messenger.auth.LoginUserClient;
import edu.laplateforme.messenger.auth.RegisterUserClient;

import java.io.IOException;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) throws IOException {
        RegisterUserClient registerUserClient = new RegisterUserClient();
        LoginUserClient loginUserClient = new LoginUserClient();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                To register: /register <username> <password>
                To login: /login <username> <password>
                To get help: /help
                                            
                """);

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            if (parts.length == 3) {
                String username = parts[1];
                String password = parts[2];

                if (command.equals("/register")) {
                    registerUserClient.registerUser(username, password);
//                    System.out.println("User registered successfully.\n");
                } else if (command.equals("/login")) {
                    loginUserClient.loginUser(username, password);
//                    System.out.println("User logged in successfully.\n");
                } else {
                    System.out.println("Invalid command.\n");
                }

            } else if (command.equals("/help")) {
                System.out.println("""
                        To register: /register <username> <password>
                        To login: /login <username> <password>
                        To get help: /help
                                                    
                        """);
            } else {
                System.out.println("Invalid command.\n");
            }
        }
        // End of main
    }
}

