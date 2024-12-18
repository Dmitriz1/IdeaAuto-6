package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferPage;
import ru.netology.page.VerificationPage;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {
    @Test
    public void testTransferBetweenCards() {
        LoginPage loginPage = new LoginPage();
        open("http://localhost:9999");
        loginPage.enterUsername(DataHelper.getValidUsername())
                .enterPassword(DataHelper.getValidPassword());

        VerificationPage verificationPage = loginPage.submitLogin();
        verificationPage.enterVerificationCode(DataHelper.getValidVerificationCode());

        DashboardPage dashboardPage = verificationPage.submitVerification();

        int initialBalanceFirstCard = dashboardPage.getCardBalance(dashboardPage.card1);
        int initialBalanceSecondCard = dashboardPage.getCardBalance(dashboardPage.card2);

        TransferPage transferPage = dashboardPage.selectCardForTransfer(dashboardPage.card1);
        transferPage.enterAmount(DataHelper.getTransferAmount())
                .enterCardId(DataHelper.getCardNumber());

        dashboardPage = transferPage.submitTransfer();

        dashboardPage.refresh();

        int finalBalanceFirstCard = dashboardPage.getCardBalance(dashboardPage.card1);
        int finalBalanceSecondCard = dashboardPage.getCardBalance(dashboardPage.card2);

        assertEquals(initialBalanceFirstCard + DataHelper.getTransferAmount(), finalBalanceFirstCard);
        assertEquals(initialBalanceSecondCard - DataHelper.getTransferAmount(), finalBalanceSecondCard);
    }
}