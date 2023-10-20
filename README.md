# FinalAutomationProject
This project aims to automate tests for a web application available at http://training.skillo-bg.com:4200/posts/all. The tests are designed to cover at least 5 different scenarios.

Prerequisites
Java Development Kit (JDK): Make sure you have Java installed. You can download it from Oracle's official website.
Apache Maven: Ensure that Maven is installed on your system. You can download Maven from the official Apache Maven website.
Google Chrome: You need Google Chrome installed as the tests will run on the Chrome browser.
ChromeDriver: Download ChromeDriver from the official website and ensure it's in your system's PATH.

Project Structure
- pom.xml
- testng.xml
- src
    - test
        - java
            - com
                - example
                    - tests
                        - TestScenario1.java
                        - TestScenario2.java
                        - TestScenario3.java
                        - TestScenario4.java
                        - TestScenario5.java

  All tests can be executed using the following command:
  mvn clean test

TestNG Configuration
The project includes a testng.xml file which specifies the test suite configuration, allowing you to control the test execution flow and parameters.

Chrome Browser Configuration
By default, tests will run on the Chrome browser. Ensure that Chrome is installed and ChromeDriver is set up properly in your system's PATH.

Capturing Screenshots on Failure
In case of a test failure, a screenshot will be captured and saved in a directory of your choice within the project. The screenshot capture logic is implemented in the test classes' @AfterMethod annotated methods.

Test Scenarios
The test scenarios should cover various aspects of the web application such as login, data input, form submission, navigation, error handling, etc. Each TestScenarioX.java file should contain a different scenario to be tested.

Feel free to add more scenarios and customize the project as per your testing requirements.

License
This project is licensed under the MIT License - see the LICENSE file for details.
