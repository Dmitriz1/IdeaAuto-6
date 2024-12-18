package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement cardIDInput = $("[data-test-id = 'from'] input");
    private SelenideElement transferButton = $(By.className("button"));

    public TransferPage enterAmount(int amount) {
        amountInput.setValue(String.valueOf(amount));
        return this;
    }

    public TransferPage enterCardId(String cardId) {
        cardIDInput.setValue(cardId);
        return this;
    }

    public DashboardPage submitTransfer() {
        transferButton.click();
        return new DashboardPage();
    }
}