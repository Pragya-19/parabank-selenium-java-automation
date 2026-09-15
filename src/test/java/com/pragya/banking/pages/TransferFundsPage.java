package com.pragya.banking.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By amountField = By.id("amount");
    private By fromAccount = By.id("fromAccountId");
    private By toAccount = By.id("toAccountId");

    private By transferButton =
            By.cssSelector("input[value='Transfer']");

    private By successMessage =
            By.xpath("//h1[contains(text(),'Transfer Complete')]");

    public TransferFundsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterAmount(String amount) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(amountField)
        ).sendKeys(amount);
    }

    public void selectFromAccount(int index) {

        wait.until(driver ->
                new Select(driver.findElement(fromAccount))
                        .getOptions().size() > index
        );

        Select select =
                new Select(driver.findElement(fromAccount));

        select.selectByIndex(index);
    }

    public void selectToAccount(int index) {

        wait.until(driver ->
                new Select(driver.findElement(toAccount))
                        .getOptions().size() > index
        );

        Select select =
                new Select(driver.findElement(toAccount));

        select.selectByIndex(index);
    }

    public void clickTransfer() {

        wait.until(
                ExpectedConditions.elementToBeClickable(transferButton)
        ).click();
    }

    public boolean isTransferSuccessful() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).isDisplayed();
    }

    public void transferMoney(
            String amount,
            int fromIndex,
            int toIndex) {

        enterAmount(amount);
        selectFromAccount(fromIndex);
        selectToAccount(toIndex);
        clickTransfer();
    }
}