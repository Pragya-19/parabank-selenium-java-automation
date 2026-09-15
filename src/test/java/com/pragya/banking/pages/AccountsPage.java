package com.pragya.banking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage {

    private WebDriver driver;

    private By accountsOverviewHeading =
            By.xpath("//h1[contains(text(),'Accounts Overview')]");

    private By transferFundsLink =
            By.linkText("Transfer Funds");

    private By billPayLink =
            By.linkText("Bill Pay");

    private By findTransactionsLink =
            By.linkText("Find Transactions");

    private By logoutLink =
            By.linkText("Log Out");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountsOverviewDisplayed() {
        return driver.findElement(accountsOverviewHeading).isDisplayed();
    }

    public void clickTransferFunds() {
        driver.findElement(transferFundsLink).click();
    }

    public void clickBillPay() {
        driver.findElement(billPayLink).click();
    }

    public void clickFindTransactions() {
        driver.findElement(findTransactionsLink).click();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }
}