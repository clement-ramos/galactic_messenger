package edu.laplateforme.messenger.auth;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RegisterUserClient {

    private final String apiUrl = "http://localhost:9092/api/users/register";
    private final RestTemplate restTemplate = new RestTemplate();

    public void registerUser(String username, String password) {
        String registerUrl = apiUrl + "?username=" + username + "&password=" + password;
        ResponseEntity<String> responseEntity = restTemplate.exchange(registerUrl, HttpMethod.POST, null, String.class);
        System.out.println(responseEntity.getBody());
    }
}
