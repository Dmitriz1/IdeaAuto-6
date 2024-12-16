package ru.netology;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

class TransferPage {
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private ElementsCollection cards = $$(".list__item div");
    private SelenideElement transferButton = $(By.className("button"));
    private SelenideElement cardID = $("[data-test-id = 'from'] input");

    public void transferAmount(String cardId, int amount) {
        amountInput.setValue(String.valueOf(amount));
        cardID.setValue(cardId);
        transferButton.click();
    }

    private void selectTargetCard(String targetCardNumber) {
        for (SelenideElement card : cards) {
            if (card.text().contains(targetCardNumber)) {
                $(By.className("button")).click();
                break;
            }
        }
    }
}