package com.pragya.banking.listeners;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.pragya.banking.base.BaseTest;
import com.pragya.banking.utils.ScreenshotUtil;

import org.openqa.selenium.WebDriver;

public class ExtentReportListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {

            BaseTest baseTest =
                    (BaseTest) result.getInstance();

            WebDriver driver =
                    baseTest.driver();

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName()
                    );

            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            test.warning(
                    "Screenshot could not be captured: "
                    + e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}