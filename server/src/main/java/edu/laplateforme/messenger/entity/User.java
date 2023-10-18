package edu.laplateforme.messenger.entity;

import edu.laplateforme.messenger.service.PasswordEncoderService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = PasswordEncoderService.hashPassword(password);
    }
}
