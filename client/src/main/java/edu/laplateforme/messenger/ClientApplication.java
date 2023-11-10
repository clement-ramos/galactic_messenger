package edu.laplateforme.messenger;

import edu.laplateforme.messenger.services.LoginUserClient;
import edu.laplateforme.messenger.services.RegisterUserClient;
import edu.laplateforme.messenger.controller.AuthController;
import java.io.IOException;

public class ClientApplication {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java -jar galactic_messenger_client.jar <ip address> <port>");
            System.exit(1);
        } else {
            String serverIp = args[0];
            String serverPort = args[1];

            RegisterUserClient registerUserClient = new RegisterUserClient(serverIp, serverPort);
            LoginUserClient loginUserClient = new LoginUserClient(serverIp, serverPort);

            AuthController loginRegisterManager = new AuthController(registerUserClient, loginUserClient);
            loginRegisterManager.authHandler();

            System.out.println(loginRegisterManager.getLoggedInUser());
        }
    }

}

