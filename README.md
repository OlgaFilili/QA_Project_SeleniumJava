# QA_Project_SeleniumJava
Telerik automation QA project with Selenium & Java.

A simple automation project demonstrating Selenium WebDriver tests using Java, TestNG, and Maven.

## Prerequisites / Environment
- java 25 2025-09-16 LTS
- Intellij IDEA portable ideaIC-2025.2.3
- Windows 10 Pro
- Chrome v141

## Project Setup
1. Clone the repo:
git clone https://github.com/OlgaFilili/QA_Project_SeleniumJava.git
2. Navigate to project folder:
cd QA_Project_SeleniumJava
3. Open the project in IntelliJ IDEA and make sure Maven downloads the dependencies.

## Project Structure

QA_Project_SeleniumJava/
├─ src/
│  ├─ main/
│  │  └─ java/								# Base classes, utilities
│  │     └─ com/
│  │        └─ telerik/
│  │           ├─ pages/
│  │           │  ├─ BasePage.java
│  │           │  └─ dialogs/
│  │           │     └─ DialogsPage.java
│  │           └─ utilities/
│  │              └─ Utils.java
│  └─ test/
│     └─ java/								# TestNG test classes
│        └─ task1_2/
│           └─ com/
│              └─ telerik/
│                 ├─ base/
│                 │  └─ BaseTest.java
│                 └─ tests/
│                    └─ task1_test.java
├─ pom.xml									# Maven project file with dependencies
├── .gitignore            				    # Files/folders to ignore in Git
└─ README.md								# Project documentation

## Dependencies
Selenium Java 4.25.0
TestNG 7.10.2
WebDriverManager 5.9.2

## Notes

BasePage contains generic page actions and driver handling.
DialogsPage represents page for task 1 and 2 and their interactions.
Utilities hold reusable helper methods like waits.
Tests are located under src/test/java with BaseTest for setup and initialization.