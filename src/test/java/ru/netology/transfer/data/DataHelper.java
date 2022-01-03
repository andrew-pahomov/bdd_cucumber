package ru.netology.transfer.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("5559000000000001");
    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("5559000000000002");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardInfo {
        String cardNumber;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

}