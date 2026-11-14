# Selenium Java Automation Framework

## Project Overview
This project is a Selenium Java Automation Framework developed to automate web application testing using industry-standard automation practices and design patterns.

The framework follows the Page Object Model (POM) design pattern to improve code reusability, maintainability, and scalability.

## Technologies Used
- **Programming Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Testing Framework:** TestNG
- **Build Management Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** Extent Reports
- **Version Control:** Git and GitHub
- **IDE:** Eclipse

## Framework Features
- Page Object Model (POM) implementation.
- Reusable methods and common utilities.
- TestNG annotations for test execution and management.
- Data-driven testing support.
- Maven-based project and dependency management.
- Automated test execution.
- HTML test execution reports using Extent Reports.
- Screenshot capture and reporting for test failures.

## Project Structure

SeleniumFrameworkDesign
│
├── src/main/java
│   └── renukakamathacademy
│       ├── pageobjects
│       ├── resources
│       └── AbstractComponents
│
├── src/test/java
│   └── renukakamathacademy
│       ├── tests
│       └── TestComponents
│
├── src/test/resources
│
├── pom.xml
└── testng.xml


## Test Scenarios
The framework covers end-to-end web application testing scenarios, including:
- User login.
- Product selection.
- Adding products to the shopping cart.
- Order placement.
- Order verification.

## Prerequisites
Make sure the following are installed:
- Java JDK
- Eclipse IDE (or any Java IDE)
- Maven
- Chrome browser
- Git

## How to Clone the Repository

git clone https://github.com/rkamath111/SeleniumFrameworkDesign.git

Navigate to the project directory:

cd SeleniumFrameworkDesign

## How to Execute Tests

Run the following Maven command:

mvn clean test

This command cleans the previous build output and executes the configured test suite.

## Reports
The framework uses Extent Reports to generate HTML test execution reports, providing details of test execution results.

## Author
GitHub: https://github.com/rkamath111

## Repository
https://github.com/rkamath111/SeleniumFrameworkDesign