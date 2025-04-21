# Paymob_Task 🧪

## 🔧 Prerequisites

Before running this project, make sure you have the following installed on your machine:

- **Java JDK 8 or higher**
- **Maven**
- **Allure CLI** – for generating test reports  
  [Install Allure CLI](https://docs.qameta.io/allure/#_installing_a_commandline)

---

## 📦 Project Overview

This is a UI Automation Testing project developed to validate an e-commerce flow. It uses:

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Allure Reporting**
- **Page Object Model (POM)** for clean code structure
- **Data-Driven Testing (DDT)** with Excel as input source

---

## ✅ Executed Test Scenarios

1. **Account Creation** – Automates user registration using form data from Excel.
2. **Home Page Navigation** – Verifies the user reaches the homepage after login.
3. **Add to Cart Flow** – Adds two products to the shopping cart and validates the functionality.

---

## 🧠 Project Structure

Paymob_Task │ 
  ├── src │ 
    ├── main │ 
      │ ├── java │ 
        │ │ └── Pages │ 
          │ │ ├── createAccountPage.java │
          │ │ ├── homePage.java │ 
          │ │ └── pageBase.java │ 
        │ └── resources │ 
          │ └── CreateAccountData.xlsx │ 
    ├── test │ 
      └── java │ 
        ├── Paymob_Cases │ 
          │ └── TestCases.java │ 
        ├── TestBase │ 
          │ └── testBase.java │ 
        └── utiles │ 
          ├── assertionHelper.java │ 
          ├── excelReader.java │ 
          └── Screenshots.java │ 
  ├── pom.xml 
  ├── README.md 
  └── .gitignore

---


```bash
mvn clean test


---


# 📊 Generate Allure Report
- **After executing the tests:**
**Use this command in the CMD** allure serve allure-results
- **Or to generate and open manually:**
allure generate allure-results --clean -o allure-report
allure open allure-report

---


# 👤 Author

- **Created by Sayed Salah El-Din**
- **Role: QA Automation Engineer**
Always open to feedback and collaboration!


