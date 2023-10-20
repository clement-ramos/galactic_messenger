package edu.laplateforme.messenger;

import edu.laplateforme.messenger.auth.LoginUserClient;
import edu.laplateforme.messenger.auth.RegisterUserClient;
import edu.laplateforme.messenger.manager.ChatManager;
import edu.laplateforme.messenger.manager.LoginRegisterManager;

public class ClientApplication {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar galactic_messenger_client.jar <ip address> <port>");
            System.exit(1);
        } else {
            String serverIp = args[0];
            String serverPort = args[1];

            RegisterUserClient registerUserClient = new RegisterUserClient(serverIp, serverPort);
            LoginUserClient loginUserClient = new LoginUserClient(serverIp, serverPort);

            LoginRegisterManager loginRegisterManager = new LoginRegisterManager(registerUserClient, loginUserClient);
            loginRegisterManager.startInteraction();

            System.out.println("Welcome to Galactic Messenger, " + loginRegisterManager.getLoggedInUser() + "!\n");

            ChatManager chatManager = new ChatManager();
            chatManager.startInteraction();
        }
    }
}

