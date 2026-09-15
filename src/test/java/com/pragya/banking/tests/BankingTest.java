package com.pragya.banking.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.pragya.banking.base.BaseTest;
import com.pragya.banking.pages.AccountsPage;
import com.pragya.banking.pages.LoginPage;
import com.pragya.banking.pages.TransferFundsPage;
import com.pragya.banking.utils.ConfigReader;
import org.testng.annotations.DataProvider;

public class BankingTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
        	    ConfigReader.getProperty("username"),
        	    ConfigReader.getProperty("password")
        	);

        AccountsPage accountsPage = new AccountsPage(driver);

        Assert.assertTrue(
                accountsPage.isAccountsOverviewDisplayed(),
                "Accounts Overview page was not displayed"
        );
    }
    
    @Test(enabled = false)
    public void verifyFundTransfer() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("john", "demo");

        AccountsPage accountsPage =
                new AccountsPage(driver);

        Assert.assertTrue(
                accountsPage.isAccountsOverviewDisplayed(),
                "Login failed - Accounts Overview not displayed"
        );

        accountsPage.clickTransferFunds();

        TransferFundsPage transferPage =
                new TransferFundsPage(driver);

        transferPage.transferMoney("10", 0, 1);

        Assert.assertTrue(
                transferPage.isTransferSuccessful(),
                "Fund transfer was not successful"
        );
    }
    
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
            {"invalidUser", "invalidPassword"},
            {"john", "wrongPassword"},
            {"wrongUser", "demo"}
        };
    }
    
    @Test(dataProvider = "invalidLoginData")
    public void verifyInvalidLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        Assert.assertTrue(
            loginPage.isLoginErrorDisplayed(),
            "Login error message was not displayed"
        );
    }
    
}