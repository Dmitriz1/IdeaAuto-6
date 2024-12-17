package ru.netology;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class TransferPage {
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement transferButton = $(By.className("button"));
    private SelenideElement cardID = $("[data-test-id = 'from'] input");

    public void transferAmount(String cardId, int amount) {
        amountInput.setValue(String.valueOf(amount));
        cardID.setValue(cardId);
        transferButton.click();
    }
}