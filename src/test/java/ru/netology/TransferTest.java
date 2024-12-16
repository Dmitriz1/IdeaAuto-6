package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {
    private void login(String username, String password, String code) {
        $(By.cssSelector("[data-test-id='login'] input")).setValue(username);
        $(By.cssSelector("[data-test-id='password'] input")).setValue(password);
        $(By.className("button")).click();
        $(By.cssSelector("[data-test-id='code'] input")).setValue(code);
        $(By.className("button")).click();
    }

    @Test
    public void testTransferBetweenCards() {
        open("http://localhost:9999");
        login("vasya", "qwerty123", "12345");

        DashboardPage dashboardPage = new DashboardPage();
        int initialBalanceFirstCard = dashboardPage.getCardBalance("5559 0000 0000 0001");
        int initialBalanceSecondCard = dashboardPage.getCardBalance("5559 0000 0000 0002");

        TransferPage transferPage = dashboardPage.selectCardForTransfer("5559 0000 0000 0001");
        transferPage.transferAmount("5559 0000 0000 0002", 5000);
        dashboardPage.refresh();

        int finalBalanceFirstCard = dashboardPage.getCardBalance("5559 0000 0000 0001");
        int finalBalanceSecondCard = dashboardPage.getCardBalance("5559 0000 0000 0002");

        assertEquals(initialBalanceFirstCard + 5000, finalBalanceFirstCard);
        assertEquals(initialBalanceSecondCard - 5000, finalBalanceSecondCard);
    }
}