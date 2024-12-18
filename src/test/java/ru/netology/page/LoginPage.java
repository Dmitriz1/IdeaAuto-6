package ru.netology.page;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement usernameField = $("[data-test-id='login'] input");
    private SelenideElement passwordField = $("[data-test-id='password'] input");
    private SelenideElement loginButton = $(By.className("button"));

    public LoginPage enterUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public VerificationPage submitLogin() {
        loginButton.click();
        return new VerificationPage();
    }
}