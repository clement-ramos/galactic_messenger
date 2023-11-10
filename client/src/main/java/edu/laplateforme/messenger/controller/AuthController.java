package edu.laplateforme.messenger.controller;

import edu.laplateforme.messenger.services.LoginUserClient;
import edu.laplateforme.messenger.services.RegisterUserClient;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class AuthController {

    private static final String REGISTER_COMMAND = "/register";
    private static final String LOGIN_COMMAND = "/login";
    private static final String HELP_COMMAND = "/help";

    private String loggedInUser = null;
    private final RegisterUserClient registerUserClient;
    private final LoginUserClient loginUserClient;

    public AuthController(RegisterUserClient registerUserClient, LoginUserClient loginUserClient) {
        this.registerUserClient = registerUserClient;
        this.loginUserClient = loginUserClient;
    }

    /**
     * Handles user authentication.
     */
    public void authHandler() {
        Scanner scanner = new Scanner(System.in);

        displayHelp();

        while (this.loggedInUser == null) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            if (parts.length == 3) {
                String username = parts[1];
                String password = parts[2];

                if (command.equals(REGISTER_COMMAND)) {
                    registerUser(username, password);
                } else if (command.equals(LOGIN_COMMAND)) {
                    loginUser(username, password);
                } else {
                    System.out.println("Invalid command.\n");
                }
            } else if (command.equals(HELP_COMMAND)) {
                displayHelp();
            } else {
                System.out.println("Invalid command.\n");
            }
        }

        // Clean up resources
        scanner.close();
    }

    private void registerUser(String username, String password) {
        registerUserClient.registerUser(username, password);
        this.loggedInUser = username;
    }

    private void loginUser(String username, String password) {
        if (loginUserClient.loginUser(username, password)) {
            this.loggedInUser = username;
        }
    }

    private void displayHelp() {
        System.out.println("""
                To register: /register <username> <password>
                To login: /login <username> <password>
                To get help: /help
                """);
    }
}
