package ru.netology.transfer.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.transfer.data.DataHelper;
import ru.netology.transfer.page.DashboardPage;
import ru.netology.transfer.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TemplateStepsOld {
    private static DashboardPage dashboardPage;

    @Пусть("Пусть пользователь залогинен с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var verificationPage = loginPage.validLogin(login, password);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }

    @Когда("Когда он переводит {string} рублей с карты с номером {string} на свою {string} карту с главной страницы")
    public void makeTransfer(String amount, String debitCardNumber, String creditCardNumber) {
        var transferPage = dashboardPage.selectCardToTransfer(Integer.parseInt(creditCardNumber));
        dashboardPage = transferPage.makeTransfer(String.valueOf(amount), debitCardNumber);
    }

    @Тогда("Тогда баланс его {string} карты из списка на главной странице должен стать {string} рублей")
    public void verifyCreditBalance(String creditCardNumber, String expectedCreditBalance) {
        var actualCreditBalance = dashboardPage.getCardBalance(Integer.parseInt(creditCardNumber));
        assertEquals(expectedCreditBalance, actualCreditBalance);
    }
}
