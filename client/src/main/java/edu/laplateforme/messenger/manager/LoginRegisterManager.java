package edu.laplateforme.messenger.manager;

import edu.laplateforme.messenger.auth.LoginUserClient;
import edu.laplateforme.messenger.auth.RegisterUserClient;
import lombok.Getter;
import java.util.Scanner;

@Getter
public class LoginRegisterManager {

    private String loggedInUser = null;
    private final String text = """
            To register: /register <username> <password>
            To login: /login <username> <password>
            To get help: /help
            
            """;
    private final RegisterUserClient registerUserClient;
    private final LoginUserClient loginUserClient;

    public LoginRegisterManager(RegisterUserClient registerUserClient, LoginUserClient loginUserClient) {
        this.registerUserClient = registerUserClient;
        this.loginUserClient = loginUserClient;
    }

    public void startInteraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.text);
        do {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            if (parts.length == 3) {
                String username = parts[1];
                String password = parts[2];

                if (!"/register".equals(command) && !"/login".equals(command)) {
                    System.out.println("Invalid command.\n");
                } else if (command.equals("/register")) {
                    registerUserClient.registerUser(username, password);
                    this.loggedInUser = username;
                } else if (command.equals("/login") && this.loginUserClient.loginUser(username, password)) {
                    this.loggedInUser = username;
                }

            } else if (command.equals("/help")) {
                System.out.println(this.text);
            } else {
                System.out.println(this.text);
            }
        } while (this.loggedInUser == null);
    }
}
