package com.arthuramorim.apispring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    //create new password using BCrypt
    public static String generateBCrypt(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Voce deve preencher o campo de senha");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    //check password using bcrypt
    public static boolean passValid(String password, String passHash) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, passHash);
    }


}
