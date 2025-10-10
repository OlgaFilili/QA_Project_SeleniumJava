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
│  │  └─ java/                       # Base classes, Page Objects, utilities
│  │     └─ com/
│  │        └─ telerik/
│  │           ├─ pages/
│  │           │  ├─ dialogs/
│  │           │  │  └─ DialogsPage.java
│  │           │  ├─ grid/
│  │           │  │  └─ GridPage.java
│  │           │  └─ dropdowns/
│  │           │     └─ DropdownsPage.java
│  │           └─ utilities/
│  │              └─ Utils.java
│  └─ test/
│     └─ java/                       # TestNG test classes
│        └─ task1_2/
│        │  └─ com/telerik/
│        │     ├─ base/
│        │     │  └─ BaseTest.java
│        │     └─ tests/
│        │        ├─ task1_test.java
│        │        └─ task2_test.java
│        └─ task3/
│        │  └─ com/telerik/
│        │     ├─ base/
│        │     │  └─ BaseTest.java
│        │     └─ tests/
│        │        └─ task3_test.java
│        └─ task4_5/
│           └─ com/telerik/
│              ├─ base/
│              │  └─ BaseTest.java
│              └─ tests/
│                 ├─ task4_test.java
│                 └─ task5_test.java
├─ pom.xml                           # Maven project file with dependencies
├─ .gitignore                        # Ignored files/folders (downloads, target, etc.)
└─ README.md                         # Project documentation

## Dependencies
Selenium Java 4.25.0
TestNG 7.10.2
WebDriverManager 5.9.2
Apache POI 5.2.3 (for Excel files)
Java 16+

## Notes

BasePage contains generic page actions and driver handling.
DialogsPage represents page for task 1 and 2 and their interactions.
GridPage represents page for task 3 and it's interactions.
DropdownsPage represents page for task 4 and 5 and their interactions.
Utilities hold reusable helper methods like waits.
Tests are located under src/test/java with BaseTest for setup and initialization.
Downloads/ – temporary folder for files downloaded during tests (ignored by Git).

## Implementation Notes

1. I tried to minimize the use of JavaScript Executor, and resorted to it only for Task 5, due to the custom behavior of the Kendo MultiSelect component, which prevented standard Selenium interactions.

2. There is a single Utils.java file, as the project is relatively small. In a larger project, utility functions could be organized into multiple helper classes according to their purpose.

3. Task 3 (table verification) logic: compared the number of columns and rows (excluding Excel headers) between the exported table and the browser table, and verified one random Phone value.

4. Task 5 (multi-select dropdown) logic: first verified the sports pre-selected on page load in the dropdown list, then cleared all selections and added the desired sports. The newly selected sports were also verified.

5. Additional note: Some UI components behave non-standardly, making automation challenging. For example, certain dropdowns and autocomplete fields require custom JS events for reliable testing. Adding test-friendly attributes or hooks would significantly improve maintainability and test reliability.