# ParaBank Selenium Java Automation Framework

[![ParaBank Selenium Automation Tests](https://github.com/Pragya-19/parabank-selenium-java-automation/actions/workflows/test.yml/badge.svg)](https://github.com/Pragya-19/parabank-selenium-java-automation/actions/workflows/test.yml)

A hybrid **UI + API test automation framework** built for the ParaBank banking application using **Java, Selenium WebDriver, TestNG, Maven, Page Object Model (POM), REST Assured, and GitHub Actions**.

The project demonstrates practical automation framework design, reusable page objects, API validation, configuration management, automated test execution, reporting support, and CI integration.

---

## Tech Stack

| Area | Technology |
|---|---|
| Programming Language | Java |
| UI Automation | Selenium WebDriver |
| Test Framework | TestNG |
| API Automation | REST Assured |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Configuration | Properties file |
| Reporting | Extent Report Listener |
| Version Control | Git & GitHub |
| CI | GitHub Actions |
| CI Browser Execution | Chrome Headless |

---

## Framework Architecture

The framework separates test logic from page interactions and reusable configuration.

```text
parabank-selenium-java-automation
│
├── .github/
│   └── workflows/
│       └── test.yml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.pragya.banking.utils/
│   │   │       └── ConfigReader.java
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       └── java/
│           └── com.pragya.banking/
│               ├── api/
│               │   └── BankingApiTest.java
│               ├── base/
│               │   └── BaseTest.java
│               ├── listeners/
│               │   └── ExtentReportListener.java
│               ├── pages/
│               │   ├── AccountsPage.java
│               │   ├── LoginPage.java
│               │   └── TransferFundsPage.java
│               ├── tests/
│               │   └── BankingTest.java
│               └── utils/
│                   └── ScreenshotUtil.java
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## Key Features

- Selenium WebDriver based UI automation
- Page Object Model for separation of page locators/actions from test logic
- TestNG for test execution, assertions, and suite management
- REST Assured based banking API tests
- Positive and negative API validation
- Maven dependency management and test execution
- Centralized configuration using `config.properties`
- Reusable WebDriver setup and teardown through `BaseTest`
- Screenshot utility for test/debugging support
- TestNG listener integration for reporting
- GitHub Actions based continuous integration
- Headless Chrome execution in the CI environment

---

## UI Automation

The UI layer follows the **Page Object Model (POM)**.

Page classes contain page-specific locators and reusable actions, while the test classes contain test scenarios and assertions.

Examples include:

- Login-related interactions
- Account page interactions
- Fund transfer workflow
- Banking UI validations

This separation improves **maintainability, readability, and code reuse**.

---

## API Automation

REST Assured is integrated into the same TestNG/Maven framework.

API tests include validation of:

- HTTP status codes
- API responses
- Positive scenarios
- Negative scenarios
- Banking service endpoints

This allows both **UI and API tests to be executed from the same automation suite**.

---

## Test Execution

### Prerequisites

Install:

- Java 11 or above
- Maven
- Google Chrome
- Git

### Run the complete test suite

```bash
mvn clean test
```

The TestNG suite is configured through:

```text
testng.xml
```

---

## Continuous Integration

The project uses **GitHub Actions** for automated test execution.

Workflow:

```text
Code Push
    ↓
GitHub Actions Triggered
    ↓
Checkout Repository
    ↓
Set Up Java
    ↓
Maven Test Execution
    ↓
Selenium Tests in Headless Chrome
    ↓
UI + API Test Validation
    ↓
Build Pass / Fail
```

The workflow configuration is available at:

```text
.github/workflows/test.yml
```

The CI status badge at the top of this README reflects the latest workflow status.

---

## CI Challenge & Resolution

One practical challenge encountered while integrating Selenium with GitHub Actions was that the CI runner does not provide a normal graphical browser environment.

The WebDriver configuration was therefore adapted to execute Chrome in **headless mode when running in CI**, while allowing normal browser execution locally.

Typical CI Chrome arguments include:

```text
--headless
--no-sandbox
--disable-dev-shm-usage
```

This allows the Selenium suite to execute reliably on the GitHub-hosted Linux runner.

---

## Framework Design

The framework follows separation of concerns:

```text
Test Cases
    ↓
Page Objects
    ↓
Selenium WebDriver
    ↓
Application Under Test

API Tests
    ↓
REST Assured
    ↓
Banking APIs

             ↓
        TestNG Suite
             ↓
           Maven
             ↓
      GitHub Actions CI
```

---

## What This Project Demonstrates

This project demonstrates hands-on implementation of:

**UI Automation → API Automation → Framework Design → Test Execution → Git Version Control → CI Integration**

It represents an end-to-end QA automation workflow rather than isolated Selenium test scripts.

---

## Author

**Pragya Kapil**

QA Automation Engineer | SDET | Selenium | Java | API Testing | Playwright | CI/CD
