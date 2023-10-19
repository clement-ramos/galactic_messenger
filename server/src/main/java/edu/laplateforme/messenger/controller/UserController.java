package edu.laplateforme.messenger.controller;

import edu.laplateforme.messenger.entity.User;
import edu.laplateforme.messenger.repository.UserRepository;
import edu.laplateforme.messenger.service.PasswordEncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        if (userRepository.existsByUsername(username)) {
            return "User with this username already exists.\n";
        }
        User user = new User(username, password);
        userRepository.save(user);
        return "User registered successfully.\n";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        if (userRepository.existsByUsername(username) &&
                userRepository.findByUsername(username).getPassword().equals(PasswordEncoderService.hashPassword(password))) {
            return "User logged in successfully.\n";
        } else {
            return "Invalid username or password.\n";
        }
    }
}
