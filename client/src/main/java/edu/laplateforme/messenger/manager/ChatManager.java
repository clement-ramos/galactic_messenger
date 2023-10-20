package edu.laplateforme.messenger.manager;

import java.util.Scanner;

public class ChatManager {

    private String command;

    public void startInteraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                /private_chat <guest_username>
                /accept <username_of_person_inviting>
                /decline <username_of_person_inviting>
                /exit_private_chat
                                
                """);

        do {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            this.command = parts[0];

            if (parts.length == 2) {
                String username = parts[1];

                if (!"/private_chat".equals(this.command) && !"/accept".equals(this.command) && !"/decline".equals(this.command)) {
                    System.out.println("Invalid command.\n");
                } else if (this.command.equals("/private_chat")) {
                    // TODO: Implement private chat
                    System.out.println("You are now in a private chat with " + username + "!\n");
                } else if (this.command.equals("/accept")) {
                    // TODO: Implement accepting private chat invitation
                    System.out.println("You accepted the private chat invitation from " + username + "!\n");
                } else if (this.command.equals("/decline")) {
                    // TODO: Implement declining private chat invitation
                    System.out.println("You declined the private chat invitation from " + username + "!\n");
                }

            } else if (this.command.equals("/exit_private_chat")) {
                System.out.println("You exited the private chat!\n");
            } else {
                System.out.println("Invalid command.\n");
            }
        } while (!this.command.equals("/exit_private_chat"));
    }
}
