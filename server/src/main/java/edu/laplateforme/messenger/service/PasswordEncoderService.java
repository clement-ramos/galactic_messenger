package edu.laplateforme.messenger.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoderService {
    public static String hashPassword(String password) {
        try {
            System.out.println("hashPassword: ");
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder hexStringBuilder = new StringBuilder();

            for (byte b : hashedPassword) {
                String hexValue = String.format("%02x", b);
                hexStringBuilder.append(hexValue);
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
