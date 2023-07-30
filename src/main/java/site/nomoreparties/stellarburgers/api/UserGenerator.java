package site.nomoreparties.stellarburgers.api;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {

    public static String generateRandomEmail(int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        return RandomStringUtils.random(length, allowedChars) + "@example.com";
    }

    public static User random() {
        String randomEmail = generateRandomEmail(10);
        return new User(randomEmail, RandomStringUtils.randomAlphanumeric(6, 10), "Tyler Durden");
    }
}