# Tulip-Automation-TDD

## Description
This project is performs UI automation on "Tulip.com"; majorly focusing on important modules.

## How to run the project 
1. Clone the repository.
2. Make sure java, allure, maven have been installed.
	2.1 java --version
	2.2 allure --version
	2.3 mvn --version 
3. After completing the above commands use "mvn test -Dgroups=Regression -DexecutionMode=lambdaTest -D browserType=chrome -Dlt_username=your username of lambdaTest -Dlt_access_key=your access key of lambda test" to run the project
4. After running the automation "allure-results" will be generated in the project root directory; to view the results use "allure generate" to generate allure-reports.
