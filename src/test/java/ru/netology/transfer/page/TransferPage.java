package ru.netology.transfer.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.transfer.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TransferPage {
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement transferHead = $(byText("Пополнение карты"));

    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public DashboardPage makeTransfer(String amountToTransfer, String cardNumber) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(cardNumber);
        transferButton.click();
        return new DashboardPage();
    }
}
