package ru.netology.transfer.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private String balanceStart = "баланс: ";
    private String balanceFinish = " р.";
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public String getCardBalance(String cardNumber) {
        var text = cards.findBy(text(cardNumber.substring(12, 16))).getText();
        return extractBalance(text);
    }

    public TransferPage selectCardToTransfer(String cardNumber) {
        cards.findBy(text(cardNumber.substring(12, 16))).$("button").click();
        return new TransferPage();
    }

    private String extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        return text.substring(start + balanceStart.length(), finish);
    }

    public String getCardBalance(int index) {
        var text = cards.get(index - 1).text();
        return extractBalance(text);
    }

    public TransferPage selectCardToTransfer(int index) {
        cards.get(index - 1).$("button").click();
        return new TransferPage();
    }
}
