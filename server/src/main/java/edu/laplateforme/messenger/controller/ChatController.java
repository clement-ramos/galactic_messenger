package edu.laplateforme.messenger.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import edu.laplateforme.messenger.entity.Message;
import edu.laplateforme.messenger.service.ChatService;

import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat/send")
    @SendTo("/topic/messages")
    public List<Message> sendMessage(Message message) {
        // Logique pour envoyer le message au destinataire
        return chatService.sendMessage(message);
    }

    @MessageMapping("/chat/history")
    public List<Message> getChatHistory(String username) {
        // Logique pour récupérer l'historique des messages pour un utilisateur
        return chatService.getChatHistory(username);
    }
}
