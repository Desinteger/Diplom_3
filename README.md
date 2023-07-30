# Project Name

Diplom_3

# Description

Educational project in which WEB testing of https://stellarburgers.nomoreparties.site/ in Google Chrome and Yandex Browser is carried out.

# Technologies

Java 11, maven 2.22.2, JUnit 4.13.2, allure 2.10.0, selenium 4.9.1, rest-assured 5.3.1

# Clean up and run tests

`mvn clean test`

# Test in Google Chrome

`mvn test -Dbrowser=chrome`

# Test in Yandex Browser

Correct the path to Yandex Browser in WebDriverFactory class (package **browsers**) in 25 line - options.setBinary("your_path");

Command to run:

`mvn test -Dbrowser=yandex`

# Allure report

`mvn allure:serve`