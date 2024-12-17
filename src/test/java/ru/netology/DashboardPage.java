package ru.netology;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public int getCardBalance(String cardId) {
        for (SelenideElement card : cards) {
            if (card.text().contains("**** **** ****")) {
                return extractBalance(card.text());
            }
            if (card.text().contains("**** **** ****")) {
                return extractBalance(card.text());
            }
        }
        throw new RuntimeException("Card not found: " + cardId);
    }

    public TransferPage selectCardForTransfer(String cardId) {
        for (SelenideElement card : cards) {
            if (card.text().contains("**** **** ****")) {
                $(By.className("button")).click();
                return new TransferPage();
            }
            if (card.text().contains("**** **** ****")) {
                $(By.className("button")).click();
                return new TransferPage();
            }
        }
        throw new RuntimeException("Card not found for transfer: " + cardId);
    }

    public void refresh() {
    }

    private int extractBalance(String text) {
        int start = text.indexOf(balanceStart);
        int finish = text.indexOf(balanceFinish);
        String value = text.substring(start + balanceStart.length(), finish).trim();
        return Integer.parseInt(value);
    }
}