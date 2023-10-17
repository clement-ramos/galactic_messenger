package edu.laplateforme.messenger.repository;

import edu.laplateforme.messenger.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
