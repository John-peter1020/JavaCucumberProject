# JavaCucumberProject
Java Cucumber project

Developed a simple framework which should support to develop automation test scripts for API services in Java. This project is an example of API test Exchange rates (http://api.exchangeratesapi.io) using Rest Assured and Cucumber.

Test scenarios are described in the feature file located here src/test/resources/features/ExchangeRatesTest.feature

# Tools / libraries used :

1. Java
2. Rest Assured
3. Cucumber
4. JUnit
5. Maven

# Steps to start :

1. Clone / Download the project into your local machine
2. Open the Command prompt and navigate to project location
3. Execute the following Maven command's
    - mvn clean :- To clean the maven repo
    - mvn install :- To install the maven requirments 
    - mvn test :- To execute the test scenarios
    
        After tests are run, reports are generated at : /target/cucumber-reports/index.html
