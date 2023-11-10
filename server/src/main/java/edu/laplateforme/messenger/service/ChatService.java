package edu.laplateforme.messenger.service;

import edu.laplateforme.messenger.entity.Message;
import edu.laplateforme.messenger.repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;

import java.util.List;

@Service
public class ChatService {

    private final MessageRepository messageRepository;

    @Autowired
    public ChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> sendMessage(Message message) {
        // Logique pour enregistrer le message dans la base de données
        messageRepository.save(message);

        // Vous pouvez également ajouter une logique pour envoyer des notifications en temps réel

        // Retourne l'historique mis à jour des messages
        return getChatHistory(message.getSender());
    }

    public List<Message> getChatHistory(String username) {
        // Logique pour récupérer l'historique des messages à partir de la base de données
        return messageRepository.findTop10BySenderOrRecipientOrderByTimestampDesc(username, username);
    }
}
