package edu.laplateforme.messenger;

import edu.laplateforme.messenger.entity.User;
import edu.laplateforme.messenger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {


        if (args.length > 0) {
            int port = Integer.parseInt(args[0]);
            System.setProperty("server.port", String.valueOf(port));
        }

        SpringApplication.run(ServerApplication.class, args);
        System.out.println("Galactic Messenger Server started on port " + System.getProperty("server.port"));


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
