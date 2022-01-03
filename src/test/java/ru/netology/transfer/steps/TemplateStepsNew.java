package ru.netology.transfer.steps;

import io.cucumber.java.Before;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.transfer.data.DataHelper;
import ru.netology.transfer.page.DashboardPage;
import ru.netology.transfer.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TemplateStepsNew {
    private static DashboardPage dashboardPage;

    @Before
    public static void setUp() {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var verificationPage = loginPage.validLogin(DataHelper.getAuthInfo().getLogin(),
                DataHelper.getAuthInfo().getPassword());
        var dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
        var actualBalanceFirstCard = Integer.parseInt(dashboardPage.getCardBalance(DataHelper.getFirstCardInfo().getCardNumber()));
        var actualBalanceSecondCard = Integer.parseInt(dashboardPage.getCardBalance(DataHelper.getSecondCardInfo().getCardNumber()));
        var difference = (actualBalanceFirstCard - actualBalanceSecondCard) / 2;
        if (difference > 0) {
            var transferPage = dashboardPage.selectCardToTransfer(DataHelper.getSecondCardInfo().getCardNumber());
            transferPage.makeTransfer(String.valueOf(difference), DataHelper.getFirstCardInfo().getCardNumber());
        } else {
            var transferPage = dashboardPage.selectCardToTransfer(DataHelper.getFirstCardInfo().getCardNumber());
            transferPage.makeTransfer(String.valueOf(difference), DataHelper.getSecondCardInfo().getCardNumber());
        }
    }

    @Пусть("пользователь залогинен с именем {string} и паролем {string} и страница дашбоарда загрузилась")
    public void loginWithNameAndPassword(String login, String password) {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var verificationPage = loginPage.validLogin(login, password);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }

    @Когда("он переводит {string} рублей с карты с номером {string} на карту с номером {string}")
    public void makeTransfer(String amount, String debitCardNumber, String creditCardNumber) {
        var transferPage = dashboardPage.selectCardToTransfer(creditCardNumber);
        dashboardPage = transferPage.makeTransfer(String.valueOf(amount), debitCardNumber);
    }

    @Тогда("баланс его карты с номером {string} должен стать {string} рублей")
    public void verifyCreditBalance(String creditCardNumber, String expectedCreditBalance) {
        var actualCreditBalance = dashboardPage.getCardBalance(creditCardNumber);
        assertEquals(expectedCreditBalance, actualCreditBalance);
    }

    @И("карты с номером {string} - {string} рублей")
    public void verifyDebitBalance(String debitCardNumber, String expectedDebitBalance) {
        var actualDebitBalance = dashboardPage.getCardBalance(debitCardNumber);
        assertEquals(expectedDebitBalance, actualDebitBalance);
    }
}

