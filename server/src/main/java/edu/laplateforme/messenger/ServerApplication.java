package edu.laplateforme.messenger;

import edu.laplateforme.messenger.entity.User;
import edu.laplateforme.messenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
        System.out.println("Server available at http://localhost:9092/api/users");
    }

    @Override
    public void run(String... args) throws Exception {
//        userRepository.deleteAll();
//        userRepository.flush();
//
//        User user1 = new User();
//        user1.setUsername("user1");
//        user1.setPassword("password1");
//        userRepository.save(user1);
//
//        User user2 = new User();
//        user2.setUsername("user2");
//        user2.setPassword("password2");
//        userRepository.save(user2);
    }

}
