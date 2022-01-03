package ru.netology.transfer.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.transfer.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
        return new VerificationPage();
    }
}
