[![ParaBank Selenium Automation Tests](https://github.com/Pragya-19/parabank-selenium-java-automation/actions/workflows/test.yml/badge.svg)](https://github.com/Pragya-19/parabank-selenium-java-automation/actions/workflows/test.yml)

# ParaBank Selenium Java Automation Framework

End-to-end banking test automation framework built using Selenium WebDriver, Java, TestNG, Maven, Page Object Model (POM), and REST API testing.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- REST Assured
- Git & GitHub
- Extent Reports

## Automated Scenarios

### UI Automation
- User login
- Account validation
- Fund transfer
- Banking workflow validation

### API Automation
- Positive API validation
- Negative API validation
- HTTP status code validation
- Response body validation
- Response time validation
- Content-Type validation

## Framework Structure

src/main/java
- ConfigReader.java

src/test/java
- api
- base
- listeners
- pages
- tests
- utils

## Framework Features

- Page Object Model for maintainable UI automation
- TestNG test execution
- Maven dependency management
- Configuration-driven test setup
- Reusable Selenium utilities
- REST API validation
- Extent reporting
- Screenshot utility
- Positive and negative test coverage

## Test Execution

Run the complete TestNG suite:

```bash
mvn clean test

Current Test Result

7 Tests Executed
7 Passed
0 Failed
0 Skipped

Application Under Test

ParaBank demo banking application.

Author

Pragya Kapil
