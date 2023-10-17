package edu.laplateforme.messenger.repository;

import edu.laplateforme.messenger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
