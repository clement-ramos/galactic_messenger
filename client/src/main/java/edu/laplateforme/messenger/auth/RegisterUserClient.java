package edu.laplateforme.messenger.auth;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RegisterUserClient {

    private final String SERVER_PORT;
    private final String SERVER_IP;
    private final RestTemplate restTemplate = new RestTemplate();

    public RegisterUserClient(String serverIp, String serverPort) {
        this.SERVER_IP = serverIp;
        this.SERVER_PORT = serverPort;
    }

    public void registerUser(String username, String password) {
        String apiUrl = "http://" + this.SERVER_IP + ":" + this.SERVER_PORT + "/api/users/register";
        String registerUrl = apiUrl + "?username=" + username + "&password=" + password;
        ResponseEntity<String> responseEntity = restTemplate.exchange(registerUrl, HttpMethod.POST, null, String.class);
        System.out.println(responseEntity.getBody());
    }
}
