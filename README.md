The "RetailDiscountPolicy" project is a Java-based web application that serves as an online retail system. It utilizes the Spring Boot framework for building a robust and scalable system. This project aims to provide the total cost of a customer's purchase based on customer's type such that given a bill, the net payable amount can be found.
Features
Below are the list of features and its description of each feature.

Spring Boot Framework

Description: Utilizes the Spring Boot framework for building a robust and scalable online retail system.
Dependency: org.springframework.boot, spring-boot-starter-actuator, spring-boot-starter-data-jpa, spring-boot-starter-web

RESTful Web Services
Description: Develops RESTful web services to support interactions between the front-end and back-end of the online retail system.
Dependency: spring-boot-starter-web
Testing with JUnit and RestAssured

Description: Conducts unit and integration testing using JUnit and RestAssured for ensuring code quality and reliability.
Dependencies: junit, io.rest-assured
Development and Testing Utilities

Lombok for Simplified Code
Description: Integrates Lombok to reduce boilerplate code, making the codebase cleaner and more concise.
Dependency: org.projectlombok

Installation
To install and set up the "RetailDiscountsPolicy" project, follow these steps:

Clone the project repository from GitHub.
Ensure that you have Java 17 installed.
Build the project using Maven: mvn clean install
Run the application: mvn spring-boot:run

Usage
Add products to your shopping cart.
Find total cost of the cart
