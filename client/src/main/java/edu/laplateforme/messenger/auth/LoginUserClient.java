package edu.laplateforme.messenger.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LoginUserClient {
    private final String SERVER_PORT;
    private final String SERVER_IP;
    private final RestTemplate restTemplate = new RestTemplate();

    public LoginUserClient(String serverIp, String serverPort) {
        this.SERVER_IP = serverIp;
        this.SERVER_PORT = serverPort;
    }

    public boolean loginUser(String username, String password) {
        String apiUrl = "http://" + this.SERVER_IP + ":" + this.SERVER_PORT + "/api/users/login";
        String loginUrl = apiUrl + "?username=" + username + "&password=" + password;
        ResponseEntity<String> responseEntity = restTemplate.exchange(loginUrl, HttpMethod.POST, null, String.class);

        if ("User logged in successfully.\n".equals(responseEntity.getBody())) {
            System.out.println(responseEntity.getBody());
            return true;
        } else {
            System.out.println(responseEntity.getBody());
            return false;
        }
    }
}
