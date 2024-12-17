package ru.netology;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    public SelenideElement card1 = $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    public SelenideElement card2 = $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public int getCardBalance(SelenideElement card) {
        String [] text = card.innerText().split(" ");
        return Integer.parseInt(text[5]);
    }

    public TransferPage selectCardForTransfer(SelenideElement card) {
        card.find("button[data-test-id=action-deposit]").click();
        return new TransferPage();
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