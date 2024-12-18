package ru.netology.page;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $(By.className("button"));

    public VerificationPage enterVerificationCode(String code) {
        codeField.setValue(code);
        return this;
    }

    public DashboardPage submitVerification() {
        verifyButton.click();
        return new DashboardPage();
    }
}